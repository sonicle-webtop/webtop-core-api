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

import com.sonicle.webtop.core.bol.ODomainAccessLog;
import com.sonicle.webtop.core.bol.ODomainAccessLogDetail;
import static com.sonicle.webtop.core.jooq.core.Tables.AUDIT_LOG;
import static com.sonicle.webtop.core.jooq.core.Tables.VW_AUTH_DETAILS;
import java.sql.Connection;
import java.util.List;
import org.jooq.Condition;
import org.jooq.DSLContext;
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
	
	public Integer countByDomainIdCondition(Connection con, String domainId, Condition condition) throws DAOException {
		DSLContext dsl = getDSL(con);
		Condition filterCondition = (condition != null) ? condition : DSL.trueCondition();
		
		return dsl
			.selectCount()
			.from(VW_AUTH_DETAILS)
			.where(
				VW_AUTH_DETAILS.DOMAIN_ID.equal(domainId)
				.and(filterCondition)
			)
			.fetchOne(0, Integer.class);
	}
	
	public List<ODomainAccessLog> getByDomainIdCondition(Connection con, String domainId, SortField<?> orderBy, Integer limit, Integer offset, Condition condition) {
		DSLContext dsl = getDSL(con);
		Condition filterCondition = (condition != null) ? condition : DSL.trueCondition();
		
		return dsl
			.select(
				VW_AUTH_DETAILS.SESSION_ID,
				VW_AUTH_DETAILS.USER_ID,
				VW_AUTH_DETAILS.DATE,
				VW_AUTH_DETAILS.MINUTES,
				VW_AUTH_DETAILS.AUTHENTICATED,
				VW_AUTH_DETAILS.FAILURE,
				VW_AUTH_DETAILS.LOGIN_ERRORS
			)
			.from(VW_AUTH_DETAILS)
			.where(
				VW_AUTH_DETAILS.DOMAIN_ID.equal(domainId)
				.and(filterCondition)
			)
			.orderBy(orderBy)
			.limit(limit)
			.offset(offset)
			.fetchInto(ODomainAccessLog.class);
	}
	
	public Integer countDetailBySessionId(Connection con, String sessionId, String domainId, String userId) throws DAOException {
		DSLContext dsl = getDSL(con);
		
		return dsl
			.selectCount()
			.from(AUDIT_LOG)
			.where(
				AUDIT_LOG.SESSION_ID.equal(sessionId),
				AUDIT_LOG.DOMAIN_ID.equal(domainId),
				AUDIT_LOG.USER_ID.equal(userId),
				AUDIT_LOG.CONTEXT.equal("AUTH")
			)
			.fetchOne(0, Integer.class);
	}
	
	public List<ODomainAccessLogDetail> getDetailBySessionId(Connection con, String sessionId, String domainId, String userId) {
		DSLContext dsl = getDSL(con);
		
		return dsl
			.select(
				AUDIT_LOG.TIMESTAMP,
				AUDIT_LOG.ACTION,
				AUDIT_LOG.DATA
			)
			.from(AUDIT_LOG)
			.where(
				AUDIT_LOG.SESSION_ID.equal(sessionId),
				AUDIT_LOG.DOMAIN_ID.equal(domainId),
				AUDIT_LOG.USER_ID.equal(userId),
				AUDIT_LOG.CONTEXT.equal("AUTH")
			)
			.orderBy(AUDIT_LOG.TIMESTAMP)
			.fetchInto(ODomainAccessLogDetail.class);
	}
}
