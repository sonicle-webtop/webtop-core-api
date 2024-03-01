/*
 * Copyright (C) 2024 Sonicle S.r.l.
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
 * display the words "Copyright (C) 2024 Sonicle S.r.l.".
 */
package com.sonicle.webtop.core.app.ical4j;

import net.fortuna.ical4j.model.*;
import net.fortuna.ical4j.model.component.*;
import net.fortuna.ical4j.model.parameter.TzId;
import net.fortuna.ical4j.model.property.DateListProperty;
import net.fortuna.ical4j.model.property.DateProperty;
import net.fortuna.ical4j.model.property.XProperty;
import net.fortuna.ical4j.util.CompatibilityHints;
import net.fortuna.ical4j.util.Constants;
import net.fortuna.ical4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.CalendarParser;
import net.fortuna.ical4j.data.CalendarParserFactory;
import net.fortuna.ical4j.data.ContentHandler;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.data.UnfoldingReader;
/**
 *
 * @author gabriele.bulfon
 */
public class LazyCalendarBuilder {

    private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    private final CalendarParser parser;

    private final ContentHandler contentHandler;

    private final TimeZoneRegistry tzRegistry;

    private List<Property> datesMissingTimezones;

    /**
     * The calendar instance created by the builder.
     */
    //protected Calendar calendar;

    /**
     * The current component instance created by the builder.
     */
    protected CalendarComponent component;

    /**
     * The current sub-component instance created by the builder.
     */
    protected Component subComponent;

    /**
     * The current property instance created by the builder.
     */
    protected Property property;
	
	/**
	 * The consumer of components
	 */
	private LazyCalendarComponentConsumer consumer;

    /**
     * Default constructor.
     */
    public LazyCalendarBuilder(LazyCalendarComponentConsumer consumer) {
        this(CalendarParserFactory.getInstance().createParser(), new PropertyFactoryRegistry(),
                new ParameterFactoryRegistry(), TimeZoneRegistryFactory.getInstance().createRegistry(), consumer);
    }

    /**
     * Constructs a new calendar builder using the specified calendar parser.
     *
     * @param parser a calendar parser used to parse calendar files
     */
    public LazyCalendarBuilder(final CalendarParser parser, LazyCalendarComponentConsumer consumer) {
        this(parser, new PropertyFactoryRegistry(), new ParameterFactoryRegistry(),
                TimeZoneRegistryFactory.getInstance().createRegistry(), consumer);
    }

    /**
     * Constructs a new calendar builder using the specified timezone registry.
     *
     * @param tzRegistry a timezone registry to populate with discovered timezones
     */
    public LazyCalendarBuilder(final TimeZoneRegistry tzRegistry, LazyCalendarComponentConsumer consumer) {
        this(CalendarParserFactory.getInstance().createParser(), new PropertyFactoryRegistry(),
                new ParameterFactoryRegistry(), tzRegistry, consumer);
    }

    /**
     * Constructs a new instance using the specified parser and registry.
     *
     * @param parser     a calendar parser used to construct the calendar
     * @param tzRegistry a timezone registry used to retrieve {@link TimeZone}s and
     *                   register additional timezone information found
     *                   in the calendar
     */
    public LazyCalendarBuilder(CalendarParser parser, TimeZoneRegistry tzRegistry, LazyCalendarComponentConsumer consumer) {
        this(parser, new PropertyFactoryRegistry(), new ParameterFactoryRegistry(), tzRegistry, consumer);
    }

    /**
     * @param parser                   a custom calendar parser
     * @param propertyFactoryRegistry  registry for non-standard property factories
     * @param parameterFactoryRegistry registry for non-standard parameter factories
     * @param tzRegistry               a custom timezone registry
     */
    public LazyCalendarBuilder(CalendarParser parser, PropertyFactoryRegistry propertyFactoryRegistry,
                           ParameterFactoryRegistry parameterFactoryRegistry, TimeZoneRegistry tzRegistry, LazyCalendarComponentConsumer consumer) {

        this.parser = parser;
        this.tzRegistry = tzRegistry;
		this.consumer = consumer;
        this.contentHandler = new LazyContentHandlerImpl(ComponentFactoryImpl.getInstance(),
                propertyFactoryRegistry, parameterFactoryRegistry);
    }

