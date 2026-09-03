/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.testinzone.uf.sportsapi.datamodel.DescVariant;
import com.testinzone.uf.sportsapi.datamodel.VariantDescriptions;
import com.testinzone.unifiedodds.sdk.exceptions.internal.DataProviderException;
import com.testinzone.utils.domain.names.LanguageHolder;
import lombok.val;

public final class VariantDescriptionDataProviders {

    public static DataProvider<VariantDescriptions> providingList(
        LanguageHolder language,
        DescVariant variantDescription
    ) throws DataProviderException {
        DataProvider<VariantDescriptions> dataProvider = mock(DataProvider.class);
        when(dataProvider.getData(language.get())).thenReturn(getVariantDescriptions(variantDescription));
        return dataProvider;
    }

    private static VariantDescriptions getVariantDescriptions(DescVariant variant) {
        val descriptions = new VariantDescriptions();
        descriptions.getVariant().add(variant);
        return descriptions;
    }
}
