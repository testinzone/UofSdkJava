/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.caching.fixtures;

import com.testinzone.unifiedodds.sdk.entities.NamedValue;

public class NamedValueStub implements NamedValue {

    private final int id;
    private final String description;

    public NamedValueStub(int id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
