/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.impl.markets;

import com.testinzone.unifiedodds.sdk.entities.SportEvent;
import java.util.Map;

/**
 * Created on 15/06/2017.
 * // TODO @eti: Javadoc
 */
public interface NameExpressionFactory {
    NameExpression buildExpression(
        SportEvent sportEvent,
        Map<String, String> specifiers,
        String operator,
        String operand
    );
}
