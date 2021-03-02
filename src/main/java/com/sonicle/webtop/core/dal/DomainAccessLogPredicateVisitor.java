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
package com.sonicle.webtop.core.dal;

import com.sonicle.commons.qbuilders.nodes.ComparisonNode;
import com.sonicle.commons.qbuilders.operators.ComparisonOperator;
import com.sonicle.webtop.core.app.sdk.JOOQPredicateVisitor;
import static com.sonicle.webtop.core.jooq.core.Tables.VW_AUTH_DETAILS;
import java.util.Collection;
import org.joda.time.DateTime;
import org.jooq.Condition;

/**
 *
 * @author Federico Ballarini
 */
public class DomainAccessLogPredicateVisitor extends JOOQPredicateVisitor {
	protected DateTime fromRange = null;
	protected DateTime toRange = null;
	protected Double minDuration = null;
	protected Double maxDuration = null;
	
	public DomainAccessLogPredicateVisitor() {
		super();
	}
	
	@Override
	protected Condition toCondition(String fieldName, ComparisonOperator operator, Collection<?> values, ComparisonNode node) {
		if ("session".equals(fieldName)) {
			String singleAsString = valueToLikePattern(singleAsString(values));
			return VW_AUTH_DETAILS.SESSION_ID.likeIgnoreCase(singleAsString);
			
		} else if ("user".equals(fieldName)) {
			String singleAsString = valueToLikePattern(singleAsString(values));
			return VW_AUTH_DETAILS.USER_ID.likeIgnoreCase(singleAsString);
			
		} else if ("ip".equals(fieldName)) {
			String singleAsString = valueToLikePattern(singleAsString(values));
			return VW_AUTH_DETAILS.DATA.like(singleAsString);
			
		} else if ("dateFrom".equals(fieldName)) {
			fromRange = (DateTime)single(values);
			return VW_AUTH_DETAILS.DATE.greaterOrEqual(fromRange);
			
		} else if ("dateTo".equals(fieldName)) {
			toRange = (DateTime)single(values);
			if (toRange != null) toRange = toRange.plusDays(1);
			return VW_AUTH_DETAILS.DATE.lessThan(toRange);
			
		} else if ("minDuration".equals(fieldName)) {
			minDuration = (Double)single(values);
			return VW_AUTH_DETAILS.MINUTES.greaterOrEqual(minDuration);
			
		} else if ("maxDuration".equals(fieldName)) {
			maxDuration = (Double)single(values);
			return VW_AUTH_DETAILS.MINUTES.lessOrEqual(maxDuration);
			
		} else if ("authenticated".equals(fieldName)) {
			return defaultCondition(VW_AUTH_DETAILS.AUTHENTICATED, operator, values);
			
		} else if ("failure".equals(fieldName)) {
			return defaultCondition(VW_AUTH_DETAILS.FAILURE, operator, values);
			
		} else if ("any".equals(fieldName)) {
			String singleAsString = valueToLikePattern(singleAsString(values));
			return VW_AUTH_DETAILS.SESSION_ID.likeIgnoreCase(singleAsString)
				.or(VW_AUTH_DETAILS.USER_ID.likeIgnoreCase(singleAsString));
			
		}  else {
			throw new UnsupportedOperationException("Field not supported: " + fieldName);
		}
	}
}
