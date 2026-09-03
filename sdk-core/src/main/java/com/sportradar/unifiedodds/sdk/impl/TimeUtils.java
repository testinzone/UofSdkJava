/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.impl;

import java.time.Instant;

/**
 * Created on 06/04/2018.
 * // TODO @eti: Javadoc
 */
public interface TimeUtils {
    long now();

    Instant nowInstant();
}
