package com.androidmvpexample.felipecano.androidmvpexample.injection.component;

import android.content.Context;


import com.androidmvpexample.felipecano.androidmvpexample.injection.module.ActivityModule;
import com.androidmvpexample.felipecano.androidmvpexample.injection.qualifier.ActivityContext;
import com.androidmvpexample.felipecano.androidmvpexample.injection.scope.PerActivity;
import com.androidmvpexample.felipecano.androidmvpexample.ui.activity.ClimateActivity;
import com.androidmvpexample.felipecano.androidmvpexample.ui.activity.LocationActivity;
import com.androidmvpexample.felipecano.androidmvpexample.ui.activity.MenuActivity;

import dagger.Component;



@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(ClimateActivity mainActivity);
    void inject(MenuActivity menuActivity);
    void inject(LocationActivity locationActivity);

    @ActivityContext
    Context context();

}

