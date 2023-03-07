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

import com.sonicle.commons.LangUtils;
import com.sonicle.security.ConnectionSecurity;
import java.net.URI;

/**
 *
 * @author malbinola
 */
public class DomainBase {
	protected Boolean enabled;
	protected String displayName;
	protected String authDomainName;
	protected String domainName;
	protected Boolean userAutoCreation;
	protected URI dirUri;
	protected String dirAdmin;
	protected String dirPassword;
	protected ConnectionSecurity dirConnSecurity;
	protected Boolean dirCaseSensitive;
	protected String dirRawParameters;
	protected PasswordPolicies passwordPolicies;

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

	public String getAuthDomainName() {
		return authDomainName;
	}

	public void setAuthDomainName(String authDomainName) {
		this.authDomainName = authDomainName;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public Boolean getUserAutoCreation() {
		return userAutoCreation;
	}

	public void setUserAutoCreation(Boolean userAutoCreation) {
		this.userAutoCreation = userAutoCreation;
	}

	public URI getDirUri() {
		return dirUri;
	}

	public void setDirUri(URI dirUri) {
		this.dirUri = dirUri;
	}

	public String getDirAdmin() {
		return dirAdmin;
	}

	public void setDirAdmin(String dirAdmin) {
		this.dirAdmin = dirAdmin;
	}

	public String getDirPassword() {
		return dirPassword;
	}

	public void setDirPassword(String dirPassword) {
		this.dirPassword = dirPassword;
	}

	public ConnectionSecurity getDirConnSecurity() {
		return dirConnSecurity;
	}

	public void setDirConnSecurity(ConnectionSecurity dirConnSecurity) {
		this.dirConnSecurity = dirConnSecurity;
	}

	public Boolean getDirCaseSensitive() {
		return dirCaseSensitive;
	}

	public void setDirCaseSensitive(Boolean dirCaseSensitive) {
		this.dirCaseSensitive = dirCaseSensitive;
	}

	public String getDirRawParameters() {
		return dirRawParameters;
	}

	public void setDirRawParameters(String dirRawParameters) {
		this.dirRawParameters = dirRawParameters;
	}

	public PasswordPolicies getPasswordPolicies() {
		return passwordPolicies;
	}

	public void setPasswordPolicies(PasswordPolicies passwordPolicies) {
		this.passwordPolicies = passwordPolicies;
	}
	
	public String getDirScheme() {
		URI uri = getDirUri();
		return uri != null ? uri.getScheme() : null;
	}
	
	public Class getDirRawParametersClass() {
		String scheme = getDirScheme();
		if (com.sonicle.security.auth.directory.LdapDirectory.SCHEME.equals(scheme) || com.sonicle.security.auth.directory.ADDirectory.SCHEME.equals(scheme) || com.sonicle.security.auth.directory.LdapNethDirectory.SCHEME.equals(scheme)) {
			return LdapDirectoryParams.class;
		} else {
			return null;
		}
	}
	
	public <T extends Object> T readDirRawParameters(Class<T> classOf) {
		return LangUtils.deserialize(getDirRawParameters(), classOf);
	}
	
	public <T extends Object> void writeDirRawParameters(T value, Class<T> classOf) {
		setDirRawParameters(LangUtils.serialize(value, classOf));
	}
	
	public static class PasswordPolicies {
		protected Short minLength;
		protected Boolean complexity;
		protected Boolean avoidConsecutiveChars;
		protected Boolean avoidOldSimilarity;
		protected Boolean avoidUsernameSimilarity;
		protected Short expiration;
		protected Boolean verifyAtLogin;
		
		public PasswordPolicies() {}
		
		public PasswordPolicies(Short minLength, Boolean complexity, Boolean avoidConsecutiveChars, Boolean avoidOldSimilarity, Boolean avoidUsernameSimilarity, Short expiration, Boolean verifyAtLogin) {
			this.minLength = minLength;
			this.complexity = complexity;
			this.avoidConsecutiveChars = avoidConsecutiveChars;
			this.avoidOldSimilarity = avoidOldSimilarity;
			this.avoidUsernameSimilarity = avoidUsernameSimilarity;
			this.expiration = expiration;
			this.verifyAtLogin = verifyAtLogin;
		}
		
		public Short getMinLength() {
			return minLength;
		}

		public boolean getComplexity() {
			return LangUtils.value(complexity, false);
		}

		public boolean getAvoidConsecutiveChars() {
			return LangUtils.value(avoidConsecutiveChars, false);
		}

		public boolean getAvoidOldSimilarity() {
			return LangUtils.value(avoidOldSimilarity, false);
		}

		public boolean getAvoidUsernameSimilarity() {
			return LangUtils.value(avoidUsernameSimilarity, false);
		}

		public Short getExpiration() {
			return expiration;
		}

		public boolean getVerifyAtLogin() {
			return LangUtils.value(verifyAtLogin, false);
		}
	}
}
