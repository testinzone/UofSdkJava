/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.di;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.testinzone.uf.custombet.datamodel.CapiAvailableSelections;
import com.testinzone.uf.custombet.datamodel.CapiCalculationResponse;
import com.testinzone.uf.custombet.datamodel.CapiFilteredCalculationResponse;
import com.testinzone.unifiedodds.sdk.CustomBetSelectionBuilder;
import com.testinzone.unifiedodds.sdk.CustomBetSelectionBuilderImpl;
import com.testinzone.unifiedodds.sdk.SdkInternalConfiguration;
import com.testinzone.unifiedodds.sdk.impl.DataProvider;
import com.testinzone.unifiedodds.sdk.impl.Deserializer;
import com.testinzone.unifiedodds.sdk.impl.LogHttpDataFetcher;

/**
 * The DI module in charge of custom bet API readers
 */
public class CustomBetModule extends AbstractModule {

    /**
     * Configures a {@link Binder} via the exposed methods.
     */
    @Override
    protected void configure() {
        bind(CustomBetSelectionBuilder.class).to(CustomBetSelectionBuilderImpl.class);
    }

    @Provides
    private DataProvider<CapiAvailableSelections> providesAvailableSelectionsDataProvider(
        SdkInternalConfiguration cfg,
        LogHttpDataFetcher httpDataFetcher,
        @Named("CustomBetApiJaxbDeserializer") Deserializer deserializer
    ) {
        return new DataProvider<>("/custombet/%2$s/available_selections", cfg, httpDataFetcher, deserializer);
    }

    @Provides
    private DataProvider<CapiCalculationResponse> providesCalculateProbabilityDataProvider(
        SdkInternalConfiguration cfg,
        LogHttpDataFetcher httpDataFetcher,
        @Named("CustomBetApiJaxbDeserializer") Deserializer deserializer
    ) {
        return new DataProvider<>("/custombet/calculate", cfg, httpDataFetcher, deserializer);
    }

    @Provides
    private DataProvider<CapiFilteredCalculationResponse> providesCalculateProbabilityFilterDataProvider(
        SdkInternalConfiguration cfg,
        LogHttpDataFetcher httpDataFetcher,
        @Named("CustomBetApiJaxbDeserializer") Deserializer deserializer
    ) {
        return new DataProvider<>("/custombet/calculate-filter", cfg, httpDataFetcher, deserializer);
    }
}
