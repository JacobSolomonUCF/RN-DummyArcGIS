package com.mapfix;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

public class RNArcGISMapViewModule extends ReactContextBaseJavaModule {
    public RNArcGISMapViewModule(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return "RNArcGISMapViewManager";
    }

}