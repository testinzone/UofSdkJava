/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.cfg;

import static org.junit.Assert.*;

import com.testinzone.unifiedodds.sdk.ExceptionHandlingStrategy;
import com.testinzone.unifiedodds.sdk.entities.BookmakerDetails;
import java.util.List;
import java.util.Locale;

@SuppressWarnings("ClassFanOutComplexity")
public class UofConfigurationStub implements UofConfiguration {

    private UofCacheConfiguration cache = new UofCacheConfigurationStub();
    private UofRabbitConfiguration rabbit = new UofRabbitConfigurationStub();
    private UofProducerConfiguration producerConfig = new UofProducerConfigurationStub();
    private Environment environment;
    private UofApiConfiguration apiConfig = new UofApiConfigurationStub();
    private Integer nodeId;

    @Override
    public String getAccessToken() {
        return null;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public Environment getEnvironment() {
        return environment;
    }

    @Override
    public Locale getDefaultLanguage() {
        return null;
    }

    @Override
    public List<Locale> getLanguages() {
        return null;
    }

    @Override
    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    @Override
    public ExceptionHandlingStrategy getExceptionHandlingStrategy() {
        return null;
    }

    @Override
    public BookmakerDetails getBookmakerDetails() {
        return null;
    }

    @Override
    public UofApiConfiguration getApi() {
        return apiConfig;
    }

    public void setRabbit(UofRabbitConfiguration rabbit) {
        this.rabbit = rabbit;
    }

    @Override
    public UofRabbitConfiguration getRabbit() {
        return rabbit;
    }

    @Override
    public UofCacheConfiguration getCache() {
        return cache;
    }

    public void setCache(UofCacheConfiguration cache) {
        this.cache = cache;
    }

    @Override
    public UofProducerConfiguration getProducer() {
        return producerConfig;
    }

    @Override
    public UofAdditionalConfiguration getAdditional() {
        return null;
    }
}
