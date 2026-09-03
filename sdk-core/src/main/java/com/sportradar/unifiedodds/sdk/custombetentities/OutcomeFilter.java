/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.custombetentities;

/**
 * Provides an outcome
 */
public interface OutcomeFilter {
    /**
     * Returns the id of the outcome
     *
     * @return the id of the outcome
     */
    String getId();

    /**
     * Returns the value indicating if this outcome is in conflict
     * @return the value indicating if this outcome is in conflict
     */
    Boolean isConflict();
}
