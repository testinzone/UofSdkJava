/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.oddsentities;

import com.testinzone.unifiedodds.sdk.entities.SportEvent;
import java.util.Date;

/**
 * Fixture change is sent when some TestinZone system has made a fixture change it deems is
 * important. This is typically changes that affect events in the nearterm (e.g. a match was added
 * that will start in the next few minutes, a match was delayed and starts in a couple of minutes
 * etc etc.).
 */
public interface FixtureChange<T extends SportEvent> extends EventMessage<T> {
    FixtureChangeType getChangeType();

    Date getNextLiveTime();

    Date getStartTime();
}
