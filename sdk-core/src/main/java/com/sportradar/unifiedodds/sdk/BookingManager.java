/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk;

import com.testinzone.unifiedodds.sdk.exceptions.internal.CommunicationException;
import com.testinzone.utils.Urn;

/**
 * Defines methods used to perform various booking calendar operations
 */
public interface BookingManager {
    /**
     * Performs a request on the API which books the event associated with the provided {@link Urn} identifier
     *
     * @param eventId the {@link Urn} identifier of the event which needs to be booked
     * @return <code>true</code> if the booking was successful; otherwise <code>false</code>
     */
    boolean bookLiveOddsEvent(Urn eventId) throws CommunicationException;
}
