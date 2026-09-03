/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.oddsentities;

import com.testinzone.unifiedodds.sdk.entities.NamedValue;

/**
 * Information about a market that was cancelled
 */
public interface MarketCancel extends Market {
    /**
     * Returns the void reason descriptor
     *
     * @return the void reason descriptor
     */
    NamedValue getVoidReasonValue();

    /**
     * Returns the void reason description
     *
     * @return the void reason description
     */
    String getVoidReason();
}
