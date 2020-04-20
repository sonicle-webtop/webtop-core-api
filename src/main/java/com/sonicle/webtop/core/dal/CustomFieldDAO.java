/*
 * Copyright (C) 2019 Sonicle S.r.l.
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
 * display the words "Copyright (C) 2019 Sonicle S.r.l.".
 */
package com.sonicle.webtop.core.dal;

import com.sonicle.commons.EnumUtils;
import com.sonicle.commons.IdentifierUtils;
import com.sonicle.webtop.core.bol.OCustomField;
import com.sonicle.webtop.core.bol.VCustomField;
import static com.sonicle.webtop.core.jooq.core.Tables.CUSTOM_FIELDS;
import static com.sonicle.webtop.core.jooq.core.Tables.CUSTOM_PANELS_FIELDS;
import com.sonicle.webtop.core.jooq.core.tables.records.CustomFieldsRecord;
import com.sonicle.webtop.core.model.CustomField;
import java.sql.Connection;
import java.util.Map;
import java.util.Set;
import org.joda.time.DateTime;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Param;
import org.jooq.Table;
import org.jooq.impl.DSL;

/**
 *
 * @author malbinola
 */
public class CustomFieldDAO extends BaseDAO {
	private final static CustomFieldDAO INSTANCE = new CustomFieldDAO();
	public static CustomFieldDAO getInstance() {
		return INSTANCE;
	}
	
	public String generateCustomFieldId() {
		return IdentifierUtils.getTimeBasedShortID();
	}
	
	public Map<String, String> viewOnlineTypeByDomainService(Connection con, String domainId, String serviceId) throws DAOException {
		return viewOnlineTypeByDomainServiceSearchable(con, domainId, serviceId, null);
	}
	
	public Map<String, String> viewOnlineTypeByDomainServiceSearchable(Connection con, String domainId, String serviceId, Boolean searchable) throws DAOException {
		DSLContext dsl = getDSL(con);
		
		Condition searchableCndt = DSL.trueCondition();
		if (searchable != null) {
			searchableCndt = (searchable == true) ? CUSTOM_FIELDS.SEARCHABLE.isTrue() : CUSTOM_FIELDS.SEARCHABLE.isFalse();
		}
		
		return dsl
			.select(
				CUSTOM_FIELDS.CUSTOM_FIELD_ID,
				CUSTOM_FIELDS.TYPE
			)
			.from(CUSTOM_FIELDS)
			.where(
				CUSTOM_FIELDS.DOMAIN_ID.equal(domainId)
				.and(CUSTOM_FIELDS.SERVICE_ID.equal(serviceId))
				.and(
					CUSTOM_FIELDS.REVISION_STATUS.equal(EnumUtils.toSerializedName(CustomField.RevisionStatus.NEW))
					.or(CUSTOM_FIELDS.REVISION_STATUS.equal(EnumUtils.toSerializedName(CustomField.RevisionStatus.MODIFIED)))
				)
				.and(searchableCndt)
			)
			.orderBy(
				CUSTOM_FIELDS.NAME.asc()
			)
			.fetchMap(CUSTOM_FIELDS.CUSTOM_FIELD_ID, CUSTOM_FIELDS.TYPE);
	}
	
	public Map<String, VCustomField> viewOnlineByDomainService(Connection con, String domainId, String serviceId, int limit) throws DAOException {
		return viewOnlineByDomainServiceSearchablePreviewable(con, domainId, serviceId, null, null, limit);
	}
	
