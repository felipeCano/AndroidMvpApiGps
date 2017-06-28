package com.androidmvpexample.felipecano.androidmvpexample.ui.activity;


import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.androidmvpexample.felipecano.androidmvpexample.R;
import com.androidmvpexample.felipecano.androidmvpexample.ui.presenter.MainActivityPresenter;
import com.androidmvpexample.felipecano.androidmvpexample.ui.view.MainActivityView;
import com.google.android.gms.maps.SupportMapFragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import javax.inject.Inject;


public class MainActivity extends BaseActivity implements MainActivityView, OnMapReadyCallback {

    @Inject
    MainActivityPresenter mMainActivityPresenter;

    TextView mTextView;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textView);

        mMainActivityPresenter.attachView(this);

        // Map
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

        //API
        mMainActivityPresenter.getInformationApi();

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

        mMainActivityPresenter.locationMaps();

    }


    @Override
    public void showError() {

    }

    @Override
    public void showClimateInformation(String nameCity, String temp) {
        mTextView.setText(nameCity + "---" + temp);
        Log.d("LOG: ", nameCity + "---" + temp);
    }

}
