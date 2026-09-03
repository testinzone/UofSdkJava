/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.testutil.generic.concurrent;

import java.util.concurrent.Callable;

public class VoidCallables {

    private VoidCallables() {}

    public static Callable<Void> voidCallable(final ThrowingRunnable runnable) {
        return () -> {
            runnable.run();
            return null;
        };
    }

    public static interface ThrowingRunnable {
        public void run() throws Exception;
    }
}
