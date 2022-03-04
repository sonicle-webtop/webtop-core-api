/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.core.tables.pojos;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ImChats implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private java.lang.Integer      id;
    private java.lang.String       domainId;
    private java.lang.String       userId;
    private java.lang.String       revisionStatus;
    private org.joda.time.DateTime revisionTimestamp;
    private java.lang.String       chatJid;
    private java.lang.String       ownerJid;
    private java.lang.String       name;
    private java.lang.Boolean      isGroupChat;
    private org.joda.time.DateTime lastSeenActivity;
    private java.lang.String       withJid;

    public ImChats() {}

    public ImChats(ImChats value) {
        this.id = value.id;
        this.domainId = value.domainId;
        this.userId = value.userId;
        this.revisionStatus = value.revisionStatus;
        this.revisionTimestamp = value.revisionTimestamp;
        this.chatJid = value.chatJid;
        this.ownerJid = value.ownerJid;
        this.name = value.name;
        this.isGroupChat = value.isGroupChat;
        this.lastSeenActivity = value.lastSeenActivity;
        this.withJid = value.withJid;
    }

    public ImChats(
        java.lang.Integer      id,
        java.lang.String       domainId,
        java.lang.String       userId,
        java.lang.String       revisionStatus,
        org.joda.time.DateTime revisionTimestamp,
        java.lang.String       chatJid,
        java.lang.String       ownerJid,
        java.lang.String       name,
        java.lang.Boolean      isGroupChat,
        org.joda.time.DateTime lastSeenActivity,
        java.lang.String       withJid
    ) {
        this.id = id;
        this.domainId = domainId;
        this.userId = userId;
        this.revisionStatus = revisionStatus;
        this.revisionTimestamp = revisionTimestamp;
        this.chatJid = chatJid;
        this.ownerJid = ownerJid;
        this.name = name;
        this.isGroupChat = isGroupChat;
        this.lastSeenActivity = lastSeenActivity;
        this.withJid = withJid;
    }

    /**
     * Getter for <code>core.im_chats.id</code>.
     */
    public java.lang.Integer getId() {
        return this.id;
    }

    /**
     * Setter for <code>core.im_chats.id</code>.
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    /**
     * Getter for <code>core.im_chats.domain_id</code>.
     */
    public java.lang.String getDomainId() {
        return this.domainId;
    }

    /**
     * Setter for <code>core.im_chats.domain_id</code>.
     */
    public void setDomainId(java.lang.String domainId) {
        this.domainId = domainId;
    }

    /**
     * Getter for <code>core.im_chats.user_id</code>.
     */
    public java.lang.String getUserId() {
        return this.userId;
    }

    /**
     * Setter for <code>core.im_chats.user_id</code>.
     */
    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }

    /**
     * Getter for <code>core.im_chats.revision_status</code>.
     */
    public java.lang.String getRevisionStatus() {
        return this.revisionStatus;
    }

    /**
     * Setter for <code>core.im_chats.revision_status</code>.
     */
    public void setRevisionStatus(java.lang.String revisionStatus) {
        this.revisionStatus = revisionStatus;
    }

    /**
     * Getter for <code>core.im_chats.revision_timestamp</code>.
     */
    public org.joda.time.DateTime getRevisionTimestamp() {
        return this.revisionTimestamp;
    }

    /**
     * Setter for <code>core.im_chats.revision_timestamp</code>.
     */
    public void setRevisionTimestamp(org.joda.time.DateTime revisionTimestamp) {
        this.revisionTimestamp = revisionTimestamp;
    }

    /**
     * Getter for <code>core.im_chats.chat_jid</code>.
     */
    public java.lang.String getChatJid() {
        return this.chatJid;
    }

    /**
     * Setter for <code>core.im_chats.chat_jid</code>.
     */
    public void setChatJid(java.lang.String chatJid) {
        this.chatJid = chatJid;
    }

    /**
     * Getter for <code>core.im_chats.owner_jid</code>.
     */
    public java.lang.String getOwnerJid() {
        return this.ownerJid;
    }

    /**
     * Setter for <code>core.im_chats.owner_jid</code>.
     */
    public void setOwnerJid(java.lang.String ownerJid) {
        this.ownerJid = ownerJid;
    }

    /**
     * Getter for <code>core.im_chats.name</code>.
     */
    public java.lang.String getName() {
        return this.name;
    }

    /**
     * Setter for <code>core.im_chats.name</code>.
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }

    /**
     * Getter for <code>core.im_chats.is_group_chat</code>.
     */
    public java.lang.Boolean getIsGroupChat() {
        return this.isGroupChat;
    }

    /**
     * Setter for <code>core.im_chats.is_group_chat</code>.
     */
    public void setIsGroupChat(java.lang.Boolean isGroupChat) {
        this.isGroupChat = isGroupChat;
    }

    /**
     * Getter for <code>core.im_chats.last_seen_activity</code>.
     */
    public org.joda.time.DateTime getLastSeenActivity() {
        return this.lastSeenActivity;
    }

    /**
     * Setter for <code>core.im_chats.last_seen_activity</code>.
     */
    public void setLastSeenActivity(org.joda.time.DateTime lastSeenActivity) {
        this.lastSeenActivity = lastSeenActivity;
    }

    /**
     * Getter for <code>core.im_chats.with_jid</code>.
     */
    public java.lang.String getWithJid() {
        return this.withJid;
    }

    /**
     * Setter for <code>core.im_chats.with_jid</code>.
     */
    public void setWithJid(java.lang.String withJid) {
        this.withJid = withJid;
    }

    @Override
    public String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("ImChats (");

        sb.append(id);
        sb.append(", ").append(domainId);
        sb.append(", ").append(userId);
        sb.append(", ").append(revisionStatus);
        sb.append(", ").append(revisionTimestamp);
        sb.append(", ").append(chatJid);
        sb.append(", ").append(ownerJid);
        sb.append(", ").append(name);
        sb.append(", ").append(isGroupChat);
        sb.append(", ").append(lastSeenActivity);
        sb.append(", ").append(withJid);

        sb.append(")");
        return sb.toString();
    }
}
