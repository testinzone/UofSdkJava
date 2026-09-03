/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import com.testinzone.unifiedodds.sdk.cfg.Environment;
import com.testinzone.unifiedodds.sdk.cfg.UofConfiguration;
import com.testinzone.unifiedodds.sdk.shared.StubUofConfiguration;
import org.junit.Before;
import org.junit.Test;

public class UofSdkForReplayTest {

    private final UofGlobalEventsListener listener = mock(UofGlobalEventsListener.class);
    private final UofConfiguration config = new StubUofConfiguration();

    @Before
    public void setup() {
        ((StubUofConfiguration) config).setEnvironment(Environment.Integration);
        ((StubUofConfiguration) config).resetNbrSetEnvironmentCalled();
    }

    @Test
    public void shouldNotInstantiateWithNullListener() {
        assertThatThrownBy(() -> new UofSdkForReplay(null, config))
            .isInstanceOf(NullPointerException.class)
            .hasMessageContaining("listener");
        assertThatThrownBy(() -> new UofSdkForReplay(null, config, null))
            .isInstanceOf(NullPointerException.class)
            .hasMessageContaining("listener");
    }

    @Test
    public void shouldNotInstantiateWithNullConfig() {
        assertThatThrownBy(() -> new UofSdkForReplay(listener, null))
            .isInstanceOf(NullPointerException.class)
            .hasMessageContaining("config");
        assertThatThrownBy(() -> new UofSdkForReplay(listener, null, null))
            .isInstanceOf(NullPointerException.class)
            .hasMessageContaining("config");
    }

    @Test
    public void shouldInstantiate() {
        assertNotNull(new UofSdkForReplay(listener, config));
        assertNotNull(new UofSdkForReplay(listener, config, null));
    }
}
