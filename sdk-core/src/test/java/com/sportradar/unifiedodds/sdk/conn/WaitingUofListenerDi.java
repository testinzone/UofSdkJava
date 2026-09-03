/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.conn;

import com.testinzone.unifiedodds.sdk.impl.TimeUtilsImpl;
import com.testinzone.unifiedodds.sdk.testutil.generic.concurrent.SignallingOnPollingQueue;

public class WaitingUofListenerDi {

    private WaitingUofListenerDi() {}

    public static WaitingUofListener.Factory createWaitingUofListenerFactory() {
        return new WaitingUofListener.Factory(
            SignallingOnPollingQueue.createSignallingOnPollingQueue(new TimeUtilsImpl())
        );
    }
}
