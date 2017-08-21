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
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;

/**
 *
 * @author malbinola
 */
public class IMMessage {
	private Integer id;
	private String domainId;
	private String userId;
	private String chatJid;
	private String senderJid;
	private String senderResource;
	private DateTime timestamp;
	private DateTime deliveryTimestamp;
	private Action action;
	private String text;
	private String data;
	private String messageUid;
	private String stanzaId;
	
	public IMMessage() {}

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

	public String getChatJid() {
		return chatJid;
	}

	public void setChatJid(String chatJid) {
		this.chatJid = chatJid;
	}

	public String getSenderJid() {
		return senderJid;
	}

	public void setSenderJid(String senderJid) {
		this.senderJid = senderJid;
	}

	public String getSenderResource() {
		return senderResource;
	}

	public void setSenderResource(String senderResource) {
		this.senderResource = senderResource;
	}

	public DateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(DateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	public DateTime getDeliveryTimestamp() {
		return deliveryTimestamp;
	}

	public void setDeliveryTimestamp(DateTime deliveryTimestamp) {
		this.deliveryTimestamp = deliveryTimestamp;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getMessageUid() {
		return messageUid;
	}

	public void setMessageUid(String messageUid) {
		this.messageUid = messageUid;
	}

	public String getStanzaId() {
		return stanzaId;
	}

	public void setStanzaId(String stanzaId) {
		this.stanzaId = stanzaId;
	}
	
	public LocalDate getTimestampDate(DateTimeZone timezone) {
		return timestamp.withZone(timezone).toLocalDate();
	}
	
	public LocalDate getDeliveryTimestampDate(DateTimeZone timezone) {
		if (deliveryTimestamp != null) {
			return deliveryTimestamp.withZone(timezone).toLocalDate();
		} else {
			return getTimestampDate(timezone);
		}
	}
	
	public static enum Action {
		@SerializedName("none") NONE,
		@SerializedName("file") FILE,
		@SerializedName("warn") WARN,
		@SerializedName("close") CHAT_CLOSE,
		@SerializedName("join") USER_JOIN,
		@SerializedName("leave") USER_LEAVE,
		@SerializedName("kick") USER_KICK,
		@SerializedName("ban") USER_BAN,
		@SerializedName("title") ROOM_TITLE_CHANGE;
	}
}
