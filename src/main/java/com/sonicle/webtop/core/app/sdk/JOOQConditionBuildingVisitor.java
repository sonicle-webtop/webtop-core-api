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

import com.sonicle.commons.flags.BitFlags;
import com.sonicle.commons.flags.BitFlagsEnum;
import com.sonicle.commons.rsql.parser.Operator;
import com.sonicle.commons.rsql.parser.ast.AndNode;
import com.sonicle.commons.rsql.parser.ast.ComparisonNode;
import com.sonicle.commons.rsql.parser.ast.LogicalNode;
import com.sonicle.commons.rsql.parser.ast.NoArgRSQLVisitorAdapter;
import com.sonicle.commons.rsql.parser.ast.Node;
import com.sonicle.commons.rsql.parser.ast.OrNode;
import com.sonicle.commons.time.DateTimeUtils;
import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;
import net.sf.qualitycheck.Check;
import org.apache.commons.lang3.StringUtils;
import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.impl.DSL;
import org.jooq.util.postgres.PostgresDSL;

/**
 *
 * @author malbinola
 */
public abstract class JOOQConditionBuildingVisitor extends NoArgRSQLVisitorAdapter<Condition> {
	protected final Function<Object, Object> normalizer;
	protected BitFlags<DefaultConditionOption> defaultConditionOpts = BitFlags.noneOf(DefaultConditionOption.class);
	
	public JOOQConditionBuildingVisitor() {
		this(new DefaultNormalizer());
	}
	
	public JOOQConditionBuildingVisitor(Function<Object, Object> normalizer) {
		this.normalizer = normalizer;
	}
	
	public <T extends JOOQConditionBuildingVisitor> T withDefaultConditionOpts(BitFlags<DefaultConditionOption> defaultConditionOpts) {
		this.defaultConditionOpts = Check.notNull(defaultConditionOpts, "defaultConditionOpts");
		return (T)this;
	}
	
	abstract protected Condition buildCondition(final String fieldName, final Operator operator, final Collection<?> values);
	/*abstract protected Condition buildCondition(final String fieldName, final Operator operator, final Collection<?> values, final ComparisonNode node);*/
	
	@Override
	public Condition visit(AndNode node) {
		return DSL.and(node.getChildren().stream().map(this::visitAny).collect(Collectors.toList()));
	}

	@Override
	public Condition visit(OrNode node) {
		return DSL.or(node.getChildren().stream().map(this::visitAny).collect(Collectors.toList()));
	}

	@Override
	public Condition visit(ComparisonNode node) {
		String fieldName = node.getSelector();
		Collection<?> values = node.getArguments().stream().map(normalizer).collect(Collectors.toList());
		return buildCondition(fieldName, Operator.toOperator(node.getOperator()), values/*, node*/);
	}
	
	private Condition visitAny(Node node) {
		// skip straight to the children if it's a logical node with one member
		if (node instanceof LogicalNode) {
			LogicalNode ln = (LogicalNode)node;
			if (ln.getChildren().size() == 1) {
				return visitAny(ln.getChildren().get(0));
			}
		}
		
		if (node instanceof AndNode) {
			return visit((AndNode)node);
		} else if (node instanceof OrNode) {
			return visit((OrNode)node);
		} else {
			return visit((ComparisonNode)node);
		}
	}
	
	protected <T> Condition defaultCondition(final Field<T> field, final Operator operator, final Collection<?> values) {
		return defaultCondition(field, operator, values, defaultConditionOpts);
	}
	
