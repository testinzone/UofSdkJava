/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.impl.markets;

import java.util.Map;

/**
 * Created on 21/06/2017.
 * // TODO @eti: Javadoc
 */
public interface OperandFactory {
    Operand buildOperand(Map<String, String> specifiers, String operandExpression);
}
