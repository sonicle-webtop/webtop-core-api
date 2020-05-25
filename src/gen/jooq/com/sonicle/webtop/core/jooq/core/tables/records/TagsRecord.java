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
public class TagsRecord extends org.jooq.impl.UpdatableRecordImpl<com.sonicle.webtop.core.jooq.core.tables.records.TagsRecord> implements org.jooq.Record7<java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String> {

	private static final long serialVersionUID = 613696850;

	/**
	 * Setter for <code>core.tags.tag_id</code>.
	 */
	public void setTagId(java.lang.String value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>core.tags.tag_id</code>.
	 */
	public java.lang.String getTagId() {
		return (java.lang.String) getValue(0);
	}

	/**
	 * Setter for <code>core.tags.domain_id</code>.
	 */
	public void setDomainId(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>core.tags.domain_id</code>.
	 */
	public java.lang.String getDomainId() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>core.tags.built_in</code>.
	 */
	public void setBuiltIn(java.lang.Boolean value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>core.tags.built_in</code>.
	 */
	public java.lang.Boolean getBuiltIn() {
		return (java.lang.Boolean) getValue(2);
	}

	/**
	 * Setter for <code>core.tags.name</code>.
	 */
	public void setName(java.lang.String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>core.tags.name</code>.
	 */
	public java.lang.String getName() {
		return (java.lang.String) getValue(3);
	}

	/**
	 * Setter for <code>core.tags.color</code>.
	 */
	public void setColor(java.lang.String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>core.tags.color</code>.
	 */
	public java.lang.String getColor() {
		return (java.lang.String) getValue(4);
	}

	/**
	 * Setter for <code>core.tags.user_id</code>.
	 */
	public void setUserId(java.lang.String value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>core.tags.user_id</code>.
	 */
	public java.lang.String getUserId() {
		return (java.lang.String) getValue(5);
	}

	/**
	 * Setter for <code>core.tags.external_id</code>.
	 */
	public void setExternalId(java.lang.String value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>core.tags.external_id</code>.
	 */
	public java.lang.String getExternalId() {
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
	public org.jooq.Row7<java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String> fieldsRow() {
		return (org.jooq.Row7) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row7<java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String> valuesRow() {
		return (org.jooq.Row7) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field1() {
		return com.sonicle.webtop.core.jooq.core.tables.Tags.TAGS.TAG_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return com.sonicle.webtop.core.jooq.core.tables.Tags.TAGS.DOMAIN_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Boolean> field3() {
		return com.sonicle.webtop.core.jooq.core.tables.Tags.TAGS.BUILT_IN;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field4() {
		return com.sonicle.webtop.core.jooq.core.tables.Tags.TAGS.NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field5() {
		return com.sonicle.webtop.core.jooq.core.tables.Tags.TAGS.COLOR;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field6() {
		return com.sonicle.webtop.core.jooq.core.tables.Tags.TAGS.USER_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field7() {
		return com.sonicle.webtop.core.jooq.core.tables.Tags.TAGS.EXTERNAL_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value1() {
		return getTagId();
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
	public java.lang.Boolean value3() {
		return getBuiltIn();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value4() {
		return getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value5() {
		return getColor();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value6() {
		return getUserId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value7() {
		return getExternalId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TagsRecord value1(java.lang.String value) {
		setTagId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TagsRecord value2(java.lang.String value) {
		setDomainId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TagsRecord value3(java.lang.Boolean value) {
		setBuiltIn(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TagsRecord value4(java.lang.String value) {
		setName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TagsRecord value5(java.lang.String value) {
		setColor(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TagsRecord value6(java.lang.String value) {
		setUserId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TagsRecord value7(java.lang.String value) {
		setExternalId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TagsRecord values(java.lang.String value1, java.lang.String value2, java.lang.Boolean value3, java.lang.String value4, java.lang.String value5, java.lang.String value6, java.lang.String value7) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached TagsRecord
	 */
	public TagsRecord() {
		super(com.sonicle.webtop.core.jooq.core.tables.Tags.TAGS);
	}

	/**
	 * Create a detached, initialised TagsRecord
	 */
	public TagsRecord(java.lang.String tagId, java.lang.String domainId, java.lang.Boolean builtIn, java.lang.String name, java.lang.String color, java.lang.String userId, java.lang.String externalId) {
		super(com.sonicle.webtop.core.jooq.core.tables.Tags.TAGS);

		setValue(0, tagId);
		setValue(1, domainId);
		setValue(2, builtIn);
		setValue(3, name);
		setValue(4, color);
		setValue(5, userId);
		setValue(6, externalId);
	}
}
