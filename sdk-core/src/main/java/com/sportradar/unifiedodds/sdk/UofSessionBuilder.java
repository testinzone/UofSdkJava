/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk;

import com.testinzone.utils.Urn;
import java.util.Set;

@SuppressWarnings({ "IllegalType" })
public interface UofSessionBuilder {
    /**
     *
     * @param listener the main odds feed listener
     * @return the current session builder
     */
    UofSessionBuilder setListener(UofListener listener);

    /**
     *
     * @param msgInterest the message level that the current session should receive
     * @return the current session builder
     */
    UofSessionBuilder setMessageInterest(MessageInterest msgInterest);

    /**
     *
     * @param specificEventsOnly the specific target events
     * @return the current session builder
     */
    UofSessionBuilder setSpecificEventsOnly(Set<Urn> specificEventsOnly);

    /**
     *
     * @param specificEventsOnly the specific target events
     * @return the current session builder
     */
    UofSessionBuilder setSpecificEventsOnly(Urn specificEventsOnly);

    /**
     * This function creates the newly configured session using the supplied message interest and listeners
     *
     * @return - the session instance
     */
    UofSession build();
}
