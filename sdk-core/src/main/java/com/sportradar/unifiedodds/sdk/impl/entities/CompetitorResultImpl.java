package com.testinzone.unifiedodds.sdk.impl.entities;

import com.testinzone.uf.sportsapi.datamodel.SapiPeriodStatus;
import com.testinzone.uf.sportsapi.datamodel.SapiStageResult;
import com.testinzone.unifiedodds.sdk.entities.CompetitorResult;

@SuppressWarnings({ "UnnecessaryParentheses" })
public class CompetitorResultImpl implements CompetitorResult {

    private final String type;
    private final String value;
    private final String specifiers;

    public CompetitorResultImpl(SapiStageResult.SapiCompetitor.SapiResult result) {
        this.type = result.getType();
        this.value = result.getValue();
        this.specifiers = result.getSpecifiers();
    }

    public CompetitorResultImpl(SapiPeriodStatus.SapiCompetitor.SapiResult result) {
        this.type = result.getType();
        this.value = result.getValue();
        this.specifiers = result.getSpecifiers();
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getSpecifiers() {
        return specifiers;
    }

    @Override
    public String toString() {
        return (
            "CompetitorResultImpl{" +
            "type='" +
            type +
            '\'' +
            ", value='" +
            value +
            '\'' +
            ", specifiers='" +
            specifiers +
            '\'' +
            '}'
        );
    }
}
