/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.impl.rabbitconnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({ "ConstantName" })
public class RabbitMqMonitoringThreads {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMqMonitoringThreads.class);

    // todo: should use Scheduler without thread.sleep
    public void startNew(Runnable runnable, String messageInterest, int channelId) {
        Thread monitorThread = new Thread(runnable);
        monitorThread.setName("MqChannelMonitor-" + messageInterest + "-" + channelId);
        monitorThread.setUncaughtExceptionHandler(
            new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread thread, Throwable throwable) {
                    logger.error(
                        String.format("Uncaught thread exception monitoring %s", messageInterest),
                        throwable
                    );
                }
            }
        );

        monitorThread.start();
    }
}
