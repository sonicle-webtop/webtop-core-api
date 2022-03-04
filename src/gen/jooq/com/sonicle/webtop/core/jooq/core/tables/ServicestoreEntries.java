/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.core.tables;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ServicestoreEntries extends org.jooq.impl.TableImpl<com.sonicle.webtop.core.jooq.core.tables.records.ServicestoreEntriesRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>core.servicestore_entries</code>
     */
    public static final ServicestoreEntries SERVICESTORE_ENTRIES = new ServicestoreEntries();

    /**
     * The class holding records for this type
     */
    @java.lang.Override
    public java.lang.Class<com.sonicle.webtop.core.jooq.core.tables.records.ServicestoreEntriesRecord> getRecordType() {
        return com.sonicle.webtop.core.jooq.core.tables.records.ServicestoreEntriesRecord.class;
    }

    /**
     * The column <code>core.servicestore_entries.domain_id</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ServicestoreEntriesRecord, java.lang.String> DOMAIN_ID = createField(org.jooq.impl.DSL.name("domain_id"), org.jooq.impl.SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * The column <code>core.servicestore_entries.user_id</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ServicestoreEntriesRecord, java.lang.String> USER_ID = createField(org.jooq.impl.DSL.name("user_id"), org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>core.servicestore_entries.service_id</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ServicestoreEntriesRecord, java.lang.String> SERVICE_ID = createField(org.jooq.impl.DSL.name("service_id"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>core.servicestore_entries.context</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ServicestoreEntriesRecord, java.lang.String> CONTEXT = createField(org.jooq.impl.DSL.name("context"), org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>core.servicestore_entries.key</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ServicestoreEntriesRecord, java.lang.String> KEY = createField(org.jooq.impl.DSL.name("key"), org.jooq.impl.SQLDataType.VARCHAR(1024).nullable(false), this, "");

    /**
     * The column <code>core.servicestore_entries.value</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ServicestoreEntriesRecord, java.lang.String> VALUE = createField(org.jooq.impl.DSL.name("value"), org.jooq.impl.SQLDataType.VARCHAR(1024).nullable(false), this, "");

    /**
     * The column <code>core.servicestore_entries.frequency</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ServicestoreEntriesRecord, java.lang.Integer> FREQUENCY = createField(org.jooq.impl.DSL.name("frequency"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>core.servicestore_entries.last_update</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ServicestoreEntriesRecord, org.joda.time.DateTime> LAST_UPDATE = createField(org.jooq.impl.DSL.name("last_update"), org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "", new com.sonicle.jooq.jsr310.OffsetDateTimeJodaConverter());

    private ServicestoreEntries(org.jooq.Name alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.ServicestoreEntriesRecord> aliased) {
        this(alias, aliased, null);
    }

    private ServicestoreEntries(org.jooq.Name alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.ServicestoreEntriesRecord> aliased, org.jooq.Field<?>[] parameters) {
        super(alias, null, aliased, parameters, org.jooq.impl.DSL.comment(""), org.jooq.TableOptions.table());
    }

    /**
     * Create an aliased <code>core.servicestore_entries</code> table reference
     */
    public ServicestoreEntries(java.lang.String alias) {
        this(org.jooq.impl.DSL.name(alias), SERVICESTORE_ENTRIES);
    }

    /**
     * Create an aliased <code>core.servicestore_entries</code> table reference
     */
    public ServicestoreEntries(org.jooq.Name alias) {
        this(alias, SERVICESTORE_ENTRIES);
    }

    /**
     * Create a <code>core.servicestore_entries</code> table reference
     */
    public ServicestoreEntries() {
        this(org.jooq.impl.DSL.name("servicestore_entries"), null);
    }

    public <O extends org.jooq.Record> ServicestoreEntries(org.jooq.Table<O> child, org.jooq.ForeignKey<O, com.sonicle.webtop.core.jooq.core.tables.records.ServicestoreEntriesRecord> key) {
        super(child, key, SERVICESTORE_ENTRIES);
    }

    @java.lang.Override
    public org.jooq.Schema getSchema() {
        return com.sonicle.webtop.core.jooq.core.Core.CORE;
    }

    @java.lang.Override
    public org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.ServicestoreEntriesRecord> getPrimaryKey() {
        return com.sonicle.webtop.core.jooq.core.Keys.SERVICESTORE_ENTRIES_PKEY;
    }

    @java.lang.Override
    public java.util.List<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.ServicestoreEntriesRecord>> getKeys() {
        return java.util.Arrays.<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.ServicestoreEntriesRecord>>asList(com.sonicle.webtop.core.jooq.core.Keys.SERVICESTORE_ENTRIES_PKEY);
    }

    @java.lang.Override
    public ServicestoreEntries as(java.lang.String alias) {
        return new ServicestoreEntries(org.jooq.impl.DSL.name(alias), this);
    }

    @java.lang.Override
    public ServicestoreEntries as(org.jooq.Name alias) {
        return new ServicestoreEntries(alias, this);
    }

    /**
     * Rename this table
     */
    @java.lang.Override
    public ServicestoreEntries rename(java.lang.String name) {
        return new ServicestoreEntries(org.jooq.impl.DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @java.lang.Override
    public ServicestoreEntries rename(org.jooq.Name name) {
        return new ServicestoreEntries(name, null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @java.lang.Override
    public org.jooq.Row8<java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, org.joda.time.DateTime> fieldsRow() {
        return (org.jooq.Row8) super.fieldsRow();
    }
}
