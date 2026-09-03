/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.entities;

/**
 * An indication of the type of the related period
 */
// Constant names should comply with a naming convention
@SuppressWarnings({ "java:S115", "NoEnumTrailingComma" })
public enum PeriodType {
    RegularPeriod,
    Overtime,
    Penalties,
    Other,
}
