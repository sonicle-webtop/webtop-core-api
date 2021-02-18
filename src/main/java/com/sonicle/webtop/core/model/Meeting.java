/*
 * Copyright (C) 2020 Sonicle S.r.l.
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
 * display the words "Copyright (C) 2020 Sonicle S.r.l.".
 */
package com.sonicle.webtop.core.model;

import com.google.gson.annotations.SerializedName;
import java.net.URI;

/**
 *
 * @author malbinola
 */
public class Meeting {
	protected final Provider provider;
	protected final String id;
	protected final URI link;
	protected final ShareEmbedTexts embedTexts;
	
	public Meeting(Provider provider, String id, URI link, ShareEmbedTexts embedTexts) {
		this.provider = provider;
		this.id = id;
		this.link = link;
		this.embedTexts = embedTexts;
	}
	
	public Provider getProvider() {
		return provider;
	}

	public String getId() {
		return id;
	}

	public URI getLink() {
		return link;
	}
	
	public ShareEmbedTexts getEmbedTexts() {
		return embedTexts;
	}
	
	public static enum Provider {
		@SerializedName("jitsi") JITSI;
	}
	
	public static class ShareEmbedTexts {
		public final String info;
		public final String subject;
		public final String unschedDescription;
		public final String schedDescription;
		
		public ShareEmbedTexts(String info, String subject, String unschedDescription, String schedDescription) {
			this.info = info;
			this.subject = subject;
			this.unschedDescription = unschedDescription;
			this.schedDescription = schedDescription;
		}
	}
	
	public static class Builder<B extends Builder> {
		protected Provider provider;
		protected String id;
		protected URI link;
		protected ShareEmbedTexts embedTexts;
		
		public Builder() {}
		
		public B withProvider(Provider provider) {
			this.provider = provider;
			return (B)this;
		}
		
		public B withId(String id) {
			this.id = id;
			return (B)this;
		}
		
		public B withLink(URI link) {
			this.link = link;
			return (B)this;
		}
		
		public B withShareEmbedTexts(ShareEmbedTexts embedTexts) {
			this.embedTexts = embedTexts;
			return (B)this;
		}
		
		public Meeting build() {
			return new Meeting(provider, id, link, embedTexts);
		}
	}
}
