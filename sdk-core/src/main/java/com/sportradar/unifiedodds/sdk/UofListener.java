/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk;

import com.testinzone.unifiedodds.sdk.entities.SportEvent;

/**
 * These are all the messages you can receive relating to odds. You implement this interface to
 * handle received messages.
 *
 */
public interface UofListener extends GenericUofListener<SportEvent> {}
