/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.testutil.rabbit.integration;

import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BaseUrl {

    @NonNull
    private final String host;

    @NonNull
    private final int port;

    public static BaseUrl of(String host, int port) {
        return new BaseUrl(host, port);
    }

    public static BaseUrl any() {
        final int anyPort = 987;
        return of("any", anyPort);
    }

    public String get() {
        return host + ":" + port;
    }
}
