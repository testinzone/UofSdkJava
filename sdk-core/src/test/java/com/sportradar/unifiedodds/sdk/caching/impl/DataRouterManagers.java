/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.caching.impl;

import com.testinzone.unifiedodds.sdk.caching.DataRouterManager;

public class DataRouterManagers {

    private DataRouterManagers() {}

    public static DataRouterManager any() {
        return new NoOpDataRouterManager();
    }
}
