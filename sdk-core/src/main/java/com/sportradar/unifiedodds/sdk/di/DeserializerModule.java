/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */
package com.testinzone.unifiedodds.sdk.di;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.testinzone.unifiedodds.sdk.impl.Deserializer;
import com.testinzone.unifiedodds.sdk.impl.DeserializerImpl;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class DeserializerModule implements Module {

    private final JAXBContext messagesJaxbContext;

    private final JAXBContext sportsApiJaxbContext;

    private final JAXBContext customBetApiJaxbContext;

    public DeserializerModule() {
        try {
            messagesJaxbContext = JAXBContext.newInstance("com.testinzone.uf.datamodel");
            sportsApiJaxbContext = JAXBContext.newInstance("com.testinzone.uf.sportsapi.datamodel");
            customBetApiJaxbContext = JAXBContext.newInstance("com.testinzone.uf.custombet.datamodel");
        } catch (JAXBException e) {
            throw new IllegalStateException("JAXB contexts creation failed, ex: ", e);
        }
    }

    @Override
    public void configure(Binder binder) {}

    @Provides
    @Named("MessageJAXBContext")
    private JAXBContext provideMessageJaxbContext() {
        return messagesJaxbContext;
    }

    @Provides
    @Named("SportsApiJaxbDeserializer")
    private Deserializer provideSportsApiJaxbDeserializer() {
        return new DeserializerImpl(sportsApiJaxbContext);
    }

    @Provides
    @Named("CustomBetApiJaxbDeserializer")
    private Deserializer provideCustomBetApiJaxbDeserializer() {
        return new DeserializerImpl(customBetApiJaxbContext);
    }

    @Provides
    @Named("MessageDeserializer")
    private Deserializer provideMessageDeserializer() {
        return new DeserializerImpl(messagesJaxbContext);
    }
}
