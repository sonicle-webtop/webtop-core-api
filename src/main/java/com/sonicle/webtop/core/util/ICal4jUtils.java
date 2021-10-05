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
import java.net.SocketException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.DateList;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.Dur;
import net.fortuna.ical4j.model.Period;
import net.fortuna.ical4j.model.PeriodList;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.Recur;
import net.fortuna.ical4j.model.TimeZone;
import net.fortuna.ical4j.model.TimeZoneRegistry;
import net.fortuna.ical4j.model.TimeZoneRegistryFactory;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.component.VToDo;
import net.fortuna.ical4j.model.parameter.Value;
import net.fortuna.ical4j.model.property.DateProperty;
import net.fortuna.ical4j.model.property.DtStamp;
import net.fortuna.ical4j.model.property.DtStart;
import net.fortuna.ical4j.model.property.Duration;
import net.fortuna.ical4j.model.property.ExDate;
import net.fortuna.ical4j.model.property.RRule;
import net.fortuna.ical4j.util.UidGenerator;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTimeZone;

/**
 *
 * @author malbinola
 */
public class ICal4jUtils {
	//public final static TimeZoneRegistry tzRegistry = new TimeZoneRegistryImpl();
	public final static TimeZoneRegistry tzRegistry = TimeZoneRegistryFactory.getInstance().createRegistry();
	
	/**
	 * Prints a short dump of the passed VEvent component.
	 * @param vevent The component.
	 * @return The dump string
	 */
	public static String printDump(VEvent vevent) {
		if (vevent == null) return null;
		String uid = (vevent.getUid() != null) ? vevent.getUid().getValue() : null;
		String summ = (vevent.getSummary() != null) ? vevent.getSummary().getValue() : null;
		return LangUtils.joinStrings(", ", uid, summ);
	}
	
	/**
	 * Prints a short dump of the passed VEvent component.
	 * @param vtodo The component.
	 * @return The dump string
	 */
	public static String printDump(VToDo vtodo) {
		if (vtodo == null) return null;
		String uid = (vtodo.getUid() != null) ? vtodo.getUid().getValue() : null;
		String summ = (vtodo.getSummary() != null) ? vtodo.getSummary().getValue() : null;
		return LangUtils.joinStrings(", ", uid, summ);
	}
	
	/**
	 * Returns the value of passed Property, if provided, or null otherwise.
	 * @param prop Property object
	 * @return The corresponding String value
	 */
	public static String getPropertyValue(Property prop) {
		return (prop != null) ? prop.getValue() : null;
	}
	
	/**
	 * Returns the value of passed DateProperty, if provided, or null otherwise.
	 * @param prop Property object
	 * @return The corresponding Date value
	 */
	public static Date getDatePropertyValue(DateProperty prop) {
		return (prop != null) ? prop.getDate(): null;
	}
	
	public static void addProperty(Component component, Property property) {
		component.getProperties().add(property);
	}
	
	public static void addOrReplaceProperty(Component component, Property property) {
		Property oldProp = component.getProperties().getProperty(property.getName());
		if (oldProp != null) component.getProperties().remove(oldProp);
		addProperty(component, property);
	}
	
	public static boolean isAllDay(VEvent event) {
		return StringUtils.contains(event.getStartDate().toString(), "VALUE=DATE");
	}
	
	public static String generateUid(String hostName, String pid) {
		UidGenerator ug = null;
		try {
			ug = new UidGenerator(pid);
			return ug.generateUid().toString();
		} catch(SocketException ex) {
			return null;
		}
	}
	
	public static org.joda.time.DateTime ifiniteDate() {
		return ifiniteDate(org.joda.time.DateTimeZone.UTC);
	}
	
	public static org.joda.time.DateTime ifiniteDate(org.joda.time.DateTimeZone tz) {
		return new org.joda.time.DateTime(2100, 12, 31, 0, 0, 0, tz);
	}
	
	public static boolean recurHasCount(Recur recur) {
		if (recur == null) return false;
		return recur.getCount() > 0;
	}
	
	public static boolean recurHasUntilDate(Recur recur) {
		if (recur == null) return false;
		return recur.getUntil() != null;
	}
	
	public static boolean recurHasInfiniteEnd(Recur recur) {
		if (recur == null) return false;
		if (recurHasCount(recur)) return false;
		if (recurHasUntilDate(recur)) return false;
		return true;
	}
	
	public static Period createPeriod(org.joda.time.DateTime start, org.joda.time.DateTime end, org.joda.time.DateTimeZone timezone) {
		return new Period(toIC4jDateTime(start, timezone), toIC4jDateTime(end, timezone));
	}
	
	/**
	 * @deprecated use toIC4jDateTimeUTC instead
	 */
	@Deprecated
	public static DateTime createDateTime(org.joda.time.DateTime dateTime) {
		DateTime dt1 = new DateTime(dateTime.toDate());
		if (dateTime.getZone().equals(org.joda.time.DateTimeZone.UTC)) {
			dt1.setUtc(true);
		} else {
			dt1.setTimeZone(toIC4jTimezone(dateTime.getZone().getID()));
		}
		return dt1;
	}
	
	public static DtStamp createDtStamp(org.joda.time.DateTime dt) {
		return new DtStamp(createDateTime(dt));
	}
	
	/**
	 * Converts JodaTime timezone object into a ICal4j timezone object
	 * @param timezone JodaTime timezone
	 * @return ICal4j timezone
	 */
	public static TimeZone toIC4jTimezone(org.joda.time.DateTimeZone timezone) {
		return (timezone != null) ? toIC4jTimezone(timezone.getID()) : null;
	}
	
	/**
	 * Converts JodaTime timezone ID into a ICal4j timezone object
	 * @param timezoneId JodaTime timezone ID
	 * @return ICal4j timezone
	 */
	public static TimeZone toIC4jTimezone(String timezoneId) {
		return tzRegistry.getTimeZone(timezoneId);
	}
	
	/**
	 * Clears-out the timezone returning the standard timezone value.
	 * Sometimes, we can find non standard timezones coming from custom/private 
	 * timezone database implementation. A call to the registry, ensures that a
	 * cleared timezone will be returned.
	 * For example, using "/inverse.ca/20091015_1/Europe/Rome" as timezone ID,
	 * we get back "Europe/Rome"; thats we are looking for.
	 * @param timezone ICal4j timezone
	 * @return ICal4j timezone
	 */
	public static TimeZone clearIC4jTimezone(TimeZone timezone) {
		return (timezone == null) ? null : tzRegistry.getTimeZone(timezone.getID());
	}
	
	/**
	 * Converts ICal4j timezone object into a JodaTime timezone object
	 * @param timezone ICal4j timezone
	 * @return JodaTime timezone
	 */
	public static DateTimeZone toJodaTimezone(TimeZone timezone) {
		TimeZone clearedTimezone = ICal4jUtils.clearIC4jTimezone(timezone);
		return (clearedTimezone != null) ? toJodaTimezone(clearedTimezone.getID()) : null;
	}
	
