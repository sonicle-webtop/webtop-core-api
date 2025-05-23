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
package com.sonicle.webtop.core.app.sdk;

import com.sonicle.commons.flags.BitFlags;
import com.sonicle.commons.flags.BitFlagsEnum;
import com.sonicle.commons.qbuilders.nodes.AbstractNode;
import com.sonicle.commons.qbuilders.nodes.AndNode;
import com.sonicle.commons.qbuilders.nodes.ComparisonNode;
import com.sonicle.commons.qbuilders.nodes.LogicalNode;
import com.sonicle.commons.qbuilders.nodes.OrNode;
import com.sonicle.commons.qbuilders.operators.ComparisonOperator;
import com.sonicle.commons.qbuilders.visitors.AbstractVoidContextNodeVisitor;
import com.sonicle.commons.time.DateTimeUtils;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.impl.DSL;
import org.jooq.util.postgres.PostgresDSL;

/**
 * @deprecated use JOOQConditionBuildingVisitor instead
 * @author malbinola
 */
@Deprecated
public abstract class JOOQPredicateVisitor extends AbstractVoidContextNodeVisitor<Condition> {
	protected final Function<Object, Object> normalizer;
	protected boolean globalIgnoreCase = false;
	protected boolean forceStringLikeComparison = false;
	
	public JOOQPredicateVisitor() {
		this(new DefaultNormalizer());
	}
	
	public JOOQPredicateVisitor(Function<Object, Object> normalizer) {
		this.normalizer = normalizer;
	}
	
	public <T extends JOOQPredicateVisitor> T withIgnoreCase(boolean ignoreCase) {
		this.globalIgnoreCase = ignoreCase;
		return (T)this;
	}
	
	public <T extends JOOQPredicateVisitor> T withForceStringLikeComparison(boolean forceStringLikeComparison) {
		this.forceStringLikeComparison = forceStringLikeComparison;
		return (T)this;
	}
	
	abstract protected Condition toCondition(String fieldName, ComparisonOperator operator, Collection<?> values, ComparisonNode node);

	@Override
	protected Condition visit(AndNode node) {
		//Condition condition = DSL.and(conditions); in jOOQ 3.6+
		Condition result = DSL.trueCondition();
		List<Condition> conditions = node.getChildren().stream()
				.map(this::visitAny).collect(Collectors.toList());
		for (Condition condition : conditions) {
			result = result.and(condition);
		}
		return result;
	}

	@Override
	protected Condition visit(OrNode node) {
		//Condition condition = DSL.and(conditions); in jOOQ 3.6+
		Condition result = DSL.falseCondition();
		List<Condition> conditions = node.getChildren().stream()
				.map(this::visitAny).collect(Collectors.toList());
		for (Condition condition : conditions) {
			result = result.or(condition);
		}
		return result;
	}
	
	@Override
	protected Condition visit(ComparisonNode node) {
		String fieldName = node.getField().asKey();
		if (QueryBuilder.FIELD_DUMMY_TRUE.equals(fieldName)) {
			return DSL.trueCondition();
		} else {
			ComparisonOperator operator = node.getOperator();
			Collection<?> values = node.getValues().stream().map(normalizer).collect(Collectors.toList());
			return toCondition(fieldName, operator, values, node);
		}
	}
	
	protected <T> Condition defaultCondition(Field<T> field, ComparisonOperator operator, Collection<?> values) {
		return defaultCondition(field, operator, values, BitFlags.noneOf(ConditionOption.class));
	}
	
	protected <T> Condition defaultCondition(Field<T> field, boolean fieldModeArray, ComparisonOperator operator, Collection<?> values) {
		return defaultCondition(field, operator, values, fieldModeArray ? BitFlags.with(ConditionOption.STRING_FIELDMODE_ARRAY) : BitFlags.noneOf(ConditionOption.class));
	}
	
