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

import com.sonicle.commons.qbuilders.builders.QBuilder;
import com.sonicle.commons.qbuilders.conditions.Condition;
import com.sonicle.commons.qbuilders.properties.concrete.BooleanProperty;
import com.sonicle.commons.qbuilders.properties.concrete.DoubleProperty;
import com.sonicle.commons.qbuilders.properties.concrete.InstantProperty;
import com.sonicle.commons.qbuilders.properties.concrete.StringProperty;
import com.sonicle.commons.time.DateTimeUtils;
import java.time.Instant;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTimeZone;

/**
 *
 * @author malbinola
 * @param <T>
 */
public class QueryBuilder<T extends QBuilder<T>> extends QBuilder<T> {
	public static final String FIELD_DUMMY_TRUE = "DUMMY_TRUE";
	
	public Condition<T> trueCondition() {
		return string(FIELD_DUMMY_TRUE).eq(FIELD_DUMMY_TRUE);
	}
	
	public Condition<T> condition(final StringProperty<T> property, final String value, final boolean negated) {
		if (negated) {
			return property.ne(value);
		} else {
			return property.eq(value);
		}
	}
	
	public Condition<T> condition(final DoubleProperty<T> property, final ValueWithOperator valueWithOperator, final boolean negated) {
		Double double1 = Double.valueOf(valueWithOperator.value1);
		if (ValueOperator.BETWEEN.equals(valueWithOperator.operator)) {
			Double double2 = Double.valueOf(valueWithOperator.value2);
			if (negated) {
				return property.nbtw(double1, double2);
			} else {
				return property.btw(double1, double2);
			}
			
		} else if (ValueOperator.GT.equals(valueWithOperator.operator)) {
			return negated ? property.lte(double1) : property.gt(double1);

		} else if (ValueOperator.GTE.equals(valueWithOperator.operator)) {
			return negated ? property.lt(double1) : property.gte(double1);

		} else if (ValueOperator.LT.equals(valueWithOperator.operator)) {
			return negated ? property.gte(double1) : property.lt(double1);

		} else if (ValueOperator.LTE.equals(valueWithOperator.operator)) {
			return negated ? property.gt(double1) : property.lte(double1);
			
		} else {
			return negated ? property.ne(double1) : property.eq(double1);
		}
	}
	
	public Condition<T> condition(final BooleanProperty<T> property, final String value, final boolean negated) {
		Boolean boolValue = Boolean.parseBoolean(value);
		if (negated ? !boolValue : boolValue) {
			return property.isTrue();
		} else {
			return property.isFalse();
		}
	}
	
	public Condition<T> condition(final InstantProperty<T> property, final InstantType type, final DateTimeZone timezone, final ValueWithOperator valueWithOperator, boolean negated) {
		Instant instant1 = asInstantValue(valueWithOperator.value1, type, timezone);
		if (ValueOperator.BETWEEN.equals(valueWithOperator.operator)) {
			Instant instant2 = asInstantValue(valueWithOperator.value2, type, timezone);
			if (negated) {
				return property.nbtw(instant1, instant2);
			} else {
				return property.btw(instant1, instant2);
			}
			
		} else if (ValueOperator.GT.equals(valueWithOperator.operator)) {
			return negated ? property.before(instant1, false) : property.after(instant1, true);

		} else if (ValueOperator.GTE.equals(valueWithOperator.operator)) {
			return negated ? property.before(instant1, true) : property.after(instant1, false);

		} else if (ValueOperator.LT.equals(valueWithOperator.operator)) {
			return negated ? property.after(instant1, false) : property.before(instant1, true);

		} else if (ValueOperator.LTE.equals(valueWithOperator.operator)) {
			return negated ? property.after(instant1, true) : property.before(instant1, false);
			
		} else {
			return negated ? property.ne(instant1) : property.eq(instant1);
		}
	}
	
	protected static String asStringValue(final String value, final boolean stringSmartComparison) {
		return stringSmartComparison ? buildSmartValue(value) : value;
	}
	
	protected static Instant asInstantValue(final String value, final InstantType type, final DateTimeZone timezone) {
		if (InstantType.DATE.equals(type)) {
			return DateTimeUtils.toInstant(DateTimeUtils.parseLocalDate(value), DateTimeUtils.toZoneId(timezone));
		} else if (InstantType.TIME.equals(type)) {
			return DateTimeUtils.toInstant(DateTimeUtils.parseLocalTime(value), DateTimeUtils.toZoneId(timezone));
		} else {
			return DateTimeUtils.toInstant(DateTimeUtils.parseDateTime(value, DateTimeUtils.toZoneId(timezone)));
		}
	}
	
	/**
	 * Transform passed String value in a wildcard form only if there aren't any
	 * previous '*' chars in text, in order to not alterate attended behavoiur.
	 * @param value
	 * @return 
	 */
	protected static String buildSmartValue(final String value) {
		if (valueContainsWildcard(value)) {
			return value;
		} else {
			return "*" + value + "*";
		}
	}
	
	/**
	 * Checks if query value uses wildcards chars.
	 * @param value
	 * @return 
	 */
	protected static boolean valueContainsWildcard(final String value) {
		int escapedAsterisks = StringUtils.countMatches(value, "\\*");
		int asterisks = StringUtils.countMatches(value, "*");
		return asterisks > escapedAsterisks;
	}
	
	protected static ValueWithOperator splitOperator(final String value) {
		String trimmedValue = StringUtils.trim(value);
		String substr = null;
		
		substr = StringUtils.substringAfter(trimmedValue, ">=");
		if (!StringUtils.isBlank(substr)) {
			return new ValueWithOperator(ValueOperator.GTE, StringUtils.trim(substr));
		}
		
		substr = StringUtils.substringAfter(trimmedValue, "<=");
		if (!StringUtils.isBlank(substr)) {
			return new ValueWithOperator(ValueOperator.LTE, StringUtils.trim(substr));
		}
		
		String[] tokens = StringUtils.split(trimmedValue, "<>", 2);
		if (tokens.length == 2) {
			return new ValueWithOperator(ValueOperator.BETWEEN, StringUtils.trim(tokens[0]), StringUtils.trim(tokens[1]));
		}
		
		substr = StringUtils.substringAfter(trimmedValue, ">");
		if (!StringUtils.isBlank(substr)) {
			return new ValueWithOperator(ValueOperator.GT, StringUtils.trim(substr));
		}
		
		substr = StringUtils.substringAfter(trimmedValue, "<");
		if (!StringUtils.isBlank(substr)) {
			return new ValueWithOperator(ValueOperator.LT, StringUtils.trim(substr));
		}
		
		return new ValueWithOperator(null, value);
	}
	
	protected static class ValueWithOperator {
		public final ValueOperator operator;
		public final String value1;
		public final String value2;
		
		public ValueWithOperator(ValueOperator operator, String value1) {
			this(operator, value1, null);
		}
		
		public ValueWithOperator(ValueOperator operator, String value1, String value2) {
			this.operator = operator;
			this.value1 = value1;
			this.value2 = value2;
		}
	}
	
	public static enum InstantType {
		DATE, TIME, DATE_TIME
	}
	
	public static enum ValueOperator {
		GT, GTE, LT, LTE, BETWEEN
	}
}
