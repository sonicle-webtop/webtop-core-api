/* 
 * Copyright (C) 2014 Sonicle S.r.l.
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
 * display the words "Copyright (C) 2014 Sonicle S.r.l.".
 */
package com.sonicle.webtop.core.sdk;

import com.sonicle.security.DomainAccount;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author malbinola
 */
public class UserProfileId extends DomainAccount {
	
	public UserProfileId(String id) {
		super(id);
	}

	public UserProfileId(String domainId, String userId) {
		super(domainId, userId);
	}

	public String getDomainId() {
		return getDomain();
	}

	public String getUserId() {
		return getLocal();
	}
	
	public static boolean isWildcardUser(UserProfileId profileId) {
		return "*".equals(profileId.getUserId());
	}
	
	public static UserProfileId parse(final String fullName) {
		return new UserProfileId(fullName);
	}
	
	public static UserProfileId parse(final String fullName, final String defaultDomainId) {
		return new UserProfileId(StringUtils.contains(fullName, "@") ? fullName : fullName + "@" + defaultDomainId);
	}
	
	public static UserProfileId parseQuielty(final String fullName) {
		try {
			return parse(fullName);
		} catch (Exception ex) {
			return null;
		}
	}
	
	public static UserProfileId parseQuielty(final String fullName, final String defaultDomainId) {
		try {
			return parse(fullName, defaultDomainId);
		} catch (Exception ex) {
			return null;
		}
	}
}
