/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.config.tables.pojos;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class VirtualDomainNames implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private java.lang.Integer virtualDomainNameId;
    private java.lang.String  context;
    private java.lang.String  primaryName;
    private java.lang.String  virtualName;

    public VirtualDomainNames() {}

    public VirtualDomainNames(VirtualDomainNames value) {
        this.virtualDomainNameId = value.virtualDomainNameId;
        this.context = value.context;
        this.primaryName = value.primaryName;
        this.virtualName = value.virtualName;
    }

    public VirtualDomainNames(
        java.lang.Integer virtualDomainNameId,
        java.lang.String  context,
        java.lang.String  primaryName,
        java.lang.String  virtualName
    ) {
        this.virtualDomainNameId = virtualDomainNameId;
        this.context = context;
        this.primaryName = primaryName;
        this.virtualName = virtualName;
    }

    /**
     * Getter for <code>config.virtual_domain_names.virtual_domain_name_id</code>.
     */
    public java.lang.Integer getVirtualDomainNameId() {
        return this.virtualDomainNameId;
    }

    /**
     * Setter for <code>config.virtual_domain_names.virtual_domain_name_id</code>.
     */
    public void setVirtualDomainNameId(java.lang.Integer virtualDomainNameId) {
        this.virtualDomainNameId = virtualDomainNameId;
    }

    /**
     * Getter for <code>config.virtual_domain_names.context</code>.
     */
    public java.lang.String getContext() {
        return this.context;
    }

    /**
     * Setter for <code>config.virtual_domain_names.context</code>.
     */
    public void setContext(java.lang.String context) {
        this.context = context;
    }

    /**
     * Getter for <code>config.virtual_domain_names.primary_name</code>.
     */
    public java.lang.String getPrimaryName() {
        return this.primaryName;
    }

    /**
     * Setter for <code>config.virtual_domain_names.primary_name</code>.
     */
    public void setPrimaryName(java.lang.String primaryName) {
        this.primaryName = primaryName;
    }

    /**
     * Getter for <code>config.virtual_domain_names.virtual_name</code>.
     */
    public java.lang.String getVirtualName() {
        return this.virtualName;
    }

    /**
     * Setter for <code>config.virtual_domain_names.virtual_name</code>.
     */
    public void setVirtualName(java.lang.String virtualName) {
        this.virtualName = virtualName;
    }

    @Override
    public String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("VirtualDomainNames (");

        sb.append(virtualDomainNameId);
        sb.append(", ").append(context);
        sb.append(", ").append(primaryName);
        sb.append(", ").append(virtualName);

        sb.append(")");
        return sb.toString();
    }
}