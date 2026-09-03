/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.impl.entities.status;

import com.testinzone.unifiedodds.sdk.caching.LocalizedNamedValueCache;
import com.testinzone.unifiedodds.sdk.caching.SportEventStatusCi;
import com.testinzone.unifiedodds.sdk.entities.status.SoccerStatistics;
import com.testinzone.unifiedodds.sdk.entities.status.SoccerStatus;

/**
 * Provides methods used to access soccer status information
 *
 *  @deprecated Soccer was considered a special sport, and the only sport exposing statistics
 *    however currently @MatchStatus also provides total and period statistics,
 *    making this class redundant
 */
@Deprecated
public class SoccerStatusImpl extends MatchStatusImpl implements SoccerStatus {

    private final SportEventStatusCi statusCi;

    public SoccerStatusImpl(SportEventStatusCi statusCi, LocalizedNamedValueCache matchStatuses) {
        super(statusCi, matchStatuses);
        this.statusCi = statusCi;
    }

    /**
     * Returns the associated soccer match statistics
     *
     * @return the associated soccer match statistics, if available; otherwise null;
     */
    @Override
    public SoccerStatistics getStatistics() {
        return statusCi.getSportEventStatisticsDto() == null
            ? null
            : new SoccerStatisticsImpl(statusCi.getSportEventStatisticsDto());
    }
}
