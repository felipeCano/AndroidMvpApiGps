package com.androidmvpexample.felipecano.androidmvpexample.injection.component;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;


import com.androidmvpexample.felipecano.androidmvpexample.data.DataManager;
import com.androidmvpexample.felipecano.androidmvpexample.injection.module.ApplicationModule;
import com.androidmvpexample.felipecano.androidmvpexample.injection.module.NetworkModule;
import com.androidmvpexample.felipecano.androidmvpexample.injection.qualifier.ApplicationContext;

import javax.inject.Singleton;


import dagger.Component;



@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    Application application();

    @ApplicationContext
    Context context();

    DataManager dataManager();

}
