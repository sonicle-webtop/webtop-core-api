/**
 * This class is generated by jOOQ
 */
package com.sonicle.webtop.core.jooq.core.tables;

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
public class IpGeoCache extends org.jooq.impl.TableImpl<com.sonicle.webtop.core.jooq.core.tables.records.IpGeoCacheRecord> {

	private static final long serialVersionUID = 2089307586;

	/**
	 * The reference instance of <code>core.ip_geo_cache</code>
	 */
	public static final com.sonicle.webtop.core.jooq.core.tables.IpGeoCache IP_GEO_CACHE = new com.sonicle.webtop.core.jooq.core.tables.IpGeoCache();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<com.sonicle.webtop.core.jooq.core.tables.records.IpGeoCacheRecord> getRecordType() {
		return com.sonicle.webtop.core.jooq.core.tables.records.IpGeoCacheRecord.class;
	}

	/**
	 * The column <code>core.ip_geo_cache.ip_address</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.IpGeoCacheRecord, java.lang.String> IP_ADDRESS = createField("ip_address", org.jooq.impl.SQLDataType.VARCHAR.length(45).nullable(false), this, "");

	/**
	 * The column <code>core.ip_geo_cache.timestamp</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.IpGeoCacheRecord, org.joda.time.DateTime> TIMESTAMP = createField("timestamp", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "", new com.sonicle.webtop.core.jooq.DateTimeConverter());

	/**
	 * The column <code>core.ip_geo_cache.provider</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.IpGeoCacheRecord, java.lang.String> PROVIDER = createField("provider", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * The column <code>core.ip_geo_cache.data</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.IpGeoCacheRecord, java.lang.String> DATA = createField("data", org.jooq.impl.SQLDataType.CLOB, this, "");

	/**
	 * Create a <code>core.ip_geo_cache</code> table reference
	 */
	public IpGeoCache() {
		this("ip_geo_cache", null);
	}

	/**
	 * Create an aliased <code>core.ip_geo_cache</code> table reference
	 */
	public IpGeoCache(java.lang.String alias) {
		this(alias, com.sonicle.webtop.core.jooq.core.tables.IpGeoCache.IP_GEO_CACHE);
	}

	private IpGeoCache(java.lang.String alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.IpGeoCacheRecord> aliased) {
		this(alias, aliased, null);
	}

	private IpGeoCache(java.lang.String alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.IpGeoCacheRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, com.sonicle.webtop.core.jooq.core.Core.CORE, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.IpGeoCacheRecord> getPrimaryKey() {
		return com.sonicle.webtop.core.jooq.core.Keys.IP_GEO_CACHE_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.IpGeoCacheRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.IpGeoCacheRecord>>asList(com.sonicle.webtop.core.jooq.core.Keys.IP_GEO_CACHE_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public com.sonicle.webtop.core.jooq.core.tables.IpGeoCache as(java.lang.String alias) {
		return new com.sonicle.webtop.core.jooq.core.tables.IpGeoCache(alias, this);
	}

	/**
	 * Rename this table
	 */
	public com.sonicle.webtop.core.jooq.core.tables.IpGeoCache rename(java.lang.String name) {
		return new com.sonicle.webtop.core.jooq.core.tables.IpGeoCache(name, null);
	}
}