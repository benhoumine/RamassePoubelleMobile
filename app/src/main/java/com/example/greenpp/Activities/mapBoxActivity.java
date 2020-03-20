package com.example.greenpp.Activities;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.example.greenpp.Entities.Jardin;
import com.example.greenpp.R;
import com.google.gson.Gson;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.style.layers.PropertyFactory;
import com.mapbox.mapboxsdk.style.layers.SymbolLayer;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;

import java.util.ArrayList;
import java.util.List;

import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconAllowOverlap;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconOffset;



public class mapBoxActivity extends AppCompatActivity implements
        OnMapReadyCallback {

    private MapView mapView;
    private Jardin jardin;
    private static final String SOURCE_ID = "SOURCE_ID";
    private static final String ICON_ID = "ICON_ID";
    private static final String LAYER_ID = "LAYER_ID";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("Activité MapBox");
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this, getString(R.string.access_token));
        setContentView(R.layout.activity_map_box);
        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        String jardinJSON = getIntent().getExtras().getString("JARDIN_JSON");
        Gson gson = new Gson();
        this.jardin = gson.fromJson(jardinJSON, Jardin.class);

        System.out.println("Dans Maps jardin : " + this.jardin.getNomJardin());
    }

    @Override
    public void onMapReady(@NonNull final MapboxMap mapboxMap) {
        List<Feature> symbolLayerIconFeatureList = new ArrayList<>();
        symbolLayerIconFeatureList.add(Feature.fromGeometry(
                Point.fromLngLat(3.0925838947296143, 45.771724700927734)));
        symbolLayerIconFeatureList.add(Feature.fromGeometry(
                Point.fromLngLat(3.1215284, 45.7625999)));
        symbolLayerIconFeatureList.add(Feature.fromGeometry(
                Point.fromLngLat(6.3016029, 46.927027)));

        mapboxMap.setStyle(new Style.Builder().fromUri("mapbox://styles/mapbox/cjf4m44iw0uza2spb3q0a7s41")
                .withImage(ICON_ID, BitmapFactory.decodeResource(
                        mapBoxActivity.this.getResources(), R.drawable.mapbox_marker_icon_default))
                .withSource(new GeoJsonSource(SOURCE_ID,
                        FeatureCollection.fromFeatures(symbolLayerIconFeatureList)))
                        .withLayer(new SymbolLayer(LAYER_ID, SOURCE_ID)
                                .withProperties(PropertyFactory.iconImage(ICON_ID),
                                        iconAllowOverlap(true),
                                        iconOffset(new Float[] {0f, -9f}))
                        ), new Style.OnStyleLoaded() {
                    @Override
                    public void onStyleLoaded(@NonNull Style style) {



                    }
                }
        );
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}
