package com.testinzone.unifiedodds.sdk.impl;

import com.google.common.collect.Lists;
import com.testinzone.unifiedodds.sdk.cfg.Environment;
import java.util.List;

public class EnvironmentSetting {

    private Environment environment;
    private String mqHost;
    private String apiHost;
    private int apiPort;
    private Boolean onlySsl;
    private List<Environment> retryList;
    /** Whether the broker expects the access token as the AMQP password rather than an empty one. */
    private boolean tokenAsMessagingPassword;

    public EnvironmentSetting(
        Environment environment,
        String mqHost,
        String apiHost,
        int apiPort,
        Boolean onlySsl,
        List<Environment> environmentRetryList
    ) {
        this.environment = environment;
        this.mqHost = mqHost;
        this.apiHost = apiHost;
        this.apiPort = apiPort;
        this.onlySsl = onlySsl;
        this.retryList = environmentRetryList == null ? Lists.newArrayList() : environmentRetryList;
        this.tokenAsMessagingPassword = false;
    }

    @SuppressWarnings("ParameterNumber")
    public EnvironmentSetting(
        Environment environment,
        String mqHost,
        String apiHost,
        int apiPort,
        Boolean onlySsl,
        List<Environment> environmentRetryList,
        boolean tokenAsMessagingPassword
    ) {
        this(environment, mqHost, apiHost, apiPort, onlySsl, environmentRetryList);
        this.tokenAsMessagingPassword = tokenAsMessagingPassword;
    }

    /**
     * Sportradar's brokers authenticate the access token as the username with an empty
     * password. A broker that instead expects the token as the password too sets this.
     * @return whether the access token doubles as the AMQP password
     */
    public boolean usesTokenAsMessagingPassword() {
        return tokenAsMessagingPassword;
    }

    /**
     * Get the environment.
     * @return the environment.
     */
    public Environment getEnvironment() {
        return environment;
    }

    /**
     * Get the rabbit host address
     * @return the rabbit host address
     */
    public String getMqHost() {
        return mqHost;
    }

    /**
     * Get the API host.
     * @return the API host
     */
    public String getApiHost() {
        return apiHost;
    }

    int getApiPort() {
        return apiPort;
    }

    /**
     * Gets a value indicating whether only SSL is supported on the endpoint or also non-ssl
     * @return a value indicating whether only SSL is supported on the endpoint or also non-ssl
     */
    public Boolean isOnlySsl() {
        return onlySsl;
    }

    /**
     * Gets the environment retry list.
     * @return the environment retry list.
     */
    public List<Environment> getEnvironmentRetryList() {
        return retryList;
    }
}
