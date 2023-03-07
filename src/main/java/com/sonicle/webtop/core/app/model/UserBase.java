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

import java.util.LinkedHashSet;
import java.util.Set;
import org.codehaus.plexus.util.StringUtils;

/**
 *
 * @author malbinola
 */
public class UserBase {
	protected Boolean enabled;
	protected String displayName;
	protected String firstName;
	protected String lastName;
	//protected Set<String> assignedGroups = new LinkedHashSet<>();
	//protected Set<String> assignedRoles = new LinkedHashSet<>();
	//protected Set<PermissionString> permissions = new LinkedHashSet<>();
	//protected Set<String> allowedServiceIds = new LinkedHashSet<>();
	protected Set<String> assignedGroups;
	protected Set<String> assignedRoles;
	protected Set<PermissionString> permissions;
	protected Set<String> allowedServiceIds;
	
	public void sanitize() {
		displayName = StringUtils.strip(displayName);
		firstName = StringUtils.strip(firstName);
		lastName = StringUtils.strip(lastName);
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<String> getAssignedGroups() {
		return assignedGroups;
	}

	public void setAssignedGroups(Set<String> assignedGroups) {
		this.assignedGroups = assignedGroups;
	}

	public Set<String> getAssignedRoles() {
		return assignedRoles;
	}

	public void setAssignedRoles(Set<String> assignedRoles) {
		this.assignedRoles = assignedRoles;
	}

	public Set<PermissionString> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<PermissionString> permissions) {
		this.permissions = permissions;
	}

	public Set<String> getAllowedServiceIds() {
		return allowedServiceIds;
	}

	public void setAllowedServiceIds(Set<String> allowedServiceIds) {
		this.allowedServiceIds = allowedServiceIds;
	}
}
