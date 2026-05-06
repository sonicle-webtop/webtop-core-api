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
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
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

import com.sonicle.webtop.core.app.model.AIUsage;
import com.sonicle.webtop.core.bol.OAIUsage;
import static com.sonicle.webtop.core.jooq.core.tables.AiUsage.AI_USAGE;
import static com.sonicle.webtop.core.jooq.core.tables.Users.USERS;
import com.sonicle.webtop.core.jooq.core.tables.records.AiUsageRecord;
import java.sql.Connection;
import java.util.List;
import org.joda.time.DateTime;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

public class AIUsageDAO extends BaseDAO {
	private final static AIUsageDAO INSTANCE = new AIUsageDAO();
	public static AIUsageDAO getInstance() {
		return INSTANCE;
	}

	public int insert(Connection con, OAIUsage item) throws DAOException {
		DSLContext dsl = getDSL(con);
		AiUsageRecord record = dsl.newRecord(AI_USAGE, item);
		return dsl
			.insertInto(AI_USAGE)
			.set(record)
			.execute();
	}
	
	public List<OAIUsage> groupUserNamesByDateRange(Connection con, String domainId, DateTime from, DateTime to) {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
				AI_USAGE.USER_ID,
				USERS.DISPLAY_NAME,
				DSL.sum(AI_USAGE.PROMPT_TOKENS).as("prompt_tokens"),
				DSL.sum(AI_USAGE.COMPLETION_TOKENS).as("completion_tokens"),
				DSL.sum(AI_USAGE.TOTAL_TOKENS).as("total_tokens")
			)
			.from(AI_USAGE).innerJoin(USERS).on(AI_USAGE.DOMAIN_ID.equal(USERS.DOMAIN_ID).and(AI_USAGE.USER_ID.equal(USERS.USER_ID)))
			.where(
				AI_USAGE.DOMAIN_ID.equal(domainId).and(
					AI_USAGE.TIMESTAMP.between(from, to)
				)
			)
			.groupBy(AI_USAGE.USER_ID, USERS.DISPLAY_NAME)
			.orderBy(AI_USAGE.USER_ID)
			.fetchInto(OAIUsage.class);
	}

	/**
	 * Sums {@code total_tokens} for one user since the given inclusive
	 * lower bound. Used by AIUsageManager to seed its in-memory daily
	 * counter on a cold start (or first call after midnight). Returns 0
	 * when there are no rows or when all matching rows have null tokens.
	 */
	public long sumTokensSince(Connection con, String domainId, String userId, DateTime fromInclusive) throws DAOException {
		DSLContext dsl = getDSL(con);
		Long sum = dsl
			.select(org.jooq.impl.DSL.sum(AI_USAGE.TOTAL_TOKENS).cast(Long.class))
			.from(AI_USAGE)
			.where(
				AI_USAGE.DOMAIN_ID.equal(domainId)
				.and(AI_USAGE.USER_ID.equal(userId))
				.and(AI_USAGE.TIMESTAMP.greaterOrEqual(fromInclusive))
			)
			.fetchOne(0, Long.class);
		return sum == null ? 0L : sum;
	}
}
