/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.oddsentities;

import com.testinzone.unifiedodds.sdk.entities.SportEvent;

/**
 * The event that gets released when an unparsable/bad message gets detected
 */
public interface UnparsableMessage<T extends SportEvent> extends Message {
    /**
     * Returns the {@link Producer} that generated this message.
     * The method will return a null value if the producer data could not be extracted.
     *
     * @return the {@link Producer} that generated this message
     */
    Producer getProducer();

    /**
     * Returns the competition/match/race/outright for which the un-parsable message is triggered.
     * The method will return null if the event data could not be extracted.
     *
     * @return the competition/match this odds update is for
     */
    T getEvent();

    /**
     * Returns the raw message as received from the producer
     *
     * @return the raw message as received from the producer
     */
    byte[] getRawMessage();
}
