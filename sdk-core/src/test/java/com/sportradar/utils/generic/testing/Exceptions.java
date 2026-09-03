/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.utils.generic.testing;

import com.testinzone.unifiedodds.sdk.testutil.generic.concurrent.VoidCallables;

public final class Exceptions {

    private Exceptions() {}

    @SuppressWarnings({ "IllegalCatch", "EmptyCatchBlock" })
    public static void ignoringExceptions(VoidCallables.ThrowingRunnable runnable) {
        try {
            runnable.run();
        } catch (Exception ignored) {}
    }
}
