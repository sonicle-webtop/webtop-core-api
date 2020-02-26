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
import static com.sonicle.webtop.core.jooq.core.Tables.CUSTOM_FIELDS;
import com.sonicle.webtop.core.jooq.core.tables.records.CustomFieldsRecord;
import com.sonicle.webtop.core.model.CustomField;
import java.sql.Connection;
import java.util.Map;
import org.joda.time.DateTime;
import org.jooq.DSLContext;

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
	
	public Map<String, OCustomField> selectOnlineByDomainService(Connection con, String domainId, String serviceId) throws DAOException {
		DSLContext dsl = getDSL(con);
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
			)
			.orderBy(
				CUSTOM_FIELDS.NAME.asc()
			)
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
