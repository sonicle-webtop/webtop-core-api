/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.core.tables.pojos;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Licenses implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private java.lang.String        domainId;
    private java.lang.String        serviceId;
    private java.lang.String        productCode;
    private java.lang.String        string;
    private org.joda.time.DateTime  revisionTimestamp;
    private java.lang.String        activatedString;
    private org.joda.time.DateTime  activationTimestamp;
    private java.lang.String        activationHwId;
    private org.joda.time.LocalDate expirationDate;
    private java.lang.Integer       quantity;
    private java.lang.Boolean       autoLease;

    public Licenses() {}

    public Licenses(Licenses value) {
        this.domainId = value.domainId;
        this.serviceId = value.serviceId;
        this.productCode = value.productCode;
        this.string = value.string;
        this.revisionTimestamp = value.revisionTimestamp;
        this.activatedString = value.activatedString;
        this.activationTimestamp = value.activationTimestamp;
        this.activationHwId = value.activationHwId;
        this.expirationDate = value.expirationDate;
        this.quantity = value.quantity;
        this.autoLease = value.autoLease;
    }

    public Licenses(
        java.lang.String        domainId,
        java.lang.String        serviceId,
        java.lang.String        productCode,
        java.lang.String        string,
        org.joda.time.DateTime  revisionTimestamp,
        java.lang.String        activatedString,
        org.joda.time.DateTime  activationTimestamp,
        java.lang.String        activationHwId,
        org.joda.time.LocalDate expirationDate,
        java.lang.Integer       quantity,
        java.lang.Boolean       autoLease
    ) {
        this.domainId = domainId;
        this.serviceId = serviceId;
        this.productCode = productCode;
        this.string = string;
        this.revisionTimestamp = revisionTimestamp;
        this.activatedString = activatedString;
        this.activationTimestamp = activationTimestamp;
        this.activationHwId = activationHwId;
        this.expirationDate = expirationDate;
        this.quantity = quantity;
        this.autoLease = autoLease;
    }

    /**
     * Getter for <code>core.licenses.domain_id</code>.
     */
    public java.lang.String getDomainId() {
        return this.domainId;
    }

    /**
     * Setter for <code>core.licenses.domain_id</code>.
     */
    public void setDomainId(java.lang.String domainId) {
        this.domainId = domainId;
    }

    /**
     * Getter for <code>core.licenses.service_id</code>.
     */
    public java.lang.String getServiceId() {
        return this.serviceId;
    }

    /**
     * Setter for <code>core.licenses.service_id</code>.
     */
    public void setServiceId(java.lang.String serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * Getter for <code>core.licenses.product_code</code>.
     */
    public java.lang.String getProductCode() {
        return this.productCode;
    }

    /**
     * Setter for <code>core.licenses.product_code</code>.
     */
    public void setProductCode(java.lang.String productCode) {
        this.productCode = productCode;
    }

    /**
     * Getter for <code>core.licenses.string</code>.
     */
    public java.lang.String getString() {
        return this.string;
    }

    /**
     * Setter for <code>core.licenses.string</code>.
     */
    public void setString(java.lang.String string) {
        this.string = string;
    }

    /**
     * Getter for <code>core.licenses.revision_timestamp</code>.
     */
    public org.joda.time.DateTime getRevisionTimestamp() {
        return this.revisionTimestamp;
    }

    /**
     * Setter for <code>core.licenses.revision_timestamp</code>.
     */
    public void setRevisionTimestamp(org.joda.time.DateTime revisionTimestamp) {
        this.revisionTimestamp = revisionTimestamp;
    }

    /**
     * Getter for <code>core.licenses.activated_string</code>.
     */
    public java.lang.String getActivatedString() {
        return this.activatedString;
    }

    /**
     * Setter for <code>core.licenses.activated_string</code>.
     */
    public void setActivatedString(java.lang.String activatedString) {
        this.activatedString = activatedString;
    }

    /**
     * Getter for <code>core.licenses.activation_timestamp</code>.
     */
    public org.joda.time.DateTime getActivationTimestamp() {
        return this.activationTimestamp;
    }

    /**
     * Setter for <code>core.licenses.activation_timestamp</code>.
     */
    public void setActivationTimestamp(org.joda.time.DateTime activationTimestamp) {
        this.activationTimestamp = activationTimestamp;
    }

    /**
     * Getter for <code>core.licenses.activation_hw_id</code>.
     */
    public java.lang.String getActivationHwId() {
        return this.activationHwId;
    }

    /**
     * Setter for <code>core.licenses.activation_hw_id</code>.
     */
    public void setActivationHwId(java.lang.String activationHwId) {
        this.activationHwId = activationHwId;
    }

    /**
     * Getter for <code>core.licenses.expiration_date</code>.
     */
    public org.joda.time.LocalDate getExpirationDate() {
        return this.expirationDate;
    }

    /**
     * Setter for <code>core.licenses.expiration_date</code>.
     */
    public void setExpirationDate(org.joda.time.LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * Getter for <code>core.licenses.quantity</code>.
     */
    public java.lang.Integer getQuantity() {
        return this.quantity;
    }

    /**
     * Setter for <code>core.licenses.quantity</code>.
     */
    public void setQuantity(java.lang.Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Getter for <code>core.licenses.auto_lease</code>.
     */
    public java.lang.Boolean getAutoLease() {
        return this.autoLease;
    }

    /**
     * Setter for <code>core.licenses.auto_lease</code>.
     */
    public void setAutoLease(java.lang.Boolean autoLease) {
        this.autoLease = autoLease;
    }

    @Override
    public String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Licenses (");

        sb.append(domainId);
        sb.append(", ").append(serviceId);
        sb.append(", ").append(productCode);
        sb.append(", ").append(string);
        sb.append(", ").append(revisionTimestamp);
        sb.append(", ").append(activatedString);
        sb.append(", ").append(activationTimestamp);
        sb.append(", ").append(activationHwId);
        sb.append(", ").append(expirationDate);
        sb.append(", ").append(quantity);
        sb.append(", ").append(autoLease);

        sb.append(")");
        return sb.toString();
    }
}
