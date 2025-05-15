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
package com.sonicle.webtop.core.app.ical4j;

import com.sonicle.commons.time.JodaTimeUtils;
import java.net.URISyntaxException;
import net.fortuna.ical4j.model.ParameterFactoryImpl;
import net.fortuna.ical4j.model.ParameterList;
import net.fortuna.ical4j.model.property.XProperty;
import net.sf.qualitycheck.Check;
import org.joda.time.DateTime;

/**
 *
 * @author malbinola
 */
public class XCustomFieldValue {
	public static final String PROPERTY_NAME = "X-WT-CUSTOMFIELDVALUE";
	public static final String TYPE_STRING = "string";
	public static final String TYPE_NUMBER = "number";
	public static final String TYPE_BOOLEAN = "boolean";
	public static final String TYPE_DATE = "date";
	public static final String TYPE_TEXT = "text";
	
	public static XProperty toProperty(final String uid, final String value, final boolean isText) throws URISyntaxException {
		return toProperty(uid, isText ? TYPE_TEXT : TYPE_STRING, value);
	}
	
	public static XProperty toProperty(final String uid, final Double value) throws URISyntaxException {
		return toProperty(uid, TYPE_NUMBER, String.valueOf(value));
	}
	
	public static XProperty toProperty(final String uid, final Boolean value) throws URISyntaxException {
		return toProperty(uid, TYPE_BOOLEAN, String.valueOf(value));
	}
	
	public static XProperty toProperty(final String uid, final DateTime value) throws URISyntaxException {
		return toProperty(uid, TYPE_DATE, JodaTimeUtils.printISO(value));
	}
	
	public static XProperty toProperty(final String uid, final String type, final String value) throws URISyntaxException {
		Check.notNull(value, "value");
		return new XProperty(PROPERTY_NAME, toParameters(uid, type), value);
	}
	
	public static ParameterList toParameters(final String uid, final String type) throws URISyntaxException {
		Check.notEmpty(uid, "uid");
		Check.notEmpty(type, "type");
		ParameterFactoryImpl pfi = ParameterFactoryImpl.getInstance();
		ParameterList pl = new ParameterList();
		pl.add(pfi.createParameter("UID", uid));
		pl.add(pfi.createParameter("TYPE", type));
		return pl;
	}
}
