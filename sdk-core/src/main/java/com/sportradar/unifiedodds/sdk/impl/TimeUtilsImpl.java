/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.impl;

import java.time.Instant;

/**
 * Created on 06/04/2018.
 * // TODO @eti: Javadoc
 */
public class TimeUtilsImpl implements TimeUtils {

    @Override
    public long now() {
        return Instant.now().toEpochMilli();
    }

    @Override
    public Instant nowInstant() {
        return Instant.now();
    }
}
