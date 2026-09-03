/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.impl.oddsentities.markets;

import static com.testinzone.unifiedodds.sdk.impl.oddsentities.markets.ExpectationTowardsSdkErrorHandlingStrategy.WILL_THROW_EXCEPTIONS;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.testinzone.unifiedodds.sdk.exceptions.ObjectNotFoundException;
import com.testinzone.unifiedodds.sdk.oddsentities.OutcomeSettlement;
import java.util.Locale;
import lombok.val;
import org.assertj.core.api.AbstractAssert;

public class OutcomeSettlementAssert extends AbstractAssert<OutcomeSettlementAssert, OutcomeSettlement> {

    private OutcomeSettlementAssert(OutcomeSettlement outcomeSettlement) {
        super(outcomeSettlement, OutcomeSettlementAssert.class);
    }

    public static OutcomeSettlementAssert assertThat(OutcomeSettlement outcomeSettlement) {
        return new OutcomeSettlementAssert(outcomeSettlement);
    }
}
