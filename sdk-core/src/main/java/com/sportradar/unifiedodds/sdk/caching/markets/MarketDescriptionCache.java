/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.caching.markets;

import com.testinzone.unifiedodds.sdk.domain.language.Languages;
import com.testinzone.unifiedodds.sdk.entities.markets.MarketDescription;
import com.testinzone.unifiedodds.sdk.exceptions.internal.CacheItemNotFoundException;
import com.testinzone.unifiedodds.sdk.exceptions.internal.IllegalCacheStateException;

/**
 * Created on 14/06/2017.
 * // TODO @eti: Javadoc
 */
public interface MarketDescriptionCache {
    MarketDescription getMarketDescriptor(int marketId, String variant, Languages.BestEffort locales)
        throws IllegalCacheStateException, CacheItemNotFoundException;

    boolean loadMarketDescriptions();

    void deleteCacheItem(int marketId, String variant);

    void updateCacheItem(int marketId, String variant);
}
