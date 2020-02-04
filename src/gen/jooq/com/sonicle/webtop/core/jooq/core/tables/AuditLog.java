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
public class AuditLog extends org.jooq.impl.TableImpl<com.sonicle.webtop.core.jooq.core.tables.records.AuditLogRecord> {

	private static final long serialVersionUID = 1728163404;

	/**
	 * The reference instance of <code>core.audit_log</code>
	 */
	public static final com.sonicle.webtop.core.jooq.core.tables.AuditLog AUDIT_LOG = new com.sonicle.webtop.core.jooq.core.tables.AuditLog();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<com.sonicle.webtop.core.jooq.core.tables.records.AuditLogRecord> getRecordType() {
		return com.sonicle.webtop.core.jooq.core.tables.records.AuditLogRecord.class;
	}

	/**
	 * The column <code>core.audit_log.audit_log_id</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.AuditLogRecord, java.lang.Long> AUDIT_LOG_ID = createField("audit_log_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>core.audit_log.timestamp</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.AuditLogRecord, org.joda.time.DateTime> TIMESTAMP = createField("timestamp", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "", new com.sonicle.webtop.core.jooq.DateTimeConverter());

	/**
	 * The column <code>core.audit_log.domain_id</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.AuditLogRecord, java.lang.String> DOMAIN_ID = createField("domain_id", org.jooq.impl.SQLDataType.VARCHAR.length(20).nullable(false), this, "");

	/**
	 * The column <code>core.audit_log.user_id</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.AuditLogRecord, java.lang.String> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.VARCHAR.length(100).nullable(false), this, "");

	/**
	 * The column <code>core.audit_log.service_id</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.AuditLogRecord, java.lang.String> SERVICE_ID = createField("service_id", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * The column <code>core.audit_log.context</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.AuditLogRecord, java.lang.String> CONTEXT = createField("context", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

	/**
	 * The column <code>core.audit_log.action</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.AuditLogRecord, java.lang.String> ACTION = createField("action", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

	/**
	 * The column <code>core.audit_log.reference_id</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.AuditLogRecord, java.lang.String> REFERENCE_ID = createField("reference_id", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>core.audit_log.ip_address</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.AuditLogRecord, java.lang.String> IP_ADDRESS = createField("ip_address", org.jooq.impl.SQLDataType.VARCHAR.length(39), this, "");

	/**
	 * The column <code>core.audit_log.session_id</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.AuditLogRecord, java.lang.String> SESSION_ID = createField("session_id", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>core.audit_log.data</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.AuditLogRecord, java.lang.String> DATA = createField("data", org.jooq.impl.SQLDataType.CLOB, this, "");

	/**
	 * Create a <code>core.audit_log</code> table reference
	 */
	public AuditLog() {
		this("audit_log", null);
	}

	/**
	 * Create an aliased <code>core.audit_log</code> table reference
	 */
	public AuditLog(java.lang.String alias) {
		this(alias, com.sonicle.webtop.core.jooq.core.tables.AuditLog.AUDIT_LOG);
	}

	private AuditLog(java.lang.String alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.AuditLogRecord> aliased) {
		this(alias, aliased, null);
	}

	private AuditLog(java.lang.String alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.AuditLogRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, com.sonicle.webtop.core.jooq.core.Core.CORE, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<com.sonicle.webtop.core.jooq.core.tables.records.AuditLogRecord, java.lang.Long> getIdentity() {
		return com.sonicle.webtop.core.jooq.core.Keys.IDENTITY_AUDIT_LOG;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.AuditLogRecord> getPrimaryKey() {
		return com.sonicle.webtop.core.jooq.core.Keys.AUDIT_LOG_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.AuditLogRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.AuditLogRecord>>asList(com.sonicle.webtop.core.jooq.core.Keys.AUDIT_LOG_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public com.sonicle.webtop.core.jooq.core.tables.AuditLog as(java.lang.String alias) {
		return new com.sonicle.webtop.core.jooq.core.tables.AuditLog(alias, this);
	}

	/**
	 * Rename this table
	 */
	public com.sonicle.webtop.core.jooq.core.tables.AuditLog rename(java.lang.String name) {
		return new com.sonicle.webtop.core.jooq.core.tables.AuditLog(name, null);
	}
}
