/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.shared;

import static com.testinzone.unifiedodds.sdk.impl.ProducerDataProviderStubs.anyProducerDataProvider;
import static com.testinzone.unifiedodds.sdk.impl.apireaders.WhoAmIReaderStubs.anyBookmakerDetailsReader;

import com.testinzone.uf.sportsapi.datamodel.ResponseCode;
import com.testinzone.unifiedodds.sdk.ExceptionHandlingStrategy;
import com.testinzone.unifiedodds.sdk.cfg.Environment;
import com.testinzone.unifiedodds.sdk.cfg.UofConfiguration;
import com.testinzone.unifiedodds.sdk.cfg.UofConfigurationImpl;
import com.testinzone.unifiedodds.sdk.entities.BookmakerDetails;
import com.testinzone.unifiedodds.sdk.impl.entities.BookmakerDetailsImpl;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class StubUofConfiguration extends UofConfigurationImpl implements UofConfiguration {

    private int nbrSetEnvironmentCalled;

    public StubUofConfiguration() {
        super(anyConfig -> anyBookmakerDetailsReader(), anyConfig -> anyProducerDataProvider());
        setAccessToken("accessToken");
        setDefaultLanguage(Locale.ENGLISH);
        setNodeId(1);
        updateSdkEnvironment(Environment.GlobalIntegration);
        setExceptionHandlingStrategy(ExceptionHandlingStrategy.Throw);

        validateMinimumSettings();
    }

    public void setEnvironment(Environment environment) {
        nbrSetEnvironmentCalled = +1;
        updateSdkEnvironment(environment);
    }

    public int getNbrSetEnvironmentCalled() {
        return nbrSetEnvironmentCalled;
    }

    public void resetNbrSetEnvironmentCalled() {
        nbrSetEnvironmentCalled = 0;
    }

    private static BookmakerDetails getStupBookmakerDetails() {
        BookmakerDetails bookmakerDetails = new BookmakerDetailsImpl(
            2,
            getVirtualHost(2),
            Date.from(Instant.now().plus(2, ChronoUnit.DAYS)),
            ResponseCode.ACCEPTED,
            "All good",
            Duration.ofSeconds(1)
        );
        return bookmakerDetails;
    }

    private static String getVirtualHost(int bookmakerId) {
        return "/unifiedfeed/" + bookmakerId;
    }
}
