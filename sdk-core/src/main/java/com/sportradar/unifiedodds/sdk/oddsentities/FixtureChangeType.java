/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.oddsentities;

/**
 * What is the reason for a SDKFixtureChange message. *
 */
@SuppressWarnings({ "NoEnumTrailingComma" })
public enum FixtureChangeType {
    New,
    TimeUpdate,
    Cancelled,
    Format,
    Coverage,
    Pitcher,
    OtherChange,
    NotAvailable,
}
