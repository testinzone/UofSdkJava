/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk;

/**
 * Created on 17/09/2018.
 * // TODO @eti: Javadoc
 */
public interface SnapshotRequestManager {
    void scheduleRequest(SnapshotRequest request);

    void requestCompleted(SnapshotCompleted completed);

    void requestFailed(SnapshotFailed failed);
}
