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
public class CustomPanelsFields extends org.jooq.impl.TableImpl<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord> {

	private static final long serialVersionUID = 1010330902;

	/**
	 * The reference instance of <code>core.custom_panels_fields</code>
	 */
	public static final com.sonicle.webtop.core.jooq.core.tables.CustomPanelsFields CUSTOM_PANELS_FIELDS = new com.sonicle.webtop.core.jooq.core.tables.CustomPanelsFields();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord> getRecordType() {
		return com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord.class;
	}

	/**
	 * The column <code>core.custom_panels_fields.custom_panel_id</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord, java.lang.String> CUSTOM_PANEL_ID = createField("custom_panel_id", org.jooq.impl.SQLDataType.VARCHAR.length(22).nullable(false), this, "");

	/**
	 * The column <code>core.custom_panels_fields.custom_field_id</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord, java.lang.String> CUSTOM_FIELD_ID = createField("custom_field_id", org.jooq.impl.SQLDataType.VARCHAR.length(22).nullable(false), this, "");

	/**
	 * The column <code>core.custom_panels_fields.order</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord, java.lang.Short> ORDER = createField("order", org.jooq.impl.SQLDataType.SMALLINT.nullable(false), this, "");

	/**
	 * Create a <code>core.custom_panels_fields</code> table reference
	 */
	public CustomPanelsFields() {
		this("custom_panels_fields", null);
	}

	/**
	 * Create an aliased <code>core.custom_panels_fields</code> table reference
	 */
	public CustomPanelsFields(java.lang.String alias) {
		this(alias, com.sonicle.webtop.core.jooq.core.tables.CustomPanelsFields.CUSTOM_PANELS_FIELDS);
	}

	private CustomPanelsFields(java.lang.String alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord> aliased) {
		this(alias, aliased, null);
	}

	private CustomPanelsFields(java.lang.String alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, com.sonicle.webtop.core.jooq.core.Core.CORE, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord> getPrimaryKey() {
		return com.sonicle.webtop.core.jooq.core.Keys.CUSTOM_PANELS_FIELDS_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord>>asList(com.sonicle.webtop.core.jooq.core.Keys.CUSTOM_PANELS_FIELDS_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord, ?>>asList(com.sonicle.webtop.core.jooq.core.Keys.CUSTOM_PANELS_FIELDS__CUSTOM_PANELS_FIELDS_CUSTOM_PANEL_ID_FKEY, com.sonicle.webtop.core.jooq.core.Keys.CUSTOM_PANELS_FIELDS__CUSTOM_PANELS_FIELDS_CUSTOM_FIELD_ID_FKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public com.sonicle.webtop.core.jooq.core.tables.CustomPanelsFields as(java.lang.String alias) {
		return new com.sonicle.webtop.core.jooq.core.tables.CustomPanelsFields(alias, this);
	}

	/**
	 * Rename this table
	 */
	public com.sonicle.webtop.core.jooq.core.tables.CustomPanelsFields rename(java.lang.String name) {
		return new com.sonicle.webtop.core.jooq.core.tables.CustomPanelsFields(name, null);
	}
}