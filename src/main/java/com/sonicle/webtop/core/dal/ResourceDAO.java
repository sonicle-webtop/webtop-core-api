/*
 * Copyright (C) 2022 Sonicle S.r.l.
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
 * display the words "Copyright (C) 2022 Sonicle S.r.l.".
 */
package com.sonicle.webtop.core.dal;

import com.sonicle.commons.EnumUtils;
import com.sonicle.webtop.core.app.model.EnabledCond;
import com.sonicle.webtop.core.bol.VResource;
import com.sonicle.webtop.core.bol.OUser;
import com.sonicle.webtop.core.bol.OUserInfo;
import com.sonicle.webtop.core.bol.VUserData;
import static com.sonicle.webtop.core.jooq.core.Tables.USERS;
import static com.sonicle.webtop.core.jooq.core.Tables.USERS_INFO;
import com.sonicle.webtop.core.jooq.core.tables.records.UsersRecord;
import java.sql.Connection;
import java.util.List;
import java.util.Set;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

/**
 *
 * @author malbinola
 */
public class ResourceDAO extends BaseDAO {
	private final static ResourceDAO INSTANCE = new ResourceDAO();
	public static ResourceDAO getInstance() {
		return INSTANCE;
	}
	
	public boolean idIsAvailableByDomain(Connection con, String domainId, String resourceId) {
		DSLContext dsl = getDSL(con);
		return dsl
			.selectCount()
			.from(USERS)
			.where(
				USERS.DOMAIN_ID.equal(domainId)
				.and(USERS.USER_ID.equal(resourceId))
			)
			.fetchOne(0, Integer.class) == 0;
	}
	
