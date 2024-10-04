/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.core.tables.records;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CustomFieldsRecord extends org.jooq.impl.UpdatableRecordImpl<CustomFieldsRecord> implements org.jooq.Record15<java.lang.String, java.lang.String, java.lang.String, java.lang.String, org.joda.time.DateTime, org.joda.time.DateTime, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>core.custom_fields.custom_field_id</code>.
     */
    public void setCustomFieldId(java.lang.String value) {
        set(0, value);
    }

    /**
     * Getter for <code>core.custom_fields.custom_field_id</code>.
     */
    public java.lang.String getCustomFieldId() {
        return (java.lang.String) get(0);
    }

    /**
     * Setter for <code>core.custom_fields.domain_id</code>.
     */
    public void setDomainId(java.lang.String value) {
        set(1, value);
    }

    /**
     * Getter for <code>core.custom_fields.domain_id</code>.
     */
    public java.lang.String getDomainId() {
        return (java.lang.String) get(1);
    }

    /**
     * Setter for <code>core.custom_fields.service_id</code>.
     */
    public void setServiceId(java.lang.String value) {
        set(2, value);
    }

    /**
     * Getter for <code>core.custom_fields.service_id</code>.
     */
    public java.lang.String getServiceId() {
        return (java.lang.String) get(2);
    }

    /**
     * Setter for <code>core.custom_fields.revision_status</code>.
     */
    public void setRevisionStatus(java.lang.String value) {
        set(3, value);
    }

    /**
     * Getter for <code>core.custom_fields.revision_status</code>.
     */
    public java.lang.String getRevisionStatus() {
        return (java.lang.String) get(3);
    }

    /**
     * Setter for <code>core.custom_fields.revision_timestamp</code>.
     */
    public void setRevisionTimestamp(org.joda.time.DateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>core.custom_fields.revision_timestamp</code>.
     */
    public org.joda.time.DateTime getRevisionTimestamp() {
        return (org.joda.time.DateTime) get(4);
    }

    /**
     * Setter for <code>core.custom_fields.creation_timestamp</code>.
     */
    public void setCreationTimestamp(org.joda.time.DateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>core.custom_fields.creation_timestamp</code>.
     */
    public org.joda.time.DateTime getCreationTimestamp() {
        return (org.joda.time.DateTime) get(5);
    }

    /**
     * Setter for <code>core.custom_fields.name</code>.
     */
    public void setName(java.lang.String value) {
        set(6, value);
    }

    /**
     * Getter for <code>core.custom_fields.name</code>.
     */
    public java.lang.String getName() {
        return (java.lang.String) get(6);
    }

    /**
     * Setter for <code>core.custom_fields.description</code>.
     */
    public void setDescription(java.lang.String value) {
        set(7, value);
    }

    /**
     * Getter for <code>core.custom_fields.description</code>.
     */
    public java.lang.String getDescription() {
        return (java.lang.String) get(7);
    }

    /**
     * Setter for <code>core.custom_fields.type</code>.
     */
    public void setType(java.lang.String value) {
        set(8, value);
    }

    /**
     * Getter for <code>core.custom_fields.type</code>.
     */
    public java.lang.String getType() {
        return (java.lang.String) get(8);
    }

    /**
     * Setter for <code>core.custom_fields.searchable</code>.
     */
    public void setSearchable(java.lang.Boolean value) {
        set(9, value);
    }

    /**
     * Getter for <code>core.custom_fields.searchable</code>.
     */
    public java.lang.Boolean getSearchable() {
        return (java.lang.Boolean) get(9);
    }

    /**
     * Setter for <code>core.custom_fields.previewable</code>.
     */
    public void setPreviewable(java.lang.Boolean value) {
        set(10, value);
    }

    /**
     * Getter for <code>core.custom_fields.previewable</code>.
     */
    public java.lang.Boolean getPreviewable() {
        return (java.lang.Boolean) get(10);
    }

    /**
     * Setter for <code>core.custom_fields.properties</code>.
     */
    public void setProperties(java.lang.String value) {
        set(11, value);
    }

    /**
     * Getter for <code>core.custom_fields.properties</code>.
     */
    public java.lang.String getProperties() {
        return (java.lang.String) get(11);
    }

    /**
     * Setter for <code>core.custom_fields.values</code>.
     */
    public void setValues(java.lang.String value) {
        set(12, value);
    }

    /**
     * Getter for <code>core.custom_fields.values</code>.
     */
    public java.lang.String getValues() {
        return (java.lang.String) get(12);
    }

    /**
     * Setter for <code>core.custom_fields.label_i18n</code>.
     */
    public void setLabelI18n(java.lang.String value) {
        set(13, value);
    }

    /**
     * Getter for <code>core.custom_fields.label_i18n</code>.
     */
    public java.lang.String getLabelI18n() {
        return (java.lang.String) get(13);
    }

    /**
     * Setter for <code>core.custom_fields.data_source_query_id</code>.
     */
    public void setDataSourceQueryId(java.lang.String value) {
        set(14, value);
    }

    /**
     * Getter for <code>core.custom_fields.data_source_query_id</code>.
     */
    public java.lang.String getDataSourceQueryId() {
        return (java.lang.String) get(14);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @java.lang.Override
    public org.jooq.Record1<java.lang.String> key() {
        return (org.jooq.Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record15 type implementation
    // -------------------------------------------------------------------------

    @java.lang.Override
    public org.jooq.Row15<java.lang.String, java.lang.String, java.lang.String, java.lang.String, org.joda.time.DateTime, org.joda.time.DateTime, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String> fieldsRow() {
        return (org.jooq.Row15) super.fieldsRow();
    }

    @java.lang.Override
    public org.jooq.Row15<java.lang.String, java.lang.String, java.lang.String, java.lang.String, org.joda.time.DateTime, org.joda.time.DateTime, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String> valuesRow() {
        return (org.jooq.Row15) super.valuesRow();
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field1() {
        return com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS.CUSTOM_FIELD_ID;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field2() {
        return com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS.DOMAIN_ID;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field3() {
        return com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS.SERVICE_ID;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field4() {
        return com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS.REVISION_STATUS;
    }

    @java.lang.Override
    public org.jooq.Field<org.joda.time.DateTime> field5() {
        return com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS.REVISION_TIMESTAMP;
    }

    @java.lang.Override
    public org.jooq.Field<org.joda.time.DateTime> field6() {
        return com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS.CREATION_TIMESTAMP;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field7() {
        return com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS.NAME;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field8() {
        return com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS.DESCRIPTION;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field9() {
        return com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS.TYPE;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.Boolean> field10() {
        return com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS.SEARCHABLE;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.Boolean> field11() {
        return com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS.PREVIEWABLE;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field12() {
        return com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS.PROPERTIES;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field13() {
        return com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS.VALUES;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field14() {
        return com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS.LABEL_I18N;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field15() {
        return com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS.DATA_SOURCE_QUERY_ID;
    }

    @java.lang.Override
    public java.lang.String component1() {
        return getCustomFieldId();
    }

    @java.lang.Override
    public java.lang.String component2() {
        return getDomainId();
    }

    @java.lang.Override
    public java.lang.String component3() {
        return getServiceId();
    }

    @java.lang.Override
    public java.lang.String component4() {
        return getRevisionStatus();
    }

    @java.lang.Override
    public org.joda.time.DateTime component5() {
        return getRevisionTimestamp();
    }

    @java.lang.Override
    public org.joda.time.DateTime component6() {
        return getCreationTimestamp();
    }

    @java.lang.Override
    public java.lang.String component7() {
        return getName();
    }

    @java.lang.Override
    public java.lang.String component8() {
        return getDescription();
    }

    @java.lang.Override
    public java.lang.String component9() {
        return getType();
    }

    @java.lang.Override
    public java.lang.Boolean component10() {
        return getSearchable();
    }

    @java.lang.Override
    public java.lang.Boolean component11() {
        return getPreviewable();
    }

    @java.lang.Override
    public java.lang.String component12() {
        return getProperties();
    }

    @java.lang.Override
    public java.lang.String component13() {
        return getValues();
    }

    @java.lang.Override
    public java.lang.String component14() {
        return getLabelI18n();
    }

    @java.lang.Override
    public java.lang.String component15() {
        return getDataSourceQueryId();
    }

    @java.lang.Override
    public java.lang.String value1() {
        return getCustomFieldId();
    }

    @java.lang.Override
    public java.lang.String value2() {
        return getDomainId();
    }

    @java.lang.Override
    public java.lang.String value3() {
        return getServiceId();
    }

    @java.lang.Override
    public java.lang.String value4() {
        return getRevisionStatus();
    }

    @java.lang.Override
    public org.joda.time.DateTime value5() {
        return getRevisionTimestamp();
    }

    @java.lang.Override
    public org.joda.time.DateTime value6() {
        return getCreationTimestamp();
    }

    @java.lang.Override
    public java.lang.String value7() {
        return getName();
    }

    @java.lang.Override
    public java.lang.String value8() {
        return getDescription();
    }

    @java.lang.Override
    public java.lang.String value9() {
        return getType();
    }

    @java.lang.Override
    public java.lang.Boolean value10() {
        return getSearchable();
    }

    @java.lang.Override
    public java.lang.Boolean value11() {
        return getPreviewable();
    }

    @java.lang.Override
    public java.lang.String value12() {
        return getProperties();
    }

    @java.lang.Override
    public java.lang.String value13() {
        return getValues();
    }

    @java.lang.Override
    public java.lang.String value14() {
        return getLabelI18n();
    }

    @java.lang.Override
    public java.lang.String value15() {
        return getDataSourceQueryId();
    }

    @java.lang.Override
    public CustomFieldsRecord value1(java.lang.String value) {
        setCustomFieldId(value);
        return this;
    }

    @java.lang.Override
    public CustomFieldsRecord value2(java.lang.String value) {
        setDomainId(value);
        return this;
    }

    @java.lang.Override
    public CustomFieldsRecord value3(java.lang.String value) {
        setServiceId(value);
        return this;
    }

    @java.lang.Override
    public CustomFieldsRecord value4(java.lang.String value) {
        setRevisionStatus(value);
        return this;
    }

    @java.lang.Override
    public CustomFieldsRecord value5(org.joda.time.DateTime value) {
        setRevisionTimestamp(value);
        return this;
    }

    @java.lang.Override
    public CustomFieldsRecord value6(org.joda.time.DateTime value) {
        setCreationTimestamp(value);
        return this;
    }

    @java.lang.Override
    public CustomFieldsRecord value7(java.lang.String value) {
        setName(value);
        return this;
    }

    @java.lang.Override
    public CustomFieldsRecord value8(java.lang.String value) {
        setDescription(value);
        return this;
    }

    @java.lang.Override
    public CustomFieldsRecord value9(java.lang.String value) {
        setType(value);
        return this;
    }

    @java.lang.Override
    public CustomFieldsRecord value10(java.lang.Boolean value) {
        setSearchable(value);
        return this;
    }

    @java.lang.Override
    public CustomFieldsRecord value11(java.lang.Boolean value) {
        setPreviewable(value);
        return this;
    }

    @java.lang.Override
    public CustomFieldsRecord value12(java.lang.String value) {
        setProperties(value);
        return this;
    }

    @java.lang.Override
    public CustomFieldsRecord value13(java.lang.String value) {
        setValues(value);
        return this;
    }

    @java.lang.Override
    public CustomFieldsRecord value14(java.lang.String value) {
        setLabelI18n(value);
        return this;
    }

    @java.lang.Override
    public CustomFieldsRecord value15(java.lang.String value) {
        setDataSourceQueryId(value);
        return this;
    }

    @java.lang.Override
    public CustomFieldsRecord values(java.lang.String value1, java.lang.String value2, java.lang.String value3, java.lang.String value4, org.joda.time.DateTime value5, org.joda.time.DateTime value6, java.lang.String value7, java.lang.String value8, java.lang.String value9, java.lang.Boolean value10, java.lang.Boolean value11, java.lang.String value12, java.lang.String value13, java.lang.String value14, java.lang.String value15) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CustomFieldsRecord
     */
    public CustomFieldsRecord() {
        super(com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS);
    }

    /**
     * Create a detached, initialised CustomFieldsRecord
     */
    public CustomFieldsRecord(java.lang.String customFieldId, java.lang.String domainId, java.lang.String serviceId, java.lang.String revisionStatus, org.joda.time.DateTime revisionTimestamp, org.joda.time.DateTime creationTimestamp, java.lang.String name, java.lang.String description, java.lang.String type, java.lang.Boolean searchable, java.lang.Boolean previewable, java.lang.String properties, java.lang.String values, java.lang.String labelI18n, java.lang.String dataSourceQueryId) {
        super(com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS);

        setCustomFieldId(customFieldId);
        setDomainId(domainId);
        setServiceId(serviceId);
        setRevisionStatus(revisionStatus);
        setRevisionTimestamp(revisionTimestamp);
        setCreationTimestamp(creationTimestamp);
        setName(name);
        setDescription(description);
        setType(type);
        setSearchable(searchable);
        setPreviewable(previewable);
        setProperties(properties);
        setValues(values);
        setLabelI18n(labelI18n);
        setDataSourceQueryId(dataSourceQueryId);
    }
}
