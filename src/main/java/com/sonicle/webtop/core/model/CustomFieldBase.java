/*
 * Copyright (C) 2022 Sonicle S.r.l.
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
 * display the words "Copyright (C) 2022 Sonicle S.r.l.".
 */
package com.sonicle.webtop.core.model;

import com.google.gson.annotations.SerializedName;
import com.sonicle.commons.EnumUtils;
import com.sonicle.commons.web.json.JsonResult;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

/**
 *
 * @author malbinola
 */
public class CustomFieldBase {
	protected RevisionStatus revisionStatus;
	protected DateTime revisionTimestamp;
	protected DateTime creationTimestamp;
	protected String name;
	protected String description;
	//TODO: Type class is used in many projects so we leave there for now. When branch is fully merged move definition here in CustomFieldBase!
	protected CustomField.Type type;
	protected Boolean searchable;
	protected Boolean previewable;
	protected Props props;
	protected Values values;
	protected LabelI18n labelI18n;
	protected String queryId;
	
	public RevisionStatus getRevisionStatus() {
		return revisionStatus;
	}

	public void setRevisionStatus(RevisionStatus revisionStatus) {
		this.revisionStatus = revisionStatus;
	}

	public DateTime getRevisionTimestamp() {
		return revisionTimestamp;
	}

	public void setRevisionTimestamp(DateTime revisionTimestamp) {
		this.revisionTimestamp = revisionTimestamp;
	}
	
	public DateTime getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(DateTime creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CustomField.Type getType() {
		return type;
	}

	public void setType(CustomField.Type type) {
		this.type = type;
	}
	
	public Boolean getSearchable() {
		return searchable;
	}

	public void setSearchable(Boolean searchable) {
		this.searchable = searchable;
	}
	
	public Boolean getPreviewable() {
		return previewable;
	}

	public void setPreviewable(Boolean previewable) {
		this.previewable = previewable;
	}
	
	public Props getProps() {
		return props;
	}

	public void setProps(Props props) {
		this.props = props;
	}
	
	public Values getValues() {
		return values;
	}

	public void setValues(Values values) {
		this.values = values;
	}
	
	public LabelI18n getLabelI18n() {
		return labelI18n;
	}

	public void setLabelI18n(LabelI18n labelI18n) {
		this.labelI18n = labelI18n;
	}

	public String getQueryId() {
		return queryId;
	}

	public void setQueryId(String queryId) {
		this.queryId = queryId;
	}
	
	public boolean isDataBindableType() {
		return StringUtils.equalsAny(EnumUtils.toSerializedName(getType()), "comboboxds", "tagds");
	}
	
	public static enum RevisionStatus {
		@SerializedName("N") NEW,
		@SerializedName("M") MODIFIED,
		@SerializedName("D") DELETED;
	}
	
	public static RawValueType toRawValueType(final CustomField.Type customFieldType) {
		if (CustomField.Type.TEXT.equals(customFieldType)) {
			return RawValueType.CVSTRING;
			
		} else if (CustomField.Type.TEXTAREA.equals(customFieldType)) {
			return RawValueType.CVTEXT;
		
		} else if (CustomField.Type.NUMBER.equals(customFieldType)) {
			return RawValueType.CVNUMBER;
			
		} else if (CustomField.Type.DATE.equals(customFieldType)) {
			return RawValueType.CVDATE;
			
		} else if (CustomField.Type.TIME.equals(customFieldType)) {
			return RawValueType.CVDATE;
			
		} else if (CustomField.Type.DATE_TIME.equals(customFieldType)) {
			return RawValueType.CVDATE;
			
		} else if (CustomField.Type.CHECKBOX.equals(customFieldType)) {
			return RawValueType.CVBOOL;
		
		} else if (CustomField.Type.COMBOBOX.equals(customFieldType) || CustomField.Type.COMBOBOX_DATASOURCE.equals(customFieldType)) {
			return RawValueType.CVSTRING;
			
		} else if (CustomField.Type.TAG.equals(customFieldType) || CustomField.Type.TAG_DATASOURCE.equals(customFieldType)) {
			return RawValueType.CVSTRINGARRAY;
			
		} else if (CustomField.Type.CONTACT_PICKER.equals(customFieldType)) {
			return RawValueType.CVSTRING;
			
		} else {
			return null;
		}
	}
	
	public static enum RawValueType {
		CVSTRING, CVSTRINGARRAY, CVNUMBER, CVBOOL, CVDATE, CVTEXT
	}
	
	public static class Props extends HashMap<String, String> {
	
		public Props() {
			super();
		}
		
		public Props(Map<String, String> map) {
			super(map);
		}
		
		public Props(int initialCapacity) {
			super(initialCapacity);
		}

		public static Props fromJson(String value) {
			if (value == null) return null;
			return JsonResult.gson().fromJson(value, Props.class);
		}

		public static String toJson(Props value) {
			if (value == null) return null;
			return JsonResult.gson().toJson(value, Props.class);
		}
	}
	
	public static class Values extends LinkedHashMap<String, String> {
	
		public Values() {
			super();
		}
		
		public Values(Map<String, String> map) {
			super(map);
		}
		
		public Values(int initialCapacity) {
			super(initialCapacity);
		}

		public static Values fromJson(String value) {
			if (value == null) return null;
			return JsonResult.gson().fromJson(value, Values.class);
		}

		public static String toJson(Values value) {
			if (value == null) return null;
			return JsonResult.gson().toJson(value, Values.class);
		}
	}
	
	public static class LabelI18n extends HashMap<String, String> {
	
		public LabelI18n() {
			super();
		}
		
		public LabelI18n(Map<String, String> map) {
			super(map);
		}
		
		public LabelI18n(int initialCapacity) {
			super(initialCapacity);
		}

		public static LabelI18n fromJson(String value) {
			if (value == null) return null;
			return JsonResult.gson().fromJson(value, LabelI18n.class);
		}

		public static String toJson(LabelI18n value) {
			if (value == null) return null;
			return JsonResult.gson().toJson(value, LabelI18n.class);
		}
	}
	
	public static class NewBuilder<T extends NewBuilder, I extends CustomFieldBase> {
		protected I item;
		
		public NewBuilder() {
			this.item = newItem();
		}
		
		protected I newItem() {
			return (I)new CustomFieldBase();
		}
		
		public T name(String name) {
			item.setName(name);
			return (T)this;
		}
		
		public T description(String description) {
			item.setDescription(description);
			return (T)this;
		}
		
		public T type(CustomField.Type type) {
			item.setType(type);
			return (T)this;
		}
		
		public T searchable(boolean searchable) {
			item.setSearchable(searchable);
			return (T)this;
		}
		
		public T props(CustomField.Props props) {
			item.setProps(props);
			return (T)this;
		}
		
		public T values(CustomField.Values values) {
			item.setValues(values);
			return (T)this;
		}
		
		public T labels(CustomField.LabelI18n labelI18n) {
			item.setLabelI18n(labelI18n);
			return (T)this;
		}
	}
}
