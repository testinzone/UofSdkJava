/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.caching.impl;

import com.google.common.cache.Cache;
import com.testinzone.unifiedodds.sdk.SdkInternalConfiguration;
import com.testinzone.unifiedodds.sdk.caching.DataRouterManager;
import com.testinzone.unifiedodds.sdk.caching.SportEventCache;
import com.testinzone.unifiedodds.sdk.caching.SportEventCi;
import com.testinzone.unifiedodds.sdk.caching.impl.ci.CacheItemFactory;
import com.testinzone.unifiedodds.sdk.impl.MappingTypeProvider;
import com.testinzone.utils.Urn;

public class SportEventCacheImplConstructor {

    private SportEventCacheImplConstructor() {}

    public static SportEventCacheImpl create(
        CacheItemFactory cacheItemFactory,
        MappingTypeProvider mappingTypeProvider,
        DataRouterManager dataRouterManager,
        SdkInternalConfiguration sdkInternalConfiguration,
        Cache<Urn, SportEventCi> sportEventsCache
    ) {
        return new SportEventCacheImpl(
            cacheItemFactory,
            mappingTypeProvider,
            dataRouterManager,
            sdkInternalConfiguration,
            sportEventsCache
        );
    }
}
