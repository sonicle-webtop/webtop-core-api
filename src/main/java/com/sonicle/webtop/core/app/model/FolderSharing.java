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
package com.sonicle.webtop.core.app.model;

import com.sonicle.commons.LangUtils;
import net.sf.qualitycheck.Check;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 *
 * @author malbinola
 */
public class FolderSharing {
	public static final String INSTANCE_WILDCARD = "*";
	
	public static String buildFolderPermissionKey(String context) {
		return context + "_FOLDER@SHARE";
	}
	
	public static String buildElementsPermissionKey(String context) {
		return context + "_ELEMENTS@SHARE";
	}
	
	public static class FolderScope extends Scope {
		private final String folderId;
		
		private FolderScope(String folderId) {
			this.folderId = folderId;
		}

		public String getFolderId() {
			return folderId;
		}
	}
		
	public static class WildcardScope extends Scope {
		
		private WildcardScope() {}
	}
	
	public static abstract class Scope {
		
		public static WildcardScope wildcard() {
			return new WildcardScope();
		}

		public static FolderScope folder(String folderId) {
			return new FolderScope(Check.notEmpty(folderId, "folderId"));
		}
	}
	
	public static class SubjectConfiguration<T> {
		protected final String subjectSid;
		protected final FolderShare.FolderPermissions folderPermissions;
		protected final FolderShare.ItemsPermissions itemsPermissions;
		protected final Object data;
		
		public SubjectConfiguration(String subjectSid) {
			this(subjectSid, new FolderShare.FolderPermissions(), new FolderShare.ItemsPermissions(), (Object)null);
		}
		
		public SubjectConfiguration(String subjectSid, FolderShare.FolderPermissions folderPermissions) {
			this(subjectSid, folderPermissions, new FolderShare.ItemsPermissions(), (Object)null);
		}
		
		public SubjectConfiguration(String subjectSid, FolderShare.FolderPermissions folderPermissions, FolderShare.ItemsPermissions itemsPermissions) {
			this(subjectSid, folderPermissions, itemsPermissions, (Object)null);
		}
		
		public SubjectConfiguration(String subjectSid, FolderShare.FolderPermissions folderPermissions, FolderShare.ItemsPermissions itemsPermissions, String rawData, Class<T> typeOfData) {
			this(subjectSid, folderPermissions, itemsPermissions, LangUtils.deserialize(rawData, null, typeOfData));
		}
		
		public SubjectConfiguration(String subjectSid, FolderShare.FolderPermissions folderPermissions, FolderShare.ItemsPermissions itemsPermissions, Object data) {
			this.subjectSid = Check.notEmpty(subjectSid, "subjectSid");
			this.folderPermissions = Check.notNull(folderPermissions, "folderPermissions");
			this.itemsPermissions = Check.notNull(itemsPermissions, "itemsPermissions");
			this.data = data;
		}
		
		public String getSubjectSid() {
			return subjectSid;
		}

		public FolderShare.FolderPermissions getFolderPermissions() {
			return folderPermissions;
		}

		public FolderShare.ItemsPermissions getItemsPermissions() {
			return itemsPermissions;
		}
		
		public Object getData() {
			return data;
		}
		
		public <T> T getTypedData(final Class<T> typeOfData) {
			return (T)data;
		}
		
		public <T> String getRawData(final Class<T> typeOfData) {
			return LangUtils.serialize((T)data, Check.notNull(typeOfData, "typeOfData"));
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
