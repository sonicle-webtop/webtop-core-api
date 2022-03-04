/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.core.tables.records;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserSettingsRecord extends org.jooq.impl.UpdatableRecordImpl<UserSettingsRecord> implements org.jooq.Record5<java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>core.user_settings.domain_id</code>.
     */
    public void setDomainId(java.lang.String value) {
        set(0, value);
    }

    /**
     * Getter for <code>core.user_settings.domain_id</code>.
     */
    public java.lang.String getDomainId() {
        return (java.lang.String) get(0);
    }

    /**
     * Setter for <code>core.user_settings.user_id</code>.
     */
    public void setUserId(java.lang.String value) {
        set(1, value);
    }

    /**
     * Getter for <code>core.user_settings.user_id</code>.
     */
    public java.lang.String getUserId() {
        return (java.lang.String) get(1);
    }

    /**
     * Setter for <code>core.user_settings.service_id</code>.
     */
    public void setServiceId(java.lang.String value) {
        set(2, value);
    }

    /**
     * Getter for <code>core.user_settings.service_id</code>.
     */
    public java.lang.String getServiceId() {
        return (java.lang.String) get(2);
    }

    /**
     * Setter for <code>core.user_settings.key</code>.
     */
    public void setKey(java.lang.String value) {
        set(3, value);
    }

    /**
     * Getter for <code>core.user_settings.key</code>.
     */
    public java.lang.String getKey() {
        return (java.lang.String) get(3);
    }

    /**
     * Setter for <code>core.user_settings.value</code>.
     */
    public void setValue(java.lang.String value) {
        set(4, value);
    }

    /**
     * Getter for <code>core.user_settings.value</code>.
     */
    public java.lang.String getValue() {
        return (java.lang.String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @java.lang.Override
    public org.jooq.Record4<java.lang.String, java.lang.String, java.lang.String, java.lang.String> key() {
        return (org.jooq.Record4) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @java.lang.Override
    public org.jooq.Row5<java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String> fieldsRow() {
        return (org.jooq.Row5) super.fieldsRow();
    }

    @java.lang.Override
    public org.jooq.Row5<java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String> valuesRow() {
        return (org.jooq.Row5) super.valuesRow();
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field1() {
        return com.sonicle.webtop.core.jooq.core.tables.UserSettings.USER_SETTINGS.DOMAIN_ID;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field2() {
        return com.sonicle.webtop.core.jooq.core.tables.UserSettings.USER_SETTINGS.USER_ID;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field3() {
        return com.sonicle.webtop.core.jooq.core.tables.UserSettings.USER_SETTINGS.SERVICE_ID;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field4() {
        return com.sonicle.webtop.core.jooq.core.tables.UserSettings.USER_SETTINGS.KEY;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field5() {
        return com.sonicle.webtop.core.jooq.core.tables.UserSettings.USER_SETTINGS.VALUE;
    }

    @java.lang.Override
    public java.lang.String component1() {
        return getDomainId();
    }

    @java.lang.Override
    public java.lang.String component2() {
        return getUserId();
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
        return getValue();
    }

    @java.lang.Override
    public java.lang.String value1() {
        return getDomainId();
    }

    @java.lang.Override
    public java.lang.String value2() {
        return getUserId();
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
        return getValue();
    }

    @java.lang.Override
    public UserSettingsRecord value1(java.lang.String value) {
        setDomainId(value);
        return this;
    }

    @java.lang.Override
    public UserSettingsRecord value2(java.lang.String value) {
        setUserId(value);
        return this;
    }

    @java.lang.Override
    public UserSettingsRecord value3(java.lang.String value) {
        setServiceId(value);
        return this;
    }

    @java.lang.Override
    public UserSettingsRecord value4(java.lang.String value) {
        setKey(value);
        return this;
    }

    @java.lang.Override
    public UserSettingsRecord value5(java.lang.String value) {
        setValue(value);
        return this;
    }

    @java.lang.Override
    public UserSettingsRecord values(java.lang.String value1, java.lang.String value2, java.lang.String value3, java.lang.String value4, java.lang.String value5) {
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
     * Create a detached UserSettingsRecord
     */
    public UserSettingsRecord() {
        super(com.sonicle.webtop.core.jooq.core.tables.UserSettings.USER_SETTINGS);
    }

    /**
     * Create a detached, initialised UserSettingsRecord
     */
    public UserSettingsRecord(java.lang.String domainId, java.lang.String userId, java.lang.String serviceId, java.lang.String key, java.lang.String value) {
        super(com.sonicle.webtop.core.jooq.core.tables.UserSettings.USER_SETTINGS);

        setDomainId(domainId);
        setUserId(userId);
        setServiceId(serviceId);
        setKey(key);
        setValue(value);
    }
}
