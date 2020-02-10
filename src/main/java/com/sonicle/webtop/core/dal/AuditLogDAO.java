/*
 * webtop-core-db is a library developed by Sonicle S.r.l.
 * Copyright (C) 2014 Sonicle S.r.l.
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
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program; if not, see http://www.gnu.org/licenses or write to
 * the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301 USA.
 *
 * You can contact Sonicle S.r.l. at email address sonicle@sonicle.com
 *
 * The interactive user interfaces in modified source and object code versions
 * of this program must display Appropriate Legal Notices, as required under
 * Section 5 of the GNU Affero General Public License version 3.
 *
 * In accordance with Section 7(b) of the GNU Affero General Public License
 * version 3, these Appropriate Legal Notices must retain the display of the
 * Sonicle logo and Sonicle copyright notice. If the display of the logo is not
 * reasonably feasible for technical reasons, the Appropriate Legal Notices must
 * display the words "Copyright (C) 2014 Sonicle S.r.l.".
 */
package com.sonicle.webtop.core.dal;

import com.sonicle.webtop.core.bol.OAuditLog;
import com.sonicle.webtop.core.jooq.core.Sequences;
import static com.sonicle.webtop.core.jooq.core.Tables.AUDIT_LOG;
import com.sonicle.webtop.core.jooq.core.tables.records.AuditLogRecord;
import java.sql.Connection;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.jooq.DSLContext;

/**
 *
 * @author malbinola
 */
public class AuditLogDAO extends BaseDAO {
	private final static AuditLogDAO INSTANCE = new AuditLogDAO();

	public static AuditLogDAO getInstance() {
		return INSTANCE;
	}

	public Long getSequence(Connection con) throws DAOException {
		DSLContext dsl = getDSL(con);
		Long nextID = dsl.nextval(Sequences.SEQ_AUDIT_LOG);
		return nextID;
	}
	
	public int insert(Connection con, OAuditLog item) throws DAOException {
		DSLContext dsl = getDSL(con);
		AuditLogRecord record = dsl.newRecord(AUDIT_LOG, item);
		return dsl
			.insertInto(AUDIT_LOG)
			.set(record)
			.execute();
	}
	
	public int deleteByAge(Connection con, int days) throws DAOException {
		DateTime boundaryDate = DateTime.now(DateTimeZone.UTC).withTimeAtStartOfDay().minusDays(days);
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(AUDIT_LOG)
			.where(
				AUDIT_LOG.TIMESTAMP.lessThan(boundaryDate)
			)
			.execute();
	}
	
	public int deleteByDomain(Connection con, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(AUDIT_LOG)
			.where(
				AUDIT_LOG.DOMAIN_ID.equal(domainId)
			)
			.execute();
	}
}