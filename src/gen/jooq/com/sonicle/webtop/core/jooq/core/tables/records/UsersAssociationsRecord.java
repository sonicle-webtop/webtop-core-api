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
public class UsersAssociationsRecord extends org.jooq.impl.UpdatableRecordImpl<com.sonicle.webtop.core.jooq.core.tables.records.UsersAssociationsRecord> implements org.jooq.Record3<java.lang.Integer, java.lang.String, java.lang.String> {

	private static final long serialVersionUID = -35164825;

	/**
	 * Setter for <code>core.users_associations.user_association_id</code>.
	 */
	public void setUserAssociationId(java.lang.Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>core.users_associations.user_association_id</code>.
	 */
	public java.lang.Integer getUserAssociationId() {
		return (java.lang.Integer) getValue(0);
	}

	/**
	 * Setter for <code>core.users_associations.user_uid</code>.
	 */
	public void setUserUid(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>core.users_associations.user_uid</code>.
	 */
	public java.lang.String getUserUid() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>core.users_associations.group_uid</code>.
	 */
	public void setGroupUid(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>core.users_associations.group_uid</code>.
	 */
	public java.lang.String getGroupUid() {
		return (java.lang.String) getValue(2);
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
	// Record3 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row3<java.lang.Integer, java.lang.String, java.lang.String> fieldsRow() {
		return (org.jooq.Row3) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row3<java.lang.Integer, java.lang.String, java.lang.String> valuesRow() {
		return (org.jooq.Row3) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field1() {
		return com.sonicle.webtop.core.jooq.core.tables.UsersAssociations.USERS_ASSOCIATIONS.USER_ASSOCIATION_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return com.sonicle.webtop.core.jooq.core.tables.UsersAssociations.USERS_ASSOCIATIONS.USER_UID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return com.sonicle.webtop.core.jooq.core.tables.UsersAssociations.USERS_ASSOCIATIONS.GROUP_UID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value1() {
		return getUserAssociationId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value2() {
		return getUserUid();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value3() {
		return getGroupUid();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UsersAssociationsRecord value1(java.lang.Integer value) {
		setUserAssociationId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UsersAssociationsRecord value2(java.lang.String value) {
		setUserUid(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UsersAssociationsRecord value3(java.lang.String value) {
		setGroupUid(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UsersAssociationsRecord values(java.lang.Integer value1, java.lang.String value2, java.lang.String value3) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached UsersAssociationsRecord
	 */
	public UsersAssociationsRecord() {
		super(com.sonicle.webtop.core.jooq.core.tables.UsersAssociations.USERS_ASSOCIATIONS);
	}

	/**
	 * Create a detached, initialised UsersAssociationsRecord
	 */
	public UsersAssociationsRecord(java.lang.Integer userAssociationId, java.lang.String userUid, java.lang.String groupUid) {
		super(com.sonicle.webtop.core.jooq.core.tables.UsersAssociations.USERS_ASSOCIATIONS);

		setValue(0, userAssociationId);
		setValue(1, userUid);
		setValue(2, groupUid);
	}
}
