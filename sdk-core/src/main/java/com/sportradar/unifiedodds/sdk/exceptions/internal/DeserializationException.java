/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.exceptions.internal;

/**
 * The following exception gets thrown when an object deserialization fails
 */
public class DeserializationException extends SdkInternalException {

    public DeserializationException(String message, Throwable cause) {
        super(message, cause);
    }
}
