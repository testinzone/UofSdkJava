/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.impl.apireaders;

public class HttpHelperDeleteTest extends HttpHelperWithStubbedHttpClientTest {

    @Override
    InvokeHelpersHttpMethod httpMethodInvocationOn(HttpHelper httpHelper) {
        return path -> httpHelper.delete(path);
    }
}
