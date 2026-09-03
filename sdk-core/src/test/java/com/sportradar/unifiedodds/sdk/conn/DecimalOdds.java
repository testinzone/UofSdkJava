/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.conn;

import com.testinzone.utils.generic.testing.RandomInteger;

public final class DecimalOdds {

    private static final int HUNDRED_PERCENT = 100;

    private static final int MINIMUM_PROBABILITY_PERCENTAGE = 1;
    private static final int MAXIMUM_PROBABILITY_PERCENTAGE = 99;

    private DecimalOdds() {}

    public static double any() {
        double decimalOdds =
            HUNDRED_PERCENT /
            (double) RandomInteger.fromRangeInclusive(
                MINIMUM_PROBABILITY_PERCENTAGE,
                MAXIMUM_PROBABILITY_PERCENTAGE
            );
        return decimalOdds;
    }
}
