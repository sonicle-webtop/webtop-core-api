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
package com.sonicle.webtop.core.model;

import com.sonicle.webtop.core.app.model.GenericSubject;
import com.sonicle.commons.EnumUtils;
import com.sonicle.webtop.core.bol.ORole;
import com.sonicle.webtop.core.bol.OUser;
import net.sf.qualitycheck.Check;

/**
 *
 * @author malbinola
 */
public class SubjectSid {
	protected final GenericSubject.Type type;
	protected final String sid;
	
	public SubjectSid(GenericSubject.Type type, String sid) {
		this.type = Check.notNull(type, "type");
		this.sid = Check.notNull(sid, "sid");
	}
	
	public SubjectSid(OUser ouser) {
		this(toAclSubjectType(ouser.getType()), ouser.getUserUid());
	}
	
	public SubjectSid(ORole orole) {
		this(GenericSubject.Type.ROLE, orole.getRoleUid());
	}

	public GenericSubject.Type getType() {
		return type;
	}

	public String getSid() {
		return sid;
	}
	
	public static GenericSubject.Type toAclSubjectType(String type) {
		OUser.Type xtype = EnumUtils.forSerializedName(type, OUser.Type.class);
		if (OUser.Type.USER.equals(xtype)) {
			return GenericSubject.Type.USER;
		} else if (OUser.Type.RESOURCE.equals(xtype)) {
			return GenericSubject.Type.RESOURCE;
		} else if (OUser.Type.GROUP.equals(xtype)) {
			return GenericSubject.Type.GROUP;
		} else {
			return null;
		}
	}
}
