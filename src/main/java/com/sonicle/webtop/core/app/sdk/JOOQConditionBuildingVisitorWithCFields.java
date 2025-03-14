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
import com.sonicle.commons.flags.BitFlags;
import com.sonicle.commons.rsql.parser.Operator;
import com.sonicle.commons.web.json.CId;
import static com.sonicle.webtop.core.jooq.core.Tables.CUSTOM_FIELDS;
import static com.sonicle.webtop.core.jooq.core.Tables.CUSTOM_PANELS_FIELDS;
import static com.sonicle.webtop.core.jooq.core.Tables.CUSTOM_PANELS_TAGS;
import com.sonicle.webtop.core.jooq.core.tables.CustomFields;
import com.sonicle.webtop.core.jooq.core.tables.CustomPanelsFields;
import com.sonicle.webtop.core.jooq.core.tables.CustomPanelsTags;
import com.sonicle.webtop.core.model.CustomField;
import com.sonicle.webtop.core.model.CustomFieldBase;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.TableLike;
import org.jooq.impl.DSL;
import static org.jooq.impl.DSL.exists;
import static org.jooq.impl.DSL.selectOne;

/**
 *
 * @author malbinola
 */
public abstract class JOOQConditionBuildingVisitorWithCFields extends JOOQConditionBuildingVisitor {
	protected final boolean negatedEqualityIsStrict;
	private FieldNameMode fieldNameMode = null;
	private Map<String, String> customFieldsNameToIDMapping = null;
	private Map<String, CustomField.Type> customFieldsIDToTypeMapping = null;
	
	public JOOQConditionBuildingVisitorWithCFields(boolean negatedEqualityIsStrict) {
		this.negatedEqualityIsStrict = negatedEqualityIsStrict;
	}
	
	public <T extends JOOQConditionBuildingVisitorWithCFields> T withFieldNameAsCustomFieldID(Map<String, CustomField.Type> customFieldsIDToTypeMapping) {
		this.fieldNameMode = FieldNameMode.FIELDNAME_AS_CF_ID;
		this.customFieldsIDToTypeMapping = customFieldsIDToTypeMapping;
		return (T)this;
	}
	
	public <T extends JOOQConditionBuildingVisitorWithCFields> T withFieldNameAsCustomFieldName(Map<String, String> customFieldsNameToIDMapping) {
		return (T)withFieldNameAsCustomFieldName(customFieldsNameToIDMapping, null);
	}
	
	public <T extends JOOQConditionBuildingVisitorWithCFields> T withFieldNameAsCustomFieldName(Map<String, String> customFieldsNameToIDMapping, Map<String, CustomField.Type> customFieldsIDToTypeMapping) {
		this.fieldNameMode = FieldNameMode.FIELDNAME_AS_CF_NAME;
		this.customFieldsNameToIDMapping = customFieldsNameToIDMapping;
		this.customFieldsIDToTypeMapping = customFieldsIDToTypeMapping;
		return (T)this;
	}
	
	abstract protected Field<?> getFieldEntityIdOfEntityTable();
	abstract protected TableLike<?> getTableTags();
	abstract protected Field<String> getFieldTagIdOfTableTags();
	abstract protected Condition getConditionTagsForCurrentEntity();
	abstract protected TableLike<?> getTableCustomValues();
	abstract protected Condition getConditionCustomValuesForCurrentEntityAndField(final String fieldId);
	abstract protected Field<?> getTableCustomValuesTypeTableField(final CustomFieldBase.RawValueType cvalueType);
	
	public FieldNameMode getFieldNameMode() {
		return this.fieldNameMode;
	}
	
	protected String lookupCustomFieldID(final String fieldName) {
		if (FieldNameMode.FIELDNAME_AS_CF_ID.equals(fieldNameMode)) {
			return fieldName;
		} else if (FieldNameMode.FIELDNAME_AS_CF_NAME.equals(fieldNameMode)) {
			return customFieldsNameToIDMapping.getOrDefault(fieldName, null);
		} else {
			throw new UnsupportedOperationException("Invalid configuration: please choose between withFieldNameAsCustomFieldID or withCustomFieldTypeMapping");
		}
	}
	
	protected CustomField.Type lookupCustomFieldType(final String customFieldId) {
		return customFieldsIDToTypeMapping != null ? customFieldsIDToTypeMapping.getOrDefault(customFieldId, null) : null;
	}
	
