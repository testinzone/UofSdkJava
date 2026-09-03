/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.impl;

import static org.mockito.Mockito.*;

import com.testinzone.uf.datamodel.UfFixtureChange;
import com.testinzone.unifiedodds.sdk.caching.SportEventCache;
import com.testinzone.unifiedodds.sdk.caching.SportEventStatusCache;
import com.testinzone.unifiedodds.sdk.impl.processing.pipeline.CacheMessageProcessor;
import com.testinzone.unifiedodds.sdk.impl.processing.pipeline.ProcessedFixtureChangesTracker;
import com.testinzone.unifiedodds.sdk.oddsentities.MessageTimestamp;
import com.testinzone.unifiedodds.sdk.oddsentities.Producer;
import com.testinzone.unifiedodds.sdk.shared.TestProducersProvider;
import com.testinzone.utils.Urn;
import java.util.HashMap;
import java.util.Map;
import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings("checkstyle:ClassFanOutComplexity")
@RunWith(JUnitParamsRunner.class)
public class CacheMessageProcessorTest {

    private final Urn eventId = Urn.parse("sr:match:1234");
    private final MessageTimestamp timestamp = mock(MessageTimestamp.class);
    private final SportEventStatusCache sportEventStatusCache = mock(SportEventStatusCache.class);
    private final SportEventCache sportEventCache = mock(SportEventCache.class);
    private final ProcessedFixtureChangesTracker fixtureChangesTracker = mock(
        ProcessedFixtureChangesTracker.class
    );
    private final SdkProducerManager producerManager = mock(SdkProducerManager.class);
    private CacheMessageProcessor cacheMessageProcessor;
    private final TestProducersProvider producersProvider = new TestProducersProvider();
    private final Map<Integer, Producer> producerMap = new HashMap<>();

    @SuppressWarnings("checkstyle:MagicNumber")
    @Before
    public void setup() {
        when(producerManager.getAvailableProducers()).thenReturn(producerMap);
        setupCacheMessageProcessor();
    }

    private void setupCacheMessageProcessor() {
        cacheMessageProcessor =
            new CacheMessageProcessor(
                sportEventStatusCache,
                sportEventCache,
                fixtureChangesTracker,
                producerManager
            );
    }

    @Test
    public void cacheMessageProcessorIsSetup() {
        Assert.assertNotNull(cacheMessageProcessor);
    }

    @Test
    public void processFixtureChangeMessageForNormalProducer() {
        producerMap.put(1, new ProducerImpl(producersProvider.getProducer(1, true)));

        final String routingKeyStr = "hi.pre.live.fixture_change.40.sr:match.1234.-";
        final RoutingKeyInfo routingKey = new RoutingKeyInfo(
            routingKeyStr,
            Urn.parse("sr:sport:40"),
            eventId
        );
        Assert.assertNotNull(routingKey);
        UfFixtureChange fixtureChange = new UfFixtureChange();
        fixtureChange.setEventId(routingKey.getEventId().toString());
        fixtureChange.setProduct(1);
        Assert.assertEquals(eventId.toString(), fixtureChange.getEventId());
        cacheMessageProcessor.processMessage(fixtureChange, new byte[0], routingKey, timestamp);

        verify(sportEventCache, times(1)).purgeCacheItem(eventId);
        verify(sportEventCache, times(1)).addFixtureTimestamp(eventId);
        verify(sportEventStatusCache, times(1)).purgeSportEventStatus(eventId);
    }

    @Test
    public void processFixtureChangeMessageForVirtualProducer() {
        final int virtualProducerId = 8;
        producerMap.put(
            virtualProducerId,
            new ProducerImpl(producersProvider.getProducer(virtualProducerId, true))
        );
        final String routingKeyStr = "hi.pre.live.fixture_change.40.sr:match.1234.-";
        final RoutingKeyInfo routingKey = new RoutingKeyInfo(
            routingKeyStr,
            Urn.parse("sr:sport:40"),
            eventId
        );
        Assert.assertNotNull(routingKey);
        UfFixtureChange fixtureChange = new UfFixtureChange();
        fixtureChange.setEventId(routingKey.getEventId().toString());
        fixtureChange.setProduct(virtualProducerId);
        Assert.assertEquals(eventId.toString(), fixtureChange.getEventId());
        setupCacheMessageProcessor();
        cacheMessageProcessor.processMessage(fixtureChange, new byte[0], routingKey, timestamp);

        verify(sportEventCache, times(1)).purgeCacheItem(eventId);
        verify(sportEventCache, times(0)).addFixtureTimestamp(eventId);
        verify(sportEventStatusCache, times(1)).purgeSportEventStatus(eventId);
    }
}
