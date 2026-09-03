/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.impl.entities;

import static java.util.Locale.ENGLISH;
import static org.junit.Assert.assertNull;

import com.testinzone.unifiedodds.sdk.entities.CurrentSeasonInfo;
import java.util.Locale;
import org.assertj.core.api.Assertions;

public class CurrentSeasonAssertions {

    private CurrentSeasonInfo season;

    public CurrentSeasonAssertions(CurrentSeasonInfo season) {
        this.season = season;
    }

    public static CurrentSeasonAssertions assertThat(CurrentSeasonInfo season) {
        return new CurrentSeasonAssertions(season);
    }

    public CurrentSeasonAssertions hasNameTranslated(Locale language, String translation) {
        Assertions.assertThat(season.getNames().get(language)).isEqualTo(translation);
        Assertions.assertThat(season.getName(language)).isEqualTo(translation);
        return this;
    }

    public void hasNameNotTranslatedTo(Locale language) {
        Assertions.assertThat(season.getNames().containsKey(language)).isFalse();
        assertNull(season.getName(language));
    }
}
