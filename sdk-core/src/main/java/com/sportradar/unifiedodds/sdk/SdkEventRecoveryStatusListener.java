/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk;

import com.testinzone.utils.Urn;

/**
 * Defines methods used as callbacks to notify the client about event recovery updates
 */
public interface SdkEventRecoveryStatusListener {
    /**
     * Method invoked when a requested event recovery completes
     *
     * @param eventId the associated event identifier
     * @param requestId the identifier of the recovery request
     */
    void onEventRecoveryCompleted(Urn eventId, long requestId);
}
