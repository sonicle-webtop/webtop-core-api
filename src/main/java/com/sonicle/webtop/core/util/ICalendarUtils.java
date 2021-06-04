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
import java.util.Properties;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMultipart;
import java.util.LinkedHashSet;
import java.util.Set;
import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.data.CalendarParser;
import net.fortuna.ical4j.data.CalendarParserFactory;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.ComponentList;
import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.ParameterFactoryRegistry;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.PropertyFactoryRegistry;
import net.fortuna.ical4j.model.PropertyList;
import net.fortuna.ical4j.model.Recur;
import net.fortuna.ical4j.model.TimeZone;
import net.fortuna.ical4j.model.TimeZoneRegistry;
import net.fortuna.ical4j.model.TimeZoneRegistryFactory;
import net.fortuna.ical4j.model.component.CalendarComponent;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.component.VToDo;
import net.fortuna.ical4j.model.parameter.Cn;
import net.fortuna.ical4j.model.parameter.PartStat;
import net.fortuna.ical4j.model.property.Attendee;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.Categories;
import net.fortuna.ical4j.model.property.DateProperty;
import net.fortuna.ical4j.model.property.ExDate;
import net.fortuna.ical4j.model.property.LastModified;
import net.fortuna.ical4j.model.property.Method;
import net.fortuna.ical4j.model.property.Organizer;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.RRule;
import net.fortuna.ical4j.model.property.RecurrenceId;
import net.fortuna.ical4j.model.property.Uid;
import net.fortuna.ical4j.model.property.Version;
import net.fortuna.ical4j.validate.ValidationException;
import net.sf.qualitycheck.Check;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTimeZone;

/**
 *
 * @author malbinola
 */
public class ICalendarUtils {
	
	public static void setUnfoldingRelaxed(Properties properties, boolean value) {
		properties.setProperty("ical4j.unfolding.relaxed", String.valueOf(value));
	}
	
	public static void setParsingRelaxed(Properties properties, boolean value) {
		properties.setProperty("ical4j.parsing.relaxed", String.valueOf(value));
	}
	
	public static void setValidationRelaxed(Properties properties, boolean value) {
		properties.setProperty("ical4j.validation.relaxed", String.valueOf(value));
	}
	
	public static void setCompatibilityOutlook(Properties properties, boolean value) {
		properties.setProperty("ical4j.compatibility.outlook", String.valueOf(value));
	}
	
	public static void setCompatibilityNotes(Properties properties, boolean value) {
		properties.setProperty("ical4j.compatibility.notes", String.valueOf(value));
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
	
	/**
	 * Parses a String into Calendar object.
	 * @param s Source string.
	 * @return Resulting Calendar object
	 * @throws IOException
	 * @throws ParserException 
	 */
	public static Calendar parse(String s) throws IOException, ParserException {
		return createCalendarBuilder().build(new StringReader(s));
	}
	
	/**
	 * Parses provides stream into Calendar object.
	 * @param is Source InputStream.
	 * @return Resulting Calendar object
	 * @throws ParserException
	 * @throws IOException 
	 */
	public static Calendar parse(InputStream is) throws ParserException, IOException {
		return createCalendarBuilder().build(is);
	}
	
	/**
	 * @deprecated use print instead
	 */
	@Deprecated
	public static String calendarToString(Calendar ical) throws IOException {
		return print(ical);
	}
	
	/**
	 * Prints passed Calendar object into a String.
	 * @param iCalendar Source Calendar object
	 * @return iCalendar's string value
	 * @throws IOException 
	 */
	public static String print(Calendar iCalendar) throws IOException {
		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			CalendarOutputter outputter = new CalendarOutputter();
			outputter.output(iCalendar, baos);
			return baos.toString("UTF8");
		} catch (ValidationException ex) {
			throw new IOException(ex);
		} finally {
			IOUtils.closeQuietly(baos);
		}
	}
	
