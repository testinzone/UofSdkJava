/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk;

import static com.testinzone.unifiedodds.sdk.cfg.Environment.GlobalReplay;
import static com.testinzone.unifiedodds.sdk.cfg.Environment.Replay;
import static java.util.Arrays.asList;

import com.testinzone.unifiedodds.sdk.cfg.UofConfiguration;
import com.testinzone.unifiedodds.sdk.cfg.UofConfigurationImpl;
import com.testinzone.unifiedodds.sdk.di.CustomisableSdkModule;
import com.testinzone.unifiedodds.sdk.extended.UofExtListener;

/**
 * An extension of the UofSdk that has the ability to customise some of the sdk components
 */
@SuppressWarnings({ "LineLength" })
public class CustomisableUofSdk extends UofSdk {

    /**
     * The following constructor is used to crate the UofSdk instance with a custom injection module
     *
     * @param listener              {@link UofGlobalEventsListener} that handles global feed events
     * @param config                {@link UofConfigurationImpl}, the configuration class used to configure the new feed
     * @param customisableSdkModule the customised injection module
     */
    public CustomisableUofSdk(
        UofGlobalEventsListener listener,
        UofConfiguration config,
        CustomisableSdkModule customisableSdkModule
    ) {
        super(
            listener,
            config,
            config == null ? false : asList(Replay, GlobalReplay).contains(config.getEnvironment()),
            customisableSdkModule,
            null
        );
    }

    /**
     * The following constructor is used to crate the UofSdk instance with a custom injection module
     *
     * @param listener              {@link UofGlobalEventsListener} that handles global feed events
     * @param config                {@link UofConfigurationImpl}, the configuration class used to configure the new feed
     * @param customisableSdkModule the customised injection module
     * @param uofExtListener {@link UofExtListener} used to receive raw feed and api data
     */
    public CustomisableUofSdk(
        UofGlobalEventsListener listener,
        UofConfiguration config,
        CustomisableSdkModule customisableSdkModule,
        UofExtListener uofExtListener
    ) {
        super(
            listener,
            config,
            config == null ? false : asList(Replay, GlobalReplay).contains(config.getEnvironment()),
            customisableSdkModule,
            uofExtListener
        );
    }
}
