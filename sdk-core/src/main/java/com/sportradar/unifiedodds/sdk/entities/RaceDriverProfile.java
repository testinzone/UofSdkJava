/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.entities;

import com.testinzone.utils.Urn;

/**
 * An interface providing methods to access race driver data
 */
public interface RaceDriverProfile {
    /**
     * Returns the race driver id
     *
     * @return the race driver id
     */
    Urn getRaceDriverId();

    /**
     * Returns the race team id
     *
     * @return the race team id
     */
    Urn getRaceTeamId();

    /**
     * Returns the car information
     *
     * @return the car information
     */
    Car getCar();
}
