/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.impl;

/**
 * Defines methods implemented by the composite message processor
 */
public interface CompositeFeedMessageProcessor extends FeedMessageProcessor {
    /**
     * Initializes and prepares the composite processor instance
     *
     * @param dispatchingProcessor - the final dispatching message processor
     */
    void init(FeedMessageProcessor dispatchingProcessor);
}
