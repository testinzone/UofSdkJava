package com.testinzone.unifiedodds.sdk.shared;

import com.testinzone.uf.custombet.datamodel.CapiAvailableSelections;
import com.testinzone.uf.custombet.datamodel.CapiCalculationResponse;
import com.testinzone.uf.custombet.datamodel.CapiFilteredCalculationResponse;
import com.testinzone.unifiedodds.sdk.custombetentities.AvailableSelections;
import com.testinzone.unifiedodds.sdk.custombetentities.Calculation;
import com.testinzone.unifiedodds.sdk.custombetentities.CalculationFilter;
import com.testinzone.unifiedodds.sdk.impl.custombetentities.AvailableSelectionsImpl;
import com.testinzone.unifiedodds.sdk.impl.custombetentities.CalculationFilterImpl;
import com.testinzone.unifiedodds.sdk.impl.custombetentities.CalculationImpl;
import com.testinzone.utils.Urn;

@SuppressWarnings(
    {
        "HideUtilityClassConstructor",
        "OverloadMethodsDeclarationOrder",
        "StaticVariableName",
        "VisibilityModifier",
    }
)
public class SdkMessageBuilder {

    public static StaticRandom SR;
    public static RestMessageBuilder RMB;

    public static AvailableSelections getAvailableSelections(int eventId, int nbrMarkets) {
        Urn matchId = SR.Urn(eventId == 0 ? SR.I1000() : eventId, "match");
        return new AvailableSelectionsImpl(RMB.getAvailableSelections(matchId, nbrMarkets));
    }

    public static Calculation getCalculation(int eventId, int nbrSelections) {
        Urn matchId = SR.Urn(eventId == 0 ? SR.I1000() : eventId, "match");
        return new CalculationImpl(RMB.getCalculationResponse(matchId, nbrSelections));
    }

    public static CalculationFilter getCalculationFilter(int eventId, int nbrSelections) {
        Urn matchId = SR.Urn(eventId == 0 ? SR.I1000() : eventId, "match");
        return new CalculationFilterImpl(RMB.getFilteredCalculationResponse(matchId, nbrSelections));
    }

    public static AvailableSelections getAvailableSelections(CapiAvailableSelections availableSelections) {
        return new AvailableSelectionsImpl(availableSelections);
    }

    public static Calculation getCalculation(CapiCalculationResponse calculationResponse) {
        return new CalculationImpl(calculationResponse);
    }

    public static CalculationFilter getCalculationFilter(
        CapiFilteredCalculationResponse calculationResponse
    ) {
        return new CalculationFilterImpl(calculationResponse);
    }
}
