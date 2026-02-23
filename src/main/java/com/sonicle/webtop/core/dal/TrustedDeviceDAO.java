/*
 * Copyright (C) 2026 Sonicle S.r.l.
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
 * display the words "Copyright (C) 2026 Sonicle S.r.l.".
 */
package com.sonicle.webtop.core.dal;

import com.sonicle.webtop.core.bol.OTrustedDevice;
import static com.sonicle.webtop.core.jooq.core.Sequences.SEQ_TRUSTED_DEVICES;
import static com.sonicle.webtop.core.jooq.core.tables.TrustedDevices.TRUSTED_DEVICES;
import com.sonicle.webtop.core.jooq.core.tables.records.TrustedDevicesRecord;
import java.sql.Connection;
import org.joda.time.DateTime;
import org.jooq.DSLContext;

/**
 *
 * @author malbinola
 */
public class TrustedDeviceDAO extends BaseDAO {
	private final static TrustedDeviceDAO INSTANCE = new TrustedDeviceDAO();
	public static TrustedDeviceDAO getInstance() {
		return INSTANCE;
	}
	
	public Long getSequence(Connection con) throws DAOException {
		DSLContext dsl = getDSL(con);
		Long nextID = dsl.nextval(SEQ_TRUSTED_DEVICES);
		return nextID;
	}
	
	public OTrustedDevice selectByToken(Connection con, String token) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
				TRUSTED_DEVICES.TRUSTED_DEVICE_ID,
				TRUSTED_DEVICES.CREATION_TIMESTAMP,
				TRUSTED_DEVICES.REVISION_TIMESTAMP,
				TRUSTED_DEVICES.DOMAIN_ID,
				TRUSTED_DEVICES.USER_ID,
				TRUSTED_DEVICES.TOKEN,
				TRUSTED_DEVICES.CLIENT_IDENTIFIER,
				TRUSTED_DEVICES.EXPIRES_AT,
				TRUSTED_DEVICES.LAST_USED_AT,
				TRUSTED_DEVICES.REVOKED,
				TRUSTED_DEVICES.CLIENT_IP_ADDRESS,
				TRUSTED_DEVICES.CLIENT_USER_AGENT
			)
			.from(TRUSTED_DEVICES)
			.where(
				TRUSTED_DEVICES.TOKEN.equal(token)
			)
			.fetchOneInto(OTrustedDevice.class);
	}
	
	public int insert(Connection con, OTrustedDevice item, DateTime revisionTimestamp) throws DAOException {
		DSLContext dsl = getDSL(con);
		item.setCreationTimestamp(revisionTimestamp);
		item.setRevisionTimestamp(revisionTimestamp);
		
		TrustedDevicesRecord record = dsl.newRecord(TRUSTED_DEVICES, item);
		return dsl
			.insertInto(TRUSTED_DEVICES)
			.set(record)
			.execute();
	}
	
	public int updateUsageById(Connection con, long id, DateTime lastUsedAt) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.update(TRUSTED_DEVICES)
			.set(TRUSTED_DEVICES.LAST_USED_AT, lastUsedAt)
			.where(
				TRUSTED_DEVICES.TRUSTED_DEVICE_ID.equal(id)
			)
			.execute();
	}
	
	public int revokeByPid(Connection con, String domainId, String userId, DateTime revisionTimestamp) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.update(TRUSTED_DEVICES)
				.set(TRUSTED_DEVICES.REVISION_TIMESTAMP, revisionTimestamp)
				.set(TRUSTED_DEVICES.REVOKED, true)
			.where(
				TRUSTED_DEVICES.DOMAIN_ID.equal(domainId)
				.and(TRUSTED_DEVICES.USER_ID.equal(userId))
			)
			.execute();
	}
	
	public int revokeThisByPidClient(Connection con, String domainId, String userId, String clientIdentifier, DateTime revisionTimestamp) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.update(TRUSTED_DEVICES)
				.set(TRUSTED_DEVICES.REVISION_TIMESTAMP, revisionTimestamp)
				.set(TRUSTED_DEVICES.REVOKED, true)
			.where(
				TRUSTED_DEVICES.DOMAIN_ID.equal(domainId)
				.and(TRUSTED_DEVICES.USER_ID.equal(userId))
				.and(TRUSTED_DEVICES.CLIENT_IDENTIFIER.equal(clientIdentifier))
			)
			.execute();
	}
	
	public int revokeOthersByPidClient(Connection con, String domainId, String userId, String clientIdentifier, DateTime revisionTimestamp) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.update(TRUSTED_DEVICES)
				.set(TRUSTED_DEVICES.REVISION_TIMESTAMP, revisionTimestamp)
				.set(TRUSTED_DEVICES.REVOKED, true)
			.where(
				TRUSTED_DEVICES.DOMAIN_ID.equal(domainId)
				.and(TRUSTED_DEVICES.USER_ID.equal(userId))
				.and(TRUSTED_DEVICES.CLIENT_IDENTIFIER.notEqual(clientIdentifier))
			)
			.execute();
	}
	
	public int revokeByToken(Connection con, String token, DateTime revisionTimestamp) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.update(TRUSTED_DEVICES)
				.set(TRUSTED_DEVICES.REVISION_TIMESTAMP, revisionTimestamp)
				.set(TRUSTED_DEVICES.REVOKED, true)
			.where(
				TRUSTED_DEVICES.TOKEN.equal(token)
			)
			.execute();
	}
	
	public int revokeById(Connection con, long id, DateTime revisionTimestamp) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.update(TRUSTED_DEVICES)
				.set(TRUSTED_DEVICES.REVISION_TIMESTAMP, revisionTimestamp)
				.set(TRUSTED_DEVICES.REVOKED, true)
			.where(
				TRUSTED_DEVICES.TRUSTED_DEVICE_ID.equal(id)
			)
			.execute();
	}
	
	public int deleteByDomain(Connection con, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(TRUSTED_DEVICES)
			.where(
				TRUSTED_DEVICES.DOMAIN_ID.equal(domainId)
			)
			.execute();
	}
}
