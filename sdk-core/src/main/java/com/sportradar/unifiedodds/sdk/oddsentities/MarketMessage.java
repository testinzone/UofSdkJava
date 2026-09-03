/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.oddsentities;

import com.testinzone.unifiedodds.sdk.entities.SportEvent;
import java.util.List;

/**
 * The basic message that contains data regarding market changes
 *
 */
public interface MarketMessage<T extends SportEvent> extends EventMessage<T> {
    /**
     * Returns a list of markets that are affected by the associated message
     *
     * @return the list of affected markets
     */
    List<? extends Market> getMarkets();
}
