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

import com.sonicle.commons.IdentifierUtils;
import com.sonicle.webtop.core.bol.OCustomPanel;
import com.sonicle.webtop.core.bol.VCustomPanel;
import static com.sonicle.webtop.core.jooq.core.Tables.CUSTOM_PANELS;
import static com.sonicle.webtop.core.jooq.core.Tables.CUSTOM_PANELS_FIELDS;
import static com.sonicle.webtop.core.jooq.core.Tables.CUSTOM_PANELS_TAGS;
import com.sonicle.webtop.core.jooq.core.tables.CustomPanels;
import java.sql.Connection;
import java.util.Collection;
import java.util.Map;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.impl.DSL;

/**
 *
 * @author malbinola
 */
public class CustomPanelDAO extends BaseDAO {
	private final static CustomPanelDAO INSTANCE = new CustomPanelDAO();
	public static CustomPanelDAO getInstance() {
		return INSTANCE;
	}
	
	public String generateCustomPanelId() {
		return IdentifierUtils.getTimeBasedShortID();
	}
	
	/*
	public Map<String, OCustomPanel> selectByDomainService(Connection con, String domainId, String serviceId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select()
			.from(CUSTOM_PANELS)
			.where(
				CUSTOM_PANELS.DOMAIN_ID.equal(domainId)
				.and(CUSTOM_PANELS.SERVICE_ID.equal(serviceId))
			)
			.orderBy(
				CUSTOM_PANELS.NAME.asc(),
				CUSTOM_PANELS.CUSTOM_PANEL_ID.asc()
			)
			.fetchMap(CUSTOM_PANELS.CUSTOM_PANEL_ID, OCustomPanel.class);
	}
	*/
	
	public Map<String, VCustomPanel> viewUsedByDomainServiceTags(Connection con, String domainId, String serviceId, Collection<String> usedByTagIds) throws DAOException {
		DSLContext dsl = getDSL(con);
		
		Field<String> customFieldIds = DSL
			.select(DSL.groupConcat(CUSTOM_PANELS_FIELDS.CUSTOM_FIELD_ID, "|"))
			.from(CUSTOM_PANELS_FIELDS)
			.where(
				CUSTOM_PANELS_FIELDS.CUSTOM_PANEL_ID.equal(CUSTOM_PANELS.CUSTOM_PANEL_ID)
			).asField("custom_field_ids");
		
		Field<String> tagIds = DSL
			.select(DSL.groupConcat(CUSTOM_PANELS_TAGS.TAG_ID, "|"))
			.from(CUSTOM_PANELS_TAGS)
			.where(
				CUSTOM_PANELS_TAGS.CUSTOM_PANEL_ID.equal(CUSTOM_PANELS.CUSTOM_PANEL_ID)
			).asField("tag_ids");
		
		Condition cndtTags = DSL.notExists(
			DSL.selectOne()
			.from(CUSTOM_PANELS_TAGS)
			.where(
				CUSTOM_PANELS_TAGS.CUSTOM_PANEL_ID.equal(CUSTOM_PANELS.CUSTOM_PANEL_ID)
			)
		);
		if (!usedByTagIds.isEmpty()) {
			cndtTags = cndtTags.or(
				DSL.exists(
					DSL.selectOne()
					.from(CUSTOM_PANELS_TAGS)
					.where(
						CUSTOM_PANELS_TAGS.CUSTOM_PANEL_ID.equal(CUSTOM_PANELS.CUSTOM_PANEL_ID)
						.and(CUSTOM_PANELS_TAGS.TAG_ID.in(usedByTagIds))
					)
				)
			);
		}
		
		return dsl
			.select(
				CUSTOM_PANELS.fields()
			)
			.select(
				customFieldIds,
				tagIds
			)
			.from(CUSTOM_PANELS)
			.where(
				CUSTOM_PANELS.DOMAIN_ID.equal(domainId)
				.and(CUSTOM_PANELS.SERVICE_ID.equal(serviceId))
				.and(
					DSL.notExists(
						DSL.selectOne()
						.from(CUSTOM_PANELS_TAGS)
						.where(
							CUSTOM_PANELS_TAGS.CUSTOM_PANEL_ID.equal(CUSTOM_PANELS.CUSTOM_PANEL_ID)
						)
					)
					.or(cndtTags)
				)
			)
			.orderBy(
				CUSTOM_PANELS.ORDER.asc(),
				CUSTOM_PANELS.NAME.asc()
			)
			.fetchMap(CUSTOM_PANELS.CUSTOM_PANEL_ID, VCustomPanel.class);
	}
	
