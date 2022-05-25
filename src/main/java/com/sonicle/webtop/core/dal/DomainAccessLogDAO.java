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

import com.sonicle.commons.beans.SortInfo;
import com.sonicle.webtop.core.bol.VDomainAccessLog;
import com.sonicle.webtop.core.bol.ODomainAccessLogDetail;
import com.sonicle.webtop.core.jooq.core.Routines;
import com.sonicle.webtop.core.jooq.core.Tables;
import static com.sonicle.webtop.core.jooq.core.Tables.ACCESS_LOG;
import static com.sonicle.webtop.core.jooq.core.Tables.FN_ACCESS_LOG_AGGR;
import java.sql.Connection;
import java.util.List;
import org.joda.time.DateTime;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.SelectConditionStep;
import org.jooq.SortField;
import org.jooq.impl.DSL;

/**
 *
 * @author Federico Ballarini
 */
public class DomainAccessLogDAO extends BaseDAO {
	private final static DomainAccessLogDAO INSTANCE = new DomainAccessLogDAO();
	
	public static DomainAccessLogDAO getInstance() {
		return INSTANCE;
	}
	
	public SortField<?> toFnAccessLogAggrSortField(SortInfo sortInfo) {
		Field<?> field = null;
		switch (sortInfo.getField()) {
			case "sessionId":
				field = FN_ACCESS_LOG_AGGR.SESSION_ID;
				break;
			case "userId":
				field = FN_ACCESS_LOG_AGGR.USER_ID;
				break;
			case "timestamp":
				field = FN_ACCESS_LOG_AGGR.TIMESTAMP;
				break;
			case "duration":
				field = FN_ACCESS_LOG_AGGR.DURATION;
				break;
			case "authenticated":
				field = FN_ACCESS_LOG_AGGR.AUTHENTICATED;
				break;
			case "loginErrors":
				field = FN_ACCESS_LOG_AGGR.LOGIN_ERRORS;
				break;
		}
		
		if (field != null) {
			if (sortInfo.isAscending()) {
				return field.asc();
			} else {
				return field.desc();
			}
		} else {
			return null;
		}
	}
	
	public int countByDomainCondition(Connection con, String domainId, DateTime from, DateTime to, Condition condition) {
		DSLContext dsl = getDSL(con);
		return dsl
			.selectCount()
			.from(Routines.fnAccessLogAggr(domainId, from, to))
			.where(condition)
			.fetchOneInto(int.class);
	}
	
	public List<VDomainAccessLog> selectByDomainCondition(Connection con, String domainId, DateTime from, DateTime to, Condition condition, SortInfo sortInfo, int limit, int offset) {
		DSLContext dsl = getDSL(con);
		Condition filterCondition = (condition != null) ? condition : DSL.trueCondition();
		SortField<?> sortField = toFnAccessLogAggrSortField(sortInfo);
		
		SelectConditionStep step = dsl
			.select()
			.from(Tables.FN_ACCESS_LOG_AGGR(domainId, from, to))
			.where(filterCondition);
		
		if (sortField != null) {
			return step
				.orderBy(sortField)
				.limit(limit)
				.offset(offset)
				.fetchInto(VDomainAccessLog.class);
		} else {
			return step
				.limit(limit)
				.offset(offset)
				.fetchInto(VDomainAccessLog.class);
		}
	}
	
	public Integer countDetailBySessionId(Connection con, String sessionId, String domainId, String userId) throws DAOException {
		DSLContext dsl = getDSL(con);
		
		return dsl
			.selectCount()
			.from(ACCESS_LOG)
			.where(
				ACCESS_LOG.SESSION_ID.equal(sessionId),
				ACCESS_LOG.DOMAIN_ID.equal(domainId),
				ACCESS_LOG.USER_ID.equal(userId),
				ACCESS_LOG.CONTEXT.equal("AUTH")
			)
			.fetchOne(0, Integer.class);
	}
	
	public List<ODomainAccessLogDetail> getDetailBySessionId(Connection con, String sessionId, String domainId, String userId) {
		DSLContext dsl = getDSL(con);
		
		return dsl
			.select(
				ACCESS_LOG.TIMESTAMP,
				ACCESS_LOG.ACTION,
				ACCESS_LOG.DATA
			)
			.from(ACCESS_LOG)
			.where(
				ACCESS_LOG.SESSION_ID.equal(sessionId),
				ACCESS_LOG.DOMAIN_ID.equal(domainId),
				ACCESS_LOG.USER_ID.equal(userId),
				ACCESS_LOG.CONTEXT.equal("AUTH")
			)
			.orderBy(ACCESS_LOG.TIMESTAMP)
			.fetchInto(ODomainAccessLogDetail.class);
	}
}
