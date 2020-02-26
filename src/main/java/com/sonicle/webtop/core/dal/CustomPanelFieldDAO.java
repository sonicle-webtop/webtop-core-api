/*
 * Copyright (C) 2020 Sonicle S.r.l.
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
 * display the words "Copyright (C) 2020 Sonicle S.r.l.".
 */
package com.sonicle.webtop.core.dal;

import static com.sonicle.webtop.core.jooq.core.Tables.CUSTOM_PANELS_FIELDS;
import java.sql.Connection;
import java.util.Collection;
import java.util.Set;
import org.jooq.BatchBindStep;
import org.jooq.DSLContext;

/**
 *
 * @author malbinola
 */
public class CustomPanelFieldDAO extends BaseDAO {
	private final static CustomPanelFieldDAO INSTANCE = new CustomPanelFieldDAO();
	public static CustomPanelFieldDAO getInstance() {
		return INSTANCE;
	}
	
	public Set<String> selectFieldsByPanel(Connection con, String customPanelId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
				CUSTOM_PANELS_FIELDS.CUSTOM_FIELD_ID
			)
			.from(CUSTOM_PANELS_FIELDS)
			.where(
				CUSTOM_PANELS_FIELDS.CUSTOM_PANEL_ID.equal(customPanelId)
			)
			.orderBy(
				CUSTOM_PANELS_FIELDS.ORDER.asc()
			)
			.fetchSet(CUSTOM_PANELS_FIELDS.CUSTOM_FIELD_ID);
	}
	
	public int[] batchInsert(Connection con, String customPanelId, Collection<String> customFieldIds) throws DAOException {
		DSLContext dsl = getDSL(con);
		BatchBindStep batch = dsl.batch(
			dsl.insertInto(CUSTOM_PANELS_FIELDS, 
				CUSTOM_PANELS_FIELDS.CUSTOM_PANEL_ID, 
				CUSTOM_PANELS_FIELDS.CUSTOM_FIELD_ID,
				CUSTOM_PANELS_FIELDS.ORDER
			)
			.values((String)null, null, null)
		);
		int order = 0;
		for (String customFieldId : customFieldIds) {
			batch.bind(
				customPanelId,
				customFieldId,
				order
			);
			order++;
		}
		return batch.execute();
	}
	
	public int deleteByPanel(Connection con, String customPanelId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(CUSTOM_PANELS_FIELDS)
			.where(
				CUSTOM_PANELS_FIELDS.CUSTOM_PANEL_ID.equal(customPanelId)
			)
			.execute();
	}
}