	public Map<String, VCustomPanel> viewByDomainService(Connection con, String domainId, String serviceId) throws DAOException {
		DSLContext dsl = getDSL(con);
		
		Field<String> customFieldIds = DSL
			.select(DSL.groupConcat(CUSTOM_PANELS_FIELDS.CUSTOM_FIELD_ID, "|"))
			.from(CUSTOM_PANELS_FIELDS)
			.where(
				CUSTOM_PANELS_FIELDS.CUSTOM_PANEL_ID.equal(CUSTOM_PANELS.CUSTOM_PANEL_ID)
			).asField("custom_field_ids");
		
		Field<String> tagIds = DSL
			.select(DSL.groupConcat(CUSTOM_PANELS_TAGS.TAG_ID, "|"))
			.from(CUSTOM_PANELS_TAGS)
			.where(
				CUSTOM_PANELS_TAGS.CUSTOM_PANEL_ID.equal(CUSTOM_PANELS.CUSTOM_PANEL_ID)
			).asField("tag_ids");
		
		return dsl
			.select(
				CUSTOM_PANELS.fields()
			)
			.select(
				customFieldIds,
				tagIds
			)
			.from(CUSTOM_PANELS)
			.where(
				CUSTOM_PANELS.DOMAIN_ID.equal(domainId)
				.and(CUSTOM_PANELS.SERVICE_ID.equal(serviceId))
			)
			.orderBy(
				CUSTOM_PANELS.ORDER.asc(),
				CUSTOM_PANELS.NAME.asc()
			)
			.fetchMap(CUSTOM_PANELS.CUSTOM_PANEL_ID, VCustomPanel.class);
	}
	
	public OCustomPanel selectByDomainService(Connection con, String domainId, String serviceId, String customPanelId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select()
			.from(CUSTOM_PANELS)
			.where(
				CUSTOM_PANELS.CUSTOM_PANEL_ID.equal(customPanelId)
				.and(CUSTOM_PANELS.DOMAIN_ID.equal(domainId))
				.and(CUSTOM_PANELS.SERVICE_ID.equal(serviceId))
			)
			.fetchOneInto(OCustomPanel.class);
	}
	
	public int insert(Connection con, OCustomPanel item) throws DAOException {
		DSLContext dsl = getDSL(con);
		
		CustomPanels CP_2 = CUSTOM_PANELS.as("cp2");
		Field<Short> nextOrder = DSL
			.select(DSL.coalesce(DSL.max(CP_2.ORDER), -1).plus(1))
			.from(CP_2)
			.where(
				CP_2.DOMAIN_ID.equal(item.getDomainId())
				.and(CP_2.SERVICE_ID.equal(item.getServiceId()))
			).asField();
		
		return dsl
			.insertInto(CUSTOM_PANELS)
			.set(CUSTOM_PANELS.CUSTOM_PANEL_ID, item.getCustomPanelId())
			.set(CUSTOM_PANELS.DOMAIN_ID, item.getDomainId())
			.set(CUSTOM_PANELS.SERVICE_ID, item.getServiceId())
			.set(CUSTOM_PANELS.ORDER, nextOrder)
			.set(CUSTOM_PANELS.NAME, item.getName())
			.set(CUSTOM_PANELS.DESCRIPTION, item.getDescription())
			.set(CUSTOM_PANELS.TITLE_I18N, item.getTitleI18n())
			.execute();
	}
	
	public int update(Connection con, OCustomPanel item) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.update(CUSTOM_PANELS)
			.set(CUSTOM_PANELS.NAME, item.getName())
			.set(CUSTOM_PANELS.DESCRIPTION, item.getDescription())
			.set(CUSTOM_PANELS.TITLE_I18N, item.getTitleI18n())
			.where(
				CUSTOM_PANELS.CUSTOM_PANEL_ID.equal(item.getCustomPanelId())
				.and(CUSTOM_PANELS.DOMAIN_ID.equal(item.getDomainId()))
				.and(CUSTOM_PANELS.SERVICE_ID.equal(item.getServiceId()))
			)
			.execute();
	}
	
	public int updateOrder(Connection con, String domainId, String serviceId, String customPanelId, short order) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.update(CUSTOM_PANELS)
			.set(CUSTOM_PANELS.ORDER, order)
			.where(
				CUSTOM_PANELS.CUSTOM_PANEL_ID.equal(customPanelId)
				.and(CUSTOM_PANELS.DOMAIN_ID.equal(domainId))
				.and(CUSTOM_PANELS.SERVICE_ID.equal(serviceId))
			)
			.execute();
	}
	
	public int deleteByDomain(Connection con, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(CUSTOM_PANELS)
			.where(
				CUSTOM_PANELS.DOMAIN_ID.equal(domainId)
			)
			.execute();
	}
	
	public int deleteByDomainServicePanel(Connection con, String domainId, String serviceId, String customPanelId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(CUSTOM_PANELS)
			.where(
				CUSTOM_PANELS.CUSTOM_PANEL_ID.equal(customPanelId)
				.and(CUSTOM_PANELS.DOMAIN_ID.equal(domainId))
				.and(CUSTOM_PANELS.SERVICE_ID.equal(serviceId))
			)
			.execute();
	}
}
