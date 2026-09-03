/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.caching;

import com.testinzone.utils.Urn;
import java.util.List;

/**
 * Defines methods used to access cached sports data
 */
public interface SportCi extends CacheItem {
    /**
     * Returns a {@link List} specifying the id's of associated categories
     *
     * @return a {@link List} specifying the id's of associated categories
     */
    List<Urn> getCategoryIds();

    /**
     * Returns if categories should be fetched
     *
     * @return if categories should be fetched
     */
    boolean getShouldFetchCategories();

    /**
     * Clears ShouldFetchCategories flag
     */
    void categoriesFetched();
}
