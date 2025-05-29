/*
 * Copyright (C) 2025 Sonicle S.r.l.
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
 * display the words "Copyright (C) 2025 Sonicle S.r.l.".
 */
package com.sonicle.webtop.core.app.model;

import com.sonicle.commons.Base58;
import com.sonicle.security.CryptoUtils;
import com.sonicle.security.DigestAlgorithm;
import java.security.NoSuchAlgorithmException;
import net.sf.qualitycheck.Check;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

/**
 *
 * @author malbinola
 */
public class ApiKeyBase {
	protected DateTime creationTimestamp;
	protected String name;
	protected String description;
	protected String shortToken;
	protected String longToken;
	protected DateTime expiresAt;
	protected DateTime lastUsedAt;

	public DateTime getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(DateTime creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortToken() {
		return shortToken;
	}

	public void setShortToken(String shortToken) {
		this.shortToken = shortToken;
	}

	public String getLongToken() {
		return longToken;
	}

	public void setLongToken(String longToken) {
		this.longToken = longToken;
	}
	
	public DateTime getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(DateTime expiresAt) {
		this.expiresAt = expiresAt;
	}

	public DateTime getLastUsedAt() {
		return lastUsedAt;
	}

	public void setLastUsedAt(DateTime lastUsedAt) {
		this.lastUsedAt = lastUsedAt;
	}
	
	public static String buildApiKeyString(final String shortToken, final String plainLongToken) {
		return Check.notEmpty(shortToken, "shortToken") + "_" + Check.notEmpty(plainLongToken, "plainLongToken");
	}
	
	public static String[] parseApiKeyString(final String apiKeyString) {
		String[] tokens = StringUtils.split(apiKeyString, "_", 2);
		Check.equals(2, tokens.length, "ApiKey does NOT have the expected format");
		Check.notEmpty(tokens[0], "shortToken");
		Check.notEmpty(tokens[1], "longToken");
		return tokens;
	}
	
	public static String generateShortToken() throws NoSuchAlgorithmException {
		return StringUtils.left(Base58.encode(CryptoUtils.generateRandomBytes(8)), 8);
	}
	
	public static String generateLongToken() throws NoSuchAlgorithmException {
		return Base58.encode(CryptoUtils.generateAESKey(128).getEncoded());
	}
	
	public static String hashLongToken(final String plainLongToken) {
		return CryptoUtils.hash(plainLongToken, DigestAlgorithm.SHA256);
	}
}
