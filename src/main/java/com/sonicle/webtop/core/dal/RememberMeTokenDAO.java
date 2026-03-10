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

import com.sonicle.webtop.core.bol.ORememberMeToken;
import static com.sonicle.webtop.core.jooq.core.Sequences.SEQ_REMEMBERME_TOKENS;
import static com.sonicle.webtop.core.jooq.core.tables.RemembermeTokens.REMEMBERME_TOKENS;
import com.sonicle.webtop.core.jooq.core.tables.records.RemembermeTokensRecord;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import org.joda.time.DateTime;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

/**
 *
 * @author malbinola
 */
public class RememberMeTokenDAO extends BaseDAO {
	private final static RememberMeTokenDAO INSTANCE = new RememberMeTokenDAO();
	public static RememberMeTokenDAO getInstance() {
		return INSTANCE;
	}
	
	public Long getSequence(Connection con) throws DAOException {
		DSLContext dsl = getDSL(con);
		Long nextID = dsl.nextval(SEQ_REMEMBERME_TOKENS);
		return nextID;
	}
	
	public List<ORememberMeToken> selectByProfileRevoked(Connection con, String domainId, String userId, Optional<Boolean> revoked) throws DAOException {
		DSLContext dsl = getDSL(con);
		Condition cndtEnabled = DSL.trueCondition();
		if (revoked.isPresent()) cndtEnabled = REMEMBERME_TOKENS.REVOKED.equal(revoked.get());
		return dsl
			.select(
				REMEMBERME_TOKENS.REMEMBERME_TOKEN_ID,
				REMEMBERME_TOKENS.DOMAIN_ID,
				REMEMBERME_TOKENS.USER_ID,
				REMEMBERME_TOKENS.SELECTOR,
				REMEMBERME_TOKENS.VALIDATOR,
				REMEMBERME_TOKENS.VALIDATOR_PREV,
				REMEMBERME_TOKENS.ISSUED_AT,
				REMEMBERME_TOKENS.EXPIRES_AT,
				REMEMBERME_TOKENS.LAST_USED_AT,
				REMEMBERME_TOKENS.REVOKED,
				REMEMBERME_TOKENS.CLIENT_IDENTIFIER,
				REMEMBERME_TOKENS.CLIENT_IP_ADDRESS,
				REMEMBERME_TOKENS.CLIENT_USER_AGENT
			)
			.from(REMEMBERME_TOKENS)
			.where(
				REMEMBERME_TOKENS.DOMAIN_ID.equal(domainId)
				.and(REMEMBERME_TOKENS.USER_ID.equal(userId))
				.and(cndtEnabled)
			)
			.fetchInto(ORememberMeToken.class);
	}
	
