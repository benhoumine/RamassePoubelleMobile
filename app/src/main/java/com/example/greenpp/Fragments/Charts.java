package com.example.greenpp.Fragments;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.greenpp.Activities.MainActivity;
import com.example.greenpp.Entities.Jardin;
import com.example.greenpp.Entities.Plante;
import com.example.greenpp.Helper.Utils;
import com.example.greenpp.Notification.BuildNotification;
import com.example.greenpp.R;
import com.mapbox.android.core.permissions.PermissionsListener;
import com.mapbox.android.core.permissions.PermissionsManager;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.services.android.navigation.v5.navigation.MapboxNavigation;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Charts extends Fragment implements MapboxMap.OnMarkerClickListener,MapboxMap.OnMapLongClickListener, OnMapReadyCallback,PermissionsListener {

    MainActivity activity;
    private View view;
    private static final String TAG = "Charts";
    MapboxNavigation navigation;

    @Bind(R.id.mapView)
    MapView mapView;

    private MapboxMap mapboxMap;
    private PermissionsManager permissionsManager;

    public static Charts newInstance() {
        Charts fragment = new Charts();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.chart_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "Lunched");
        ButterKnife.bind(this, view);
        activity = (MainActivity) getActivity();
        Mapbox.getInstance(activity, "pk.eyJ1IjoiYWJkZWxraGFsZWsiLCJhIjoiY2s0cmRiNzI0MGFmazNnbjBob2lxd3I0MCJ9.brZ5-XRCKC_20JyhrY9bxw");
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        navigation = new MapboxNavigation(activity, "pk.eyJ1IjoiYWJkZWxraGFsZWsiLCJhIjoiY2s0cmRiNzI0MGFmazNnbjBob2lxd3I0MCJ9.brZ5-XRCKC_20JyhrY9bxw");
    }


    @Override
    public void onExplanationNeeded(List<String> permissionsToExplain) {

    }

    @Override
    public void onPermissionResult(boolean granted) {

    }


    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
        return false;
    }

    @Override
    public void onMapReady(MapboxMap mapboxMap) {

    }

    @Override
    public boolean onMapLongClick(@NonNull LatLng point) {
        return false;
    }
}
