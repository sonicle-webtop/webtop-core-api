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

import com.sonicle.webtop.core.bol.ODataSource;
import static com.sonicle.webtop.core.jooq.core.Tables.DATA_SOURCES;
import com.sonicle.webtop.core.jooq.core.tables.records.DataSourcesRecord;
import java.sql.Connection;
import java.util.List;
import org.joda.time.DateTime;
import org.jooq.DSLContext;
import org.jooq.UpdateSetMoreStep;

/**
 *
 * @author malbinola
 */
public class DataSourceDAO extends BaseDAO {
	private final static DataSourceDAO INSTANCE = new DataSourceDAO();
	public static DataSourceDAO getInstance() {
		return INSTANCE;
	}
	
	public List<ODataSource> selectAll(Connection con) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select()
			.from(DATA_SOURCES)
			.orderBy(
				DATA_SOURCES.NAME.asc()
			)
			.fetchInto(ODataSource.class);
	}
	
	public List<ODataSource> selectByDomain(Connection con, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select()
			.from(DATA_SOURCES)
			.where(
				DATA_SOURCES.DOMAIN_ID.eq(domainId)
			)
			.orderBy(
				DATA_SOURCES.NAME.asc()
			)
			.fetchInto(ODataSource.class);
	}
	
	public boolean existByIdDomain(Connection con, String dataSourceId, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.selectCount()
			.from(DATA_SOURCES)
			.where(
				DATA_SOURCES.DATA_SOURCE_ID.eq(dataSourceId)
				.and(DATA_SOURCES.DOMAIN_ID.eq(domainId)) // Forces domain membership
			)
			.fetchOne(0, Integer.class) == 1;
	}
	
	public ODataSource selectByIdDomain(Connection con, String dataSourceId, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select()
			.from(DATA_SOURCES)
			.where(
				DATA_SOURCES.DATA_SOURCE_ID.eq(dataSourceId)
				.and(DATA_SOURCES.DOMAIN_ID.eq(domainId)) // Forces domain membership
			)
			.fetchOneInto(ODataSource.class);
	}
	
	public int insert(Connection con, ODataSource item) throws DAOException {
		DSLContext dsl = getDSL(con);
		DataSourcesRecord record = dsl.newRecord(DATA_SOURCES, item);
		return dsl
			.insertInto(DATA_SOURCES)
			.set(record)
			.execute();
	}
	
	public int update(Connection con, ODataSource item, boolean setPassword, DateTime revisionTimestamp) throws DAOException {
		DSLContext dsl = getDSL(con);
		item.setRevisionTimestamp(revisionTimestamp);
		
		UpdateSetMoreStep update = dsl
			.update(DATA_SOURCES)
			.set(DATA_SOURCES.REVISION_TIMESTAMP, item.getRevisionTimestamp())
			.set(DATA_SOURCES.NAME, item.getName())
			.set(DATA_SOURCES.DESCRIPTION, item.getName())
			.set(DATA_SOURCES.TYPE, item.getType())
			.set(DATA_SOURCES.SERVER_NAME, item.getServerName())
			.set(DATA_SOURCES.SERVER_PORT, item.getServerPort())
			.set(DATA_SOURCES.DATABASE_NAME, item.getDatabaseName())
			.set(DATA_SOURCES.USERNAME, item.getUsername())
			.set(DATA_SOURCES.DRIVER_RAW_PROPS, item.getDriverRawProps())
			.set(DATA_SOURCES.POOL_RAW_PROPS, item.getPoolRawProps());
		if (setPassword) {
			update = update
				.set(DATA_SOURCES.PASSWORD, item.getPassword());
		}
		return update
			.where(
				DATA_SOURCES.DATA_SOURCE_ID.eq(item.getDataSourceId())
				.and(DATA_SOURCES.DOMAIN_ID.eq(item.getDomainId())) // Forces domain membership
			)
			.execute();
	}
	
	public int deleteByDomain(Connection con, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(DATA_SOURCES)
			.where(
				DATA_SOURCES.DOMAIN_ID.eq(domainId)
			)
			.execute();
	}
	
	public int deleteByIdDomain(Connection con, String dataSourceId, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(DATA_SOURCES)
			.where(
				DATA_SOURCES.DATA_SOURCE_ID.eq(dataSourceId)
				.and(DATA_SOURCES.DOMAIN_ID.eq(domainId)) // Forces domain membership
			)
			.execute();
	}
}
