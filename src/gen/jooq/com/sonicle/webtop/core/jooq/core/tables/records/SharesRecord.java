/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.core.tables.records;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SharesRecord extends org.jooq.impl.UpdatableRecordImpl<SharesRecord> implements org.jooq.Record5<java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>core.shares.share_id</code>.
     */
    public void setShareId(java.lang.Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>core.shares.share_id</code>.
     */
    public java.lang.Integer getShareId() {
        return (java.lang.Integer) get(0);
    }

    /**
     * Setter for <code>core.shares.user_uid</code>.
     */
    public void setUserUid(java.lang.String value) {
        set(1, value);
    }

    /**
     * Getter for <code>core.shares.user_uid</code>.
     */
    public java.lang.String getUserUid() {
        return (java.lang.String) get(1);
    }

    /**
     * Setter for <code>core.shares.service_id</code>.
     */
    public void setServiceId(java.lang.String value) {
        set(2, value);
    }

    /**
     * Getter for <code>core.shares.service_id</code>.
     */
    public java.lang.String getServiceId() {
        return (java.lang.String) get(2);
    }

    /**
     * Setter for <code>core.shares.key</code>.
     */
    public void setKey(java.lang.String value) {
        set(3, value);
    }

    /**
     * Getter for <code>core.shares.key</code>.
     */
    public java.lang.String getKey() {
        return (java.lang.String) get(3);
    }

    /**
     * Setter for <code>core.shares.instance</code>.
     */
    public void setInstance(java.lang.String value) {
        set(4, value);
    }

    /**
     * Getter for <code>core.shares.instance</code>.
     */
    public java.lang.String getInstance() {
        return (java.lang.String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @java.lang.Override
    public org.jooq.Record1<java.lang.Integer> key() {
        return (org.jooq.Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @java.lang.Override
    public org.jooq.Row5<java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String> fieldsRow() {
        return (org.jooq.Row5) super.fieldsRow();
    }

    @java.lang.Override
    public org.jooq.Row5<java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String> valuesRow() {
        return (org.jooq.Row5) super.valuesRow();
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.Integer> field1() {
        return com.sonicle.webtop.core.jooq.core.tables.Shares.SHARES.SHARE_ID;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field2() {
        return com.sonicle.webtop.core.jooq.core.tables.Shares.SHARES.USER_UID;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field3() {
        return com.sonicle.webtop.core.jooq.core.tables.Shares.SHARES.SERVICE_ID;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field4() {
        return com.sonicle.webtop.core.jooq.core.tables.Shares.SHARES.KEY;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field5() {
        return com.sonicle.webtop.core.jooq.core.tables.Shares.SHARES.INSTANCE;
    }

    @java.lang.Override
    public java.lang.Integer component1() {
        return getShareId();
    }

    @java.lang.Override
    public java.lang.String component2() {
        return getUserUid();
    }

    @java.lang.Override
    public java.lang.String component3() {
        return getServiceId();
    }

    @java.lang.Override
    public java.lang.String component4() {
        return getKey();
    }

    @java.lang.Override
    public java.lang.String component5() {
        return getInstance();
    }

    @java.lang.Override
    public java.lang.Integer value1() {
        return getShareId();
    }

    @java.lang.Override
    public java.lang.String value2() {
        return getUserUid();
    }

    @java.lang.Override
    public java.lang.String value3() {
        return getServiceId();
    }

    @java.lang.Override
    public java.lang.String value4() {
        return getKey();
    }

    @java.lang.Override
    public java.lang.String value5() {
        return getInstance();
    }

    @java.lang.Override
    public SharesRecord value1(java.lang.Integer value) {
        setShareId(value);
        return this;
    }

    @java.lang.Override
    public SharesRecord value2(java.lang.String value) {
        setUserUid(value);
        return this;
    }

    @java.lang.Override
    public SharesRecord value3(java.lang.String value) {
        setServiceId(value);
        return this;
    }

    @java.lang.Override
    public SharesRecord value4(java.lang.String value) {
        setKey(value);
        return this;
    }

    @java.lang.Override
    public SharesRecord value5(java.lang.String value) {
        setInstance(value);
        return this;
    }

    @java.lang.Override
    public SharesRecord values(java.lang.Integer value1, java.lang.String value2, java.lang.String value3, java.lang.String value4, java.lang.String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SharesRecord
     */
    public SharesRecord() {
        super(com.sonicle.webtop.core.jooq.core.tables.Shares.SHARES);
    }

    /**
     * Create a detached, initialised SharesRecord
     */
    public SharesRecord(java.lang.Integer shareId, java.lang.String userUid, java.lang.String serviceId, java.lang.String key, java.lang.String instance) {
        super(com.sonicle.webtop.core.jooq.core.tables.Shares.SHARES);

        setShareId(shareId);
        setUserUid(userUid);
        setServiceId(serviceId);
        setKey(key);
        setInstance(instance);
    }
}
