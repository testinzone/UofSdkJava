/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.custombetentities;

import com.testinzone.utils.Urn;
import java.util.List;

/**
 * Provides an available selections for a particular event
 */
public interface AvailableSelectionsFilter {
    /**
     * Returns the {@link Urn} of the event
     * @return the {@link Urn} of the event
     */
    Urn getEvent();

    /**
     * Returns the list of markets for this event
     * @return the list of markets for this event
     */
    List<MarketFilter> getMarkets();
}
