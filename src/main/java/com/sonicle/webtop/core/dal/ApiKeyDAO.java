/*
 * Copyright (C) 2025 Sonicle S.r.l.
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
 * display the words "Copyright (C) 2025 Sonicle S.r.l.".
 */
package com.sonicle.webtop.core.dal;

import com.sonicle.webtop.core.bol.OApiKey;
import static com.sonicle.webtop.core.jooq.core.Tables.API_KEYS;
import com.sonicle.webtop.core.jooq.core.tables.records.ApiKeysRecord;
import java.sql.Connection;
import java.util.Map;
import org.joda.time.DateTime;
import org.jooq.DSLContext;

/**
 *
 * @author malbinola
 */
public class ApiKeyDAO extends BaseDAO {
	private final static ApiKeyDAO INSTANCE = new ApiKeyDAO();
	public static ApiKeyDAO getInstance() {
		return INSTANCE;
	}
	
	public Map<String, OApiKey> selectByDomain(Connection con, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select()
			.from(API_KEYS)
			.where(
				API_KEYS.DOMAIN_ID.equal(domainId)
			)
			.orderBy(
				API_KEYS.NAME.asc()
			)
			.fetchMap(API_KEYS.API_KEY_ID, OApiKey.class);
	}
	
	public Map<String, OApiKey> selectValidByInstant(Connection con, DateTime instant) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select()
			.from(API_KEYS)
			.where(
				API_KEYS.EXPIRES_AT.isNull()
				.or(API_KEYS.EXPIRES_AT.lessThan(instant))
			)
			.orderBy(
				API_KEYS.NAME.asc()
			)
			.fetchMap(API_KEYS.API_KEY_ID, OApiKey.class);
	}
	
	public OApiKey selectByDomainId(Connection con, String domainId, String apiKeyId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select()
			.from(API_KEYS)
			.where(
				API_KEYS.API_KEY_ID.equal(apiKeyId)
				.and(API_KEYS.DOMAIN_ID.equal(domainId))
			)
			.fetchOneInto(OApiKey.class);
	} 
	
	public int insert(Connection con, OApiKey item, DateTime revisionTimestamp) throws DAOException {
		DSLContext dsl = getDSL(con);
		item.setCreationTimestamp(revisionTimestamp);
		item.setRevisionTimestamp(revisionTimestamp);
		
		ApiKeysRecord record = dsl.newRecord(API_KEYS, item);
		return dsl
			.insertInto(API_KEYS)
			.set(record)
			.execute();
	}
	
	public int update(Connection con, String domainId, OApiKey item, DateTime revisionTimestamp) throws DAOException {
		item.setRevisionTimestamp(revisionTimestamp);
		DSLContext dsl = getDSL(con);
		return dsl
			.update(API_KEYS)
			.set(API_KEYS.REVISION_TIMESTAMP, item.getRevisionTimestamp())
			.set(API_KEYS.NAME, item.getName())
			.set(API_KEYS.DESCRIPTION, item.getDescription())
			.set(API_KEYS.EXPIRES_AT, item.getExpiresAt())
			.where(
				API_KEYS.API_KEY_ID.equal(item.getApiKeyId())
				.and(API_KEYS.DOMAIN_ID.equal(domainId))
			)
			.execute();
	}
	
	public int deleteByDomainId(Connection con, String domainId, String apiKeyId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(API_KEYS)
			.where(
				API_KEYS.API_KEY_ID.equal(apiKeyId)
				.and(API_KEYS.DOMAIN_ID.equal(domainId))
			)
			.execute();
	}
	
	public int deleteByDomain(Connection con, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(API_KEYS)
			.where(
				API_KEYS.DOMAIN_ID.equal(domainId)
			)
			.execute();
	}
}
