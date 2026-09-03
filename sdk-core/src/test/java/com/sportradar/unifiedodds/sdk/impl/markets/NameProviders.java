/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.impl.markets;

import static com.testinzone.unifiedodds.sdk.ExceptionHandlingStrategies.anyErrorHandlingStrategy;
import static com.testinzone.utils.domain.markets.MarketIds.anyMarketId;
import static com.testinzone.utils.domain.producers.ProducerIds.anyProducerId;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.testinzone.unifiedodds.sdk.ExceptionHandlingStrategy;
import com.testinzone.unifiedodds.sdk.SdkInternalConfiguration;
import com.testinzone.unifiedodds.sdk.caching.ProfileCache;
import com.testinzone.unifiedodds.sdk.caching.markets.MarketDescriptionProvider;
import com.testinzone.unifiedodds.sdk.entities.SportEvent;
import com.testinzone.utils.domain.names.Languages;
import com.testinzone.utils.time.TimeUtilsStub;
import java.util.Collections;
import java.util.Optional;
import lombok.val;

public final class NameProviders {

    private NameProviders() {}

    public static BuilderViaFactoryOnly usingFactory() {
        return new BuilderViaFactoryOnly();
    }

    public static class BuilderViaFactoryOnly {

        private Optional<MarketDescriptionProvider> marketDescriptorProvider = Optional.empty();
        private Optional<ExceptionHandlingStrategy> exceptionHandlingStrategy = Optional.empty();

        public BuilderViaFactoryOnly withMarketDescriptorProvider(MarketDescriptionProvider provider) {
            marketDescriptorProvider = Optional.of(provider);
            return this;
        }

        public BuilderViaFactoryOnly withExceptionHandlingStrategy(ExceptionHandlingStrategy strategy) {
            exceptionHandlingStrategy = Optional.of(strategy);
            return this;
        }

        public NameProvider construct() {
            val config = mock(SdkInternalConfiguration.class);
            when(config.getExceptionHandlingStrategy())
                .thenReturn(exceptionHandlingStrategy.orElse(anyErrorHandlingStrategy()));
            val factory = new NameProviderFactoryImpl(
                marketDescriptorProvider.orElse(mock(MarketDescriptionProvider.class)),
                mock(ProfileCache.class),
                mock(NameExpressionFactory.class),
                config,
                mock(TimeUtilsStub.class)
            );
            return factory.buildNameProvider(
                mock(SportEvent.class),
                anyMarketId(),
                Collections.emptyMap(),
                anyProducerId()
            );
        }
    }
}
