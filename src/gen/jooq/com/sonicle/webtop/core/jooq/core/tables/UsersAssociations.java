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
public class UsersAssociations extends org.jooq.impl.TableImpl<com.sonicle.webtop.core.jooq.core.tables.records.UsersAssociationsRecord> {

	private static final long serialVersionUID = 206780437;

	/**
	 * The reference instance of <code>core.users_associations</code>
	 */
	public static final com.sonicle.webtop.core.jooq.core.tables.UsersAssociations USERS_ASSOCIATIONS = new com.sonicle.webtop.core.jooq.core.tables.UsersAssociations();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<com.sonicle.webtop.core.jooq.core.tables.records.UsersAssociationsRecord> getRecordType() {
		return com.sonicle.webtop.core.jooq.core.tables.records.UsersAssociationsRecord.class;
	}

	/**
	 * The column <code>core.users_associations.user_association_id</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.UsersAssociationsRecord, java.lang.Integer> USER_ASSOCIATION_ID = createField("user_association_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>core.users_associations.user_uid</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.UsersAssociationsRecord, java.lang.String> USER_UID = createField("user_uid", org.jooq.impl.SQLDataType.VARCHAR.length(36).nullable(false), this, "");

	/**
	 * The column <code>core.users_associations.group_uid</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.UsersAssociationsRecord, java.lang.String> GROUP_UID = createField("group_uid", org.jooq.impl.SQLDataType.VARCHAR.length(36).nullable(false), this, "");

	/**
	 * Create a <code>core.users_associations</code> table reference
	 */
	public UsersAssociations() {
		this("users_associations", null);
	}

	/**
	 * Create an aliased <code>core.users_associations</code> table reference
	 */
	public UsersAssociations(java.lang.String alias) {
		this(alias, com.sonicle.webtop.core.jooq.core.tables.UsersAssociations.USERS_ASSOCIATIONS);
	}

	private UsersAssociations(java.lang.String alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.UsersAssociationsRecord> aliased) {
		this(alias, aliased, null);
	}

	private UsersAssociations(java.lang.String alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.UsersAssociationsRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, com.sonicle.webtop.core.jooq.core.Core.CORE, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<com.sonicle.webtop.core.jooq.core.tables.records.UsersAssociationsRecord, java.lang.Integer> getIdentity() {
		return com.sonicle.webtop.core.jooq.core.Keys.IDENTITY_USERS_ASSOCIATIONS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.UsersAssociationsRecord> getPrimaryKey() {
		return com.sonicle.webtop.core.jooq.core.Keys.USERS_ASSOCIATIONS_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.UsersAssociationsRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.UsersAssociationsRecord>>asList(com.sonicle.webtop.core.jooq.core.Keys.USERS_ASSOCIATIONS_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public com.sonicle.webtop.core.jooq.core.tables.UsersAssociations as(java.lang.String alias) {
		return new com.sonicle.webtop.core.jooq.core.tables.UsersAssociations(alias, this);
	}

	/**
	 * Rename this table
	 */
	public com.sonicle.webtop.core.jooq.core.tables.UsersAssociations rename(java.lang.String name) {
		return new com.sonicle.webtop.core.jooq.core.tables.UsersAssociations(name, null);
	}
}