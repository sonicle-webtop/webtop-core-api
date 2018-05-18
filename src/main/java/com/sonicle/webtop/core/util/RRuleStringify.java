/*
 * Copyright (C) 2018 Sonicle S.r.l.
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
 * display the words "Copyright (C) 2018 Sonicle S.r.l.".
 */
package com.sonicle.webtop.core.util;

import com.sonicle.commons.time.DateTimeUtils;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Locale;
import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.NumberList;
import net.fortuna.ical4j.model.Recur;
import net.fortuna.ical4j.model.WeekDay;
import net.fortuna.ical4j.model.WeekDayList;
import net.fortuna.ical4j.model.property.RRule;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author malbinola
 */
public class RRuleStringify {
	private static final String DEFAULT_DATE_FORMAT = "dd/MM/yyyy";
	private static final String DEFAULT_TIME_FORMAT = "HH:mm";
	private Strings strings;
	private DateTimeZone timezone;
	private String dateFormat;
	private String timeFormat;
	
	public RRuleStringify(Strings strings, DateTimeZone timezone) {
		this(strings, timezone, DEFAULT_DATE_FORMAT, DEFAULT_TIME_FORMAT);
	}
	
	public RRuleStringify(Strings strings, DateTimeZone timezone, String dateFormat, String timeFormat) {
		this.strings = strings;
		this.timezone = timezone;
		this.dateFormat = dateFormat;
		this.timeFormat = timeFormat;
	}
	
	public void setStrings(Strings strings) {
		this.strings = strings;
	}
	
	public void setDateTimeZone(DateTimeZone timezone) {
		this.timezone = timezone;
	}
	
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	
	public void setTimeFormat(String timeFormat) {
		this.timeFormat = timeFormat;
	}
	
	public String toHumanReadableFrequency(String rr) throws Exception {
		return toHumanReadableFrequency(new RRule(rr));
	}
	
	public String toHumanReadableFrequency(RRule rr) throws Exception {
		Recur recur = rr.getRecur();
		return frequencyString(recur.getFrequency());
	}
	
	public String toHumanReadableText(String rr) throws Exception {
		return toHumanReadableText(new RRule(rr));
	}
	
	public String toHumanReadableText(RRule rr) throws Exception {
		StringBuilder sb = new StringBuilder();
		Recur recur = rr.getRecur();
		
		if (Recur.DAILY.equals(recur.getFrequency())) {
			stringifyDaily(sb, recur);
		} else if (Recur.WEEKLY.equals(recur.getFrequency())) {
			stringifyWeekly(sb, recur);
		} else if (Recur.MONTHLY.equals(recur.getFrequency())) {
			stringifyMonthly(sb, recur);
		} else if (Recur.YEARLY.equals(recur.getFrequency())) {
			stringifyYearly(sb, recur);
		}
		stringifyEnd(sb, recur);
		
		return sb.toString();
	}
	
	private void stringifyDaily(StringBuilder sb, Recur recur) throws Exception {
		WeekDayList bydayList = recur.getDayList();
		if (bydayList.isEmpty()) {
			if (recur.getInterval() <= 1) {
				// E.g. Every day
				sb.append(strings.onEvery);
				sb.append(" ");
				sb.append(strings.day);
			} else {
				// E.g. Every 2 days
				sb.append(strings.onEvery);
				sb.append(" ");
				sb.append(String.valueOf(recur.getInterval()));
				sb.append(" ");
				sb.append(strings.days);
			}
		} else {
			// E.g. Every weekdays
			if (!isWeekdayDayList(bydayList)) throw new Exception("Unsupported configuration [BYDAY]");
			sb.append(strings.onEvery);
			sb.append(" ");
			sb.append(strings.weekdays);
		}	
	}
	
	private void stringifyWeekly(StringBuilder sb, Recur recur) throws Exception {
		if (recur.getInterval() <= 1) {
			// E.g. Every week
			sb.append(strings.onEvery);
			sb.append(" ");
			sb.append(strings.week);
		} else {
			// E.g. Every 2 weeks
			sb.append(strings.onEvery);
			sb.append(" ");
			sb.append(String.valueOf(recur.getInterval()));
			sb.append(" ");
			sb.append(strings.weeks);
		}
		
		// Have specific weekdays been specified? E.g. Weekly on Tuesday, Wednesday and Thursday
		WeekDayList bydayList = recur.getDayList();
		if (!bydayList.isEmpty()) {
			sb.append(" ");
			sb.append(strings.on);
			sb.append(" ");
			
			int len = bydayList.size();
			for (int i=0; i<len; i++) {
				if (i > 0 && i < len-1) {
					sb.append(", ");
				} else if (len > 1 && i == len-1) {
					sb.append(" ");
					sb.append(strings.and);
					sb.append(" ");
				}
				// If more than 2 weekdays have been specified, use short day names, otherwise long day names.
				sb.append(weekdayNameString(bydayList.get(i).getDay(), len > 2));
			}
		}	
	}
	
