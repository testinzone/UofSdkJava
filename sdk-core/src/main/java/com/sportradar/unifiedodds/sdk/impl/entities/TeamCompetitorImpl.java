/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.impl.entities;

import com.testinzone.unifiedodds.sdk.ExceptionHandlingStrategy;
import com.testinzone.unifiedodds.sdk.SportEntityFactory;
import com.testinzone.unifiedodds.sdk.caching.CompetitorCi;
import com.testinzone.unifiedodds.sdk.caching.ProfileCache;
import com.testinzone.unifiedodds.sdk.caching.SportEventCi;
import com.testinzone.unifiedodds.sdk.entities.TeamCompetitor;
import com.testinzone.utils.Urn;
import java.util.List;
import java.util.Locale;

/**
 * Represents a competing team
 */
@SuppressWarnings({ "ParameterNumber", "UnnecessaryParentheses" })
public class TeamCompetitorImpl extends CompetitorImpl implements TeamCompetitor {

    /**
     * Initializes a new instance of the {@link TeamCompetitorImpl} class
     *
     * @param competitorId the associated competitor id
     * @param profileCache the cache instance used to retrieve the cached data
     * @param qualifier the associated team qualifier
     * @param isVirtual indication if the competitor is marked as virtual
     * @param parentSportEventCi the {@link SportEventCi} this {@link CompetitorCi} belongs to
     * @param locales a {@link List} in which is provided the {@link CompetitorCi}
     * @param sportEntityFactory the factory used to create additional entities
     * @param exceptionHandlingStrategy the exception handling strategy
     */
    public TeamCompetitorImpl(
        Urn competitorId,
        ProfileCache profileCache,
        String qualifier,
        Integer division,
        Boolean isVirtual,
        SportEventCi parentSportEventCi,
        List<Locale> locales,
        SportEntityFactory sportEntityFactory,
        ExceptionHandlingStrategy exceptionHandlingStrategy
    ) {
        super(
            competitorId,
            profileCache,
            parentSportEventCi,
            locales,
            sportEntityFactory,
            exceptionHandlingStrategy,
            isVirtual
        );
        TeamQualifier = qualifier;
        TeamDivision = division;
    }

    /**
     * Returns the qualifier additionally describing the competitor (e.g. home, away, ...)
     *
     * @return - the qualifier additionally describing the competitor (e.g. home, away, ...)
     */
    @Override
    public String getQualifier() {
        FetchEventCompetitorsQualifiers();
        return TeamQualifier;
    }

    /**
     * Returns a {@link String} describing the current {@link TeamCompetitor} instance
     *
     * @return - a {@link String} describing the current {@link TeamCompetitor} instance
     */
    @Override
    public String toString() {
        return (
            "TeamCompetitorImpl{" +
            "qualifier='" +
            TeamQualifier +
            '\'' +
            "division='" +
            TeamDivision +
            '\'' +
            "} " +
            super.toString()
        );
    }
}
