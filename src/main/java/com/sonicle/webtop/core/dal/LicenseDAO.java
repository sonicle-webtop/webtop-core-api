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

import com.sonicle.webtop.core.bol.OLicense;
import com.sonicle.webtop.core.bol.VLicense;
import static com.sonicle.webtop.core.jooq.core.Tables.*;
import com.sonicle.webtop.core.jooq.core.tables.records.LicensesRecord;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.impl.DSL;

/**
 *
 * @author gbulfon
 */
public class LicenseDAO extends BaseDAO {
	private final static LicenseDAO INSTANCE = new LicenseDAO();
	public static LicenseDAO getInstance() {
		return INSTANCE;
	}
	
	public OLicense lock(Connection con, String domainId, String serviceId, String productCode) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
				LICENSES.DOMAIN_ID,
				LICENSES.SERVICE_ID,
				LICENSES.PRODUCT_CODE
			)
			.from(LICENSES)
			.where(
				LICENSES.DOMAIN_ID.equal(domainId)
				.and(LICENSES.SERVICE_ID.equal(serviceId))
				.and(LICENSES.PRODUCT_CODE.equal(productCode))
			)
			.forUpdate()
			.fetchOneInto(OLicense.class);
	}
	
	public List<OLicense> selectAll(Connection con) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select()
			.from(LICENSES)
			.fetchInto(OLicense.class);
	}
	
	public Map<String, List<String>> groupAllLicenses(Connection con) throws DAOException {
		DSLContext dsl = getDSL(con);
		Field<String> PRODUCT_ID = DSL.concat(LICENSES.SERVICE_ID, DSL.val("|"), LICENSES.PRODUCT_CODE).as("product_id");
		return dsl
			.select(
				LICENSES.DOMAIN_ID,
				PRODUCT_ID
			)
			.from(LICENSES)
			.orderBy(
				LICENSES.DOMAIN_ID.asc(),
				LICENSES.SERVICE_ID.asc(),
				LICENSES.PRODUCT_CODE.asc()
			)
			.fetchGroups(LICENSES.DOMAIN_ID, PRODUCT_ID);
	}
	
	public List<OLicense> selectByDomain(Connection con, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select()
			.from(LICENSES)
			.where(
				LICENSES.DOMAIN_ID.equal(domainId)
			)
			.fetchInto(OLicense.class);
	}
	
	public List<VLicense> viewByDomain(Connection con, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		
		Field<String> userIds = DSL
			.select(DSL.groupConcat(LICENSES_LEASES.USER_ID, "|"))
			.from(LICENSES_LEASES)
			.where(
				LICENSES_LEASES.DOMAIN_ID.equal(LICENSES.DOMAIN_ID)
				.and(LICENSES_LEASES.SERVICE_ID.equal(LICENSES.SERVICE_ID))
				.and(LICENSES_LEASES.PRODUCT_CODE.equal(LICENSES.PRODUCT_CODE))
			)
			.asField("user_ids");
		
		return dsl
			.select(
				LICENSES.fields()
			)
			.select(
				userIds
			)
			.from(LICENSES)
			.where(
				LICENSES.DOMAIN_ID.equal(domainId)
			)
			.orderBy(
				LICENSES.SERVICE_ID.asc(),
				LICENSES.PRODUCT_CODE.asc()
			)
			.fetchInto(VLicense.class);
	}
	
	public OLicense select(Connection con, String domainId, String serviceId, String productCode) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select()
			.from(LICENSES)
			.where(
				LICENSES.DOMAIN_ID.equal(domainId)
				.and(LICENSES.SERVICE_ID.equal(serviceId))
				.and(LICENSES.PRODUCT_CODE.equal(productCode))
			)
			.fetchOneInto(OLicense.class);
	}
	
	public int insert(Connection con, OLicense item) throws DAOException {
		DSLContext dsl = getDSL(con);
		LicensesRecord record = dsl.newRecord(LICENSES, item);
		return dsl
			.insertInto(LICENSES)
			.set(record)
			.execute();
	}
	
	public int replaceLicense(Connection con, String domainId, String serviceId, String productCode, String string, LocalDate expirationDate, Integer quantity, String activatedString, DateTime revisionTimestamp, String activationHwId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.update(LICENSES)
			.set(LICENSES.STRING, string)
			.set(LICENSES.REVISION_TIMESTAMP, revisionTimestamp)
			.set(LICENSES.EXPIRATION_DATE, expirationDate)
			.set(LICENSES.QUANTITY, quantity)
			.set(LICENSES.ACTIVATED_STRING, activatedString)
			.set(LICENSES.ACTIVATION_TIMESTAMP, revisionTimestamp)
			.set(LICENSES.ACTIVATION_HW_ID, activationHwId)
			.where(
				LICENSES.DOMAIN_ID.equal(domainId)
				.and(LICENSES.SERVICE_ID.equal(serviceId))
				.and(LICENSES.PRODUCT_CODE.equal(productCode))
			)
			.execute();
	}
	
	public int updateActivation(Connection con, String domainId, String serviceId, String productCode, String activatedString, DateTime activationTimestamp, String activationHwId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.update(LICENSES)
			.set(LICENSES.ACTIVATED_STRING, activatedString)
			.set(LICENSES.ACTIVATION_TIMESTAMP, activationTimestamp)
			.set(LICENSES.ACTIVATION_HW_ID, activationHwId)
			.where(
				LICENSES.DOMAIN_ID.equal(domainId)
				.and(LICENSES.SERVICE_ID.equal(serviceId))
				.and(LICENSES.PRODUCT_CODE.equal(productCode))
			)
			.execute();
	}
	
	public int updateAutoLease(Connection con, String domainId, String serviceId, String productCode, boolean autoLease) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.update(LICENSES)
			.set(LICENSES.AUTO_LEASE, autoLease)
			.where(
				LICENSES.DOMAIN_ID.equal(domainId)
				.and(LICENSES.SERVICE_ID.equal(serviceId))
				.and(LICENSES.PRODUCT_CODE.equal(productCode))
			)
			.execute();
	}
	
	public int delete(Connection con, String domainId, String serviceId, String productCode) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(LICENSES)
			.where(
				LICENSES.DOMAIN_ID.equal(domainId)
				.and(LICENSES.SERVICE_ID.equal(serviceId))
				.and(LICENSES.PRODUCT_CODE.equal(productCode))
			)
			.execute();
	}
	
	public int deleteByDomain(Connection con, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(LICENSES)
			.where(
				LICENSES.DOMAIN_ID.eq(domainId)
			)
			.execute();
	}
	
	/*
	public List<OLicense> selectByInternetName(Connection con, String internetName) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select()
			.from(LICENSES)
			.where(
				LICENSES.INTERNET_NAME.equal(internetName)
			)
			.fetchInto(OLicense.class);
	}
	
	public OLicense select(Connection con, String serviceId, String productId, String internetName) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select()
			.from(LICENSES)
			.where(
				LICENSES.SERVICE_ID.equal(serviceId)
				.and(LICENSES.PRODUCT_ID.equal(productId))
				.and(LICENSES.INTERNET_NAME.equal(internetName))
			)
			.fetchOneInto(OLicense.class);
	}
	
	public int insert(Connection con, OLicense item) throws DAOException {
		DSLContext dsl = getDSL(con);
		LicensesRecord record = dsl.newRecord(LICENSES, item);
		return dsl
			.insertInto(LICENSES)
			.set(record)
			.execute();
	}
	
	public int update(Connection con, OLicense item) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.update(LICENSES)
			.set(LICENSES.LICENSE, item.getLicense())
			.where(
				LICENSES.SERVICE_ID.equal(item.getServiceId())
				.and(LICENSES.PRODUCT_ID.equal(item.getProductId()))
				.and(LICENSES.INTERNET_NAME.equal(item.getInternetName()))
			)
			.execute();
	}
	
	public int delete(Connection con, OLicense item) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(LICENSES)
			.where(
				LICENSES.SERVICE_ID.equal(item.getServiceId())
				.and(LICENSES.PRODUCT_ID.equal(item.getProductId()))
				.and(LICENSES.INTERNET_NAME.equal(item.getInternetName()))
			)
			.execute();
	}
	
	public int delete(Connection con, String serviceId, String productId, String internetName) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(LICENSES)
			.where(
				LICENSES.SERVICE_ID.equal(serviceId)
				.and(LICENSES.PRODUCT_ID.equal(productId))
				.and(LICENSES.INTERNET_NAME.equal(internetName))
			)
			.execute();
	}
	*/
}
