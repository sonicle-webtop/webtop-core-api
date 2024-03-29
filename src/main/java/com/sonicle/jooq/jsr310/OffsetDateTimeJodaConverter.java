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
package com.sonicle.jooq.jsr310;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import org.jooq.Converter;

/**
 *
 * @author malbinola
 */
public class OffsetDateTimeJodaConverter implements Converter<OffsetDateTime, org.joda.time.DateTime> {

	@Override
	public org.joda.time.DateTime from(OffsetDateTime t) {
		if (t == null) {
			return null;
		} else {
			// https://github.com/jklingsporn/vertx-jooq/issues/64
			// https://gist.github.com/liry/701adafca6c6c3776aa7
			final org.joda.time.DateTimeZone dtz = "Z".equals(t.getOffset().getId()) ? org.joda.time.DateTimeZone.UTC : org.joda.time.DateTimeZone.forID(t.toZonedDateTime().getZone().getId());
			return new org.joda.time.DateTime(t.getYear(), t.getMonthValue(), t.getDayOfMonth(), t.getHour(), t.getMinute(), t.getSecond(), dtz);
		}
	}

	@Override
	public OffsetDateTime to(org.joda.time.DateTime u) {
		if (u == null) {
			return null;
		} else {
			// https://gist.github.com/simon04/26f68a3f21f76dc0bc1ff012676432c9
			// https://blog.joda.org/2014/11/converting-from-joda-time-to-javatime.html
			// https://stackoverflow.com/questions/39723232/what-is-the-best-way-to-convert-a-org-joda-time-datetime-to-a-java-time-offsetda
			final Instant instant = Instant.ofEpochMilli(u.getMillis());
			final ZoneId zid = ZoneId.of(u.getZone().getID());
			return OffsetDateTime.ofInstant(instant, zid);
		}
	}

	@Override
	public Class<OffsetDateTime> fromType() {
		return OffsetDateTime.class;
	}

	@Override
	public Class<org.joda.time.DateTime> toType() {
		return org.joda.time.DateTime.class;
	}
}
