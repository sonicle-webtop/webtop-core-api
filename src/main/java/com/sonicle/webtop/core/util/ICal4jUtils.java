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

import java.net.SocketException;
import java.text.ParseException;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.Period;
import net.fortuna.ical4j.model.PeriodList;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.Recur;
import net.fortuna.ical4j.model.TimeZone;
import net.fortuna.ical4j.model.TimeZoneRegistry;
import net.fortuna.ical4j.model.TimeZoneRegistryFactory;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.DtStamp;
import net.fortuna.ical4j.model.property.RRule;
import net.fortuna.ical4j.util.UidGenerator;
import org.joda.time.DateTimeZone;

/**
 *
 * @author malbinola
 */
public class ICal4jUtils {
	//public final static TimeZoneRegistry tzRegistry = new TimeZoneRegistryImpl();
	public final static TimeZoneRegistry tzRegistry = TimeZoneRegistryFactory.getInstance().createRegistry();
	
	public static TimeZone getTimeZone(String timezoneId) {
		return tzRegistry.getTimeZone(timezoneId);
	}
	
	public static TimeZone getTimeZone(org.joda.time.DateTimeZone tz) {
		return getTimeZone(tz.getID());
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
	
	public static void addProperty(Component component, Property property) {
		component.getProperties().add(property);
	}
	
	public static void addOrReplaceProperty(Component component, Property property) {
		Property oldProp = component.getProperties().getProperty(property.getName());
		if(oldProp != null) component.getProperties().remove(oldProp);
		addProperty(component, property);
	}
	
	public static DateTime createDateTime(org.joda.time.DateTime dt) {
		DateTime dt1 = new DateTime(dt.toDate());
		if(dt.getZone().equals(org.joda.time.DateTimeZone.UTC)) {
			dt1.setUtc(true);
		} else {
			dt1.setTimeZone(getTimeZone(dt.getZone().getID()));
		}
		return dt1;
	}
	
	public static org.joda.time.DateTime fromICal4jDate(Date date, TimeZone timezone) {
		org.joda.time.DateTimeZone tz = org.joda.time.DateTimeZone.forID(timezone.getID());
		return fromICal4jDate(date, tz);
	}
	
	public static org.joda.time.DateTime fromICal4jDate(Date date, org.joda.time.DateTimeZone tz) {
		/*
		org.joda.time.LocalDate ld = new org.joda.time.LocalDate(date.getTime());
		DateTimeZone tz = DateTimeZone.forID(timezone.getID());
		return new org.joda.time.DateTime(tz).withDate(ld);
		*/
		return new org.joda.time.DateTime(date.getTime(), tz);
	}
	
	public static org.joda.time.DateTime toJodaDateTime(DateTime date) {
		return new org.joda.time.DateTime(date, org.joda.time.DateTimeZone.forID(date.getTimeZone().getID()));
	}
	
	public static org.joda.time.DateTime toJodaDateTime(Date date, org.joda.time.DateTimeZone tz) {
		return new org.joda.time.DateTime(date, tz);
	}
	
	public static Period toICal4jPeriod(org.joda.time.DateTime start, org.joda.time.DateTime end, org.joda.time.DateTimeZone tz) {
		return new Period(toICal4jDateTime(start, tz), toICal4jDateTime(end, tz));
	}
	
	/**
	 * @deprecated use toIC4jDateTimeUTC() or toIC4jDateTimeLocal() instead
	 */
	public static DateTime toICal4jDateTime(org.joda.time.DateTime dateTime, org.joda.time.DateTimeZone timezone) {
		DateTime dt = new DateTime(dateTime.toDate());
		if (timezone != null) {
			dt.setTimeZone(tzRegistry.getTimeZone(timezone.getID()));
		}
		return dt;
	}
	
	/**
	 * Creates an iCal4j DateTime with UTC time.
	 * The date with UTC time, or absolute time, is identified by a LATIN
	 * CAPITAL LETTER Z suffix character, the UTC designator, appended to
	 * the time value.  For example, the following represents January 19,
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
	 * Creates an iCal4j DateTime with local time and optionally adds the 
	 * timezone reference.
	 * The date and local time with reference to time zone information is
	 * identified by the use the "TZID" property parameter to reference
	 * the appropriate time zone definition.  "TZID" is discussed in
	 * detail in Section 3.2.19.  For example, the following represents
	 * 2:00 A.M. in New York on January 19, 1998:
	 * TZID=America/New_York:19980119T020000
	 * @param dateTime
	 * @param withZone
	 * @param addZoneReference
	 * @return 
	 */
	public static DateTime toIC4jDateTimeLocal(org.joda.time.DateTime dateTime, org.joda.time.DateTimeZone withZone, boolean addZoneReference) {
		if (withZone != null) {
			final DateTime dt = new DateTime(dateTime.withZone(withZone).toDate().getTime());
			if (addZoneReference) dt.setTimeZone(tzRegistry.getTimeZone(withZone.getID()));
			return dt;
		} else {
			return new DateTime(dateTime.toDate().getTime());
		}
	}
	
	public static org.joda.time.DateTime ifiniteDate() {
		return ifiniteDate(org.joda.time.DateTimeZone.UTC);
	}
	
	public static org.joda.time.DateTime ifiniteDate(org.joda.time.DateTimeZone tz) {
		return new org.joda.time.DateTime(2100, 12, 31, 0, 0, 0, tz);
	}
	
	public static DtStamp createDtStamp(org.joda.time.DateTime dt) {
		return new DtStamp(createDateTime(dt));
	}
	
	
	
	
	
	
	public static org.joda.time.DateTime calculateRecurrenceStart(org.joda.time.DateTime eventStart, RRule rrule, org.joda.time.DateTimeZone tz) {
		return calculateRecurrenceStart(eventStart, rrule.getRecur(), tz);
	}
	
	public static org.joda.time.DateTime calculateRecurrenceStart(org.joda.time.DateTime eventStart, Recur recur, org.joda.time.DateTimeZone tz) {
		Date d = recur.getNextDate(ICal4jUtils.toICal4jDateTime(eventStart, tz), ICal4jUtils.toICal4jDateTime(eventStart.minusDays(1), tz));
		return toJodaDateTime(d, tz);
	}
	
	@Deprecated
	public static org.joda.time.DateTime calculateRecurrenceEnd(org.joda.time.DateTime eventStart, org.joda.time.DateTime eventEnd, RRule rr, org.joda.time.DateTimeZone tz) {
		VEvent vevent = new VEvent(ICal4jUtils.toICal4jDateTime(eventStart, tz), ICal4jUtils.toICal4jDateTime(eventEnd, tz), "");
		vevent.getProperties().add(rr);
		PeriodList periods = vevent.calculateRecurrenceSet(ICal4jUtils.toICal4jPeriod(eventStart, ifiniteDate(), tz));
		if((periods == null) || periods.isEmpty()) return null;
		Period last = (Period)periods.toArray()[periods.size()-1];
		return toJodaDateTime(last.getEnd(), tz);
	}
	
	public static org.joda.time.DateTime calculateRecurEnd(Recur recur, org.joda.time.DateTime eventStart, org.joda.time.DateTime eventEnd, org.joda.time.DateTimeZone eventTz) {
		VEvent veDummy = new VEvent(ICal4jUtils.toICal4jDateTime(eventStart, eventTz), ICal4jUtils.toICal4jDateTime(eventEnd, eventTz), "");
		veDummy.getProperties().add(new RRule(recur));
		
		PeriodList periods = veDummy.calculateRecurrenceSet(ICal4jUtils.toICal4jPeriod(eventStart, ifiniteDate(), eventTz));
		if ((periods == null) || periods.isEmpty()) {
			return null;
		} else {
			Period last = (Period)periods.toArray()[periods.size()-1];
			return toJodaDateTime(last.getEnd(), eventTz);
		}
	}
	
	public static boolean recurHasCount(Recur recur) {
		return recur.getCount() > 0;
	}
	
	public static boolean recurHasUntilDate(Recur recur) {
		return recur.getUntil() != null;
	}
	
	public static boolean recurHasInfiniteEnd(Recur recur) {
		if (recurHasCount(recur)) return false;
		if (recurHasUntilDate(recur)) return false;
		return true;
	}
	
	public static void setRecurUntilDate(Recur recur, org.joda.time.DateTime untilDate) {
		recur.setUntil(toIC4jDateTimeUTC(untilDate.withZone(org.joda.time.DateTimeZone.UTC)));
	}
	
	public static Recur parseRRule(String rrule) {
		try {
			return new Recur(rrule);
		} catch(ParseException ex) {
			return null;
		}
	}
	
	public static PeriodList calculateRecurrenceSet(org.joda.time.DateTime eventStart, org.joda.time.DateTime eventEnd, org.joda.time.DateTime recStart, RRule rr, org.joda.time.DateTime from, org.joda.time.DateTime to, org.joda.time.DateTimeZone tz) {
		org.joda.time.DateTime start, end;
		
		if(eventStart.isEqual(recStart)) {
			start = eventStart;
			end = eventEnd;
		} else {
			int eventDays = org.joda.time.Days.daysBetween(eventStart.toLocalDate(), eventEnd.toLocalDate()).getDays();
			start = eventStart.withDate(recStart.toLocalDate());
			end = eventEnd.withDate(start.plusDays(eventDays).toLocalDate());
		}
		
		VEvent vevent = new VEvent(ICal4jUtils.toICal4jDateTime(start, tz), ICal4jUtils.toICal4jDateTime(end, tz), "");
		vevent.getProperties().add(rr);
		return vevent.calculateRecurrenceSet(ICal4jUtils.toICal4jPeriod(from, to, tz));
	}
	
	
	
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
}
