/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.impl.entities;

import com.testinzone.unifiedodds.sdk.ExceptionHandlingStrategy;
import com.testinzone.unifiedodds.sdk.entities.BasicTournament;
import com.testinzone.unifiedodds.sdk.exceptions.ObjectNotFoundException;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

class BasicTournamentAssert extends AbstractAssert<BasicTournamentAssert, BasicTournament> {

    private BasicTournamentAssert(BasicTournament tournament) {
        super(tournament, BasicTournamentAssert.class);
    }

    public static BasicTournamentAssert assertThat(BasicTournament tournament) {
        return new BasicTournamentAssert(tournament);
    }

    public BasicTournamentAssert doesNotHaveStartTimeTbd(ExceptionHandlingStrategy errorHandling) {
        if (errorHandling == ExceptionHandlingStrategy.Throw) {
            Assertions
                .assertThatExceptionOfType(ObjectNotFoundException.class)
                .isThrownBy(actual::isStartTimeTbd);
        } else {
            Assertions.assertThat(actual.isStartTimeTbd()).isNull();
        }
        return this;
    }
}
