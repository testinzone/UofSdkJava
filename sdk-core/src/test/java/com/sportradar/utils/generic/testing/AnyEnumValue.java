/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.utils.generic.testing;

public class AnyEnumValue {

    public static <T extends Enum<T>> T anyFrom(Class<T> enumeration) {
        return enumeration.getEnumConstants()[0];
    }
}
