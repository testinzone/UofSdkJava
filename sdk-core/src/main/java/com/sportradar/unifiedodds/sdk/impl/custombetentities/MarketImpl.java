/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.impl.custombetentities;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.testinzone.uf.custombet.datamodel.CapiMarketType;
import com.testinzone.uf.custombet.datamodel.CapiOutcomeType;
import com.testinzone.unifiedodds.sdk.custombetentities.Market;
import java.util.List;

/**
 * Implements methods used to access available selections for the market
 */
public class MarketImpl implements Market {

    /**
     * the id of the market
     */
    private final int id;

    /**
     * The specifiers for this market
     */
    private final String specifiers;

    /**
     * The outcomes for this market
     */
    private final List<String> outcomes;

    MarketImpl(CapiMarketType market) {
        Preconditions.checkNotNull(market);

        this.id = market.getId();
        this.specifiers = market.getSpecifiers();
        this.outcomes =
            market
                .getOutcomes()
                .stream()
                .map(CapiOutcomeType::getId)
                .collect(ImmutableList.toImmutableList());
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getSpecifiers() {
        return specifiers;
    }

    @Override
    public List<String> getOutcomes() {
        return outcomes;
    }
}
