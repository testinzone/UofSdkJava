/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.exceptions;

/**
 * The following exception gets thrown when a URN object fails to initialize
 */
public class UnsupportedUrnFormatException extends UofSdkException {

    public UnsupportedUrnFormatException(String message) {
        super(message);
    }

    public UnsupportedUrnFormatException(String message, Exception e) {
        super(message, e);
    }
}
