/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.conn;

import com.testinzone.utils.Urn;

public enum Sport {
    FOOTBALL(Urn.parse("sr:sport:1")),
    FUTSAL(Urn.parse("sr:sport:29"));

    private final Urn urn;

    private Sport(Urn urn) {
        this.urn = urn;
    }

    public Urn getUrn() {
        return urn;
    }
}
