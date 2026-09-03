/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.impl;

import static com.testinzone.unifiedodds.sdk.caching.markets.DataProviderAnswers.withGetDataThrowingByDefault;
import static com.testinzone.utils.generic.testing.Urls.anyHttpUrl;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import com.testinzone.uf.sportsapi.datamodel.SapiMatchSummaryEndpoint;
import com.testinzone.utils.domain.names.LanguageHolder;
import lombok.SneakyThrows;

public class SummaryDataProviders {

    @SneakyThrows
    public static DataProvider<Object> providing(
        LanguageHolder language,
        String sportEventId,
        SapiMatchSummaryEndpoint summary
    ) {
        DataProvider<Object> dataProvider = mock(DataProvider.class, withGetDataThrowingByDefault());
        doReturn(summary).when(dataProvider).getData(language.get(), sportEventId);
        doReturn(anyHttpUrl().toString()).when(dataProvider).getFinalUrl(language.get(), sportEventId);
        return dataProvider;
    }
}