	protected Condition evalFieldNameAndGenerateCFieldCondition(final String fieldName, final Operator operator, final Collection<?> values) {
		CId parsedFieldName = parseCFieldFieldName(fieldName);
		if (CFIELD_PLAIN_PREFIX.equals(parsedFieldName.getToken(0))) { // Plain form "CF:<field-name>" -> type lookup required
			if (parsedFieldName.isTokenEmpty(1)) throw new UnsupportedOperationException("Field name missing: " + fieldName);
			String customFieldId = lookupCustomFieldID(parsedFieldName.getToken(1));
			
			CustomField.Type fieldType = lookupCustomFieldType(customFieldId);
			if (fieldType == null) throw new UnsupportedOperationException("Field type unknown: " + fieldName);
			CustomFieldBase.RawValueType valueType = CustomFieldBase.toRawValueType(fieldType);
			if (valueType == null) throw new UnsupportedOperationException("Field value-type invalid: " + fieldName);
			return generateCValueCondition(customFieldId, valueType, operator, values);
			
		} else { // Typed form "<field-name>:CVSTRING" -> no type lookup required
			if (parsedFieldName.isTokenEmpty(0)) throw new UnsupportedOperationException("Field name missing: " + fieldName);
			if (parsedFieldName.isTokenEmpty(1)) throw new UnsupportedOperationException("Field value-type missing: " + fieldName);
			String customFieldId = lookupCustomFieldID(parsedFieldName.getToken(0));
			
			CustomFieldBase.RawValueType valueType = EnumUtils.forName(parsedFieldName.getToken(1), CustomFieldBase.RawValueType.class);
			if (valueType == null) throw new UnsupportedOperationException("Field value-type invalid: " + fieldName);
			return generateCValueCondition(customFieldId, valueType, operator, values);
		}
	}
	
	protected Condition generateCValueCondition(final String customFieldId, final CustomFieldBase.RawValueType customFieldValueType, final Operator operator, final Collection<?> values) {
		CustomFields PV_CUSTOM_FIELDS = CUSTOM_FIELDS.as("pvis_cf");
		CustomPanelsFields PV_CUSTOM_PANELS_FIELDS = CUSTOM_PANELS_FIELDS.as("pvis_cpf");
		CustomPanelsTags PV_CUSTOM_PANELS_TAGS = CUSTOM_PANELS_TAGS.as("pvis_cpt");
		
		Condition cfieldExistenceCond = exists(
			selectOne()
			.from(PV_CUSTOM_FIELDS)
			// Join below ensures that custom-field is not in D (deleted) 
			// state: association between fields/panels is removed when a 
			// field is deleted.
			.join(PV_CUSTOM_PANELS_FIELDS).on(PV_CUSTOM_FIELDS.CUSTOM_FIELD_ID.eq(PV_CUSTOM_PANELS_FIELDS.CUSTOM_FIELD_ID))
			// Two joins below ensures that the custom-field is really 
			// assigned to the current entity. Join can be null whether the 
			// field is associated to a global panel. (see where)
			.leftOuterJoin(PV_CUSTOM_PANELS_TAGS).on(PV_CUSTOM_PANELS_FIELDS.CUSTOM_PANEL_ID.eq(PV_CUSTOM_PANELS_TAGS.CUSTOM_PANEL_ID))
			.leftOuterJoin(getTableTags()).on(PV_CUSTOM_PANELS_TAGS.TAG_ID.eq(getFieldTagIdOfTableTags()))
			.where(
				PV_CUSTOM_FIELDS.CUSTOM_FIELD_ID.eq(customFieldId)
				.and(
					// When customPanelId is null we have a field associated 
					// to a global panel, and so is enought. Otherwise a match 
					// needs to be found in OR clause.
					PV_CUSTOM_PANELS_TAGS.CUSTOM_PANEL_ID.isNull()
					.or(getConditionTagsForCurrentEntity())
				)
			)
		);
		
		boolean valueNotExists = false; // True if returned condition must be treated as negated (not exist).
		Condition cvalueCond = null;
		if (!negatedEqualityIsStrict) {
			
			// Boolean values needs to be adjusted in order to give correct results:
			// Operators and boolean values can be combined in four ways:
			//   |original|  |adjusted                 |
			//   |op|value|  |op|value|negate-condition|
			// 1) EQ true  -> EQ true  no
			// 2) EQ false -> EQ true  yes
			// 3) NE true  -> EQ true  yes (already excluded by query logic)
			// 4) NE false -> EQ true  no (already excluded by query logic)
			
			if (CustomFieldBase.RawValueType.CVBOOL.equals(customFieldValueType)) {
				valueNotExists = (false == singleValueAsBoolean(values));
				cvalueCond = defaultCustomFieldValueCondition(customFieldValueType, Operator.EQ, Arrays.asList(true));
				
			} else {
				Operator sop = toStraightOperator(operator);
				valueNotExists = !operator.equals(sop);
				cvalueCond = defaultCustomFieldValueCondition(customFieldValueType, sop, values);
			}
		} else {
			cvalueCond = defaultCustomFieldValueCondition(customFieldValueType, operator, values);
		}
		if (cvalueCond == null) throw new UnsupportedOperationException("Custom value not supported: " + EnumUtils.getName(customFieldValueType));
		
		if (valueNotExists) {
			return cfieldExistenceCond
				.andNotExists(
					selectOne()
					.from(getTableCustomValues())
					.where(
						getConditionCustomValuesForCurrentEntityAndField(customFieldId)
						.and(cvalueCond)
					)
				);

		} else {
			return cfieldExistenceCond
				.andExists(
					selectOne()
					.from(getTableCustomValues())
					.where(
						getConditionCustomValuesForCurrentEntityAndField(customFieldId)
						.and(cvalueCond)
					)
			);
		}
	}
	
