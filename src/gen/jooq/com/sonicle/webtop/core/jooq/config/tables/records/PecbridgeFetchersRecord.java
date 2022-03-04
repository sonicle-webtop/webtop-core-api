/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.config.tables.records;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PecbridgeFetchersRecord extends org.jooq.impl.UpdatableRecordImpl<PecbridgeFetchersRecord> implements org.jooq.Record10<java.lang.Integer, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.Short, java.lang.String, java.lang.String, java.lang.String, java.lang.String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>config.pecbridge_fetchers.fetcher_id</code>.
     */
    public void setFetcherId(java.lang.Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>config.pecbridge_fetchers.fetcher_id</code>.
     */
    public java.lang.Integer getFetcherId() {
        return (java.lang.Integer) get(0);
    }

    /**
     * Setter for <code>config.pecbridge_fetchers.context</code>.
     */
    public void setContext(java.lang.String value) {
        set(1, value);
    }

    /**
     * Getter for <code>config.pecbridge_fetchers.context</code>.
     */
    public java.lang.String getContext() {
        return (java.lang.String) get(1);
    }

    /**
     * Setter for <code>config.pecbridge_fetchers.forward_address</code>.
     */
    public void setForwardAddress(java.lang.String value) {
        set(2, value);
    }

    /**
     * Getter for <code>config.pecbridge_fetchers.forward_address</code>.
     */
    public java.lang.String getForwardAddress() {
        return (java.lang.String) get(2);
    }

    /**
     * Setter for <code>config.pecbridge_fetchers.delete_on_forward</code>.
     */
    public void setDeleteOnForward(java.lang.Boolean value) {
        set(3, value);
    }

    /**
     * Getter for <code>config.pecbridge_fetchers.delete_on_forward</code>.
     */
    public java.lang.Boolean getDeleteOnForward() {
        return (java.lang.Boolean) get(3);
    }

    /**
     * Setter for <code>config.pecbridge_fetchers.host</code>.
     */
    public void setHost(java.lang.String value) {
        set(4, value);
    }

    /**
     * Getter for <code>config.pecbridge_fetchers.host</code>.
     */
    public java.lang.String getHost() {
        return (java.lang.String) get(4);
    }

    /**
     * Setter for <code>config.pecbridge_fetchers.port</code>.
     */
    public void setPort(java.lang.Short value) {
        set(5, value);
    }

    /**
     * Getter for <code>config.pecbridge_fetchers.port</code>.
     */
    public java.lang.Short getPort() {
        return (java.lang.Short) get(5);
    }

    /**
     * Setter for <code>config.pecbridge_fetchers.protocol</code>.
     */
    public void setProtocol(java.lang.String value) {
        set(6, value);
    }

    /**
     * Getter for <code>config.pecbridge_fetchers.protocol</code>.
     */
    public java.lang.String getProtocol() {
        return (java.lang.String) get(6);
    }

    /**
     * Setter for <code>config.pecbridge_fetchers.username</code>.
     */
    public void setUsername(java.lang.String value) {
        set(7, value);
    }

    /**
     * Getter for <code>config.pecbridge_fetchers.username</code>.
     */
    public java.lang.String getUsername() {
        return (java.lang.String) get(7);
    }

    /**
     * Setter for <code>config.pecbridge_fetchers.password</code>.
     */
    public void setPassword(java.lang.String value) {
        set(8, value);
    }

    /**
     * Getter for <code>config.pecbridge_fetchers.password</code>.
     */
    public java.lang.String getPassword() {
        return (java.lang.String) get(8);
    }

    /**
     * Setter for <code>config.pecbridge_fetchers.webtop_profile_id</code>.
     */
    public void setWebtopProfileId(java.lang.String value) {
        set(9, value);
    }

    /**
     * Getter for <code>config.pecbridge_fetchers.webtop_profile_id</code>.
     */
    public java.lang.String getWebtopProfileId() {
        return (java.lang.String) get(9);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @java.lang.Override
    public org.jooq.Record1<java.lang.Integer> key() {
        return (org.jooq.Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record10 type implementation
    // -------------------------------------------------------------------------

    @java.lang.Override
    public org.jooq.Row10<java.lang.Integer, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.Short, java.lang.String, java.lang.String, java.lang.String, java.lang.String> fieldsRow() {
        return (org.jooq.Row10) super.fieldsRow();
    }

    @java.lang.Override
    public org.jooq.Row10<java.lang.Integer, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.Short, java.lang.String, java.lang.String, java.lang.String, java.lang.String> valuesRow() {
        return (org.jooq.Row10) super.valuesRow();
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.Integer> field1() {
        return com.sonicle.webtop.core.jooq.config.tables.PecbridgeFetchers.PECBRIDGE_FETCHERS.FETCHER_ID;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field2() {
        return com.sonicle.webtop.core.jooq.config.tables.PecbridgeFetchers.PECBRIDGE_FETCHERS.CONTEXT;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field3() {
        return com.sonicle.webtop.core.jooq.config.tables.PecbridgeFetchers.PECBRIDGE_FETCHERS.FORWARD_ADDRESS;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.Boolean> field4() {
        return com.sonicle.webtop.core.jooq.config.tables.PecbridgeFetchers.PECBRIDGE_FETCHERS.DELETE_ON_FORWARD;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field5() {
        return com.sonicle.webtop.core.jooq.config.tables.PecbridgeFetchers.PECBRIDGE_FETCHERS.HOST;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.Short> field6() {
        return com.sonicle.webtop.core.jooq.config.tables.PecbridgeFetchers.PECBRIDGE_FETCHERS.PORT;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field7() {
        return com.sonicle.webtop.core.jooq.config.tables.PecbridgeFetchers.PECBRIDGE_FETCHERS.PROTOCOL;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field8() {
        return com.sonicle.webtop.core.jooq.config.tables.PecbridgeFetchers.PECBRIDGE_FETCHERS.USERNAME;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field9() {
        return com.sonicle.webtop.core.jooq.config.tables.PecbridgeFetchers.PECBRIDGE_FETCHERS.PASSWORD;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field10() {
        return com.sonicle.webtop.core.jooq.config.tables.PecbridgeFetchers.PECBRIDGE_FETCHERS.WEBTOP_PROFILE_ID;
    }

    @java.lang.Override
    public java.lang.Integer component1() {
        return getFetcherId();
    }

    @java.lang.Override
    public java.lang.String component2() {
        return getContext();
    }

    @java.lang.Override
    public java.lang.String component3() {
        return getForwardAddress();
    }

    @java.lang.Override
    public java.lang.Boolean component4() {
        return getDeleteOnForward();
    }

    @java.lang.Override
    public java.lang.String component5() {
        return getHost();
    }

    @java.lang.Override
    public java.lang.Short component6() {
        return getPort();
    }

    @java.lang.Override
    public java.lang.String component7() {
        return getProtocol();
    }

    @java.lang.Override
    public java.lang.String component8() {
        return getUsername();
    }

    @java.lang.Override
    public java.lang.String component9() {
        return getPassword();
    }

    @java.lang.Override
    public java.lang.String component10() {
        return getWebtopProfileId();
    }

    @java.lang.Override
    public java.lang.Integer value1() {
        return getFetcherId();
    }

    @java.lang.Override
    public java.lang.String value2() {
        return getContext();
    }

    @java.lang.Override
    public java.lang.String value3() {
        return getForwardAddress();
    }

    @java.lang.Override
    public java.lang.Boolean value4() {
        return getDeleteOnForward();
    }

    @java.lang.Override
    public java.lang.String value5() {
        return getHost();
    }

    @java.lang.Override
    public java.lang.Short value6() {
        return getPort();
    }

    @java.lang.Override
    public java.lang.String value7() {
        return getProtocol();
    }

    @java.lang.Override
    public java.lang.String value8() {
        return getUsername();
    }

    @java.lang.Override
    public java.lang.String value9() {
        return getPassword();
    }

    @java.lang.Override
    public java.lang.String value10() {
        return getWebtopProfileId();
    }

    @java.lang.Override
    public PecbridgeFetchersRecord value1(java.lang.Integer value) {
        setFetcherId(value);
        return this;
    }

    @java.lang.Override
    public PecbridgeFetchersRecord value2(java.lang.String value) {
        setContext(value);
        return this;
    }

    @java.lang.Override
    public PecbridgeFetchersRecord value3(java.lang.String value) {
        setForwardAddress(value);
        return this;
    }

    @java.lang.Override
    public PecbridgeFetchersRecord value4(java.lang.Boolean value) {
        setDeleteOnForward(value);
        return this;
    }

    @java.lang.Override
    public PecbridgeFetchersRecord value5(java.lang.String value) {
        setHost(value);
        return this;
    }

    @java.lang.Override
    public PecbridgeFetchersRecord value6(java.lang.Short value) {
        setPort(value);
        return this;
    }

    @java.lang.Override
    public PecbridgeFetchersRecord value7(java.lang.String value) {
        setProtocol(value);
        return this;
    }

    @java.lang.Override
    public PecbridgeFetchersRecord value8(java.lang.String value) {
        setUsername(value);
        return this;
    }

    @java.lang.Override
    public PecbridgeFetchersRecord value9(java.lang.String value) {
        setPassword(value);
        return this;
    }

    @java.lang.Override
    public PecbridgeFetchersRecord value10(java.lang.String value) {
        setWebtopProfileId(value);
        return this;
    }

    @java.lang.Override
    public PecbridgeFetchersRecord values(java.lang.Integer value1, java.lang.String value2, java.lang.String value3, java.lang.Boolean value4, java.lang.String value5, java.lang.Short value6, java.lang.String value7, java.lang.String value8, java.lang.String value9, java.lang.String value10) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PecbridgeFetchersRecord
     */
    public PecbridgeFetchersRecord() {
        super(com.sonicle.webtop.core.jooq.config.tables.PecbridgeFetchers.PECBRIDGE_FETCHERS);
    }

    /**
     * Create a detached, initialised PecbridgeFetchersRecord
     */
    public PecbridgeFetchersRecord(java.lang.Integer fetcherId, java.lang.String context, java.lang.String forwardAddress, java.lang.Boolean deleteOnForward, java.lang.String host, java.lang.Short port, java.lang.String protocol, java.lang.String username, java.lang.String password, java.lang.String webtopProfileId) {
        super(com.sonicle.webtop.core.jooq.config.tables.PecbridgeFetchers.PECBRIDGE_FETCHERS);

        setFetcherId(fetcherId);
        setContext(context);
        setForwardAddress(forwardAddress);
        setDeleteOnForward(deleteOnForward);
        setHost(host);
        setPort(port);
        setProtocol(protocol);
        setUsername(username);
        setPassword(password);
        setWebtopProfileId(webtopProfileId);
    }
}
