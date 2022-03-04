/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.core.tables;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ImMessages extends org.jooq.impl.TableImpl<com.sonicle.webtop.core.jooq.core.tables.records.ImMessagesRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>core.im_messages</code>
     */
    public static final ImMessages IM_MESSAGES = new ImMessages();

    /**
     * The class holding records for this type
     */
    @java.lang.Override
    public java.lang.Class<com.sonicle.webtop.core.jooq.core.tables.records.ImMessagesRecord> getRecordType() {
        return com.sonicle.webtop.core.jooq.core.tables.records.ImMessagesRecord.class;
    }

    /**
     * The column <code>core.im_messages.id</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ImMessagesRecord, java.lang.Integer> ID = createField(org.jooq.impl.DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('core.seq_im_messages'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>core.im_messages.domain_id</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ImMessagesRecord, java.lang.String> DOMAIN_ID = createField(org.jooq.impl.DSL.name("domain_id"), org.jooq.impl.SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * The column <code>core.im_messages.user_id</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ImMessagesRecord, java.lang.String> USER_ID = createField(org.jooq.impl.DSL.name("user_id"), org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>core.im_messages.chat_jid</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ImMessagesRecord, java.lang.String> CHAT_JID = createField(org.jooq.impl.DSL.name("chat_jid"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>core.im_messages.sender_jid</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ImMessagesRecord, java.lang.String> SENDER_JID = createField(org.jooq.impl.DSL.name("sender_jid"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>core.im_messages.sender_resource</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ImMessagesRecord, java.lang.String> SENDER_RESOURCE = createField(org.jooq.impl.DSL.name("sender_resource"), org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>core.im_messages.timestamp</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ImMessagesRecord, org.joda.time.DateTime> TIMESTAMP = createField(org.jooq.impl.DSL.name("timestamp"), org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "", new com.sonicle.jooq.jsr310.OffsetDateTimeJodaConverter());

    /**
     * The column <code>core.im_messages.delivery_timestamp</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ImMessagesRecord, org.joda.time.DateTime> DELIVERY_TIMESTAMP = createField(org.jooq.impl.DSL.name("delivery_timestamp"), org.jooq.impl.SQLDataType.TIMESTAMPWITHTIMEZONE(6), this, "", new com.sonicle.jooq.jsr310.OffsetDateTimeJodaConverter());

    /**
     * The column <code>core.im_messages.action</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ImMessagesRecord, java.lang.String> ACTION = createField(org.jooq.impl.DSL.name("action"), org.jooq.impl.SQLDataType.VARCHAR(10).nullable(false), this, "");

    /**
     * The column <code>core.im_messages.text</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ImMessagesRecord, java.lang.String> TEXT = createField(org.jooq.impl.DSL.name("text"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>core.im_messages.data</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ImMessagesRecord, java.lang.String> DATA = createField(org.jooq.impl.DSL.name("data"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>core.im_messages.message_uid</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ImMessagesRecord, java.lang.String> MESSAGE_UID = createField(org.jooq.impl.DSL.name("message_uid"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>core.im_messages.stanza_id</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ImMessagesRecord, java.lang.String> STANZA_ID = createField(org.jooq.impl.DSL.name("stanza_id"), org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    private ImMessages(org.jooq.Name alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.ImMessagesRecord> aliased) {
        this(alias, aliased, null);
    }

    private ImMessages(org.jooq.Name alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.ImMessagesRecord> aliased, org.jooq.Field<?>[] parameters) {
        super(alias, null, aliased, parameters, org.jooq.impl.DSL.comment(""), org.jooq.TableOptions.table());
    }

    /**
     * Create an aliased <code>core.im_messages</code> table reference
     */
    public ImMessages(java.lang.String alias) {
        this(org.jooq.impl.DSL.name(alias), IM_MESSAGES);
    }

    /**
     * Create an aliased <code>core.im_messages</code> table reference
     */
    public ImMessages(org.jooq.Name alias) {
        this(alias, IM_MESSAGES);
    }

    /**
     * Create a <code>core.im_messages</code> table reference
     */
    public ImMessages() {
        this(org.jooq.impl.DSL.name("im_messages"), null);
    }

    public <O extends org.jooq.Record> ImMessages(org.jooq.Table<O> child, org.jooq.ForeignKey<O, com.sonicle.webtop.core.jooq.core.tables.records.ImMessagesRecord> key) {
        super(child, key, IM_MESSAGES);
    }

    @java.lang.Override
    public org.jooq.Schema getSchema() {
        return com.sonicle.webtop.core.jooq.core.Core.CORE;
    }

    @java.lang.Override
    public java.util.List<org.jooq.Index> getIndexes() {
        return java.util.Arrays.<org.jooq.Index>asList(com.sonicle.webtop.core.jooq.core.Indexes.IM_MESSAGES_AK1, com.sonicle.webtop.core.jooq.core.Indexes.IM_MESSAGES_AK2, com.sonicle.webtop.core.jooq.core.Indexes.IM_MESSAGES_AK3);
    }

    @java.lang.Override
    public org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.ImMessagesRecord> getPrimaryKey() {
        return com.sonicle.webtop.core.jooq.core.Keys.IM_MESSAGES_PKEY;
    }

    @java.lang.Override
    public java.util.List<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.ImMessagesRecord>> getKeys() {
        return java.util.Arrays.<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.ImMessagesRecord>>asList(com.sonicle.webtop.core.jooq.core.Keys.IM_MESSAGES_PKEY);
    }

    @java.lang.Override
    public ImMessages as(java.lang.String alias) {
        return new ImMessages(org.jooq.impl.DSL.name(alias), this);
    }

    @java.lang.Override
    public ImMessages as(org.jooq.Name alias) {
        return new ImMessages(alias, this);
    }

    /**
     * Rename this table
     */
    @java.lang.Override
    public ImMessages rename(java.lang.String name) {
        return new ImMessages(org.jooq.impl.DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @java.lang.Override
    public ImMessages rename(org.jooq.Name name) {
        return new ImMessages(name, null);
    }

    // -------------------------------------------------------------------------
    // Row13 type methods
    // -------------------------------------------------------------------------

    @java.lang.Override
    public org.jooq.Row13<java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, org.joda.time.DateTime, org.joda.time.DateTime, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String> fieldsRow() {
        return (org.jooq.Row13) super.fieldsRow();
    }
}