	public VUserData viewDataByProfile(Connection con, String domainId, String resourceId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
				USERS.ENABLED,
				USERS.DISPLAY_NAME,
				USERS_INFO.CUSTOM1
			)
			.from(USERS)
			.join(USERS_INFO).on(
				USERS.DOMAIN_ID.equal(USERS_INFO.DOMAIN_ID).and(USERS.USER_ID.equal(USERS_INFO.USER_ID))
			)
			.where(
				USERS.DOMAIN_ID.equal(domainId)
				.and(USERS.USER_ID.equal(resourceId))
				.and(USERS.TYPE.equal(EnumUtils.toSerializedName(OUser.Type.RESOURCE)))
			)
			.fetchOneInto(VUserData.class);
	}
	
	public Boolean selectEnabledByProfile(Connection con, String domainId, String resourceId) {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
				USERS.ENABLED
			)
			.from(USERS)
			.where(
				USERS.DOMAIN_ID.equal(domainId)
				.and(USERS.USER_ID.equal(resourceId))
				.and(USERS.TYPE.equal(EnumUtils.toSerializedName(OUser.Type.RESOURCE)))
			)
			.fetchOne(USERS.ENABLED);
	}
	
	public VResource selectByProfile(Connection con, String domainId, String resourceId) throws DAOException {
		DSLContext dsl = getDSL(con);
		
		return dsl
			.select(
				USERS.DOMAIN_ID,
				USERS.USER_ID,
				USERS.TYPE,
				USERS.ENABLED,
				USERS.USER_UID,
				USERS.DISPLAY_NAME,
				USERS_INFO.EMAIL,
				//USERS_INFO.TELEPHONE,
				USERS_INFO.CUSTOM1
				//USERS_INFO.CUSTOM2
			)
			.from(USERS)
			.join(USERS_INFO).on(
				USERS.DOMAIN_ID.equal(USERS_INFO.DOMAIN_ID).and(USERS.USER_ID.equal(USERS_INFO.USER_ID))
			)
			.where(
				USERS.DOMAIN_ID.equal(domainId)
				.and(USERS.USER_ID.equal(resourceId))
				.and(USERS.TYPE.equal(EnumUtils.toSerializedName(OUser.Type.RESOURCE)))
			)
			.fetchOneInto(VResource.class);
	}
	
	public List<VResource> selectByDomainEnabled(Connection con, String domainId, EnabledCond enabled) throws DAOException {
		DSLContext dsl = getDSL(con);
		Condition cndtEnabled = DSL.trueCondition();
		if (EnabledCond.ENABLED_ONLY.equals(enabled)) {
			cndtEnabled = USERS.ENABLED.equal(true);
		} else if (EnabledCond.DISABLED_ONLY.equals(enabled)) {
			cndtEnabled = USERS.ENABLED.equal(false);
		}
		
		return dsl
			.select(
				USERS.DOMAIN_ID,
				USERS.USER_ID,
				USERS.TYPE,
				USERS.ENABLED,
				USERS.USER_UID,
				USERS.DISPLAY_NAME,
				USERS_INFO.EMAIL,
				//USERS_INFO.TELEPHONE,
				USERS_INFO.CUSTOM1
				//USERS_INFO.CUSTOM2
			)
			.from(USERS)
			.join(USERS_INFO).on(
				USERS.DOMAIN_ID.equal(USERS_INFO.DOMAIN_ID).and(USERS.USER_ID.equal(USERS_INFO.USER_ID))
			)
			.where(
				USERS.DOMAIN_ID.equal(domainId)
				.and(cndtEnabled)
				.and(USERS.TYPE.equal(EnumUtils.toSerializedName(OUser.Type.RESOURCE)))
			)
			.orderBy(
				USERS.USER_ID.asc()
			)
			.fetchInto(VResource.class);
	}
	
	public Set<String> selectIdsByDomainEnabled(Connection con, String domainId, EnabledCond enabled) throws DAOException {
		DSLContext dsl = getDSL(con);
		Condition cndtEnabled = DSL.trueCondition();
		if (EnabledCond.ENABLED_ONLY.equals(enabled)) {
			cndtEnabled = USERS.ENABLED.equal(true);
		} else if (EnabledCond.DISABLED_ONLY.equals(enabled)) {
			cndtEnabled = USERS.ENABLED.equal(false);
		}
		
		return dsl
			.select(
				USERS.USER_ID
			)
			.from(USERS)
			.where(
				USERS.DOMAIN_ID.equal(domainId)
				.and(cndtEnabled)
				.and(USERS.TYPE.equal(EnumUtils.toSerializedName(OUser.Type.RESOURCE)))
			)
			.orderBy(
				USERS.USER_ID.asc()
			)
			.fetchSet(USERS.USER_ID);
	}
	
	public int insert(Connection con, OUser item) throws DAOException {
		DSLContext dsl = getDSL(con);
		item.setType(EnumUtils.toSerializedName(OUser.Type.RESOURCE));
		UsersRecord record = dsl.newRecord(USERS, item);
		return dsl
			.insertInto(USERS)
			.set(record)
			.execute();
	}
	
	public int update(Connection con, OUser item) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.update(USERS)
			.set(USERS.ENABLED, item.getEnabled())
			.set(USERS.DISPLAY_NAME, item.getDisplayName())
			.where(
				USERS.DOMAIN_ID.eq(item.getDomainId())
				.and(USERS.USER_ID.eq(item.getUserId()))
				.and(USERS.TYPE.equal(EnumUtils.toSerializedName(OUser.Type.RESOURCE)))
			)
			.execute();
	}
	
	public int insert(Connection con, OUserInfo item) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.insertInto(USERS_INFO)
			.set(USERS_INFO.DOMAIN_ID, item.getDomainId())
			.set(USERS_INFO.USER_ID, item.getUserId())
			.set(USERS_INFO.EMAIL, item.getEmail())
			//.set(USERS_INFO.TELEPHONE, item.getTelephone())
			//.set(USERS_INFO.ADDRESS, item.getAddress())
			.set(USERS_INFO.CUSTOM1, item.getCustom1())
			//.set(USERS_INFO.CUSTOM2, item.getCustom2())
			.execute();
	}
	
	public int update(Connection con, OUserInfo item) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.update(USERS_INFO)
			.set(USERS_INFO.EMAIL, item.getEmail())
			//.set(USERS_INFO.TELEPHONE, item.getTelephone())
			//.set(USERS_INFO.ADDRESS, item.getAddress())
			.set(USERS_INFO.CUSTOM1, item.getCustom1())
			//.set(USERS_INFO.CUSTOM2, item.getCustom2())
			.where(
				USERS_INFO.DOMAIN_ID.eq(item.getDomainId())
				.and(USERS_INFO.USER_ID.eq(item.getUserId()))
			)
			.execute();
	}
	
	public int updateEnabledByProfile(Connection con, String domainId, String userId, boolean enabled) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.update(USERS)
			.set(USERS.ENABLED, enabled)
			.where(
				USERS.DOMAIN_ID.equal(domainId)
				.and(USERS.USER_ID.equal(userId))
				.and(USERS.TYPE.equal(EnumUtils.toSerializedName(OUser.Type.RESOURCE)))
			)
			.execute();
	}
	
	public int deleteByDomainId(Connection con, String domainId, String resourceId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(USERS)
			.where(
				USERS.DOMAIN_ID.equal(domainId)
				.and(USERS.USER_ID.equal(resourceId))
				.and(USERS.TYPE.equal(EnumUtils.toSerializedName(OUser.Type.RESOURCE)))
			)
			.execute();
	}
}
