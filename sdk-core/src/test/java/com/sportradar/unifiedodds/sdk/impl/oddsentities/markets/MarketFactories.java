/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.impl.oddsentities.markets;

import static com.testinzone.unifiedodds.sdk.ExceptionHandlingStrategies.anyErrorHandlingStrategy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.testinzone.unifiedodds.sdk.ExceptionHandlingStrategies;
import com.testinzone.unifiedodds.sdk.ExceptionHandlingStrategy;
import com.testinzone.unifiedodds.sdk.SdkInternalConfiguration;
import com.testinzone.unifiedodds.sdk.caching.LocalizedNamedValueCache;
import com.testinzone.unifiedodds.sdk.caching.NamedValueCache;
import com.testinzone.unifiedodds.sdk.caching.ProfileCache;
import com.testinzone.unifiedodds.sdk.caching.impl.NamedValuesProviderImpl;
import com.testinzone.unifiedodds.sdk.caching.markets.MarketDescriptionProvider;
import com.testinzone.unifiedodds.sdk.impl.TimeUtils;
import com.testinzone.unifiedodds.sdk.impl.markets.NameExpressionFactoryImpl;
import com.testinzone.unifiedodds.sdk.impl.markets.NameProviderFactoryImpl;
import com.testinzone.unifiedodds.sdk.impl.markets.OperandFactoryImpl;
import com.testinzone.utils.domain.names.Languages;
import com.testinzone.utils.time.TimeUtilsStub;
import java.util.Locale;
import java.util.Optional;
import lombok.val;

public class MarketFactories {

    public static class BuilderStubbingOutSportEventAndCaches {

        private Optional<MarketDescriptionProvider> marketDescriptionProvider = Optional.empty();
        private Optional<ExceptionHandlingStrategy> exceptionHandlingStrategy = Optional.empty();
        private Optional<Locale> defaultLanguage = Optional.empty();
        private Optional<TimeUtils> time = Optional.empty();

        public static BuilderStubbingOutSportEventAndCaches stubbingOutSportEventAndCaches() {
            return new BuilderStubbingOutSportEventAndCaches();
        }

        public BuilderStubbingOutSportEventAndCaches with(MarketDescriptionProvider provider) {
            this.marketDescriptionProvider = Optional.of(provider);
            return this;
        }

        public BuilderStubbingOutSportEventAndCaches with(ExceptionHandlingStrategy strategy) {
            this.exceptionHandlingStrategy = Optional.of(strategy);
            return this;
        }

        @SuppressWarnings("HiddenField")
        public BuilderStubbingOutSportEventAndCaches with(TimeUtils time) {
            this.time = Optional.of(time);
            return this;
        }

        public BuilderStubbingOutSportEventAndCaches withDefaultLanguage(Locale language) {
            this.defaultLanguage = Optional.of(language);
            return this;
        }

        public MarketFactory build() {
            val profileCache = mock(ProfileCache.class);
            val config = mock(SdkInternalConfiguration.class);
            when(config.getExceptionHandlingStrategy())
                .thenReturn(exceptionHandlingStrategy.orElse(anyErrorHandlingStrategy()));
            when(config.getDefaultLocale()).thenReturn(defaultLanguage.orElse(Languages.any()));
            return new MarketFactoryImpl(
                marketDescriptionProvider.orElse(mock(MarketDescriptionProvider.class)),
                new NameProviderFactoryImpl(
                    marketDescriptionProvider.orElse(mock(MarketDescriptionProvider.class)),
                    profileCache,
                    new NameExpressionFactoryImpl(new OperandFactoryImpl(), profileCache),
                    config,
                    time.orElse(mock(TimeUtils.class))
                ),
                new NamedValuesProviderImpl(
                    mock(NamedValueCache.class),
                    mock(NamedValueCache.class),
                    mock(NamedValueCache.class),
                    mock(LocalizedNamedValueCache.class)
                ),
                config
            );
        }
    }
}
