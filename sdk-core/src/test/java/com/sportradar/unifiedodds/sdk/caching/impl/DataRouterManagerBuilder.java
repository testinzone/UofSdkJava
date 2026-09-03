/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.caching.impl;

import static org.mockito.Mockito.mock;

import com.testinzone.uf.sportsapi.datamodel.SapiCompetitorProfileEndpoint;
import com.testinzone.uf.sportsapi.datamodel.SapiLotterySchedule;
import com.testinzone.unifiedodds.sdk.SdkInternalConfiguration;
import com.testinzone.unifiedodds.sdk.caching.DataRouter;
import com.testinzone.unifiedodds.sdk.caching.DataRouterManager;
import com.testinzone.unifiedodds.sdk.impl.DataProvider;
import com.testinzone.unifiedodds.sdk.impl.SdkProducerManager;
import com.testinzone.unifiedodds.sdk.impl.SdkTaskScheduler;

@SuppressWarnings("HiddenField")
public class DataRouterManagerBuilder {

    private DataProvider<SapiLotterySchedule> lotterySchedules = mock(DataProvider.class);
    private DataRouter dataRouter = mock(DataRouter.class);
    private DataProvider<Object> summaries = mock(DataProvider.class);
    private DataProvider<SapiCompetitorProfileEndpoint> competitors = mock(DataProvider.class);

    public static DataRouterManagerBuilder create() {
        return new DataRouterManagerBuilder();
    }

    public DataRouterManagerBuilder setLotterySchedules(DataProvider<SapiLotterySchedule> lotterySchedules) {
        this.lotterySchedules = lotterySchedules;
        return this;
    }

    public DataRouterManagerBuilder withSummaries(DataProvider<Object> summaries) {
        this.summaries = summaries;
        return this;
    }

    public DataRouterManagerBuilder withCompetitors(DataProvider<SapiCompetitorProfileEndpoint> competitors) {
        this.competitors = competitors;
        return this;
    }

    public DataRouterManagerBuilder with(DataRouterImpl dataRouter) {
        this.dataRouter = dataRouter;
        return this;
    }

    public DataRouterManager build() {
        return new DataRouterManagerImpl(
            mock(SdkInternalConfiguration.class),
            mock(SdkTaskScheduler.class),
            mock(SdkProducerManager.class),
            dataRouter,
            summaries,
            mock(DataProvider.class),
            mock(DataProvider.class),
            mock(DataProvider.class),
            mock(DataProvider.class),
            mock(DataProvider.class),
            mock(DataProvider.class),
            mock(DataProvider.class),
            competitors,
            mock(DataProvider.class),
            mock(DataProvider.class),
            mock(DataProvider.class),
            mock(DataProvider.class),
            mock(DataProvider.class),
            mock(DataProvider.class),
            mock(DataProvider.class),
            lotterySchedules,
            mock(DataProvider.class),
            mock(DataProvider.class),
            mock(DataProvider.class),
            mock(DataProvider.class),
            mock(DataProvider.class),
            mock(DataProvider.class),
            mock(DataProvider.class),
            mock(DataProvider.class)
        );
    }
}
