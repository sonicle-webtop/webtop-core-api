/*
 * Copyright (C) 2014 Sonicle S.r.l.
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
 * display the words "Copyright (C) 2014 Sonicle S.r.l.".
 */
package com.sonicle.webtop.core.util;

import com.sonicle.commons.LangUtils;
import com.sonicle.webtop.core.app.ezvcard.XAttachmentScribe;
import com.sonicle.webtop.core.app.ezvcard.XCustomFieldValueScribe;
import com.sonicle.webtop.core.app.ezvcard.XTagScribe;
import ezvcard.Ezvcard;
import ezvcard.VCard;
import ezvcard.VCardVersion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author malbinola
 */
public class VCardUtils {
	
	public static String buildUid(String id, String internetName) {
		return id + "@" + internetName;
	}
	
	public static String buildProdId(String product) {
		return "-//Sonicle//" + product + "//EN";
	}
	
	public static String buildProdId(String company, String product) {
		return "-//" + company + "//" + product + "//EN";
	}
	
	/**
	 * @deprecated Use parse or parseFirst instead. Remove me when WT-1071 will be merged!
	 */
	@Deprecated
	public static List<VCard> parse(String s, boolean first) throws IOException {
		if (first) {
			VCard vCard = Ezvcard.parse(s).first();
			return (vCard != null) ? Arrays.asList(vCard) : new ArrayList<>(0);
		} else {
			return Ezvcard.parse(s).all();
		}
	}
	
	public static VCard parseFirst(String s) throws IOException {
		return Ezvcard.parse(s)
				.first();
	}
	
	public static List<VCard> parse(String s) throws IOException {
		return Ezvcard.parse(s)
				.all();
	}
	
	public static String write(VCard vCard) {
		if (vCard == null) return null;
		return Ezvcard.write(vCard)
				.caretEncoding(true)
				.register(new XTagScribe())
				.register(new XCustomFieldValueScribe())
				.register(new XAttachmentScribe())
				.go();
	}
	
	/**
	 * Prints some reference data of the passed VCard component.
	 * @param vc The component.
	 * @return The string dump
	 */
	public static String print(VCard vc) {
		if (vc == null) return null;
		String uid = (vc.getUid() != null) ? vc.getUid().getValue() : null;
		String fn = (vc.getFormattedName() != null) ? vc.getFormattedName().getValue() : null;
		return LangUtils.joinStrings(", ", uid, fn);
	}
	
	public static String computeHashCompat(VCard vCard) {
		return DigestUtils.md5Hex(Ezvcard.write(vCard)
				.caretEncoding(true)
				.go());
	}
}
