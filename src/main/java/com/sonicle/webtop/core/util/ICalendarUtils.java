/*
 * WebTop Services is a Web Application framework developed by Sonicle S.r.l.
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
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program; if not, see http://www.gnu.org/licenses or write to
 * the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301 USA.
 *
 * You can contact Sonicle S.r.l. at email address sonicle@sonicle.com
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
import com.sonicle.commons.MailUtils;
import com.sonicle.commons.time.DateTimeUtils;
import com.sonicle.webtop.core.util.ical4j.model.property.PreferredLanguage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Iterator;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.data.CalendarParser;
import net.fortuna.ical4j.data.CalendarParserFactory;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.ComponentList;
import net.fortuna.ical4j.model.ParameterFactoryRegistry;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.PropertyFactoryRegistry;
import net.fortuna.ical4j.model.PropertyList;
import net.fortuna.ical4j.model.TimeZone;
import net.fortuna.ical4j.model.TimeZoneRegistry;
import net.fortuna.ical4j.model.TimeZoneRegistryFactory;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.parameter.PartStat;
import net.fortuna.ical4j.model.property.Attendee;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.LastModified;
import net.fortuna.ical4j.model.property.Method;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Transp;
import net.fortuna.ical4j.model.property.Uid;
import net.fortuna.ical4j.model.property.Version;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTimeZone;

/**
 *
 * @author malbinola
 */
public class ICalendarUtils {
	
	public static void setUnfoldingRelaxed(boolean value) {
		System.setProperty("ical4j.unfolding.relaxed", String.valueOf(value));
	}
	
	public static void setParsingRelaxed(boolean value) {
		System.setProperty("ical4j.parsing.relaxed", String.valueOf(value));
	}
	
	public static void setValidationRelaxed(boolean value) {
		System.setProperty("ical4j.validation.relaxed", String.valueOf(value));
	}
	
	public static void setCompatibilityOutlook(boolean value) {
		System.setProperty("ical4j.compatibility.outlook", String.valueOf(value));
	}
	
	public static void setCompatibilityNotes(boolean value) {
		System.setProperty("ical4j.compatibility.notes", String.valueOf(value));
	}
	
	public static void relaxParsingAndCompatibility() {
		relaxParsing();
		relaxCompatibility();
	}
	
	public static void relaxParsing() {
		setUnfoldingRelaxed(true);
		setParsingRelaxed(true);
		setValidationRelaxed(true);
	}
	
	public static void relaxCompatibility() {
		setCompatibilityOutlook(true);
		setCompatibilityNotes(true);
	}
	
	public static Calendar parse(String s) throws IOException, ParserException {
		return createCalendarBuilder().build(new StringReader(s));
	}
	
	public static Calendar parse(InputStream is) throws ParserException, IOException {
		return createCalendarBuilder().build(is);
	}
	
	public static CalendarBuilder createCalendarBuilder() {
		CalendarParser parser = CalendarParserFactory.getInstance().createParser();
		PropertyFactoryRegistry propertyRegistry = new PropertyFactoryRegistry();
		propertyRegistry.register(PreferredLanguage.PROPERTY_NAME, PreferredLanguage.FACTORY);
		ParameterFactoryRegistry parameterRegistry = new ParameterFactoryRegistry();
		TimeZoneRegistry tzRegistry = TimeZoneRegistryFactory.getInstance().createRegistry();
		return new CalendarBuilder(parser, propertyRegistry, parameterRegistry, tzRegistry);
	}
	
	/**
	 * Extract the first VEvent's from a calendar object.
	 * @param ical The Calendar object
	 * @return The first VEvent object or null if not found
	 */
	public static VEvent getVEvent(Calendar ical) {
		ComponentList cl = ical.getComponents();
		for (Iterator cIt = cl.iterator(); cIt.hasNext();) {
			Component component = (Component) cIt.next();
			if (component instanceof VEvent) return (VEvent)component;
		}
		return null;
	}
	
	/**
	 * Extract VEvent's uid from a calendar object.
	 * Only the first VEvent element will be taken into account.
	 * This method should be used only on an invitation object (that 
	 * brings with it only a single VEvent).
	 * @param ical The Calendar object
	 * @return The VEvent's Uid or null if not found
	 */
	public static String getVEventUid(Calendar ical) {
		VEvent ve = getVEvent(ical);
		return (ve == null) ? null : getUidValue(ve);
	}
	
	/**
	 * Returns the first attendee in the VEvent object.
	 * @param ve The VEvent object
	 * @return The first attendee or null if not present
	 */
	public static Attendee getAttendee(VEvent ve) {
		PropertyList atts = ve.getProperties(Property.ATTENDEE);
		for (Iterator attIt = atts.iterator(); attIt.hasNext();) {
			return (Attendee) attIt.next();
		}
		return null;
	}
	
	/**
	 * Returns the Uid value of a VEvent component, if provided, or null otherwise.
	 * @param ve The VEvent
	 * @return Uid value
	 */
	public static String getUidValue(VEvent ve) {
		Uid uid = ve.getUid();
		return (uid != null) ? uid.getValue() : null;
	}
	
	/**
	 * Prints some reference data of the passed VEvent component.
	 * @param ve The component.
	 * @return The string dump
	 */
	public static String print(VEvent ve) {
		if (ve == null) return null;
		String uid = (ve.getUid() != null) ? ve.getUid().getValue() : null;
		String summ = (ve.getSummary() != null) ? ve.getSummary().getValue() : null;
		return LangUtils.joinStrings(", ", uid, summ);
	}
	
