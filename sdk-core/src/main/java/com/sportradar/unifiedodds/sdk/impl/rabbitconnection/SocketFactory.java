/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.impl.rabbitconnection;

import java.io.IOException;
import java.net.Socket;

public class SocketFactory {

    public Socket openNew(final String host, final int port) throws IOException {
        return new Socket(host, port);
    }
}
