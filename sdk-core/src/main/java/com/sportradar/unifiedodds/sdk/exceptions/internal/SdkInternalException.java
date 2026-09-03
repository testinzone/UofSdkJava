/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.exceptions.internal;

/**
 * This is the base exception used within the SDK to handle checked exceptions
 */
public abstract class SdkInternalException extends Exception {

    public SdkInternalException(String message) {
        super(message);
    }

    public SdkInternalException(String message, Throwable cause) {
        super(message, cause);
    }
}
