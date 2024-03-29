/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.core.tables.pojos;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AuditKnownDevices implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private java.lang.Long         auditKnownDeviceId;
    private java.lang.String       domainId;
    private java.lang.String       userId;
    private java.lang.String       deviceId;
    private org.joda.time.DateTime firstSeen;
    private org.joda.time.DateTime lastSeen;

    public AuditKnownDevices() {}

    public AuditKnownDevices(AuditKnownDevices value) {
        this.auditKnownDeviceId = value.auditKnownDeviceId;
        this.domainId = value.domainId;
        this.userId = value.userId;
        this.deviceId = value.deviceId;
        this.firstSeen = value.firstSeen;
        this.lastSeen = value.lastSeen;
    }

    public AuditKnownDevices(
        java.lang.Long         auditKnownDeviceId,
        java.lang.String       domainId,
        java.lang.String       userId,
        java.lang.String       deviceId,
        org.joda.time.DateTime firstSeen,
        org.joda.time.DateTime lastSeen
    ) {
        this.auditKnownDeviceId = auditKnownDeviceId;
        this.domainId = domainId;
        this.userId = userId;
        this.deviceId = deviceId;
        this.firstSeen = firstSeen;
        this.lastSeen = lastSeen;
    }

    /**
     * Getter for <code>core.audit_known_devices.audit_known_device_id</code>.
     */
    public java.lang.Long getAuditKnownDeviceId() {
        return this.auditKnownDeviceId;
    }

    /**
     * Setter for <code>core.audit_known_devices.audit_known_device_id</code>.
     */
    public void setAuditKnownDeviceId(java.lang.Long auditKnownDeviceId) {
        this.auditKnownDeviceId = auditKnownDeviceId;
    }

    /**
     * Getter for <code>core.audit_known_devices.domain_id</code>.
     */
    public java.lang.String getDomainId() {
        return this.domainId;
    }

    /**
     * Setter for <code>core.audit_known_devices.domain_id</code>.
     */
    public void setDomainId(java.lang.String domainId) {
        this.domainId = domainId;
    }

    /**
     * Getter for <code>core.audit_known_devices.user_id</code>.
     */
    public java.lang.String getUserId() {
        return this.userId;
    }

    /**
     * Setter for <code>core.audit_known_devices.user_id</code>.
     */
    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }

    /**
     * Getter for <code>core.audit_known_devices.device_id</code>.
     */
    public java.lang.String getDeviceId() {
        return this.deviceId;
    }

    /**
     * Setter for <code>core.audit_known_devices.device_id</code>.
     */
    public void setDeviceId(java.lang.String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * Getter for <code>core.audit_known_devices.first_seen</code>.
     */
    public org.joda.time.DateTime getFirstSeen() {
        return this.firstSeen;
    }

    /**
     * Setter for <code>core.audit_known_devices.first_seen</code>.
     */
    public void setFirstSeen(org.joda.time.DateTime firstSeen) {
        this.firstSeen = firstSeen;
    }

    /**
     * Getter for <code>core.audit_known_devices.last_seen</code>.
     */
    public org.joda.time.DateTime getLastSeen() {
        return this.lastSeen;
    }

    /**
     * Setter for <code>core.audit_known_devices.last_seen</code>.
     */
    public void setLastSeen(org.joda.time.DateTime lastSeen) {
        this.lastSeen = lastSeen;
    }

    @Override
    public String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("AuditKnownDevices (");

        sb.append(auditKnownDeviceId);
        sb.append(", ").append(domainId);
        sb.append(", ").append(userId);
        sb.append(", ").append(deviceId);
        sb.append(", ").append(firstSeen);
        sb.append(", ").append(lastSeen);

        sb.append(")");
        return sb.toString();
    }
}
