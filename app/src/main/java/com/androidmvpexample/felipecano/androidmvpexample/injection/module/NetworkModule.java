package com.androidmvpexample.felipecano.androidmvpexample.injection.module;

import com.androidmvpexample.felipecano.androidmvpexample.data.ApiService;

import javax.inject.Singleton;


import dagger.Module;
import dagger.Provides;


@Module
public class NetworkModule {

    protected final String PREF_NAME = "preferences";

    public NetworkModule() {
    }

    @Provides
    @Singleton
    ApiService provideApiService() {
        return ApiService.Factory.create();
    }

}
