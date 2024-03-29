/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.core.tables;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SettingsDb extends org.jooq.impl.TableImpl<com.sonicle.webtop.core.jooq.core.tables.records.SettingsDbRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>core.settings_db</code>
     */
    public static final SettingsDb SETTINGS_DB = new SettingsDb();

    /**
     * The class holding records for this type
     */
    @java.lang.Override
    public java.lang.Class<com.sonicle.webtop.core.jooq.core.tables.records.SettingsDbRecord> getRecordType() {
        return com.sonicle.webtop.core.jooq.core.tables.records.SettingsDbRecord.class;
    }

    /**
     * The column <code>core.settings_db.service_id</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.SettingsDbRecord, java.lang.String> SERVICE_ID = createField(org.jooq.impl.DSL.name("service_id"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>core.settings_db.key</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.SettingsDbRecord, java.lang.String> KEY = createField(org.jooq.impl.DSL.name("key"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>core.settings_db.is_system</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.SettingsDbRecord, java.lang.Boolean> IS_SYSTEM = createField(org.jooq.impl.DSL.name("is_system"), org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("false", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>core.settings_db.is_domain</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.SettingsDbRecord, java.lang.Boolean> IS_DOMAIN = createField(org.jooq.impl.DSL.name("is_domain"), org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("false", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>core.settings_db.is_user</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.SettingsDbRecord, java.lang.Boolean> IS_USER = createField(org.jooq.impl.DSL.name("is_user"), org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("false", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>core.settings_db.hidden</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.SettingsDbRecord, java.lang.Boolean> HIDDEN = createField(org.jooq.impl.DSL.name("hidden"), org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("false", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>core.settings_db.type</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.SettingsDbRecord, java.lang.String> TYPE = createField(org.jooq.impl.DSL.name("type"), org.jooq.impl.SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * The column <code>core.settings_db.help</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.SettingsDbRecord, java.lang.String> HELP = createField(org.jooq.impl.DSL.name("help"), org.jooq.impl.SQLDataType.CLOB, this, "");

    private SettingsDb(org.jooq.Name alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.SettingsDbRecord> aliased) {
        this(alias, aliased, null);
    }

    private SettingsDb(org.jooq.Name alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.SettingsDbRecord> aliased, org.jooq.Field<?>[] parameters) {
        super(alias, null, aliased, parameters, org.jooq.impl.DSL.comment(""), org.jooq.TableOptions.table());
    }

    /**
     * Create an aliased <code>core.settings_db</code> table reference
     */
    public SettingsDb(java.lang.String alias) {
        this(org.jooq.impl.DSL.name(alias), SETTINGS_DB);
    }

    /**
     * Create an aliased <code>core.settings_db</code> table reference
     */
    public SettingsDb(org.jooq.Name alias) {
        this(alias, SETTINGS_DB);
    }

    /**
     * Create a <code>core.settings_db</code> table reference
     */
    public SettingsDb() {
        this(org.jooq.impl.DSL.name("settings_db"), null);
    }

    public <O extends org.jooq.Record> SettingsDb(org.jooq.Table<O> child, org.jooq.ForeignKey<O, com.sonicle.webtop.core.jooq.core.tables.records.SettingsDbRecord> key) {
        super(child, key, SETTINGS_DB);
    }

    @java.lang.Override
    public org.jooq.Schema getSchema() {
        return com.sonicle.webtop.core.jooq.core.Core.CORE;
    }

    @java.lang.Override
    public java.util.List<org.jooq.Index> getIndexes() {
        return java.util.Arrays.<org.jooq.Index>asList(com.sonicle.webtop.core.jooq.core.Indexes.SETTINGS_DB_AK1, com.sonicle.webtop.core.jooq.core.Indexes.SETTINGS_DB_AK2, com.sonicle.webtop.core.jooq.core.Indexes.SETTINGS_DB_AK3);
    }

    @java.lang.Override
    public org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.SettingsDbRecord> getPrimaryKey() {
        return com.sonicle.webtop.core.jooq.core.Keys.SETTINGS_DB_PKEY;
    }

    @java.lang.Override
    public java.util.List<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.SettingsDbRecord>> getKeys() {
        return java.util.Arrays.<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.SettingsDbRecord>>asList(com.sonicle.webtop.core.jooq.core.Keys.SETTINGS_DB_PKEY);
    }

    @java.lang.Override
    public SettingsDb as(java.lang.String alias) {
        return new SettingsDb(org.jooq.impl.DSL.name(alias), this);
    }

    @java.lang.Override
    public SettingsDb as(org.jooq.Name alias) {
        return new SettingsDb(alias, this);
    }

    /**
     * Rename this table
     */
    @java.lang.Override
    public SettingsDb rename(java.lang.String name) {
        return new SettingsDb(org.jooq.impl.DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @java.lang.Override
    public SettingsDb rename(org.jooq.Name name) {
        return new SettingsDb(name, null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @java.lang.Override
    public org.jooq.Row8<java.lang.String, java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.String> fieldsRow() {
        return (org.jooq.Row8) super.fieldsRow();
    }
}
