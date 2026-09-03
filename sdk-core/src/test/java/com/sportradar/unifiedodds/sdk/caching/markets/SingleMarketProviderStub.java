/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.caching.markets;

import com.testinzone.unifiedodds.sdk.entities.markets.MarketDescription;
import com.testinzone.unifiedodds.sdk.exceptions.internal.CacheItemNotFoundException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SingleMarketProviderStub implements MarketDescriptionProvider {

    private final MarketDescription marketDescription;

    @Override
    public MarketDescription getMarketDescription(
        int marketId,
        Map<String, String> marketSpecifiers,
        List<Locale> locales,
        boolean fetchVariantDescriptions
    ) throws CacheItemNotFoundException {
        return marketDescription;
    }

    @Override
    public boolean reloadMarketDescription(int marketId, Map<String, String> marketSpecifiers) {
        return false;
    }
}
