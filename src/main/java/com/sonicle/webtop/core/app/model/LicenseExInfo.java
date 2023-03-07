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
package com.sonicle.webtop.core.app.model;

import com.sonicle.commons.flags.BitFlags;
import com.sonicle.commons.l4j.ProductLicense.LicenseInfo;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author malbinola
 */
public class LicenseExInfo {
	private String hardwareID;
	private String registeredTo;
	private BitFlags<LicenseComputedStatus> status;

	public LicenseExInfo(String hardwareID, String registeredTo, BitFlags<LicenseComputedStatus> status) {
		this.hardwareID = hardwareID;
		this.registeredTo = registeredTo;
		this.status = status;
	}

	public String getHardwareID() {
		return hardwareID;
	}

	public void setHardwareID(String hardwareID) {
		this.hardwareID = hardwareID;
	}

	public String getRegisteredTo() {
		return registeredTo;
	}

	public void setRegisteredTo(String registeredTo) {
		this.registeredTo = registeredTo;
	}
	
	public BitFlags<LicenseComputedStatus> getStatus() {
		return status;
	}

	public void setStatus(BitFlags<LicenseComputedStatus> status) {
		this.status = status;
	}
	
	public static String buildRegisteredTo(LicenseInfo li) {
		String s = li.getUserRegisteredTo();
		if (!StringUtils.isBlank(li.getUserCompany())) {
			s += " (" + li.getUserCompany() + ")";
		}
		return s;
	}
}
