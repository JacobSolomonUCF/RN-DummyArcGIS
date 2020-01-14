package com.mapfix;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;


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

}
