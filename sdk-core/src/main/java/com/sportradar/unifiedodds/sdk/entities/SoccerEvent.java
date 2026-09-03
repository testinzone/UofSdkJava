/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.entities;

import com.testinzone.unifiedodds.sdk.entities.status.SoccerStatus;

/**
 * A {@link Match} derived type used to represent a soccer sport events
 */
public interface SoccerEvent extends Match {
    /**
     * Returns a {@link SoccerStatus} containing information about the progress of the soccer match
     * associated with the current instance
     *
     * @return - a {@link SoccerStatus} containing information about the progress of the soccer match
     * associated with the current instance
     */
    SoccerStatus getStatus();
}
