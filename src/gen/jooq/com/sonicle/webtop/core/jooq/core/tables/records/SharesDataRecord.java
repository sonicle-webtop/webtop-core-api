/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.core.tables.records;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SharesDataRecord extends org.jooq.impl.UpdatableRecordImpl<SharesDataRecord> implements org.jooq.Record3<java.lang.Integer, java.lang.String, java.lang.String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>core.shares_data.share_id</code>.
     */
    public void setShareId(java.lang.Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>core.shares_data.share_id</code>.
     */
    public java.lang.Integer getShareId() {
        return (java.lang.Integer) get(0);
    }

    /**
     * Setter for <code>core.shares_data.user_uid</code>.
     */
    public void setUserUid(java.lang.String value) {
        set(1, value);
    }

    /**
     * Getter for <code>core.shares_data.user_uid</code>.
     */
    public java.lang.String getUserUid() {
        return (java.lang.String) get(1);
    }

    /**
     * Setter for <code>core.shares_data.value</code>.
     */
    public void setValue(java.lang.String value) {
        set(2, value);
    }

    /**
     * Getter for <code>core.shares_data.value</code>.
     */
    public java.lang.String getValue() {
        return (java.lang.String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @java.lang.Override
    public org.jooq.Record2<java.lang.Integer, java.lang.String> key() {
        return (org.jooq.Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @java.lang.Override
    public org.jooq.Row3<java.lang.Integer, java.lang.String, java.lang.String> fieldsRow() {
        return (org.jooq.Row3) super.fieldsRow();
    }

    @java.lang.Override
    public org.jooq.Row3<java.lang.Integer, java.lang.String, java.lang.String> valuesRow() {
        return (org.jooq.Row3) super.valuesRow();
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.Integer> field1() {
        return com.sonicle.webtop.core.jooq.core.tables.SharesData.SHARES_DATA.SHARE_ID;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field2() {
        return com.sonicle.webtop.core.jooq.core.tables.SharesData.SHARES_DATA.USER_UID;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field3() {
        return com.sonicle.webtop.core.jooq.core.tables.SharesData.SHARES_DATA.VALUE;
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
        return getValue();
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
        return getValue();
    }

    @java.lang.Override
    public SharesDataRecord value1(java.lang.Integer value) {
        setShareId(value);
        return this;
    }

    @java.lang.Override
    public SharesDataRecord value2(java.lang.String value) {
        setUserUid(value);
        return this;
    }

    @java.lang.Override
    public SharesDataRecord value3(java.lang.String value) {
        setValue(value);
        return this;
    }

    @java.lang.Override
    public SharesDataRecord values(java.lang.Integer value1, java.lang.String value2, java.lang.String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SharesDataRecord
     */
    public SharesDataRecord() {
        super(com.sonicle.webtop.core.jooq.core.tables.SharesData.SHARES_DATA);
    }

    /**
     * Create a detached, initialised SharesDataRecord
     */
    public SharesDataRecord(java.lang.Integer shareId, java.lang.String userUid, java.lang.String value) {
        super(com.sonicle.webtop.core.jooq.core.tables.SharesData.SHARES_DATA);

        setShareId(shareId);
        setUserUid(userUid);
        setValue(value);
    }
}
