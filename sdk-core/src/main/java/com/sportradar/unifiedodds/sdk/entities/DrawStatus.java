/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.entities;

/**
 * Possible draw statuses
 */
// Constant names should comply with a naming convention
@SuppressWarnings({ "java:S115", "NoEnumTrailingComma" })
public enum DrawStatus {
    Open,
    Closed,
    Finished,
    Cancelled,
    Unknown,
}
