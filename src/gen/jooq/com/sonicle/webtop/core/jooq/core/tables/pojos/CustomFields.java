/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.core.tables.pojos;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CustomFields implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private java.lang.String       customFieldId;
    private java.lang.String       domainId;
    private java.lang.String       serviceId;
    private java.lang.String       revisionStatus;
    private org.joda.time.DateTime revisionTimestamp;
    private org.joda.time.DateTime creationTimestamp;
    private java.lang.String       name;
    private java.lang.String       description;
    private java.lang.String       type;
    private java.lang.Boolean      searchable;
    private java.lang.Boolean      previewable;
    private java.lang.String       properties;
    private java.lang.String       values;
    private java.lang.String       labelI18n;

    public CustomFields() {}

    public CustomFields(CustomFields value) {
        this.customFieldId = value.customFieldId;
        this.domainId = value.domainId;
        this.serviceId = value.serviceId;
        this.revisionStatus = value.revisionStatus;
        this.revisionTimestamp = value.revisionTimestamp;
        this.creationTimestamp = value.creationTimestamp;
        this.name = value.name;
        this.description = value.description;
        this.type = value.type;
        this.searchable = value.searchable;
        this.previewable = value.previewable;
        this.properties = value.properties;
        this.values = value.values;
        this.labelI18n = value.labelI18n;
    }

    public CustomFields(
        java.lang.String       customFieldId,
        java.lang.String       domainId,
        java.lang.String       serviceId,
        java.lang.String       revisionStatus,
        org.joda.time.DateTime revisionTimestamp,
        org.joda.time.DateTime creationTimestamp,
        java.lang.String       name,
        java.lang.String       description,
        java.lang.String       type,
        java.lang.Boolean      searchable,
        java.lang.Boolean      previewable,
        java.lang.String       properties,
        java.lang.String       values,
        java.lang.String       labelI18n
    ) {
        this.customFieldId = customFieldId;
        this.domainId = domainId;
        this.serviceId = serviceId;
        this.revisionStatus = revisionStatus;
        this.revisionTimestamp = revisionTimestamp;
        this.creationTimestamp = creationTimestamp;
        this.name = name;
        this.description = description;
        this.type = type;
        this.searchable = searchable;
        this.previewable = previewable;
        this.properties = properties;
        this.values = values;
        this.labelI18n = labelI18n;
    }

    /**
     * Getter for <code>core.custom_fields.custom_field_id</code>.
     */
    public java.lang.String getCustomFieldId() {
        return this.customFieldId;
    }

    /**
     * Setter for <code>core.custom_fields.custom_field_id</code>.
     */
    public void setCustomFieldId(java.lang.String customFieldId) {
        this.customFieldId = customFieldId;
    }

    /**
     * Getter for <code>core.custom_fields.domain_id</code>.
     */
    public java.lang.String getDomainId() {
        return this.domainId;
    }

    /**
     * Setter for <code>core.custom_fields.domain_id</code>.
     */
    public void setDomainId(java.lang.String domainId) {
        this.domainId = domainId;
    }

    /**
     * Getter for <code>core.custom_fields.service_id</code>.
     */
    public java.lang.String getServiceId() {
        return this.serviceId;
    }

    /**
     * Setter for <code>core.custom_fields.service_id</code>.
     */
    public void setServiceId(java.lang.String serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * Getter for <code>core.custom_fields.revision_status</code>.
     */
    public java.lang.String getRevisionStatus() {
        return this.revisionStatus;
    }

    /**
     * Setter for <code>core.custom_fields.revision_status</code>.
     */
    public void setRevisionStatus(java.lang.String revisionStatus) {
        this.revisionStatus = revisionStatus;
    }

    /**
     * Getter for <code>core.custom_fields.revision_timestamp</code>.
     */
    public org.joda.time.DateTime getRevisionTimestamp() {
        return this.revisionTimestamp;
    }

    /**
     * Setter for <code>core.custom_fields.revision_timestamp</code>.
     */
    public void setRevisionTimestamp(org.joda.time.DateTime revisionTimestamp) {
        this.revisionTimestamp = revisionTimestamp;
    }

    /**
     * Getter for <code>core.custom_fields.creation_timestamp</code>.
     */
    public org.joda.time.DateTime getCreationTimestamp() {
        return this.creationTimestamp;
    }

    /**
     * Setter for <code>core.custom_fields.creation_timestamp</code>.
     */
    public void setCreationTimestamp(org.joda.time.DateTime creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    /**
     * Getter for <code>core.custom_fields.name</code>.
     */
    public java.lang.String getName() {
        return this.name;
    }

    /**
     * Setter for <code>core.custom_fields.name</code>.
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }

    /**
     * Getter for <code>core.custom_fields.description</code>.
     */
    public java.lang.String getDescription() {
        return this.description;
    }

    /**
     * Setter for <code>core.custom_fields.description</code>.
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    /**
     * Getter for <code>core.custom_fields.type</code>.
     */
    public java.lang.String getType() {
        return this.type;
    }

    /**
     * Setter for <code>core.custom_fields.type</code>.
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }

    /**
     * Getter for <code>core.custom_fields.searchable</code>.
     */
    public java.lang.Boolean getSearchable() {
        return this.searchable;
    }

    /**
     * Setter for <code>core.custom_fields.searchable</code>.
     */
    public void setSearchable(java.lang.Boolean searchable) {
        this.searchable = searchable;
    }

    /**
     * Getter for <code>core.custom_fields.previewable</code>.
     */
    public java.lang.Boolean getPreviewable() {
        return this.previewable;
    }

    /**
     * Setter for <code>core.custom_fields.previewable</code>.
     */
    public void setPreviewable(java.lang.Boolean previewable) {
        this.previewable = previewable;
    }

    /**
     * Getter for <code>core.custom_fields.properties</code>.
     */
    public java.lang.String getProperties() {
        return this.properties;
    }

    /**
     * Setter for <code>core.custom_fields.properties</code>.
     */
    public void setProperties(java.lang.String properties) {
        this.properties = properties;
    }

    /**
     * Getter for <code>core.custom_fields.values</code>.
     */
    public java.lang.String getValues() {
        return this.values;
    }

    /**
     * Setter for <code>core.custom_fields.values</code>.
     */
    public void setValues(java.lang.String values) {
        this.values = values;
    }

    /**
     * Getter for <code>core.custom_fields.label_i18n</code>.
     */
    public java.lang.String getLabelI18n() {
        return this.labelI18n;
    }

    /**
     * Setter for <code>core.custom_fields.label_i18n</code>.
     */
    public void setLabelI18n(java.lang.String labelI18n) {
        this.labelI18n = labelI18n;
    }

    @Override
    public String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("CustomFields (");

        sb.append(customFieldId);
        sb.append(", ").append(domainId);
        sb.append(", ").append(serviceId);
        sb.append(", ").append(revisionStatus);
        sb.append(", ").append(revisionTimestamp);
        sb.append(", ").append(creationTimestamp);
        sb.append(", ").append(name);
        sb.append(", ").append(description);
        sb.append(", ").append(type);
        sb.append(", ").append(searchable);
        sb.append(", ").append(previewable);
        sb.append(", ").append(properties);
        sb.append(", ").append(values);
        sb.append(", ").append(labelI18n);

        sb.append(")");
        return sb.toString();
    }
}
