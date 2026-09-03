/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.caching.markets;

import com.testinzone.unifiedodds.sdk.entities.markets.MarketDescription;
import com.testinzone.unifiedodds.sdk.exceptions.internal.CacheItemNotFoundException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created on 07/07/2017.
 * // TODO @eti: Javadoc
 */
public interface MarketDescriptionProvider {
    MarketDescription getMarketDescription(
        int marketId,
        Map<String, String> marketSpecifiers,
        List<Locale> locales,
        boolean fetchVariantDescriptions
    ) throws CacheItemNotFoundException;

    /**
     * Reloads market description (single or list)
     * @param marketId the market identifier
     * @param marketSpecifiers a list of specifiers or a null reference if market is invariant
     * @return true if succeeded, false otherwise
     */
    boolean reloadMarketDescription(int marketId, Map<String, String> marketSpecifiers);
}
