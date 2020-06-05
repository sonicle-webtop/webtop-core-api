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

import com.sonicle.webtop.core.bol.OLicenseLease;
import static com.sonicle.webtop.core.jooq.core.Tables.LICENSES_LEASES;
import com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jooq.DSLContext;

/**
 *
 * @author malbinola
 */
public class LicenseLeaseDAO extends BaseDAO {
	private final static LicenseLeaseDAO INSTANCE = new LicenseLeaseDAO();
	public static LicenseLeaseDAO getInstance() {
		return INSTANCE;
	}
	
	public List<OLicenseLease> selectByDomainUser(Connection con, String domainId, String userId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select()
			.from(LICENSES_LEASES)
			.where(
				LICENSES_LEASES.DOMAIN_ID.equal(domainId)
				.and(LICENSES_LEASES.USER_ID.equal(userId))
			)
			.orderBy(
				LICENSES_LEASES.USER_ID.desc()
			)
			.fetchInto(OLicenseLease.class);
	}
	
	public Set<String> selectUsersByDomainServiceProduct(Connection con, String domainId, String serviceId, String productCode) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
				LICENSES_LEASES.USER_ID
			)
			.from(LICENSES_LEASES)
			.where(
				LICENSES_LEASES.DOMAIN_ID.equal(domainId)
				.and(LICENSES_LEASES.SERVICE_ID.equal(serviceId))
				.and(LICENSES_LEASES.PRODUCT_CODE.equal(productCode))
			)
			.orderBy(
				LICENSES_LEASES.USER_ID.desc()
			)
			.fetchSet(LICENSES_LEASES.USER_ID);
	}
	
	public Map<String, String> selectByDomainServiceProduct(Connection con, String domainId, String serviceId, String productCode) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
				LICENSES_LEASES.USER_ID,
				LICENSES_LEASES.ACTIVATION_STRING
			)
			.from(LICENSES_LEASES)
			.where(
				LICENSES_LEASES.DOMAIN_ID.equal(domainId)
				.and(LICENSES_LEASES.SERVICE_ID.equal(serviceId))
				.and(LICENSES_LEASES.PRODUCT_CODE.equal(productCode))
			)
			.fetchMap(LICENSES_LEASES.USER_ID, LICENSES_LEASES.ACTIVATION_STRING);
	}
	
	/*
	public List<OLicenseLease> selectByDomainServiceProduct(Connection con, String domainId, String serviceId, String productCode) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select()
			.from(LICENSES_LEASES)
			.where(
				LICENSES_LEASES.DOMAIN_ID.equal(domainId)
				.and(LICENSES_LEASES.SERVICE_ID.equal(serviceId))
				.and(LICENSES_LEASES.PRODUCT_CODE.equal(productCode))
			)
			.fetchInto(OLicenseLease.class);
	}
	*/
	
	public String selectActivationStringByDomainServiceProductUser(Connection con, String domainId, String serviceId, String productCode, String userId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
				LICENSES_LEASES.ACTIVATION_STRING
			)
			.from(LICENSES_LEASES)
			.where(
				LICENSES_LEASES.DOMAIN_ID.equal(domainId)
				.and(LICENSES_LEASES.SERVICE_ID.equal(serviceId))
				.and(LICENSES_LEASES.PRODUCT_CODE.equal(productCode))
				.and(LICENSES_LEASES.USER_ID.equal(userId))
			)
			.fetchOneInto(String.class);
	}
	
	public int insert(Connection con, OLicenseLease item) throws DAOException {
		DSLContext dsl = getDSL(con);
		LicensesLeasesRecord record = dsl.newRecord(LICENSES_LEASES, item);
		return dsl
			.insertInto(LICENSES_LEASES)
			.set(record)
			.execute();
	}
	
	public int delete(Connection con, String domainId, String serviceId, String productCode, String userId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(LICENSES_LEASES)
			.where(
				LICENSES_LEASES.DOMAIN_ID.equal(domainId)
				.and(LICENSES_LEASES.SERVICE_ID.equal(serviceId))
				.and(LICENSES_LEASES.PRODUCT_CODE.equal(productCode))
				.and(LICENSES_LEASES.USER_ID.equal(userId))
			)
			.execute();
	}
	
	public int deleteByDomainServiceProduct(Connection con, String domainId, String serviceId, String productCode) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(LICENSES_LEASES)
			.where(
				LICENSES_LEASES.DOMAIN_ID.equal(domainId)
				.and(LICENSES_LEASES.SERVICE_ID.equal(serviceId))
				.and(LICENSES_LEASES.PRODUCT_CODE.equal(productCode))
			)
			.execute();
	}
}
