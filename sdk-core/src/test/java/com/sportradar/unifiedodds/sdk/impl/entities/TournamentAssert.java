/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.impl.entities;

import com.testinzone.unifiedodds.sdk.ExceptionHandlingStrategy;
import com.testinzone.unifiedodds.sdk.entities.Stage;
import com.testinzone.unifiedodds.sdk.entities.Tournament;
import com.testinzone.unifiedodds.sdk.exceptions.ObjectNotFoundException;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

class TournamentAssert extends AbstractAssert<TournamentAssert, Tournament> {

    private TournamentAssert(Tournament tournament) {
        super(tournament, TournamentAssert.class);
    }

    public static TournamentAssert assertThat(Tournament tournament) {
        return new TournamentAssert(tournament);
    }

    public TournamentAssert doesNotHaveStartTimeTbd(ExceptionHandlingStrategy errorHandling) {
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