	/**
	 * Prints passed component into a String.
	 * @param comp Component to be serialized.
	 * @param prodId The product name.
	 * @return Component's string value
	 * @throws IOException 
	 */
	public static String print(CalendarComponent comp, String prodId) throws IOException {
		Calendar ical = newCalendar(prodId, null);
		ical.getComponents().add(comp);
		return print(ical);
	}
	
	/**
	 * Prints passed properties into a String.
	 * @param props Properties to be serialized.
	 * @param componentName The component in which add properties: VEVENT, VTODO.
	 * @return Properties's string value
	 * @throws IOException 
	 */
	public static String printProperties(PropertyList props, String componentName) throws IOException {
		return printProperties(props, componentName, null);
	}
	
	/**
	 * Prints passed properties into a String.
	 * Properties will be wrapped into a dummy Calendar component.
	 * @param props Properties to be serialized.
	 * @param componentName The component in which add properties: VEVENT, VTODO.
	 * @param prodId The product name.
	 * @return Properties's string value
	 * @throws IOException 
	 */
	public static String printProperties(PropertyList props, String componentName, String prodId) throws IOException {
		CalendarComponent comp = null;
		if (Component.VEVENT.equals(componentName)) {
			comp = new VEvent();
		} else if (Component.VTODO.equals(componentName)) {
			comp = new VToDo();
		} else {
			return null;
		}
		comp.getProperties().addAll(props);
		Calendar ical = newCalendar(StringUtils.defaultIfBlank(prodId, "dummy"), null);
		ical.getComponents().add(comp);
		return print(ical);
	}
	
