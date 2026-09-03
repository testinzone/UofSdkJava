/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.utils.generic.testing;

public final class RandomInteger {

    private RandomInteger() {}

    public static int fromRangeInclusive(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }

    public static int fromRange(int min, int max) {
        return min + (int) (Math.random() * (max - min));
    }
}