	private void stringifyMonthly(StringBuilder sb, Recur recur) throws Exception {
		if (recur.getInterval() <= 1) {
			// E.g. Monthly
			sb.append(strings.onEvery);
			sb.append(" ");
			sb.append(strings.month);
		} else {
			// E.g. Every 2 months
			sb.append(strings.onEvery);
			sb.append(" ");
			sb.append(String.valueOf(recur.getInterval()));
			sb.append(" ");
			sb.append(strings.months);
		}
		
		NumberList bysetposList = recur.getSetPosList();
		NumberList bymonthdayList = recur.getMonthDayList();
		
		if (!bysetposList.isEmpty()) {
			// A numbered weekday of the month has been selected, e.g. Monthly on the first Monday
			if (bysetposList.size() > 1) throw new Exception("Unsupported configuration [BYSETPOS]");
			int nth = bysetposList.get(0);
			if (!isNthSetpos(nth)) throw new Exception("Unsupported configuration [BYSETPOS]");
			
			WeekDayList bydayList = recur.getDayList();
			if (bydayList.size() != 1) throw new Exception("Unsupported configuration [BYDAY]");
			
			sb.append(", ");
			sb.append(strings.onthe);
			sb.append(" ");
			sb.append(nthString(nth));
			sb.append(" ");
			sb.append(weekdayNameString(bydayList.get(0).getDay(), false));
			
		} else if (!bymonthdayList.isEmpty()) {
			// A specific month day has been selected, e.g. Monthly on day 23.
			if (bymonthdayList.size() > 1) throw new Exception("Unsupported configuration [BYMONTHDAY]");
			
			sb.append(", ");
			sb.append(strings.on);
			sb.append(" ");
			sb.append(strings.day);
			sb.append(" ");
			sb.append(String.valueOf(bymonthdayList.get(0).intValue()));
		}
	}
	
	private void stringifyYearly(StringBuilder sb, Recur recur) throws Exception {
		if (recur.getInterval() <= 1) {
			// E.g. Yearly
			sb.append(strings.onEvery);
			sb.append(" ");
			sb.append(strings.year);
		} else {
			// E.g. Every 2 years
			sb.append(strings.onEvery);
			sb.append(" ");
			sb.append(String.valueOf(recur.getInterval()));
			sb.append(" ");
			sb.append(strings.years);
		}
		
		NumberList bysetposList = recur.getSetPosList();
		NumberList bymonthList = recur.getMonthList();
		NumberList bymonthdayList = recur.getMonthDayList();
		
		if (!bysetposList.isEmpty()) {
			
			if (bysetposList.size() > 1) throw new Exception("Unsupported configuration [BYSETPOS]");
			int nth = bysetposList.get(0);
			if (!isNthSetpos(nth)) throw new Exception("Unsupported configuration [BYSETPOS]");
			
			WeekDayList bydayList = recur.getDayList();
			if (bydayList.size() != 1) throw new Exception("Unsupported configuration [BYDAY]");
			
			NumberList bymonthList2 = recur.getMonthList();
			if (bymonthList2.size() != 1) throw new Exception("Unsupported configuration [BYMONTH]");
			
			sb.append(", ");
			sb.append(strings.onthe);
			sb.append(" ");
			sb.append(nthString(nth));
			sb.append(" ");
			sb.append(weekdayNameString(bydayList.get(0).getDay(), false));
			sb.append(" ");
			sb.append(strings.of);
			sb.append(monthNameString(bymonthList2.get(0)));
			
		} else if (!bymonthList.isEmpty() && !bymonthdayList.isEmpty()) {
			if (bymonthList.size() > 1) throw new Exception("Unsupported configuration [BYMONTH]");
			if (bymonthdayList.size() > 1) throw new Exception("Unsupported configuration [BYMONTHDAY]");
			
			sb.append(", ");
			sb.append(strings.on);
			sb.append(" ");
			sb.append(strings.day);
			sb.append(" ");
			sb.append(String.valueOf(bymonthdayList.get(0).intValue()));
			sb.append(" ");
			sb.append(monthNameString(bymonthdayList.get(0)));
		}
	}
	
