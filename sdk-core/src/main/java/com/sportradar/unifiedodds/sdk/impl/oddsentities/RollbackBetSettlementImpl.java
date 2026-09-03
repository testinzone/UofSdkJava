/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.impl.oddsentities;

import com.google.common.base.Preconditions;
import com.testinzone.uf.datamodel.UfRollbackBetSettlement;
import com.testinzone.unifiedodds.sdk.entities.SportEvent;
import com.testinzone.unifiedodds.sdk.impl.oddsentities.markets.MarketFactory;
import com.testinzone.unifiedodds.sdk.oddsentities.Market;
import com.testinzone.unifiedodds.sdk.oddsentities.MessageTimestamp;
import com.testinzone.unifiedodds.sdk.oddsentities.Producer;
import com.testinzone.unifiedodds.sdk.oddsentities.RollbackBetSettlement;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created on 23/06/2017.
 * // TODO @eti: Javadoc
 */
@SuppressWarnings({ "ConstantName" })
class RollbackBetSettlementImpl<T extends SportEvent>
    extends EventMessageImpl<T>
    implements RollbackBetSettlement<T> {

    private static final Logger logger = LoggerFactory.getLogger(RollbackBetSettlementImpl.class);
    private final List<Market> affectedMarkets;

    RollbackBetSettlementImpl(
        T sportEvent,
        UfRollbackBetSettlement message,
        Producer producer,
        byte[] rawMessage,
        MarketFactory factory,
        MessageTimestamp timestamp
    ) {
        super(sportEvent, rawMessage, producer, timestamp, message.getRequestId());
        Preconditions.checkNotNull(factory);

        if (message.getMarket() != null) {
            affectedMarkets =
                message
                    .getMarket()
                    .stream()
                    .map(m -> factory.buildMarket(sportEvent, m, message.getProduct()))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());
        } else {
            logger.warn(
                "Processing RollbackBetSettlement with empty market list. [sportEvent:{}, producer:{}]",
                sportEvent.getId(),
                producer
            );
            affectedMarkets = Collections.emptyList();
        }
    }

    /**
     * @return the list of markets that are affected
     */
    @Override
    public List<Market> getMarkets() {
        return affectedMarkets;
    }
}
