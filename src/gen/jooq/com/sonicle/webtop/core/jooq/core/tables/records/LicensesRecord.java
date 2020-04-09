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
public class LicensesRecord extends org.jooq.impl.UpdatableRecordImpl<com.sonicle.webtop.core.jooq.core.tables.records.LicensesRecord> implements org.jooq.Record4<java.lang.String, java.lang.String, java.lang.String, java.lang.String> {

	private static final long serialVersionUID = -2044830174;

	/**
	 * Setter for <code>core.licenses.service_id</code>.
	 */
	public void setServiceId(java.lang.String value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>core.licenses.service_id</code>.
	 */
	public java.lang.String getServiceId() {
		return (java.lang.String) getValue(0);
	}

	/**
	 * Setter for <code>core.licenses.product_id</code>.
	 */
	public void setProductId(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>core.licenses.product_id</code>.
	 */
	public java.lang.String getProductId() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>core.licenses.internet_name</code>.
	 */
	public void setInternetName(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>core.licenses.internet_name</code>.
	 */
	public java.lang.String getInternetName() {
		return (java.lang.String) getValue(2);
	}

	/**
	 * Setter for <code>core.licenses.license</code>.
	 */
	public void setLicense(java.lang.String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>core.licenses.license</code>.
	 */
	public java.lang.String getLicense() {
		return (java.lang.String) getValue(3);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record3<java.lang.String, java.lang.String, java.lang.String> key() {
		return (org.jooq.Record3) super.key();
	}

	// -------------------------------------------------------------------------
	// Record4 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row4<java.lang.String, java.lang.String, java.lang.String, java.lang.String> fieldsRow() {
		return (org.jooq.Row4) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row4<java.lang.String, java.lang.String, java.lang.String, java.lang.String> valuesRow() {
		return (org.jooq.Row4) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field1() {
		return com.sonicle.webtop.core.jooq.core.tables.Licenses.LICENSES.SERVICE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return com.sonicle.webtop.core.jooq.core.tables.Licenses.LICENSES.PRODUCT_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return com.sonicle.webtop.core.jooq.core.tables.Licenses.LICENSES.INTERNET_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field4() {
		return com.sonicle.webtop.core.jooq.core.tables.Licenses.LICENSES.LICENSE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value1() {
		return getServiceId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value2() {
		return getProductId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value3() {
		return getInternetName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value4() {
		return getLicense();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LicensesRecord value1(java.lang.String value) {
		setServiceId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LicensesRecord value2(java.lang.String value) {
		setProductId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LicensesRecord value3(java.lang.String value) {
		setInternetName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LicensesRecord value4(java.lang.String value) {
		setLicense(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LicensesRecord values(java.lang.String value1, java.lang.String value2, java.lang.String value3, java.lang.String value4) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached LicensesRecord
	 */
	public LicensesRecord() {
		super(com.sonicle.webtop.core.jooq.core.tables.Licenses.LICENSES);
	}

	/**
	 * Create a detached, initialised LicensesRecord
	 */
	public LicensesRecord(java.lang.String serviceId, java.lang.String productId, java.lang.String internetName, java.lang.String license) {
		super(com.sonicle.webtop.core.jooq.core.tables.Licenses.LICENSES);

		setValue(0, serviceId);
		setValue(1, productId);
		setValue(2, internetName);
		setValue(3, license);
	}
}