	private void stringifyEnd(StringBuilder sb, Recur recur) throws ParseException {
		if (recur.getCount() > 0) {
			sb.append(", ");
			stringifyCount(sb, recur.getCount());
		} else if (recur.getUntil() != null) {
			sb.append(", ");
			stringifyUntil(sb, recur.getUntil());
		}
	}
	
	private void stringifyCount(StringBuilder sb, int count) {
		sb.append(String.valueOf(count));
		sb.append(" ");
		sb.append((count == 1) ? strings.time : strings.times);
	}
	
	private void stringifyUntil(StringBuilder sb, Date until) {
		DateTimeFormatter fmt = DateTimeUtils.createFormatter(dateFormat, timezone);
		sb.append(strings.endsBy);
		sb.append(" ");
		sb.append(fmt.print(ICal4jUtils.toJodaDateTime(until, DateTimeZone.UTC)));
	}
	
	private boolean isWeekdayDayList(WeekDayList list) {
		if (list.size() != 5) return false;
		if (!list.contains(WeekDay.MO)) return false;
		if (!list.contains(WeekDay.TU)) return false;
		if (!list.contains(WeekDay.WE)) return false;
		if (!list.contains(WeekDay.TH)) return false;
		if (!list.contains(WeekDay.FR)) return false;
		return true;
	}
	
	private boolean isWeekendDayList(WeekDayList list) {
		if (list.size() != 2) return false;
		if (!list.contains(WeekDay.SA)) return false;
		if (!list.contains(WeekDay.SU)) return false;
		return true;
	}
	
	private boolean isNthSetpos(int nth) {
		if (nth == 1) return true;
		if (nth == 2) return true;
		if (nth == 3) return true;
		if (nth == 4) return true;
		if (nth == -2) return true;
		if (nth == -1) return true;
		return false;
	}
	
	private String frequencyString(String freq) {
		if (Recur.SECONDLY.equals(freq)) {
			return strings.freqSecondly;
		} else if (Recur.MINUTELY.equals(freq)) {
			return strings.freqMinutely;
		} else if (Recur.HOURLY.equals(freq)) {
			return strings.freqHourly;
		} else if (Recur.DAILY.equals(freq)) {
			return strings.freqDaily;
		} else if (Recur.WEEKLY.equals(freq)) {
			return strings.freqWeekly;
		} else if (Recur.MONTHLY.equals(freq)) {
			return strings.freqMonthly;
		} else if (Recur.YEARLY.equals(freq)) {
			return strings.freqYearly;
		} else {
			return null;
		}
	}
	
	private String nthString(int nth) {
		if (nth == 1) {
			return strings.nth1st;
		} else if (nth == 2) {
			return strings.nth2nd;
		} else if (nth == 3) {
			return strings.nth3rd;
		} else if (nth == 4) {
			return strings.nth4th;
		} else if (nth == -2) {
			return strings.nthLast2nd;
		} else if (nth == -1) {
			return strings.nthLast;
		} else {
			return null;
		}
	}
	
	private String weekdayNameString(WeekDay.Day day, boolean shortName) {
		if (WeekDay.Day.MO.equals(day)) {
			return shortName ? strings.dayNameShortMO : strings.dayNameLongMO;
		} else if (WeekDay.Day.TU.equals(day)) {
			return shortName ? strings.dayNameShortTU : strings.dayNameLongTU;
		} else if (WeekDay.Day.WE.equals(day)) {
			return shortName ? strings.dayNameShortWE : strings.dayNameLongWE;
		} else if (WeekDay.Day.TH.equals(day)) {
			return shortName ? strings.dayNameShortTH : strings.dayNameLongTH;
		} else if (WeekDay.Day.FR.equals(day)) {
			return shortName ? strings.dayNameShortFR : strings.dayNameLongFR;
		} else if (WeekDay.Day.SA.equals(day)) {
			return shortName ? strings.dayNameShortSA : strings.dayNameLongSA;
		} else if (WeekDay.Day.SU.equals(day)) {
			return shortName ? strings.dayNameShortSU : strings.dayNameLongSU;
		} else {
			return null;
		}
	}
	
