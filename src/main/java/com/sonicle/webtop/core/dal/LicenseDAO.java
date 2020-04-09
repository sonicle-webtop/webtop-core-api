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
import static com.sonicle.webtop.core.jooq.core.Tables.*;
import com.sonicle.webtop.core.jooq.core.tables.records.LicensesRecord;
import java.sql.Connection;
import java.util.List;
import org.jooq.DSLContext;

/**
 *
 * @author gbulfon
 */
public class LicenseDAO extends BaseDAO {
	private final static LicenseDAO INSTANCE = new LicenseDAO();
	public static LicenseDAO getInstance() {
		return INSTANCE;
	}
	
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
}