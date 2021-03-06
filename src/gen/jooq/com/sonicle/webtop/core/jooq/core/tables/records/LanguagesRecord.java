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
public class LanguagesRecord extends org.jooq.impl.UpdatableRecordImpl<com.sonicle.webtop.core.jooq.core.tables.records.LanguagesRecord> implements org.jooq.Record1<java.lang.String> {

	private static final long serialVersionUID = 429269741;

	/**
	 * Setter for <code>core.languages.language_tag</code>.
	 */
	public void setLanguageTag(java.lang.String value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>core.languages.language_tag</code>.
	 */
	public java.lang.String getLanguageTag() {
		return (java.lang.String) getValue(0);
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
	// Record1 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row1<java.lang.String> fieldsRow() {
		return (org.jooq.Row1) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row1<java.lang.String> valuesRow() {
		return (org.jooq.Row1) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field1() {
		return com.sonicle.webtop.core.jooq.core.tables.Languages.LANGUAGES.LANGUAGE_TAG;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value1() {
		return getLanguageTag();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LanguagesRecord value1(java.lang.String value) {
		setLanguageTag(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LanguagesRecord values(java.lang.String value1) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached LanguagesRecord
	 */
	public LanguagesRecord() {
		super(com.sonicle.webtop.core.jooq.core.tables.Languages.LANGUAGES);
	}

	/**
	 * Create a detached, initialised LanguagesRecord
	 */
	public LanguagesRecord(java.lang.String languageTag) {
		super(com.sonicle.webtop.core.jooq.core.tables.Languages.LANGUAGES);

		setValue(0, languageTag);
	}
}
