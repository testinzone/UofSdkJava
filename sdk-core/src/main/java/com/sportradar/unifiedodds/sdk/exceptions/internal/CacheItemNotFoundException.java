/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.exceptions.internal;

/**
 * The following exception gets thrown when a cache item could not be found
 */
public class CacheItemNotFoundException extends CachingException {

    public CacheItemNotFoundException(String message) {
        super(message);
    }

    public CacheItemNotFoundException(String message, Exception e) {
        super(message, e);
    }
}
