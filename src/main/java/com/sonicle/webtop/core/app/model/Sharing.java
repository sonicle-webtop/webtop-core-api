/*
 * Copyright (C) 2023 Sonicle S.r.l.
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
 * display the words "Copyright (C) 2023 Sonicle S.r.l.".
 */
package com.sonicle.webtop.core.app.model;

import com.sonicle.commons.LangUtils;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import net.sf.qualitycheck.Check;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 *
 * @author malbinola
 */
public class Sharing {
	
	public static class SubjectConfiguration<T> {
		protected final String subjectSid;
		protected final Set<String> actions;
		protected final Class<T> dataType;
		protected final T data;
		
		public SubjectConfiguration(String subjectSid) {
			this(subjectSid, new LinkedHashSet<>(0), (T)null, null);
		}
		
		public SubjectConfiguration(String subjectSid, Set<String> actions) {
			this(subjectSid, actions, (T)null, null);
		}
		
		public SubjectConfiguration(String subjectSid, Set<String> actions, T data, Class<T> dataType) {
			this.subjectSid = Check.notEmpty(subjectSid, "subjectSid");
			this.actions = Collections.unmodifiableSet(Check.notNull(actions, "actions"));
			this.dataType = Check.notNull(dataType, "dataType");
			this.data = data;
		}
		
		public SubjectConfiguration(String subjectSid, Set<String> actions, String rawData, Class<T> dataType) {
			this.subjectSid = Check.notEmpty(subjectSid, "subjectSid");
			this.actions = Collections.unmodifiableSet(Check.notNull(actions, "actions"));
			this.dataType = Check.notNull(dataType, "dataType");
			this.data = LangUtils.deserialize(rawData, null, dataType);
		}
		
		public String getSubjectSid() {
			return subjectSid;
		}

		public Set<String> getActions() {
			return actions;
		}
		
		public T getData() {
			return data;
		}
		
		public String getRawData() {
			return LangUtils.serialize(data, dataType);
		}
		
		@Override
		public int hashCode() {
			return new HashCodeBuilder()
				.append(subjectSid)
				.toHashCode();
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof SubjectConfiguration == false) return false;
			if (this == obj) return true;
			final SubjectConfiguration otherObject = (SubjectConfiguration)obj;
			return new EqualsBuilder()
				.append(subjectSid, otherObject.subjectSid)
				.isEquals();
		}
	}
}
