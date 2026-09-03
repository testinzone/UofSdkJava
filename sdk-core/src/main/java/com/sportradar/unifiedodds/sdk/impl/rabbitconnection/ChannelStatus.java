/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.impl.rabbitconnection;

@SuppressWarnings({ "NoEnumTrailingComma" })
class ChannelStatus {

    private UnderlyingConnectionStatus underlyingConnectionStatus;

    ChannelStatus(UnderlyingConnectionStatus underlyingConnectionStatus) {
        this.underlyingConnectionStatus = underlyingConnectionStatus;
    }

    UnderlyingConnectionStatus getUnderlyingConnectionStatus() {
        return underlyingConnectionStatus;
    }

    enum UnderlyingConnectionStatus {
        CAN_BE_OPEN,
        PERMANENTLY_CLOSED,
    }
}
