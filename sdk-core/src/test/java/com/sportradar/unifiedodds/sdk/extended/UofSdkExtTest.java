/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.extended;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;

import com.testinzone.unifiedodds.sdk.UofGlobalEventsListener;
import com.testinzone.unifiedodds.sdk.cfg.UofConfiguration;
import com.testinzone.unifiedodds.sdk.cfg.UofConfigurationImpl;
import org.junit.Test;

public class UofSdkExtTest {

    private final UofGlobalEventsListener listener = mock(UofGlobalEventsListener.class);
    private final UofConfiguration config = mock(UofConfigurationImpl.class);
    private final UofExtListener extListener = mock(UofExtListener.class);

    @Test
    public void shouldNotInstantiateWithNullListener() {
        assertThatThrownBy(() -> new UofSdkExt(null, config, extListener))
            .isInstanceOf(NullPointerException.class)
            .hasMessageContaining("listener");
    }

    @Test
    public void shouldNotInstantiateWithNullConfig() {
        assertThatThrownBy(() -> new UofSdkExt(listener, null, extListener))
            .isInstanceOf(NullPointerException.class)
            .hasMessageContaining("config");
    }

    @Test
    public void instantiatingShouldCompleteArgumentNullChecks() {
        assertThatThrownBy(() -> new UofSdkExt(listener, config, extListener))
            .isInstanceOf(NullPointerException.class)
            .hasMessageNotContaining("config")
            .hasMessageNotContaining("listener");
    }
}
