/*
 * WebTop Services is a Web Application framework developed by Sonicle S.r.l.
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
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program; if not, see http://www.gnu.org/licenses or write to
 * the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301 USA.
 *
 * You can contact Sonicle S.r.l. at email address sonicle@sonicle.com
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
package com.sonicle.webtop.core.bol;

import com.sonicle.commons.IdentifierUtils;
import com.sonicle.commons.RegexUtils;
import com.sonicle.webtop.core.jooq.core.tables.pojos.Users;
import com.sonicle.webtop.core.sdk.UserProfileId;
import net.sf.qualitycheck.Check;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author malbinola
 */
public class OGroup extends Users {
	
	public String getGroupId() {
		return getUserId();
	}
	
	public void setGroupId(String groupId) {
		setUserId(groupId);
	}
	
	public String getGroupSid() {
		return getUserUid();
	}
	
	public void setGroupSid(String groupSid) {
		setUserUid(groupSid);
	}
	
	public String getDescription() {
		return getDisplayName();
	}
	
	public void setDescription(String description) {
		setDisplayName(description);
	}
	
	public UserProfileId getProfileId() {
		return new UserProfileId(this.getDomainId(), this.getUserId());
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append(getDomainId())
			.append(getUserId())
			.append(getUserUid())
			.toString();
	}
	
	public static void validate(OGroup tgt) {
		Check.matchesPattern(RegexUtils.match(RegexUtils.MATCH_USERNAME_CHARS), tgt.getGroupId(), "groupId");
		Check.notNull(tgt.getEnabled(), "enabled");
		Check.notNull(tgt.getDescription(), "description");
	}
	
	public static OGroup fillDefaultsForInsert(OGroup tgt) {
		if (tgt != null) {
			tgt.setEnabled(true);
			tgt.setSecret(null);
			if (StringUtils.isBlank(tgt.getUserUid())) tgt.setUserUid(IdentifierUtils.getUUID());
			tgt.setDescription(StringUtils.defaultIfBlank(tgt.getDescription(), "")); // Description (displayName in table) needs to be at least empty!
		}
		return tgt;
	}
}
