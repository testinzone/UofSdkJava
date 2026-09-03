/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.exceptions;

/**
 * The base SDK exception class
 */
public abstract class UofSdkException extends RuntimeException {

    public UofSdkException(String message) {
        super(message);
    }

    public UofSdkException(String message, Exception e) {
        super(message, e);
    }
}
