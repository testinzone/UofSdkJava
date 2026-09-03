/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.conn;

import static java.util.concurrent.TimeUnit.SECONDS;

import com.testinzone.unifiedodds.sdk.oddsentities.OddsChange;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.awaitility.Awaitility;

public class WaiterForSingleMessage {

    private final MessagesInMemoryStorage messagesStorage;

    public WaiterForSingleMessage(MessagesInMemoryStorage messagesStorage) {
        this.messagesStorage = messagesStorage;
    }

    public OddsChange<com.testinzone.unifiedodds.sdk.entities.SportEvent> theOnlyOddsChange() {
        final int tenForSlowMachines = 10;
        Awaitility.await().atMost(tenForSlowMachines, SECONDS).until(anyOddsChangeMessageReceived());
        List<OddsChange<com.testinzone.unifiedodds.sdk.entities.SportEvent>> allOddsChange = new ArrayList<>(
            messagesStorage.findAllOddsChange()
        );
        if (allOddsChange.size() != 1) {
            throw new IllegalStateException(
                "Expected 1 odds change message, but found " + allOddsChange.size()
            );
        }
        return allOddsChange.get(0);
    }

    public OddsChange<com.testinzone.unifiedodds.sdk.entities.SportEvent> secondOddsChange() {
        final int tenForSlowMachines = 10;
        Awaitility.await().atMost(tenForSlowMachines, SECONDS).until(multipleOddsChangeMessageReceived());
        List<OddsChange<com.testinzone.unifiedodds.sdk.entities.SportEvent>> allOddsChange = new ArrayList<>(
            messagesStorage.findAllOddsChange()
        );
        if (allOddsChange.size() <= 1) {
            throw new IllegalStateException(
                "Expected at least 2 odds change message, but found " + allOddsChange.size()
            );
        }
        return allOddsChange.get(1);
    }

    private Callable<Boolean> anyOddsChangeMessageReceived() {
        return () -> !messagesStorage.findAllOddsChange().isEmpty();
    }

    private Callable<Boolean> multipleOddsChangeMessageReceived() {
        return () -> messagesStorage.findAllOddsChange().size() > 1;
    }
}
