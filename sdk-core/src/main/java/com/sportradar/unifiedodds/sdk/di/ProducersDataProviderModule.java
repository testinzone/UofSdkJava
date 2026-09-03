/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.di;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.testinzone.uf.sportsapi.datamodel.Producers;
import com.testinzone.unifiedodds.sdk.SdkInternalConfiguration;
import com.testinzone.unifiedodds.sdk.impl.DataProvider;
import com.testinzone.unifiedodds.sdk.impl.Deserializer;
import com.testinzone.unifiedodds.sdk.impl.LogHttpDataFetcher;
import com.testinzone.unifiedodds.sdk.impl.ProducerDataProvider;
import com.testinzone.unifiedodds.sdk.impl.ProducerDataProviderImpl;

public class ProducersDataProviderModule implements Module {

    private SdkInternalConfiguration config;

    ProducersDataProviderModule(SdkInternalConfiguration config) {
        this.config = config;
    }

    @Override
    public void configure(Binder binder) {
        binder.bind(ProducerDataProvider.class).to(ProducerDataProviderImpl.class).in(Singleton.class);
    }

    @Provides
    @Singleton
    private DataProvider<Producers> providesProducersDataProvider(
        LogHttpDataFetcher logHttpDataFetcher,
        @Named("SportsApiJaxbDeserializer") Deserializer deserializer
    ) {
        return new DataProvider<>("/descriptions/producers.xml", config, logHttpDataFetcher, deserializer);
    }
}
