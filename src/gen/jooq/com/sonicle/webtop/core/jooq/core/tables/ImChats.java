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
public class ImChats extends org.jooq.impl.TableImpl<com.sonicle.webtop.core.jooq.core.tables.records.ImChatsRecord> {

	private static final long serialVersionUID = 709193998;

	/**
	 * The reference instance of <code>core.im_chats</code>
	 */
	public static final com.sonicle.webtop.core.jooq.core.tables.ImChats IM_CHATS = new com.sonicle.webtop.core.jooq.core.tables.ImChats();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<com.sonicle.webtop.core.jooq.core.tables.records.ImChatsRecord> getRecordType() {
		return com.sonicle.webtop.core.jooq.core.tables.records.ImChatsRecord.class;
	}

	/**
	 * The column <code>core.im_chats.id</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ImChatsRecord, java.lang.Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>core.im_chats.domain_id</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ImChatsRecord, java.lang.String> DOMAIN_ID = createField("domain_id", org.jooq.impl.SQLDataType.VARCHAR.length(20).nullable(false), this, "");

	/**
	 * The column <code>core.im_chats.user_id</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ImChatsRecord, java.lang.String> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.VARCHAR.length(100).nullable(false), this, "");

	/**
	 * The column <code>core.im_chats.revision_status</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ImChatsRecord, java.lang.String> REVISION_STATUS = createField("revision_status", org.jooq.impl.SQLDataType.VARCHAR.length(1).nullable(false), this, "");

	/**
	 * The column <code>core.im_chats.revision_timestamp</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ImChatsRecord, org.joda.time.DateTime> REVISION_TIMESTAMP = createField("revision_timestamp", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "", new com.sonicle.webtop.core.jooq.DateTimeConverter());

	/**
	 * The column <code>core.im_chats.chat_jid</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ImChatsRecord, java.lang.String> CHAT_JID = createField("chat_jid", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * The column <code>core.im_chats.owner_jid</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ImChatsRecord, java.lang.String> OWNER_JID = createField("owner_jid", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * The column <code>core.im_chats.name</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ImChatsRecord, java.lang.String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * The column <code>core.im_chats.is_group_chat</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ImChatsRecord, java.lang.Boolean> IS_GROUP_CHAT = createField("is_group_chat", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "");

	/**
	 * The column <code>core.im_chats.last_seen_activity</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ImChatsRecord, org.joda.time.DateTime> LAST_SEEN_ACTIVITY = createField("last_seen_activity", org.jooq.impl.SQLDataType.TIMESTAMP, this, "", new com.sonicle.webtop.core.jooq.DateTimeConverter());

	/**
	 * The column <code>core.im_chats.with_jid</code>.
	 */
	public final org.jooq.TableField<com.sonicle.webtop.core.jooq.core.tables.records.ImChatsRecord, java.lang.String> WITH_JID = createField("with_jid", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * Create a <code>core.im_chats</code> table reference
	 */
	public ImChats() {
		this("im_chats", null);
	}

	/**
	 * Create an aliased <code>core.im_chats</code> table reference
	 */
	public ImChats(java.lang.String alias) {
		this(alias, com.sonicle.webtop.core.jooq.core.tables.ImChats.IM_CHATS);
	}

	private ImChats(java.lang.String alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.ImChatsRecord> aliased) {
		this(alias, aliased, null);
	}

	private ImChats(java.lang.String alias, org.jooq.Table<com.sonicle.webtop.core.jooq.core.tables.records.ImChatsRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, com.sonicle.webtop.core.jooq.core.Core.CORE, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<com.sonicle.webtop.core.jooq.core.tables.records.ImChatsRecord, java.lang.Integer> getIdentity() {
		return com.sonicle.webtop.core.jooq.core.Keys.IDENTITY_IM_CHATS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.ImChatsRecord> getPrimaryKey() {
		return com.sonicle.webtop.core.jooq.core.Keys.IM_HISTORY_CHATS_2_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.ImChatsRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.ImChatsRecord>>asList(com.sonicle.webtop.core.jooq.core.Keys.IM_HISTORY_CHATS_2_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public com.sonicle.webtop.core.jooq.core.tables.ImChats as(java.lang.String alias) {
		return new com.sonicle.webtop.core.jooq.core.tables.ImChats(alias, this);
	}

	/**
	 * Rename this table
	 */
	public com.sonicle.webtop.core.jooq.core.tables.ImChats rename(java.lang.String name) {
		return new com.sonicle.webtop.core.jooq.core.tables.ImChats(name, null);
	}
}
