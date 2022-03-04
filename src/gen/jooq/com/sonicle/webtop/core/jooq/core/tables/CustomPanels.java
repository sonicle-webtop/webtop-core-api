/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.core.tables;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CustomPanels extends org.jooq.impl.TableImpl<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>core.custom_panels</code>
     */
    public static final CustomPanels CUSTOM_PANELS = new CustomPanels();

    /**
     * The class holding records for this type
     */
    @java.lang.Override
    public java.lang.Class<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsRecord> getRecordType() {
        return com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsRecord.class;
    }

    /**
     * The column <code>core.custom_panels.custom_panel_id</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsRecord, java.lang.String> CUSTOM_PANEL_ID = createField(org.jooq.impl.DSL.name("custom_panel_id"), org.jooq.impl.SQLDataType.VARCHAR(22).nullable(false), this, "");

    /**
     * The column <code>core.custom_panels.domain_id</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsRecord, java.lang.String> DOMAIN_ID = createField(org.jooq.impl.DSL.name("domain_id"), org.jooq.impl.SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * The column <code>core.custom_panels.service_id</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsRecord, java.lang.String> SERVICE_ID = createField(org.jooq.impl.DSL.name("service_id"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>core.custom_panels.order</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsRecord, java.lang.Short> ORDER = createField(org.jooq.impl.DSL.name("order"), org.jooq.impl.SQLDataType.SMALLINT.nullable(false), this, "");

    /**
     * The column <code>core.custom_panels.name</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsRecord, java.lang.String> NAME = createField(org.jooq.impl.DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>core.custom_panels.description</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsRecord, java.lang.String> DESCRIPTION = createField(org.jooq.impl.DSL.name("description"), org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>core.custom_panels.title_i18n</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsRecord, java.lang.String> TITLE_I18N = createField(org.jooq.impl.DSL.name("title_i18n"), org.jooq.impl.SQLDataType.CLOB, this, "");

    private CustomPanels(org.jooq.Name alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsRecord> aliased) {
        this(alias, aliased, null);
    }

    private CustomPanels(org.jooq.Name alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsRecord> aliased, org.jooq.Field<?>[] parameters) {
        super(alias, null, aliased, parameters, org.jooq.impl.DSL.comment(""), org.jooq.TableOptions.table());
    }

    /**
     * Create an aliased <code>core.custom_panels</code> table reference
     */
    public CustomPanels(java.lang.String alias) {
        this(org.jooq.impl.DSL.name(alias), CUSTOM_PANELS);
    }

    /**
     * Create an aliased <code>core.custom_panels</code> table reference
     */
    public CustomPanels(org.jooq.Name alias) {
        this(alias, CUSTOM_PANELS);
    }

    /**
     * Create a <code>core.custom_panels</code> table reference
     */
    public CustomPanels() {
        this(org.jooq.impl.DSL.name("custom_panels"), null);
    }

    public <O extends org.jooq.Record> CustomPanels(org.jooq.Table<O> child, org.jooq.ForeignKey<O, com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsRecord> key) {
        super(child, key, CUSTOM_PANELS);
    }

    @java.lang.Override
    public org.jooq.Schema getSchema() {
        return com.sonicle.webtop.core.jooq.core.Core.CORE;
    }

    @java.lang.Override
    public java.util.List<org.jooq.Index> getIndexes() {
        return java.util.Arrays.<org.jooq.Index>asList(com.sonicle.webtop.core.jooq.core.Indexes.CUSTOM_PANELS_AK1);
    }

    @java.lang.Override
    public org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsRecord> getPrimaryKey() {
        return com.sonicle.webtop.core.jooq.core.Keys.CUSTOM_PANELS_PKEY;
    }

    @java.lang.Override
    public java.util.List<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsRecord>> getKeys() {
        return java.util.Arrays.<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsRecord>>asList(com.sonicle.webtop.core.jooq.core.Keys.CUSTOM_PANELS_PKEY);
    }

    @java.lang.Override
    public CustomPanels as(java.lang.String alias) {
        return new CustomPanels(org.jooq.impl.DSL.name(alias), this);
    }

    @java.lang.Override
    public CustomPanels as(org.jooq.Name alias) {
        return new CustomPanels(alias, this);
    }

    /**
     * Rename this table
     */
    @java.lang.Override
    public CustomPanels rename(java.lang.String name) {
        return new CustomPanels(org.jooq.impl.DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @java.lang.Override
    public CustomPanels rename(org.jooq.Name name) {
        return new CustomPanels(name, null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @java.lang.Override
    public org.jooq.Row7<java.lang.String, java.lang.String, java.lang.String, java.lang.Short, java.lang.String, java.lang.String, java.lang.String> fieldsRow() {
        return (org.jooq.Row7) super.fieldsRow();
    }
}
