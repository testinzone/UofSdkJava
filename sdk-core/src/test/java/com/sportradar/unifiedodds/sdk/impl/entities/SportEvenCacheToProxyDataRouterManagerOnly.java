/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.impl.entities;

import static org.mockito.Mockito.mock;

import com.google.common.cache.Cache;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Provides;
import com.testinzone.unifiedodds.sdk.SdkInternalConfiguration;
import com.testinzone.unifiedodds.sdk.caching.DataRouterManager;
import com.testinzone.unifiedodds.sdk.caching.SportEventCi;
import com.testinzone.unifiedodds.sdk.caching.impl.SportEventCacheImpl;
import com.testinzone.unifiedodds.sdk.caching.impl.ci.CacheItemFactory;
import com.testinzone.unifiedodds.sdk.impl.MappingTypeProvider;
import com.testinzone.utils.Urn;

public class SportEvenCacheToProxyDataRouterManagerOnly {

    private SportEvenCacheToProxyDataRouterManagerOnly() {}

    public static SportEventCacheImpl create(final DataRouterManager dataRouterManager) {
        return Guice
            .createInjector(new SportEvenCacheToProxyDataRouterManagerModule(dataRouterManager))
            .getInstance(SportEventCacheImpl.class);
    }

    private static class SportEvenCacheToProxyDataRouterManagerModule extends AbstractModule {

        private DataRouterManager dataRouterManager;

        public SportEvenCacheToProxyDataRouterManagerModule(final DataRouterManager dataRouterManager) {
            this.dataRouterManager = dataRouterManager;
        }

        @Override
        protected void configure() {}

        @Provides
        public CacheItemFactory mockCacheItemFactory() {
            return mock(CacheItemFactory.class);
        }

        @Provides
        public MappingTypeProvider mockMappingTypeProvider() {
            return mock(MappingTypeProvider.class);
        }

        @Provides
        public DataRouterManager mockDataRouterManager() {
            return dataRouterManager;
        }

        @Provides
        public SdkInternalConfiguration mockSdkConfig() {
            return mock(SdkInternalConfiguration.class);
        }

        @Provides
        public Cache<Urn, SportEventCi> mockGuavaCache() {
            return mock(Cache.class);
        }
    }
}