	protected <T> Condition defaultCondition(final Field<T> field, final Operator operator, final Collection<?> values, final BitFlags<DefaultConditionOption> opts) {
		if (Operator.EQ.equals(operator)) {
			if (fieldHasStringType(field)) {
				final String value = singleValueAsString(values);
				if (opts.has(DefaultConditionOption.STRING_ANYOF_COMP)) {
					return DSL.value((String)value).equal(DSL.any(PostgresDSL.stringToArray((Field<String>) field, ",")));
					
				} else {
					final boolean ignoreCase = opts.has(DefaultConditionOption.STRING_ICASE_COMP);
					if (opts.has(DefaultConditionOption.STRING_LIKE_COMP) || opts.has(DefaultConditionOption.STRING_LIKE_AUTO_COMP) && valueContainsWildcard(value)) {
						return ignoreCase ? field.likeIgnoreCase(valueToLikePattern(value)) : field.like(valueToLikePattern(value));
					
					} else if (ignoreCase) {
						return field.equalIgnoreCase(value);
					}
				}
				
			} else if (fieldHasBooleanType(field)) {
				final Boolean value = singleValueAsBoolean(values);
				return true == value ? field.isTrue() : field.isFalse();
				
			}
			return field.equal(field.getDataType().convert(singleValue(values)));
			
		} else if (Operator.NE.equals(operator)) {
			if (fieldHasStringType(field)) {
				final String value = singleValueAsString(values);
				if (opts.has(DefaultConditionOption.STRING_ANYOF_COMP)) {
					return DSL.value((String)value).notEqual(DSL.any(PostgresDSL.stringToArray((Field<String>) field, ",")));
					
				} else {
					final boolean ignoreCase = opts.has(DefaultConditionOption.STRING_ICASE_COMP);
					if (opts.has(DefaultConditionOption.STRING_LIKE_COMP) || opts.has(DefaultConditionOption.STRING_LIKE_AUTO_COMP) && valueContainsWildcard(value)) {
						return ignoreCase ? field.notLikeIgnoreCase(valueToLikePattern(value)) : field.notLike(valueToLikePattern(value));
						
					} else if (ignoreCase) {
						return field.notEqualIgnoreCase(value);
					}
				}
				
			} else if (fieldHasBooleanType(field)) {
				Boolean value = singleValueAsBoolean(values);
				return true == value ? field.isFalse() : field.isTrue();
				
			}
			return field.notEqual(field.getDataType().convert(singleValue(values)));
			
		} else if (Operator.LIKE.equals(operator)) {
			final String value = singleValueAsString(values);
			final boolean ignoreCase = opts.has(DefaultConditionOption.STRING_ICASE_COMP);
			return ignoreCase ? field.likeIgnoreCase(valueToLikePattern(value)) : field.like(valueToLikePattern(value));
			
		} else if (Operator.NLIKE.equals(operator)) {
			final String value = singleValueAsString(values);
			final boolean ignoreCase = opts.has(DefaultConditionOption.STRING_ICASE_COMP);
			return ignoreCase ? field.notLikeIgnoreCase(valueToLikePattern(value)) : field.notLike(valueToLikePattern(value));
			
		} else if (Operator.GT.equals(operator)) {
			return field.greaterThan(field.getDataType().convert(singleValue(values)));
			
		} else if (Operator.GTE.equals(operator)) {
			return field.greaterOrEqual(field.getDataType().convert(singleValue(values)));
			
		} else if (Operator.LT.equals(operator)) {
			return field.lessThan(field.getDataType().convert(singleValue(values)));
			
		} else if (Operator.LTE.equals(operator)) {
			return field.lessOrEqual(field.getDataType().convert(singleValue(values)));
			
		} else if (Operator.BTW.equals(operator)) {
			Object[] multi = multiValue(values, 2);
			return field.between(field.getDataType().convert(multi[0]), field.getDataType().convert(multi[1]));
			
		} else if (Operator.NBTW.equals(operator)) {
			Object[] multi = multiValue(values, 2);
			return field.notBetween(field.getDataType().convert(multi[0]), field.getDataType().convert(multi[1]));
			
		} else if (Operator.IN.equals(operator)) {
			return field.in(field.getDataType().convert(values));
			
		} else if (Operator.NIN.equals(operator)) {
			return field.notIn(field.getDataType().convert(values));
			
		} else if (Operator.RE.equals(operator)) {
			return field.likeRegex((String)singleValue(values));
			
		} else {
			throw new UnsupportedOperationException("Operator not supported: " + operator.toString());
		}
	}
	
	protected String singleValueAsString(Collection<?> values) {
		return (String)singleValue(values);
	}
	
	protected Boolean singleValueAsBoolean(Collection<?> values) {
		Object value = singleValue(values);
		return (value instanceof String) ? Boolean.parseBoolean((String)value) : (Boolean)value;
	}
	
	protected Object singleValue(Collection<?> values) {
		if (values != null && values.size() == 1) {
			return values.iterator().next();
		} else {
			throw new IllegalArgumentException("You must provide a non-null query value for the condition.");
		}
	}
	
	protected Object[] multiValue(Collection<?> values, int howMany) {
		if (!values.isEmpty()) {
			Object[] objects = new Object[howMany];
			int index = -1;
			for (Object value : values) {
				index++;
				if (index >= howMany) break;
				objects[index] = value;
			}
			return objects;
		} else {
			throw new IllegalArgumentException("You must provide a non-null query value for the condition.");
		}
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
	
	protected boolean fieldHasStringType(Field<?> field) {
		return field.getType().equals(java.lang.String.class);
	}
	
	protected boolean fieldHasBooleanType(Field<?> field) {
		return field.getType().equals(java.lang.Boolean.class);
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
	
	public static enum DefaultConditionOption implements BitFlagsEnum<DefaultConditionOption> {
		STRING_ICASE_COMP(1<<0), STRING_LIKE_COMP(1<<1), STRING_LIKE_AUTO_COMP(1<<2), STRING_ANYOF_COMP(1<<3);
		
		private int mask = 0;
		private DefaultConditionOption(int mask) { this.mask = mask; }
		@Override
		public long mask() { return this.mask; }
	}
}
