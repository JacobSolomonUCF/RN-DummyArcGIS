package com.mapfix;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.esri.arcgisruntime.ArcGISRuntimeException;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.MapView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;


public class RNAGSMapView extends LinearLayout implements LifecycleEventListener {

    View rootView;
    public MapView mapView;
    String basemapUrl = "";
    String routeUrl = "";
    Boolean recenterIfGraphicTapped = false;
    Double minZoom = 0.0;
    Double maxZoom = 0.0;
    Boolean rotationEnabled = true;

    public RNAGSMapView(Context context) {
        super(context);
        rootView = inflate(context.getApplicationContext(),R.layout.rnags_mapview,this);
        mapView = rootView.findViewById(R.id.agsMapView);
        if (context instanceof ReactContext) {
            ((ReactContext) context).addLifecycleEventListener(this);
        }
        setUpMap();
    }

    @SuppressLint("ClickableViewAccessibility")
    public void setUpMap() {
        mapView.setMap(new ArcGISMap(Basemap.Type.STREETS_VECTOR, 34.057, -117.196, 17));
        mapView.getMap().addDoneLoadingListener(() -> {
            ArcGISRuntimeException e = mapView.getMap().getLoadError();
            Boolean success = e != null;
            String errorMessage = !success ? "" : e.getMessage();
            WritableMap map = Arguments.createMap();
            map.putBoolean("success",success);
            map.putString("errorMessage",errorMessage);

        });
    }

    // MARK: Event emitting
    public void emitEvent(String eventName, WritableMap args) {
        ((ReactContext) getContext()).getJSModule(RCTEventEmitter.class).receiveEvent(
                getId(),
                eventName,
                args
        );
    }

    // MARK: Lifecycle Event Listeners
    @Override
    public void onHostResume() {
        mapView.resume();
    }

    @Override
    public void onHostPause() {
        mapView.pause();
    }

    @Override
    public void onHostDestroy() {
        mapView.dispose();
        if (getContext() instanceof ReactContext) {
            ((ReactContext) getContext()).removeLifecycleEventListener(this);
        }
    }

}
