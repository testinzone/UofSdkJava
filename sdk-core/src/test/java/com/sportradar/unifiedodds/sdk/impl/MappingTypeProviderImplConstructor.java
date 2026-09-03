/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.impl;

public class MappingTypeProviderImplConstructor {

    private MappingTypeProviderImplConstructor() {}

    public static MappingTypeProvider create() {
        return new MappingTypeProviderImpl();
    }
}
