package com.testinzone.unifiedodds.sdk.impl;

import com.testinzone.uf.datamodel.UfAlive;
import com.testinzone.uf.sportsapi.datamodel.SapiFixturesEndpoint;
import com.testinzone.unifiedodds.sdk.exceptions.internal.DataProviderException;
import com.testinzone.unifiedodds.sdk.exceptions.internal.DeserializationException;
import org.junit.Assert;
import org.junit.Test;

public class DataReaderTests {

    @Test
    public void mockFeedMessageReader() throws DeserializationException {
        UfAlive alive = XmlMessageReader.readMessageFromResource("test/feed_xml/alive.xml");
        Assert.assertNotNull(alive);
    }

    @Test
    public void mockSportsApiMessageReader() throws DeserializationException {
        SapiFixturesEndpoint fixturesEndpoint = XmlMessageReader.readMessageFromResource(
            "test/rest/fixtures.de.xml"
        );
        Assert.assertNotNull(fixturesEndpoint);
    }

    @Test
    public void mockDataProvider() throws DataProviderException {
        TestingDataProvider<SapiFixturesEndpoint> dataProvider = new TestingDataProvider<>(
            "test/rest/fixtures.de.xml"
        );
        SapiFixturesEndpoint data = dataProvider.getData();
        Assert.assertNotNull(data);
    }
}
