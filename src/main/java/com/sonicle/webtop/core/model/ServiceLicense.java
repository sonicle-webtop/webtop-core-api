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
package com.sonicle.webtop.core.model;

import com.sonicle.webtop.core.app.model.LicenseExInfo;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;

/**
 *
 * @author gbulfon
 */
public class ServiceLicense extends License {
	protected Boolean builtIn;
	protected DateTime revisionTimestamp;
	protected DateTime activationTimestamp;
	protected String activationHwId;
	protected LocalDate expirationDate;
	protected Integer quantity;
	protected Map<String, ServiceLicenseLease> leases = new LinkedHashMap<>();
	protected LicenseExInfo extendedInfo;
	
	public Boolean getBuiltIn() {
		return builtIn;
	}

	public void setBuiltIn(Boolean builtIn) {
		this.builtIn = builtIn;
	}
	
	public DateTime getRevisionTimestamp() {
		return revisionTimestamp;
	}

	public void setRevisionTimestamp(DateTime revisionTimestamp) {
		this.revisionTimestamp = revisionTimestamp;
	}
	
	public DateTime getActivationTimestamp() {
		return activationTimestamp;
	}

	public void setActivationTimestamp(DateTime activationTimestamp) {
		this.activationTimestamp = activationTimestamp;
	}

	public String getActivationHwId() {
		return activationHwId;
	}

	public void setActivationHwId(String activationHwId) {
		this.activationHwId = activationHwId;
	}
	
	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Map<String, ServiceLicenseLease> getLeases() {
		return leases;
	}
	
	public void setLeases(Map<String, ServiceLicenseLease> leases) {
		this.leases = leases;
	}
	
	public void setLeases(Collection<ServiceLicenseLease> leases) {
		this.leases = leases.stream()
			.filter(item -> item.getUserId() != null)
			.collect(Collectors.toMap(item -> item.getUserId(), item -> item, (ov, nv) -> nv, LinkedHashMap::new));
	}

	public LicenseExInfo getExtendedInfo() {
		return extendedInfo;
	}

	public void setExtendedInfo(LicenseExInfo extendedInfo) {
		this.extendedInfo = extendedInfo;
	}
	
	/*
	 * Computes quantity based on eventual expiration date and activation
	 */
	public static Integer computeLicenseQuantity(ServiceLicense sl ) {
		LocalDate expd = sl !=null ? sl.getExpirationDate() : null;
		Integer qta = 0;
		if (sl != null && sl.getActivationHwId() != null) qta = sl.getQuantity();
		if (expd != null && LocalDate.now().isAfter(expd)) qta = 0;
		return qta;
	}
	
	public static final int SOFT_TIME_WINDOW_DAYS = 2;
	
	public static boolean isInsideSoftTimeWindow(ServiceLicense sl) {
		if (sl == null || sl.getActivationTimestamp() == null) return false;
		int days = Days.daysBetween(sl.getActivationTimestamp().toLocalDate(), LocalDate.now()).getDays();
		return days < SOFT_TIME_WINDOW_DAYS;
	}
	
	public static int computeSoftTimeWindowDays(ServiceLicense sl) {
		if (sl == null || sl.getActivationTimestamp() == null) return 0;
		int days = Days.daysBetween(sl.getActivationTimestamp().toLocalDate(), LocalDate.now()).getDays();
		return SOFT_TIME_WINDOW_DAYS - days;
	}
	
}