	public Map<String, VCustomField> viewOnlineByDomainServiceSearchablePreviewable(Connection con, String domainId, String serviceId, Boolean searchable, Boolean previewable, int limit) throws DAOException {
		DSLContext dsl = getDSL(con);
		
		Condition searchableCndt = DSL.trueCondition();
		if (searchable != null) {
			searchableCndt = (searchable == true) ? CUSTOM_FIELDS.SEARCHABLE.isTrue() : CUSTOM_FIELDS.SEARCHABLE.isFalse();
		}
		Condition previewableCndt = DSL.trueCondition();
		if (previewable != null) {
			previewableCndt = (previewable == true) ? CUSTOM_FIELDS.PREVIEWABLE.isTrue() : CUSTOM_FIELDS.PREVIEWABLE.isFalse();
		}
		
		Table<?> cpfinner = DSL
			.selectDistinct(
				CUSTOM_PANELS_FIELDS.CUSTOM_PANEL_ID
			)
			.from(CUSTOM_PANELS_FIELDS)
			.where(
				CUSTOM_PANELS_FIELDS.CUSTOM_FIELD_ID.equal(CUSTOM_FIELDS.CUSTOM_FIELD_ID)
			)
			.asTable("cpfinner");
		
		Field<String> customPanelIds = DSL
			.select(DSL.groupConcat(cpfinner.field("custom_panel_id"), "|"))
			.from(cpfinner)
			.asField("custom_panel_ids");
		
		return dsl
			.select(
				CUSTOM_FIELDS.fields()
			)
			.select(
				customPanelIds
			)
			.from(CUSTOM_FIELDS)
			.where(
				CUSTOM_FIELDS.DOMAIN_ID.equal(domainId)
				.and(CUSTOM_FIELDS.SERVICE_ID.equal(serviceId))
				.and(
					CUSTOM_FIELDS.REVISION_STATUS.equal(EnumUtils.toSerializedName(CustomField.RevisionStatus.NEW))
					.or(CUSTOM_FIELDS.REVISION_STATUS.equal(EnumUtils.toSerializedName(CustomField.RevisionStatus.MODIFIED)))
				)
				.and(searchableCndt)
				.and(previewableCndt)
			)
			.orderBy(
				CUSTOM_FIELDS.NAME.asc()
			)
			.limit(limit == -1 ? (Param)null : DSL.inline(limit, Integer.class))
			.fetchMap(CUSTOM_FIELDS.CUSTOM_FIELD_ID, VCustomField.class);
	}
	
	
	public Set<String> viewOnlineIdsByDomainServiceSearchablePreviewable(Connection con, String domainId, String serviceId, Boolean searchable, Boolean previewable, int limit) throws DAOException {
		DSLContext dsl = getDSL(con);
		
		Condition searchableCndt = DSL.trueCondition();
		if (searchable != null) {
			searchableCndt = (searchable == true) ? CUSTOM_FIELDS.SEARCHABLE.isTrue() : CUSTOM_FIELDS.SEARCHABLE.isFalse();
		}
		Condition previewableCndt = DSL.trueCondition();
		if (previewable != null) {
			previewableCndt = (previewable == true) ? CUSTOM_FIELDS.PREVIEWABLE.isTrue() : CUSTOM_FIELDS.PREVIEWABLE.isFalse();
		}
		
		return dsl
			.select(
				CUSTOM_FIELDS.CUSTOM_FIELD_ID
			)
			.from(CUSTOM_FIELDS)
			.where(
				CUSTOM_FIELDS.DOMAIN_ID.equal(domainId)
				.and(CUSTOM_FIELDS.SERVICE_ID.equal(serviceId))
				.and(
					CUSTOM_FIELDS.REVISION_STATUS.equal(EnumUtils.toSerializedName(CustomField.RevisionStatus.NEW))
					.or(CUSTOM_FIELDS.REVISION_STATUS.equal(EnumUtils.toSerializedName(CustomField.RevisionStatus.MODIFIED)))
				)
				.and(searchableCndt)
				.and(previewableCndt)
			)
			.orderBy(
				CUSTOM_FIELDS.NAME.asc()
			)
			.limit(limit == -1 ? (Param)null : DSL.inline(limit, Integer.class))
			.fetchSet(CUSTOM_FIELDS.CUSTOM_FIELD_ID);
	}
	
	public Map<String, OCustomField> selectOnlineByDomainService(Connection con, String domainId, String serviceId, int limit) throws DAOException {
		return selectOnlineByDomainServiceSearchable(con, domainId, serviceId, null, limit);
	}
	
	public Map<String, OCustomField> selectOnlineByDomainServiceSearchable(Connection con, String domainId, String serviceId, Boolean searchable, int limit) throws DAOException {
		DSLContext dsl = getDSL(con);
		Condition searchableCndt = DSL.trueCondition();
		if (searchable != null) {
			searchableCndt = (searchable == true) ? CUSTOM_FIELDS.SEARCHABLE.isTrue() : CUSTOM_FIELDS.SEARCHABLE.isFalse();
		}
		
		return dsl
			.select()
			.from(CUSTOM_FIELDS)
			.where(
				CUSTOM_FIELDS.DOMAIN_ID.equal(domainId)
				.and(CUSTOM_FIELDS.SERVICE_ID.equal(serviceId))
				.and(
					CUSTOM_FIELDS.REVISION_STATUS.equal(EnumUtils.toSerializedName(CustomField.RevisionStatus.NEW))
					.or(CUSTOM_FIELDS.REVISION_STATUS.equal(EnumUtils.toSerializedName(CustomField.RevisionStatus.MODIFIED)))
				)
				.and(searchableCndt)
			)
			.orderBy(
				CUSTOM_FIELDS.NAME.asc()
			)
			.limit(limit == -1 ? (Param)null : DSL.inline(limit, Integer.class))
			.fetchMap(CUSTOM_FIELDS.CUSTOM_FIELD_ID, OCustomField.class);
	}
	
