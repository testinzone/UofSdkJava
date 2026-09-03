/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.impl.dto;

import com.google.common.base.Preconditions;
import com.testinzone.uf.sportsapi.datamodel.SapiMatchPeriod;
import com.testinzone.unifiedodds.sdk.entities.HomeAway;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Period statistics data transfer object
 */
public class PeriodStatisticsDto {

    private final String periodName;
    private final List<TeamStatisticsDto> teamStatisticDtoS;

    PeriodStatisticsDto(SapiMatchPeriod p, Map<HomeAway, String> homeAwayMap) {
        Preconditions.checkNotNull(p);

        periodName = p.getName();

        teamStatisticDtoS =
            p
                .getTeams()
                .get(0)
                .getTeam()
                .stream()
                .map(t -> new TeamStatisticsDto(t, homeAwayMap))
                .collect(Collectors.toList());
    }

    public String getPeriodName() {
        return periodName;
    }

    public List<TeamStatisticsDto> getTeamStatisticDtos() {
        return teamStatisticDtoS;
    }
}
