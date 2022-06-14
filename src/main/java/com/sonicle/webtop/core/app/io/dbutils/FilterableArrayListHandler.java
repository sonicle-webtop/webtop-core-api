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
package com.sonicle.webtop.core.app.io.dbutils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.RowProcessor;

/**
 *
 * @author malbinola
 */
public class FilterableArrayListHandler implements ResultSetHandler<RowsAndCols> {
	protected final Set<String> columnNames;
	protected final RowProcessor convert;
	
	public FilterableArrayListHandler() {
		this(null);
	}
	
	public FilterableArrayListHandler(final Set<String> columnNames) {
		this.columnNames = columnNames;
		this.convert = new FilterableRowProcessor(columnNames);
	}
	
	protected static Set<String> extractColumnNames(ResultSetMetaData rsmd) throws SQLException {
		final int cols = rsmd.getColumnCount();
		Set<String> result = new LinkedHashSet<>(cols);
		
		for (int i = 1; i <= cols; i++) {
			String columnName = rsmd.getColumnLabel(i);
			if (null == columnName || 0 == columnName.length()) {
				columnName = rsmd.getColumnName(i);
			}
			result.add(columnName);
		}
		return result;
	}

	@Override
	public RowsAndCols handle(ResultSet rs) throws SQLException {
		final List<Object[]> rows = new ArrayList<>();
		while (rs.next()) {
			rows.add(this.convert.toArray(rs));
		}
		final Set<String> cols = (columnNames != null) ? columnNames : extractColumnNames(rs.getMetaData());
		return new RowsAndCols(rows, cols);
		
		/*
		ResultSetMetaData rsmd = rs.getMetaData();
		String[] columns = new String[rsmd.getColumnCount()];
		for (int i = 0; i < columns.length; i++) {
			columns[i] = rsmd.getColumnLabel(i+1);
		}
		final List<Object[]> rows = new ArrayList<>();
		while (rs.next()) {
			rows.add(this.convert.toArray(rs));
		}
		return new RowsAndCols(rows, columns);
		*/
	}
}
