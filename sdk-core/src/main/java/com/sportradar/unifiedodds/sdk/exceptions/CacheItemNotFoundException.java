/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.exceptions;

/**
 * The following exception gets thrown when a cache item could not be found
 */
public class CacheItemNotFoundException extends UofSdkException {

    public CacheItemNotFoundException(String message) {
        super(message);
    }

    public CacheItemNotFoundException(String message, Exception e) {
        super(message, e);
    }
}