	public static boolean isBusy(Transp transparency) {
		return !StringUtils.equals(transparency.getValue(), "TRANSPARENT");
	}
	
	public static TimeZone guessTimeZone(TimeZone tz, DateTimeZone defaultTz) {
		if (tz == null) return ICal4jUtils.toIC4jTimezone(defaultTz.getID());
		
		// During iCal import we can found non standard timezones coming from
		// custom/private timezone database implementation.
		// If we make a call to registry.getTimeZone() it ensures that a 
		// cleared timezone will be returned.
			// Calling .getTimeZone() using "/inverse.ca/20091015_1/Europe/Rome" 
		// we get back "Europe/Rome"; thats we are looking for.
		TimeZone guessedTz = ICal4jUtils.toIC4jTimezone(tz.getID());
		return (guessedTz != null) ? guessedTz : ICal4jUtils.toIC4jTimezone(defaultTz.getID());
	}
	
	public static String buildUid(String id, String internetName) {
		return id + "@" + internetName;
	}
	
	public static String buildProdId(String product) {
		return "-//Sonicle//" + product + "//EN";
	}
	
	public static String buildProdId(String company, String product) {
		return "-//" + company + "//" + product + "//EN";
	}
	
	public static String calendarToString(Calendar ical) throws IOException {
		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			CalendarOutputter outputter = new CalendarOutputter();
			outputter.output(ical, baos);
			return baos.toString("UTF8");
		} finally {
			IOUtils.closeQuietly(baos);
		}
	}
	
	public static Calendar newCalendar(String prodId, Method method) {
		Calendar ical = new Calendar();
		ical.getProperties().add(new ProdId(prodId));
		ical.getProperties().add(Version.VERSION_2_0);
		ical.getProperties().add(CalScale.GREGORIAN);
		if (method != null) ical.getProperties().add(method);
		return ical;
	}
	
	public static MimeMultipart createInvitationPart(String htmlText, MimeBodyPart calendarPart, MimeBodyPart attachmentPart) throws MessagingException {
		MimeMultipart altPart = new MimeMultipart("alternative");
		if (!StringUtils.isBlank(htmlText)) MailUtils.addHtmlBodyPart(altPart, htmlText, true);
		altPart.addBodyPart(calendarPart);
		MimeBodyPart altwPart = new MimeBodyPart();
		altwPart.setContent(altPart);

		MimeMultipart mixPart = new MimeMultipart("mixed");
		mixPart.addBodyPart(altwPart);
		mixPart.addBodyPart(attachmentPart);
		
		return mixPart;
	}
	
	public static MimeBodyPart createInvitationAttachmentPart(String icalText, String filename) throws MessagingException {
		MimeBodyPart part = new MimeBodyPart();
		part.setContent(icalText, MailUtils.buildPartContentType("application/ics", "UTF-8"));
		part.setFileName(filename);
		return part;
	}
	
	public static MimeBodyPart createInvitationCalendarPart(Method icalMethod, String icalText) throws MessagingException {
		String method = toMimePartMethod(icalMethod);
		MimeBodyPart part = new MimeBodyPart();
		part.setContent(icalText, MailUtils.buildPartContentType("text/calendar", "UTF-8", method));
		return part;
	}
	
	public static String toMimePartMethod(Method icalMethod) {
		if (Method.REPLY.equals(icalMethod)) {
			return "REPLY";
		} else if (Method.CANCEL.equals(icalMethod)) {
			return "CANCEL";
		} else {
			return "REQUEST";
		}
	}
	
	public static String buildICalendarAttachmentFilename(String platformName) {
		return platformName.toLowerCase() + "-invite.ics";
	}
	
	public static Calendar buildInvitationReply(Calendar ical, String prodId, InternetAddress forAddress, PartStat response) throws URISyntaxException, ParseException, IOException {
		Calendar nical = new Calendar(ical);
		PropertyList plist = nical.getProperties();
		plist.remove(plist.getProperty(Property.METHOD));
		plist.add(Method.REPLY);
		plist.remove(plist.getProperty(Property.PRODID));
		plist.add(new ProdId(prodId));
		
		VEvent ve = getVEvent(nical);
		ve.getAlarms().clear(); // Clear any defined alarms
		PropertyList props = ve.getProperties();
		
		props.remove(props.getProperty(Property.DESCRIPTION));
		props.remove(props.getProperty(Property.LAST_MODIFIED));
		props.remove(props.getProperty(Property.CREATED));
		props.remove(props.getProperty(Property.LOCATION));
		props.remove(props.getProperty(Property.STATUS));
		props.add(new LastModified(ICal4jUtils.createDateTime(DateTimeUtils.now(true))));

		// Iterates over attendees...
		PropertyList atts = ve.getProperties(Property.ATTENDEE);
		props.removeAll(atts);
		Attendee matchingAtt = null;
		for (Iterator attIt = atts.iterator(); attIt.hasNext();) {
			final Attendee att = (Attendee) attIt.next();

			// We are looking for a specific attendee...
			URI uri = att.getCalAddress();
			if(StringUtils.equalsIgnoreCase(uri.getSchemeSpecificPart(), forAddress.getAddress())) {
				att.getParameters().replace(response);
				matchingAtt = att;
				break;
			}
		}
		
		if (matchingAtt == null) {
			return null;
		} else {
			props.add(matchingAtt);
			return nical;
		}
	}
}
