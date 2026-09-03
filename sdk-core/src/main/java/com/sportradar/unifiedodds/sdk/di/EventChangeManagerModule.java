/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.di;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.testinzone.unifiedodds.sdk.CustomBetSelectionBuilder;
import com.testinzone.unifiedodds.sdk.CustomBetSelectionBuilderImpl;

/**
 * The DI module in charge of EventChangeManager
 */
public class EventChangeManagerModule extends AbstractModule {

    /**
     * Configures a {@link Binder} via the exposed methods.
     */
    @Override
    protected void configure() {
        bind(CustomBetSelectionBuilder.class).to(CustomBetSelectionBuilderImpl.class);
    }
}
