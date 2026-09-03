/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.oddsentities;

import com.testinzone.unifiedodds.sdk.entities.SportEvent;

/**
 * Represents a {@link Message} associated with a sport event
 */
public interface EventMessage<T extends SportEvent> extends Message {
    /**
     * Returns the competition/match/race/outright this odds update is for
     *
     * @return the competition/match this odds update is for
     */
    T getEvent();

    /**
     * Returns the request id of the current message
     *
     * @return the request id of the current message
     */
    Long getRequestId();

    /**
     * Returns the raw message as received from the producer
     *
     * @return the raw message as received from the producer
     */
    byte[] getRawMessage();
}
