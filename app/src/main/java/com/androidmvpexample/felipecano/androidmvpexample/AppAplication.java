package com.androidmvpexample.felipecano.androidmvpexample;

import android.app.Application;
import android.content.Context;

import com.androidmvpexample.felipecano.androidmvpexample.injection.component.ApplicationComponent;
import com.androidmvpexample.felipecano.androidmvpexample.injection.component.DaggerApplicationComponent;
import com.androidmvpexample.felipecano.androidmvpexample.injection.module.ApplicationModule;
import com.androidmvpexample.felipecano.androidmvpexample.injection.module.NetworkModule;

/**
 * Created by felipecano on 28/06/17.
 */

public class AppAplication extends Application {
    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {

        }
    }


    public static AppAplication get(Context context) {
        return (AppAplication) context.getApplicationContext();
    }


    public void setComponent(ApplicationComponent applicationComponent) {
        this.mApplicationComponent = applicationComponent;
    }

    public ApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .networkModule(new NetworkModule())
                    .build();
        }
        return mApplicationComponent;
    }
}
