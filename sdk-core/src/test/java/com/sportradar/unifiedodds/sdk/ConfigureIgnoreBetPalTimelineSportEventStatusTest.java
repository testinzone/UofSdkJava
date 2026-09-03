/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk;

import static com.testinzone.unifiedodds.sdk.impl.ProducerDataProviderStubs.providerOfSingleEmptyProducer;
import static com.testinzone.unifiedodds.sdk.impl.apireaders.WhoAmIReaderStubs.emptyBookmakerDetailsReader;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import com.testinzone.unifiedodds.sdk.cfg.Environment;
import com.testinzone.unifiedodds.sdk.cfg.StubSdkConfigurationPropertiesReader;
import com.testinzone.unifiedodds.sdk.cfg.StubSdkConfigurationYamlReader;
import com.testinzone.unifiedodds.sdk.cfg.TokenSetter;
import com.testinzone.unifiedodds.sdk.cfg.TokenSetterImpl;
import com.testinzone.unifiedodds.sdk.cfg.UofConfiguration;
import com.testinzone.utils.domain.names.Languages;
import java.util.Map;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class ConfigureIgnoreBetPalTimelineSportEventStatusTest {

    @Test
    public void withoutConfiguringDefaultsToRespecting() {
        UofConfiguration config = buildViaJavaApi()
            .setAccessToken("any")
            .selectEnvironment(Environment.Integration)
            .setDefaultLanguage(Languages.any())
            .build();

        assertThat(config.getCache().getIgnoreBetPalTimelineSportEventStatus()).isEqualTo(false);
    }

    @Test
    public void configureViaJavaApiToIgnore() {
        boolean ignore = true;
        try (
            MockedStatic<RuntimeConfiguration> operationManager = Mockito.mockStatic(
                RuntimeConfiguration.class
            )
        ) {
            UofConfiguration config = buildViaJavaApi()
                .setAccessToken("any")
                .selectEnvironment(Environment.Integration)
                .setDefaultLanguage(Languages.any())
                .setIgnoreBetPalTimelineSportEventStatus(ignore)
                .build();

            operationManager.verify(() -> RuntimeConfiguration.setIgnoreBetPalTimelineSportEventStatus(ignore)
            );
            assertThat(config.getCache().getIgnoreBetPalTimelineSportEventStatus()).isEqualTo(ignore);
        }
    }

    @Test
    public void configureViaJavaApiToRespect() {
        try (
            MockedStatic<RuntimeConfiguration> operationManager = Mockito.mockStatic(
                RuntimeConfiguration.class
            )
        ) {
            UofConfiguration config = buildViaJavaApi()
                .setAccessToken("any")
                .selectEnvironment(Environment.Integration)
                .setDefaultLanguage(Languages.any())
                .setIgnoreBetPalTimelineSportEventStatus(false)
                .build();

            operationManager.verify(() -> RuntimeConfiguration.setIgnoreBetPalTimelineSportEventStatus(false)
            );
            assertThat(config.getCache().getIgnoreBetPalTimelineSportEventStatus()).isFalse();
        }
    }

    private TokenSetter buildViaJavaApi() {
        final Map<String, String> anyYamlFileContent = mock(Map.class);
        final Map<String, String> anyPropertiesFileContent = mock(Map.class);
        final TokenSetter buildFromPropsFile = new TokenSetterImpl(
            new StubSdkConfigurationPropertiesReader(anyPropertiesFileContent),
            new StubSdkConfigurationYamlReader(anyYamlFileContent),
            anyConfig -> emptyBookmakerDetailsReader(),
            anyConfig -> providerOfSingleEmptyProducer()
        );
        return buildFromPropsFile;
    }
}
