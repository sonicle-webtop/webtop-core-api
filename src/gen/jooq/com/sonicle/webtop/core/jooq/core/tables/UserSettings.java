/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.core.tables;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserSettings extends org.jooq.impl.TableImpl<com.sonicle.webtop.core.jooq.core.tables.records.UserSettingsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>core.user_settings</code>
     */
    public static final UserSettings USER_SETTINGS = new UserSettings();

    /**
     * The class holding records for this type
     */
    @java.lang.Override
    public java.lang.Class<com.sonicle.webtop.core.jooq.core.tables.records.UserSettingsRecord> getRecordType() {
        return com.sonicle.webtop.core.jooq.core.tables.records.UserSettingsRecord.class;
    }

    /**
     * The column <code>core.user_settings.domain_id</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.UserSettingsRecord, java.lang.String> DOMAIN_ID = createField(org.jooq.impl.DSL.name("domain_id"), org.jooq.impl.SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * The column <code>core.user_settings.user_id</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.UserSettingsRecord, java.lang.String> USER_ID = createField(org.jooq.impl.DSL.name("user_id"), org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>core.user_settings.service_id</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.UserSettingsRecord, java.lang.String> SERVICE_ID = createField(org.jooq.impl.DSL.name("service_id"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>core.user_settings.key</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.UserSettingsRecord, java.lang.String> KEY = createField(org.jooq.impl.DSL.name("key"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>core.user_settings.value</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.UserSettingsRecord, java.lang.String> VALUE = createField(org.jooq.impl.DSL.name("value"), org.jooq.impl.SQLDataType.CLOB, this, "");

    private UserSettings(org.jooq.Name alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.UserSettingsRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserSettings(org.jooq.Name alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.UserSettingsRecord> aliased, org.jooq.Field<?>[] parameters) {
        super(alias, null, aliased, parameters, org.jooq.impl.DSL.comment(""), org.jooq.TableOptions.table());
    }

    /**
     * Create an aliased <code>core.user_settings</code> table reference
     */
    public UserSettings(java.lang.String alias) {
        this(org.jooq.impl.DSL.name(alias), USER_SETTINGS);
    }

    /**
     * Create an aliased <code>core.user_settings</code> table reference
     */
    public UserSettings(org.jooq.Name alias) {
        this(alias, USER_SETTINGS);
    }

    /**
     * Create a <code>core.user_settings</code> table reference
     */
    public UserSettings() {
        this(org.jooq.impl.DSL.name("user_settings"), null);
    }

    public <O extends org.jooq.Record> UserSettings(org.jooq.Table<O> child, org.jooq.ForeignKey<O, com.sonicle.webtop.core.jooq.core.tables.records.UserSettingsRecord> key) {
        super(child, key, USER_SETTINGS);
    }

    @java.lang.Override
    public org.jooq.Schema getSchema() {
        return com.sonicle.webtop.core.jooq.core.Core.CORE;
    }

    @java.lang.Override
    public org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.UserSettingsRecord> getPrimaryKey() {
        return com.sonicle.webtop.core.jooq.core.Keys.USER_SETTINGS_PKEY;
    }

    @java.lang.Override
    public java.util.List<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.UserSettingsRecord>> getKeys() {
        return java.util.Arrays.<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.UserSettingsRecord>>asList(com.sonicle.webtop.core.jooq.core.Keys.USER_SETTINGS_PKEY);
    }

    @java.lang.Override
    public UserSettings as(java.lang.String alias) {
        return new UserSettings(org.jooq.impl.DSL.name(alias), this);
    }

    @java.lang.Override
    public UserSettings as(org.jooq.Name alias) {
        return new UserSettings(alias, this);
    }

    /**
     * Rename this table
     */
    @java.lang.Override
    public UserSettings rename(java.lang.String name) {
        return new UserSettings(org.jooq.impl.DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @java.lang.Override
    public UserSettings rename(org.jooq.Name name) {
        return new UserSettings(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @java.lang.Override
    public org.jooq.Row5<java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String> fieldsRow() {
        return (org.jooq.Row5) super.fieldsRow();
    }
}
