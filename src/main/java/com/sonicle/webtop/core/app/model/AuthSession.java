/*
 * Copyright (C) 2026 Sonicle S.r.l.
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
 * display the words "Copyright (C) 2026 Sonicle S.r.l.".
 */
package com.sonicle.webtop.core.app.model;

import org.joda.time.DateTime;

/**
 * Active session entry returned by listActiveAuthSessions, one per
 * non-revoked, non-expired refresh token.
 *
 * @author malbinola
 */
public class AuthSession {
	private final long id;
	private final String deviceLabel;
	private final DateTime createdAt;
	private final DateTime lastUsedAt;
	private final DateTime expiresAt;
	private final String clientIpAddress;
	private final String clientUserAgent;

	public AuthSession(long id, String deviceLabel, DateTime createdAt, DateTime lastUsedAt, DateTime expiresAt, String clientIpAddress, String clientUserAgent) {
		this.id = id;
		this.deviceLabel = deviceLabel;
		this.createdAt = createdAt;
		this.lastUsedAt = lastUsedAt;
		this.expiresAt = expiresAt;
		this.clientIpAddress = clientIpAddress;
		this.clientUserAgent = clientUserAgent;
	}

	public long getId() { return id; }
	public String getDeviceLabel() { return deviceLabel; }
	public DateTime getCreatedAt() { return createdAt; }
	public DateTime getLastUsedAt() { return lastUsedAt; }
	public DateTime getExpiresAt() { return expiresAt; }
	public String getClientIpAddress() { return clientIpAddress; }
	public String getClientUserAgent() { return clientUserAgent; }
}
