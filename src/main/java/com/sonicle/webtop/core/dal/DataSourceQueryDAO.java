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

import com.sonicle.webtop.core.bol.ODataSourceQuery;
import com.sonicle.webtop.core.bol.VDataSourceQuery;
import static com.sonicle.webtop.core.jooq.core.Tables.CUSTOM_FIELDS;
import static com.sonicle.webtop.core.jooq.core.Tables.DATA_SOURCES;
import static com.sonicle.webtop.core.jooq.core.Tables.DATA_SOURCES_QUERIES;
import com.sonicle.webtop.core.jooq.core.tables.DataSourcesQueries;
import com.sonicle.webtop.core.jooq.core.tables.records.DataSourcesQueriesRecord;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import org.joda.time.DateTime;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

/**
 *
 * @author malbinola
 */
public class DataSourceQueryDAO extends BaseDAO {
	private final static DataSourceQueryDAO INSTANCE = new DataSourceQueryDAO();
	public static DataSourceQueryDAO getInstance() {
		return INSTANCE;
	}
	
	public List<ODataSourceQuery> selectByDomain(Connection con, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
				DATA_SOURCES_QUERIES.fields()
			)
			.from(DATA_SOURCES_QUERIES)
			.join(DATA_SOURCES).on(DATA_SOURCES_QUERIES.DATA_SOURCE_ID.equal(DATA_SOURCES.DATA_SOURCE_ID))
			.where(
				DATA_SOURCES.DOMAIN_ID.eq(domainId)
			)
			.orderBy(
				DATA_SOURCES_QUERIES.NAME.asc()
			)
			.fetchInto(ODataSourceQuery.class);
	}
	
	public Map<String, List<VDataSourceQuery>> mapDataSourceByDomain(Connection con, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		DataSourcesQueries DSQ1 = DATA_SOURCES_QUERIES.as("dsq1");
		return dsl
			.select(
				DATA_SOURCES_QUERIES.fields()
			)
			.select(
				DSL.selectCount()
					.from(CUSTOM_FIELDS)
					.join(DSQ1).on(CUSTOM_FIELDS.DATA_SOURCE_QUERY_ID.equal(DSQ1.QUERY_ID))
					.where(
						CUSTOM_FIELDS.DOMAIN_ID.equal(domainId)
						.and(DSQ1.QUERY_ID.equal(DATA_SOURCES_QUERIES.QUERY_ID))
					)
				.asField("usage_count")
			)
			.from(DATA_SOURCES_QUERIES)
			.join(DATA_SOURCES).on(DATA_SOURCES_QUERIES.DATA_SOURCE_ID.equal(DATA_SOURCES.DATA_SOURCE_ID))
			.where(
				DATA_SOURCES.DOMAIN_ID.eq(domainId)
			)
			.orderBy(
				DATA_SOURCES_QUERIES.NAME.asc()
			)
			.fetchGroups(DATA_SOURCES_QUERIES.DATA_SOURCE_ID, VDataSourceQuery.class);
	}
	
	public ODataSourceQuery selectByIdDomain(Connection con, String queryId, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
				DATA_SOURCES_QUERIES.fields()
			)
			.from(DATA_SOURCES_QUERIES)
			.join(DATA_SOURCES).on(DATA_SOURCES_QUERIES.DATA_SOURCE_ID.equal(DATA_SOURCES.DATA_SOURCE_ID))
			.where(
				DATA_SOURCES_QUERIES.QUERY_ID.eq(queryId)
				.and(DATA_SOURCES.DOMAIN_ID.eq(domainId)) // Forces domain membership
			)
			.fetchOneInto(ODataSourceQuery.class);
	}
	
	public int insert(Connection con, ODataSourceQuery item) throws DAOException {
		DSLContext dsl = getDSL(con);
		DataSourcesQueriesRecord record = dsl.newRecord(DATA_SOURCES_QUERIES, item);
		return dsl
			.insertInto(DATA_SOURCES_QUERIES)
			.set(record)
			.execute();
	}
	
	public int update(Connection con, ODataSourceQuery item, DateTime revisionTimestamp, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		item.setRevisionTimestamp(revisionTimestamp);
		
		return dsl
			.update(DATA_SOURCES_QUERIES)
			.set(DATA_SOURCES_QUERIES.REVISION_TIMESTAMP, item.getRevisionTimestamp())
			.set(DATA_SOURCES_QUERIES.NAME, item.getName())
			.set(DATA_SOURCES_QUERIES.DESCRIPTION, item.getDescription())
			.set(DATA_SOURCES_QUERIES.RAW_SQL, item.getRawSql())
			.set(DATA_SOURCES_QUERIES.FORCE_PAGINATION, item.getForcePagination())
			.from(DATA_SOURCES)
			.where(
				DATA_SOURCES_QUERIES.QUERY_ID.eq(item.getQueryId())
				.and(DATA_SOURCES_QUERIES.DATA_SOURCE_ID.equal(DATA_SOURCES.DATA_SOURCE_ID))
				.and(DATA_SOURCES.DOMAIN_ID.eq(domainId)) // Forces domain membership
			)
			.execute();
	}
	
	public int deleteByIdDomain(Connection con, String queryId, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(DATA_SOURCES_QUERIES)
			.using(DATA_SOURCES)
			.where(
				DATA_SOURCES_QUERIES.QUERY_ID.eq(queryId)
				.and(DATA_SOURCES_QUERIES.DATA_SOURCE_ID.equal(DATA_SOURCES.DATA_SOURCE_ID))
				.and(DATA_SOURCES.DOMAIN_ID.eq(domainId)) // Forces domain membership
			)
			.execute();
	}
}
