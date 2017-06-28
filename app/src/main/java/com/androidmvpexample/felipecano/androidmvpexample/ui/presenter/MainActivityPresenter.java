package com.androidmvpexample.felipecano.androidmvpexample.ui.presenter;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.androidmvpexample.felipecano.androidmvpexample.data.DataManager;
import com.androidmvpexample.felipecano.androidmvpexample.injection.qualifier.ApplicationContext;
import com.androidmvpexample.felipecano.androidmvpexample.ui.view.MainActivityView;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by felipecano on 28/06/17.
 */

public class MainActivityPresenter extends BasePresenter<MainActivityView> implements LocationListener {

    private CompositeSubscription mCompositeSubscription;

    private final DataManager mDataManager;

    private LocationManager locationManager;

    @Inject
    @ApplicationContext
    Context mContext;

    @Inject
    public MainActivityPresenter(DataManager dataManager) {
        this.mDataManager = dataManager;
    }

    @Override
    public void attachView(MainActivityView mvpView) {
        super.attachView(mvpView);
        if (mCompositeSubscription == null || mCompositeSubscription.isUnsubscribed()) {
            mCompositeSubscription = new CompositeSubscription();
        }
    }

    public void getInformationApi() {
        checkViewAttached();

        mCompositeSubscription.add(
                mDataManager.getClimate()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(climate -> {

                            getMvpView().showClimateInformation(
                                    climate.getCurrentObservation().getTempC().toString(),
                                    climate.getCurrentObservation().getObservationLocation().getCity());

                        }, throwable -> {
                            Log.d("ERROR ", throwable.getMessage());
                        })

        );

    }

    public void locationMaps() {

        if (ActivityCompat.checkSelfPermission(mContext, android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mContext,
                android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            locationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

            if (locationManager != null) {

                Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                if (location != null) {

                    getMvpView().showCoordinates(location.getLatitude(), location.getLongitude());

                }

            }

        }

    }


    @Override
    public void detachView() {
        super.detachView();
        if (mCompositeSubscription != null) {
            mCompositeSubscription.clear();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        double lat = (location.getLatitude());
        double lng = (location.getLongitude());
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