/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.core.tables;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CustomersDeprecated extends org.jooq.impl.TableImpl<com.sonicle.webtop.core.jooq.core.tables.records.CustomersDeprecatedRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>core.customers_deprecated</code>
     */
    public static final CustomersDeprecated CUSTOMERS_DEPRECATED = new CustomersDeprecated();

    /**
     * The class holding records for this type
     */
    @java.lang.Override
    public java.lang.Class<com.sonicle.webtop.core.jooq.core.tables.records.CustomersDeprecatedRecord> getRecordType() {
        return com.sonicle.webtop.core.jooq.core.tables.records.CustomersDeprecatedRecord.class;
    }

    /**
     * The column <code>core.customers_deprecated.customer_id</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomersDeprecatedRecord, java.lang.String> CUSTOMER_ID = createField(org.jooq.impl.DSL.name("customer_id"), org.jooq.impl.SQLDataType.VARCHAR(15).nullable(false), this, "");

    /**
     * The column <code>core.customers_deprecated.description</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomersDeprecatedRecord, java.lang.String> DESCRIPTION = createField(org.jooq.impl.DSL.name("description"), org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>core.customers_deprecated.type</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomersDeprecatedRecord, java.lang.String> TYPE = createField(org.jooq.impl.DSL.name("type"), org.jooq.impl.SQLDataType.VARCHAR(1), this, "");

    /**
     * The column <code>core.customers_deprecated.address</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomersDeprecatedRecord, java.lang.String> ADDRESS = createField(org.jooq.impl.DSL.name("address"), org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>core.customers_deprecated.city</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomersDeprecatedRecord, java.lang.String> CITY = createField(org.jooq.impl.DSL.name("city"), org.jooq.impl.SQLDataType.VARCHAR(30), this, "");

    /**
     * The column <code>core.customers_deprecated.state</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomersDeprecatedRecord, java.lang.String> STATE = createField(org.jooq.impl.DSL.name("state"), org.jooq.impl.SQLDataType.VARCHAR(30), this, "");

    /**
     * The column <code>core.customers_deprecated.postalcode</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomersDeprecatedRecord, java.lang.String> POSTALCODE = createField(org.jooq.impl.DSL.name("postalcode"), org.jooq.impl.SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>core.customers_deprecated.country</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomersDeprecatedRecord, java.lang.String> COUNTRY = createField(org.jooq.impl.DSL.name("country"), org.jooq.impl.SQLDataType.VARCHAR(30), this, "");

    /**
     * The column <code>core.customers_deprecated.telephone</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomersDeprecatedRecord, java.lang.String> TELEPHONE = createField(org.jooq.impl.DSL.name("telephone"), org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>core.customers_deprecated.email</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomersDeprecatedRecord, java.lang.String> EMAIL = createField(org.jooq.impl.DSL.name("email"), org.jooq.impl.SQLDataType.VARCHAR(80), this, "");

    /**
     * The column <code>core.customers_deprecated.from_drm</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomersDeprecatedRecord, java.lang.String> FROM_DRM = createField(org.jooq.impl.DSL.name("from_drm"), org.jooq.impl.SQLDataType.VARCHAR(5), this, "");

    /**
     * The column <code>core.customers_deprecated.parent_id</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomersDeprecatedRecord, java.lang.String> PARENT_ID = createField(org.jooq.impl.DSL.name("parent_id"), org.jooq.impl.SQLDataType.VARCHAR(15), this, "");

    /**
     * The column <code>core.customers_deprecated.external_id</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomersDeprecatedRecord, java.lang.String> EXTERNAL_ID = createField(org.jooq.impl.DSL.name("external_id"), org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>core.customers_deprecated.status</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomersDeprecatedRecord, java.lang.String> STATUS = createField(org.jooq.impl.DSL.name("status"), org.jooq.impl.SQLDataType.VARCHAR(1), this, "");

    /**
     * The column <code>core.customers_deprecated.domain_id</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomersDeprecatedRecord, java.lang.String> DOMAIN_ID = createField(org.jooq.impl.DSL.name("domain_id"), org.jooq.impl.SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>core.customers_deprecated.km</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomersDeprecatedRecord, java.lang.String> KM = createField(org.jooq.impl.DSL.name("km"), org.jooq.impl.SQLDataType.VARCHAR(15), this, "");

    /**
     * The column <code>core.customers_deprecated.lock</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomersDeprecatedRecord, java.lang.String> LOCK = createField(org.jooq.impl.DSL.name("lock"), org.jooq.impl.SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>core.customers_deprecated.note</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomersDeprecatedRecord, java.lang.String> NOTE = createField(org.jooq.impl.DSL.name("note"), org.jooq.impl.SQLDataType.VARCHAR(2000), this, "");

    private CustomersDeprecated(org.jooq.Name alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.CustomersDeprecatedRecord> aliased) {
        this(alias, aliased, null);
    }

    private CustomersDeprecated(org.jooq.Name alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.CustomersDeprecatedRecord> aliased, org.jooq.Field<?>[] parameters) {
        super(alias, null, aliased, parameters, org.jooq.impl.DSL.comment(""), org.jooq.TableOptions.table());
    }

    /**
     * Create an aliased <code>core.customers_deprecated</code> table reference
     */
    public CustomersDeprecated(java.lang.String alias) {
        this(org.jooq.impl.DSL.name(alias), CUSTOMERS_DEPRECATED);
    }

    /**
     * Create an aliased <code>core.customers_deprecated</code> table reference
     */
    public CustomersDeprecated(org.jooq.Name alias) {
        this(alias, CUSTOMERS_DEPRECATED);
    }

    /**
     * Create a <code>core.customers_deprecated</code> table reference
     */
    public CustomersDeprecated() {
        this(org.jooq.impl.DSL.name("customers_deprecated"), null);
    }

    public <O extends org.jooq.Record> CustomersDeprecated(org.jooq.Table<O> child, org.jooq.ForeignKey<O, com.sonicle.webtop.core.jooq.core.tables.records.CustomersDeprecatedRecord> key) {
        super(child, key, CUSTOMERS_DEPRECATED);
    }

    @java.lang.Override
    public org.jooq.Schema getSchema() {
        return com.sonicle.webtop.core.jooq.core.Core.CORE;
    }

    @java.lang.Override
    public java.util.List<org.jooq.Index> getIndexes() {
        return java.util.Arrays.<org.jooq.Index>asList(com.sonicle.webtop.core.jooq.core.Indexes.CUSTOMERS_AK1);
    }

    @java.lang.Override
    public org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomersDeprecatedRecord> getPrimaryKey() {
        return com.sonicle.webtop.core.jooq.core.Keys.CUSTOMERS_PKEY;
    }

    @java.lang.Override
    public java.util.List<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomersDeprecatedRecord>> getKeys() {
        return java.util.Arrays.<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomersDeprecatedRecord>>asList(com.sonicle.webtop.core.jooq.core.Keys.CUSTOMERS_PKEY);
    }

    @java.lang.Override
    public CustomersDeprecated as(java.lang.String alias) {
        return new CustomersDeprecated(org.jooq.impl.DSL.name(alias), this);
    }

    @java.lang.Override
    public CustomersDeprecated as(org.jooq.Name alias) {
        return new CustomersDeprecated(alias, this);
    }

    /**
     * Rename this table
     */
    @java.lang.Override
    public CustomersDeprecated rename(java.lang.String name) {
        return new CustomersDeprecated(org.jooq.impl.DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @java.lang.Override
    public CustomersDeprecated rename(org.jooq.Name name) {
        return new CustomersDeprecated(name, null);
    }

    // -------------------------------------------------------------------------
    // Row18 type methods
    // -------------------------------------------------------------------------

    @java.lang.Override
    public org.jooq.Row18<java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String> fieldsRow() {
        return (org.jooq.Row18) super.fieldsRow();
    }
}
