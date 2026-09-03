/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.conn;

import com.testinzone.uf.datamodel.UfAlive;
import com.testinzone.unifiedodds.sdk.MessageInterest;
import java.util.List;

public interface RawMessagesQuerier {
    public List<ReceivedRawMessage<UfAlive>> findAlivesOf(MessageInterest interest);
}
