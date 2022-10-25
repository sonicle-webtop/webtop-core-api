/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.core.tables;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CustomPanelsFields extends org.jooq.impl.TableImpl<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>core.custom_panels_fields</code>
     */
    public static final CustomPanelsFields CUSTOM_PANELS_FIELDS = new CustomPanelsFields();

    /**
     * The class holding records for this type
     */
    @java.lang.Override
    public java.lang.Class<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord> getRecordType() {
        return com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord.class;
    }

    /**
     * The column <code>core.custom_panels_fields.custom_panel_id</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord, java.lang.String> CUSTOM_PANEL_ID = createField(org.jooq.impl.DSL.name("custom_panel_id"), org.jooq.impl.SQLDataType.VARCHAR(22).nullable(false), this, "");

    /**
     * The column <code>core.custom_panels_fields.custom_field_id</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord, java.lang.String> CUSTOM_FIELD_ID = createField(org.jooq.impl.DSL.name("custom_field_id"), org.jooq.impl.SQLDataType.VARCHAR(22).nullable(false), this, "");

    /**
     * The column <code>core.custom_panels_fields.order</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord, java.lang.Short> ORDER = createField(org.jooq.impl.DSL.name("order"), org.jooq.impl.SQLDataType.SMALLINT.nullable(false), this, "");

    private CustomPanelsFields(org.jooq.Name alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord> aliased) {
        this(alias, aliased, null);
    }

    private CustomPanelsFields(org.jooq.Name alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord> aliased, org.jooq.Field<?>[] parameters) {
        super(alias, null, aliased, parameters, org.jooq.impl.DSL.comment(""), org.jooq.TableOptions.table());
    }

    /**
     * Create an aliased <code>core.custom_panels_fields</code> table reference
     */
    public CustomPanelsFields(java.lang.String alias) {
        this(org.jooq.impl.DSL.name(alias), CUSTOM_PANELS_FIELDS);
    }

    /**
     * Create an aliased <code>core.custom_panels_fields</code> table reference
     */
    public CustomPanelsFields(org.jooq.Name alias) {
        this(alias, CUSTOM_PANELS_FIELDS);
    }

    /**
     * Create a <code>core.custom_panels_fields</code> table reference
     */
    public CustomPanelsFields() {
        this(org.jooq.impl.DSL.name("custom_panels_fields"), null);
    }

    public <O extends org.jooq.Record> CustomPanelsFields(org.jooq.Table<O> child, org.jooq.ForeignKey<O, com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord> key) {
        super(child, key, CUSTOM_PANELS_FIELDS);
    }

    @java.lang.Override
    public org.jooq.Schema getSchema() {
        return com.sonicle.webtop.core.jooq.core.Core.CORE;
    }

    @java.lang.Override
    public java.util.List<org.jooq.Index> getIndexes() {
        return java.util.Arrays.<org.jooq.Index>asList(com.sonicle.webtop.core.jooq.core.Indexes.CUSTOM_PANELS_FIELDS_AK1);
    }

    @java.lang.Override
    public org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord> getPrimaryKey() {
        return com.sonicle.webtop.core.jooq.core.Keys.CUSTOM_PANELS_FIELDS_PKEY;
    }

    @java.lang.Override
    public java.util.List<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord>> getKeys() {
        return java.util.Arrays.<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord>>asList(com.sonicle.webtop.core.jooq.core.Keys.CUSTOM_PANELS_FIELDS_PKEY);
    }

    @java.lang.Override
    public java.util.List<org.jooq.ForeignKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord, ?>> getReferences() {
        return java.util.Arrays.<org.jooq.ForeignKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord, ?>>asList(com.sonicle.webtop.core.jooq.core.Keys.CUSTOM_PANELS_FIELDS__CUSTOM_PANELS_FIELDS_CUSTOM_PANEL_ID_FKEY, com.sonicle.webtop.core.jooq.core.Keys.CUSTOM_PANELS_FIELDS__CUSTOM_PANELS_FIELDS_CUSTOM_FIELD_ID_FKEY);
    }

    private transient com.sonicle.webtop.core.jooq.core.tables.CustomPanels _customPanels;
    private transient com.sonicle.webtop.core.jooq.core.tables.CustomFields _customFields;

    public com.sonicle.webtop.core.jooq.core.tables.CustomPanels customPanels() {
        if (_customPanels == null)
            _customPanels = new com.sonicle.webtop.core.jooq.core.tables.CustomPanels(this, com.sonicle.webtop.core.jooq.core.Keys.CUSTOM_PANELS_FIELDS__CUSTOM_PANELS_FIELDS_CUSTOM_PANEL_ID_FKEY);

        return _customPanels;
    }

    public com.sonicle.webtop.core.jooq.core.tables.CustomFields customFields() {
        if (_customFields == null)
            _customFields = new com.sonicle.webtop.core.jooq.core.tables.CustomFields(this, com.sonicle.webtop.core.jooq.core.Keys.CUSTOM_PANELS_FIELDS__CUSTOM_PANELS_FIELDS_CUSTOM_FIELD_ID_FKEY);

        return _customFields;
    }

    @java.lang.Override
    public CustomPanelsFields as(java.lang.String alias) {
        return new CustomPanelsFields(org.jooq.impl.DSL.name(alias), this);
    }

    @java.lang.Override
    public CustomPanelsFields as(org.jooq.Name alias) {
        return new CustomPanelsFields(alias, this);
    }

    /**
     * Rename this table
     */
    @java.lang.Override
    public CustomPanelsFields rename(java.lang.String name) {
        return new CustomPanelsFields(org.jooq.impl.DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @java.lang.Override
    public CustomPanelsFields rename(org.jooq.Name name) {
        return new CustomPanelsFields(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @java.lang.Override
    public org.jooq.Row3<java.lang.String, java.lang.String, java.lang.Short> fieldsRow() {
        return (org.jooq.Row3) super.fieldsRow();
    }
}
