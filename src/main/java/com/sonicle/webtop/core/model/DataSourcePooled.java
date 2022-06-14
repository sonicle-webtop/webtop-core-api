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
package com.sonicle.webtop.core.model;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author malbinola
 */
public class DataSourcePooled extends DataSource {
	protected PoolStatus poolStatus;
	protected Map<String, Query> queries = new LinkedHashMap<>();
	
	public DataSourcePooled(String dialectMime, PoolStatus poolStatus) {
		super(dialectMime);
		this.poolStatus = poolStatus;
	}

	public PoolStatus getPoolStatus() {
		return poolStatus;
	}
	
	public Map<String, Query> getQueries() {
		return queries;
	}
	
	public void setQueries(Map<String, Query> queries) {
		this.queries = queries;
	}
	
	public void setQueries(Collection<DataSourceQuery> queries) {
		this.queries = queries.stream()
			.filter(item -> StringUtils.equals(item.getDataSourceId(), this.getDataSourceId()))
			.collect(Collectors.toMap(item -> item.getDataSourceId(), item -> new Query(item), (ov, nv) -> nv, LinkedHashMap::new));
	}
	
	public static class PoolStatus {
		public final Integer size;
		public final Integer active;
		public final Integer free;
		
		public PoolStatus(Integer size, Integer active, Integer free) {
			this.size = size;
			this.active = active;
			this.free = free;
		}
	}
	
	public static class Query {
		private final String queryId;
		private final String name;
		private final String description;
		private final Integer usage;
		
		public Query(DataSourceQuery query) {
			this(query.getQueryId(), query.getName(), query.getDescription(), null);
		}
		
		public Query(String queryId, String name, String description, Integer usage) {
			this.queryId = queryId;
			this.name = name;
			this.description = description;
			this.usage = usage;
		}

		public String getQueryId() {
			return queryId;
		}

		public String getName() {
			return name;
		}

		public String getDescription() {
			return description;
		}
		
		public Integer getUsage() {
			return usage;
		}
	}
}
