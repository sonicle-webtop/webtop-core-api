/**
 * This class is generated by jOOQ
 */
package com.sonicle.webtop.core.jooq.core.tables.records;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.5.3"
	},
	comments = "This class is generated by jOOQ"
)
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class IpGeoCacheRecord extends org.jooq.impl.UpdatableRecordImpl<com.sonicle.webtop.core.jooq.core.tables.records.IpGeoCacheRecord> implements org.jooq.Record4<java.lang.String, org.joda.time.DateTime, java.lang.String, java.lang.String> {

	private static final long serialVersionUID = -727497092;

	/**
	 * Setter for <code>core.ip_geo_cache.ip_address</code>.
	 */
	public void setIpAddress(java.lang.String value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>core.ip_geo_cache.ip_address</code>.
	 */
	public java.lang.String getIpAddress() {
		return (java.lang.String) getValue(0);
	}

	/**
	 * Setter for <code>core.ip_geo_cache.timestamp</code>.
	 */
	public void setTimestamp(org.joda.time.DateTime value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>core.ip_geo_cache.timestamp</code>.
	 */
	public org.joda.time.DateTime getTimestamp() {
		return (org.joda.time.DateTime) getValue(1);
	}

	/**
	 * Setter for <code>core.ip_geo_cache.provider</code>.
	 */
	public void setProvider(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>core.ip_geo_cache.provider</code>.
	 */
	public java.lang.String getProvider() {
		return (java.lang.String) getValue(2);
	}

	/**
	 * Setter for <code>core.ip_geo_cache.data</code>.
	 */
	public void setData(java.lang.String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>core.ip_geo_cache.data</code>.
	 */
	public java.lang.String getData() {
		return (java.lang.String) getValue(3);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record2<java.lang.String, org.joda.time.DateTime> key() {
		return (org.jooq.Record2) super.key();
	}

	// -------------------------------------------------------------------------
	// Record4 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row4<java.lang.String, org.joda.time.DateTime, java.lang.String, java.lang.String> fieldsRow() {
		return (org.jooq.Row4) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row4<java.lang.String, org.joda.time.DateTime, java.lang.String, java.lang.String> valuesRow() {
		return (org.jooq.Row4) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field1() {
		return com.sonicle.webtop.core.jooq.core.tables.IpGeoCache.IP_GEO_CACHE.IP_ADDRESS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<org.joda.time.DateTime> field2() {
		return com.sonicle.webtop.core.jooq.core.tables.IpGeoCache.IP_GEO_CACHE.TIMESTAMP;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return com.sonicle.webtop.core.jooq.core.tables.IpGeoCache.IP_GEO_CACHE.PROVIDER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field4() {
		return com.sonicle.webtop.core.jooq.core.tables.IpGeoCache.IP_GEO_CACHE.DATA;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value1() {
		return getIpAddress();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.joda.time.DateTime value2() {
		return getTimestamp();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value3() {
		return getProvider();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value4() {
		return getData();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IpGeoCacheRecord value1(java.lang.String value) {
		setIpAddress(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IpGeoCacheRecord value2(org.joda.time.DateTime value) {
		setTimestamp(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IpGeoCacheRecord value3(java.lang.String value) {
		setProvider(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IpGeoCacheRecord value4(java.lang.String value) {
		setData(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IpGeoCacheRecord values(java.lang.String value1, org.joda.time.DateTime value2, java.lang.String value3, java.lang.String value4) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached IpGeoCacheRecord
	 */
	public IpGeoCacheRecord() {
		super(com.sonicle.webtop.core.jooq.core.tables.IpGeoCache.IP_GEO_CACHE);
	}

	/**
	 * Create a detached, initialised IpGeoCacheRecord
	 */
	public IpGeoCacheRecord(java.lang.String ipAddress, org.joda.time.DateTime timestamp, java.lang.String provider, java.lang.String data) {
		super(com.sonicle.webtop.core.jooq.core.tables.IpGeoCache.IP_GEO_CACHE);

		setValue(0, ipAddress);
		setValue(1, timestamp);
		setValue(2, provider);
		setValue(3, data);
	}
}
