/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.entities.markets;

/**
 * Defines methods used to access specifier type and name
 */
public interface Specifier {
    /**
     * Returns the specifier type
     *
     * @return the specifier type
     */
    String getType();

    /**
     * Returns the specifier name
     *
     * @return the specifier name
     */
    String getName();
}
