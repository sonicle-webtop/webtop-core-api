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
public class LicensesLeases extends org.jooq.impl.TableImpl<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord> {

	private static final long serialVersionUID = -794074011;

	/**
	 * The reference instance of <code>core.licenses_leases</code>
	 */
	public static final com.sonicle.webtop.core.jooq.core.tables.LicensesLeases LICENSES_LEASES = new com.sonicle.webtop.core.jooq.core.tables.LicensesLeases();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord> getRecordType() {
		return com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord.class;
	}

	/**
	 * The column <code>core.licenses_leases.domain_id</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord, java.lang.String> DOMAIN_ID = createField("domain_id", org.jooq.impl.SQLDataType.VARCHAR.length(20).nullable(false), this, "");

	/**
	 * The column <code>core.licenses_leases.service_id</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord, java.lang.String> SERVICE_ID = createField("service_id", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * The column <code>core.licenses_leases.product_code</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord, java.lang.String> PRODUCT_CODE = createField("product_code", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * The column <code>core.licenses_leases.user_id</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord, java.lang.String> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.VARCHAR.length(100).nullable(false), this, "");

	/**
	 * The column <code>core.licenses_leases.activation_string</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord, java.lang.String> ACTIVATION_STRING = createField("activation_string", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

	/**
	 * Create a <code>core.licenses_leases</code> table reference
	 */
	public LicensesLeases() {
		this("licenses_leases", null);
	}

	/**
	 * Create an aliased <code>core.licenses_leases</code> table reference
	 */
	public LicensesLeases(java.lang.String alias) {
		this(alias, com.sonicle.webtop.core.jooq.core.tables.LicensesLeases.LICENSES_LEASES);
	}

	private LicensesLeases(java.lang.String alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord> aliased) {
		this(alias, aliased, null);
	}

	private LicensesLeases(java.lang.String alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, com.sonicle.webtop.core.jooq.core.Core.CORE, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord> getPrimaryKey() {
		return com.sonicle.webtop.core.jooq.core.Keys.LICENSES_LEASES_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord>>asList(com.sonicle.webtop.core.jooq.core.Keys.LICENSES_LEASES_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord, ?>>asList(com.sonicle.webtop.core.jooq.core.Keys.LICENSES_LEASES__LICENSES_LEASES_DOMAIN_ID_FKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public com.sonicle.webtop.core.jooq.core.tables.LicensesLeases as(java.lang.String alias) {
		return new com.sonicle.webtop.core.jooq.core.tables.LicensesLeases(alias, this);
	}

	/**
	 * Rename this table
	 */
	public com.sonicle.webtop.core.jooq.core.tables.LicensesLeases rename(java.lang.String name) {
		return new com.sonicle.webtop.core.jooq.core.tables.LicensesLeases(name, null);
	}
}
