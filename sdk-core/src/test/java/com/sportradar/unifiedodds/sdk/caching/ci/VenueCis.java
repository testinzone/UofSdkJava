/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.caching.ci;

import static com.testinzone.unifiedodds.sdk.testutil.serialization.JavaSerializer.deserialize;
import static com.testinzone.unifiedodds.sdk.testutil.serialization.JavaSerializer.serialize;

import com.testinzone.unifiedodds.sdk.caching.exportable.ExportableVenueCi;
import lombok.val;

public final class VenueCis {

    private VenueCis() {}

    public static VenueCi exportSerializeAndUseConstructorToReimport(VenueCi original) throws Exception {
        val exportedRaceStage = original.export();
        val serialized = serialize(exportedRaceStage);
        val deserialized = deserialize(serialized);
        return new VenueCi((ExportableVenueCi) deserialized);
    }
}
