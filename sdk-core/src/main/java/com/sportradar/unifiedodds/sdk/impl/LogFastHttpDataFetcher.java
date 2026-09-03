/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.impl;

import com.google.common.base.Stopwatch;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.testinzone.unifiedodds.sdk.LoggerDefinitions;
import com.testinzone.unifiedodds.sdk.SdkInternalConfiguration;
import com.testinzone.unifiedodds.sdk.exceptions.internal.CommunicationException;
import java.util.concurrent.TimeUnit;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Wrapper class for the {@link HttpDataFetcher} with the sole purpose of API request logging
 */
@SuppressWarnings({ "ConstantName" })
public class LogFastHttpDataFetcher extends HttpDataFetcher {

    private static final Logger logger = LoggerFactory.getLogger(LogFastHttpDataFetcher.class);
    private static final Logger trafficLogger = LoggerFactory.getLogger(
        LoggerDefinitions.UfSdkRestTrafficLog.class
    );

    @Inject
    public LogFastHttpDataFetcher(
        SdkInternalConfiguration config,
        @Named("FastHttpClient") CloseableHttpClient httpClient,
        UnifiedOddsStatistics statsBean,
        HttpResponseHandler responseDataHandler,
        UserAgentProvider userAgentProvider
    ) {
        super(config, httpClient, statsBean, responseDataHandler, userAgentProvider);
    }

    @Override
    protected HttpData send(ClassicHttpRequest request, String path) throws CommunicationException {
        logger.info("Fetching data from: " + path);
        Stopwatch timer = Stopwatch.createStarted();
        HttpData result;
        try {
            result = super.send(request, path);
        } catch (CommunicationException e) {
            trafficLogger.info(
                "Request[DataFetcher]: {}, response - FAILED({} ms), ex:",
                path,
                timer.stop().elapsed(TimeUnit.MILLISECONDS),
                e
            );
            throw e;
        }

        if (trafficLogger.isInfoEnabled()) {
            String cleanResponse = result.getResponse() == null
                ? null
                : result.getResponse().replace("\n", "");
            trafficLogger.info(
                "Request[DataFetcher]: {}, response - OK({} ms): {}",
                path,
                timer.stop().elapsed(TimeUnit.MILLISECONDS),
                cleanResponse
            );
        }

        return result;
    }
}
