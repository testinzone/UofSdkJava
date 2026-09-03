/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk;

import static com.testinzone.unifiedodds.sdk.ExceptionHandlingStrategy.Throw;

public class ExceptionHandlingStrategies {

    private ExceptionHandlingStrategies() {}

    public static ExceptionHandlingStrategy anyErrorHandlingStrategy() {
        return Throw;
    }
}
