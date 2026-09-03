/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk;

/**
 * Created on 08/11/2018.
 * // TODO @eti: Javadoc
 */
public interface SnapshotFailed {
    int getBookmakerId();

    int getProducerId();

    long getRecoveryId();
}
