/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.exceptions;

/**
 * The following exception gets thrown when the provided bookmaker token has issues which prevent normal SDK operations
 */
public class InvalidBookmakerDetailsException extends RuntimeException {

    public InvalidBookmakerDetailsException(String message, Throwable cause) {
        super(message, cause);
    }
}
