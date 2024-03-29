/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.config.tables;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class VirtualAliases extends org.jooq.impl.TableImpl<com.sonicle.webtop.core.jooq.config.tables.records.VirtualAliasesRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>config.virtual_aliases</code>
     */
    public static final VirtualAliases VIRTUAL_ALIASES = new VirtualAliases();

    /**
     * The class holding records for this type
     */
    @java.lang.Override
    public java.lang.Class<com.sonicle.webtop.core.jooq.config.tables.records.VirtualAliasesRecord> getRecordType() {
        return com.sonicle.webtop.core.jooq.config.tables.records.VirtualAliasesRecord.class;
    }

    /**
     * The column <code>config.virtual_aliases.virtual_alias_id</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.config.tables.records.VirtualAliasesRecord, java.lang.Integer> VIRTUAL_ALIAS_ID = createField(org.jooq.impl.DSL.name("virtual_alias_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('config.seq_virtual_aliases'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>config.virtual_aliases.context</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.config.tables.records.VirtualAliasesRecord, java.lang.String> CONTEXT = createField(org.jooq.impl.DSL.name("context"), org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>config.virtual_aliases.name</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.config.tables.records.VirtualAliasesRecord, java.lang.String> NAME = createField(org.jooq.impl.DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR(320).nullable(false), this, "");

    /**
     * The column <code>config.virtual_aliases.address</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.config.tables.records.VirtualAliasesRecord, java.lang.String> ADDRESS = createField(org.jooq.impl.DSL.name("address"), org.jooq.impl.SQLDataType.VARCHAR(320).nullable(false), this, "");

    private VirtualAliases(org.jooq.Name alias, org.jooq.Table<com.sonicle.webtop.core.jooq.config.tables.records.VirtualAliasesRecord> aliased) {
        this(alias, aliased, null);
    }

    private VirtualAliases(org.jooq.Name alias, org.jooq.Table<com.sonicle.webtop.core.jooq.config.tables.records.VirtualAliasesRecord> aliased, org.jooq.Field<?>[] parameters) {
        super(alias, null, aliased, parameters, org.jooq.impl.DSL.comment(""), org.jooq.TableOptions.table());
    }

    /**
     * Create an aliased <code>config.virtual_aliases</code> table reference
     */
    public VirtualAliases(java.lang.String alias) {
        this(org.jooq.impl.DSL.name(alias), VIRTUAL_ALIASES);
    }

    /**
     * Create an aliased <code>config.virtual_aliases</code> table reference
     */
    public VirtualAliases(org.jooq.Name alias) {
        this(alias, VIRTUAL_ALIASES);
    }

    /**
     * Create a <code>config.virtual_aliases</code> table reference
     */
    public VirtualAliases() {
        this(org.jooq.impl.DSL.name("virtual_aliases"), null);
    }

    public <O extends org.jooq.Record> VirtualAliases(org.jooq.Table<O> child, org.jooq.ForeignKey<O, com.sonicle.webtop.core.jooq.config.tables.records.VirtualAliasesRecord> key) {
        super(child, key, VIRTUAL_ALIASES);
    }

    @java.lang.Override
    public org.jooq.Schema getSchema() {
        return com.sonicle.webtop.core.jooq.config.Config.CONFIG;
    }

    @java.lang.Override
    public java.util.List<org.jooq.Index> getIndexes() {
        return java.util.Arrays.<org.jooq.Index>asList(com.sonicle.webtop.core.jooq.config.Indexes.VIRTUAL_ALIASES_AK1, com.sonicle.webtop.core.jooq.config.Indexes.VIRTUAL_ALIASES_AK2);
    }

    @java.lang.Override
    public org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.config.tables.records.VirtualAliasesRecord> getPrimaryKey() {
        return com.sonicle.webtop.core.jooq.config.Keys.VIRTUAL_ALIASES_PKEY;
    }

    @java.lang.Override
    public java.util.List<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.config.tables.records.VirtualAliasesRecord>> getKeys() {
        return java.util.Arrays.<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.config.tables.records.VirtualAliasesRecord>>asList(com.sonicle.webtop.core.jooq.config.Keys.VIRTUAL_ALIASES_PKEY);
    }

    @java.lang.Override
    public VirtualAliases as(java.lang.String alias) {
        return new VirtualAliases(org.jooq.impl.DSL.name(alias), this);
    }

    @java.lang.Override
    public VirtualAliases as(org.jooq.Name alias) {
        return new VirtualAliases(alias, this);
    }

    /**
     * Rename this table
     */
    @java.lang.Override
    public VirtualAliases rename(java.lang.String name) {
        return new VirtualAliases(org.jooq.impl.DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @java.lang.Override
    public VirtualAliases rename(org.jooq.Name name) {
        return new VirtualAliases(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @java.lang.Override
    public org.jooq.Row4<java.lang.Integer, java.lang.String, java.lang.String, java.lang.String> fieldsRow() {
        return (org.jooq.Row4) super.fieldsRow();
    }
}
