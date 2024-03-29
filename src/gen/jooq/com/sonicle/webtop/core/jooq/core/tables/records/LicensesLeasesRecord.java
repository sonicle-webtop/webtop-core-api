/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.core.tables.records;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LicensesLeasesRecord extends org.jooq.impl.UpdatableRecordImpl<LicensesLeasesRecord> implements org.jooq.Record6<java.lang.String, java.lang.String, java.lang.String, java.lang.String, org.joda.time.DateTime, java.lang.String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>core.licenses_leases.domain_id</code>.
     */
    public void setDomainId(java.lang.String value) {
        set(0, value);
    }

    /**
     * Getter for <code>core.licenses_leases.domain_id</code>.
     */
    public java.lang.String getDomainId() {
        return (java.lang.String) get(0);
    }

    /**
     * Setter for <code>core.licenses_leases.service_id</code>.
     */
    public void setServiceId(java.lang.String value) {
        set(1, value);
    }

    /**
     * Getter for <code>core.licenses_leases.service_id</code>.
     */
    public java.lang.String getServiceId() {
        return (java.lang.String) get(1);
    }

    /**
     * Setter for <code>core.licenses_leases.product_code</code>.
     */
    public void setProductCode(java.lang.String value) {
        set(2, value);
    }

    /**
     * Getter for <code>core.licenses_leases.product_code</code>.
     */
    public java.lang.String getProductCode() {
        return (java.lang.String) get(2);
    }

    /**
     * Setter for <code>core.licenses_leases.user_id</code>.
     */
    public void setUserId(java.lang.String value) {
        set(3, value);
    }

    /**
     * Getter for <code>core.licenses_leases.user_id</code>.
     */
    public java.lang.String getUserId() {
        return (java.lang.String) get(3);
    }

    /**
     * Setter for <code>core.licenses_leases.lease_timestamp</code>.
     */
    public void setLeaseTimestamp(org.joda.time.DateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>core.licenses_leases.lease_timestamp</code>.
     */
    public org.joda.time.DateTime getLeaseTimestamp() {
        return (org.joda.time.DateTime) get(4);
    }

    /**
     * Setter for <code>core.licenses_leases.lease_origin</code>.
     */
    public void setLeaseOrigin(java.lang.String value) {
        set(5, value);
    }

    /**
     * Getter for <code>core.licenses_leases.lease_origin</code>.
     */
    public java.lang.String getLeaseOrigin() {
        return (java.lang.String) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @java.lang.Override
    public org.jooq.Record4<java.lang.String, java.lang.String, java.lang.String, java.lang.String> key() {
        return (org.jooq.Record4) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @java.lang.Override
    public org.jooq.Row6<java.lang.String, java.lang.String, java.lang.String, java.lang.String, org.joda.time.DateTime, java.lang.String> fieldsRow() {
        return (org.jooq.Row6) super.fieldsRow();
    }

    @java.lang.Override
    public org.jooq.Row6<java.lang.String, java.lang.String, java.lang.String, java.lang.String, org.joda.time.DateTime, java.lang.String> valuesRow() {
        return (org.jooq.Row6) super.valuesRow();
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field1() {
        return com.sonicle.webtop.core.jooq.core.tables.LicensesLeases.LICENSES_LEASES.DOMAIN_ID;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field2() {
        return com.sonicle.webtop.core.jooq.core.tables.LicensesLeases.LICENSES_LEASES.SERVICE_ID;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field3() {
        return com.sonicle.webtop.core.jooq.core.tables.LicensesLeases.LICENSES_LEASES.PRODUCT_CODE;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field4() {
        return com.sonicle.webtop.core.jooq.core.tables.LicensesLeases.LICENSES_LEASES.USER_ID;
    }

    @java.lang.Override
    public org.jooq.Field<org.joda.time.DateTime> field5() {
        return com.sonicle.webtop.core.jooq.core.tables.LicensesLeases.LICENSES_LEASES.LEASE_TIMESTAMP;
    }

    @java.lang.Override
    public org.jooq.Field<java.lang.String> field6() {
        return com.sonicle.webtop.core.jooq.core.tables.LicensesLeases.LICENSES_LEASES.LEASE_ORIGIN;
    }

    @java.lang.Override
    public java.lang.String component1() {
        return getDomainId();
    }

    @java.lang.Override
    public java.lang.String component2() {
        return getServiceId();
    }

    @java.lang.Override
    public java.lang.String component3() {
        return getProductCode();
    }

    @java.lang.Override
    public java.lang.String component4() {
        return getUserId();
    }

    @java.lang.Override
    public org.joda.time.DateTime component5() {
        return getLeaseTimestamp();
    }

    @java.lang.Override
    public java.lang.String component6() {
        return getLeaseOrigin();
    }

    @java.lang.Override
    public java.lang.String value1() {
        return getDomainId();
    }

    @java.lang.Override
    public java.lang.String value2() {
        return getServiceId();
    }

    @java.lang.Override
    public java.lang.String value3() {
        return getProductCode();
    }

    @java.lang.Override
    public java.lang.String value4() {
        return getUserId();
    }

    @java.lang.Override
    public org.joda.time.DateTime value5() {
        return getLeaseTimestamp();
    }

    @java.lang.Override
    public java.lang.String value6() {
        return getLeaseOrigin();
    }

    @java.lang.Override
    public LicensesLeasesRecord value1(java.lang.String value) {
        setDomainId(value);
        return this;
    }

    @java.lang.Override
    public LicensesLeasesRecord value2(java.lang.String value) {
        setServiceId(value);
        return this;
    }

    @java.lang.Override
    public LicensesLeasesRecord value3(java.lang.String value) {
        setProductCode(value);
        return this;
    }

    @java.lang.Override
    public LicensesLeasesRecord value4(java.lang.String value) {
        setUserId(value);
        return this;
    }

    @java.lang.Override
    public LicensesLeasesRecord value5(org.joda.time.DateTime value) {
        setLeaseTimestamp(value);
        return this;
    }

    @java.lang.Override
    public LicensesLeasesRecord value6(java.lang.String value) {
        setLeaseOrigin(value);
        return this;
    }

    @java.lang.Override
    public LicensesLeasesRecord values(java.lang.String value1, java.lang.String value2, java.lang.String value3, java.lang.String value4, org.joda.time.DateTime value5, java.lang.String value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LicensesLeasesRecord
     */
    public LicensesLeasesRecord() {
        super(com.sonicle.webtop.core.jooq.core.tables.LicensesLeases.LICENSES_LEASES);
    }

    /**
     * Create a detached, initialised LicensesLeasesRecord
     */
    public LicensesLeasesRecord(java.lang.String domainId, java.lang.String serviceId, java.lang.String productCode, java.lang.String userId, org.joda.time.DateTime leaseTimestamp, java.lang.String leaseOrigin) {
        super(com.sonicle.webtop.core.jooq.core.tables.LicensesLeases.LICENSES_LEASES);

        setDomainId(domainId);
        setServiceId(serviceId);
        setProductCode(productCode);
        setUserId(userId);
        setLeaseTimestamp(leaseTimestamp);
        setLeaseOrigin(leaseOrigin);
    }
}
