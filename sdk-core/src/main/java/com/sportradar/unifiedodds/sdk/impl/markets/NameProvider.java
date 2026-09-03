/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.impl.markets;

import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created on 15/06/2017.
 * // TODO @eti: Javadoc
 */
public interface NameProvider {
    String getMarketName(Locale locale);
    Map<Locale, String> getMarketNames(List<Locale> locales);
    String getOutcomeName(String outcomeId, Locale locale);
    Map<Locale, String> getOutcomeNames(String outcomeId, List<Locale> locales);
}
