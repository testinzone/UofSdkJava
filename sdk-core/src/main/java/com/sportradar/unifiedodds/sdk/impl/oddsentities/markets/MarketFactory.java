/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.impl.oddsentities.markets;

import com.testinzone.uf.datamodel.UfBetSettlementMarket;
import com.testinzone.uf.datamodel.UfMarket;
import com.testinzone.uf.datamodel.UfOddsChangeMarket;
import com.testinzone.unifiedodds.sdk.entities.SportEvent;
import com.testinzone.unifiedodds.sdk.oddsentities.*;
import java.util.Optional;

/**
 * Created on 23/06/2017.
 * // TODO @eti: Javadoc
 */
public interface MarketFactory {
    Optional<Market> buildMarket(SportEvent sportEvent, UfMarket m, int producerId);

    Optional<MarketWithOdds> buildMarketWithOdds(
        SportEvent sportEvent,
        UfOddsChangeMarket market,
        int producerId
    );

    Optional<MarketWithSettlement> buildMarketWithSettlement(
        SportEvent sportEvent,
        UfBetSettlementMarket market,
        int producerId
    );

    Optional<MarketWithProbabilities> buildMarketWithProbabilities(
        SportEvent sportEvent,
        UfOddsChangeMarket market,
        int producerId
    );

    Optional<MarketCancel> buildMarketCancel(SportEvent sportEvent, UfMarket market, int producerId);
}
