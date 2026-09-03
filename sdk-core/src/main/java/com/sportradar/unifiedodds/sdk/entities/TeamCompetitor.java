/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.entities;

/**
 * Defines methods implemented by classes representing a competing team
 */
public interface TeamCompetitor extends Competitor {
    /**
     * Returns the qualifier additionally describing the competitor (e.g. home, away, ...)
     *
     * @return - the qualifier additionally describing the competitor (e.g. home, away, ...)
     */
    String getQualifier();
}
