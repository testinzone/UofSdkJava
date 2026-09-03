/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.conn;

import com.testinzone.unifiedodds.sdk.UofListener;
import com.testinzone.unifiedodds.sdk.UofSession;
import com.testinzone.unifiedodds.sdk.entities.SportEvent;
import com.testinzone.unifiedodds.sdk.oddsentities.*;

public class NoOpUofListener implements UofListener {

    @Override
    public void onOddsChange(UofSession sender, OddsChange<SportEvent> oddsChanges) {}

    @Override
    public void onBetStop(UofSession sender, BetStop<SportEvent> betStop) {}

    @Override
    public void onBetSettlement(UofSession sender, BetSettlement<SportEvent> clearBets) {}

    @Override
    public void onRollbackBetSettlement(
        UofSession sender,
        RollbackBetSettlement<SportEvent> rollbackBetSettlement
    ) {}

    @Override
    public void onBetCancel(UofSession sender, BetCancel<SportEvent> betCancel) {}

    @Override
    public void onRollbackBetCancel(UofSession sender, RollbackBetCancel<SportEvent> rbBetCancel) {}

    @Override
    public void onFixtureChange(UofSession sender, FixtureChange<SportEvent> fixtureChange) {}

    @Override
    public void onUnparsableMessage(UofSession sender, UnparsableMessage unparsableMessage) {}

    @Override
    public void onUserUnhandledException(UofSession sender, Exception exception) {}
}
