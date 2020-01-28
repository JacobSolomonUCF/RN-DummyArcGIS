package com.mapfix;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

import java.util.Map;


public class RNArcGISMapViewManager extends SimpleViewManager<RNAGSMapView> {

    // MARK Initializing methods
    @Override
    public String getName() {
        return "RNArcGISMapView";
    }

    @Override
    protected RNAGSMapView createViewInstance(ThemedReactContext reactContext) {
        return new RNAGSMapView(reactContext);
    }

    public Map getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder()
                .put(
                        "onMapDidLoad",
                        MapBuilder.of(
                                "phasedRegistrationNames",
                                MapBuilder.of("bubbled", "onMapDidLoad")))
                .build();
    }

}
