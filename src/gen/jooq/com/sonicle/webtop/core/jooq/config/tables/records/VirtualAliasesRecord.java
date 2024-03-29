/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.config.tables.records;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class VirtualAliasesRecord extends org.jooq.impl.UpdatableRecordImpl<VirtualAliasesRecord> implements org.jooq.Record4<java.lang.Integer, java.lang.String, java.lang.String, java.lang.String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>config.virtual_aliases.virtual_alias_id</code>.
     */
    public void setVirtualAliasId(java.lang.Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>config.virtual_aliases.virtual_alias_id</code>.
     */
    public java.lang.Integer getVirtualAliasId() {
        return (java.lang.Integer) get(0);
    }

    /**
     * Setter for <code>config.virtual_aliases.context</code>.
     */
    public void setContext(java.lang.String value) {
        set(1, value);
    }

    /**
     * Getter for <code>config.virtual_aliases.context</code>.
     */
    public java.lang.String getContext() {
        return (java.lang.String) get(1);
    }

    /**
     * Setter for <code>config.virtual_aliases.name</code>.
     */
    public void setName(java.lang.String value) {
        set(2, value);
    }

    /**
     * Getter for <code>config.virtual_aliases.name</code>.
     */
    public java.lang.String getName() {
        return (java.lang.String) get(2);
    }

    /**
     * Setter for <code>config.virtual_aliases.address</code>.
     */
    public void setAddress(java.lang.String value) {
        set(3, value);
    }

    /**
     * Getter for <code>config.virtual_aliases.address</code>.
     */
    public java.lang.String getAddress() {
        return (java.lang.String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @java.lang.Override
    public org.jooq.Record1<java.lang.Integer> key() {
        return (org.jooq.Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @java.lang.Override
    public org.jooq.Row4<java.lang.Integer, java.lang.String, java.lang.String, java.lang.String> fieldsRow() {
        return (org.jooq.Row4) super.fieldsRow();
    }

    @java.lang.Override
    public org.jooq.Row4<java.lang.Integer, java.lang.String, java.lang.String, java.lang.String> valuesRow() {
        return (org.jooq.Row4) super.valuesRow();
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.Integer> field1() {
        return com.sonicle.webtop.core.jooq.config.tables.VirtualAliases.VIRTUAL_ALIASES.VIRTUAL_ALIAS_ID;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field2() {
        return com.sonicle.webtop.core.jooq.config.tables.VirtualAliases.VIRTUAL_ALIASES.CONTEXT;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field3() {
        return com.sonicle.webtop.core.jooq.config.tables.VirtualAliases.VIRTUAL_ALIASES.NAME;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field4() {
        return com.sonicle.webtop.core.jooq.config.tables.VirtualAliases.VIRTUAL_ALIASES.ADDRESS;
    }

    @java.lang.Override
    public java.lang.Integer component1() {
        return getVirtualAliasId();
    }

    @java.lang.Override
    public java.lang.String component2() {
        return getContext();
    }

    @java.lang.Override
    public java.lang.String component3() {
        return getName();
    }

    @java.lang.Override
    public java.lang.String component4() {
        return getAddress();
    }

    @java.lang.Override
    public java.lang.Integer value1() {
        return getVirtualAliasId();
    }

    @java.lang.Override
    public java.lang.String value2() {
        return getContext();
    }

    @java.lang.Override
    public java.lang.String value3() {
        return getName();
    }

    @java.lang.Override
    public java.lang.String value4() {
        return getAddress();
    }

    @java.lang.Override
    public VirtualAliasesRecord value1(java.lang.Integer value) {
        setVirtualAliasId(value);
        return this;
    }

    @java.lang.Override
    public VirtualAliasesRecord value2(java.lang.String value) {
        setContext(value);
        return this;
    }

    @java.lang.Override
    public VirtualAliasesRecord value3(java.lang.String value) {
        setName(value);
        return this;
    }

    @java.lang.Override
    public VirtualAliasesRecord value4(java.lang.String value) {
        setAddress(value);
        return this;
    }

    @java.lang.Override
    public VirtualAliasesRecord values(java.lang.Integer value1, java.lang.String value2, java.lang.String value3, java.lang.String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached VirtualAliasesRecord
     */
    public VirtualAliasesRecord() {
        super(com.sonicle.webtop.core.jooq.config.tables.VirtualAliases.VIRTUAL_ALIASES);
    }

    /**
     * Create a detached, initialised VirtualAliasesRecord
     */
    public VirtualAliasesRecord(java.lang.Integer virtualAliasId, java.lang.String context, java.lang.String name, java.lang.String address) {
        super(com.sonicle.webtop.core.jooq.config.tables.VirtualAliases.VIRTUAL_ALIASES);

        setVirtualAliasId(virtualAliasId);
        setContext(context);
        setName(name);
        setAddress(address);
    }
}
