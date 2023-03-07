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
package com.sonicle.webtop.core.sdk;

import com.sonicle.commons.web.json.MapItem;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author malbinola
 */
public class ServiceMessage {
	protected String service;
	protected String action;
	protected Object payload;
	
	public ServiceMessage(String service, String action) {
		super();
		this.service = service;
		this.action = action;
	}
	
	public ServiceMessage(String service, String action, Object payload) {
		super();
		this.service = service;
		this.action = action;
		this.payload = payload;
	}
	
	public final String getService() {
		return service;
	}
	
	public final ServiceMessage setService(String value) {
		service = value;
		return this;
	}
	
	public final String getAction() {
		return action;
	}
	
	public final ServiceMessage setAction(String value) {
		action = value;
		return this;
	}
	
	protected final MapItem payloadAsMap() {
		return (MapItem)payload;
	}
	
	public synchronized final ServiceMessage setMappedPayload(String name, Object value) {
		if ((payload == null) || !(payload instanceof Map)) payload = new HashMap<>();
		((Map)payload).put(name, value);
		return this;
	}
}
