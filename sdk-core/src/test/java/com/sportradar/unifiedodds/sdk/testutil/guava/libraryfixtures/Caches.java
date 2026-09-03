/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.testutil.guava.libraryfixtures;

import com.google.common.cache.Cache;

public class Caches {

    private Caches() {}

    public static Cache any() {
        return new NoOpCache();
    }
}
