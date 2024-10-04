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

import com.sonicle.webtop.core.sdk.WTException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

/**
 *
 * @author malbinola
 */
public class DataSourceBase {
	protected String friendlyId;
	protected DateTime revisionTimestamp;
	protected String name;
	protected String description;
	protected String type;
	protected String serverName;
	protected Integer serverPort;
	protected String databaseName;
	protected String username;
	protected String password;
	protected Map<String, String> driverProps;
	protected Map<String, String> poolProps;
	
	public String getFriendlyId() {
		return friendlyId;
	}

	public void setFriendlyId(String friendlyId) {
		this.friendlyId = friendlyId;
	}
	
	public DateTime getRevisionTimestamp() {
		return revisionTimestamp;
	}

	public void setRevisionTimestamp(DateTime revisionTimestamp) {
		this.revisionTimestamp = revisionTimestamp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public Integer getServerPort() {
		return serverPort;
	}

	public void setServerPort(Integer serverPort) {
		this.serverPort = serverPort;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, String> getDriverProps() {
		return driverProps;
	}

	public void setDriverProps(Map<String, String> driverProps) {
		this.driverProps = driverProps;
	}
	
	public Map<String, String> getPoolProps() {
		return poolProps;
	}

	public void setPoolProps(Map<String, String> poolProps) {
		this.poolProps = poolProps;
	}
	
	public String getDriverPropsAsString() {
		Map<String, String> map = getDriverProps();
		if (map == null) return null;
		
		List<String> params = new ArrayList<>(map.size());
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (!StringUtils.isBlank(entry.getKey())) {
				params.add(entry.getKey() + "=" + entry.getValue());
			}
		}
		return StringUtils.join(params, ",");
	}
	
	public String getPoolPropsAsString() {
		Map<String, String> map = getPoolProps();
		if (map == null) return null;
		
		List<String> params = new ArrayList<>(map.size());
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (!StringUtils.isBlank(entry.getKey())) {
				params.add(entry.getKey() + "=" + entry.getValue());
			}
		}
		return StringUtils.join(params, ",");
	}
	
	public static class WTPoolException extends WTException {
		public WTPoolException(Throwable cause) {
			super(cause);
		}
		
		public WTPoolException(String message, Object... arguments) {
			super(message, arguments);
		}
	}
	
	public static class ExecuteQueryResult<T> {
		public final boolean success;
		public final String message;
		public T resultSet;
		public final Integer totalCount;
		
		public ExecuteQueryResult(boolean success, String message, T resultSet, Long totalCount) {
			this(success, message, resultSet, totalCount != null ? totalCount.intValue() : null);
		}
		
		public ExecuteQueryResult(boolean success, String message, T resultSet, Integer totalCount) {
			this.success = success;
			this.message = message;
			this.resultSet = resultSet;
			this.totalCount = totalCount;
		}
	}
}
