/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sonicle.webtop.core.bol;

import com.google.gson.annotations.SerializedName;
import com.sonicle.commons.IdentifierUtils;
import com.sonicle.commons.InternetAddressUtils;
import com.sonicle.webtop.core.jooq.core.tables.pojos.Users;
import com.sonicle.webtop.core.sdk.UserProfileId;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author gbulfon
 */
public class OUser extends Users {
	public static final String TYPE_USER = "U";
	public static final String TYPE_GROUP = "G";
	
	public String getUserSid() {
		return getUserUid();
	}
	
	public void setUserSid(String userSid) {
		setUserUid(userSid);
	}
	
	public UserProfileId getProfileId() {
		return new UserProfileId(this.getDomainId(), this.getUserId());
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append(getDomainId())
			.append(getUserId())
			.append(getUserSid())
			.toString();
	}
	
	public static String generateSecretKey() {
		return StringUtils.defaultIfBlank(IdentifierUtils.generateSecretKey(), "0123456789101112");
	}
	
	public static enum Type {
		@SerializedName("U") USER,
		@SerializedName("G") GROUP,
		@SerializedName("R") RESOURCE;
	}
	
	public void sanitize() {
		setDisplayName(StringUtils.strip(getDisplayName()));
	}
	
	public static OUser fillDefaultsForInsert(OUser tgt, String firstName, String lastName) {
		if (tgt != null) {
			if (StringUtils.isBlank(tgt.getUserSid())) tgt.setUserSid(IdentifierUtils.getUUID());
			if (StringUtils.isBlank(tgt.getSecret())) tgt.setSecret(OUser.generateSecretKey());
			if (StringUtils.isBlank(tgt.getDisplayName())) {
				String dn = StringUtils.trim(StringUtils.defaultIfBlank(firstName, "") + " " + StringUtils.defaultIfBlank(lastName, ""));
				tgt.setDisplayName(StringUtils.isBlank(dn) ? tgt.getUserId() : dn);
			}
		}
		return tgt;
	}
	
	public static OUserInfo fillDefaultsForInsert(OUserInfo tgt, String personalEmailDefaultLocal, String personalEmailDomain) {
		if (tgt != null) {
			if (StringUtils.isBlank(tgt.getEmail())) tgt.setEmail(InternetAddressUtils.toInternetAddress(personalEmailDefaultLocal, personalEmailDomain, null).toString());
		}
		return tgt;
	}
}
