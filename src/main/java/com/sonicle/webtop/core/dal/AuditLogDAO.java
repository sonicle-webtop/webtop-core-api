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

import com.sonicle.webtop.core.app.sdk.AuditReferenceDataEntry;
import com.sonicle.webtop.core.bol.OAccessLog;
import com.sonicle.webtop.core.bol.OAuditLog;
import static com.sonicle.webtop.core.jooq.core.Tables.ACCESS_LOG;
import static com.sonicle.webtop.core.jooq.core.Tables.AUDIT_LOG;
import java.sql.Connection;
import java.util.Collection;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.jooq.BatchBindStep;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.tools.StringUtils;

/**
 *
 * @author malbinola
 */
public class AuditLogDAO extends BaseDAO {
	private final static AuditLogDAO INSTANCE = new AuditLogDAO();

	public static AuditLogDAO getInstance() {
		return INSTANCE;
	}
	
	public int insert(Connection con, OAuditLog item) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.insertInto(AUDIT_LOG)
			.set(AUDIT_LOG.TIMESTAMP, item.getTimestamp())
			.set(AUDIT_LOG.DOMAIN_ID, item.getDomainId())
			.set(AUDIT_LOG.USER_ID, item.getUserId())
			.set(AUDIT_LOG.REFERENCE_ID, item.getReferenceId())
			.set(AUDIT_LOG.SOFTWARE_NAME, item.getSoftwareName())
			.set(AUDIT_LOG.SERVICE_ID, item.getServiceId())
			.set(AUDIT_LOG.CONTEXT, item.getContext())
			.set(AUDIT_LOG.ACTION, item.getAction())
			.set(AUDIT_LOG.SESSION_ID, item.getSessionId())
			.set(AUDIT_LOG.DATA, item.getData())
			.execute();
	}
	
	public int[] batchInsert(Connection con, OAuditLog baseItem, Collection<AuditReferenceDataEntry> entries) throws DAOException {
		if (entries.isEmpty()) return new int[0];
		DSLContext dsl = getDSL(con);
		BatchBindStep batch = dsl.batch(
			dsl.insertInto(AUDIT_LOG, 
				AUDIT_LOG.TIMESTAMP, AUDIT_LOG.DOMAIN_ID, AUDIT_LOG.USER_ID, AUDIT_LOG.SOFTWARE_NAME, AUDIT_LOG.SESSION_ID,
				AUDIT_LOG.SERVICE_ID, AUDIT_LOG.CONTEXT, AUDIT_LOG.ACTION, AUDIT_LOG.REFERENCE_ID, AUDIT_LOG.DATA)
				.values((DateTime)null, null, null, null, null, null, null, null, null, null)
		);
		for (AuditReferenceDataEntry entry : entries) {
			batch.bind(
				baseItem.getTimestamp(),
				baseItem.getDomainId(),
				baseItem.getUserId(),
				baseItem.getSoftwareName(),
				baseItem.getSessionId(),
				baseItem.getServiceId(),
				baseItem.getContext(),
				baseItem.getAction(),
				entry.getReference(),
				entry.getData()
			);
		}
		return batch.execute();
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
	
	public List<OAuditLog> selectByReferenceId(Connection con, String domainId, String serviceId, String context, String action, String referenceId) throws DAOException {
		DSLContext dsl = getDSL(con);
		Condition whereCondition = AUDIT_LOG.DOMAIN_ID.equal(domainId)
			.and(AUDIT_LOG.SERVICE_ID.equal(serviceId))
			.and(AUDIT_LOG.CONTEXT.equal(context))
			.and(AUDIT_LOG.REFERENCE_ID.equal(referenceId));
		
		if (!StringUtils.isEmpty(action)) {
			whereCondition = whereCondition
				.and(AUDIT_LOG.ACTION.equal(action));
		}
		
		return dsl
			.select()
			.from(AUDIT_LOG)
			.where(whereCondition)
			.orderBy(
				AUDIT_LOG.TIMESTAMP.asc()
			)
			.fetchInto(OAuditLog.class);
	}
	
	public int updateReferences(Connection con, String domainId, String serviceId, String context, String oldReference, String newReference) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.update(AUDIT_LOG)
			.set(AUDIT_LOG.REFERENCE_ID, newReference)
			.where(
				AUDIT_LOG.REFERENCE_ID.eq(oldReference)
			)
			.execute();
	}
	
	public int insertAccess(Connection con, OAccessLog item) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.insertInto(ACCESS_LOG)
			.set(ACCESS_LOG.TIMESTAMP, item.getTimestamp())
			.set(ACCESS_LOG.DOMAIN_ID, item.getDomainId())
			.set(ACCESS_LOG.USER_ID, item.getUserId())
			.set(ACCESS_LOG.SOFTWARE_NAME, item.getSoftwareName())
			.set(ACCESS_LOG.SESSION_ID, item.getSessionId())
			.set(ACCESS_LOG.SERVICE_ID, item.getServiceId())
			.set(ACCESS_LOG.CONTEXT, item.getContext())
			.set(ACCESS_LOG.ACTION, item.getAction())
			.set(ACCESS_LOG.REFERENCE_ID, item.getReferenceId())
			.set(ACCESS_LOG.DATA, item.getData())
			.execute();
	}
	
	public int[] batchInsertAccess(Connection con, OAccessLog baseItem, Collection<AuditReferenceDataEntry> entries) throws DAOException {
		if (entries.isEmpty()) return new int[0];
		DSLContext dsl = getDSL(con);
		BatchBindStep batch = dsl.batch(
			dsl.insertInto(ACCESS_LOG, 
				ACCESS_LOG.TIMESTAMP, ACCESS_LOG.DOMAIN_ID, ACCESS_LOG.USER_ID, ACCESS_LOG.SOFTWARE_NAME, ACCESS_LOG.SESSION_ID,  
				ACCESS_LOG.SERVICE_ID, ACCESS_LOG.CONTEXT, ACCESS_LOG.ACTION, ACCESS_LOG.REFERENCE_ID, ACCESS_LOG.DATA)
				.values((DateTime)null, null, null, null, null, null, null, null, null, null)
		);
		for (AuditReferenceDataEntry entry : entries) {
			batch.bind(
				baseItem.getTimestamp(),
				baseItem.getDomainId(),
				baseItem.getUserId(),
				baseItem.getSoftwareName(),
				baseItem.getSessionId(),
				baseItem.getServiceId(),
				baseItem.getContext(),
				baseItem.getAction(),
				entry.getReference(),
				entry.getData()
			);
		}
		return batch.execute();
	}
	
	public int deleteAccessByDomain(Connection con, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(ACCESS_LOG)
			.where(
				ACCESS_LOG.DOMAIN_ID.equal(domainId)
			)
			.execute();
	}
}
