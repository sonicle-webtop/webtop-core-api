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

import com.google.gson.annotations.SerializedName;
import com.sonicle.webtop.core.bol.OGroup;
import com.sonicle.webtop.core.bol.ORole;
import com.sonicle.webtop.core.bol.OUser;
import com.sonicle.webtop.core.bol.VResource;
import com.sonicle.webtop.core.sdk.UserProfileId;

/**
 *
 * @author malbinola
 */
public class GenericSubject {
	protected Type type;
	protected String domainId;
	protected String sid;
	protected String name;
	protected String displayName;
	
	public GenericSubject(Type type, String domainId, String sid, String name, String displayName) {
		this.type = type;
		this.domainId = domainId;
		this.sid = sid;
		this.name = name;
		this.displayName = displayName;
	}
	
	public GenericSubject(OUser ouser) {
		this(Type.USER, ouser.getDomainId(), ouser.getUserSid(), ouser.getUserId(), ouser.getDisplayName());
	}
	
	public GenericSubject(VResource vres) {
		this(Type.RESOURCE, vres.getDomainId(), vres.getResourceSid(), vres.getUserId(), vres.getDisplayName());
	}
	
	public GenericSubject(OGroup ogroup) {
		this(Type.GROUP, ogroup.getDomainId(), ogroup.getGroupSid(), ogroup.getGroupId(), ogroup.getGroupId());
	}
	
	public GenericSubject(ORole orole) {
		this(Type.ROLE, orole.getDomainId(), orole.getRoleSid(), orole.getRoleId(), orole.getRoleId());
	}
	
	public Type getType() {
		return type;
	}

	public String getDomainId() {
		return domainId;
	}

	public String getSid() {
		return sid;
	}

	public String getName() {
		return name;
	}

	public String getDisplayName() {
		return displayName;
	}
	
	public UserProfileId getProfileId() {
		return new UserProfileId(getDomainId(), getName());
	}
	
	public static enum Type {
		@SerializedName("group") GROUP,
		@SerializedName("user") USER,
		@SerializedName("resource") RESOURCE,
		@SerializedName("role") ROLE;
	}
}
