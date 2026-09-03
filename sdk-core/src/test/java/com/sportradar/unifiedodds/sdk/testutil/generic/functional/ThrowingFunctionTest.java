/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.testutil.generic.functional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.IOException;
import org.junit.Test;

public class ThrowingFunctionTest {

    @Test
    public void shouldThrowCheckedException() throws IOException {
        final boolean any = true;
        final ThrowingFunction<Boolean, Integer> alwaysThrows = input -> {
            throw new IOException();
        };

        assertThatThrownBy(() -> alwaysThrows.apply(any));
    }
}
