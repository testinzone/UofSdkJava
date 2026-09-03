/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.impl;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.testinzone.uf.sportsapi.datamodel.MarketDescriptions;
import com.testinzone.unifiedodds.sdk.SdkInternalConfiguration;
import com.testinzone.unifiedodds.sdk.exceptions.internal.DataProviderException;

/**
 * Created on 07/11/2018.
 * // TODO @eti: Javadoc
 */
public final class DefaultAdditionalMarketMappingsProvider
    extends ObservableDataProvider<MarketDescriptions> {

    @Inject
    DefaultAdditionalMarketMappingsProvider(
        SdkInternalConfiguration config,
        LogHttpDataFetcher logHttpDataFetcher,
        @Named("SportsApiJaxbDeserializer") Deserializer deserializer
    ) {
        super("no-op-uri", config, logHttpDataFetcher, deserializer);
    }

    @Override
    public MarketDescriptions getData() throws DataProviderException {
        return null;
    }

    @Override
    public void registerWatcher(Class watcherClazz, DataProviderWatcher watcher) {
        // No-op
    }

    @Override
    public boolean logErrors() {
        return false;
    }
}
