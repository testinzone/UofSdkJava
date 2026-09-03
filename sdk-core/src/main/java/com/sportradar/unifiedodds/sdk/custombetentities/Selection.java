/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.custombetentities;

import com.testinzone.utils.Urn;

/**
 * Provides an requested selection
 */
public interface Selection {
    /**
     * Gets the event id
     *
     * @return the {@link Urn} of the event
     */
    Urn getEventId();

    /**
     * Gets the market id
     *
     * @return the market id
     */
    int getMarketId();

    /**
     * Gets the specifiers
     *
     * @return the specifiers
     */
    String getSpecifiers();

    /**
     * Gets the outcome id
     *
     * @return the outcome id
     */
    String getOutcomeId();
}
