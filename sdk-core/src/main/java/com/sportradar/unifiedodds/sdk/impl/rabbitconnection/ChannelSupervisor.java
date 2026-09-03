/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.impl.rabbitconnection;

import com.testinzone.unifiedodds.sdk.impl.ChannelMessageConsumer;
import java.io.IOException;
import java.util.List;

public interface ChannelSupervisor {
    OpeningResult openChannel(
        List<String> routingKeys,
        ChannelMessageConsumer channelMessageConsumer,
        String messageInterest
    ) throws IOException;

    ClosingResult closeChannel() throws IOException;
}
