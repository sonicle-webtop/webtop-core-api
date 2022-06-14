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

import com.sonicle.commons.web.json.JsonResult;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author malbinola
 */
public class CustomPanelBase {
	protected String name;
	protected String description;
	protected Set<String> fields;
	protected Set<String> tags;
	protected TitleI18n titleI18n;
	protected Props props;
	
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

	public Set<String> getFields() {
		return fields;
	}

	public void setFields(Set<String> fields) {
		this.fields = fields;
	}
	
	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}
	
	public TitleI18n getTitleI18n() {
		return titleI18n;
	}

	public void setTitleI18n(TitleI18n titleI18n) {
		this.titleI18n = titleI18n;
	}
	
	public Props getProps() {
		return props;
	}

	public void setProps(Props props) {
		this.props = props;
	}
	
	public static class TitleI18n extends HashMap<String, String> {
	
		public TitleI18n() {
			super();
		}
		
		public TitleI18n(Map<String, String> map) {
			super(map);
		}
		
		public TitleI18n(int initialCapacity) {
			super(initialCapacity);
		}

		public static TitleI18n fromJson(String value) {
			if (value == null) return null;
			return JsonResult.gson().fromJson(value, TitleI18n.class);
		}

		public static String toJson(TitleI18n value) {
			if (value == null) return null;
			return JsonResult.gson().toJson(value, TitleI18n.class);
		}
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
}
