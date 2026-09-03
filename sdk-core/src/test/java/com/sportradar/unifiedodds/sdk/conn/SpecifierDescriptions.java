/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.conn;

import com.testinzone.uf.sportsapi.datamodel.DescSpecifiers;
import com.testinzone.unifiedodds.sdk.impl.UnifiedFeedConstants;

public class SpecifierDescriptions {

    public static DescSpecifiers variant() {
        DescSpecifiers setSpecifiers = new DescSpecifiers();
        setSpecifiers
            .getSpecifier()
            .add(specifier(UnifiedFeedConstants.VARIANT_DESCRIPTION_NAME, "variable_text"));
        return setSpecifiers;
    }

    public static DescSpecifiers variantAndVersion() {
        DescSpecifiers setSpecifiers = new DescSpecifiers();
        setSpecifiers
            .getSpecifier()
            .add(specifier(UnifiedFeedConstants.VARIANT_DESCRIPTION_NAME, "variable_text"));
        setSpecifiers.getSpecifier().add(specifier("version", "string"));
        return setSpecifiers;
    }

    private static DescSpecifiers.Specifier specifier(String name, String type) {
        DescSpecifiers.Specifier specifier = new DescSpecifiers.Specifier();
        specifier.setName(name);
        specifier.setType(type);
        return specifier;
    }
}