	protected Condition defaultCustomFieldValueCondition(final CustomFieldBase.RawValueType cvalueType, final Operator operator, final Collection<?> values) {
		Field<?> valueTypeField = getTableCustomValuesTypeTableField(cvalueType);
		if (valueTypeField != null) {
			if (CustomFieldBase.RawValueType.CVSTRING.equals(cvalueType)) {
				return defaultCondition(valueTypeField, operator, values);

			} else if (CustomFieldBase.RawValueType.CVSTRINGARRAY.equals(cvalueType)) {
				return defaultCondition(valueTypeField, operator, values, BitFlags.with(DefaultConditionOption.STRING_ANYOF_COMP));

			} else if (CustomFieldBase.RawValueType.CVNUMBER.equals(cvalueType)) {
				return defaultCondition(valueTypeField, operator, values);

			} else if (CustomFieldBase.RawValueType.CVBOOL.equals(cvalueType)) {
				return defaultCondition(valueTypeField, operator, values);

			} else if (CustomFieldBase.RawValueType.CVDATE.equals(cvalueType)) {
				return defaultCondition(valueTypeField, operator, values);

			} else if (CustomFieldBase.RawValueType.CVTEXT.equals(cvalueType)) {
				return defaultCondition(valueTypeField, operator, values);

			}
		}
		return DSL.trueCondition();
	}
	
	protected Operator toStraightOperator(Operator operator) {
		if (Operator.NE.equals(operator)) {
			return Operator.EQ;
		} else if (Operator.NIN.equals(operator)) {
			return Operator.IN;
		}
		return operator;
	}
	
	protected boolean isCFieldPlainNotation(String fieldName) {
		return StringUtils.startsWith(fieldName, CFIELD_PLAIN_PREFIX+":");
	}
	
	protected boolean isCFieldWithRawValueTypeNotation(String fieldName) {
		return StringUtils.endsWith(fieldName, ":"+EnumUtils.getName(CustomFieldBase.RawValueType.CVSTRING))
			|| StringUtils.endsWith(fieldName, ":"+EnumUtils.getName(CustomFieldBase.RawValueType.CVSTRINGARRAY))
			|| StringUtils.endsWith(fieldName, ":"+EnumUtils.getName(CustomFieldBase.RawValueType.CVNUMBER))
			|| StringUtils.endsWith(fieldName, ":"+EnumUtils.getName(CustomFieldBase.RawValueType.CVBOOL))
			|| StringUtils.endsWith(fieldName, ":"+EnumUtils.getName(CustomFieldBase.RawValueType.CVDATE))
			|| StringUtils.endsWith(fieldName, ":"+EnumUtils.getName(CustomFieldBase.RawValueType.CVTEXT));
	}
	
	protected CId parseCFieldFieldName(String fieldName) {
		return new CId(":", fieldName, 2);
	}
	
	public static final String CFIELD_PLAIN_PREFIX = "CF";
	
	public static enum FieldNameMode {
		FIELDNAME_AS_CF_ID, FIELDNAME_AS_CF_NAME
	}
}
