/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.impl.entities;

import com.google.common.base.Preconditions;
import com.testinzone.uf.sportsapi.datamodel.SapiResultChange;
import com.testinzone.unifiedodds.sdk.entities.ResultChange;
import com.testinzone.utils.SdkHelper;
import com.testinzone.utils.Urn;
import java.util.Date;

/**
 * A representation of a result change
 *
 */
public class ResultChangeImpl implements ResultChange {

    private final Urn sportEventId;
    private final Date updateTime;

    /**
     * Initializes a new instance of the {@link ResultChangeImpl}
     *
     * @param resultChange - {@link SapiResultChange} used to create the new instance
     */
    public ResultChangeImpl(SapiResultChange resultChange) {
        Preconditions.checkNotNull(resultChange);
        Preconditions.checkNotNull(resultChange.getSportEventId());
        Preconditions.checkNotNull(resultChange.getUpdateTime());

        this.sportEventId = Urn.parse(resultChange.getSportEventId());
        this.updateTime = SdkHelper.toDate(resultChange.getUpdateTime());
    }

    /**
     * Returns the {@link Urn} instance specifying the sport event
     *
     * @return - the {@link Urn} instance specifying the sport event
     */
    public Urn getSportEventId() {
        return sportEventId;
    }

    /**
     * Returns the {@link Date} instance specifying the last update time
     *
     * @return - the {@link Date} instance specifying the last update time
     */
    public Date getUpdateTime() {
        return updateTime;
    }
}