	/**
	 * Converts ICal4j timezone ID into a JodaTime timezone object
	 * @param ic4jTimezoneId ICal4j timezone ID
	 * @return JodaTime timezone
	 */
	public static DateTimeZone toJodaTimezone(String ic4jTimezoneId) {
		return org.joda.time.DateTimeZone.forID(ic4jTimezoneId);
	}
	
	/**
	 * Creates an iCal4j DateTime from a Joda LocalDate.
	 * For example, the following represents January 19, 1998:
	 * VALUE=DATE:19980119
	 * @param date Joda date
	 * @return ICal4j Date
	 */
	public static Date toIC4jDate(org.joda.time.LocalDate date) {
		//return new Date(date.toDate().getTime());
		try {
			return new Date(date.toString("yyyyMMdd"));
		} catch (ParseException ex) {
			return null;
		}
	}
	
	/**
	 * Creates an iCal4j DateTime with UTC time.
	 * The date with UTC time, or absolute time, is identified by a LATIN
	 * CAPITAL LETTER Z suffix character, the UTC designator, appended to
	 * the time value. For example, the following represents January 19,
	 * 1998, at 0700 UTC:
	 * 19980119T070000Z
	 * @param dateTime
	 * @return 
	 */
	public static DateTime toIC4jDateTimeUTC(org.joda.time.DateTime dateTime) {
		final DateTime dt = new DateTime(true);
		dt.setTime(dateTime.withZone(DateTimeZone.UTC).toDate().getTime());
		return dt;
	}
	
	/**
	 * Creates an iCal4j DateTime according to the passed timezone reference.
	 * The date and local time with reference to time zone information is
	 * identified by the use the "TZID" property parameter to reference
	 * the appropriate time zone definition. "TZID" is discussed in
	 * detail in Section 3.2.19. For example, the following represents
	 * 2:00 A.M. in New York on January 19, 1998:
	 * TZID=America/New_York:19980119T020000
	 * @param dateTime The date-time to convert.
	 * @param timezone The zone info of the instant.
	 * @return DateTime object
	 */
	public static DateTime toIC4jDateTime(org.joda.time.DateTime dateTime, org.joda.time.DateTimeZone timezone) {
		return toIC4jDateTime(dateTime, timezone, true);
	}
	
	/**
	 * Creates an iCal4j DateTime with local time and optionally adds the 
	 * timezone reference.
	 * The date and local time with reference to time zone information is
	 * identified by the use the "TZID" property parameter to reference
	 * the appropriate time zone definition. "TZID" is discussed in
	 * detail in Section 3.2.19. For example, the following represents
	 * 2:00 A.M. in New York on January 19, 1998:
	 * TZID=America/New_York:19980119T020000
	 * @param dateTime The date-time to convert.
	 * @param timezone The zone info of the instant.
	 * @param addZoneReference
	 * @return DateTime object
	 */
	public static DateTime toIC4jDateTime(org.joda.time.DateTime dateTime, org.joda.time.DateTimeZone timezone, boolean addZoneReference) {
		if (timezone != null) {
			final DateTime dt = new DateTime(dateTime.withZone(timezone).toDate().getTime());
			if (addZoneReference) dt.setTimeZone(toIC4jTimezone(timezone));
			return dt;
		} else {
			return new DateTime(dateTime.toDate().getTime());
		}
	}
	
	/**
	 * Creates a list of excluded dates suitable to use in conjunction with a recurrence rule.
	 * @param excludedDates List of dates to exclude.
	 * @param eventAllDay Event's all-day status.
	 * @param eventStart Event's start time.
	 * @param eventTimezone Event's zone info.
	 * @param useUTC Specifies whether to explicit use UTC times in target collection (eg. exports).
	 * @return ExDate objects list
	 */
	public static ExDate toIC4jExDate(Set<org.joda.time.LocalDate> excludedDates, boolean eventAllDay, org.joda.time.DateTime eventStart, org.joda.time.DateTimeZone eventTimezone, boolean useUTC) {
		org.joda.time.LocalTime startTime = eventAllDay ? null : eventStart.withZone(eventTimezone).toLocalTime();
		return toIC4jExDate(excludedDates, startTime, eventTimezone, useUTC);
	}
	
	/**
	 * Creates a list of excluded dates suitable to use in conjunction with a recurrence rule.
	 * @param excludedDates List of dates to exclude.
	 * @param defaultTime A reference time to use (for eg. event's start time), it can be null.
	 * @param timezone A reference timezone to use.
	 * @param useUTC Specifies whether to explicit use UTC times in target collection (eg. exports).
	 * @return ExDate objects list
	 */
	public static ExDate toIC4jExDate(Set<org.joda.time.LocalDate> excludedDates, org.joda.time.LocalTime defaultTime, org.joda.time.DateTimeZone timezone, boolean useUTC) {
		// Define the collection that hold dates...
		DateList dateList = null;
		if (defaultTime != null) {
			dateList = new DateList(Value.DATE_TIME);
			// Sets timezone info only if we have time defined, AD events must carry dates only!
			if (useUTC) {
				dateList.setUtc(true);
			} else {
				dateList.setTimeZone(ICal4jUtils.toIC4jTimezone(timezone));
			}
		} else {
			dateList = new DateList(Value.DATE);
		}
		
		// Fill the collection...
		for (org.joda.time.LocalDate exclDate : excludedDates) {
			if (Value.DATE_TIME.equals(dateList.getType())) {
				org.joda.time.DateTime dt = exclDate.toDateTime(defaultTime, timezone);
				if (useUTC) {
					dateList.add(ICal4jUtils.toIC4jDateTimeUTC(dt));
				} else {
					// Skip forcing the zone reference, it's already set above on the collection setup!
					dateList.add(ICal4jUtils.toIC4jDateTime(dt, timezone, false));
				}
			} else {
				dateList.add(ICal4jUtils.toIC4jDate(exclDate));
			}
		}
		return new ExDate(dateList);
	}
	
	/**
	 * Creates an iCal4j Period with UTC time.
	 * @param start Period's start instant.
	 * @param end Period's start instant.
	 * @return Period object
	 */
	public static Period toIC4jPeriodUTC(org.joda.time.DateTime start, org.joda.time.DateTime end) {
		return new Period(toIC4jDateTimeUTC(start), toIC4jDateTimeUTC(end));
	}
	
	/**
	 * Creates an iCal4j Period with secified Zone.
	 * @param start Period's start instant.
	 * @param end Period's end instant.
	 * @param timezone Zone reference.
	 * @return Period object
	 */
	public static Period toIC4jPeriod(org.joda.time.DateTime start, org.joda.time.DateTime end, org.joda.time.DateTimeZone timezone) {
		return new Period(toIC4jDateTime(start, timezone), toIC4jDateTime(end, timezone));
	}
	
