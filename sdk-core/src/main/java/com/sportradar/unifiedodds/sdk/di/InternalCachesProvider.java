package com.testinzone.unifiedodds.sdk.di;

import com.google.common.cache.Cache;
import com.testinzone.unifiedodds.sdk.caching.*;
import com.testinzone.unifiedodds.sdk.caching.ci.markets.MarketDescriptionCi;
import com.testinzone.unifiedodds.sdk.caching.ci.markets.VariantDescriptionCi;
import com.testinzone.utils.Urn;
import java.io.Closeable;
import java.util.Date;

/**
 * Created on 2019-03-29
 *
 * @author e.roznik
 */
public interface InternalCachesProvider extends Closeable {
    Cache<Urn, SportCi> getSportDataCache();

    Cache<Urn, CategoryCi> getCategoryDataCache();

    Cache<Urn, SportEventCi> getSportEventCache();

    Cache<Urn, PlayerProfileCi> getPlayerProfileCache();

    Cache<Urn, CompetitorCi> getCompetitorCache();

    Cache<Urn, CompetitorCi> getSimpleTeamCompetitorCache();

    Cache<String, SportEventStatusCi> getSportEventStatusCache();

    Cache<String, MarketDescriptionCi> getInvariantMarketCache();

    Cache<String, MarketDescriptionCi> getVariantMarketCache();

    Cache<String, String> getDispatchedFixtureChanges();

    Cache<String, VariantDescriptionCi> getVariantDescriptionCache();

    Cache<Urn, Date> getFixtureTimestampCache();

    Cache<String, Date> getIgnoreEventsTimelineCache();
}