	public Map<String, OCustomField> selectOfflineByDomainService(Connection con, String domainId, String serviceId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select()
			.from(CUSTOM_FIELDS)
			.where(
				CUSTOM_FIELDS.DOMAIN_ID.equal(domainId)
				.and(CUSTOM_FIELDS.SERVICE_ID.equal(serviceId))
				.and(CUSTOM_FIELDS.REVISION_STATUS.equal(EnumUtils.toSerializedName(CustomField.RevisionStatus.DELETED)))
			)
			.orderBy(
				CUSTOM_FIELDS.NAME.asc()
			)
			.fetchMap(CUSTOM_FIELDS.CUSTOM_FIELD_ID, OCustomField.class);
	}
	
	public OCustomField selectByDomainService(Connection con, String domainId, String serviceId, String customFieldId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select()
			.from(CUSTOM_FIELDS)
			.where(
				CUSTOM_FIELDS.CUSTOM_FIELD_ID.equal(customFieldId)
				.and(CUSTOM_FIELDS.DOMAIN_ID.equal(domainId))
				.and(CUSTOM_FIELDS.SERVICE_ID.equal(serviceId))
			)
			.fetchOneInto(OCustomField.class);
	}
	
	public int insert(Connection con, OCustomField item, DateTime revisionTimestamp) throws DAOException {
		DSLContext dsl = getDSL(con);
		item.setRevisionStatus(EnumUtils.toSerializedName(CustomField.RevisionStatus.NEW));
		item.setRevisionTimestamp(revisionTimestamp);
		item.setCreationTimestamp(revisionTimestamp);
		
		CustomFieldsRecord record = dsl.newRecord(CUSTOM_FIELDS, item);
		return dsl
			.insertInto(CUSTOM_FIELDS)
			.set(record)
			.execute();
	}
	
	public int update(Connection con, OCustomField item, DateTime revisionTimestamp) throws DAOException {
		DSLContext dsl = getDSL(con);
		item.setRevisionStatus(EnumUtils.toSerializedName(CustomField.RevisionStatus.MODIFIED));
		item.setRevisionTimestamp(revisionTimestamp);
		
		return dsl
			.update(CUSTOM_FIELDS)
			.set(CUSTOM_FIELDS.REVISION_STATUS, item.getRevisionStatus())
			.set(CUSTOM_FIELDS.REVISION_TIMESTAMP, item.getRevisionTimestamp())
			.set(CUSTOM_FIELDS.NAME, item.getName())
			.set(CUSTOM_FIELDS.DESCRIPTION, item.getDescription())
			.set(CUSTOM_FIELDS.TYPE, item.getType())
			.set(CUSTOM_FIELDS.SEARCHABLE, item.getSearchable())
			.set(CUSTOM_FIELDS.PREVIEWABLE, item.getPreviewable())
			.set(CUSTOM_FIELDS.PROPERTIES, item.getProperties())
			.set(CUSTOM_FIELDS.VALUES, item.getValues())
			.set(CUSTOM_FIELDS.LABEL_I18N, item.getLabelI18n())
			.where(
				CUSTOM_FIELDS.DOMAIN_ID.equal(item.getDomainId())
				.and(CUSTOM_FIELDS.SERVICE_ID.equal(item.getServiceId()))
				.and(CUSTOM_FIELDS.CUSTOM_FIELD_ID.equal(item.getCustomFieldId()))
			)
			.execute();
	}
	
	public int deleteByDomain(Connection con, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(CUSTOM_FIELDS)
			.where(
				CUSTOM_FIELDS.DOMAIN_ID.equal(domainId)
			)
			.execute();
	}
	
	public int logicDeleteByDomainServiceId(Connection con, String domainId, String serviceId, String fieldId , DateTime revisionTimestamp) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.update(CUSTOM_FIELDS)
			.set(CUSTOM_FIELDS.REVISION_STATUS, EnumUtils.toSerializedName(CustomField.RevisionStatus.DELETED))
			.set(CUSTOM_FIELDS.REVISION_TIMESTAMP, revisionTimestamp)
			.where(
				CUSTOM_FIELDS.DOMAIN_ID.equal(domainId)
				.and(CUSTOM_FIELDS.SERVICE_ID.equal(serviceId))
				.and(CUSTOM_FIELDS.CUSTOM_FIELD_ID.equal(fieldId))
			)
			.execute();
	}
}
