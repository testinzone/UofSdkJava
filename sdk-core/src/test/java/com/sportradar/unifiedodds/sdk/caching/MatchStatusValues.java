/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.caching;

import com.testinzone.unifiedodds.sdk.entities.LocalizedNamedValue;
import java.util.List;
import java.util.Locale;

public class MatchStatusValues {

    public static LocalizedNamedValueCache createNoOp() {
        return new LocalizedNamedValueCache() {
            @Override
            public LocalizedNamedValue get(int id, List<Locale> locales) {
                return null;
            }

            @Override
            public boolean isValueDefined(int id) {
                return false;
            }
        };
    }
}
