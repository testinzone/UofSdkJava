/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.exceptions.internal;

/**
 * A general util exception used to wrap checked exception within streams
 */
public class StreamWrapperException extends RuntimeException {

    public StreamWrapperException(String message, Exception e) {
        super(message, e);
    }
}
