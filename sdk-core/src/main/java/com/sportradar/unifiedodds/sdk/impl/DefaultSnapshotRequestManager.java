/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.impl;

import com.testinzone.unifiedodds.sdk.SnapshotCompleted;
import com.testinzone.unifiedodds.sdk.SnapshotFailed;
import com.testinzone.unifiedodds.sdk.SnapshotRequest;
import com.testinzone.unifiedodds.sdk.SnapshotRequestManager;

/**
 * Default pass-trough snapshot scheduler
 */
public class DefaultSnapshotRequestManager implements SnapshotRequestManager {

    @Override
    public void scheduleRequest(SnapshotRequest request) {
        request.approveRecovery();
    }

    @Override
    public void requestCompleted(SnapshotCompleted completed) {}

    @Override
    public void requestFailed(SnapshotFailed failed) {}
}
