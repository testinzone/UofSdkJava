/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.cfg;

import com.testinzone.unifiedodds.sdk.impl.util.files.ResourceReader;
import com.testinzone.unifiedodds.sdk.impl.util.javaclass.ClassResolver;
import java.util.HashMap;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;

public class StubSdkConfigurationYamlReader extends SdkConfigurationYamlReader {

    private Map<String, String> properties;

    public StubSdkConfigurationYamlReader() {
        super(new ClassResolver(), new Yaml(), new ResourceReader());
        this.properties = new HashMap<>();
    }

    public StubSdkConfigurationYamlReader(Map<String, String> properties) {
        super(new ClassResolver(), new Yaml(), new ResourceReader());
        this.properties = properties;
    }

    @Override
    Map<String, String> readConfiguration() {
        return properties;
    }
}
