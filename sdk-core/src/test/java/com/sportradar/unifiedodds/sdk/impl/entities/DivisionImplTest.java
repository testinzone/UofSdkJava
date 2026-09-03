/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.impl.entities;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;

import com.testinzone.unifiedodds.sdk.caching.ci.DivisionCi;
import com.testinzone.unifiedodds.sdk.entities.Division;
import org.junit.Test;

public class DivisionImplTest {

    private final Integer anyDivisionId = 1;
    private final String anyDivisionName = "FCB";

    @Test
    public void shouldCreateWithDivision() {
        Division division = new DivisionImpl(createDivisionCi(anyDivisionId, anyDivisionName));
        Integer actualDivisionId = division.getDivision();
        assertEquals(anyDivisionId, actualDivisionId);
    }

    @Test
    public void shouldCreateWithDivisionName() {
        Division division = new DivisionImpl(createDivisionCi(anyDivisionId, anyDivisionName));
        String actualDivisionName = division.getDivisionName();
        assertEquals(anyDivisionName, actualDivisionName);
    }

    @Test
    public void shouldNotCreateFromNullDivisionCi() {
        assertThatThrownBy(() -> {
                new DivisionImpl(null);
            })
            .isInstanceOf(NullPointerException.class);
    }

    private DivisionCi createDivisionCi(Integer divisionId, String divisionName) {
        return new DivisionCi(divisionId, divisionName);
    }
}
