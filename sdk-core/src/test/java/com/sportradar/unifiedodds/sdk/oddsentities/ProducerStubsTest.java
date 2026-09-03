/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.oddsentities;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.testinzone.unifiedodds.sdk.ProducerScope;
import org.junit.Test;

public class ProducerStubsTest {

    @Test
    public void liveProducerShouldHaveIdOf1() {
        Producer liveProducer = ProducerStubs.stubLiveProducer();

        assertEquals(1, liveProducer.getId());
    }

    @Test
    public void liveProducerShouldCarryLiveScopeOnly() {
        Producer liveProducer = ProducerStubs.stubLiveProducer();

        assertTrue(liveProducer.getProducerScopes().contains(ProducerScope.Live));
        assertEquals(1, liveProducer.getProducerScopes().size());
    }

    @Test
    public void liveProducerScopesShouldBeImmutable() {
        Producer liveProducer = ProducerStubs.stubLiveProducer();

        assertThatThrownBy(() -> liveProducer.getProducerScopes().clear());
    }
}