	protected <T> Condition defaultCondition(Field<T> field, ComparisonOperator operator, Collection<?> values, final BitFlags<ConditionOption> opts) {
		final boolean ignoreCase = opts.has(ConditionOption.STRING_ICASE_COMP);
		final boolean useLike = opts.has(ConditionOption.STRING_LIKE_COMP);
		// When fieldModeArray is `true`, DB field value will be a String of values separated by a colon (,).
		// In this situation, the only operators suitable are EQ and NOT EQ.
		final boolean fieldModeArray = opts.has(ConditionOption.STRING_FIELDMODE_ARRAY);
		if (fieldModeArray && (!ComparisonOperator.EQ.equals(operator) && !ComparisonOperator.NE.equals(operator))) {
			throw new UnsupportedOperationException("Operator not supported in array mode: " + operator.toString());
		}
		if (ComparisonOperator.EQ.equals(operator)) {
			if (hasStringType(field)) {
				String value = (String)single(values);
				if (fieldModeArray) {
					return DSL.value((String)value).equal(DSL.any(PostgresDSL.stringToArray((Field<String>) field, ",")));
					
				} else {
					if (forceStringLikeComparison || useLike || valueContainsWildcard(value)) {
						return (globalIgnoreCase || ignoreCase) ? field.likeIgnoreCase(valueToLikePattern(value)) : field.like(valueToLikePattern(value));
					} else if (globalIgnoreCase || ignoreCase) {
						return field.equalIgnoreCase(value);
					}
				}
			} else if (hasBooleanType(field)) {
				Boolean value = singleAsBoolean(values);
				return true == value ? field.isTrue() : field.isFalse();
			}
			return field.equal(field.getDataType().convert(single(values)));

		} else if (ComparisonOperator.NE.equals(operator)) {
			if (hasStringType(field)) {
				String value = (String)single(values);
				if (fieldModeArray) {
					return DSL.value((String)value).notEqual(DSL.all(PostgresDSL.stringToArray((Field<String>) field, ",")));
					
				} else {
					if (forceStringLikeComparison || valueContainsWildcard(value)) {
						return ignoreCase ? field.notLikeIgnoreCase(valueToLikePattern(value)) : field.notLike(valueToLikePattern(value));
					} else if (ignoreCase) {
						return field.notEqualIgnoreCase(value);
					}
				}
			} else if (hasBooleanType(field)) {
				Boolean value = singleAsBoolean(values);
				return true == value ? field.isFalse() : field.isTrue();
			}
			return field.notEqual(field.getDataType().convert(single(values)));
			
		} else if (ComparisonOperator.EX.equals(operator)) {
			throw new UnsupportedOperationException("Operator not supported: " + operator.toString());
			
		} else if (ComparisonOperator.GT.equals(operator)) {
			return field.greaterThan(field.getDataType().convert(single(values)));
			
		} else if (ComparisonOperator.LT.equals(operator)) {
			return field.lessThan(field.getDataType().convert(single(values)));
			
		} else if (ComparisonOperator.GTE.equals(operator)) {
			return field.greaterOrEqual(field.getDataType().convert(single(values)));
			
		} else if (ComparisonOperator.LTE.equals(operator)) {
			return field.lessOrEqual(field.getDataType().convert(single(values)));
		
		} else if (ComparisonOperator.BTW.equals(operator)) {
			Object[] multi = multiple(values, 2);
			return field.between(field.getDataType().convert(multi[0]), field.getDataType().convert(multi[1]));
		
		} else if (ComparisonOperator.NBTW.equals(operator)) {
			Object[] multi = multiple(values, 2);
			return field.notBetween(field.getDataType().convert(multi[0]), field.getDataType().convert(multi[1]));
		
		} else if (ComparisonOperator.IN.equals(operator)) {
			return field.in(field.getDataType().convert(values));
			
		} else if (ComparisonOperator.NIN.equals(operator)) {
			return field.notIn(field.getDataType().convert(values));
			
		} else if (ComparisonOperator.RE.equals(operator)) {
			return field.likeRegex((String)single(values));
			
		} else if (ComparisonOperator.SUB_CONDITION_ANY.equals(operator)) {
			throw new UnsupportedOperationException("Operator not supported: " + operator.toString());
			
		} else {
			throw new UnsupportedOperationException("Operator not supported: " + operator.toString());
		}
	}
	
	protected boolean hasStringType(Field<?> field) {
		return field.getType().equals(java.lang.String.class);
	}
	
	protected boolean hasBooleanType(Field<?> field) {
		return field.getType().equals(java.lang.Boolean.class);
	}
	
	protected String singleAsString(Collection<?> values) {
		return (String)single(values);
	}
	
	protected Boolean singleAsBoolean(Collection<?> values) {
		Object ovalue = single(values);
		return (ovalue instanceof String) ? Boolean.parseBoolean((String)ovalue) : (Boolean)ovalue;
	}
	
	protected String valueToLikePattern(String value) {
		value = StringUtils.replace(value, "*", "%");
		value = StringUtils.replace(value, "\\*", "*");
		return value;
	}
	
	protected boolean valueContainsWildcard(String value) {
		int escapedAsterisks = StringUtils.countMatches(value, "\\*");
		int asterisks = StringUtils.countMatches(value, "*");
		return asterisks > escapedAsterisks;
	}
	
	protected static class DefaultNormalizer implements Function<Object, Object> {

		@Override
		public Object apply(Object o) {
			if (o instanceof java.time.Instant) {
				return DateTimeUtils.toDateTime(DateTimeUtils.toZonedDateTime((java.time.Instant)o, java.time.ZoneOffset.UTC));
			}
			return o;
		}
	}
	
	public static enum ConditionOption implements BitFlagsEnum<ConditionOption> {
		STRING_ICASE_COMP(1<<0), STRING_LIKE_COMP(1<<1), STRING_FIELDMODE_ARRAY(1<<2);
		
		private int mask = 0;
		private ConditionOption(int mask) { this.mask = mask; }
		@Override
		public long mask() { return this.mask; }
	}
}
