/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.impl.markets;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.testinzone.unifiedodds.sdk.ExceptionHandlingStrategy;
import com.testinzone.unifiedodds.sdk.SdkInternalConfiguration;
import com.testinzone.unifiedodds.sdk.caching.ProfileCache;
import com.testinzone.unifiedodds.sdk.caching.markets.MarketDescriptionProvider;
import com.testinzone.unifiedodds.sdk.entities.SportEvent;
import com.testinzone.unifiedodds.sdk.impl.TimeUtils;
import java.util.Map;

/**
 * Created on 20/06/2017.
 * // TODO @eti: Javadoc
 */
public class NameProviderFactoryImpl implements NameProviderFactory {

    private final MarketDescriptionProvider descriptorProvider;
    private final ProfileCache profileCache;
    private final NameExpressionFactory expressionFactory;
    private final ExceptionHandlingStrategy exceptionHandlingStrategy;
    private final TimeUtils time;

    @Inject
    public NameProviderFactoryImpl(
        MarketDescriptionProvider descriptorProvider,
        ProfileCache profileCache,
        NameExpressionFactory expressionFactory,
        SdkInternalConfiguration cfg,
        TimeUtils time
    ) {
        Preconditions.checkNotNull(descriptorProvider);
        Preconditions.checkNotNull(profileCache);
        Preconditions.checkNotNull(expressionFactory);
        Preconditions.checkNotNull(time);

        this.descriptorProvider = descriptorProvider;
        this.profileCache = profileCache;
        this.expressionFactory = expressionFactory;
        this.exceptionHandlingStrategy = cfg.getExceptionHandlingStrategy();
        this.time = time;
    }

    @Override
    public NameProvider buildNameProvider(
        SportEvent sportEvent,
        int marketId,
        Map<String, String> specifiers,
        int producerId
    ) {
        return new NameProviderImpl(
            descriptorProvider,
            profileCache,
            expressionFactory,
            sportEvent,
            marketId,
            specifiers,
            producerId,
            exceptionHandlingStrategy,
            time
        );
    }
}
