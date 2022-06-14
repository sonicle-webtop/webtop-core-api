/*
 * Copyright (C) 2019 Sonicle S.r.l.
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
 * display the words "Copyright (C) 2019 Sonicle S.r.l.".
 */
package com.sonicle.webtop.core.model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author malbinola
 */
public class CustomField extends CustomFieldBase {
	protected String fieldId;
	protected String domainId;
	protected String serviceId;

	public String getFieldId() {
		return fieldId;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}
	
	public String getDomainId() {
		return domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	
	//TODO: Type class is used in many projects so we leave here for now. When branch is fully merged move definition in CustomFieldBase!
	public static enum Type {
		
		// !!! Note for the maintainer !!!
		// When adding a new type, remember to update implementation also 
		// in the following classes:
		//  - com.sonicle.webtop.core.bol.js.ObjCustomFieldValue
		//  - com.sonicle.webtop.core.app.sdk.QueryBuilderWithCValues
		//  - com.sonicle.webtop.core.model.CustomFieldValue
		//  - com.sonicle.webtop.core.model.CustomFieldBase.isDataBindableType (only for DS feature)
		//  - client-core.model.isDataBindableType (only for DS feature)
		
		@SerializedName("text") TEXT,
		@SerializedName("textarea") TEXTAREA,
		@SerializedName("number") NUMBER,
		@SerializedName("date") DATE,
		@SerializedName("time") TIME,
		@SerializedName("datetime") DATE_TIME,
		@SerializedName("combobox") COMBOBOX,
		@SerializedName("comboboxds") COMBOBOX_DATASOURCE,
		@SerializedName("checkbox") CHECKBOX,
		@SerializedName("tag") TAG,
		@SerializedName("tagds") TAG_DATASOURCE,
		@SerializedName("contactpicker") CONTACT_PICKER
		;
	}
}