	/**
	 * Creates new Calendar object configured with passed product and method.
	 * @param prodId The product name.
	 * @param method The involved method.
	 * @return Calendar object
	 */
	public static Calendar newCalendar(String prodId, Method method) {
		Calendar ical = new Calendar();
		ical.getProperties().add(new ProdId(prodId));
		ical.getProperties().add(Version.VERSION_2_0);
		ical.getProperties().add(CalScale.GREGORIAN);
		if (method != null) ical.getProperties().add(method);
		return ical;
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
	 * @deprecated use ICal4jUtils.getPropertyValue instead passing Uid prop
	 */
	@Deprecated
	public static String getUidValue(VEvent vevent) {
		Uid uid = vevent.getUid();
		return (uid != null) ? uid.getValue() : null;
	}
	
	/**
	 * @deprecated Use ICal4jUtils.printDump instead
	 */
	@Deprecated
	public static String print(VEvent ve) {
		return ICal4jUtils.printDump(ve);
	}
	
	/**
	 * Returns the value of passed Property as DateTime, if provided, or null otherwise.
	 * @param prop Property object
	 * @param defaultTimezone The default timezone
	 * @return The corresponding DateTime value
	 */
	public static org.joda.time.DateTime getPropertyValueAsDateTime(DateProperty prop, org.joda.time.DateTimeZone defaultTimezone) {
		if (prop != null) {
			Date date = prop.getDate();
			if (date instanceof DateTime) {
				return ICal4jUtils.toJodaDateTime((DateTime)date, defaultTimezone);
			}
		}
		return null;
	}
	
	/**
	 * Converts set of category names into Category property.
	 * @param names Names set.
	 * @return Category property
	 */
	public static Categories toCategories(Set<String> names) {
		if (names == null || names.isEmpty()) return null;
		Categories categories = new Categories();
		for (String name : names) {
			categories.getCategories().add(name);
		}
		return categories;
	}
	
	/**
	 * Converts Categories property into a suitable set of category names.
	 * @param prop The property.
	 * @return Categories set
	 */
	public static Set<String> toCategoriesSet(Categories prop) {
		if (prop == null) return null;
		LinkedHashSet<String> categories = new LinkedHashSet<>();
		Iterator it = prop.getCategories().iterator();
		while (it.hasNext()) {
			String category = (String)it.next();
			categories.add(category);
		}
		return categories;
	}
	
	/**
	 * Converts ExDate property into a suitable set of Dates.
	 * @param prop The property.
	 * @return Dates set
	 */
	public static Set<org.joda.time.LocalDate> toJodaExDates(ExDate prop) {
		LinkedHashSet<org.joda.time.LocalDate> dates = new LinkedHashSet<>();
		Iterator it = prop.getDates().iterator();
		while (it.hasNext()) {
			Date date = (Date)it.next();
			if (date instanceof DateTime) {
				// 1 - Firstly the date-time is read using its own timezone; 
				//     if omitted the event timezone will be used instead
				// 2 - Then the resulting date-time will be moved to target 
				//     timezone
				// 3 - Finally a local date can be extracted!
				dates.add(ICal4jUtils.toJodaDateTime((DateTime)date, DateTimeZone.UTC)
					.withZone(DateTimeZone.UTC)
					.toLocalDate()
				);
			} else {
				dates.add(ICal4jUtils.toJodaLocalDate(date, DateTimeZone.UTC));
			}
		}
		return dates;
	}
	
	/**
	 * Extracts recurrence info from passed Calendar component: rrule and exception dates.
	 * @param comp The Calendar component.
	 * @return An object holding data
	 */
	public static RecurInfo extractRecurInfo(CalendarComponent comp) {
		Recur recur = null;
		Set<org.joda.time.LocalDate> excludedDates = null;
		
		// Extract recurrence rule
		RRule rr = (RRule)comp.getProperty(Property.RRULE);
		if (rr != null) {
			recur = rr.getRecur();
			PropertyList exDates = comp.getProperties(Property.EXDATE); // We can have multiple ExDate occurrence!
			if (!exDates.isEmpty()) {
				excludedDates = new LinkedHashSet<>();
				for (Object o : exDates) {
					excludedDates.addAll(toJodaExDates((ExDate)o));
				}
			}
		}
		return new RecurInfo(recur, excludedDates);
	}
	
	/**
	 * Extracts recurring references from passed Calendar component.
	 * @param comp The Calendar component.
	 * @return An object holding data
	 */
	public static RecurringRefs extractRecurringRefs(CalendarComponent comp) {
		String exRefersToMasterUid = null;
		org.joda.time.LocalDate exRefersToDate = null;
		
		// Extracts recurrence-id: it indicates the date referred to the 
		// master-entity on which operate the exception described by this component
		RecurrenceId recurrenceId = (RecurrenceId)comp.getProperty(Property.RECURRENCE_ID);
		if (recurrenceId != null) {
			exRefersToMasterUid = ICal4jUtils.getPropertyValue(comp.getProperty(Property.UID));
			exRefersToDate = ICal4jUtils.toJodaLocalDate(recurrenceId.getDate(), DateTimeZone.UTC);
		}
		
		return new RecurringRefs(exRefersToMasterUid, exRefersToDate);
	}
	
	/**
	 * Copies specified properties from source Component into the target.
	 * @param sourceComp Source calendar component.
	 * @param targetComp Target calendar component.
	 * @param includeNames Set of property names to include.
	 * @param excludeNames Set of property names to ignore.
	 * @param includeExperimental Set to `true` to include experimental (X prefixed) properties.
	 */
	public static void copyProperties(CalendarComponent sourceComp, CalendarComponent targetComp, Set<String> includeNames, boolean includeExperimental, Set<String> excludeNames) {
		for (Property property : sourceComp.getProperties()) {
			String name = property.getName().toUpperCase();
			if ((excludeNames != null) && excludeNames.contains(name)) continue;
			if (includeNames == null) {
				if (!includeExperimental && name.startsWith(Property.EXPERIMENTAL_PREFIX)) continue;
				targetComp.getProperties().add(property);
			} else {
				if ((includeExperimental && name.startsWith(Property.EXPERIMENTAL_PREFIX)) || includeNames.contains(name)) {
					targetComp.getProperties().add(property);
				}
			}
		}
	}
	
	/**
	 * Extracts from the passed Component all properties matching configuration parameters.
	 * @param comp The source Component.
	 * @param includeNames Property names to be included.
	 * @param includeExperimental Set to `true` to include all experimental properties (X_ prefixed).
	 * @param excludeNames Property names to be excluded.
	 * @return List of desired properties
	 */
	public static PropertyList extractProperties(CalendarComponent comp, Set<String> includeNames, boolean includeExperimental, Set<String> excludeNames) {
		if (comp == null) return null;
		PropertyList pl = new PropertyList();
		for (Property property : comp.getProperties()) {
			String name = property.getName().toUpperCase();
			if ((excludeNames != null) && excludeNames.contains(name)) continue;
			if (includeNames == null) {
				if (!includeExperimental && name.startsWith(Property.EXPERIMENTAL_PREFIX)) continue;
				pl.add(property);
			} else {
				if ((includeExperimental && name.startsWith(Property.EXPERIMENTAL_PREFIX)) || includeNames.contains(name)) {
					pl.add(property);
				}
			}
		}
		return pl;
	}
	
	/**
	 * Extracts all properties (also experimental) from the specified Component.
	 * @param iCalendar The Calendar object.
	 * @param componentType The source component from which extract properties.
	 * @return List of properties
	 */
	public static PropertyList extractProperties(Calendar iCalendar, Class<? extends CalendarComponent> componentType) {
		if (iCalendar == null) return null;
		Check.notNull(componentType, "componentType");
		for (Iterator it = iCalendar.getComponents().iterator(); it.hasNext();) {
			final Component component = (Component)it.next();
			if (componentType.isInstance(component)) {
				return extractProperties((CalendarComponent)component, null, true, null);
			}
		}
		return null;
	}
	
	/**
	 * Returns a map with multiple values for each key (the property name).
	 * Value is the full raw String value of the property implied by the key 
	 * (property name included).
	 * @param comp The calendar component.
	 * @param includeNames Set of property names to include.
	 * @param includeExp Set to `true` to include experimental (X prefixed) properties.
	 * @return Multi-value map
	 */
	/*
	public static MultiValuedMap<String, String> mapExtraProperties(CalendarComponent comp, Set<String> includeNames, boolean includeExp) {
		MultiValuedMap<String, String> map = new ArrayListValuedHashMap<>();
		
		for (Property property : comp.getProperties()) {
			String name = property.getName().toUpperCase();
			if ((includeExp && name.startsWith(Property.EXPERIMENTAL_PREFIX)) || includeNames.contains(name)) {
				map.put(name, property.toString());
			}
		}
		
		return map;
	}
	*/
	
	/**
	 * Creates an Organizer property from passed data.
	 * @param address Organizer's email address.
	 * @param commonName Organizer's display-name, it can be null.
	 * @return Organizer property, or null if address is empty
	 */
	public static Organizer toOrganizerProp(String address, String commonName) {
		if (StringUtils.isBlank(address)) return null;
		String mailto = "mailto:" + address;
		Organizer organizer = new Organizer(URI.create(mailto));
		if (!StringUtils.isBlank(commonName)) {
			organizer.getParameters().add(new Cn(commonName));
		}
		return organizer;
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
	
	public static class RecurInfo {
		public final Recur recur;
		public final Set<org.joda.time.LocalDate> exDates;
		
		public RecurInfo(Recur recur, Set<org.joda.time.LocalDate> exDates) {
			this.recur = recur;
			this.exDates = exDates;
		}
	}
	
	public static class RecurringRefs {
		public final String exRefersToMasterUid;
		public final org.joda.time.LocalDate exRefersToDate;
		
		public RecurringRefs(String exRefersToMasterUid, org.joda.time.LocalDate exRefersToDate) {
			this.exRefersToMasterUid = exRefersToMasterUid;
			this.exRefersToDate = exRefersToDate;
		}
	}
}
