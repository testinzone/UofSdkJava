package com.testinzone.unifiedodds.sdk.impl.entities;

import static com.testinzone.unifiedodds.sdk.impl.Constants.SCHEDULE_MSG_URI;
import static org.junit.Assert.assertEquals;

import com.google.common.collect.ImmutableMap;
import com.testinzone.uf.sportsapi.datamodel.SapiScheduleEndpoint;
import com.testinzone.uf.sportsapi.datamodel.SapiVenue;
import com.testinzone.unifiedodds.sdk.caching.ci.VenueCi;
import com.testinzone.unifiedodds.sdk.caching.exportable.ExportableVenueCi;
import com.testinzone.unifiedodds.sdk.entities.Venue;
import com.testinzone.unifiedodds.sdk.exceptions.internal.DeserializationException;
import com.testinzone.unifiedodds.sdk.impl.XmlMessageReader;
import com.testinzone.utils.Urn;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings({ "MultipleStringLiterals" })
public class VenueTest {

    private static final Locale LOCALE = Locale.ENGLISH;
    private static final List<Locale> LOCALES = Arrays.asList(LOCALE);
    private static final String VENUE_ID = "sr:venue:26791";

    private SapiVenue sapiVenue;

    @Before
    public void setup() throws DeserializationException {
        SapiScheduleEndpoint sapiSchedule = XmlMessageReader.readMessageFromResource(SCHEDULE_MSG_URI);

        sapiVenue = sapiSchedule.getSportEvent().get(0).getVenue();
    }

    @Test
    public void parsesEntityFromXml() {
        VenueCi venueCi = new VenueCi(sapiVenue, LOCALE);

        Venue actual = new VenueImpl(venueCi, LOCALES);

        assertEquals(actual.getId(), Urn.parse(VENUE_ID));
        assertEquals(actual.getNames(), ImmutableMap.of(LOCALE, "Court 2"));
        assertEquals(actual.getCities(), ImmutableMap.of(LOCALE, "Newport Beach"));
        assertEquals(actual.getCountries(), ImmutableMap.of(LOCALE, "USA"));
        assertEquals(actual.getCountryCode(), "USA");
        assertEquals(actual.getState(), "CA");
    }

    @Test
    public void exportsImportsEntityFromCache() {
        VenueCi venueCi = new VenueCi(sapiVenue, LOCALE);

        ExportableVenueCi exportableVenueCi = venueCi.export(); //export to cache

        Venue actual = new VenueImpl(
            new VenueCi(exportableVenueCi), //import from cache
            LOCALES
        );

        assertEquals(actual.getId(), Urn.parse(VENUE_ID));
        assertEquals(actual.getNames(), ImmutableMap.of(LOCALE, "Court 2"));
        assertEquals(actual.getCities(), ImmutableMap.of(LOCALE, "Newport Beach"));
        assertEquals(actual.getCountries(), ImmutableMap.of(LOCALE, "USA"));
        assertEquals(actual.getCountryCode(), "USA");
        assertEquals(actual.getState(), "CA");
    }
}
