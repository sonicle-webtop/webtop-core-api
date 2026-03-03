/*
 * Copyright (C) 2026 Sonicle S.r.l.
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
 * display the words "Copyright (C) 2026 Sonicle S.r.l.".
 */
package com.sonicle.webtop.core.model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author malbinola
 */
public class Recipient {
	private final String source; // Do NOT change, its directly serialized client-side!
	private final String sourceName; // Do NOT change, its directly serialized client-side!
	private final String origin;
	private final String recipientId; // Do NOT change, its directly serialized client-side!
	//private final RecipientFieldType addressType; //TODO: Maybe add address type!
	private String address; // Do NOT change, its directly serialized client-side!
	private final String personal; // Do NOT change, its directly serialized client-side!
	private final RecipientType type; // Do NOT change, its directly serialized client-side!
	
	public Recipient(String sourceId, String sourceName, String origin, String recipientId, String address, String personal) {
		this(sourceId, sourceName, origin, recipientId, address, personal, null);
	}
	
	public Recipient(String sourceId, String sourceName, String origin, String recipientId, String address, String personal, RecipientType type) {
		this.source = sourceId; // The provider ID
		this.sourceName = sourceName; // The name associated to the provider
		this.origin = origin;
		this.recipientId = recipientId;
		//this.addressType = addressType;
		this.address = address;
		this.personal = personal;
		this.type = type;
	}

	public String getProviderId() {
		return source;
	}

	public String getProviderName() {
		return sourceName;
	}

	public String getOrigin() {
		return origin;
	}
	
	public String getRecipientId() {
		return recipientId;
	}
	
	public String getAddress() {
		return address;
	}
	
	/**
	 * @deprecated Why is this necessary?
	 */
	@Deprecated public void setAddress(String address) {
		this.address = address;
	}

	public String getPersonal() {
		return personal;
	}

	public RecipientType getRcptType() {
		return type;
	}
	
	public static enum RecipientType {
		@SerializedName("to") TO,
		@SerializedName("cc") CC,
		@SerializedName("bcc") BCC;
	}
}
