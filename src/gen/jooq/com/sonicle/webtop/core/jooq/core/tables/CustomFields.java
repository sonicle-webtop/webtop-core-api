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
public class CustomFields extends org.jooq.impl.TableImpl<com.sonicle.webtop.core.jooq.core.tables.records.CustomFieldsRecord> {

	private static final long serialVersionUID = 2051072150;

	/**
	 * The reference instance of <code>core.custom_fields</code>
	 */
	public static final com.sonicle.webtop.core.jooq.core.tables.CustomFields CUSTOM_FIELDS = new com.sonicle.webtop.core.jooq.core.tables.CustomFields();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<com.sonicle.webtop.core.jooq.core.tables.records.CustomFieldsRecord> getRecordType() {
		return com.sonicle.webtop.core.jooq.core.tables.records.CustomFieldsRecord.class;
	}

	/**
	 * The column <code>core.custom_fields.custom_field_id</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomFieldsRecord, java.lang.String> CUSTOM_FIELD_ID = createField("custom_field_id", org.jooq.impl.SQLDataType.VARCHAR.length(22).nullable(false), this, "");

	/**
	 * The column <code>core.custom_fields.domain_id</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomFieldsRecord, java.lang.String> DOMAIN_ID = createField("domain_id", org.jooq.impl.SQLDataType.VARCHAR.length(20).nullable(false), this, "");

	/**
	 * The column <code>core.custom_fields.service_id</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomFieldsRecord, java.lang.String> SERVICE_ID = createField("service_id", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * The column <code>core.custom_fields.revision_status</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomFieldsRecord, java.lang.String> REVISION_STATUS = createField("revision_status", org.jooq.impl.SQLDataType.VARCHAR.length(1).nullable(false), this, "");

	/**
	 * The column <code>core.custom_fields.revision_timestamp</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomFieldsRecord, org.joda.time.DateTime> REVISION_TIMESTAMP = createField("revision_timestamp", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "", new com.sonicle.webtop.core.jooq.DateTimeConverter());

	/**
	 * The column <code>core.custom_fields.creation_timestamp</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomFieldsRecord, org.joda.time.DateTime> CREATION_TIMESTAMP = createField("creation_timestamp", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "", new com.sonicle.webtop.core.jooq.DateTimeConverter());

	/**
	 * The column <code>core.custom_fields.name</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomFieldsRecord, java.lang.String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * The column <code>core.custom_fields.description</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomFieldsRecord, java.lang.String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>core.custom_fields.type</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomFieldsRecord, java.lang.String> TYPE = createField("type", org.jooq.impl.SQLDataType.VARCHAR.length(20).nullable(false), this, "");

	/**
	 * The column <code>core.custom_fields.properties</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomFieldsRecord, java.lang.String> PROPERTIES = createField("properties", org.jooq.impl.SQLDataType.CLOB, this, "");

	/**
	 * The column <code>core.custom_fields.values</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomFieldsRecord, java.lang.String> VALUES = createField("values", org.jooq.impl.SQLDataType.CLOB, this, "");

	/**
	 * The column <code>core.custom_fields.label_i18n</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomFieldsRecord, java.lang.String> LABEL_I18N = createField("label_i18n", org.jooq.impl.SQLDataType.CLOB, this, "");

	/**
	 * The column <code>core.custom_fields.searchable</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomFieldsRecord, java.lang.Boolean> SEARCHABLE = createField("searchable", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

	/**
	 * Create a <code>core.custom_fields</code> table reference
	 */
	public CustomFields() {
		this("custom_fields", null);
	}

	/**
	 * Create an aliased <code>core.custom_fields</code> table reference
	 */
	public CustomFields(java.lang.String alias) {
		this(alias, com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS);
	}

	private CustomFields(java.lang.String alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.CustomFieldsRecord> aliased) {
		this(alias, aliased, null);
	}

	private CustomFields(java.lang.String alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.CustomFieldsRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, com.sonicle.webtop.core.jooq.core.Core.CORE, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomFieldsRecord> getPrimaryKey() {
		return com.sonicle.webtop.core.jooq.core.Keys.CUSTOM_FIELDS_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomFieldsRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomFieldsRecord>>asList(com.sonicle.webtop.core.jooq.core.Keys.CUSTOM_FIELDS_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public com.sonicle.webtop.core.jooq.core.tables.CustomFields as(java.lang.String alias) {
		return new com.sonicle.webtop.core.jooq.core.tables.CustomFields(alias, this);
	}

	/**
	 * Rename this table
	 */
	public com.sonicle.webtop.core.jooq.core.tables.CustomFields rename(java.lang.String name) {
		return new com.sonicle.webtop.core.jooq.core.tables.CustomFields(name, null);
	}
}
