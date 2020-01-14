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
public class RolesAssociations extends org.jooq.impl.TableImpl<com.sonicle.webtop.core.jooq.core.tables.records.RolesAssociationsRecord> {

	private static final long serialVersionUID = 954400401;

	/**
	 * The reference instance of <code>core.roles_associations</code>
	 */
	public static final com.sonicle.webtop.core.jooq.core.tables.RolesAssociations ROLES_ASSOCIATIONS = new com.sonicle.webtop.core.jooq.core.tables.RolesAssociations();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<com.sonicle.webtop.core.jooq.core.tables.records.RolesAssociationsRecord> getRecordType() {
		return com.sonicle.webtop.core.jooq.core.tables.records.RolesAssociationsRecord.class;
	}

	/**
	 * The column <code>core.roles_associations.role_association_id</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.RolesAssociationsRecord, java.lang.Integer> ROLE_ASSOCIATION_ID = createField("role_association_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>core.roles_associations.user_uid</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.RolesAssociationsRecord, java.lang.String> USER_UID = createField("user_uid", org.jooq.impl.SQLDataType.VARCHAR.length(36).nullable(false), this, "");

	/**
	 * The column <code>core.roles_associations.role_uid</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.RolesAssociationsRecord, java.lang.String> ROLE_UID = createField("role_uid", org.jooq.impl.SQLDataType.VARCHAR.length(36).nullable(false), this, "");

	/**
	 * Create a <code>core.roles_associations</code> table reference
	 */
	public RolesAssociations() {
		this("roles_associations", null);
	}

	/**
	 * Create an aliased <code>core.roles_associations</code> table reference
	 */
	public RolesAssociations(java.lang.String alias) {
		this(alias, com.sonicle.webtop.core.jooq.core.tables.RolesAssociations.ROLES_ASSOCIATIONS);
	}

	private RolesAssociations(java.lang.String alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.RolesAssociationsRecord> aliased) {
		this(alias, aliased, null);
	}

	private RolesAssociations(java.lang.String alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.RolesAssociationsRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, com.sonicle.webtop.core.jooq.core.Core.CORE, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<com.sonicle.webtop.core.jooq.core.tables.records.RolesAssociationsRecord, java.lang.Integer> getIdentity() {
		return com.sonicle.webtop.core.jooq.core.Keys.IDENTITY_ROLES_ASSOCIATIONS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.RolesAssociationsRecord> getPrimaryKey() {
		return com.sonicle.webtop.core.jooq.core.Keys.ROLES_ASSOCIATIONS_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.RolesAssociationsRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.RolesAssociationsRecord>>asList(com.sonicle.webtop.core.jooq.core.Keys.ROLES_ASSOCIATIONS_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public com.sonicle.webtop.core.jooq.core.tables.RolesAssociations as(java.lang.String alias) {
		return new com.sonicle.webtop.core.jooq.core.tables.RolesAssociations(alias, this);
	}

	/**
	 * Rename this table
	 */
	public com.sonicle.webtop.core.jooq.core.tables.RolesAssociations rename(java.lang.String name) {
		return new com.sonicle.webtop.core.jooq.core.tables.RolesAssociations(name, null);
	}
}
