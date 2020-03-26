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
package com.sonicle.webtop.core.app.sdk;

import com.github.rutledgepaulv.qbuilders.builders.QBuilder;
import com.github.rutledgepaulv.qbuilders.conditions.Condition;
import com.github.rutledgepaulv.qbuilders.properties.concrete.BooleanProperty;
import com.github.rutledgepaulv.qbuilders.properties.concrete.DoubleProperty;
import com.github.rutledgepaulv.qbuilders.properties.concrete.InstantProperty;
import com.github.rutledgepaulv.qbuilders.properties.concrete.StringProperty;
import com.sonicle.commons.EnumUtils;
import com.sonicle.commons.time.DateTimeUtils;
import com.sonicle.commons.web.json.CompId;
import com.sonicle.webtop.core.model.CustomField;
import java.time.Instant;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTimeZone;

/**
 *
 * @author malbinola
 * @param <T>
 */
public abstract class QBuilderWithCValues<T extends QBuilder<T>> extends QBuilder<T> {
	
	public static enum Type {
		CVSTRING, CVNUMBER, CVBOOL, CVDATE, CVTEXT
	}
	
	public StringProperty<T> customValueString(String fieldId) {
		return string(new CompId(EnumUtils.getName(Type.CVSTRING), fieldId).toString());
	}
	
	public DoubleProperty<T> customValueNumber(String fieldId) {
		return doubleNum(new CompId(EnumUtils.getName(Type.CVNUMBER), fieldId).toString());
	}
	
	public BooleanProperty<T> customValueBoolean(String fieldId) {
		return bool(new CompId(EnumUtils.getName(Type.CVBOOL), fieldId).toString());
	}
	
	public InstantProperty<T> customValueDate(String fieldId) {
		return instant(new CompId(EnumUtils.getName(Type.CVDATE), fieldId).toString());
	}
	
	public StringProperty<T> customValueText(String fieldId) {
		return string(new CompId(EnumUtils.getName(Type.CVTEXT), fieldId).toString());
	}
	
	protected Condition<T> customValueCondition(String customFieldId, CustomField.Type customFieldType, String value, boolean negated, DateTimeZone timezone) {
		if (CustomField.Type.TEXT.equals(customFieldType) || CustomField.Type.COMBOBOX.equals(customFieldType)) {
			if (negated) {
				return customValueString(customFieldId).ne(value);
			} else {
				return customValueString(customFieldId).eq(value);
			}
			
		} else if (CustomField.Type.NUMBER.equals(customFieldType)) {
			if (negated) {
				return customValueNumber(customFieldId).ne(Double.valueOf(value));
			} else {
				return customValueNumber(customFieldId).eq(Double.valueOf(value));
			}
			
		} else if (CustomField.Type.CHECKBOX.equals(customFieldType)) {
			Boolean bool = Boolean.parseBoolean(value);
			if (negated ? !bool : bool) {
				return customValueBoolean(customFieldId).isTrue();
			} else {
				return customValueBoolean(customFieldId).isFalse();
			}
		
		} else if (CustomField.Type.DATE.equals(customFieldType)) {
			String date = StringUtils.replace(value, "/", "-");
			Instant instant = DateTimeUtils.toInstant(DateTimeUtils.parseLocalDate(date), DateTimeUtils.toZoneId(DateTimeZone.UTC));
			if (negated) {
				return customValueDate(customFieldId).ne(instant);
			} else {
				return customValueDate(customFieldId).eq(instant);
			}
			
		} else if (CustomField.Type.TIME.equals(customFieldType)) {
			Instant instant = DateTimeUtils.toInstant(DateTimeUtils.parseLocalTime(value), DateTimeUtils.toZoneId(DateTimeZone.UTC));
			if (negated) {
				return customValueDate(customFieldId).ne(instant);
			} else {
				return customValueDate(customFieldId).eq(instant);
			}
			
		} else if (CustomField.Type.DATE_TIME.equals(customFieldType)) {
			String datetime = StringUtils.replace(value, "/", "-");
			datetime = StringUtils.replace(datetime, " " , "T");
			Instant instant = DateTimeUtils.toInstant(DateTimeUtils.parseDateTime(datetime, DateTimeUtils.toZoneId(timezone)));
			if (negated) {
				return customValueDate(customFieldId).ne(instant);
			} else {
				return customValueDate(customFieldId).eq(instant);
			}
			
		} else if (CustomField.Type.TEXTAREA.equals(customFieldType)) {
			if (negated) {
				return customValueText(customFieldId).ne(value);
			} else {
				return customValueText(customFieldId).eq(value);
			}
			
		} else {
			return null;
		}
	}
}
