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

import com.sonicle.webtop.core.app.model.EnabledCond;
import com.sonicle.webtop.core.bol.ODomain;
import static com.sonicle.webtop.core.jooq.core.Tables.DOMAINS;
import java.sql.Connection;
import org.jooq.DSLContext;
import com.sonicle.webtop.core.jooq.core.tables.records.*;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jooq.Condition;
import org.jooq.UpdateSetMoreStep;
import org.jooq.impl.DSL;

/**
 *
 * @author malbinola
 */
public class DomainDAO extends BaseDAO {
	private final static DomainDAO INSTANCE = new DomainDAO();
	public static DomainDAO getInstance() {
		return INSTANCE;
	}
	
	public boolean idIsAvailable(Connection con, String domainId) {
		DSLContext dsl = getDSL(con);
		return dsl
			.selectCount()
			.from(DOMAINS)
			.where(
				DOMAINS.DOMAIN_ID.equal(domainId)
			)
			.fetchOne(0, Integer.class) == 0;
	}
	
	public Set<String> selectIdsByEnabled(Connection con, EnabledCond enabled) throws DAOException {
		DSLContext dsl = getDSL(con);
		Condition cndtEnabled = DSL.trueCondition();
		if (EnabledCond.ENABLED_ONLY.equals(enabled)) {
			cndtEnabled = DOMAINS.ENABLED.equal(true);
		} else if (EnabledCond.DISABLED_ONLY.equals(enabled)) {
			cndtEnabled = DOMAINS.ENABLED.equal(false);
		}
		
		return dsl
			.select(
				DOMAINS.DOMAIN_ID
			)
			.from(DOMAINS)
			.where(cndtEnabled)
			.orderBy(
				DOMAINS.DOMAIN_ID.asc()
			)
			.fetchSet(DOMAINS.DOMAIN_ID);
	}
	
	public List<ODomain> selectBasicByEnabled(Connection con, EnabledCond enabled) throws DAOException {
		DSLContext dsl = getDSL(con);
		Condition cndtEnabled = DSL.trueCondition();
		if (EnabledCond.ENABLED_ONLY.equals(enabled)) {
			cndtEnabled = DOMAINS.ENABLED.equal(true);
		} else if (EnabledCond.DISABLED_ONLY.equals(enabled)) {
			cndtEnabled = DOMAINS.ENABLED.equal(false);
		}
		
		return dsl
			.select(
				DOMAINS.DOMAIN_ID,
				DOMAINS.ENABLED,
				DOMAINS.DESCRIPTION,
				DOMAINS.INTERNET_NAME,
				DOMAINS.USER_AUTO_CREATION,
				DOMAINS.DIR_URI
			)
			.from(DOMAINS)
			.where(cndtEnabled)
			.orderBy(
				DOMAINS.DOMAIN_ID.asc()
			)
			.fetchInto(ODomain.class);
	}
	
