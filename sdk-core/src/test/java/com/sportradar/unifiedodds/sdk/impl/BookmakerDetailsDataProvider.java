/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.impl;

import static com.testinzone.unifiedodds.sdk.caching.markets.DataProviderAnswers.withGetDataThrowingByDefault;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import com.testinzone.uf.sportsapi.datamodel.BookmakerDetails;
import com.testinzone.unifiedodds.sdk.exceptions.internal.DataProviderException;
import com.testinzone.utils.domain.names.LanguageHolder;
import org.apache.hc.core5.http.Header;

public class BookmakerDetailsDataProvider {

    public static DataProvider<BookmakerDetails> providing(
        LanguageHolder language,
        BookmakerDetails bookmakerDetails
    ) throws DataProviderException {
        DataProvider<com.testinzone.uf.sportsapi.datamodel.BookmakerDetails> dataProvider = mock(
            DataProvider.class,
            withGetDataThrowingByDefault()
        );
        doReturn(new DataWrapper<>(bookmakerDetails, new Header[] {}))
            .when(dataProvider)
            .getDataWithAdditionalInfo(language.get());
        return dataProvider;
    }
}
