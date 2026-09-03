/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk;

import static com.testinzone.unifiedodds.sdk.impl.ProducerDataProviderStubs.providerOfSingleEmptyProducer;
import static com.testinzone.unifiedodds.sdk.impl.apireaders.WhoAmIReaderStubs.emptyBookmakerDetailsReader;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;

import com.testinzone.unifiedodds.sdk.cfg.Environment;
import com.testinzone.unifiedodds.sdk.cfg.StubSdkConfigurationPropertiesReader;
import com.testinzone.unifiedodds.sdk.cfg.StubSdkConfigurationYamlReader;
import com.testinzone.unifiedodds.sdk.cfg.TokenSetter;
import com.testinzone.unifiedodds.sdk.cfg.TokenSetterImpl;
import com.testinzone.unifiedodds.sdk.cfg.UofConfiguration;
import com.testinzone.utils.domain.names.Languages;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class ConfigureRabbitHeartBeatTest {

    private static final int DEFAULT_TIMEOUT_IN_SECONDS = 60;
    private static final String ANY = "any";

    @Test
    public void withoutConfiguringDefaultsTo60seconds() {
        UofConfiguration config = buildViaJavaApi()
            .setAccessToken(ANY)
            .selectEnvironment(Environment.Integration)
            .setDefaultLanguage(Languages.any())
            .build();

        assertThat(config.getRabbit().getHeartBeat()).isEqualTo(asDuration(DEFAULT_TIMEOUT_IN_SECONDS));
    }

    @Test
    public void configureViaJavaApi() {
        final int timeoutSeconds = 15;
        try (
            MockedStatic<RuntimeConfiguration> operationManager = Mockito.mockStatic(
                RuntimeConfiguration.class
            )
        ) {
            UofConfiguration config = buildViaJavaApi()
                .setAccessToken(ANY)
                .selectEnvironment(Environment.Integration)
                .setDefaultLanguage(Languages.any())
                .setRabbitHeartbeat(timeoutSeconds)
                .build();

            operationManager.verify(() -> RuntimeConfiguration.setRabbitHeartbeat(timeoutSeconds));
            assertThat(config.getRabbit().getHeartBeat()).isEqualTo(asDuration(timeoutSeconds));
        }
    }

    @Test
    public void notConfigureViaJavaApiIfTimeoutIfTooLow() {
        int tooLowTimeout = 1;
        try (
            MockedStatic<RuntimeConfiguration> operationManager = Mockito.mockStatic(
                RuntimeConfiguration.class
            )
        ) {
            assertThatThrownBy(() ->
                buildViaJavaApi()
                    .setAccessToken(ANY)
                    .selectEnvironment(Environment.Integration)
                    .setDefaultLanguage(Languages.any())
                    .setRabbitHeartbeat(tooLowTimeout)
                    .build()
            );

            operationManager.verify(() -> RuntimeConfiguration.setRabbitHeartbeat(tooLowTimeout), never());
            assertThat(
                buildViaJavaApi()
                    .setAccessToken(ANY)
                    .selectEnvironment(Environment.Integration)
                    .setDefaultLanguage(Languages.any())
                    .build()
                    .getRabbit()
                    .getHeartBeat()
            )
                .isEqualTo(asDuration(DEFAULT_TIMEOUT_IN_SECONDS));
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

    private static Duration asDuration(int timeoutSeconds) {
        return Duration.of(timeoutSeconds, ChronoUnit.SECONDS);
    }
}
