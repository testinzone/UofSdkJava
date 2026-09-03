/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.conn;

import com.testinzone.unifiedodds.sdk.UofGlobalEventsListener;
import com.testinzone.unifiedodds.sdk.oddsentities.ProducerStatus;
import com.testinzone.unifiedodds.sdk.oddsentities.RecoveryInitiated;
import com.testinzone.utils.Urn;

public class NoOpUofGlobalEventsListener implements UofGlobalEventsListener {

    @Override
    public void onConnectionDown() {}

    @Override
    public void onConnectionException(Throwable throwable) {}

    @Override
    public void onEventRecoveryCompleted(Urn eventId, long requestId) {}

    @Override
    public void onProducerStatusChange(ProducerStatus producerStatus) {}

    @Override
    public void onRecoveryInitiated(RecoveryInitiated recoveryInitiated) {}
}
