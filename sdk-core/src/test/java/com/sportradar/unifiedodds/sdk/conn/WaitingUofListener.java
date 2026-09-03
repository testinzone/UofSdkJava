/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.conn;

import static org.junit.Assert.assertNotNull;

import com.testinzone.unifiedodds.sdk.UofSession;
import com.testinzone.unifiedodds.sdk.entities.SportEvent;
import com.testinzone.unifiedodds.sdk.oddsentities.OddsChange;
import com.testinzone.unifiedodds.sdk.testutil.generic.concurrent.SignallingOnPollingQueue;
import java.util.concurrent.TimeUnit;
import lombok.val;

public class WaitingUofListener extends NoOpUofListener {

    private final SignallingOnPollingQueue<OddsChange<SportEvent>> oddsChangeReceivedQueue;

    private WaitingUofListener(
        final SignallingOnPollingQueue<OddsChange<SportEvent>> oddsChangeReceivedQueue
    ) {
        this.oddsChangeReceivedQueue = oddsChangeReceivedQueue;
    }

    @Override
    public void onOddsChange(UofSession sender, OddsChange<SportEvent> oddsChanges) {
        oddsChangeReceivedQueue.offer(oddsChanges);
    }

    public OddsChange<SportEvent> waitForOddsChange() {
        val expectedMessage = oddsChangeReceivedQueue.poll(1, TimeUnit.SECONDS);
        assertNotNull("Odds change message was not received", expectedMessage);
        return expectedMessage;
    }

    public static class Factory {

        private SignallingOnPollingQueue<OddsChange<SportEvent>> oddsChangeReceivedQue;

        Factory(final SignallingOnPollingQueue<OddsChange<SportEvent>> oddsChangeReceivedQue) {
            this.oddsChangeReceivedQue = oddsChangeReceivedQue;
        }

        public WaitingUofListener expectingOddsChange() {
            return new WaitingUofListener(oddsChangeReceivedQue);
        }
    }
}
