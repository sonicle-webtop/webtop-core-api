/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.core.tables;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RolesAssociations extends org.jooq.impl.TableImpl<com.sonicle.webtop.core.jooq.core.tables.records.RolesAssociationsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>core.roles_associations</code>
     */
    public static final RolesAssociations ROLES_ASSOCIATIONS = new RolesAssociations();

    /**
     * The class holding records for this type
     */
    @java.lang.Override
    public java.lang.Class<com.sonicle.webtop.core.jooq.core.tables.records.RolesAssociationsRecord> getRecordType() {
        return com.sonicle.webtop.core.jooq.core.tables.records.RolesAssociationsRecord.class;
    }

    /**
     * The column <code>core.roles_associations.role_association_id</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.RolesAssociationsRecord, java.lang.Integer> ROLE_ASSOCIATION_ID = createField(org.jooq.impl.DSL.name("role_association_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('core.seq_roles_associations'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>core.roles_associations.user_uid</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.RolesAssociationsRecord, java.lang.String> USER_UID = createField(org.jooq.impl.DSL.name("user_uid"), org.jooq.impl.SQLDataType.VARCHAR(36).nullable(false), this, "");

    /**
     * The column <code>core.roles_associations.role_uid</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.RolesAssociationsRecord, java.lang.String> ROLE_UID = createField(org.jooq.impl.DSL.name("role_uid"), org.jooq.impl.SQLDataType.VARCHAR(36).nullable(false), this, "");

    private RolesAssociations(org.jooq.Name alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.RolesAssociationsRecord> aliased) {
        this(alias, aliased, null);
    }

    private RolesAssociations(org.jooq.Name alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.RolesAssociationsRecord> aliased, org.jooq.Field<?>[] parameters) {
        super(alias, null, aliased, parameters, org.jooq.impl.DSL.comment(""), org.jooq.TableOptions.table());
    }

    /**
     * Create an aliased <code>core.roles_associations</code> table reference
     */
    public RolesAssociations(java.lang.String alias) {
        this(org.jooq.impl.DSL.name(alias), ROLES_ASSOCIATIONS);
    }

    /**
     * Create an aliased <code>core.roles_associations</code> table reference
     */
    public RolesAssociations(org.jooq.Name alias) {
        this(alias, ROLES_ASSOCIATIONS);
    }

    /**
     * Create a <code>core.roles_associations</code> table reference
     */
    public RolesAssociations() {
        this(org.jooq.impl.DSL.name("roles_associations"), null);
    }

    public <O extends org.jooq.Record> RolesAssociations(org.jooq.Table<O> child, org.jooq.ForeignKey<O, com.sonicle.webtop.core.jooq.core.tables.records.RolesAssociationsRecord> key) {
        super(child, key, ROLES_ASSOCIATIONS);
    }

    @java.lang.Override
    public org.jooq.Schema getSchema() {
        return com.sonicle.webtop.core.jooq.core.Core.CORE;
    }

    @java.lang.Override
    public java.util.List<org.jooq.Index> getIndexes() {
        return java.util.Arrays.<org.jooq.Index>asList(com.sonicle.webtop.core.jooq.core.Indexes.ROLES_ASSOCIATIONS_AK1, com.sonicle.webtop.core.jooq.core.Indexes.ROLES_ASSOCIATIONS_AK2);
    }

    @java.lang.Override
    public org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.RolesAssociationsRecord> getPrimaryKey() {
        return com.sonicle.webtop.core.jooq.core.Keys.ROLES_ASSOCIATIONS_PKEY;
    }

    @java.lang.Override
    public java.util.List<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.RolesAssociationsRecord>> getKeys() {
        return java.util.Arrays.<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.RolesAssociationsRecord>>asList(com.sonicle.webtop.core.jooq.core.Keys.ROLES_ASSOCIATIONS_PKEY);
    }

    @java.lang.Override
    public RolesAssociations as(java.lang.String alias) {
        return new RolesAssociations(org.jooq.impl.DSL.name(alias), this);
    }

    @java.lang.Override
    public RolesAssociations as(org.jooq.Name alias) {
        return new RolesAssociations(alias, this);
    }

    /**
     * Rename this table
     */
    @java.lang.Override
    public RolesAssociations rename(java.lang.String name) {
        return new RolesAssociations(org.jooq.impl.DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @java.lang.Override
    public RolesAssociations rename(org.jooq.Name name) {
        return new RolesAssociations(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @java.lang.Override
    public org.jooq.Row3<java.lang.Integer, java.lang.String, java.lang.String> fieldsRow() {
        return (org.jooq.Row3) super.fieldsRow();
    }
}
