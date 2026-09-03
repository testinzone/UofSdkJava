/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.caching.impl.ci;

import com.testinzone.unifiedodds.sdk.caching.StageCi;

class RaceStageCiToMergeTo {

    private StageCi value;

    private RaceStageCiToMergeTo(StageCi value) {
        this.value = value;
    }

    static RaceStageCiToMergeTo into(StageCi target) {
        return new RaceStageCiToMergeTo(target);
    }

    StageCi getValue() {
        return value;
    }
}
