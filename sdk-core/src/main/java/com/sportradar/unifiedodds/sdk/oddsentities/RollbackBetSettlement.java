/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.oddsentities;

import com.testinzone.unifiedodds.sdk.entities.SportEvent;

/**
 * Rollback is sent when a previously sent bet_settlement was sent in error and needs to be
 * rollbacked
 */
public interface RollbackBetSettlement<T extends SportEvent> extends MarketMessage<T> {}
