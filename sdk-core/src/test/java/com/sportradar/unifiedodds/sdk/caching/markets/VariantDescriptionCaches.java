/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.caching.markets;

import static com.testinzone.unifiedodds.sdk.caching.markets.DataProviderAnswers.withGetDataThrowingByDefault;
import static com.testinzone.utils.domain.names.Languages.anyLanguages;
import static java.util.Optional.ofNullable;
import static org.mockito.Mockito.mock;

import com.google.common.cache.CacheBuilder;
import com.testinzone.uf.sportsapi.datamodel.VariantDescriptions;
import com.testinzone.unifiedodds.sdk.impl.DataProvider;
import com.testinzone.unifiedodds.sdk.impl.SdkTaskScheduler;
import com.testinzone.unifiedodds.sdk.impl.markets.mappings.MappingValidatorFactoryImpl;

public class VariantDescriptionCaches {

    public static VariantDescriptionCachesBuilder stubbingOutDataProvidersAndScheduler() {
        return new VariantDescriptionCachesBuilder();
    }

    public static class VariantDescriptionCachesBuilder {

        private DataProvider<VariantDescriptions> dataProvider;

        public VariantDescriptionCachesBuilder with(DataProvider<VariantDescriptions> provider) {
            this.dataProvider = provider;
            return this;
        }

        public VariantDescriptionCache build() {
            return new VariantDescriptionCacheImpl(
                CacheBuilder.newBuilder().build(),
                ofNullable(dataProvider).orElse(mock(DataProvider.class, withGetDataThrowingByDefault())),
                new MappingValidatorFactoryImpl(),
                mock(SdkTaskScheduler.class),
                anyLanguages()
            );
        }
    }
}
