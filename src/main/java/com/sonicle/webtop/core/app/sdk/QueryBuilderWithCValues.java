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

import com.sonicle.commons.qbuilders.conditions.Condition;
import com.sonicle.commons.qbuilders.properties.concrete.BooleanProperty;
import com.sonicle.commons.qbuilders.properties.concrete.DoubleProperty;
import com.sonicle.commons.qbuilders.properties.concrete.InstantProperty;
import com.sonicle.commons.qbuilders.properties.concrete.StringProperty;
import com.sonicle.commons.EnumUtils;
import com.sonicle.commons.web.json.CompId;
import com.sonicle.webtop.core.model.CustomField;
import org.joda.time.DateTimeZone;

/**
 *
 * @author malbinola
 * @param <T>
 */
public abstract class QueryBuilderWithCValues<T extends QueryBuilder<T>> extends QueryBuilder<T> {
	
	public static enum Type {
		CVSTRING, CVNUMBER, CVBOOL, CVDATE, CVTEXT
	}
	
	public StringProperty<T> customValueString(final String fieldId) {
		return string(new CompId(EnumUtils.getName(Type.CVSTRING), fieldId).toString());
	}
	
	public DoubleProperty<T> customValueNumber(final String fieldId) {
		return doubleNum(new CompId(EnumUtils.getName(Type.CVNUMBER), fieldId).toString());
	}
	
	public BooleanProperty<T> customValueBoolean(final String fieldId) {
		return bool(new CompId(EnumUtils.getName(Type.CVBOOL), fieldId).toString());
	}
	
	public InstantProperty<T> customValueDate(final String fieldId) {
		return instant(new CompId(EnumUtils.getName(Type.CVDATE), fieldId).toString());
	}
	
	public StringProperty<T> customValueText(final String fieldId) {
		return string(new CompId(EnumUtils.getName(Type.CVTEXT), fieldId).toString());
	}
	
	protected Condition<T> customValueCondition(final String customFieldId, final CustomField.Type customFieldType, final String value, final boolean negated, final boolean smartStringComparison, final DateTimeZone timezone) {
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
		
		} else if (CustomField.Type.COMBOBOX.equals(customFieldType)) {
			return condition(customValueString(customFieldId), value, negated);
			
		} else {
			throw new UnsupportedOperationException("CustomField type not supported: " + customFieldType);
		}
	}
}
