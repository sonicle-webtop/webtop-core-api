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
package com.sonicle.webtop.core.app.sdk;

import com.sonicle.commons.EnumUtils;
import com.sonicle.commons.qbuilders.conditions.Condition;
import com.sonicle.commons.qbuilders.properties.concrete.BooleanProperty;
import com.sonicle.commons.qbuilders.properties.concrete.DoubleProperty;
import com.sonicle.commons.qbuilders.properties.concrete.InstantProperty;
import com.sonicle.commons.qbuilders.properties.concrete.StringProperty;
import com.sonicle.commons.web.json.CId;
import static com.sonicle.webtop.core.app.sdk.QueryBuilder.asStringValue;
import static com.sonicle.webtop.core.app.sdk.QueryBuilder.splitOperator;
import com.sonicle.webtop.core.model.CustomField;
import com.sonicle.webtop.core.model.CustomFieldBase;
import net.sf.qualitycheck.Check;
import org.joda.time.DateTimeZone;

/**
 *
 * @author malbinola
 * @param <T>
 */
public class QueryBuilderWithCFields<T extends QueryBuilder<T>> extends QueryBuilder<T> {
	
	protected StringProperty<T> customValueString(final String fieldId) {
		return string(CId.build(EnumUtils.getName(CustomFieldBase.RawValueType.CVSTRING), fieldId).toString());
	}
	
	protected StringProperty<T> customValueStringArray(final String fieldId) {
		return string(CId.build(EnumUtils.getName(CustomFieldBase.RawValueType.CVSTRINGARRAY), fieldId).toString());
	}
	
	protected DoubleProperty<T> customValueNumber(final String fieldId) {
		return doubleNum(CId.build(EnumUtils.getName(CustomFieldBase.RawValueType.CVNUMBER), fieldId).toString());
	}
	
	protected BooleanProperty<T> customValueBoolean(final String fieldId) {
		return bool(CId.build(EnumUtils.getName(CustomFieldBase.RawValueType.CVBOOL), fieldId).toString());
	}
	
	protected InstantProperty<T> customValueDate(final String fieldId) {
		return instant(CId.build(EnumUtils.getName(CustomFieldBase.RawValueType.CVDATE), fieldId).toString());
	}
	
	protected StringProperty<T> customValueText(final String fieldId) {
		return string(CId.build(EnumUtils.getName(CustomFieldBase.RawValueType.CVTEXT), fieldId).toString());
	}
	
	protected Condition<T> customFieldCondition(final String customFieldId, final CustomField.Type customFieldType, final String value, final boolean negated, final boolean smartStringComparison, final DateTimeZone timezone) {
		if (CustomField.Type.TEXT.equals(customFieldType)) {
			return condition(customValueString(customFieldId), asStringValue(value, smartStringComparison), negated);
			
		} else if (CustomField.Type.TEXTAREA.equals(customFieldType)) {
			return condition(customValueText(customFieldId), asStringValue(value, smartStringComparison), negated);
		
		} else if (CustomField.Type.NUMBER.equals(customFieldType)) {
			return condition(customValueNumber(customFieldId), splitOperator(value), negated);
			
		} else if (CustomField.Type.DATE.equals(customFieldType)) {
			return condition(customValueDate(customFieldId), InstantType.DATE, DateTimeZone.UTC, splitOperator(value), negated);
			
		} else if (CustomField.Type.TIME.equals(customFieldType)) {
			return condition(customValueDate(customFieldId), InstantType.TIME, DateTimeZone.UTC, splitOperator(value), negated);
			
		} else if (CustomField.Type.DATE_TIME.equals(customFieldType)) {
			return condition(customValueDate(customFieldId), InstantType.DATE_TIME, DateTimeZone.UTC, splitOperator(value), negated);
			
		} else if (CustomField.Type.CHECKBOX.equals(customFieldType)) {
			return condition(customValueBoolean(customFieldId), value, negated);
		
		} else if (CustomField.Type.COMBOBOX.equals(customFieldType) || CustomField.Type.COMBOBOX_DATASOURCE.equals(customFieldType)) {
			return condition(customValueString(customFieldId), value, negated);
			
		} else if (CustomField.Type.TAG.equals(customFieldType) || CustomField.Type.TAG_DATASOURCE.equals(customFieldType)) {
			return condition(customValueStringArray(customFieldId), value, negated);
			
		} else if (CustomField.Type.CONTACT_PICKER.equals(customFieldType)) {
			return condition(customValueString(customFieldId), value, negated);
			
		} else {
			throw new UnsupportedOperationException("CustomField type not supported: " + customFieldType);
		}
	}
	
	public static final class StringCField extends CField {
		public StringCField(String id) {
			super(id, CustomFieldBase.RawValueType.CVSTRING);
		}
	}
	
	public static final class StringArrayCField extends CField {
		public StringArrayCField(String id) {
			super(id, CustomFieldBase.RawValueType.CVSTRING);
		}
	}
	
	public static final class NumberCField extends CField {
		public NumberCField(String id) {
			super(id, CustomFieldBase.RawValueType.CVNUMBER);
		}
	}
	
	public static final class BoolCField extends CField {
		public BoolCField(String id) {
			super(id, CustomFieldBase.RawValueType.CVBOOL);
		}
	}
	
	public static final class DateCField extends CField {
		public DateCField(String id) {
			super(id, CustomFieldBase.RawValueType.CVDATE);
		}
	}
	
	public static final class TextCField extends CField {
		public TextCField(String id) {
			super(id, CustomFieldBase.RawValueType.CVTEXT);
		}
	}
	
	public static abstract class CField {
		private final String id;
		private final CustomFieldBase.RawValueType valueType;
		
		public CField(String id, CustomFieldBase.RawValueType valueType) {
			this.id = Check.notNull(id, "id");
			this.valueType = Check.notNull(valueType, "valueType");
		}
		
		public String getId() {
			return id;
		}
		
		public CustomFieldBase.RawValueType getValueType() {
			return valueType;
		}
		
		public String buildName() {
			return CId.build(EnumUtils.getName(getValueType()), getId()).toString();
		}
	}
}
