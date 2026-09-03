/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.caching;

import com.testinzone.unifiedodds.sdk.caching.ci.BonusInfoCi;
import com.testinzone.unifiedodds.sdk.caching.ci.DrawInfoCi;
import com.testinzone.utils.Urn;
import java.util.List;

/**
 * A lottery cache representation
 */
public interface LotteryCi extends SportEventCi {
    /**
     * Returns the associated category id
     *
     * @return the associated category id
     */
    Urn getCategoryId();

    /**
     * Returns the associated bonus info
     *
     * @return the associated bonus info
     */
    BonusInfoCi getBonusInfo();

    /**
     * Returns the associated draw info
     *
     * @return the associated draw info
     */
    DrawInfoCi getDrawInfo();

    /**
     * Returns the lottery draws schedule
     *
     * @return the lottery draw schedule
     */
    List<Urn> getScheduledDraws();
}