	/**
	 * Converts an iCal4j DateTime into a JodaTime DateTime.
	 * @param dateTime Source DateTime object.
	 * @return A DateTime object
	 */
	public static org.joda.time.DateTime toJodaDateTime(DateTime dateTime) {
		return toJodaDateTime(dateTime, null);
	}
	
	/**
	 * Converts an iCal4j DateTime into a JodaTime DateTime.
	 * A NULL timezone will base conversion to system default zone reference.
	 * @param dateTime Source DateTime object.
	 * @param defaultTimezone The reference timezone of time part.
	 * @return A DateTime object
	 */
	public static org.joda.time.DateTime toJodaDateTime(DateTime dateTime, org.joda.time.DateTimeZone defaultTimezone) {
		if (dateTime == null) return null;
		org.joda.time.DateTimeZone tz = toJodaTimezone(dateTime.getTimeZone());
		if ((tz == null) && (defaultTimezone != null)) tz = defaultTimezone;
		if (tz != null) {
			return new org.joda.time.DateTime(dateTime.getTime(), tz);
		} else {
			return new org.joda.time.DateTime(dateTime.getTime());
		}
	}
	
	/**
	 * Converts an iCal4j Date into a JodaTime DateTime.
	 * @param date Source Date object.
	 * @param defaultTimezone The reference timezone of time part.
	 * @return A DateTime object
	 */
	public static org.joda.time.DateTime toJodaDateTime(Date date, org.joda.time.DateTimeZone defaultTimezone) {
		if (date == null) return null;
		if (date instanceof DateTime) {
			return toJodaDateTime((DateTime)date, defaultTimezone);
		} else {
			if (defaultTimezone != null) {
				return new org.joda.time.DateTime(date.getTime(), defaultTimezone);
			} else {
				return new org.joda.time.DateTime(date.getTime());
			}
		}
	}
	
	/**
	 * Converts an iCal4j Date into a JodaTime LocalDate.
	 * UTC zone is used as referencence for possible dateTime values.
	 * @param date Source Date object.
	 * @return A LocalDate object
	 */
	public static org.joda.time.LocalDate toJodaLocalDate(Date date) {
		return toJodaLocalDate(date, org.joda.time.DateTimeZone.UTC);
	}
	
	/**
	 * Converts an iCal4j Date into a JodaTime LocalDate.
	 * If the passed Date is an instance of iCal4j DateTime, the timezone is 
	 * used as the reference timezone of the date in order to decode data correctly.
	 * A NULL timezone will base conversion to system default zone reference.
	 * @param date Source Date object.
	 * @param defaultTimezone The reference timezone of time part.
	 * @return A LocalDate object
	 */
	public static org.joda.time.LocalDate toJodaLocalDate(Date date, org.joda.time.DateTimeZone defaultTimezone) {
		if (date == null) return null;
		if (date instanceof DateTime) {
			org.joda.time.DateTime dt = toJodaDateTime((DateTime)date, defaultTimezone);
			return dt.toLocalDate();
		} else {
			return new org.joda.time.LocalDate(date.getTime());
		}
	}
	
