/**
 * This class is generated by jOOQ
 */
package com.sonicle.webtop.core.jooq.core.tables.pojos;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.5.3"
	},
	comments = "This class is generated by jOOQ"
)
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class VwAccessLog implements java.io.Serializable {

	private static final long serialVersionUID = 2048646743;

	private java.lang.String       sessionId;
	private java.lang.String       domainId;
	private java.lang.String       userId;
	private java.lang.String       data;
	private org.joda.time.DateTime loginSuccess;
	private org.joda.time.DateTime otpSuccess;
	private org.joda.time.DateTime otpFailure;
	private org.joda.time.DateTime otpAbandoned;
	private org.joda.time.DateTime authenticated;
	private org.joda.time.DateTime logout;
	private org.joda.time.DateTime sessionExpired;
	private org.joda.time.DateTime loginFailure;

	public VwAccessLog() {}

	public VwAccessLog(
		java.lang.String       sessionId,
		java.lang.String       domainId,
		java.lang.String       userId,
		java.lang.String       data,
		org.joda.time.DateTime loginSuccess,
		org.joda.time.DateTime otpSuccess,
		org.joda.time.DateTime otpFailure,
		org.joda.time.DateTime otpAbandoned,
		org.joda.time.DateTime authenticated,
		org.joda.time.DateTime logout,
		org.joda.time.DateTime sessionExpired,
		org.joda.time.DateTime loginFailure
	) {
		this.sessionId = sessionId;
		this.domainId = domainId;
		this.userId = userId;
		this.data = data;
		this.loginSuccess = loginSuccess;
		this.otpSuccess = otpSuccess;
		this.otpFailure = otpFailure;
		this.otpAbandoned = otpAbandoned;
		this.authenticated = authenticated;
		this.logout = logout;
		this.sessionExpired = sessionExpired;
		this.loginFailure = loginFailure;
	}

	public java.lang.String getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(java.lang.String sessionId) {
		this.sessionId = sessionId;
	}

	public java.lang.String getDomainId() {
		return this.domainId;
	}

	public void setDomainId(java.lang.String domainId) {
		this.domainId = domainId;
	}

	public java.lang.String getUserId() {
		return this.userId;
	}

	public void setUserId(java.lang.String userId) {
		this.userId = userId;
	}

	public java.lang.String getData() {
		return this.data;
	}

	public void setData(java.lang.String data) {
		this.data = data;
	}

	public org.joda.time.DateTime getLoginSuccess() {
		return this.loginSuccess;
	}

	public void setLoginSuccess(org.joda.time.DateTime loginSuccess) {
		this.loginSuccess = loginSuccess;
	}

	public org.joda.time.DateTime getOtpSuccess() {
		return this.otpSuccess;
	}

	public void setOtpSuccess(org.joda.time.DateTime otpSuccess) {
		this.otpSuccess = otpSuccess;
	}

	public org.joda.time.DateTime getOtpFailure() {
		return this.otpFailure;
	}

	public void setOtpFailure(org.joda.time.DateTime otpFailure) {
		this.otpFailure = otpFailure;
	}

	public org.joda.time.DateTime getOtpAbandoned() {
		return this.otpAbandoned;
	}

	public void setOtpAbandoned(org.joda.time.DateTime otpAbandoned) {
		this.otpAbandoned = otpAbandoned;
	}

	public org.joda.time.DateTime getAuthenticated() {
		return this.authenticated;
	}

	public void setAuthenticated(org.joda.time.DateTime authenticated) {
		this.authenticated = authenticated;
	}

	public org.joda.time.DateTime getLogout() {
		return this.logout;
	}

	public void setLogout(org.joda.time.DateTime logout) {
		this.logout = logout;
	}

	public org.joda.time.DateTime getSessionExpired() {
		return this.sessionExpired;
	}

	public void setSessionExpired(org.joda.time.DateTime sessionExpired) {
		this.sessionExpired = sessionExpired;
	}

	public org.joda.time.DateTime getLoginFailure() {
		return this.loginFailure;
	}

	public void setLoginFailure(org.joda.time.DateTime loginFailure) {
		this.loginFailure = loginFailure;
	}
}
