/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk;

/**
 * Created on 17/09/2018.
 * // TODO @eti: Javadoc
 */
public interface SnapshotRequest {
    int getBookmakerId();

    int getProducerId();

    long getRecoveryId();

    long getRecoveryFromTimestamp();

    void approveRecovery();
}
