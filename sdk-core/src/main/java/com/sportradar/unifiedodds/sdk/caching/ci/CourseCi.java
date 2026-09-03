/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.caching.ci;

import static com.testinzone.utils.stream.optional.NonNullMapper.ifNotNull;
import static java.util.stream.Collectors.toList;

import com.testinzone.uf.sportsapi.datamodel.SapiCourse;
import com.testinzone.unifiedodds.sdk.caching.exportable.ExportableCourseCi;
import com.testinzone.unifiedodds.sdk.domain.language.Translations;
import com.testinzone.utils.Urn;
import java.util.List;
import java.util.Locale;

public class CourseCi {

    private final List<HoleCi> holes;

    private final Urn id;

    private final Translations name;

    public CourseCi(SapiCourse course, Locale language) {
        this.holes = course.getHole().stream().map(HoleCi::new).collect(toList());
        id = ifNotNull(course.getId()).map(Urn::parse);
        name = new Translations(language, course.getName());
    }

    public CourseCi(ExportableCourseCi course) {
        this.holes = course.getHoles().stream().map(HoleCi::new).collect(toList());
        id = course.getId();
        name = Translations.importFrom(course.getName());
    }

    public List<HoleCi> getHoles() {
        return holes;
    }

    public ExportableCourseCi export() {
        return new ExportableCourseCi(
            id,
            name.export(),
            holes.stream().map(HoleCi::export).collect(toList())
        );
    }

    public Urn getId() {
        return id;
    }

    public Translations getName() {
        return name;
    }

    public void mergeWithoutOverriding(CourseCi courseCi) {
        name.addAllWithoutOverriding(courseCi.getName());
    }
}
