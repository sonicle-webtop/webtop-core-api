/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.core.tables;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LicensesLeases extends org.jooq.impl.TableImpl<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>core.licenses_leases</code>
     */
    public static final LicensesLeases LICENSES_LEASES = new LicensesLeases();

    /**
     * The class holding records for this type
     */
    @java.lang.Override
    public java.lang.Class<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord> getRecordType() {
        return com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord.class;
    }

    /**
     * The column <code>core.licenses_leases.domain_id</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord, java.lang.String> DOMAIN_ID = createField(org.jooq.impl.DSL.name("domain_id"), org.jooq.impl.SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * The column <code>core.licenses_leases.service_id</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord, java.lang.String> SERVICE_ID = createField(org.jooq.impl.DSL.name("service_id"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>core.licenses_leases.product_code</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord, java.lang.String> PRODUCT_CODE = createField(org.jooq.impl.DSL.name("product_code"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>core.licenses_leases.user_id</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord, java.lang.String> USER_ID = createField(org.jooq.impl.DSL.name("user_id"), org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>core.licenses_leases.lease_timestamp</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord, org.joda.time.DateTime> LEASE_TIMESTAMP = createField(org.jooq.impl.DSL.name("lease_timestamp"), org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "", new com.sonicle.jooq.jsr310.OffsetDateTimeJodaConverter());

    /**
     * The column <code>core.licenses_leases.lease_origin</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord, java.lang.String> LEASE_ORIGIN = createField(org.jooq.impl.DSL.name("lease_origin"), org.jooq.impl.SQLDataType.VARCHAR(10).nullable(false), this, "");

    private LicensesLeases(org.jooq.Name alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord> aliased) {
        this(alias, aliased, null);
    }

    private LicensesLeases(org.jooq.Name alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord> aliased, org.jooq.Field<?>[] parameters) {
        super(alias, null, aliased, parameters, org.jooq.impl.DSL.comment(""), org.jooq.TableOptions.table());
    }

    /**
     * Create an aliased <code>core.licenses_leases</code> table reference
     */
    public LicensesLeases(java.lang.String alias) {
        this(org.jooq.impl.DSL.name(alias), LICENSES_LEASES);
    }

    /**
     * Create an aliased <code>core.licenses_leases</code> table reference
     */
    public LicensesLeases(org.jooq.Name alias) {
        this(alias, LICENSES_LEASES);
    }

    /**
     * Create a <code>core.licenses_leases</code> table reference
     */
    public LicensesLeases() {
        this(org.jooq.impl.DSL.name("licenses_leases"), null);
    }

    public <O extends org.jooq.Record> LicensesLeases(org.jooq.Table<O> child, org.jooq.ForeignKey<O, com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord> key) {
        super(child, key, LICENSES_LEASES);
    }

    @java.lang.Override
    public org.jooq.Schema getSchema() {
        return com.sonicle.webtop.core.jooq.core.Core.CORE;
    }

    @java.lang.Override
    public java.util.List<org.jooq.Index> getIndexes() {
        return java.util.Arrays.<org.jooq.Index>asList(com.sonicle.webtop.core.jooq.core.Indexes.LICENSES_LEASES_AK1);
    }

    @java.lang.Override
    public org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord> getPrimaryKey() {
        return com.sonicle.webtop.core.jooq.core.Keys.LICENSES_LEASES_PKEY;
    }

    @java.lang.Override
    public java.util.List<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord>> getKeys() {
        return java.util.Arrays.<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord>>asList(com.sonicle.webtop.core.jooq.core.Keys.LICENSES_LEASES_PKEY);
    }

    @java.lang.Override
    public java.util.List<org.jooq.ForeignKey<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord, ?>> getReferences() {
        return java.util.Arrays.<org.jooq.ForeignKey<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord, ?>>asList(com.sonicle.webtop.core.jooq.core.Keys.LICENSES_LEASES__LICENSES_LEASES_DOMAIN_ID_SERVICE_ID_PRODUCT_CODE_FKEY);
    }

    private transient com.sonicle.webtop.core.jooq.core.tables.Licenses _licenses;

    public com.sonicle.webtop.core.jooq.core.tables.Licenses licenses() {
        if (_licenses == null)
            _licenses = new com.sonicle.webtop.core.jooq.core.tables.Licenses(this, com.sonicle.webtop.core.jooq.core.Keys.LICENSES_LEASES__LICENSES_LEASES_DOMAIN_ID_SERVICE_ID_PRODUCT_CODE_FKEY);

        return _licenses;
    }

    @java.lang.Override
    public LicensesLeases as(java.lang.String alias) {
        return new LicensesLeases(org.jooq.impl.DSL.name(alias), this);
    }

    @java.lang.Override
    public LicensesLeases as(org.jooq.Name alias) {
        return new LicensesLeases(alias, this);
    }

    /**
     * Rename this table
     */
    @java.lang.Override
    public LicensesLeases rename(java.lang.String name) {
        return new LicensesLeases(org.jooq.impl.DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @java.lang.Override
    public LicensesLeases rename(org.jooq.Name name) {
        return new LicensesLeases(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @java.lang.Override
    public org.jooq.Row6<java.lang.String, java.lang.String, java.lang.String, java.lang.String, org.joda.time.DateTime, java.lang.String> fieldsRow() {
        return (org.jooq.Row6) super.fieldsRow();
    }
}
