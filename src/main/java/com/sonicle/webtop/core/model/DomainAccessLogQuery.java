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
import java.util.Collection;
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
	
	public StringProperty<DomainAccessLogQuery> any() {
		return string("any");
	}
	
	public static Condition<DomainAccessLogQuery> toCondition(String pattern) {
		if (!StringUtils.isBlank(pattern)) {
			return new DomainAccessLogQuery().any().eq(StringUtils.replace(pattern, "%", "*"));
		} else {
			return null;
		}
	}
	
	public static Condition<DomainAccessLogQuery> toCondition(QueryObj query, DateTimeZone timezone) {
		boolean smartStringComparison = true;
		DomainAccessLogQuery q = new DomainAccessLogQuery();
		
		Condition<DomainAccessLogQuery> last = q.trueCondition();
		for (Map.Entry<String, Collection<QueryObj.Condition>> entry : query.getConditionsMap().entrySet()) {
			q = last.and();
			int pos = 0;
			for (QueryObj.Condition queryCondition : entry.getValue()) {
				pos++;
				if (pos > 1) q = last.or();
				
				if ("session".equals(queryCondition.keyword)) {
					last = q.session().eq(asStringValue(queryCondition.value, smartStringComparison));
					
				} else if ("user".equals(queryCondition.keyword)) {
					last = q.user().eq(asStringValue(queryCondition.value, smartStringComparison));
					
				} else if ("dateFrom".equals(queryCondition.keyword)) {
					String dateFrom = StringUtils.replace(queryCondition.value, "/", "-");
					last = q.dateFrom().eq(DateTimeUtils.toInstant(DateTimeUtils.parseLocalDate(dateFrom), DateTimeUtils.toZoneId(timezone)));
					
				} else if ("dateTo".equals(queryCondition.keyword)) {
					String dateTo = StringUtils.replace(queryCondition.value, "/", "-");
					last = q.dateTo().eq(DateTimeUtils.toInstant(DateTimeUtils.parseLocalDate(dateTo), DateTimeUtils.toZoneId(timezone)));
					
				} else if ("minDuration".equals(queryCondition.keyword)) {
					last = q.minDuration().eq(Double.parseDouble(queryCondition.value));
					
				} else if ("maxDuration".equals(queryCondition.keyword)) {
					last = q.maxDuration().eq(Double.parseDouble(queryCondition.value));
					
				} else if ("is".equals(queryCondition.keyword)) {
					switch (queryCondition.value) {
						case "authenticated":
							last = q.isAuthenticated().isTrue();
							break;
						case "failure":
							last = q.isFailure().isTrue();
							break;
						default:
							throw new UnsupportedOperationException(queryCondition.keyword + ":" + queryCondition.value);
					}
					
				} else {
					throw new WTUnsupportedOperationException("Unsupported keyword '{}'", queryCondition.keyword);
				}
			}
		}
		
		if (!StringUtils.isBlank(query.allText)) {
			return last.and().any().eq(asStringValue(query.allText, smartStringComparison));
		} else {
			return last;
		}
	}
}
