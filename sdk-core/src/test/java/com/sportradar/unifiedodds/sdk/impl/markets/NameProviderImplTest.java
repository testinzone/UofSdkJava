/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.impl.markets;

import static com.testinzone.unifiedodds.sdk.ExceptionHandlingStrategy.Catch;
import static com.testinzone.unifiedodds.sdk.ExceptionHandlingStrategy.Throw;
import static com.testinzone.unifiedodds.sdk.caching.markets.MarketDescriptionFactory.namesOf;
import static com.testinzone.unifiedodds.sdk.caching.markets.MarketDescriptionProviders.subbingOutCaches;
import static com.testinzone.unifiedodds.sdk.caching.markets.MarketDescriptorProviders.noMarketDescribingProvider;
import static com.testinzone.unifiedodds.sdk.caching.markets.MarketDescriptorProviders.providing;
import static com.testinzone.unifiedodds.sdk.conn.SapiMarketDescriptions.OddEven.oddEvenMarketDescription;
import static com.testinzone.unifiedodds.sdk.impl.markets.NameProviders.usingFactory;
import static com.testinzone.utils.domain.names.LanguageHolder.in;
import static com.testinzone.utils.domain.names.Languages.anyLanguages;
import static java.util.Collections.singletonList;
import static java.util.Locale.ENGLISH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;

import com.testinzone.uf.sportsapi.datamodel.DescMarket;
import com.testinzone.unifiedodds.sdk.SdkInternalConfiguration;
import com.testinzone.unifiedodds.sdk.caching.ProfileCache;
import com.testinzone.unifiedodds.sdk.caching.markets.MarketDescriptionProvider;
import com.testinzone.unifiedodds.sdk.exceptions.NameGenerationException;
import com.testinzone.unifiedodds.sdk.exceptions.internal.CacheItemNotFoundException;
import com.testinzone.unifiedodds.sdk.impl.TimeUtils;
import com.testinzone.utils.domain.names.Languages;
import lombok.val;
import org.junit.Test;

public class NameProviderImplTest {

    @Test
    public void failsToConstructWithoutRequiredArguments() {
        val profiles = mock(ProfileCache.class);
        val expr = mock(NameExpressionFactory.class);
        val config = mock(SdkInternalConfiguration.class);
        val time = mock(TimeUtils.class);
        val desc = mock(MarketDescriptionProvider.class);
        assertThatThrownBy(() -> new NameProviderFactoryImpl(null, profiles, expr, config, time))
            .isInstanceOf(NullPointerException.class);
        assertThatThrownBy(() -> new NameProviderFactoryImpl(desc, null, expr, config, time))
            .isInstanceOf(NullPointerException.class);
        assertThatThrownBy(() -> new NameProviderFactoryImpl(desc, profiles, null, config, time))
            .isInstanceOf(NullPointerException.class);
        assertThatThrownBy(() -> new NameProviderFactoryImpl(desc, profiles, expr, null, time))
            .isInstanceOf(NullPointerException.class);
        assertThatThrownBy(() -> new NameProviderFactoryImpl(desc, profiles, expr, config, null))
            .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void throwsOnMarketNotFoundWhenSdkConfiguredToThrow() throws CacheItemNotFoundException {
        val nameProvider = usingFactory()
            .withMarketDescriptorProvider(subbingOutCaches().build())
            .withExceptionHandlingStrategy(Throw)
            .construct();

        assertThatThrownBy(() -> nameProvider.getMarketNames(singletonList(Languages.any())))
            .isInstanceOf(NameGenerationException.class)
            .hasMessageContaining("Failed to retrieve market name descriptor");
        assertThatThrownBy(() -> nameProvider.getMarketName(Languages.any()))
            .isInstanceOf(NameGenerationException.class)
            .hasMessageContaining("Failed to retrieve market name descriptor");
    }

    @Test
    public void returnsNullOnMarketMissingNameWhenSdkConfiguredToCatch() {
        val aLanguage = ENGLISH;
        val nameProvider = usingFactory()
            .withMarketDescriptorProvider(
                providing(
                    in(aLanguage),
                    namesOf(nullifyName(oddEvenMarketDescription(aLanguage)), in(aLanguage))
                )
            )
            .withExceptionHandlingStrategy(Catch)
            .construct();

        assertThat(nameProvider.getMarketName(aLanguage)).isNull();
    }

    private DescMarket nullifyName(DescMarket market) {
        market.setName("");
        return market;
    }

    @Test
    public void swallowsOnMarketNotFoundWhenSdkConfiguredToCatch() {
        val nameProvider = usingFactory()
            .withMarketDescriptorProvider(noMarketDescribingProvider())
            .withExceptionHandlingStrategy(Catch)
            .construct();

        assertThat(nameProvider.getMarketNames(anyLanguages())).isNull();
        assertThat(nameProvider.getMarketName(Languages.any())).isNull();
    }
}
