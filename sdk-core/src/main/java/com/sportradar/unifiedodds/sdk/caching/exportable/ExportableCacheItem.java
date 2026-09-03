/*
 * Copyright (C) Testinzone AG. See LICENSE for full license governing this code
 */

package com.testinzone.unifiedodds.sdk.caching.exportable;

/**
 * Interface used by cache items to export their properties
 */
public interface ExportableCacheItem {
    /**
     * Export item's properties
     *
     * @return An {@link ExportableCi} instance containing all relevant properties
     */
    ExportableCi export();
}
