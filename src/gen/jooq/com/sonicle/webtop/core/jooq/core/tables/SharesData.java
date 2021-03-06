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
public class SharesData extends org.jooq.impl.TableImpl<com.sonicle.webtop.core.jooq.core.tables.records.SharesDataRecord> {

	private static final long serialVersionUID = -780456890;

	/**
	 * The reference instance of <code>core.shares_data</code>
	 */
	public static final com.sonicle.webtop.core.jooq.core.tables.SharesData SHARES_DATA = new com.sonicle.webtop.core.jooq.core.tables.SharesData();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<com.sonicle.webtop.core.jooq.core.tables.records.SharesDataRecord> getRecordType() {
		return com.sonicle.webtop.core.jooq.core.tables.records.SharesDataRecord.class;
	}

	/**
	 * The column <code>core.shares_data.share_id</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.SharesDataRecord, java.lang.Integer> SHARE_ID = createField("share_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>core.shares_data.user_uid</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.SharesDataRecord, java.lang.String> USER_UID = createField("user_uid", org.jooq.impl.SQLDataType.VARCHAR.length(36).nullable(false), this, "");

	/**
	 * The column <code>core.shares_data.value</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.SharesDataRecord, java.lang.String> VALUE = createField("value", org.jooq.impl.SQLDataType.CLOB, this, "");

	/**
	 * Create a <code>core.shares_data</code> table reference
	 */
	public SharesData() {
		this("shares_data", null);
	}

	/**
	 * Create an aliased <code>core.shares_data</code> table reference
	 */
	public SharesData(java.lang.String alias) {
		this(alias, com.sonicle.webtop.core.jooq.core.tables.SharesData.SHARES_DATA);
	}

	private SharesData(java.lang.String alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.SharesDataRecord> aliased) {
		this(alias, aliased, null);
	}

	private SharesData(java.lang.String alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.SharesDataRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, com.sonicle.webtop.core.jooq.core.Core.CORE, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.SharesDataRecord> getPrimaryKey() {
		return com.sonicle.webtop.core.jooq.core.Keys.SHARES_DATA_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.SharesDataRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.SharesDataRecord>>asList(com.sonicle.webtop.core.jooq.core.Keys.SHARES_DATA_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public com.sonicle.webtop.core.jooq.core.tables.SharesData as(java.lang.String alias) {
		return new com.sonicle.webtop.core.jooq.core.tables.SharesData(alias, this);
	}

	/**
	 * Rename this table
	 */
	public com.sonicle.webtop.core.jooq.core.tables.SharesData rename(java.lang.String name) {
		return new com.sonicle.webtop.core.jooq.core.tables.SharesData(name, null);
	}
}