	private String monthNameString(int month) {
		if (month == 1) {
			return strings.monthNameLongJan;
		} else if (month == 2) {
			return strings.monthNameLongFeb;
		} else if (month == 3) {
			return strings.monthNameLongMar;
		} else if (month == 4) {
			return strings.monthNameLongApr;
		} else if (month == 5) {
			return strings.monthNameLongMay;
		} else if (month == 6) {
			return strings.monthNameLongJun;
		} else if (month == 7) {
			return strings.monthNameLongJul;
		} else if (month == 8) {
			return strings.monthNameLongAug;
		} else if (month == 9) {
			return strings.monthNameLongSep;
		} else if (month == 10) {
			return strings.monthNameLongOct;
		} else if (month == 11) {
			return strings.monthNameLongNov;
		} else if (month == 12) {
			return strings.monthNameLongDec;
		} else {
			return null;
		}
	}
	
	public static class Strings {
		public String dayNameShortMO;
		public String dayNameShortTU;
		public String dayNameShortWE;
		public String dayNameShortTH;
		public String dayNameShortFR;
		public String dayNameShortSA;
		public String dayNameShortSU;
		public String dayNameLongMO;
		public String dayNameLongTU;
		public String dayNameLongWE;
		public String dayNameLongTH;
		public String dayNameLongFR;
		public String dayNameLongSA;
		public String dayNameLongSU;
		public String monthNameLongJan;
		public String monthNameLongFeb;
		public String monthNameLongMar;
		public String monthNameLongApr;
		public String monthNameLongMay;
		public String monthNameLongJun;
		public String monthNameLongJul;
		public String monthNameLongAug;
		public String monthNameLongSep;
		public String monthNameLongOct;
		public String monthNameLongNov;
		public String monthNameLongDec;
		public String freqSecondly;
		public String freqMinutely;
		public String freqHourly;
		public String freqDaily;
		public String freqWeekly;
		public String freqMonthly;
		public String freqYearly;
		public String onEvery; // Eg. (Every) 2 days
		public String day; // Eg. Every (day)
		public String days; // Eg. Every 2 (days)
		public String weekday; // Eg. Every (weekday)
		public String weekdays; // Eg. weekdays
		public String week; // Eg. Every (week)
		public String weeks; // Eg. Every 2 (weeks)
		public String month; // Eg. Every (month)
		public String months; // Eg. Every 2 (months)
		public String year; // Eg. Every (year)
		public String years; // Eg. Every 2 (years)
		public String and; // Eg. and
		public String on;
		public String of;
		public String onthe;
		public String time;
		public String times;
		public String endsBy;
		public String nth1st;
		public String nth2nd;
		public String nth3rd;
		public String nth4th;
		public String nthLast2nd;
		public String nthLast;
		
		public Strings(Locale locale) {
			String[] shortDayNames = DateTimeUtils.getDayNamesShort(locale);
			dayNameShortMO = shortDayNames[Calendar.MONDAY];
			dayNameShortTU = shortDayNames[Calendar.TUESDAY];
			dayNameShortWE = shortDayNames[Calendar.WEDNESDAY];
			dayNameShortTH = shortDayNames[Calendar.THURSDAY];
			dayNameShortFR = shortDayNames[Calendar.FRIDAY];
			dayNameShortSA = shortDayNames[Calendar.SATURDAY];
			dayNameShortSU = shortDayNames[Calendar.SUNDAY];
			String[] longDayNames = DateTimeUtils.getDayNamesLong(locale);
			dayNameLongMO = longDayNames[Calendar.MONDAY];
			dayNameLongTU = longDayNames[Calendar.TUESDAY];
			dayNameLongWE = longDayNames[Calendar.WEDNESDAY];
			dayNameLongTH = longDayNames[Calendar.THURSDAY];
			dayNameLongFR = longDayNames[Calendar.FRIDAY];
			dayNameLongSA = longDayNames[Calendar.SATURDAY];
			dayNameLongSU = longDayNames[Calendar.SUNDAY];
			String[] longMonthNames = DateTimeUtils.getMonthNamesShort(locale);
			monthNameLongJan = longMonthNames[Calendar.JANUARY];
			monthNameLongFeb = longMonthNames[Calendar.FEBRUARY];
			monthNameLongMar = longMonthNames[Calendar.MARCH];
			monthNameLongApr = longMonthNames[Calendar.APRIL];
			monthNameLongMay = longMonthNames[Calendar.MAY];
			monthNameLongJun = longMonthNames[Calendar.JUNE];
			monthNameLongJul = longMonthNames[Calendar.JULY];
			monthNameLongAug = longMonthNames[Calendar.AUGUST];
			monthNameLongSep = longMonthNames[Calendar.SEPTEMBER];
			monthNameLongOct = longMonthNames[Calendar.OCTOBER];
			monthNameLongNov = longMonthNames[Calendar.NOVEMBER];
			monthNameLongDec = longMonthNames[Calendar.DECEMBER];
		}
	}
}
