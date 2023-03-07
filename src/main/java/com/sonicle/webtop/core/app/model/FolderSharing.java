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

import net.sf.qualitycheck.Check;

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
	
	public static class SubjectRights {
		protected final String aclSubjectSid;
		protected final FolderShare.FolderPermissions folderPermissions;
		protected final FolderShare.ItemsPermissions itemsPermissions;
		
		public SubjectRights(String aclSubjectSid) {
			this(aclSubjectSid, new FolderShare.FolderPermissions(), new FolderShare.ItemsPermissions());
		}
		
		public SubjectRights(String aclSubjectSid, FolderShare.FolderPermissions folderPermissions) {
			this(aclSubjectSid, folderPermissions, new FolderShare.ItemsPermissions());
		}
		
		public SubjectRights(String aclSubjectSid, FolderShare.FolderPermissions folderPermissions, FolderShare.ItemsPermissions itemsPermissions) {
			this.aclSubjectSid = aclSubjectSid;
			this.folderPermissions = folderPermissions;
			this.itemsPermissions = itemsPermissions;
		}
		
		public String getAclSubjectSid() {
			return aclSubjectSid;
		}

		public FolderShare.FolderPermissions getFolderPermissions() {
			return folderPermissions;
		}

		public FolderShare.ItemsPermissions getItemsPermissions() {
			return itemsPermissions;
		}
	}
}
