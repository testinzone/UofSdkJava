/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.caching.markets;

import com.testinzone.unifiedodds.sdk.caching.ci.markets.VariantDescriptionCi;
import com.testinzone.unifiedodds.sdk.exceptions.internal.CacheItemNotFoundException;
import com.testinzone.unifiedodds.sdk.exceptions.internal.IllegalCacheStateException;
import java.util.List;
import java.util.Locale;

/**
 * Created on 14/12/2017.
 * // TODO @eti: Javadoc
 */
public interface VariantDescriptionCache {
    VariantDescriptionCi getVariantDescription(String id, List<Locale> locales)
        throws IllegalCacheStateException, CacheItemNotFoundException;

    boolean loadMarketDescriptions();
}
