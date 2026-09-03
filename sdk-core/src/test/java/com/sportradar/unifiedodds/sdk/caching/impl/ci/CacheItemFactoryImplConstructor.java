/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.caching.impl.ci;

import com.google.common.cache.Cache;
import com.testinzone.unifiedodds.sdk.SdkInternalConfiguration;
import com.testinzone.unifiedodds.sdk.caching.DataRouterManager;
import com.testinzone.utils.Urn;
import java.util.Date;

public class CacheItemFactoryImplConstructor {

    private CacheItemFactoryImplConstructor() {}

    public static CacheItemFactory create(
        DataRouterManager dataRouterManager,
        SdkInternalConfiguration sdkInternalConfiguration,
        Cache<Urn, Date> fixtureTimestampCache
    ) {
        return new CacheItemFactoryImpl(dataRouterManager, sdkInternalConfiguration, fixtureTimestampCache);
    }
}
