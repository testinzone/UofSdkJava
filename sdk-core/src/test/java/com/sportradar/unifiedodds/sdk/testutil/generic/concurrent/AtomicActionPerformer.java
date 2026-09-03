/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.testutil.generic.concurrent;

public class AtomicActionPerformer {

    public synchronized void perform(Runnable runnable) {
        runnable.run();
    }
}
