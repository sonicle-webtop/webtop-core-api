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

import com.sonicle.webtop.core.bol.OAuthToken;
import static com.sonicle.webtop.core.jooq.core.Sequences.SEQ_AUTH_TOKENS;
import static com.sonicle.webtop.core.jooq.core.tables.AuthTokens.AUTH_TOKENS;
import com.sonicle.webtop.core.jooq.core.tables.records.AuthTokensRecord;
import java.sql.Connection;
import java.util.Collection;
import java.util.List;
import org.joda.time.DateTime;
import org.jooq.DSLContext;

/**
 *
 * @author malbinola
 */
public class AuthTokenDAO extends BaseDAO {
	private final static AuthTokenDAO INSTANCE = new AuthTokenDAO();
	public static AuthTokenDAO getInstance() {
		return INSTANCE;
	}

	public Long getSequence(Connection con) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl.nextval(SEQ_AUTH_TOKENS);
	}

	public OAuthToken selectByTokenHash(Connection con, String token) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
				AUTH_TOKENS.fields()
			)
			.from(AUTH_TOKENS)
			.where(AUTH_TOKENS.TOKEN.equal(token))
			.fetchOneInto(OAuthToken.class);
	}

	public OAuthToken selectById(Connection con, long id) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
				AUTH_TOKENS.fields()
			)
			.from(AUTH_TOKENS)
			.where(
				AUTH_TOKENS.AUTH_TOKEN_ID.equal(id)
			)
			.fetchOneInto(OAuthToken.class);
	}

	public OAuthToken selectByIdAndUser(Connection con, long id, String domainId, String userId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
				AUTH_TOKENS.fields()
			)
			.from(AUTH_TOKENS)
			.where(
				AUTH_TOKENS.AUTH_TOKEN_ID.equal(id)
				.and(AUTH_TOKENS.DOMAIN_ID.equal(domainId))
				.and(AUTH_TOKENS.USER_ID.equal(userId))
			)
			.fetchOneInto(OAuthToken.class);
	}

	public List<OAuthToken> selectByParentIdAndType(Connection con, long parentId, String type) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
				AUTH_TOKENS.fields()
			)
			.from(AUTH_TOKENS)
			.where(
				AUTH_TOKENS.PARENT_ID.equal(parentId)
				.and(AUTH_TOKENS.TYPE.equal(type))
			)
			.fetchInto(OAuthToken.class);
	}

	public List<OAuthToken> selectActiveRefreshByUser(Connection con, String domainId, String userId, DateTime now) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
				AUTH_TOKENS.fields()
			)
			.from(AUTH_TOKENS)
			.where(
				AUTH_TOKENS.DOMAIN_ID.equal(domainId)
				.and(AUTH_TOKENS.USER_ID.equal(userId))
				.and(AUTH_TOKENS.TYPE.equal(OAuthToken.TYPE_REFRESH))
				.and(AUTH_TOKENS.REVOKED_AT.isNull())
				.and(AUTH_TOKENS.EXPIRES_AT.greaterThan(now))
			)
			.orderBy(AUTH_TOKENS.CREATION_TIMESTAMP.desc())
			.fetchInto(OAuthToken.class);
	}

	public int insert(Connection con, OAuthToken item, DateTime revisionTimestamp) throws DAOException {
		DSLContext dsl = getDSL(con);
		item.setCreationTimestamp(revisionTimestamp);
		item.setRevisionTimestamp(revisionTimestamp);

		AuthTokensRecord record = dsl.newRecord(AUTH_TOKENS, item);
		return dsl
			.insertInto(AUTH_TOKENS)
			.set(record)
			.execute();
	}

	public int updateLastUsedById(Connection con, long id, DateTime lastUsedAt) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.update(AUTH_TOKENS)
			.set(AUTH_TOKENS.LAST_USED_AT, lastUsedAt)
			.where(AUTH_TOKENS.AUTH_TOKEN_ID.equal(id))
			.execute();
	}

	public int revokeById(Connection con, long id, DateTime revokedAt, DateTime revisionTimestamp) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.update(AUTH_TOKENS)
				.set(AUTH_TOKENS.REVISION_TIMESTAMP, revisionTimestamp)
				.set(AUTH_TOKENS.REVOKED_AT, revokedAt)
			.where(
				AUTH_TOKENS.AUTH_TOKEN_ID.equal(id)
				.and(AUTH_TOKENS.REVOKED_AT.isNull())
			)
			.execute();
	}

	public int revokeByIds(Connection con, Collection<Long> ids, DateTime revokedAt, DateTime revisionTimestamp) throws DAOException {
		if (ids == null || ids.isEmpty()) return 0;
		DSLContext dsl = getDSL(con);
		return dsl
			.update(AUTH_TOKENS)
				.set(AUTH_TOKENS.REVISION_TIMESTAMP, revisionTimestamp)
				.set(AUTH_TOKENS.REVOKED_AT, revokedAt)
			.where(
				AUTH_TOKENS.AUTH_TOKEN_ID.in(ids)
				.and(AUTH_TOKENS.REVOKED_AT.isNull())
			)
			.execute();
	}

	public int revokeByParentId(Connection con, long parentId, DateTime revokedAt, DateTime revisionTimestamp) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.update(AUTH_TOKENS)
				.set(AUTH_TOKENS.REVISION_TIMESTAMP, revisionTimestamp)
				.set(AUTH_TOKENS.REVOKED_AT, revokedAt)
			.where(
				AUTH_TOKENS.PARENT_ID.equal(parentId)
				.and(AUTH_TOKENS.REVOKED_AT.isNull())
			)
			.execute();
	}

	public int revokeByParentIds(Connection con, Collection<Long> parentIds, DateTime revokedAt, DateTime revisionTimestamp) throws DAOException {
		if (parentIds == null || parentIds.isEmpty()) return 0;
		DSLContext dsl = getDSL(con);
		return dsl
			.update(AUTH_TOKENS)
				.set(AUTH_TOKENS.REVISION_TIMESTAMP, revisionTimestamp)
				.set(AUTH_TOKENS.REVOKED_AT, revokedAt)
			.where(
				AUTH_TOKENS.PARENT_ID.in(parentIds)
				.and(AUTH_TOKENS.REVOKED_AT.isNull())
			)
			.execute();
	}

	public int revokeAllByUser(Connection con, String domainId, String userId, DateTime revokedAt, DateTime revisionTimestamp) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.update(AUTH_TOKENS)
				.set(AUTH_TOKENS.REVISION_TIMESTAMP, revisionTimestamp)
				.set(AUTH_TOKENS.REVOKED_AT, revokedAt)
			.where(
				AUTH_TOKENS.DOMAIN_ID.equal(domainId)
				.and(AUTH_TOKENS.USER_ID.equal(userId))
				.and(AUTH_TOKENS.REVOKED_AT.isNull())
			)
			.execute();
	}

	public int deleteExpiredBefore(Connection con, DateTime threshold) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(AUTH_TOKENS)
			.where(AUTH_TOKENS.EXPIRES_AT.lessThan(threshold))
			.execute();
	}

	public int deleteByDomain(Connection con, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(AUTH_TOKENS)
			.where(AUTH_TOKENS.DOMAIN_ID.equal(domainId))
			.execute();
	}
}
