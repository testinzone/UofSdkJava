package com.testinzone.unifiedodds.sdk.conn;

import com.testinzone.unifiedodds.sdk.entities.SportEvent;

@SuppressWarnings({ "MemberName", "VisibilityModifier" })
public class FeedMessage {

    public long Timestamp;

    public SportEvent Event;

    public String MsgType;

    public FeedMessage(long timestamp, SportEvent sportEvent, String msgType) {
        Timestamp = timestamp;
        Event = sportEvent;
        MsgType = msgType;
    }
}
