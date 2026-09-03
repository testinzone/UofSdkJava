/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.impl.entities;

import com.google.common.base.Preconditions;
import com.testinzone.unifiedodds.sdk.caching.ci.RaceDriverProfileCi;
import com.testinzone.unifiedodds.sdk.entities.Car;
import com.testinzone.unifiedodds.sdk.entities.RaceDriverProfile;
import com.testinzone.utils.Urn;

/**
 * A basic implementation of the {@link RaceDriverProfile}
 */
public class RaceDriverProfileImpl implements RaceDriverProfile {

    private final Urn raceDriverId;
    private final Urn raceTeamId;
    private final Car car;

    public RaceDriverProfileImpl(RaceDriverProfileCi raceDriver) {
        Preconditions.checkNotNull(raceDriver);

        this.raceDriverId = raceDriver.getRaceDriverId();
        this.raceTeamId = raceDriver.getRaceTeamId();
        this.car = raceDriver.getCar() != null ? new CarImpl(raceDriver.getCar()) : null;
    }

    /**
     * Returns the race driver id
     *
     * @return the race driver id
     */
    @Override
    public Urn getRaceDriverId() {
        return raceDriverId;
    }

    /**
     * Returns the race team id
     *
     * @return the race team id
     */
    @Override
    public Urn getRaceTeamId() {
        return raceTeamId;
    }

    /**
     * Returns the car information
     *
     * @return the car information
     */
    @Override
    public Car getCar() {
        return car;
    }
}
