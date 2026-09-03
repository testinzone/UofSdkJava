/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.integrationtest.preconditions;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class SystemProperties {

    private SystemProperties() {}

    public static boolean isBooleanSystemPropertySet(String name) {
        String value = System.getProperty(name);
        return Optional.ofNullable(value).map(toBoolean()).filter(isTrue()).orElse(false);
    }

    private static Predicate<Boolean> isTrue() {
        return v -> v;
    }

    private static Function<String, Boolean> toBoolean() {
        return Boolean::valueOf;
    }
}
