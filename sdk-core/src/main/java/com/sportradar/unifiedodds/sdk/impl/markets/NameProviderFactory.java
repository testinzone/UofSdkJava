/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.impl.markets;

import com.testinzone.unifiedodds.sdk.entities.SportEvent;
import java.util.Map;

/**
 * Created on 20/06/2017.
 * // TODO @eti: Javadoc
 */
public interface NameProviderFactory {
    NameProvider buildNameProvider(
        SportEvent sportEvent,
        int marketId,
        Map<String, String> specifiers,
        int producerId
    );
}
