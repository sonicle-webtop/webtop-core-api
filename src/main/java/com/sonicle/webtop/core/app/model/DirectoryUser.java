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

import com.sonicle.security.auth.directory.AbstractDirectory;
import com.sonicle.webtop.core.bol.VUser;
import net.sf.qualitycheck.Check;

/**
 *
 * @author malbinola
 */
public class DirectoryUser {
	protected final AbstractDirectory.AuthUser directoryUser;
	protected final PlatformUser platformUser;
	
	public DirectoryUser(AbstractDirectory.AuthUser directoryUser, VUser vuser) {
		this.directoryUser = Check.notNull(directoryUser, "directoryUser");
		this.platformUser = (vuser != null) ? new PlatformUser(vuser) : null;
	}

	public AbstractDirectory.AuthUser getDirectoryUser() {
		return directoryUser;
	}

	public PlatformUser getPlatformUser() {
		return platformUser;
	}
	
	public boolean existsPlatformUser() {
		return platformUser != null;
	}

	public static class PlatformUser {
		protected final String userSid;
		protected final Boolean enabled;
		protected final String displayName;
		protected final String firstName;
		protected final String lastName;
		protected final String personalEmail;
		
		public PlatformUser(VUser vuser) {
			this.userSid = vuser.getUserSid();
			this.enabled = vuser.getEnabled();
			this.displayName = vuser.getDisplayName();
			this.firstName = vuser.getFirstName();
			this.lastName = vuser.getLastName();
			this.personalEmail = vuser.getEmail();
		}

		public String getUserSid() {
			return userSid;
		}
		
		public Boolean getEnabled() {
			return enabled;
		}

		public String getDisplayName() {
			return displayName;
		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public String getPersonalEmail() {
			return personalEmail;
		}
	}
}
