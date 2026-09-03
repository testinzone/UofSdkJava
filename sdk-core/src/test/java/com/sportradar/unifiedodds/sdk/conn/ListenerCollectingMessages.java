/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.conn;

import com.testinzone.unifiedodds.sdk.MessageInterest;
import com.testinzone.unifiedodds.sdk.UofListener;
import com.testinzone.unifiedodds.sdk.UofSession;
import com.testinzone.unifiedodds.sdk.entities.SportEvent;
import com.testinzone.unifiedodds.sdk.extended.UofExtListener;
import com.testinzone.unifiedodds.sdk.impl.RoutingKeyInfo;
import com.testinzone.unifiedodds.sdk.oddsentities.*;
import java.net.URI;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class ListenerCollectingMessages implements UofListener {

    private final MessagesInMemoryStorage messageStorage;

    public static ListenerCollectingMessages to(MessagesInMemoryStorage messageStorage) {
        return new ListenerCollectingMessages(messageStorage);
    }

    @Override
    public void onOddsChange(UofSession sender, OddsChange<SportEvent> oddsChanges) {
        messageStorage.append(oddsChanges);
    }

    @Override
    public void onBetStop(UofSession sender, BetStop<SportEvent> betStop) {
        messageStorage.append(betStop);
    }

    @Override
    public void onBetSettlement(UofSession sender, BetSettlement<SportEvent> clearBets) {
        messageStorage.append(clearBets);
    }

    @Override
    public void onRollbackBetSettlement(
        UofSession sender,
        RollbackBetSettlement<SportEvent> rollbackBetSettlement
    ) {
        messageStorage.append(rollbackBetSettlement);
    }

    @Override
    public void onBetCancel(UofSession sender, BetCancel<SportEvent> betCancel) {
        messageStorage.append(betCancel);
    }

    @Override
    public void onRollbackBetCancel(UofSession sender, RollbackBetCancel<SportEvent> rbBetCancel) {
        messageStorage.append(rbBetCancel);
    }

    @Override
    public void onFixtureChange(UofSession sender, FixtureChange<SportEvent> fixtureChange) {
        messageStorage.append(fixtureChange);
    }

    @Override
    public void onUnparsableMessage(UofSession sender, UnparsableMessage unparsableMessage) {}

    @Override
    public void onUserUnhandledException(UofSession sender, Exception exception) {}
}