    /**
     * Builds an iCalendar model from the specified input stream.
     *
     * @param in an input stream to read calendar data from
     * @return a calendar parsed from the specified input stream
     * @throws IOException     where an error occurs reading data from the specified stream
     * @throws ParserException where an error occurs parsing data from the stream
     */
    public void build(final InputStream in) throws IOException,
            ParserException {
        build(new InputStreamReader(in, DEFAULT_CHARSET));
    }

    /**
     * Builds an iCalendar model from the specified reader. An <code>UnfoldingReader</code> is applied to the
     * specified reader to ensure the data stream is correctly unfolded where appropriate.
     *
     * @param in a reader to read calendar data from
     * @return a calendar parsed from the specified reader
     * @throws IOException     where an error occurs reading data from the specified reader
     * @throws ParserException where an error occurs parsing data from the reader
     */
    public void build(final Reader in) throws IOException, ParserException {
        build(new UnfoldingReader(in));
    }

    /**
     * Build an iCalendar model by parsing data from the specified reader.
     *
     * @param uin an unfolding reader to read data from
     * @return a calendar parsed from the specified reader
     * @throws IOException     where an error occurs reading data from the specified reader
     * @throws ParserException where an error occurs parsing data from the reader
     */
    public void build(final UnfoldingReader uin) throws IOException,
            ParserException {
        // re-initialise..
        //calendar = null;
        component = null;
        subComponent = null;
        property = null;
        datesMissingTimezones = new ArrayList<Property>();

        parser.parse(uin, contentHandler);

        if (datesMissingTimezones.size() > 0 && tzRegistry != null) {
            resolveTimezones();
        }

    }

    private class LazyContentHandlerImpl implements ContentHandler {

        private final ComponentFactoryImpl componentFactory;

        private final PropertyFactoryRegistry propertyFactory;

        private final ParameterFactoryRegistry parameterFactory;

        public LazyContentHandlerImpl(ComponentFactoryImpl componentFactory, PropertyFactoryRegistry propertyFactory,
                                  ParameterFactoryRegistry parameterFactory) {

            this.componentFactory = componentFactory;
            this.propertyFactory = propertyFactory;
            this.parameterFactory = parameterFactory;
        }

        public void endCalendar() {
            // do nothing..
        }

        public void endComponent(final String name) {
            assertComponent(component);

            if (subComponent != null) {
                if (component instanceof VTimeZone) {
                    ((VTimeZone) component).getObservances().add((Observance) subComponent);
                } else if (component instanceof VEvent) {
                    ((VEvent) component).getAlarms().add((VAlarm) subComponent);
                } else if (component instanceof VToDo) {
                    ((VToDo) component).getAlarms().add((VAlarm) subComponent);
                } else if (component instanceof VAvailability) {
                    ((VAvailability) component).getAvailable().add((Available) subComponent);
                }
                subComponent = null;
            } else {
                //Original: calendar.getComponents().add(component);
				consumer.consume(component);
				
                if (component instanceof VTimeZone && tzRegistry != null) {
                    // register the timezone for use with iCalendar objects..
                    tzRegistry.register(new TimeZone((VTimeZone) component));
                }
                component = null;
            }
        }

        public void endProperty(final String name) {
            assertProperty(property);

            // replace with a constant instance if applicable..
            property = Constants.forProperty(property);
            if (component != null) {
                if (subComponent != null) {
                    subComponent.getProperties().add(property);
                } else {
                    component.getProperties().add(property);
                }
            }/* else if (calendar != null) {
                calendar.getProperties().add(property);
            }*/

            property = null;
        }

