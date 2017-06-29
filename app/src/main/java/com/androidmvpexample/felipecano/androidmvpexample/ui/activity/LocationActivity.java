package com.androidmvpexample.felipecano.androidmvpexample.ui.activity;

import android.os.Bundle;

import com.androidmvpexample.felipecano.androidmvpexample.R;
import com.androidmvpexample.felipecano.androidmvpexample.ui.presenter.LocationActivityPresenter;
import com.androidmvpexample.felipecano.androidmvpexample.ui.view.LocationActivityView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import javax.inject.Inject;

/**
 * Created by felipecano on 29/06/17.
 */

public class LocationActivity extends BaseActivity implements LocationActivityView, OnMapReadyCallback {

    private GoogleMap mMap;
    @Inject
    LocationActivityPresenter mLocationActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        setContentView(R.layout.location_activity);

        mLocationActivityPresenter.attachView(this);

        // Map
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
    }

    @Override
    public void showCoordinates(double lat, double lon) {
        LatLng location = new LatLng(lat, lon);
        mMap.addMarker(new MarkerOptions().position(location).title("Current Location"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 19.0f));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mLocationActivityPresenter.locationMaps();

    }

    @Override
    public void showError() {

    }
}
