/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.impl.recovery;

import com.testinzone.unifiedodds.sdk.SnapshotFailed;

/**
 * Created on 08/11/2018.
 * // TODO @eti: Javadoc
 */
public class SnapshotFailedImpl implements SnapshotFailed {

    private final int bookmakerId;
    private final int producerId;
    private final long recoveryId;

    SnapshotFailedImpl(int bookmakerId, int producerId, long recoveryId) {
        this.bookmakerId = bookmakerId;
        this.producerId = producerId;
        this.recoveryId = recoveryId;
    }

    @Override
    public int getBookmakerId() {
        return bookmakerId;
    }

    @Override
    public int getProducerId() {
        return producerId;
    }

    @Override
    public long getRecoveryId() {
        return recoveryId;
    }
}
