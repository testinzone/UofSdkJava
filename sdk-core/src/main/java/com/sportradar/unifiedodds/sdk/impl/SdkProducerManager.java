/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.impl;

import com.testinzone.unifiedodds.sdk.ProducerManager;
import com.testinzone.unifiedodds.sdk.oddsentities.RecoveryInfo;

/**
 * Created on 03/07/2017.
 * // TODO @eti: Javadoc
 */
public interface SdkProducerManager extends ProducerManager {
    void open();

    void setProducerDown(int producerId, boolean flaggedDown);

    void internalSetProducerLastMessageTimestamp(int producerId, long lastMessageTimestamp);

    void setLastProcessedMessageGenTimestamp(int producerId, long lastProcessedMessageGenTimestamp);

    void setLastAliveReceivedGenTimestamp(int producerId, long aliveReceivedGenTimestamp);

    void setProducerRecoveryInfo(int producerId, RecoveryInfo recoveryInfo);

    void internalSetProducerLastRecoveryMessageTimestamp(int producerId, long lastRecoveryMessageTimestamp);

    long getProducerLastRecoveryMessageTimestamp(int producerId);

    void internalSetProducerLastRecoveryAttemptTimestamp(int producerId, long lastRecoveryAttemptTimestamp);

    long getProducerLastRecoveryAttemptTimestamp(int producerId);
}
