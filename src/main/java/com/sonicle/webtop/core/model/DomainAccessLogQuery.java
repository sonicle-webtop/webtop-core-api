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
package com.sonicle.webtop.core.model;

import com.sonicle.commons.qbuilders.conditions.Condition;
import com.sonicle.commons.qbuilders.properties.concrete.BooleanProperty;
import com.sonicle.commons.qbuilders.properties.concrete.DoubleProperty;
import com.sonicle.commons.qbuilders.properties.concrete.InstantProperty;
import com.sonicle.commons.qbuilders.properties.concrete.StringProperty;
import com.sonicle.commons.time.DateTimeUtils;
import com.sonicle.commons.web.json.bean.QueryObj;
import com.sonicle.webtop.core.app.sdk.QueryBuilderWithCValues;
import com.sonicle.webtop.core.app.sdk.WTUnsupportedOperationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTimeZone;

/**
 *
 * @author Federico Ballarini
 */
public class DomainAccessLogQuery extends QueryBuilderWithCValues<DomainAccessLogQuery> {
	
	public StringProperty<DomainAccessLogQuery> session() {
		return string("session");
	}
	
	public StringProperty<DomainAccessLogQuery> user() {
		return string("user");
	}
	
	public InstantProperty<DomainAccessLogQuery> dateFrom() {
		return instant("dateFrom");
	}
	
	public InstantProperty<DomainAccessLogQuery> dateTo() {
		return instant("dateTo");
	}
	
	public DoubleProperty<DomainAccessLogQuery> minDuration() {
		return doubleNum("minDuration");
	}
	
	public DoubleProperty<DomainAccessLogQuery> maxDuration() {
		return doubleNum("maxDuration");
	}
	
	public BooleanProperty<DomainAccessLogQuery> isAuthenticated() {
		return bool("authenticated");
	}
	
	public BooleanProperty<DomainAccessLogQuery> isFailure() {
		return bool("failure");
	}
	
	public StringProperty<DomainAccessLogQuery> ip() {
		return string("ip");
	}
	
	public StringProperty<DomainAccessLogQuery> any() {
		return string("any");
	}
	
	public static Condition<DomainAccessLogQuery> createCondition(QueryObj query, DateTimeZone timezone) {
		boolean smartStringComparison = true;
		
		Condition<DomainAccessLogQuery> last = new DomainAccessLogQuery().trueCondition();
		for (Map.Entry<QueryObj.Condition, List<String>> entry : query.groupConditions(Arrays.asList("is")).entrySet()) {
			final QueryObj.Condition key = entry.getKey();
			final List<String> values = entry.getValue();
			
			if (values.isEmpty() || values.size() == 1) {
				last = new DomainAccessLogQuery().and(last, createCondition(key, values.isEmpty() ? null : values.get(0), timezone, smartStringComparison));
			} else {
				List<Condition<DomainAccessLogQuery>> conds = new ArrayList<>();
				for (String value : entry.getValue()) {
					conds.add(createCondition(key, value, timezone, smartStringComparison));
				}
				last = new DomainAccessLogQuery().and(last, new DomainAccessLogQuery().or(conds));
			}
		}
		
		if (!StringUtils.isBlank(query.getAllText())) {
			return new DomainAccessLogQuery().and(last, new DomainAccessLogQuery().any().eq(asStringValue(query.getAllText(), smartStringComparison)));
		} else {
			return last;
		}
	}
	
	private static Condition<DomainAccessLogQuery> createCondition(QueryObj.Condition condition, String value, DateTimeZone timezone, boolean smartStringComparison) {
		if ("session".equals(condition.keyword)) {
			return new DomainAccessLogQuery().session().eq(asStringValue(value, smartStringComparison));

		} else if ("user".equals(condition.keyword)) {
			return new DomainAccessLogQuery().user().eq(asStringValue(value, smartStringComparison));

		} else if ("dateFrom".equals(condition.keyword)) {
			String dateFrom = StringUtils.replace(value, "/", "-");
			return new DomainAccessLogQuery().dateFrom().eq(DateTimeUtils.toInstant(DateTimeUtils.parseLocalDate(dateFrom), DateTimeUtils.toZoneId(timezone)));

		} else if ("dateTo".equals(condition.keyword)) {
			String dateTo = StringUtils.replace(value, "/", "-");
			return new DomainAccessLogQuery().dateTo().eq(DateTimeUtils.toInstant(DateTimeUtils.parseLocalDate(dateTo), DateTimeUtils.toZoneId(timezone)));

		} else if ("minDuration".equals(condition.keyword)) {
			return new DomainAccessLogQuery().minDuration().eq(Double.parseDouble(value));

		} else if ("maxDuration".equals(condition.keyword)) {
			return new DomainAccessLogQuery().maxDuration().eq(Double.parseDouble(value));

		} else if ("ip".equals(condition.keyword)) {
			return new DomainAccessLogQuery().ip().eq(asStringValue(value, smartStringComparison));

		} else if ("authenticated".equals(condition.keyword)) {
			return condition.negated ? new DomainAccessLogQuery().isAuthenticated().isFalse() : new DomainAccessLogQuery().isAuthenticated().isTrue();

		} else if ("failure".equals(condition.keyword)) {
			return condition.negated ? new DomainAccessLogQuery().isFailure().isFalse() : new DomainAccessLogQuery().isFailure().isTrue();
		}
		
		throw new WTUnsupportedOperationException("Unsupported keyword '{}'", condition.keyword);
	}
}