	public ORememberMeToken selectBySelector(Connection con, String selector) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
				REMEMBERME_TOKENS.REMEMBERME_TOKEN_ID,
				REMEMBERME_TOKENS.DOMAIN_ID,
				REMEMBERME_TOKENS.USER_ID,
				REMEMBERME_TOKENS.SELECTOR,
				REMEMBERME_TOKENS.VALIDATOR,
				REMEMBERME_TOKENS.VALIDATOR_PREV,
				REMEMBERME_TOKENS.ISSUED_AT,
				REMEMBERME_TOKENS.EXPIRES_AT,
				REMEMBERME_TOKENS.LAST_USED_AT,
				REMEMBERME_TOKENS.REVOKED,
				REMEMBERME_TOKENS.CLIENT_IDENTIFIER,
				REMEMBERME_TOKENS.CLIENT_IP_ADDRESS,
				REMEMBERME_TOKENS.CLIENT_USER_AGENT
			)
			.from(REMEMBERME_TOKENS)
			.where(
				REMEMBERME_TOKENS.SELECTOR.equal(selector)
			)
			.fetchOneInto(ORememberMeToken.class);
	}
	
	public int insert(Connection con, ORememberMeToken item, DateTime revisionTimestamp) throws DAOException {
		DSLContext dsl = getDSL(con);
		item.setCreationTimestamp(revisionTimestamp);
		item.setRevisionTimestamp(revisionTimestamp);
		
		RemembermeTokensRecord record = dsl.newRecord(REMEMBERME_TOKENS, item);
		return dsl
			.insertInto(REMEMBERME_TOKENS)
			.set(record)
			.execute();
	}
	
	public int updateValidatorById(Connection con, long tokenId, String newValidator, DateTime issuedAt, DateTime expiresAt, DateTime revisionTimestamp) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.update(REMEMBERME_TOKENS)
			.set(REMEMBERME_TOKENS.REVISION_TIMESTAMP, revisionTimestamp)
			.set(REMEMBERME_TOKENS.VALIDATOR_PREV, REMEMBERME_TOKENS.VALIDATOR)
			.set(REMEMBERME_TOKENS.VALIDATOR, newValidator)
			.set(REMEMBERME_TOKENS.ISSUED_AT, issuedAt)
			.set(REMEMBERME_TOKENS.EXPIRES_AT, expiresAt)
			.set(REMEMBERME_TOKENS.LAST_USED_AT, revisionTimestamp)
			.where(
				REMEMBERME_TOKENS.REMEMBERME_TOKEN_ID.equal(tokenId)
			)
			.execute();
	}
	
	public int updateUsageById(Connection con, long id, DateTime expiresAt, DateTime lastUsedAt) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.update(REMEMBERME_TOKENS)
			.set(REMEMBERME_TOKENS.EXPIRES_AT, expiresAt)
			.set(REMEMBERME_TOKENS.LAST_USED_AT, lastUsedAt)
			.where(
				REMEMBERME_TOKENS.REMEMBERME_TOKEN_ID.equal(id)
			)
			.execute();
	}
	
	public int updateUsageById(Connection con, long id, DateTime lastUsedAt) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.update(REMEMBERME_TOKENS)
			.set(REMEMBERME_TOKENS.LAST_USED_AT, lastUsedAt)
			.where(
				REMEMBERME_TOKENS.REMEMBERME_TOKEN_ID.equal(id)
			)
			.execute();
	}
	
	public int revokeById(Connection con, long tokenId, DateTime revisionTimestamp) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.update(REMEMBERME_TOKENS)
				.set(REMEMBERME_TOKENS.REVISION_TIMESTAMP, revisionTimestamp)
				.set(REMEMBERME_TOKENS.REVOKED, true)
			.where(
				REMEMBERME_TOKENS.REMEMBERME_TOKEN_ID.equal(tokenId)
			)
			.execute();
	}
	
	public int revokeBySelector(Connection con, String selector, DateTime revisionTimestamp) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.update(REMEMBERME_TOKENS)
				.set(REMEMBERME_TOKENS.REVISION_TIMESTAMP, revisionTimestamp)
				.set(REMEMBERME_TOKENS.REVOKED, true)
			.where(
				REMEMBERME_TOKENS.SELECTOR.equal(selector)
			)
			.execute();
	}
	
	public int revokeByProfile(Connection con, String domainId, String userId, DateTime revisionTimestamp) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.update(REMEMBERME_TOKENS)
				.set(REMEMBERME_TOKENS.REVISION_TIMESTAMP, revisionTimestamp)
				.set(REMEMBERME_TOKENS.REVOKED, true)
			.where(
				REMEMBERME_TOKENS.DOMAIN_ID.equal(domainId)
				.and(REMEMBERME_TOKENS.USER_ID.equal(userId))
			)
			.execute();
	}
	
	public int revokeByProfileSelector(Connection con, String domainId, String userId, String selector, DateTime revisionTimestamp) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.update(REMEMBERME_TOKENS)
				.set(REMEMBERME_TOKENS.REVISION_TIMESTAMP, revisionTimestamp)
				.set(REMEMBERME_TOKENS.REVOKED, true)
			.where(
				REMEMBERME_TOKENS.SELECTOR.equal(selector)
				.and(REMEMBERME_TOKENS.DOMAIN_ID.equal(domainId))
				.and(REMEMBERME_TOKENS.USER_ID.equal(userId))
			)
			.execute();
	}
	
	public int deleteByDomain(Connection con, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(REMEMBERME_TOKENS)
			.where(
				REMEMBERME_TOKENS.DOMAIN_ID.equal(domainId)
			)
			.execute();
	}
}
