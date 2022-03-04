/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.core.tables.pojos;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Causals implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private java.lang.Integer causalId;
    private java.lang.String  domainId;
    private java.lang.String  userId;
    private java.lang.String  masterDataId;
    private java.lang.String  revisionStatus;
    private java.lang.String  description;
    private java.lang.Boolean readOnly;
    private java.lang.String  externalId;

    public Causals() {}

    public Causals(Causals value) {
        this.causalId = value.causalId;
        this.domainId = value.domainId;
        this.userId = value.userId;
        this.masterDataId = value.masterDataId;
        this.revisionStatus = value.revisionStatus;
        this.description = value.description;
        this.readOnly = value.readOnly;
        this.externalId = value.externalId;
    }

    public Causals(
        java.lang.Integer causalId,
        java.lang.String  domainId,
        java.lang.String  userId,
        java.lang.String  masterDataId,
        java.lang.String  revisionStatus,
        java.lang.String  description,
        java.lang.Boolean readOnly,
        java.lang.String  externalId
    ) {
        this.causalId = causalId;
        this.domainId = domainId;
        this.userId = userId;
        this.masterDataId = masterDataId;
        this.revisionStatus = revisionStatus;
        this.description = description;
        this.readOnly = readOnly;
        this.externalId = externalId;
    }

    /**
     * Getter for <code>core.causals.causal_id</code>.
     */
    public java.lang.Integer getCausalId() {
        return this.causalId;
    }

    /**
     * Setter for <code>core.causals.causal_id</code>.
     */
    public void setCausalId(java.lang.Integer causalId) {
        this.causalId = causalId;
    }

    /**
     * Getter for <code>core.causals.domain_id</code>.
     */
    public java.lang.String getDomainId() {
        return this.domainId;
    }

    /**
     * Setter for <code>core.causals.domain_id</code>.
     */
    public void setDomainId(java.lang.String domainId) {
        this.domainId = domainId;
    }

    /**
     * Getter for <code>core.causals.user_id</code>.
     */
    public java.lang.String getUserId() {
        return this.userId;
    }

    /**
     * Setter for <code>core.causals.user_id</code>.
     */
    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }

    /**
     * Getter for <code>core.causals.master_data_id</code>.
     */
    public java.lang.String getMasterDataId() {
        return this.masterDataId;
    }

    /**
     * Setter for <code>core.causals.master_data_id</code>.
     */
    public void setMasterDataId(java.lang.String masterDataId) {
        this.masterDataId = masterDataId;
    }

    /**
     * Getter for <code>core.causals.revision_status</code>.
     */
    public java.lang.String getRevisionStatus() {
        return this.revisionStatus;
    }

    /**
     * Setter for <code>core.causals.revision_status</code>.
     */
    public void setRevisionStatus(java.lang.String revisionStatus) {
        this.revisionStatus = revisionStatus;
    }

    /**
     * Getter for <code>core.causals.description</code>.
     */
    public java.lang.String getDescription() {
        return this.description;
    }

    /**
     * Setter for <code>core.causals.description</code>.
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    /**
     * Getter for <code>core.causals.read_only</code>.
     */
    public java.lang.Boolean getReadOnly() {
        return this.readOnly;
    }

    /**
     * Setter for <code>core.causals.read_only</code>.
     */
    public void setReadOnly(java.lang.Boolean readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * Getter for <code>core.causals.external_id</code>.
     */
    public java.lang.String getExternalId() {
        return this.externalId;
    }

    /**
     * Setter for <code>core.causals.external_id</code>.
     */
    public void setExternalId(java.lang.String externalId) {
        this.externalId = externalId;
    }

    @Override
    public String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Causals (");

        sb.append(causalId);
        sb.append(", ").append(domainId);
        sb.append(", ").append(userId);
        sb.append(", ").append(masterDataId);
        sb.append(", ").append(revisionStatus);
        sb.append(", ").append(description);
        sb.append(", ").append(readOnly);
        sb.append(", ").append(externalId);

        sb.append(")");
        return sb.toString();
    }
}
