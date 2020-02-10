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
public class CausalsRecord extends org.jooq.impl.UpdatableRecordImpl<com.sonicle.webtop.core.jooq.core.tables.records.CausalsRecord> implements org.jooq.Record8<java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String> {

	private static final long serialVersionUID = -1086599018;

	/**
	 * Setter for <code>core.causals.causal_id</code>.
	 */
	public void setCausalId(java.lang.Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>core.causals.causal_id</code>.
	 */
	public java.lang.Integer getCausalId() {
		return (java.lang.Integer) getValue(0);
	}

	/**
	 * Setter for <code>core.causals.domain_id</code>.
	 */
	public void setDomainId(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>core.causals.domain_id</code>.
	 */
	public java.lang.String getDomainId() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>core.causals.user_id</code>.
	 */
	public void setUserId(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>core.causals.user_id</code>.
	 */
	public java.lang.String getUserId() {
		return (java.lang.String) getValue(2);
	}

	/**
	 * Setter for <code>core.causals.master_data_id</code>.
	 */
	public void setMasterDataId(java.lang.String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>core.causals.master_data_id</code>.
	 */
	public java.lang.String getMasterDataId() {
		return (java.lang.String) getValue(3);
	}

	/**
	 * Setter for <code>core.causals.revision_status</code>.
	 */
	public void setRevisionStatus(java.lang.String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>core.causals.revision_status</code>.
	 */
	public java.lang.String getRevisionStatus() {
		return (java.lang.String) getValue(4);
	}

	/**
	 * Setter for <code>core.causals.description</code>.
	 */
	public void setDescription(java.lang.String value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>core.causals.description</code>.
	 */
	public java.lang.String getDescription() {
		return (java.lang.String) getValue(5);
	}

	/**
	 * Setter for <code>core.causals.read_only</code>.
	 */
	public void setReadOnly(java.lang.Boolean value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>core.causals.read_only</code>.
	 */
	public java.lang.Boolean getReadOnly() {
		return (java.lang.Boolean) getValue(6);
	}

	/**
	 * Setter for <code>core.causals.external_id</code>.
	 */
	public void setExternalId(java.lang.String value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>core.causals.external_id</code>.
	 */
	public java.lang.String getExternalId() {
		return (java.lang.String) getValue(7);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record1<java.lang.Integer> key() {
		return (org.jooq.Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record8 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row8<java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String> fieldsRow() {
		return (org.jooq.Row8) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row8<java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String> valuesRow() {
		return (org.jooq.Row8) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field1() {
		return com.sonicle.webtop.core.jooq.core.tables.Causals.CAUSALS.CAUSAL_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return com.sonicle.webtop.core.jooq.core.tables.Causals.CAUSALS.DOMAIN_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return com.sonicle.webtop.core.jooq.core.tables.Causals.CAUSALS.USER_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field4() {
		return com.sonicle.webtop.core.jooq.core.tables.Causals.CAUSALS.MASTER_DATA_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field5() {
		return com.sonicle.webtop.core.jooq.core.tables.Causals.CAUSALS.REVISION_STATUS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field6() {
		return com.sonicle.webtop.core.jooq.core.tables.Causals.CAUSALS.DESCRIPTION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Boolean> field7() {
		return com.sonicle.webtop.core.jooq.core.tables.Causals.CAUSALS.READ_ONLY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field8() {
		return com.sonicle.webtop.core.jooq.core.tables.Causals.CAUSALS.EXTERNAL_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value1() {
		return getCausalId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value2() {
		return getDomainId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value3() {
		return getUserId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value4() {
		return getMasterDataId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value5() {
		return getRevisionStatus();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value6() {
		return getDescription();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Boolean value7() {
		return getReadOnly();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value8() {
		return getExternalId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CausalsRecord value1(java.lang.Integer value) {
		setCausalId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CausalsRecord value2(java.lang.String value) {
		setDomainId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CausalsRecord value3(java.lang.String value) {
		setUserId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CausalsRecord value4(java.lang.String value) {
		setMasterDataId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CausalsRecord value5(java.lang.String value) {
		setRevisionStatus(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CausalsRecord value6(java.lang.String value) {
		setDescription(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CausalsRecord value7(java.lang.Boolean value) {
		setReadOnly(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CausalsRecord value8(java.lang.String value) {
		setExternalId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CausalsRecord values(java.lang.Integer value1, java.lang.String value2, java.lang.String value3, java.lang.String value4, java.lang.String value5, java.lang.String value6, java.lang.Boolean value7, java.lang.String value8) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached CausalsRecord
	 */
	public CausalsRecord() {
		super(com.sonicle.webtop.core.jooq.core.tables.Causals.CAUSALS);
	}

	/**
	 * Create a detached, initialised CausalsRecord
	 */
	public CausalsRecord(java.lang.Integer causalId, java.lang.String domainId, java.lang.String userId, java.lang.String masterDataId, java.lang.String revisionStatus, java.lang.String description, java.lang.Boolean readOnly, java.lang.String externalId) {
		super(com.sonicle.webtop.core.jooq.core.tables.Causals.CAUSALS);

		setValue(0, causalId);
		setValue(1, domainId);
		setValue(2, userId);
		setValue(3, masterDataId);
		setValue(4, revisionStatus);
		setValue(5, description);
		setValue(6, readOnly);
		setValue(7, externalId);
	}
}