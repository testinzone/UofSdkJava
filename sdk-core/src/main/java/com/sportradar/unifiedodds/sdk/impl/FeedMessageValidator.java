/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.impl;

import com.testinzone.unifiedodds.sdk.oddsentities.UnmarshalledMessage;

/**
 * A class used to validate {@link com.testinzone.unifiedodds.sdk.oddsentities.UnmarshalledMessage} objects
 */
public interface FeedMessageValidator {
    /**
     * Validates the provided {@link UnmarshalledMessage} instance
     *
     * @param message the message instance that should be validated
     * @param rkInfo the associated routing key information
     * @return a {@link ValidationResult} specifying the validation result
     */
    ValidationResult validate(UnmarshalledMessage message, RoutingKeyInfo rkInfo);
}
