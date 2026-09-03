/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.utils.generic.testing;

import java.util.Random;

public final class Booleans {

    public static final Random RANDOM = new Random();

    private Booleans() {}

    public static Boolean any() {
        return RANDOM.nextBoolean();
    }
}
