/*
 * Copyright (C) 2025 Sonicle S.r.l.
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
 * display the words "Copyright (C) 2025 Sonicle S.r.l.".
 */
package com.sonicle.webtop.core.model;

import com.google.gson.annotations.SerializedName;
import com.sonicle.commons.EnumUtils;
import com.sonicle.commons.LangUtils;
import com.sonicle.commons.time.JodaTimeUtils;
import net.sf.qualitycheck.Check;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.DateTime;

/**
 *
 * @author malbinola
 */
public class CustomFieldValueCandidate {
	private final String fieldId;
	private final ValueType valueType;
	protected String stringValue;
	protected Double numberValue;
	protected Boolean booleanValue;
	protected DateTime dateValue;
	protected String textValue;
	
	public CustomFieldValueCandidate(final String fieldId, final String valueType, final String value) {
		this.fieldId = Check.notEmpty(fieldId, "fieldId");
		this.valueType = Check.notNull(EnumUtils.forSerializedName(valueType, ValueType.class), valueType);
		
		if (ValueType.STRING.equals(this.valueType)) {
			this.stringValue = LangUtils.value(value, (String)null);
		} else if (ValueType.NUMBER.equals(this.valueType)) {
			this.numberValue = LangUtils.value(value, (Double)null);
		} else if (ValueType.BOOLEAN.equals(this.valueType)) {
			this.booleanValue = LangUtils.value(value, (Boolean)null);
		} else if (ValueType.DATE.equals(this.valueType)) {
			this.dateValue = JodaTimeUtils.parseDateTimeISO(value);
		} else if (ValueType.TEXT.equals(this.valueType)) {
			this.textValue = LangUtils.value(value, (String)null);
		}
	}
	
	public String getFieldId() {
		return this.fieldId;
	}
	
	public ValueType getValueType() {
		return this.valueType;
	}

	public String getStringValue() {
		return stringValue;
	}

	public Double getNumberValue() {
		return numberValue;
	}

	public Boolean getBooleanValue() {
		return booleanValue;
	}

	public DateTime getDateValue() {
		return dateValue;
	}

	public String getTextValue() {
		return textValue;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
			.append(this.fieldId)
			.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CustomFieldValueCandidate == false) return false;
		if (this == obj) return true;
		final CustomFieldValueCandidate otherObject = (CustomFieldValueCandidate)obj;
		return new EqualsBuilder()
			.append(this.fieldId, otherObject.fieldId)
			.isEquals();
	}
	
	public static enum ValueType {
		@SerializedName("string") STRING,
		@SerializedName("number") NUMBER,
		@SerializedName("boolean") BOOLEAN,
		@SerializedName("date") DATE,
		@SerializedName("text") TEXT;
	}
}
