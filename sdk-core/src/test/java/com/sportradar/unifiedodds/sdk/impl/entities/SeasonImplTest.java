/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.impl.entities;

import static com.testinzone.utils.Urns.SportEvents.urnForAnySeason;
import static com.testinzone.utils.Urns.Sports.urnForAnySport;
import static java.util.Arrays.asList;
import static java.util.Locale.ENGLISH;
import static java.util.Locale.FRENCH;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

import com.testinzone.unifiedodds.sdk.ExceptionHandlingStrategy;
import com.testinzone.unifiedodds.sdk.SportEntityFactory;
import com.testinzone.unifiedodds.sdk.caching.DataRouterManager;
import com.testinzone.unifiedodds.sdk.caching.impl.SportEventCacheImpl;
import com.testinzone.unifiedodds.sdk.entities.Competition;
import com.testinzone.unifiedodds.sdk.entities.Season;
import com.testinzone.unifiedodds.sdk.exceptions.ObjectNotFoundException;
import com.testinzone.unifiedodds.sdk.exceptions.internal.CommunicationException;
import com.testinzone.utils.Urn;
import java.util.List;
import java.util.Locale;
import org.junit.Test;

public class SeasonImplTest {

    private final SportEntityFactory anyFactory = mock(SportEntityFactory.class);
    private final Urn seasonUrn = urnForAnySeason();
    private final DataRouterManager dataRouterManager = mock(DataRouterManager.class);
    private final Locale inEnglish = ENGLISH;

    @Test
    public void failingToGetScheduledSportEventIdsComposingScheduleShouldReturnNullWhenConfiguredToCatchExceptions()
        throws CommunicationException {
        final SportEventCacheImpl sportEventCache = SportEvenCacheToProxyDataRouterManagerOnly.create(
            dataRouterManager
        );
        final Season season = new SeasonImpl(
            seasonUrn,
            urnForAnySport(),
            asList(inEnglish),
            sportEventCache,
            anyFactory,
            ExceptionHandlingStrategy.Catch
        );
        when(dataRouterManager.requestEventsFor(inEnglish, seasonUrn))
            .thenThrow(CommunicationException.class);

        final List<Competition> schedule = season.getSchedule();

        assertNull(schedule);
    }

    @Test
    public void failingToGetScheduledSportEventIdsComposingScheduleShouldThrowWhenConfiguredToThrowExceptions()
        throws CommunicationException {
        final SportEventCacheImpl sportEventCache = SportEvenCacheToProxyDataRouterManagerOnly.create(
            dataRouterManager
        );
        final Season season = new SeasonImpl(
            seasonUrn,
            urnForAnySport(),
            asList(inEnglish),
            sportEventCache,
            anyFactory,
            ExceptionHandlingStrategy.Throw
        );
        when(dataRouterManager.requestEventsFor(inEnglish, seasonUrn))
            .thenThrow(CommunicationException.class);

        assertThatThrownBy(() -> season.getSchedule())
            .isInstanceOf(ObjectNotFoundException.class)
            .hasMessageContaining("getSchedule failure");
    }

    @Test
    public void allConfiguredLanguagesShouldBeAttemptedUntilFailureWhenGettingScheduledSportEventIdsComposingSchedule()
        throws CommunicationException {
        final Locale firstLanguage = ENGLISH;
        final Locale secondLanguage = FRENCH;
        final SportEventCacheImpl sportEventCache = SportEvenCacheToProxyDataRouterManagerOnly.create(
            dataRouterManager
        );
        final Season season = new SeasonImpl(
            seasonUrn,
            urnForAnySport(),
            asList(firstLanguage, secondLanguage),
            sportEventCache,
            anyFactory,
            ExceptionHandlingStrategy.Throw
        );
        when(dataRouterManager.requestEventsFor(firstLanguage, seasonUrn)).thenReturn(asList());
        when(dataRouterManager.requestEventsFor(secondLanguage, seasonUrn))
            .thenThrow(CommunicationException.class);

        assertThatThrownBy(() -> season.getSchedule())
            .isInstanceOf(ObjectNotFoundException.class)
            .hasMessageContaining("getSchedule failure");
    }

    @Test
    public void noFurtherLanguagesShouldBeAttemptedAfterFailingOneWhenGettingScheduledSportEventIdsComposingSchedule()
        throws CommunicationException {
        final Locale firstLanguage = ENGLISH;
        final Locale secondLanguage = FRENCH;
        final SportEventCacheImpl sportEventCache = SportEvenCacheToProxyDataRouterManagerOnly.create(
            dataRouterManager
        );
        final Season season = new SeasonImpl(
            seasonUrn,
            urnForAnySport(),
            asList(firstLanguage, secondLanguage),
            sportEventCache,
            anyFactory,
            ExceptionHandlingStrategy.Throw
        );
        when(dataRouterManager.requestEventsFor(firstLanguage, seasonUrn))
            .thenThrow(CommunicationException.class);

        assertThatThrownBy(() -> season.getSchedule())
            .isInstanceOf(ObjectNotFoundException.class)
            .hasMessageContaining("getSchedule failure");
        verify(dataRouterManager, times(1)).requestEventsFor(any(), any(Urn.class));
    }
}
