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

import com.sonicle.commons.EnumUtils;
import com.sonicle.webtop.core.sdk.WTRuntimeException;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

/**
 *
 * @author malbinola
 */
public class CustomFieldValue {
	protected String fieldId;
	protected String stringValue;
	protected Double numberValue;
	protected Boolean booleanValue;
	protected DateTime dateValue;
	protected String textValue;
	
	public CustomFieldValue() {}
	
	public CustomFieldValue(String fieldId) {
		this.fieldId = fieldId;
	}
	
	public CustomFieldValue(CustomFieldValueCandidate candidate) {
		this.fieldId = candidate.getFieldId();
		this.stringValue = candidate.getStringValue();
		this.numberValue = candidate.getNumberValue();
		this.booleanValue = candidate.getBooleanValue();
		this.dateValue = candidate.getDateValue();
		this.textValue = candidate.getTextValue();
	}

	public String getFieldId() {
		return fieldId;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

	public String getStringValue() {
		return stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	public Double getNumberValue() {
		return numberValue;
	}

	public void setNumberValue(Double numberValue) {
		this.numberValue = numberValue;
	}

	public Boolean getBooleanValue() {
		return booleanValue;
	}

	public void setBooleanValue(Boolean booleanValue) {
		this.booleanValue = booleanValue;
	}

	public DateTime getDateValue() {
		return dateValue;
	}

	public void setDateValue(DateTime dateValue) {
		this.dateValue = dateValue;
	}
	
	public String getTextValue() {
		return textValue;
	}

	public void setTextValue(String textValue) {
		this.textValue = textValue;
	}
	
	public Object getValue(CustomField.Type type) {
		if (CustomField.Type.TEXT.equals(type)) {
			return stringValue;
		} else if (CustomField.Type.TEXTAREA.equals(type)) {
			return textValue;
		} else if (CustomField.Type.NUMBER.equals(type)) {
			return numberValue;
		} else if (CustomField.Type.DATE.equals(type)) {
			return (dateValue != null) ? dateValue.withZone(DateTimeZone.UTC).toLocalDate() : null;
		} else if (CustomField.Type.TIME.equals(type)) {
			return (dateValue != null) ? dateValue.withZone(DateTimeZone.UTC).toLocalTime(): null;
		} else if (CustomField.Type.DATE_TIME.equals(type)) {
			return dateValue;
		} else if (CustomField.Type.COMBOBOX.equals(type) || CustomField.Type.COMBOBOX_DATASOURCE.equals(type)) {
			return stringValue;
		} else if (CustomField.Type.TAG.equals(type) || CustomField.Type.TAG_DATASOURCE.equals(type)) {
			return stringValue;
		} else if (CustomField.Type.CHECKBOX.equals(type)) {
			return booleanValue;
		} else if (CustomField.Type.CONTACT_PICKER.equals(type)) {
			return stringValue;
		}  else {
			throw new WTRuntimeException("Custom field type not supported [{}]", EnumUtils.toSerializedName(type));
		}
	}
	
	public void setValue(CustomField.Type type, Object value) {
		if (CustomField.Type.TEXT.equals(type)) {
			stringValue = (String)value;
		} else if (CustomField.Type.TEXTAREA.equals(type)) {
			textValue = (String)value;
		} else if (CustomField.Type.NUMBER.equals(type)) {
			numberValue = (Double)value;
		} else if (CustomField.Type.DATE.equals(type)) {
			LocalDate date = (LocalDate)value;
			dateValue = (date != null) ? date.toDateTimeAtStartOfDay(DateTimeZone.UTC) : null;
		} else if (CustomField.Type.TIME.equals(type)) {
			LocalTime time = (LocalTime)value;
			dateValue = (time != null) ? new LocalDate(1970, 1, 1).toDateTime(time, DateTimeZone.UTC) : null;
		} else if (CustomField.Type.DATE_TIME.equals(type)) {
			dateValue = (DateTime)value;
		} else if (CustomField.Type.COMBOBOX.equals(type) || CustomField.Type.COMBOBOX_DATASOURCE.equals(type)) {
			stringValue = (String)value;
		} else if (CustomField.Type.TAG.equals(type) || CustomField.Type.TAG_DATASOURCE.equals(type)) {
			stringValue = (String)value;
		} else if (CustomField.Type.CHECKBOX.equals(type)) {
			booleanValue = (Boolean)value;
		} else if (CustomField.Type.CONTACT_PICKER.equals(type)) {
			stringValue = (String)value;
		} else {
			throw new WTRuntimeException("Custom field type not supported [{}]", EnumUtils.toSerializedName(type));
		}
	}
}
