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
import static com.sonicle.webtop.core.jooq.core.Tables.CUSTOM_FIELDS;
import static com.sonicle.webtop.core.jooq.core.Tables.CUSTOM_PANELS_FIELDS;
import static com.sonicle.webtop.core.jooq.core.Tables.CUSTOM_PANELS_TAGS;
import com.sonicle.webtop.core.jooq.core.tables.CustomFields;
import com.sonicle.webtop.core.jooq.core.tables.CustomPanelsFields;
import com.sonicle.webtop.core.jooq.core.tables.CustomPanelsTags;
import java.util.Arrays;
import java.util.Collection;
import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.TableLike;
import static org.jooq.impl.DSL.exists;
import static org.jooq.impl.DSL.selectOne;

/**
 *
 * @author malbinola
 */
public abstract class JOOQPredicateVisitorWithCValues extends JOOQPredicateVisitor {
	protected final boolean negatedEqualityIsStrict;
	
	public JOOQPredicateVisitorWithCValues(boolean negatedEqualityIsStrict) {
		this.negatedEqualityIsStrict = negatedEqualityIsStrict;
	}
	
	abstract protected Field<?> getFieldEntityIdOfEntityTable();
	abstract protected TableLike<?> getTableTags();
	abstract protected Field<String> getFieldTagIdOfTableTags();
	abstract protected Condition getConditionTagsForCurrentEntity();
	abstract protected TableLike<?> getTableCustomValues();
	abstract protected Condition getConditionCustomValuesForCurrentEntityAndField(final String fieldId);
	abstract protected Condition getConditionCustomValuesForFieldValue(final QueryBuilderWithCValues.Type cvalueType, final ComparisonOperator operator, final Collection<?> values);
	
	protected Condition generateCValueCondition(final CompId fieldName, final ComparisonOperator operator, final Collection<?> values) {
		String tk0 = fieldName.getToken(0); // -> field type
		String tk1 = fieldName.getToken(1); // -> field id
		QueryBuilderWithCValues.Type cvalueType = EnumUtils.getEnum(QueryBuilderWithCValues.Type.class, tk0);
		
		CustomFields PV_CUSTOM_FIELDS = CUSTOM_FIELDS.as("pvis_cf");
		CustomPanelsFields PV_CUSTOM_PANELS_FIELDS = CUSTOM_PANELS_FIELDS.as("pvis_cpf");
		CustomPanelsTags PV_CUSTOM_PANELS_TAGS = CUSTOM_PANELS_TAGS.as("pvis_cpt");
		
		Condition cfieldExistenceCond = exists(
				selectOne()
				.from(PV_CUSTOM_FIELDS)
				.join(PV_CUSTOM_PANELS_FIELDS).on(PV_CUSTOM_FIELDS.CUSTOM_FIELD_ID.eq(PV_CUSTOM_PANELS_FIELDS.CUSTOM_FIELD_ID))
				.join(PV_CUSTOM_PANELS_TAGS).on(PV_CUSTOM_PANELS_FIELDS.CUSTOM_PANEL_ID.eq(PV_CUSTOM_PANELS_TAGS.CUSTOM_PANEL_ID))
				.join(getTableTags()).on(PV_CUSTOM_PANELS_TAGS.TAG_ID.eq(getFieldTagIdOfTableTags()))
				.where(
					PV_CUSTOM_FIELDS.CUSTOM_FIELD_ID.eq(tk1)
					.and(getConditionTagsForCurrentEntity())
				)
			);
		
		boolean valueNotExists = false; // True if returned condition must be treated as negated (not exist).
		Condition cvalueCond = null;
		if (!negatedEqualityIsStrict) {
			
			// Boolean values needs to be adjusted in order to give correct results:
			// Operators and boolean values can be combined in four ways:
			//   |original|  |adjusted                 |
			//   |op|value|  |op|value|negate-condition|
			// 1) EQ true  -> EQ true  no
			// 2) EQ false -> EQ true  yes
			// 3) NE true  -> EQ true  yes (already excluded by query logic)
			// 4) NE false -> EQ true  no (already excluded by query logic)
			
			if (QueryBuilderWithCValues.Type.CVBOOL.equals(cvalueType)) {
				valueNotExists = (false == singleAsBoolean(values));
				cvalueCond = getConditionCustomValuesForFieldValue(cvalueType, ComparisonOperator.EQ, Arrays.asList(true));
				
			} else {
				ComparisonOperator sop = toStraightOperator(operator);
				valueNotExists = !operator.equals(sop);
				cvalueCond = getConditionCustomValuesForFieldValue(cvalueType, sop, values);
			}
		} else {
			cvalueCond = getConditionCustomValuesForFieldValue(cvalueType, operator, values);
		}
		if (cvalueCond == null) throw new UnsupportedOperationException("Custom value not supported: " + tk0);
		
		if (valueNotExists) {
			return cfieldExistenceCond
					.andNotExists(
						selectOne()
						.from(getTableCustomValues())
						.where(
							getConditionCustomValuesForCurrentEntityAndField(tk1)
							.and(cvalueCond)
						)
					);

		} else {
			return cfieldExistenceCond
					.andExists(
						selectOne()
						.from(getTableCustomValues())
						.where(
							getConditionCustomValuesForCurrentEntityAndField(tk1)
							.and(cvalueCond)
						)
			);
		}
	}
	
	protected ComparisonOperator toStraightOperator(ComparisonOperator operator) {
		if (ComparisonOperator.NE.equals(operator)) {
			return ComparisonOperator.EQ;
		} else if (ComparisonOperator.NIN.equals(operator)) {
			return ComparisonOperator.IN;
		}
		return operator;
	}
}
