package com.androidmvpexample.felipecano.androidmvpexample.data;

import com.androidmvpexample.felipecano.androidmvpexample.data.model.ClimateResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by felipecano on 28/06/17.
 */
@Singleton //solo puede haber una instancia de esa clase
public class DataManager {
    private final ApiService mApiService;

    @Inject
    public DataManager(ApiService mApiService){
        this.mApiService = mApiService;
    }
    public Observable<ClimateResponse> getClimate(){
        return ApiService.Factory.create().getSfClimate();
    }
}
