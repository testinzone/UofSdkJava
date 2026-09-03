/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.caching.exportable;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.testinzone.unifiedodds.sdk.testutil.generic.collections.Maps;
import com.testinzone.utils.Urns;
import com.testinzone.utils.domain.names.Languages;
import com.testinzone.utils.domain.names.Names;
import java.util.Locale;
import java.util.Map;
import lombok.val;
import org.junit.Test;

public class ExportableCourseCiTest {

    private Map<Locale, String> anyName = Maps.of(Languages.any(), Names.any());

    @Test
    public void nullHolesAreTranslatedToEmptyList() {
        val course = new ExportableCourseCi(Urns.Venues.urnForAnyVenue(), anyName, null);

        assertThat(course.getHoles()).isEmpty();
    }

    @Test
    public void nullIdShouldBePreserved() {
        val course = new ExportableCourseCi(null, anyName, asList());

        assertThat(course.getId()).isNull();
    }

    @Test
    public void nullNamesIsConvertedToEmptyCollection() {
        ExportableCourseCi courseCi = new ExportableCourseCi(Urns.Venues.urnForAnyVenue(), null, asList());

        assertThat(courseCi.getName()).isEmpty();
    }
}
