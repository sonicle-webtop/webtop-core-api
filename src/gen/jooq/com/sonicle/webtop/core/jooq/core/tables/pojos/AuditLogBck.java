/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.core.tables.pojos;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AuditLogBck implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private java.lang.Long         auditLogId;
    private org.joda.time.DateTime timestamp;
    private java.lang.String       domainId;
    private java.lang.String       userId;
    private java.lang.String       serviceId;
    private java.lang.String       context;
    private java.lang.String       action;
    private java.lang.String       referenceId;
    private java.lang.String       sessionId;
    private java.lang.String       data;

    public AuditLogBck() {}

    public AuditLogBck(AuditLogBck value) {
        this.auditLogId = value.auditLogId;
        this.timestamp = value.timestamp;
        this.domainId = value.domainId;
        this.userId = value.userId;
        this.serviceId = value.serviceId;
        this.context = value.context;
        this.action = value.action;
        this.referenceId = value.referenceId;
        this.sessionId = value.sessionId;
        this.data = value.data;
    }

    public AuditLogBck(
        java.lang.Long         auditLogId,
        org.joda.time.DateTime timestamp,
        java.lang.String       domainId,
        java.lang.String       userId,
        java.lang.String       serviceId,
        java.lang.String       context,
        java.lang.String       action,
        java.lang.String       referenceId,
        java.lang.String       sessionId,
        java.lang.String       data
    ) {
        this.auditLogId = auditLogId;
        this.timestamp = timestamp;
        this.domainId = domainId;
        this.userId = userId;
        this.serviceId = serviceId;
        this.context = context;
        this.action = action;
        this.referenceId = referenceId;
        this.sessionId = sessionId;
        this.data = data;
    }

    /**
     * Getter for <code>core.audit_log_bck.audit_log_id</code>.
     */
    public java.lang.Long getAuditLogId() {
        return this.auditLogId;
    }

    /**
     * Setter for <code>core.audit_log_bck.audit_log_id</code>.
     */
    public void setAuditLogId(java.lang.Long auditLogId) {
        this.auditLogId = auditLogId;
    }

    /**
     * Getter for <code>core.audit_log_bck.timestamp</code>.
     */
    public org.joda.time.DateTime getTimestamp() {
        return this.timestamp;
    }

    /**
     * Setter for <code>core.audit_log_bck.timestamp</code>.
     */
    public void setTimestamp(org.joda.time.DateTime timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Getter for <code>core.audit_log_bck.domain_id</code>.
     */
    public java.lang.String getDomainId() {
        return this.domainId;
    }

    /**
     * Setter for <code>core.audit_log_bck.domain_id</code>.
     */
    public void setDomainId(java.lang.String domainId) {
        this.domainId = domainId;
    }

    /**
     * Getter for <code>core.audit_log_bck.user_id</code>.
     */
    public java.lang.String getUserId() {
        return this.userId;
    }

    /**
     * Setter for <code>core.audit_log_bck.user_id</code>.
     */
    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }

    /**
     * Getter for <code>core.audit_log_bck.service_id</code>.
     */
    public java.lang.String getServiceId() {
        return this.serviceId;
    }

    /**
     * Setter for <code>core.audit_log_bck.service_id</code>.
     */
    public void setServiceId(java.lang.String serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * Getter for <code>core.audit_log_bck.context</code>.
     */
    public java.lang.String getContext() {
        return this.context;
    }

    /**
     * Setter for <code>core.audit_log_bck.context</code>.
     */
    public void setContext(java.lang.String context) {
        this.context = context;
    }

    /**
     * Getter for <code>core.audit_log_bck.action</code>.
     */
    public java.lang.String getAction() {
        return this.action;
    }

    /**
     * Setter for <code>core.audit_log_bck.action</code>.
     */
    public void setAction(java.lang.String action) {
        this.action = action;
    }

    /**
     * Getter for <code>core.audit_log_bck.reference_id</code>.
     */
    public java.lang.String getReferenceId() {
        return this.referenceId;
    }

    /**
     * Setter for <code>core.audit_log_bck.reference_id</code>.
     */
    public void setReferenceId(java.lang.String referenceId) {
        this.referenceId = referenceId;
    }

    /**
     * Getter for <code>core.audit_log_bck.session_id</code>.
     */
    public java.lang.String getSessionId() {
        return this.sessionId;
    }

    /**
     * Setter for <code>core.audit_log_bck.session_id</code>.
     */
    public void setSessionId(java.lang.String sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * Getter for <code>core.audit_log_bck.data</code>.
     */
    public java.lang.String getData() {
        return this.data;
    }

    /**
     * Setter for <code>core.audit_log_bck.data</code>.
     */
    public void setData(java.lang.String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("AuditLogBck (");

        sb.append(auditLogId);
        sb.append(", ").append(timestamp);
        sb.append(", ").append(domainId);
        sb.append(", ").append(userId);
        sb.append(", ").append(serviceId);
        sb.append(", ").append(context);
        sb.append(", ").append(action);
        sb.append(", ").append(referenceId);
        sb.append(", ").append(sessionId);
        sb.append(", ").append(data);

        sb.append(")");
        return sb.toString();
    }
}
