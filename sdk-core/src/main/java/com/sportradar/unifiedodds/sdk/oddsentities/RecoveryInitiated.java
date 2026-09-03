/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.oddsentities;

import com.testinzone.utils.Urn;

/**
 * The event that gets released when the recovery for the producer is initiated
 */
public interface RecoveryInitiated extends Message {
    /**
     * Returns the identifier of the recovery request
     * @return the identifier of the recovery request
     */
    long getRequestId();

    /**
     * Returns the after timestamp if applied
     * @return the after timestamp if applied
     */
    Long getAfterTimestamp();

    /**
     * Gets the associated event identifier
     * @return the associated event identifier
     */
    Urn getEventId();

    /**
     * Returns the message associated with the recovery request
     * @return the message associated with the recovery request
     */
    String getMessage();
}
