/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.impl.util.javaclass;

public class ClassResolver {

    @SuppressWarnings("IllegalCatch")
    public Class<?> resolveByName(String fullyQualifiedName) {
        try {
            return Class.forName(fullyQualifiedName);
        } catch (Throwable ex) {
            throw new IllegalStateException("Yaml cnfiguration reader dependency missing", ex);
        }
    }
}
