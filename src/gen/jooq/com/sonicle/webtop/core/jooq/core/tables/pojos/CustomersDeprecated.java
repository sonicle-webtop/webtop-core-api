/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.core.tables.pojos;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CustomersDeprecated implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private java.lang.String customerId;
    private java.lang.String description;
    private java.lang.String type;
    private java.lang.String address;
    private java.lang.String city;
    private java.lang.String state;
    private java.lang.String postalcode;
    private java.lang.String country;
    private java.lang.String telephone;
    private java.lang.String email;
    private java.lang.String fromDrm;
    private java.lang.String parentId;
    private java.lang.String externalId;
    private java.lang.String status;
    private java.lang.String domainId;
    private java.lang.String km;
    private java.lang.String lock;
    private java.lang.String note;

    public CustomersDeprecated() {}

    public CustomersDeprecated(CustomersDeprecated value) {
        this.customerId = value.customerId;
        this.description = value.description;
        this.type = value.type;
        this.address = value.address;
        this.city = value.city;
        this.state = value.state;
        this.postalcode = value.postalcode;
        this.country = value.country;
        this.telephone = value.telephone;
        this.email = value.email;
        this.fromDrm = value.fromDrm;
        this.parentId = value.parentId;
        this.externalId = value.externalId;
        this.status = value.status;
        this.domainId = value.domainId;
        this.km = value.km;
        this.lock = value.lock;
        this.note = value.note;
    }

    public CustomersDeprecated(
        java.lang.String customerId,
        java.lang.String description,
        java.lang.String type,
        java.lang.String address,
        java.lang.String city,
        java.lang.String state,
        java.lang.String postalcode,
        java.lang.String country,
        java.lang.String telephone,
        java.lang.String email,
        java.lang.String fromDrm,
        java.lang.String parentId,
        java.lang.String externalId,
        java.lang.String status,
        java.lang.String domainId,
        java.lang.String km,
        java.lang.String lock,
        java.lang.String note
    ) {
        this.customerId = customerId;
        this.description = description;
        this.type = type;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postalcode = postalcode;
        this.country = country;
        this.telephone = telephone;
        this.email = email;
        this.fromDrm = fromDrm;
        this.parentId = parentId;
        this.externalId = externalId;
        this.status = status;
        this.domainId = domainId;
        this.km = km;
        this.lock = lock;
        this.note = note;
    }

    /**
     * Getter for <code>core.customers_deprecated.customer_id</code>.
     */
    public java.lang.String getCustomerId() {
        return this.customerId;
    }

    /**
     * Setter for <code>core.customers_deprecated.customer_id</code>.
     */
    public void setCustomerId(java.lang.String customerId) {
        this.customerId = customerId;
    }

    /**
     * Getter for <code>core.customers_deprecated.description</code>.
     */
    public java.lang.String getDescription() {
        return this.description;
    }

    /**
     * Setter for <code>core.customers_deprecated.description</code>.
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    /**
     * Getter for <code>core.customers_deprecated.type</code>.
     */
    public java.lang.String getType() {
        return this.type;
    }

    /**
     * Setter for <code>core.customers_deprecated.type</code>.
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }

    /**
     * Getter for <code>core.customers_deprecated.address</code>.
     */
    public java.lang.String getAddress() {
        return this.address;
    }

    /**
     * Setter for <code>core.customers_deprecated.address</code>.
     */
    public void setAddress(java.lang.String address) {
        this.address = address;
    }

    /**
     * Getter for <code>core.customers_deprecated.city</code>.
     */
    public java.lang.String getCity() {
        return this.city;
    }

    /**
     * Setter for <code>core.customers_deprecated.city</code>.
     */
    public void setCity(java.lang.String city) {
        this.city = city;
    }

    /**
     * Getter for <code>core.customers_deprecated.state</code>.
     */
    public java.lang.String getState() {
        return this.state;
    }

    /**
     * Setter for <code>core.customers_deprecated.state</code>.
     */
    public void setState(java.lang.String state) {
        this.state = state;
    }

    /**
     * Getter for <code>core.customers_deprecated.postalcode</code>.
     */
    public java.lang.String getPostalcode() {
        return this.postalcode;
    }

    /**
     * Setter for <code>core.customers_deprecated.postalcode</code>.
     */
    public void setPostalcode(java.lang.String postalcode) {
        this.postalcode = postalcode;
    }

    /**
     * Getter for <code>core.customers_deprecated.country</code>.
     */
    public java.lang.String getCountry() {
        return this.country;
    }

    /**
     * Setter for <code>core.customers_deprecated.country</code>.
     */
    public void setCountry(java.lang.String country) {
        this.country = country;
    }

    /**
     * Getter for <code>core.customers_deprecated.telephone</code>.
     */
    public java.lang.String getTelephone() {
        return this.telephone;
    }

    /**
     * Setter for <code>core.customers_deprecated.telephone</code>.
     */
    public void setTelephone(java.lang.String telephone) {
        this.telephone = telephone;
    }

    /**
     * Getter for <code>core.customers_deprecated.email</code>.
     */
    public java.lang.String getEmail() {
        return this.email;
    }

    /**
     * Setter for <code>core.customers_deprecated.email</code>.
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    /**
     * Getter for <code>core.customers_deprecated.from_drm</code>.
     */
    public java.lang.String getFromDrm() {
        return this.fromDrm;
    }

    /**
     * Setter for <code>core.customers_deprecated.from_drm</code>.
     */
    public void setFromDrm(java.lang.String fromDrm) {
        this.fromDrm = fromDrm;
    }

    /**
     * Getter for <code>core.customers_deprecated.parent_id</code>.
     */
    public java.lang.String getParentId() {
        return this.parentId;
    }

    /**
     * Setter for <code>core.customers_deprecated.parent_id</code>.
     */
    public void setParentId(java.lang.String parentId) {
        this.parentId = parentId;
    }

    /**
     * Getter for <code>core.customers_deprecated.external_id</code>.
     */
    public java.lang.String getExternalId() {
        return this.externalId;
    }

    /**
     * Setter for <code>core.customers_deprecated.external_id</code>.
     */
    public void setExternalId(java.lang.String externalId) {
        this.externalId = externalId;
    }

    /**
     * Getter for <code>core.customers_deprecated.status</code>.
     */
    public java.lang.String getStatus() {
        return this.status;
    }

    /**
     * Setter for <code>core.customers_deprecated.status</code>.
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    /**
     * Getter for <code>core.customers_deprecated.domain_id</code>.
     */
    public java.lang.String getDomainId() {
        return this.domainId;
    }

    /**
     * Setter for <code>core.customers_deprecated.domain_id</code>.
     */
    public void setDomainId(java.lang.String domainId) {
        this.domainId = domainId;
    }

    /**
     * Getter for <code>core.customers_deprecated.km</code>.
     */
    public java.lang.String getKm() {
        return this.km;
    }

    /**
     * Setter for <code>core.customers_deprecated.km</code>.
     */
    public void setKm(java.lang.String km) {
        this.km = km;
    }

    /**
     * Getter for <code>core.customers_deprecated.lock</code>.
     */
    public java.lang.String getLock() {
        return this.lock;
    }

    /**
     * Setter for <code>core.customers_deprecated.lock</code>.
     */
    public void setLock(java.lang.String lock) {
        this.lock = lock;
    }

    /**
     * Getter for <code>core.customers_deprecated.note</code>.
     */
    public java.lang.String getNote() {
        return this.note;
    }

    /**
     * Setter for <code>core.customers_deprecated.note</code>.
     */
    public void setNote(java.lang.String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("CustomersDeprecated (");

        sb.append(customerId);
        sb.append(", ").append(description);
        sb.append(", ").append(type);
        sb.append(", ").append(address);
        sb.append(", ").append(city);
        sb.append(", ").append(state);
        sb.append(", ").append(postalcode);
        sb.append(", ").append(country);
        sb.append(", ").append(telephone);
        sb.append(", ").append(email);
        sb.append(", ").append(fromDrm);
        sb.append(", ").append(parentId);
        sb.append(", ").append(externalId);
        sb.append(", ").append(status);
        sb.append(", ").append(domainId);
        sb.append(", ").append(km);
        sb.append(", ").append(lock);
        sb.append(", ").append(note);

        sb.append(")");
        return sb.toString();
    }
}
