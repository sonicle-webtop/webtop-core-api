/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.core.tables.pojos;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class VwAuthDetails implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private java.lang.String       sessionId;
    private java.lang.String       domainId;
    private java.lang.String       userId;
    private org.joda.time.DateTime date;
    private java.lang.Double       minutes;
    private java.lang.Boolean      authenticated;
    private java.lang.Boolean      failure;
    private java.lang.Integer      loginErrors;
    private java.lang.String       data;

    public VwAuthDetails() {}

    public VwAuthDetails(VwAuthDetails value) {
        this.sessionId = value.sessionId;
        this.domainId = value.domainId;
        this.userId = value.userId;
        this.date = value.date;
        this.minutes = value.minutes;
        this.authenticated = value.authenticated;
        this.failure = value.failure;
        this.loginErrors = value.loginErrors;
        this.data = value.data;
    }

    public VwAuthDetails(
        java.lang.String       sessionId,
        java.lang.String       domainId,
        java.lang.String       userId,
        org.joda.time.DateTime date,
        java.lang.Double       minutes,
        java.lang.Boolean      authenticated,
        java.lang.Boolean      failure,
        java.lang.Integer      loginErrors,
        java.lang.String       data
    ) {
        this.sessionId = sessionId;
        this.domainId = domainId;
        this.userId = userId;
        this.date = date;
        this.minutes = minutes;
        this.authenticated = authenticated;
        this.failure = failure;
        this.loginErrors = loginErrors;
        this.data = data;
    }

    /**
     * Getter for <code>core.vw_auth_details.session_id</code>.
     */
    public java.lang.String getSessionId() {
        return this.sessionId;
    }

    /**
     * Setter for <code>core.vw_auth_details.session_id</code>.
     */
    public void setSessionId(java.lang.String sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * Getter for <code>core.vw_auth_details.domain_id</code>.
     */
    public java.lang.String getDomainId() {
        return this.domainId;
    }

    /**
     * Setter for <code>core.vw_auth_details.domain_id</code>.
     */
    public void setDomainId(java.lang.String domainId) {
        this.domainId = domainId;
    }

    /**
     * Getter for <code>core.vw_auth_details.user_id</code>.
     */
    public java.lang.String getUserId() {
        return this.userId;
    }

    /**
     * Setter for <code>core.vw_auth_details.user_id</code>.
     */
    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }

    /**
     * Getter for <code>core.vw_auth_details.date</code>.
     */
    public org.joda.time.DateTime getDate() {
        return this.date;
    }

    /**
     * Setter for <code>core.vw_auth_details.date</code>.
     */
    public void setDate(org.joda.time.DateTime date) {
        this.date = date;
    }

    /**
     * Getter for <code>core.vw_auth_details.minutes</code>.
     */
    public java.lang.Double getMinutes() {
        return this.minutes;
    }

    /**
     * Setter for <code>core.vw_auth_details.minutes</code>.
     */
    public void setMinutes(java.lang.Double minutes) {
        this.minutes = minutes;
    }

    /**
     * Getter for <code>core.vw_auth_details.authenticated</code>.
     */
    public java.lang.Boolean getAuthenticated() {
        return this.authenticated;
    }

    /**
     * Setter for <code>core.vw_auth_details.authenticated</code>.
     */
    public void setAuthenticated(java.lang.Boolean authenticated) {
        this.authenticated = authenticated;
    }

    /**
     * Getter for <code>core.vw_auth_details.failure</code>.
     */
    public java.lang.Boolean getFailure() {
        return this.failure;
    }

    /**
     * Setter for <code>core.vw_auth_details.failure</code>.
     */
    public void setFailure(java.lang.Boolean failure) {
        this.failure = failure;
    }

    /**
     * Getter for <code>core.vw_auth_details.login_errors</code>.
     */
    public java.lang.Integer getLoginErrors() {
        return this.loginErrors;
    }

    /**
     * Setter for <code>core.vw_auth_details.login_errors</code>.
     */
    public void setLoginErrors(java.lang.Integer loginErrors) {
        this.loginErrors = loginErrors;
    }

    /**
     * Getter for <code>core.vw_auth_details.data</code>.
     */
    public java.lang.String getData() {
        return this.data;
    }

    /**
     * Setter for <code>core.vw_auth_details.data</code>.
     */
    public void setData(java.lang.String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("VwAuthDetails (");

        sb.append(sessionId);
        sb.append(", ").append(domainId);
        sb.append(", ").append(userId);
        sb.append(", ").append(date);
        sb.append(", ").append(minutes);
        sb.append(", ").append(authenticated);
        sb.append(", ").append(failure);
        sb.append(", ").append(loginErrors);
        sb.append(", ").append(data);

        sb.append(")");
        return sb.toString();
    }
}
