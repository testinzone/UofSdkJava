/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk;

import com.testinzone.unifiedodds.sdk.entities.SportEvent;
import com.testinzone.utils.Urn;
import java.util.Date;

/**
 * Defines methods used as callbacks to notify the client about event fixture and/or result change updates
 */
public interface EventChangeListener {
    /**
     * Method invoked for new fixture change
     *
     * @param eventId the associated event identifier
     * @param updated the date when change was made
     * @param sportEvent the {@link SportEvent}
     */
    void onFixtureChange(Urn eventId, Date updated, SportEvent sportEvent);

    /**
     * Method invoked for new result change
     *
     * @param eventId the associated event identifier
     * @param updated the date when change was made
     * @param sportEvent the {@link SportEvent}
     */
    void onResultChange(Urn eventId, Date updated, SportEvent sportEvent);
}
