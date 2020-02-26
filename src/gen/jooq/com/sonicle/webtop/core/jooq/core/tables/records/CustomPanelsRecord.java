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
public class CustomPanelsRecord extends org.jooq.impl.UpdatableRecordImpl<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsRecord> implements org.jooq.Record7<java.lang.String, java.lang.String, java.lang.String, java.lang.Short, java.lang.String, java.lang.String, java.lang.String> {

	private static final long serialVersionUID = -957448308;

	/**
	 * Setter for <code>core.custom_panels.custom_panel_id</code>.
	 */
	public void setCustomPanelId(java.lang.String value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>core.custom_panels.custom_panel_id</code>.
	 */
	public java.lang.String getCustomPanelId() {
		return (java.lang.String) getValue(0);
	}

	/**
	 * Setter for <code>core.custom_panels.domain_id</code>.
	 */
	public void setDomainId(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>core.custom_panels.domain_id</code>.
	 */
	public java.lang.String getDomainId() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>core.custom_panels.service_id</code>.
	 */
	public void setServiceId(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>core.custom_panels.service_id</code>.
	 */
	public java.lang.String getServiceId() {
		return (java.lang.String) getValue(2);
	}

	/**
	 * Setter for <code>core.custom_panels.order</code>.
	 */
	public void setOrder(java.lang.Short value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>core.custom_panels.order</code>.
	 */
	public java.lang.Short getOrder() {
		return (java.lang.Short) getValue(3);
	}

	/**
	 * Setter for <code>core.custom_panels.name</code>.
	 */
	public void setName(java.lang.String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>core.custom_panels.name</code>.
	 */
	public java.lang.String getName() {
		return (java.lang.String) getValue(4);
	}

	/**
	 * Setter for <code>core.custom_panels.description</code>.
	 */
	public void setDescription(java.lang.String value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>core.custom_panels.description</code>.
	 */
	public java.lang.String getDescription() {
		return (java.lang.String) getValue(5);
	}

	/**
	 * Setter for <code>core.custom_panels.title_i18n</code>.
	 */
	public void setTitleI18n(java.lang.String value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>core.custom_panels.title_i18n</code>.
	 */
	public java.lang.String getTitleI18n() {
		return (java.lang.String) getValue(6);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record1<java.lang.String> key() {
		return (org.jooq.Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record7 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row7<java.lang.String, java.lang.String, java.lang.String, java.lang.Short, java.lang.String, java.lang.String, java.lang.String> fieldsRow() {
		return (org.jooq.Row7) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row7<java.lang.String, java.lang.String, java.lang.String, java.lang.Short, java.lang.String, java.lang.String, java.lang.String> valuesRow() {
		return (org.jooq.Row7) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field1() {
		return com.sonicle.webtop.core.jooq.core.tables.CustomPanels.CUSTOM_PANELS.CUSTOM_PANEL_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return com.sonicle.webtop.core.jooq.core.tables.CustomPanels.CUSTOM_PANELS.DOMAIN_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return com.sonicle.webtop.core.jooq.core.tables.CustomPanels.CUSTOM_PANELS.SERVICE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Short> field4() {
		return com.sonicle.webtop.core.jooq.core.tables.CustomPanels.CUSTOM_PANELS.ORDER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field5() {
		return com.sonicle.webtop.core.jooq.core.tables.CustomPanels.CUSTOM_PANELS.NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field6() {
		return com.sonicle.webtop.core.jooq.core.tables.CustomPanels.CUSTOM_PANELS.DESCRIPTION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field7() {
		return com.sonicle.webtop.core.jooq.core.tables.CustomPanels.CUSTOM_PANELS.TITLE_I18N;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value1() {
		return getCustomPanelId();
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
		return getServiceId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Short value4() {
		return getOrder();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value5() {
		return getName();
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
	public java.lang.String value7() {
		return getTitleI18n();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CustomPanelsRecord value1(java.lang.String value) {
		setCustomPanelId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CustomPanelsRecord value2(java.lang.String value) {
		setDomainId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CustomPanelsRecord value3(java.lang.String value) {
		setServiceId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CustomPanelsRecord value4(java.lang.Short value) {
		setOrder(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CustomPanelsRecord value5(java.lang.String value) {
		setName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CustomPanelsRecord value6(java.lang.String value) {
		setDescription(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CustomPanelsRecord value7(java.lang.String value) {
		setTitleI18n(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CustomPanelsRecord values(java.lang.String value1, java.lang.String value2, java.lang.String value3, java.lang.Short value4, java.lang.String value5, java.lang.String value6, java.lang.String value7) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached CustomPanelsRecord
	 */
	public CustomPanelsRecord() {
		super(com.sonicle.webtop.core.jooq.core.tables.CustomPanels.CUSTOM_PANELS);
	}

	/**
	 * Create a detached, initialised CustomPanelsRecord
	 */
	public CustomPanelsRecord(java.lang.String customPanelId, java.lang.String domainId, java.lang.String serviceId, java.lang.Short order, java.lang.String name, java.lang.String description, java.lang.String titleI18n) {
		super(com.sonicle.webtop.core.jooq.core.tables.CustomPanels.CUSTOM_PANELS);

		setValue(0, customPanelId);
		setValue(1, domainId);
		setValue(2, serviceId);
		setValue(3, order);
		setValue(4, name);
		setValue(5, description);
		setValue(6, titleI18n);
	}
}
