/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.impl;

/**
 * Defines methods implemented by classes used to parse the RabbitMq routing key
 */
public interface RoutingKeyParser {
    /**
     * Returns a {@link RoutingKeyInfo} containing the parsed routing key data
     *
     * @param routingKey - a complete RabbitMq routing key
     * @return - a {@link RoutingKeyInfo} containing the parsed routing key data
     */
    RoutingKeyInfo getRoutingKeyInfo(String routingKey);
}