	/**
	 * Updates, if necessary, the until-date setting it to the event start time in event timezone.
	 * @param recur Recurrence rule.
	 * @param eventStartTime Event start time.
	 * @param eventTimezone Event timezone.
	 * @return True if an update was performed, false otherwise.
	 */
	public static boolean adjustRecurUntilDate(Recur recur, org.joda.time.LocalTime eventStartTime, org.joda.time.DateTimeZone eventTimezone) {
		if (recurHasUntilDate(recur)) {
			org.joda.time.LocalDate untilDate = toJodaLocalDate(recur.getUntil(), eventTimezone);
			setRecurUntilDate(recur, untilDate.toDateTime(eventStartTime, eventTimezone));
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Sets the specified date-time as new until-date in recurrence rule.
	 * @param recur Recurrence rule.
	 * @param untilDate Date-time to set.
	 */
	public static void setRecurUntilDate(Recur recur, org.joda.time.DateTime untilDate) {
		if (untilDate != null) {
			recur.setUntil(toIC4jDateTimeUTC(untilDate.withZone(org.joda.time.DateTimeZone.UTC)));
		} else {
			recur.setUntil(null);
		}
	}
	
	/**
	 * Silently parses the passed string as a recurrence rule, null is 
	 * returned in case of any errors.
	 * @param rrule The rule string.
	 * @return Recurrence rule object
	 */
	public static Recur parseRRule(String rrule) {
		if (StringUtils.isBlank(rrule)) return null;
		try {
			return new Recur(rrule);
		} catch(ParseException | IllegalArgumentException ex) {
			return null;
		}
	}
	
	/**
	 * Checks if passed recurrence rules are equals or not.
	 * @param recur1 First recurrence object.
	 * @param recur2 Second recurrence object.
	 * @return True if rules are equal, false otherwise
	 */
	public static boolean equals(Recur recur1, Recur recur2) {
		if (recur1 == null) return false;
		if (recur2 == null) return false;
		return StringUtils.equals(recur1.toString(), recur2.toString());
	}
	
	/**
	 * Computes date instances substained by the passed recurrence rule.
	 * NB: returned dates are obtained by instant in target timezone.
	 * @param recur Recurrence object instance.
	 * @param recurStart Recurrence start instant.
	 * @param recurExcludedDates List of dates to exclude from the final result.
	 * @param start Event's start instant.
	 * @param end Event's end instant.
	 * @param timezone Event's zone info.
	 * @param rangeFrom Desired starting range to evaluate.
	 * @param rangeTo Desired ending range to evaluate.
	 * @param limit Max number of elements to return, -1 means unlimited.
	 * @return List of date instances.
	 */
	public static List<org.joda.time.LocalDate> calculateRecurrenceSet(Recur recur, org.joda.time.DateTime recurStart, Set<org.joda.time.LocalDate> recurExcludedDates, org.joda.time.DateTime start, org.joda.time.DateTime end, org.joda.time.DateTimeZone timezone, org.joda.time.DateTime rangeFrom, org.joda.time.DateTime rangeTo, int limit) {
		// Dates computation needs to pass through VEvent otherwise recur may 
		// not take into account some aspects relates to recurrence start and 
		// so wrong dates are returned (eg. WEEKLY with missing BYDAY).
		
		int max = (limit == -1) ? Integer.MAX_VALUE : limit;
		org.joda.time.DateTime realRecurStart = calculateRecurrenceStart(recur, recurStart, start, timezone);
		
		org.joda.time.DateTime peStart = recurStart;
		if (start.isBefore(peStart)) peStart = start;
		if (rangeFrom != null && rangeFrom.isAfter(peStart)) peStart = rangeFrom;
		org.joda.time.DateTime peEnd = ifiniteDate(timezone);
		if ((rangeTo != null) && rangeTo.isBefore(peEnd)) peEnd = rangeTo;
		
		// We need to use recurStart date (at event startDate time) as start 
		// because otherwise we may lose instances on the end if the recur start
		// date does not match event start. We need also to set a duration 
		// according to the real event length in days, this is useful to have 
		// right instances in case of multi-day events that starts before 
		// specified view range.
		org.joda.time.DateTime veStart = start.withDate(recurStart.toLocalDate());
		int veDays = Math.abs(org.joda.time.Days.daysBetween(start.toLocalDate(), end.toLocalDate()).getDays()); // Calendar days length
		VEvent veDummy = new VEvent(toIC4jDateTime(veStart, timezone), new Dur(veDays, 0, 0, 0), "DUMMY");
		veDummy.getProperties().add(new RRule(recur));
		if ((recurExcludedDates != null) && !recurExcludedDates.isEmpty()) {
			// Seems that we have to use times also when dealing with AD events, 
			// otherwise we get wrong dates (#WT-806) when calculating recurrence set.
			// AD events have start time set to 00:00 so we are ok when extracting as time.
			veDummy.getProperties().add(toIC4jExDate(recurExcludedDates, veStart.withZone(timezone).toLocalTime(), timezone, false));
		}
		
		PeriodList list = veDummy.calculateRecurrenceSet(toIC4jPeriod(peStart, peEnd, timezone));
		ArrayList<org.joda.time.LocalDate> date = new ArrayList<>(list.size() < max ? list.size() : max);
		Iterator<Period> it = list.iterator();
		while (it.hasNext()) {
			Period period = it.next();
			org.joda.time.DateTime instant = toJodaDateTime(period.getStart(), timezone);
			if (instant.compareTo(realRecurStart) >= 0) {
				date.add(instant.toLocalDate());
				if (date.size() == max) break;
			}
		}
		return date;
	}
	
	/**
	 * @deprecated use the above instead
	 * Computes date instances substained by the passed recurrence rule.
	 * @param recur Recurrence object instance.
	 * @param recurStart Recurrence start instant.
	 * @param recurExcludedDates List of dates to exclude from the final result.
	 * @param eventAllDay Indicates whether the event is all-day or not.
	 * @param eventStart Event's start instant.
	 * @param eventEnd Event's end instant.
	 * @param eventTimezone Event's zone info.
	 * @param rangeFrom Desired starting range to evaluate.
	 * @param rangeTo Desired ending range to evaluate.
	 * @param limit Max number of elements to return, -1 means unlimited.
	 * @return List of date instances.
	 */
	@Deprecated
	public static List<org.joda.time.LocalDate> calculateRecurrenceSet(Recur recur, org.joda.time.DateTime recurStart, Set<org.joda.time.LocalDate> recurExcludedDates, boolean eventAllDay, org.joda.time.DateTime eventStart, org.joda.time.DateTime eventEnd, org.joda.time.DateTimeZone eventTimezone, org.joda.time.DateTime rangeFrom, org.joda.time.DateTime rangeTo, int limit) {
		// Dates computation needs to pass through VEvent otherwise recur may 
		// not take into account some aspects relates to recurrence start and 
		// so wrong dates are returned (eg. WEEKLY with missing BYDAY).
		
		int max = (limit == -1) ? Integer.MAX_VALUE : limit;
		//Date realRecurStart = getRecurStartDate(recur, toIC4jDateTime(recurStart, eventTimezone, false), toIC4jDateTime(eventStart, eventTimezone, false));
		org.joda.time.DateTime realRecurStart = calculateRecurrenceStart(recur, recurStart, eventStart, eventTimezone);
		//DateTime rstartDate = toIC4jDateTime(recurStart, eventTimezone, false);
		if (realRecurStart == null) return new ArrayList<>(0);
		
		//org.joda.time.DateTime peStart = recurStart.isAfter(eventStart) ? recurStart : eventStart;
		org.joda.time.DateTime peStart = recurStart;
		if (eventStart.isBefore(peStart)) peStart = eventStart;
		if (rangeFrom != null && rangeFrom.isAfter(peStart)) peStart = rangeFrom;
		org.joda.time.DateTime peEnd = ifiniteDate(eventTimezone);
		if ((rangeTo != null) && rangeTo.isBefore(peEnd)) peEnd = rangeTo;
		
		// We need to use recurStart date (at event startDate time) as start 
		// because otherwise we may lose instances on the end if the recur start
		// date does not match event start. We need also to set a duration 
		// according to the real event length in days, this is useful to have 
		// right instances in case of multi-day events that starts before 
		// specified view range.
		org.joda.time.DateTime veStart = eventStart.withDate(recurStart.toLocalDate());
		int veDays = org.joda.time.Days.daysBetween(eventStart.toLocalDate(), eventEnd.toLocalDate()).getDays(); // Calendar days length
		VEvent veDummy = new VEvent(toIC4jDateTime(veStart, eventTimezone), new Dur(veDays, 0, 0, 0), "DUMMY");
		veDummy.getProperties().add(new RRule(recur));
		if ((recurExcludedDates != null) && !recurExcludedDates.isEmpty()) {
			// Seems that we have to use times also when dealing with AD events, 
			// otherwise we get wrong dates (#WT-806) when calculating recurrence set.
			// AD events have start time set to 00:00 so we are ok when extracting as time.
			veDummy.getProperties().add(toIC4jExDate(recurExcludedDates, eventStart.withZone(eventTimezone).toLocalTime(), eventTimezone, false));
			// Replaced by logic above!
			//veDummy.getProperties().add(toIC4jExDate(recurExcludedDates, eventAllDay, eventStart, eventTimezone, false));
		}
		
		org.joda.time.LocalDate realRecurStartDate = realRecurStart.toLocalDate();
		PeriodList list = veDummy.calculateRecurrenceSet(createPeriod(peStart, peEnd, eventTimezone));
		ArrayList<org.joda.time.LocalDate> dates = new ArrayList<>(list.size() < max ? list.size() : max);
		Iterator<Period> it = list.iterator();
		while (it.hasNext()) {
			Period period = it.next();
			org.joda.time.LocalDate date = toJodaLocalDate(period.getStart(), eventTimezone);
			if (date.compareTo(realRecurStartDate) >= 0) {
				dates.add(toJodaLocalDate(period.getStart(), eventTimezone));
				if (dates.size() == max) break;
			}	
		}
		return dates;
	}
	
	/**
	 * Returns recurrence's start boundary.
	 * @param recur
	 * @param recurStart
	 * @param start
	 * @param timezone
	 * @return 
	 */
	public static org.joda.time.DateTime calculateRecurrenceStart(Recur recur, org.joda.time.DateTime recurStart, org.joda.time.DateTime start, org.joda.time.DateTimeZone timezone) {
		org.joda.time.DateTime dtSeed = start.withZone(timezone).withDate(recurStart.toLocalDate());
		org.joda.time.DateTime dtStart = recurStart.withZone(timezone).minusDays(1);
		// NB: Do NOT use toICal4jDateTimeUTC here: otherwise, due to zone translation, time will be wrong for boundaries at 00:00! I think that getNextDate does not handle UTC well.
		return toJodaDateTime(recur.getNextDate(toIC4jDateTime(dtSeed, timezone), toIC4jDateTime(dtStart, timezone)), timezone);
	}
	
	/**
	 * Returns recurrence's end boundary.
	 * @param recur Recurrence rule.
	 * @param recurStart Recurrence's start date.
	 * @param eventStart Event's start date.
	 * @param eventEnd Event's end date.
	 * @param eventTimezone Event's zone info.
	 * @return The last date within recurrence
	 */
	public static org.joda.time.DateTime calculateRecurrenceEnd(Recur recur, org.joda.time.DateTime recurStart, org.joda.time.DateTime eventStart, org.joda.time.DateTime eventEnd, org.joda.time.DateTimeZone eventTimezone) {
		DateTime seed = toIC4jDateTime(recurStart, eventTimezone);
		//DateTime periodStart = toIC4jDateTime(recurStart, eventTimezone);
		DateTime periodEnd = toIC4jDateTime(ifiniteDate(eventTimezone), eventTimezone);
		return toJodaDateTime(getRecurLastDate(recur, seed, periodEnd), eventTimezone);
		
		// Alternative implementation using getDates directly:
		//DateList dates = recur.getDates(seed, periodStart, periodEnd, Value.DATE_TIME);
		//return dates.isEmpty() ? null : toJodaDateTime(dates.get(dates.size()-1), eventTimezone);
		
		// Alternative implementation using veDummy:
		/*
		int eventDays = org.joda.time.Days.daysBetween(eventStart.toLocalDate(), eventEnd.toLocalDate()).getDays();
		org.joda.time.DateTime start = eventStart.withDate(recurStart.toLocalDate());
		org.joda.time.DateTime end = eventEnd.withDate(recurStart.toLocalDate().plusDays(eventDays));
		VEvent veDummy = new VEvent(toIC4jDateTime(start, eventTimezone, false), toIC4jDateTime(end, eventTimezone, false), "");
		veDummy.getProperties().add(new RRule(recur));

		PeriodList list = veDummy.calculateRecurrenceSet(createPeriod(recurStart, ifiniteDate(eventTimezone), eventTimezone));
		if (list.isEmpty()) {
			return null;
		} else {
			//TODO: evaluate to get the last element in a smart way, this is O(n), Guava's Streams.findLast(stream) can do it in between O(log n) and O(n).
			Period lastPeriod = null;
			Iterator<Period> it = list.iterator();
			while (it.hasNext()) lastPeriod = it.next();
			return (lastPeriod == null) ? null : toJodaDateTime(lastPeriod.getStart(), eventTimezone);
		}
		*/
	}
	
	/**
	 * //TODO: clone calculateRecurrenceStart here using only ical4j objects
	 * @param recur
	 * @param recurStart
	 * @param eventStart
	 * @param maxRangeEnd
	 * @return 
	 */
	/*
	private static Date getRecurStartDate(final Recur recur, Date recurStart, Date eventStart) {
		// Replace Dur with TemporalAmount: https://github.com/ical4j/ical4j/issues/273
		
		Calendar calRecurStart = Dates.getCalendarInstance(recurStart);
		Calendar calEventStart = Dates.getCalendarInstance(eventStart);
		calEventStart.set(calRecurStart.get(Calendar.YEAR), calRecurStart.get(Calendar.MONTH), calRecurStart.get(Calendar.DAY_OF_MONTH));
		
		Dur days1 = new Dur(-1, 0, 0, 0);
		Date seed = new Date(calEventStart);
		Date startDate = new DateTime(days1.getTime(recurStart));
		return recur.getNextDate(seed, startDate);
	}
	*/
	
	/**
	 * Returns the highest possible start-date.
	 * Heavly inspired by: https://github.com/Bedework/bw-calendar-engine/blob/master/bw-calendar-engine-ical/src/main/java/org/bedework/icalendar/RecurUtil.java
	 * @param recur
	 * @param start
	 * @param maxRangeEnd
	 * @return 
	 */
	private static Date getRecurLastDate(final Recur recur, Date start, final Date maxRangeEnd) {
		// Replace Dur with TemporalAmount: https://github.com/ical4j/ical4j/issues/273
		Date seed = start;
		Date until = recur.getUntil();
		// If until date is set, take it as last date
		if (until != null) return until;
		// If count is invalid, we do not have a last date
		int count = recur.getCount();
		if (count < 1) return null;
		
		Dur days100 = new Dur(100, 0, 0, 0);
		int i = 0;
		while ((i < count) && (start.before(maxRangeEnd))) {
			Date end = new DateTime(days100.getTime(start));
			DateList dates = recur.getDates(seed, start, end, Value.DATE_TIME);
			
			int size = dates.size();
			i += size;
			if (size != 0) until = (Date)dates.get(size -1);
			start = end;
		}
		return until;
	}
	
	/**
	 * Replicate calculations made in VEvent's method calculateRecurrenceSet
	 * (https://github.com/ical4j/ical4j/blob/develop/src/main/java/net/fortuna/ical4j/model/Component.java)
	 * in order to determine if initial date was added to the list. This is 
	 * useful to remove it later.
	 * For example using:
	 * FREQ=MONTHLY;COUNT=3;INTERVAL=1;BYDAY=MO;BYSETPOS=-1
	 * with DTSTART 11/09/2019
	 * we should have: 30Sep, 28Oct and 25Nov
	 * 
	 * VEvent's method calculateRecurrenceSet may add initial instance by  
	 * default, if intersect with the specified period. It seems that ical4j 
	 * implemented this behaviour for begin compliant to rfc5545 telling that
	 * DTSTART property should define the first instance and should be 
	 * synchronized with recurrence rule.
	 * https://sourceforge.net/p/ical4j/discussion/368291/thread/6a3c5ea6/?limit=25#f5f9
	 * https://tools.ietf.org/search/rfc5545#section-3.8.5.3
	 * 
	 * WARNING: below implementation in Component.java is different in more recent
	 * ical4j versions, so keep in mind to check the upstream code when updating library version!
	 * 
	 * @param ve Event object
	 * @param period Period object used within calculateRecurrenceSet
	 * @return 
	 */
	private static boolean shouldSkipFirstRecurrenceSetInstance(final VEvent ve, final Period period) {
		final DtStart start = (DtStart)ve.getProperty(Property.DTSTART);
		DateProperty end = (DateProperty)ve.getProperty(Property.DTEND);
		if (end == null) {
			end = (DateProperty)ve.getProperty(Property.DUE);
		}
		Duration duration = (Duration)ve.getProperty(Property.DURATION);
		
		Dur rDuration;
		if (end == null && duration == null) {
			rDuration = new Dur(start.getDate(), start.getDate());
		} else if (duration == null) {
			rDuration = new Dur(start.getDate(), end.getDate());
		} else {
			rDuration = duration.getDuration();
		}
		
		Period startPeriod;
		if (end != null) {
			startPeriod = new Period(new DateTime(start.getDate()), new DateTime(end.getDate()));
		} else {
			if (duration == null) duration = new Duration(rDuration);
			startPeriod = new Period(new DateTime(start.getDate()), duration.getDuration());
		}
		
		return period.intersects(startPeriod);
	}
	
	/*
	private Date getLatestRecurrenceDate(final List<RRule> rrules, final List<RDate> rdates) {
		
		if ((rrules == null) && (rdates == null)) {
			// Not a recurring event
			return null;
		}
		
		if (rrules != null) {
			Iterator rit = rrules.iterator();
			while (rit.hasNext()) {
				RRule rr = (RRule)rit.next();
				Date nextUntil = getRecurLastDate(rr.getRecur(), start, maxRangeEnd);
				if (nextUntil == null) {
					// No end date, so it's infinite.
					return null;
				}
				
				if ((until == null) || (nextUntil.after(until))) {
					until = nextUntil;
				}
			}
			
			// We have many rules but none with a finite end date
			if (until == null) return null;
		}
		
		if (rdates != null) {
			Iterator rit = rdates.iterator();
			while (rit.hasNext()) {
				RDate rd = (RDate)rit.next();
				
				if (Value.PERIOD.equals(rd.getParameter(Parameter.VALUE))) {
					PeriodList pl = rd.getPeriods();
					Iterator it = pl.iterator();
					while (it.hasNext()) {
						Period p = (Period)it.next();
						
						// Not sure if a single date gives a null end
						Date nextUntil = p.getEnd();
						if (nextUntil == null) {
							nextUntil = p.getStart();
						}
						
						if ((until == null) || (nextUntil.after(until))) {
							until = nextUntil;
						}
					}
				} else {
					DateList startDates = rd.getDates();
					for (int i=0; i<startDates.size(); i++) {
						Date startDate = (Date)startDates.get(i);
						Date endDate = new Date(dur.getTime(startDate));
						if ((until == null) || (endDate.after(until))) {
							until = endDate;
						}
					}
				}
			}
		}
		
		if (until instanceof DateTime) {
			until = new DateTime(dur.getTime(until));
			((DateTime)until).setUtc(true);
		} else {
			until = new Date(dur.getTime(until));
		}
		
		return until;
	}
	*/
	
	/**
	 * @deprecated it can returns bad dates due to recurStart not observed
	 */
	/*
	public static DateList calculateRecurrenceSet(Recur recur, org.joda.time.DateTime start, org.joda.time.DateTimeZone eventTimezone, org.joda.time.DateTime rangeFrom, org.joda.time.DateTime rangeTo, int limit) {
		DateTime base = toICal4jDateTime(start, eventTimezone);
		
		DateTime periodStart = start.isAfter(rangeFrom) ? toIC4jDateTime(start, eventTimezone, false) : toIC4jDateTime(rangeFrom, eventTimezone, false);
		DateTime periodEnd = null;
		if (recurHasUntilDate(recur)) {
			org.joda.time.DateTime untilDate = toJodaDateTime(recur.getUntil(), org.joda.time.DateTimeZone.UTC);
			periodEnd = untilDate.isBefore(rangeTo) ? toIC4jDateTime(untilDate, eventTimezone, false) : toIC4jDateTime(rangeTo, eventTimezone, false);
		} else {
			periodEnd = toIC4jDateTime(rangeTo, eventTimezone, false);
		}
		return recur.getDates(base, periodStart, periodEnd, Value.DATE, limit);
	}
	*/
	
	/**
	 * @deprecated it can returns bad dates due to recurStart not observed
	 */
	/*
	public static org.joda.time.DateTime calculateRecurrenceEnd(Recur recur, org.joda.time.DateTime start, org.joda.time.DateTimeZone eventTimezone) {
		DateTime base = toICal4jDateTime(start, eventTimezone);
		DateTime periodStart = toIC4jDateTime(start, eventTimezone, false);
		DateTime periodEnd = toIC4jDateTime(ifiniteDate(eventTimezone), eventTimezone, false);
		DateList dates = recur.getDates(base, periodStart, periodEnd, Value.DATE_TIME);
		return dates.isEmpty() ? null : toJodaDateTime(dates.get(dates.size()-1), eventTimezone);
	}
	*/
	
	/**
	 * @deprecated
	 */
	/*
	@Deprecated
	public static PeriodList calculateRecurrenceSet(org.joda.time.DateTime eventStart, org.joda.time.DateTime eventEnd, org.joda.time.DateTime recStart, RRule rr, org.joda.time.DateTime from, org.joda.time.DateTime to, org.joda.time.DateTimeZone tz) {
		org.joda.time.DateTime start, end;
		
		if (eventStart.isEqual(recStart)) {
			start = eventStart;
			end = eventEnd;
		} else {
			int eventDays = org.joda.time.Days.daysBetween(eventStart.toLocalDate(), eventEnd.toLocalDate()).getDays();
			start = eventStart.withDate(recStart.toLocalDate());
			end = eventEnd.withDate(start.plusDays(eventDays).toLocalDate());
		}
		
		VEvent vevent = new VEvent(ICal4jUtils.toICal4jDateTime(start, tz), ICal4jUtils.toICal4jDateTime(end, tz), "");
		vevent.getProperties().add(rr);
		return vevent.calculateRecurrenceSet(ICal4jUtils.createPeriod(from, to, tz));
	}
	*/
	
	/**
	 * @deprecated use toIC4jDateTimeUTC() or toIC4jDateTime() instead
	 */
	@Deprecated
	public static DateTime toICal4jDateTime(org.joda.time.DateTime dateTime, org.joda.time.DateTimeZone timezone) {
		DateTime dt = new DateTime(dateTime.toDate());
		if (timezone != null) {
			dt.setTimeZone(tzRegistry.getTimeZone(timezone.getID()));
		}
		return dt;
	}
	
	/*
	@Deprecated
	public static org.joda.time.DateTime calculateRecurrenceStart(org.joda.time.DateTime eventStart, RRule rrule, org.joda.time.DateTimeZone tz) {
		return calculateRecurrenceStart(eventStart, rrule.getRecur(), tz);
	}
	*/
	
	/*
	@Deprecated
	public static org.joda.time.DateTime calculateRecurrenceStart(org.joda.time.DateTime eventStart, Recur recur, org.joda.time.DateTimeZone tz) {
		Date d = recur.getNextDate(ICal4jUtils.toICal4jDateTime(eventStart, tz), ICal4jUtils.toICal4jDateTime(eventStart.minusDays(1), tz));
		return toJodaDateTime(d, tz);
	}
	*/
	
	@Deprecated
	public static org.joda.time.DateTime calculateRecurrenceEnd(org.joda.time.DateTime eventStart, org.joda.time.DateTime eventEnd, RRule rr, org.joda.time.DateTimeZone tz) {
		VEvent vevent = new VEvent(ICal4jUtils.toICal4jDateTime(eventStart, tz), ICal4jUtils.toICal4jDateTime(eventEnd, tz), "");
		vevent.getProperties().add(rr);
		PeriodList periods = vevent.calculateRecurrenceSet(ICal4jUtils.createPeriod(eventStart, ifiniteDate(), tz));
		if((periods == null) || periods.isEmpty()) return null;
		Period last = (Period)periods.toArray()[periods.size()-1];
		return toJodaDateTime(last.getEnd(), tz);
	}
	
	/*
	@Deprecated
	public static org.joda.time.DateTime calculateRecurEnd(Recur recur, org.joda.time.DateTime eventStart, org.joda.time.DateTimeZone eventTz) {
		VEvent veDummy = new VEvent(ICal4jUtils.toICal4jDateTime(eventStart, eventTz), ICal4jUtils.toICal4jDateTime(eventStart, eventTz), "");
		veDummy.getProperties().add(new RRule(recur));
		
		PeriodList periods = veDummy.calculateRecurrenceSet(ICal4jUtils.createPeriod(eventStart, ifiniteDate(), eventTz));
		if ((periods == null) || periods.isEmpty()) {
			return null;
		} else {
			Period last = (Period)periods.toArray()[periods.size()-1];
			return toJodaDateTime(last.getStart(), eventTz);
		}
	}
	*/
	
	/*
	public static void calculateRecurrenceStart(VEvent event) {
		final DtStart start = (DtStart) event.getProperty(Property.DTSTART);
		DateProperty end = (DateProperty) event.getProperty(Property.DTEND);
		Duration duration = (Duration) event.getProperty(Property.DURATION);
		
		final DateTime startMinusDuration = new DateTime(period.getStart());
	}
	
	public static void calculateRecurrenceStart(RRule rrule, org.joda.time.DateTime startDate, org.joda.time.DateTime endDate, org.joda.time.DateTimeZone timezone) {
		
		DateTime start = toICalDate(startDate, timezone);
		DateTime end = toICalDate(endDate, timezone);
		Dur dur = new Dur(start, end);
		DateTime startMinusDuration = start;
		startMinusDuration.setTime(dur.negate().getTime(start).getTime());
		
		final Value startValue = (Value) start.getParameter(Parameter.VALUE);
		
		final DateList rruleDates = rrule.getRecur().getDates(start.getDate(), new Period(startMinusDuration, end), startValue);
	}
	*/
	
	/*
                if (invitate.isEmpty()) {
                    content += "ATTENDEE:ROLE=REQ-PARTICIPANT;RSVP=TRUE" + "\n";
                } else {

                    for (String m : invitate) {
                        String cn=m;
                        String mailto=m;
                        if (m.contains("<") && m.contains(">")){
                            int x=m.indexOf("<");
                            cn=m.substring(0,x);
                            int y=m.indexOf(">");
                            mailto=m.substring(x+1,y);
                        }
                        content += "ATTENDEE;CUTYPE=INDIVIDUAL;ROLE=REQ-PARTICIPANT;PARTSTAT=NEEDS-ACTION;RSVP=TRUE;CN=" + cn + ";X-NUM-GUESTS=0:mailto:" + mailto + "\n";
                    }
                }

                if (!recurrences.equals("")) {
                    content += recurrences;
                }


                content += "CREATED:" + today.get(Calendar.YEAR) + todaymonth + todayday + "T" + todayhour + today.get(Calendar.MINUTE) + "00" + "\n";
                content += "DESCRIPTION:" + description.replaceAll("\n\r", "/N").replaceAll("\r\n", "/N").replaceAll("\n", "/N").replaceAll("\r", "/N") + "\n";
                content += "LAST-MODIFIED:" + today.get(Calendar.YEAR) + todaymonth + todayday + "T" + todayhour + today.get(Calendar.MINUTE) + "00" + "\n";
                content += "SEQUENCE:1" + "\n";
                content += "STATUS:TENTATIVE" + "\n";
                content += "SUMMARY:" + eventname + "\n";
                content += "TRANSP:OPAQUE" + "\n";
*/

	/*
	public static org.joda.time.DateTime toJodaDateTime2(DateTime dateTime, org.joda.time.DateTimeZone defaultTimezone) {
		org.joda.time.DateTimeZone tz = toJodaTimezone(dateTime.getTimeZone());
		return new org.joda.time.DateTime(dateTime.getTime(), (tz != null) ? tz : defaultTimezone);
	}
	
	public static void main(String[] args) {
		try {
			net.fortuna.ical4j.model.Calendar cal = ICalendarUtils.parse(new FileInputStream("C:/calendar.ics"));
			net.fortuna.ical4j.model.component.VEvent ve = (VEvent)cal.getComponents().get(0);
			org.joda.time.DateTime xxx1 = ICal4jUtils.toJodaDateTime((DateTime)ve.getStartDate().getDate());
			org.joda.time.DateTime xxx2 = ICal4jUtils.toJodaDateTime((DateTime)ve.getEndDate().getDate());
			//TZID=Europe/Rome:
			//TZID=Europe/Rome:20180606T113000
			String a = xxx2.toString();
		} catch(Throwable t) {
			System.out.println(t.getMessage());
		}
	}
	*/
	
	public static void recur10times() throws Exception {
		org.joda.time.format.DateTimeFormatter dtf = org.joda.time.format.DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
		org.joda.time.DateTimeZone etz = org.joda.time.DateTimeZone.forID("Europe/Rome");
		org.joda.time.DateTime estart = new org.joda.time.DateTime(2021, 10, 4, 0, 0, 0, etz);
		org.joda.time.DateTime eend = new org.joda.time.DateTime(2021, 10, 4, 0, 0, 0, etz);
		org.joda.time.DateTime rstart = new org.joda.time.DateTime(2021, 10, 4, 0, 0, 0, etz);
		Recur recur = new Recur("FREQ=MONTHLY;COUNT=10;INTERVAL=1;BYMONTHDAY=4");
		
		org.joda.time.DateTime recStart = calculateRecurrenceStart(recur, rstart, estart, etz);
		if (!"2021-10-04 00:00".equals(recStart.toString(dtf))) throw new Exception("Fail");
		
		List<org.joda.time.LocalDate> dates = calculateRecurrenceSet(recur, rstart, null, estart, eend, etz, null, null, -1);
		if (dates.size() != 10) throw new Exception("Fail");
	}
	
	/**
	 * WTCALENDAR-91
	 * @throws Exception 
	 */
	public static void recur8days4times() throws Exception {
		boolean ead = true;
		org.joda.time.DateTimeZone etz = org.joda.time.DateTimeZone.forID("Europe/Rome");
		org.joda.time.DateTime estart = new org.joda.time.DateTime(2019, 11, 1, 0, 0, 0, etz);
		org.joda.time.DateTime eend = new org.joda.time.DateTime(2019, 11, 8, 0, 0, 0, etz);
		org.joda.time.DateTime rstart = new org.joda.time.DateTime(2019, 11, 1, 0, 0, 0, etz);
		Recur recur = new Recur("FREQ=MONTHLY;COUNT=4;INTERVAL=1;BYMONTHDAY=1");
		
		org.joda.time.LocalDate recStart = calculateRecurrenceStart(recur, rstart, estart, etz).toLocalDate();
		if (!"2019-11-01".equals(recStart.toString())) throw new Exception("Fail");
		
		org.joda.time.DateTime recEnd = calculateRecurrenceEnd(recur, rstart, estart, eend, etz);
		if (!"2020-02-01T00:00:00.000+01:00".equals(recEnd.toString())) throw new Exception("Fail");
		
		List<org.joda.time.LocalDate> recSet = calculateRecurrenceSet(recur, rstart, null, ead, estart, eend, etz, null, null, -1);
		if (recSet.size() != 4) throw new Exception("Fail");
		if (!"2019-11-01".equals(recSet.get(0).toString())) throw new Exception("Fail");
		if (!"2019-12-01".equals(recSet.get(1).toString())) throw new Exception("Fail");
		if (!"2020-01-01".equals(recSet.get(2).toString())) throw new Exception("Fail");
		if (!"2020-02-01".equals(recSet.get(3).toString())) throw new Exception("Fail");
	}
	
	/**
	 * WTCALENDAR-91
	 * @throws Exception 
	 */
	public static void recur3days2times() throws Exception {
		boolean ead = true;
		org.joda.time.DateTimeZone etz = org.joda.time.DateTimeZone.forID("Europe/Rome");
		org.joda.time.DateTime estart = new org.joda.time.DateTime(2019, 11, 4, 0, 0, 0, etz);
		org.joda.time.DateTime eend = new org.joda.time.DateTime(2019, 11, 6, 0, 0, 0, etz);
		org.joda.time.DateTime rstart = new org.joda.time.DateTime(2019, 11, 4, 0, 0, 0, etz);
		Recur recur = new Recur("FREQ=WEEKLY;COUNT=2;INTERVAL=1");
		
		org.joda.time.LocalDate recStart = calculateRecurrenceStart(recur, rstart, estart, etz).toLocalDate();
		if (!"2019-11-04".equals(recStart.toString())) throw new Exception("Fail");
		
		org.joda.time.DateTime recEnd = calculateRecurrenceEnd(recur, rstart, estart, eend, etz);
		if (!"2019-11-11T00:00:00.000+01:00".equals(recEnd.toString())) throw new Exception("Fail");
		
		List<org.joda.time.LocalDate> recSet = calculateRecurrenceSet(recur, rstart, null, ead, estart, eend, etz, null, null, -1);
		if (recSet.size() != 2) throw new Exception("Fail");
		if (!"2019-11-04".equals(recSet.get(0).toString())) throw new Exception("Fail");
		if (!"2019-11-11".equals(recSet.get(1).toString())) throw new Exception("Fail");
	}
	
	public static void recur1day2times() throws Exception {
		boolean ead = false;
		org.joda.time.DateTimeZone etz = org.joda.time.DateTimeZone.forID("Europe/Rome");
		org.joda.time.DateTime estart = new org.joda.time.DateTime(2020, 1, 13, 12, 0, 0, etz);
		org.joda.time.DateTime eend = new org.joda.time.DateTime(2020, 1, 13, 12, 30, 0, etz);
		org.joda.time.DateTime rstart = new org.joda.time.DateTime(2020, 1, 13, 0, 0, 0, etz);
		Recur recur = new Recur("FREQ=DAILY;COUNT=5;INTERVAL=1");
		Set<org.joda.time.LocalDate> rexdates = new java.util.LinkedHashSet<>(Arrays.asList(
				new org.joda.time.LocalDate(2020, 1, 13)
		));
		
		org.joda.time.LocalDate recStart = calculateRecurrenceStart(recur, rstart, estart, etz).toLocalDate();
		if (!"2020-01-13".equals(recStart.toString())) throw new Exception("Fail");
		
		List<org.joda.time.LocalDate> recSet = calculateRecurrenceSet(recur, rstart, rexdates, ead, estart, eend, etz, null, null, -1);
		if (recSet.size() != 4) throw new Exception("Fail");
	}
	
	
	public static void main(String[] args) {
		try {
			org.joda.time.DateTimeZone rome = org.joda.time.DateTimeZone.forID("Europe/Rome");
			java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone("Europe/Riga"));
			recur8days4times();
			recur3days2times();
			recur1day2times();
			recur10times();
			
			org.joda.time.DateTimeZone jTz = org.joda.time.DateTimeZone.forID("Europe/Rome");
			org.joda.time.DateTime jDt = new org.joda.time.DateTime(2020, 01, 14, 12, 0, 0, jTz);
			DateTime icDt1 = toIC4jDateTime(jDt, jTz, true);
			DateTime icDtUtc1 = toIC4jDateTimeUTC(jDt);
			
			java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone("Europe/Riga"));
			
			DateTime icDt2 = toIC4jDateTime(jDt, jTz, true);
			DateTime icDtUtc2 = toIC4jDateTimeUTC(jDt);
			
			java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone("Europe/Riga"));
			
			
			/*
			java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone("Europe/Riga"));
			
			net.fortuna.ical4j.model.Calendar cal = ICalendarUtils.parse(new FileInputStream("C:/calendar.ics"));
			net.fortuna.ical4j.model.component.VEvent ve = (VEvent)cal.getComponents().get(0);
			
			org.joda.time.DateTime start = null;
			org.joda.time.DateTime end = null;
			org.joda.time.DateTimeZone defaultTz = org.joda.time.DateTimeZone.forID("Europe/Rome");
			boolean isAllDay = ICal4jUtils.isAllDay(ve);
			if (isAllDay) {
				start = ICal4jUtils.toJodaLocalDate(ve.getStartDate().getDate(), defaultTz).toDateTimeAtStartOfDay(defaultTz);
				end = ICal4jUtils.toJodaLocalDate(ve.getEndDate().getDate(), defaultTz).minusDays(1).toDateTime(new org.joda.time.LocalTime(23, 59, 59, 0), defaultTz);

			} else {
				start = ICal4jUtils.toJodaDateTime((DateTime)ve.getStartDate().getDate(), defaultTz);
				end = ICal4jUtils.toJodaDateTime((DateTime)ve.getEndDate().getDate(), defaultTz);
			}
			DateTimeZone eventTimezone = start.getZone();
			*/
			
			//https://theeventscalendar.com/support/forums/topic/issue-with-timezones-and-all-day-events-cont/
			//org.joda.time.DateTime xxx1 = ICal4jUtils.toJodaDateTime((DateTime)ve.getStartDate().getDate());
			//org.joda.time.DateTime xxx2 = ICal4jUtils.toJodaDateTime((DateTime)ve.getEndDate().getDate());
			//TZID=Europe/Rome:
			//TZID=Europe/Rome:20180606T113000
			//String a = xxx2.toString();
			
		} catch(Throwable t) {
			System.out.println(t.getMessage());
		}
	}
}
