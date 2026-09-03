/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.conn;

import com.testinzone.uf.sportsapi.datamodel.BookmakerDetails;
import com.testinzone.uf.sportsapi.datamodel.ResponseCode;
import com.testinzone.unifiedodds.sdk.testutil.jaxb.XmlGregorianCalendars;
import lombok.SneakyThrows;

public class SapiBookmakerDetails {

    @SneakyThrows
    public static BookmakerDetails valid() {
        final BookmakerDetails bookmakerDetails = new BookmakerDetails();
        int anyBookmakerId = 1;
        bookmakerDetails.setBookmakerId(anyBookmakerId);
        bookmakerDetails.setExpireAt(XmlGregorianCalendars.anyFutureDate());
        bookmakerDetails.setVirtualHost("/unifiedfeed/" + anyBookmakerId);
        bookmakerDetails.setResponseCode(ResponseCode.OK);
        return bookmakerDetails;
    }
}
