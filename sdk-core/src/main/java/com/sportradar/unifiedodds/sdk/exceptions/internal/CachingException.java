/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.exceptions.internal;

/**
 * The following exception gets thrown when a cache problem is encountered
 */
public abstract class CachingException extends SdkInternalException {

    public CachingException(String message) {
        super(message);
    }

    public CachingException(String message, Throwable cause) {
        super(message, cause);
    }
}
