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

import com.sonicle.commons.web.json.CId;
import net.sf.qualitycheck.Check;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author malbinola
 */
public class PermissionString extends CId {
	public static final String ACTION_ACCESS = "ACCESS";
	public static final String ACTION_MANAGE = "MANAGE";
	public static final String ACTION_CREATE = "CREATE";
	public static final String ACTION_READ = "READ";
	public static final String ACTION_UPDATE = "UPDATE";
	public static final String ACTION_DELETE = "DELETE";
	public static final String NULL_INSTANCE = "*";
	
	protected PermissionString(AbstractBuilder builder) {
		super(builder);
	}
	
	public PermissionString(String string) {
		super(":", string, 4);
		if (getSize() < 3) throw new IllegalArgumentException("Not a valid instance permission string");
	}
	
	public String getServiceId() {
		return getToken(0);
	}
	
	public String getContext() {
		return getToken(1);
	}
	
	public String getAction() {
		return getToken(2);
	}
	
	public String getInstance() {
		return StringUtils.defaultIfBlank(getTokenOrNull(3), NULL_INSTANCE);
	}
	
	public static PermissionString build(final String serviceId, final String context, final String action) {
		return build(serviceId, context, action, null);
	}
	
	public static PermissionString build(final String serviceId, final String context, final String action, final String instance) {
		return new Builder()
			.withSeparator(":")
			.withTokens(Check.notEmpty(serviceId, "serviceId"), Check.notEmpty(context, "context"), Check.notEmpty(action, "action"), StringUtils.defaultIfBlank(instance, NULL_INSTANCE))
			.build();
	}
	
	public static PermissionString parseQuietly(final String s) {
		try {
			return new PermissionString(s);
		} catch (IllegalArgumentException ex) {
			return null;
		}
	}
	
	private static class Builder extends CId.AbstractBuilder<Builder, PermissionString> {
		@Override
		public PermissionString build() {
			return new PermissionString(this);
		}
	}
}
