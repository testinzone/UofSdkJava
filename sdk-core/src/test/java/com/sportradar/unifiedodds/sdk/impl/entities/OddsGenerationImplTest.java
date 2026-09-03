/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.impl.entities;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;

public class OddsGenerationImplTest {

    @Test
    public void shouldNotCreateFromNoDto() {
        assertThatThrownBy(() -> new OddsGenerationImpl(null))
            .isInstanceOf(NullPointerException.class)
            .hasMessageContaining("oddsGenerationProperties");
    }
}
