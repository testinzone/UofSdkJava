/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.example.examples;

import com.testinzone.unifiedodds.example.common.GlobalEventsListener;
import com.testinzone.unifiedodds.example.common.MessageListener;
import com.testinzone.unifiedodds.example.common.SdkConstants;
import com.testinzone.unifiedodds.sdk.MessageInterest;
import com.testinzone.unifiedodds.sdk.SportDataProvider;
import com.testinzone.unifiedodds.sdk.UofSdk;
import com.testinzone.unifiedodds.sdk.caching.exportable.CacheType;
import com.testinzone.unifiedodds.sdk.caching.exportable.ExportableCi;
import com.testinzone.unifiedodds.sdk.cfg.Environment;
import com.testinzone.unifiedodds.sdk.cfg.UofConfiguration;
import com.testinzone.unifiedodds.sdk.exceptions.InitException;
import java.io.*;
import java.util.List;
import java.util.Locale;

/**
 * A basic demonstration on how to export/import current cache state
 */
@SuppressWarnings({ "ClassDataAbstractionCoupling", "IllegalCatch", "MagicNumber" })
public class ExportImportSetup {

    private final UofSdk uofSdk;
    private final File cacheFile = new File("cache");

    public ExportImportSetup(String token) {
        logEntry("Running the UofSdk SDK Basic example - cache export/import");

        logEntry("Building the configuration using the provided token");
        UofConfiguration configuration = UofSdk
            .getUofConfigurationBuilder()
            .setAccessToken(token)
            .selectEnvironment(Environment.GlobalIntegration)
            .setNodeId(SdkConstants.NODE_ID)
            .setDefaultLanguage(Locale.ENGLISH)
            .build();

        logEntry("Creating a new UofSdk instance");
        uofSdk = new UofSdk(new GlobalEventsListener(), configuration);
    }

    public void run() throws IOException, InitException, InterruptedException {
        logEntry("Building a simple session which will receive all messages");
        uofSdk
            .getSessionBuilder()
            .setMessageInterest(MessageInterest.AllMessages)
            .setListener(new MessageListener("SingleSessionSetup"))
            .build();
        SportDataProvider sportDataProvider = uofSdk.getSportDataProvider();

        logEntry("Opening the feed instance");
        logEntry("Feed instance will remain open for 10 seconds");

        if (cacheFile.exists()) {
            logEntry("Importing cache state from existing file");
            try (
                FileInputStream stream = new FileInputStream(cacheFile);
                ObjectInputStream reader = new ObjectInputStream(stream)
            ) {
                List<ExportableCi> exportableCis = (List<ExportableCi>) reader.readObject();
                sportDataProvider.cacheImport(exportableCis);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        uofSdk.open();

        logEntry("Example successfully started");

        Thread.sleep(1000 * 10L);

        logEntry("Exporting cache state to file");
        try (
            FileOutputStream stream = new FileOutputStream(cacheFile);
            ObjectOutputStream writer = new ObjectOutputStream(stream)
        ) {
            List<ExportableCi> exportableCis = sportDataProvider.cacheExport(CacheType.All);
            writer.writeObject(exportableCis);
        } catch (Exception e) {
            e.printStackTrace();
        }

        logEntry("Closing the odds feed instance (10sec elapsed)");
        uofSdk.close();

        logEntry("ExportImportSetup example finished");
        logEntry("");
    }

    private static void logEntry(String s) {
        System.out.println(s);
    }
}
