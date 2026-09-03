/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.entities;

import java.util.List;

/**
 * Defines methods implemented by classes representing sport category
 */
@SuppressWarnings({ "LineLength" })
public interface Category extends CategorySummary {
    /**
     * Returns an unmodifiable {@link List} of tournaments which belong to the category represented by the current instance
     * (possible types: {@link com.testinzone.unifiedodds.sdk.entities.BasicTournament}, {@link Tournament}, {@link com.testinzone.unifiedodds.sdk.entities.Stage})
     *
     * @return - an unmodifiable {@link List} of tournaments which belong to the category represented by the current instance
     */
    List<SportEvent> getTournaments();
}