        public void parameter(final String name, final String value) throws URISyntaxException {
            assertProperty(property);

            // parameter names are case-insensitive, but convert to upper case to simplify further processing
            final Parameter param = parameterFactory.createParameter(name.toUpperCase(), Strings.escapeNewline(value));
            property.getParameters().add(param);
            if (param instanceof TzId && tzRegistry != null && !(property instanceof XProperty)) {
                final TimeZone timezone = tzRegistry.getTimeZone(param.getValue());
                if (timezone != null) {
                    updateTimeZone(property, timezone);
                } else {
                    // VTIMEZONE may be defined later, so so keep
                    // track of dates until all components have been
                    // parsed, and then try again later
                    datesMissingTimezones.add(property);
                }
            }
        }

        /**
         * {@inheritDoc}
         */
        public void propertyValue(final String value) throws URISyntaxException,
                ParseException, IOException {

            assertProperty(property);

            if (property instanceof Escapable) {
                property.setValue(Strings.unescape(value));
            } else {
                property.setValue(value);
            }
        }

        /**
         * {@inheritDoc}
         */
        public void startCalendar() {
            //calendar = new Calendar();
        }

        /**
         * {@inheritDoc}
         */
        public void startComponent(final String name) {
            if (component != null) {
                subComponent = componentFactory.createComponent(name);
            } else {
                component = componentFactory.createComponent(name);
            }
        }

        /**
         * {@inheritDoc}
         */
        public void startProperty(final String name) {
            // property names are case-insensitive, but convert to upper case to simplify further processing
            property = propertyFactory.createProperty(name.toUpperCase());
        }
    }

    private void assertComponent(Component component) {
        if (component == null) {
            throw new CalendarException("Expected component not initialised");
        }
    }

    private void assertProperty(Property property) {
        if (property == null) {
            throw new CalendarException("Expected property not initialised");
        }
    }

    /**
     * Returns the timezone registry used in the construction of calendars.
     *
     * @return a timezone registry
     */
    public final TimeZoneRegistry getRegistry() {
        return tzRegistry;
    }

    private void updateTimeZone(Property property, TimeZone timezone) {
        try {
            ((DateProperty) property).setTimeZone(timezone);
        } catch (ClassCastException e) {
            try {
                ((DateListProperty) property).setTimeZone(timezone);
            } catch (ClassCastException e2) {
                if (CompatibilityHints.isHintEnabled(CompatibilityHints.KEY_RELAXED_PARSING)) {
                    Logger log = LoggerFactory.getLogger(CalendarBuilder.class);
                    log.warn("Error setting timezone [" + timezone.getID()
                            + "] on property [" + property.getName()
                            + "]", e);
                } else {
                    throw e2;
                }
            }
        }
    }

    private void resolveTimezones()
            throws IOException {

        // Go through each property and try to resolve the TZID.
        for (Property property : datesMissingTimezones) {
            final Parameter tzParam = property.getParameter(Parameter.TZID);

            // tzParam might be null: 
            if (tzParam == null) {
                continue;
            }

            //lookup timezone
            final TimeZone timezone = tzRegistry.getTimeZone(tzParam.getValue());

            // If timezone found, then update date property
            if (timezone != null) {
                // Get the String representation of date(s) as
                // we will need this after changing the timezone
                final String strDate = property.getValue();

                // Change the timezone
                if (property instanceof DateProperty) {
                    ((DateProperty) property).setTimeZone(timezone);
                } else if (property instanceof DateListProperty) {
                    ((DateListProperty) property).setTimeZone(timezone);
                }

                // Reset value
                try {
                    property.setValue(strDate);
                } catch (ParseException e) {
                    // shouldn't happen as its already been parsed
                    throw new CalendarException(e);
                } catch (URISyntaxException e) {
                    // shouldn't happen as its already been parsed
                    throw new CalendarException(e);
                }
            }
        }
    }
}