	@Deprecated
	public List<ODomain> selectAll(Connection con) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select()
			.from(DOMAINS)
			.fetchInto(ODomain.class);
	}
	
	@Deprecated
	public List<ODomain> selectEnabled(Connection con) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select()
			.from(DOMAINS)
			.where(
				DOMAINS.ENABLED.isTrue()
			)
			.orderBy(
				DOMAINS.DOMAIN_ID.asc()
			)
			.fetchInto(ODomain.class);
	}
	
	public List<ODomain> selectInfo(Connection con) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
				DOMAINS.DOMAIN_ID,
				DOMAINS.ENABLED,
				DOMAINS.DESCRIPTION, // -> DISPLAY_NAME
				DOMAINS.INTERNET_NAME // -> AUTH_FQDN
			)
			.from(DOMAINS)
			.orderBy(
				DOMAINS.DOMAIN_ID.asc()
			)
			.fetchInto(ODomain.class);
	}
	
	public Map<String, String> selectEnabledInternetNames(Connection con) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
				DOMAINS.DOMAIN_ID,
				DOMAINS.INTERNET_NAME
			)
			.from(DOMAINS)
			.where(
				DOMAINS.ENABLED.isTrue()
			)
			.orderBy(
				DOMAINS.DOMAIN_ID.asc()
			)
			.fetchMap(DOMAINS.DOMAIN_ID, DOMAINS.INTERNET_NAME);
	}
	
	public List<ODomain> selectEnabledByInternetName(Connection con, String internetName) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select()
			.from(DOMAINS)
			.where(
				DOMAINS.INTERNET_NAME.equal(internetName)
				.and(DOMAINS.ENABLED.isTrue())
			)
			.orderBy(
				DOMAINS.DOMAIN_ID.asc()
			)
			.fetchInto(ODomain.class);
	}
	
	public ODomain selectBasicById(Connection con, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
				DOMAINS.DOMAIN_ID,
				DOMAINS.ENABLED,
				DOMAINS.INTERNET_NAME,
				DOMAINS.DESCRIPTION,
				DOMAINS.USER_AUTO_CREATION,
				DOMAINS.DIR_URI
			)
			.from(DOMAINS)
			.where(
				DOMAINS.DOMAIN_ID.equal(domainId)
			)
			.fetchOneInto(ODomain.class);
	}
	
	public ODomain selectById(Connection con, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select()
			.from(DOMAINS)
			.where(
				DOMAINS.DOMAIN_ID.equal(domainId)
			)
			.fetchOneInto(ODomain.class);
	}
	
	public ODomain selectPasswordPoliciesById(Connection con, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
				DOMAINS.DIR_PWD_POLICY_COMPLEXITY,
				DOMAINS.DIR_PWD_POLICY_MIN_LENGTH,
				DOMAINS.DIR_PWD_POLICY_AVOID_CONSECUTIVE_CHARS,
				DOMAINS.DIR_PWD_POLICY_AVOID_OLD_SIMILARITY,
				DOMAINS.DIR_PWD_POLICY_AVOID_USERNAME_SIMILARITY,
				DOMAINS.DIR_PWD_POLICY_EXPIRATION,
				DOMAINS.DIR_PWD_POLICY_VERIFY_AT_LOGIN
			)
			.from(DOMAINS)
			.where(
				DOMAINS.DOMAIN_ID.equal(domainId)
			)
			.fetchOneInto(ODomain.class);
	}
	
	public String selectDirParametersById(Connection con, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
				DOMAINS.DIR_PARAMETERS
			)
			.from(DOMAINS)
			.where(
				DOMAINS.DOMAIN_ID.equal(domainId)
			)
			.fetchOneInto(String.class);
	}
	
	public int insert(Connection con, ODomain item) throws DAOException {
		DSLContext dsl = getDSL(con);
		DomainsRecord record = dsl.newRecord(DOMAINS, item);
		return dsl
			.insertInto(DOMAINS)
			.set(record)
			.execute();
	}
	
	public int updateBasic(Connection con, ODomain item) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.update(DOMAINS)
			.set(DOMAINS.ENABLED, item.getEnabled())
			.set(DOMAINS.DESCRIPTION, item.getDisplayName())
			.set(DOMAINS.INTERNET_NAME, item.getAuthDomainName())
			//.set(DOMAINS.INTERNET_NAME, item.getDomainName())
			.set(DOMAINS.USER_AUTO_CREATION, item.getUserAutoCreation())
			.where(
				DOMAINS.DOMAIN_ID.equal(item.getDomainId())
			)
			.execute();
	}
	
	public int update(Connection con, ODomain item, boolean setPassword) throws DAOException {
		DSLContext dsl = getDSL(con);
		UpdateSetMoreStep update = dsl
			.update(DOMAINS)
			.set(DOMAINS.ENABLED, item.getEnabled())
			.set(DOMAINS.DESCRIPTION, item.getDisplayName())
			.set(DOMAINS.INTERNET_NAME, item.getAuthDomainName())
			//.set(DOMAINS.INTERNET_NAME, item.getDomainName())
			.set(DOMAINS.USER_AUTO_CREATION, item.getUserAutoCreation())
			.set(DOMAINS.DIR_URI, item.getDirUri())
			.set(DOMAINS.DIR_ADMIN, item.getDirAdmin());
		if (setPassword) {
			update = update
				.set(DOMAINS.DIR_PASSWORD, item.getDirPassword());
		}
		update = update
			.set(DOMAINS.DIR_CONNECTION_SECURITY, item.getDirConnectionSecurity())
			.set(DOMAINS.DIR_CASE_SENSITIVE, item.getDirCaseSensitive())
			.set(DOMAINS.DIR_PARAMETERS, item.getDirParameters())
			.set(DOMAINS.DIR_PWD_POLICY_COMPLEXITY, item.getDirPwdPolicyComplexity())
			.set(DOMAINS.DIR_PWD_POLICY_MIN_LENGTH, item.getDirPwdPolicyMinLength())
			.set(DOMAINS.DIR_PWD_POLICY_AVOID_CONSECUTIVE_CHARS, item.getDirPwdPolicyAvoidConsecutiveChars())
			.set(DOMAINS.DIR_PWD_POLICY_AVOID_OLD_SIMILARITY, item.getDirPwdPolicyAvoidOldSimilarity())
			.set(DOMAINS.DIR_PWD_POLICY_AVOID_USERNAME_SIMILARITY, item.getDirPwdPolicyAvoidUsernameSimilarity())
			.set(DOMAINS.DIR_PWD_POLICY_EXPIRATION, item.getDirPwdPolicyExpiration())
			.set(DOMAINS.DIR_PWD_POLICY_VERIFY_AT_LOGIN, item.getDirPwdPolicyVerifyAtLogin());
		
		return update
			.where(
				DOMAINS.DOMAIN_ID.equal(item.getDomainId())
			)
			.execute();
	}
	
	public int deleteById(Connection con, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(DOMAINS)
			.where(
				DOMAINS.DOMAIN_ID.equal(domainId)
			)
			.execute();
	}
}
