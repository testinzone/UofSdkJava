/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.impl.recovery;

/**
 * An indication of the recovery state
 */
@SuppressWarnings({ "NoEnumTrailingComma" })
enum RecoveryState {
    /**
     * Waiting for first recovery start
     */
    NotStarted,

    /**
     * Recovery started
     */
    Started,

    /**
     * Recovery completed
     */
    Completed,

    /**
     * Recovery was interrupted
     */
    Interrupted,

    /**
     * An error occurred during recovery request
     */
    Error,
}
