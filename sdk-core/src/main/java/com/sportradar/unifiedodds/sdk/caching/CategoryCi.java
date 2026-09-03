/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.caching;

import com.testinzone.utils.Urn;
import java.util.List;

/**
 * Defines methods used to access cached category entity data
 */
public interface CategoryCi extends CacheItem {
    /**
     * Returns the {@link Urn} specifying the id of the associated sport
     *
     * @return the {@link Urn} specifying the id of the associated sport
     */
    Urn getSportId();

    /**
     * Returns a {@link String} representing a country code
     *
     * @return a {@link String} representing a country code
     */
    String getCountryCode();

    /**
     * Returns a {@link List} containing the ids of associated tournaments
     *
     * @return a {@link List} containing the ids of associated tournaments
     */
    List<Urn> getTournamentIds();
}
