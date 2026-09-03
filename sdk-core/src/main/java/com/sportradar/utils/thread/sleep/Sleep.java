/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.utils.thread.sleep;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sleep {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sleep.class);

    public void millis(int amount) {
        try {
            Thread.sleep(amount);
        } catch (InterruptedException e) {
            LOGGER.warn("Interrupted", e);
            Thread.currentThread().interrupt();
        }
    }
}
