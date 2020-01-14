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
public class ImChatsRecord extends org.jooq.impl.UpdatableRecordImpl<com.sonicle.webtop.core.jooq.core.tables.records.ImChatsRecord> implements org.jooq.Record11<java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, org.joda.time.DateTime, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, org.joda.time.DateTime, java.lang.String> {

	private static final long serialVersionUID = -589556785;

	/**
	 * Setter for <code>core.im_chats.id</code>.
	 */
	public void setId(java.lang.Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>core.im_chats.id</code>.
	 */
	public java.lang.Integer getId() {
		return (java.lang.Integer) getValue(0);
	}

	/**
	 * Setter for <code>core.im_chats.domain_id</code>.
	 */
	public void setDomainId(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>core.im_chats.domain_id</code>.
	 */
	public java.lang.String getDomainId() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>core.im_chats.user_id</code>.
	 */
	public void setUserId(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>core.im_chats.user_id</code>.
	 */
	public java.lang.String getUserId() {
		return (java.lang.String) getValue(2);
	}

	/**
	 * Setter for <code>core.im_chats.revision_status</code>.
	 */
	public void setRevisionStatus(java.lang.String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>core.im_chats.revision_status</code>.
	 */
	public java.lang.String getRevisionStatus() {
		return (java.lang.String) getValue(3);
	}

	/**
	 * Setter for <code>core.im_chats.revision_timestamp</code>.
	 */
	public void setRevisionTimestamp(org.joda.time.DateTime value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>core.im_chats.revision_timestamp</code>.
	 */
	public org.joda.time.DateTime getRevisionTimestamp() {
		return (org.joda.time.DateTime) getValue(4);
	}

	/**
	 * Setter for <code>core.im_chats.chat_jid</code>.
	 */
	public void setChatJid(java.lang.String value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>core.im_chats.chat_jid</code>.
	 */
	public java.lang.String getChatJid() {
		return (java.lang.String) getValue(5);
	}

	/**
	 * Setter for <code>core.im_chats.owner_jid</code>.
	 */
	public void setOwnerJid(java.lang.String value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>core.im_chats.owner_jid</code>.
	 */
	public java.lang.String getOwnerJid() {
		return (java.lang.String) getValue(6);
	}

	/**
	 * Setter for <code>core.im_chats.name</code>.
	 */
	public void setName(java.lang.String value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>core.im_chats.name</code>.
	 */
	public java.lang.String getName() {
		return (java.lang.String) getValue(7);
	}

	/**
	 * Setter for <code>core.im_chats.is_group_chat</code>.
	 */
	public void setIsGroupChat(java.lang.Boolean value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>core.im_chats.is_group_chat</code>.
	 */
	public java.lang.Boolean getIsGroupChat() {
		return (java.lang.Boolean) getValue(8);
	}

	/**
	 * Setter for <code>core.im_chats.last_seen_activity</code>.
	 */
	public void setLastSeenActivity(org.joda.time.DateTime value) {
		setValue(9, value);
	}

	/**
	 * Getter for <code>core.im_chats.last_seen_activity</code>.
	 */
	public org.joda.time.DateTime getLastSeenActivity() {
		return (org.joda.time.DateTime) getValue(9);
	}

	/**
	 * Setter for <code>core.im_chats.with_jid</code>.
	 */
	public void setWithJid(java.lang.String value) {
		setValue(10, value);
	}

	/**
	 * Getter for <code>core.im_chats.with_jid</code>.
	 */
	public java.lang.String getWithJid() {
		return (java.lang.String) getValue(10);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record1<java.lang.Integer> key() {
		return (org.jooq.Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record11 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row11<java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, org.joda.time.DateTime, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, org.joda.time.DateTime, java.lang.String> fieldsRow() {
		return (org.jooq.Row11) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row11<java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, org.joda.time.DateTime, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, org.joda.time.DateTime, java.lang.String> valuesRow() {
		return (org.jooq.Row11) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field1() {
		return com.sonicle.webtop.core.jooq.core.tables.ImChats.IM_CHATS.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return com.sonicle.webtop.core.jooq.core.tables.ImChats.IM_CHATS.DOMAIN_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return com.sonicle.webtop.core.jooq.core.tables.ImChats.IM_CHATS.USER_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field4() {
		return com.sonicle.webtop.core.jooq.core.tables.ImChats.IM_CHATS.REVISION_STATUS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<org.joda.time.DateTime> field5() {
		return com.sonicle.webtop.core.jooq.core.tables.ImChats.IM_CHATS.REVISION_TIMESTAMP;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field6() {
		return com.sonicle.webtop.core.jooq.core.tables.ImChats.IM_CHATS.CHAT_JID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field7() {
		return com.sonicle.webtop.core.jooq.core.tables.ImChats.IM_CHATS.OWNER_JID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field8() {
		return com.sonicle.webtop.core.jooq.core.tables.ImChats.IM_CHATS.NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Boolean> field9() {
		return com.sonicle.webtop.core.jooq.core.tables.ImChats.IM_CHATS.IS_GROUP_CHAT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<org.joda.time.DateTime> field10() {
		return com.sonicle.webtop.core.jooq.core.tables.ImChats.IM_CHATS.LAST_SEEN_ACTIVITY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field11() {
		return com.sonicle.webtop.core.jooq.core.tables.ImChats.IM_CHATS.WITH_JID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value1() {
		return getId();
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
		return getUserId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value4() {
		return getRevisionStatus();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.joda.time.DateTime value5() {
		return getRevisionTimestamp();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value6() {
		return getChatJid();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value7() {
		return getOwnerJid();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value8() {
		return getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Boolean value9() {
		return getIsGroupChat();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.joda.time.DateTime value10() {
		return getLastSeenActivity();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value11() {
		return getWithJid();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ImChatsRecord value1(java.lang.Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ImChatsRecord value2(java.lang.String value) {
		setDomainId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ImChatsRecord value3(java.lang.String value) {
		setUserId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ImChatsRecord value4(java.lang.String value) {
		setRevisionStatus(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ImChatsRecord value5(org.joda.time.DateTime value) {
		setRevisionTimestamp(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ImChatsRecord value6(java.lang.String value) {
		setChatJid(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ImChatsRecord value7(java.lang.String value) {
		setOwnerJid(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ImChatsRecord value8(java.lang.String value) {
		setName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ImChatsRecord value9(java.lang.Boolean value) {
		setIsGroupChat(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ImChatsRecord value10(org.joda.time.DateTime value) {
		setLastSeenActivity(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ImChatsRecord value11(java.lang.String value) {
		setWithJid(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ImChatsRecord values(java.lang.Integer value1, java.lang.String value2, java.lang.String value3, java.lang.String value4, org.joda.time.DateTime value5, java.lang.String value6, java.lang.String value7, java.lang.String value8, java.lang.Boolean value9, org.joda.time.DateTime value10, java.lang.String value11) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached ImChatsRecord
	 */
	public ImChatsRecord() {
		super(com.sonicle.webtop.core.jooq.core.tables.ImChats.IM_CHATS);
	}

	/**
	 * Create a detached, initialised ImChatsRecord
	 */
	public ImChatsRecord(java.lang.Integer id, java.lang.String domainId, java.lang.String userId, java.lang.String revisionStatus, org.joda.time.DateTime revisionTimestamp, java.lang.String chatJid, java.lang.String ownerJid, java.lang.String name, java.lang.Boolean isGroupChat, org.joda.time.DateTime lastSeenActivity, java.lang.String withJid) {
		super(com.sonicle.webtop.core.jooq.core.tables.ImChats.IM_CHATS);

		setValue(0, id);
		setValue(1, domainId);
		setValue(2, userId);
		setValue(3, revisionStatus);
		setValue(4, revisionTimestamp);
		setValue(5, chatJid);
		setValue(6, ownerJid);
		setValue(7, name);
		setValue(8, isGroupChat);
		setValue(9, lastSeenActivity);
		setValue(10, withJid);
	}
}
