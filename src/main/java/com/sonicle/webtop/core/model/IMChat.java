/*
 * Copyright (C) 2014 Sonicle S.r.l.
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Affero General Public License version 3 as published by
 * the Free Software Foundation with the addition of the following permission
 * added to Section 15 as permitted in Section 7(a): FOR ANY PART OF THE COVERED
 * WORK IN WHICH THE COPYRIGHT IS OWNED BY SONICLE, SONICLE DISCLAIMS THE
 * WARRANTY OF NON INFRINGEMENT OF THIRD PARTY RIGHTS.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program; if not, see http://www.gnu.org/licenses or write to
 * the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301 USA.
 *
 * You can contact Sonicle S.r.l. at email address sonicle[at]sonicle[dot]com
 *
 * The interactive user interfaces in modified source and object code versions
 * of this program must display Appropriate Legal Notices, as required under
 * Section 5 of the GNU Affero General Public License version 3.
 *
 * In accordance with Section 7(b) of the GNU Affero General Public License
 * version 3, these Appropriate Legal Notices must retain the display of the
 * Sonicle logo and Sonicle copyright notice. If the display of the logo is not
 * reasonably feasible for technical reasons, the Appropriate Legal Notices must
 * display the words "Copyright (C) 2014 Sonicle S.r.l.".
 */
package com.sonicle.webtop.core.model;

import com.google.gson.annotations.SerializedName;
import org.joda.time.DateTime;

/**
 *
 * @author malbinola
 */
public class IMChat {
	private Integer id;
	private String domainId;
	private String userId;
	private RevisionStatus revisionStatus;
	private DateTime revisionTimestamp;
	private String chatJid;
	private String ownerJid;
	private String name;
	private Boolean isGroupChat;
	private DateTime lastSeenActivity;
	private String withJid; // Only for direct chats
	
	public IMChat() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDomainId() {
		return domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public RevisionStatus getRevisionStatus() {
		return revisionStatus;
	}

	public void setRevisionStatus(RevisionStatus revisionStatus) {
		this.revisionStatus = revisionStatus;
	}
	
	public DateTime getRevisionTimestamp() {
		return revisionTimestamp;
	}

	public void setRevisionTimestamp(DateTime revisionTimestamp) {
		this.revisionTimestamp = revisionTimestamp;
	}

	public String getChatJid() {
		return chatJid;
	}

	public void setChatJid(String chatJid) {
		this.chatJid = chatJid;
	}

	public String getOwnerJid() {
		return ownerJid;
	}

	public void setOwnerJid(String ownerJid) {
		this.ownerJid = ownerJid;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Boolean getIsGroupChat() {
		return isGroupChat;
	}

	public void setIsGroupChat(Boolean isGroupChat) {
		this.isGroupChat = isGroupChat;
	}
	
	public DateTime getLastSeenActivity() {
		return lastSeenActivity;
	}

	public void setLastSeenActivity(DateTime lastSeenActivity) {
		this.lastSeenActivity = lastSeenActivity;
	}
	
	public String getWithJid() {
		return withJid;
	}

	public void setWithJid(String withJid) {
		this.withJid = withJid;
	}
	
	public static enum RevisionStatus {
		@SerializedName("M") MODIFIED,
		@SerializedName("D") DELETED;
	}
}
