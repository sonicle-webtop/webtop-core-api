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
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.apache.commons.dbutils.BasicRowProcessor;

/**
 *
 * @author malbinola
 */
public class FilterableRowProcessor extends BasicRowProcessor {
	protected final Set<String> columnNames;
	
	public FilterableRowProcessor() {
		this(null);
	}
	
	public FilterableRowProcessor(final Set<String> columnNames) {
		super();
		this.columnNames = columnNames;
	}
	
	protected static Map<String, Object> createCaseInsensitiveHashMap(final int cols) {
		return new CaseInsensitiveHashMap(cols);
	}

	@Override
	public Object[] toArray(ResultSet rs) throws SQLException {
		if (columnNames != null) {
			final Object[] result = new Object[columnNames.size()];
			int i = 0;
			for (String columnName : columnNames) {
				if (columnName != null && columnName.length() > 0) {
					result[i] = rs.getObject(columnName);
					i++;
				}
			}
			return result;
			
		} else {
			return super.toArray(rs);
		}
	}

	@Override
	public <T> T toBean(ResultSet rs, Class<? extends T> type) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public <T> List<T> toBeanList(ResultSet rs, Class<? extends T> type) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Map<String, Object> toMap(ResultSet rs) throws SQLException {
		if (columnNames != null) {
			final Map<String, Object> result = createCaseInsensitiveHashMap(columnNames.size());
			for (String columnName : columnNames) {
				if (columnName != null && columnName.length() > 0) {
					result.put(columnName, rs.getObject(columnName));
				}
			}
			return result;
			
		} else {
			return super.toMap(rs);
		}
	}
	
	/**
     * A Map that converts all keys to lowercase Strings for case insensitive
     * lookups.  This is needed for the toMap() implementation because
     * databases don't consistently handle the casing of column names.
     *
     * <p>The keys are stored as they are given [BUG #DBUTILS-34], so we maintain
     * an internal mapping from lowercase keys to the real keys in order to
     * achieve the case insensitive lookup.
     *
     * <p>Note: This implementation does not allow {@code null}
     * for key, whereas {@link LinkedHashMap} does, because of the code:
     * <pre>
     * key.toString().toLowerCase()
     * </pre>
     */
    private static final class CaseInsensitiveHashMap extends LinkedHashMap<String, Object> {

        private CaseInsensitiveHashMap(final int initialCapacity) {
            super(initialCapacity);
        }

        /**
         * The internal mapping from lowercase keys to the real keys.
         *
         * <p>
         * Any query operation using the key
         * ({@link #get(Object)}, {@link #containsKey(Object)})
         * is done in three steps:
         * <ul>
         * <li>convert the parameter key to lower case</li>
         * <li>get the actual key that corresponds to the lower case key</li>
         * <li>query the map with the actual key</li>
         * </ul>
         * </p>
         */
        private final Map<String, String> lowerCaseMap = new HashMap<>();

        /**
         * Required for serialization support.
         *
         * @see java.io.Serializable
         */
        private static final long serialVersionUID = -2848100435296897392L;

        /** {@inheritDoc} */
        @Override
        public boolean containsKey(final Object key) {
            final Object realKey = lowerCaseMap.get(key.toString().toLowerCase(Locale.ENGLISH));
            return super.containsKey(realKey);
            // Possible optimisation here:
            // Since the lowerCaseMap contains a mapping for all the keys,
            // we could just do this:
            // return lowerCaseMap.containsKey(key.toString().toLowerCase());
        }

        /** {@inheritDoc} */
        @Override
        public Object get(final Object key) {
            final Object realKey = lowerCaseMap.get(key.toString().toLowerCase(Locale.ENGLISH));
            return super.get(realKey);
        }

        /** {@inheritDoc} */
        @Override
        public Object put(final String key, final Object value) {
            /*
             * In order to keep the map and lowerCaseMap synchronized,
             * we have to remove the old mapping before putting the
             * new one. Indeed, oldKey and key are not necessaliry equals.
             * (That's why we call super.remove(oldKey) and not just
             * super.put(key, value))
             */
            final Object oldKey = lowerCaseMap.put(key.toLowerCase(Locale.ENGLISH), key);
            final Object oldValue = super.remove(oldKey);
            super.put(key, value);
            return oldValue;
        }

        /** {@inheritDoc} */
        @Override
        public void putAll(final Map<? extends String, ?> m) {
            for (final Map.Entry<? extends String, ?> entry : m.entrySet()) {
                final String key = entry.getKey();
                final Object value = entry.getValue();
                this.put(key, value);
            }
        }

        /** {@inheritDoc} */
        @Override
        public Object remove(final Object key) {
            final Object realKey = lowerCaseMap.remove(key.toString().toLowerCase(Locale.ENGLISH));
            return super.remove(realKey);
        }
    }
}
