package com.androidmvpexample.felipecano.androidmvpexample.injection.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.androidmvpexample.felipecano.androidmvpexample.injection.qualifier.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;



@Module
public class ApplicationModule {

    protected final Application mApplication;

    public ApplicationModule(Application application) {
        this.mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }


}
