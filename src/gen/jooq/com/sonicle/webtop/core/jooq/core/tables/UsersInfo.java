/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.core.tables;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UsersInfo extends org.jooq.impl.TableImpl<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>core.users_info</code>
     */
    public static final UsersInfo USERS_INFO = new UsersInfo();

    /**
     * The class holding records for this type
     */
    @java.lang.Override
    public java.lang.Class<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord> getRecordType() {
        return com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord.class;
    }

    /**
     * The column <code>core.users_info.domain_id</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord, java.lang.String> DOMAIN_ID = createField(org.jooq.impl.DSL.name("domain_id"), org.jooq.impl.SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * The column <code>core.users_info.user_id</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord, java.lang.String> USER_ID = createField(org.jooq.impl.DSL.name("user_id"), org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>core.users_info.searchfield</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord, java.lang.String> SEARCHFIELD = createField(org.jooq.impl.DSL.name("searchfield"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>core.users_info.title</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord, java.lang.String> TITLE = createField(org.jooq.impl.DSL.name("title"), org.jooq.impl.SQLDataType.VARCHAR(30), this, "");

    /**
     * The column <code>core.users_info.first_name</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord, java.lang.String> FIRST_NAME = createField(org.jooq.impl.DSL.name("first_name"), org.jooq.impl.SQLDataType.VARCHAR(60), this, "");

    /**
     * The column <code>core.users_info.last_name</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord, java.lang.String> LAST_NAME = createField(org.jooq.impl.DSL.name("last_name"), org.jooq.impl.SQLDataType.VARCHAR(60), this, "");

    /**
     * The column <code>core.users_info.nickname</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord, java.lang.String> NICKNAME = createField(org.jooq.impl.DSL.name("nickname"), org.jooq.impl.SQLDataType.VARCHAR(60), this, "");

    /**
     * The column <code>core.users_info.gender</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord, java.lang.String> GENDER = createField(org.jooq.impl.DSL.name("gender"), org.jooq.impl.SQLDataType.VARCHAR(6), this, "");

    /**
     * The column <code>core.users_info.email</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord, java.lang.String> EMAIL = createField(org.jooq.impl.DSL.name("email"), org.jooq.impl.SQLDataType.VARCHAR(320), this, "");

    /**
     * The column <code>core.users_info.telephone</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord, java.lang.String> TELEPHONE = createField(org.jooq.impl.DSL.name("telephone"), org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>core.users_info.fax</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord, java.lang.String> FAX = createField(org.jooq.impl.DSL.name("fax"), org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>core.users_info.pager</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord, java.lang.String> PAGER = createField(org.jooq.impl.DSL.name("pager"), org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>core.users_info.mobile</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord, java.lang.String> MOBILE = createField(org.jooq.impl.DSL.name("mobile"), org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>core.users_info.address</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord, java.lang.String> ADDRESS = createField(org.jooq.impl.DSL.name("address"), org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>core.users_info.city</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord, java.lang.String> CITY = createField(org.jooq.impl.DSL.name("city"), org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>core.users_info.postal_code</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord, java.lang.String> POSTAL_CODE = createField(org.jooq.impl.DSL.name("postal_code"), org.jooq.impl.SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>core.users_info.state</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord, java.lang.String> STATE = createField(org.jooq.impl.DSL.name("state"), org.jooq.impl.SQLDataType.VARCHAR(30), this, "");

    /**
     * The column <code>core.users_info.country</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord, java.lang.String> COUNTRY = createField(org.jooq.impl.DSL.name("country"), org.jooq.impl.SQLDataType.VARCHAR(30), this, "");

    /**
     * The column <code>core.users_info.company</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord, java.lang.String> COMPANY = createField(org.jooq.impl.DSL.name("company"), org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>core.users_info.function</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord, java.lang.String> FUNCTION = createField(org.jooq.impl.DSL.name("function"), org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>core.users_info.custom1</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord, java.lang.String> CUSTOM1 = createField(org.jooq.impl.DSL.name("custom1"), org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>core.users_info.custom2</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord, java.lang.String> CUSTOM2 = createField(org.jooq.impl.DSL.name("custom2"), org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>core.users_info.custom3</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord, java.lang.String> CUSTOM3 = createField(org.jooq.impl.DSL.name("custom3"), org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    private UsersInfo(org.jooq.Name alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord> aliased) {
        this(alias, aliased, null);
    }

    private UsersInfo(org.jooq.Name alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord> aliased, org.jooq.Field<?>[] parameters) {
        super(alias, null, aliased, parameters, org.jooq.impl.DSL.comment(""), org.jooq.TableOptions.table());
    }

    /**
     * Create an aliased <code>core.users_info</code> table reference
     */
    public UsersInfo(java.lang.String alias) {
        this(org.jooq.impl.DSL.name(alias), USERS_INFO);
    }

    /**
     * Create an aliased <code>core.users_info</code> table reference
     */
    public UsersInfo(org.jooq.Name alias) {
        this(alias, USERS_INFO);
    }

    /**
     * Create a <code>core.users_info</code> table reference
     */
    public UsersInfo() {
        this(org.jooq.impl.DSL.name("users_info"), null);
    }

    public <O extends org.jooq.Record> UsersInfo(org.jooq.Table<O> child, org.jooq.ForeignKey<O, com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord> key) {
        super(child, key, USERS_INFO);
    }

    @java.lang.Override
    public org.jooq.Schema getSchema() {
        return com.sonicle.webtop.core.jooq.core.Core.CORE;
    }

    @java.lang.Override
    public org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord> getPrimaryKey() {
        return com.sonicle.webtop.core.jooq.core.Keys.USERS_INFO_PKEY;
    }

    @java.lang.Override
    public java.util.List<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord>> getKeys() {
        return java.util.Arrays.<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord>>asList(com.sonicle.webtop.core.jooq.core.Keys.USERS_INFO_PKEY);
    }

    @java.lang.Override
    public UsersInfo as(java.lang.String alias) {
        return new UsersInfo(org.jooq.impl.DSL.name(alias), this);
    }

    @java.lang.Override
    public UsersInfo as(org.jooq.Name alias) {
        return new UsersInfo(alias, this);
    }

    /**
     * Rename this table
     */
    @java.lang.Override
    public UsersInfo rename(java.lang.String name) {
        return new UsersInfo(org.jooq.impl.DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @java.lang.Override
    public UsersInfo rename(org.jooq.Name name) {
        return new UsersInfo(name, null);
    }
}
