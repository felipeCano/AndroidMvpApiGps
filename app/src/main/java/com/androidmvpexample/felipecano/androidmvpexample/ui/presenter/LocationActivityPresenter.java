package com.androidmvpexample.felipecano.androidmvpexample.ui.presenter;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

import com.androidmvpexample.felipecano.androidmvpexample.injection.qualifier.ApplicationContext;
import com.androidmvpexample.felipecano.androidmvpexample.ui.view.LocationActivityView;

import javax.inject.Inject;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by felipecano on 29/06/17.
 */

public class LocationActivityPresenter extends BasePresenter<LocationActivityView> implements LocationListener {

    private CompositeSubscription mCompositeSubscription;
    private LocationManager locationManager;

    @Inject
    @ApplicationContext
    Context mContext;

    @Inject
    public LocationActivityPresenter() {
    }

    @Override
    public void attachView(LocationActivityView mvpView) {
        super.attachView(mvpView);
        if (mCompositeSubscription == null || mCompositeSubscription.isUnsubscribed()) {
            mCompositeSubscription = new CompositeSubscription();
        }
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mCompositeSubscription != null) {
            mCompositeSubscription.clear();
        }
    }

    public void locationMaps() {

        if (ActivityCompat.checkSelfPermission(mContext, android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mContext,
                android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            locationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);

            if (locationManager != null) {

                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

                Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                if (location != null) {

                    getMvpView().showCoordinates(location.getLatitude(), location.getLongitude());

                }

            }

        }

    }


    @Override
    public void onLocationChanged(Location location) {
        double lat = (location.getLatitude());
        double lng = (location.getLongitude());

        getMvpView().showCoordinates(lat, lng);

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
