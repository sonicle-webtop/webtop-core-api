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

import com.sonicle.webtop.core.bol.OSetting;
import com.sonicle.webtop.core.bol.SettingRow;
import java.sql.Connection;
import org.jooq.DSLContext;
import static com.sonicle.webtop.core.jooq.core.Tables.*;
import com.sonicle.webtop.core.jooq.core.tables.records.*;
import java.util.List;

/**
 *
 * @author malbinola
 */
public class SettingDAO extends BaseDAO {
	
	private final static SettingDAO INSTANCE = new SettingDAO();
	public static SettingDAO getInstance() {
		return INSTANCE;
	}
	
	public List<SettingRow> selectAll(Connection con, boolean hidden) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
					SETTINGS.SERVICE_ID,
					SETTINGS.KEY,
					SETTINGS.VALUE,
					SETTINGS_DB.TYPE,
					SETTINGS_DB.HELP
			)
			.from(SETTINGS)
			.leftOuterJoin(SETTINGS_DB)
			.on(
					SETTINGS.SERVICE_ID.eq(SETTINGS_DB.SERVICE_ID)
					.and(SETTINGS.KEY.eq(SETTINGS_DB.KEY))
					.and(SETTINGS_DB.IS_SYSTEM.eq(true))
					.and(SETTINGS_DB.HIDDEN.eq(hidden))
			)
			.orderBy(
					SETTINGS.SERVICE_ID.asc(),
					SETTINGS.KEY.asc()
			)
			.fetchInto(SettingRow.class);
	}
	
	public List<OSetting> selectByService(Connection con, String serviceId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select()
			.from(SETTINGS)
			.where(
					SETTINGS.SERVICE_ID.equal(serviceId)
			)
			.orderBy(
					SETTINGS.KEY.asc()
			)
			.fetchInto(OSetting.class);
	}
	
	public OSetting selectByServiceKey(Connection con, String serviceId, String key) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select()
			.from(SETTINGS)
			.where(
					SETTINGS.SERVICE_ID.equal(serviceId)
					.and(SETTINGS.KEY.equal(key))
			)
			.fetchOneInto(OSetting.class);
	}
	
	public int insert(Connection con, OSetting item) throws DAOException {
		DSLContext dsl = getDSL(con);
		SettingsRecord record = dsl.newRecord(SETTINGS, item);
		return dsl
			.insertInto(SETTINGS)
			.set(record)
			.execute();
	}
	
	public int update(Connection con, OSetting item) throws DAOException {
		DSLContext dsl = getDSL(con);
		SettingsRecord record = dsl.newRecord(SETTINGS, item);
		return dsl
			.update(SETTINGS)
			.set(record)
			.where(SETTINGS.SERVICE_ID.equal(item.getServiceId())
				.and(SETTINGS.KEY.equal(item.getKey()))
			)
			.execute();
	}
	
	public int deleteByServiceKey(Connection con, String serviceId, String key) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(SETTINGS)
			.where(SETTINGS.SERVICE_ID.equal(serviceId)
				.and(SETTINGS.KEY.equal(key))
			)
			.execute();
	}
}
