/*
 * Copyright (C) 2020 Sonicle S.r.l.
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Affero General Public License version 3 as published by
 * the Free Software Foundation with the addition of the following permission
 * added to Section 15 as permitted in Section 7(a): FOR ANY PART OF THE COVERED
 * WORK IN WHICH THE COPYRIGHT IS OWNED BY SONICLE, SONICLE DISCLAIMS THE
 * WARRANTY OF NON INFRINGEMENT OF THIRD PARTY RIGHTS.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program; if not, see http://www.gnu.org/licenses or write to
 * the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301 USA.
 *
 * You can contact Sonicle S.r.l. at email address sonicle[at]sonicle[dot]com
 *
 * The interactive user interfaces in modified source and object code versions
 * of this program must display Appropriate Legal Notices, as required under
 * Section 5 of the GNU Affero General Public License version 3.
 *
 * In accordance with Section 7(b) of the GNU Affero General Public License
 * version 3, these Appropriate Legal Notices must retain the display of the
 * Sonicle logo and Sonicle copyright notice. If the display of the logo is not
 * reasonably feasible for technical reasons, the Appropriate Legal Notices must
 * display the words "Copyright (C) 2020 Sonicle S.r.l.".
 */
package com.sonicle.webtop.core.app.sdk;

import com.github.rutledgepaulv.qbuilders.operators.ComparisonOperator;
import com.sonicle.commons.EnumUtils;
import com.sonicle.commons.web.json.CompId;
import java.util.Arrays;
import java.util.Collection;
import org.jooq.Condition;

/**
 *
 * @author malbinola
 */
public abstract class JOOQPredicateVisitorWithCValues extends JOOQPredicateVisitor {
	protected final boolean negatedEqualityIsStrict;
	
	public JOOQPredicateVisitorWithCValues(boolean negatedEqualityIsStrict) {
		this.negatedEqualityIsStrict = negatedEqualityIsStrict;
	}
	
	abstract protected Condition cvalueCondition(QBuilderWithCValues.Type cvalueType, ComparisonOperator operator, Collection<?> values);
	
	protected CValueCondition getCustomFieldCondition(final CompId fieldName, final ComparisonOperator operator, final Collection<?> values) {
		String tk0 = fieldName.getToken(0);
		QBuilderWithCValues.Type cvalueType = EnumUtils.getEnum(QBuilderWithCValues.Type.class, tk0);
		boolean negatedCond = false; // True if returned condition must be treated as negated (not exist).
		Condition cond = null;
		if (!negatedEqualityIsStrict) {
			
			// Boolean values needs to be adjusted in order to give correct results:
			// Operators and boolean values can be combined in four ways:
			//   |original|  |adjusted                 |
			//   |op|value|  |op|value|negate-condition|
			// 1) EQ true  -> EQ true  no
			// 2) EQ false -> EQ true  yes
			// 3) NE true  -> EQ true  yes (already excluded by query logic)
			// 4) NE false -> EQ true  no (already excluded by query logic)
			
			if (QBuilderWithCValues.Type.CVBOOL.equals(cvalueType)) {
				negatedCond = (false == singleAsBoolean(values));
				cond = cvalueCondition(cvalueType, ComparisonOperator.EQ, Arrays.asList(true));
				
			} else {
				ComparisonOperator sop = toStraightOperator(operator);
				negatedCond = !operator.equals(sop);
				cond = cvalueCondition(cvalueType, sop, values);
			}
		} else {
			cond = cvalueCondition(cvalueType, operator, values);
		}
		
		if (cond == null) throw new UnsupportedOperationException("Custom value not supported: " + tk0);
		return new CValueCondition(negatedCond, cond);
	}
	
	protected ComparisonOperator toStraightOperator(ComparisonOperator operator) {
		if (ComparisonOperator.NE.equals(operator)) {
			return ComparisonOperator.EQ;
		} else if (ComparisonOperator.NIN.equals(operator)) {
			return ComparisonOperator.IN;
		}
		return operator;
	}
	
	public static class CValueCondition {
		public final boolean negated;
		public final Condition condition;
		
		public CValueCondition(boolean negated, Condition condition) {
			this.negated = negated;
			this.condition = condition;
		}
	}
}
