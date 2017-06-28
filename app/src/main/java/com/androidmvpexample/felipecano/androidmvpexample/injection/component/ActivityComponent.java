package com.androidmvpexample.felipecano.androidmvpexample.injection.component;

import android.content.Context;


import com.androidmvpexample.felipecano.androidmvpexample.injection.module.ActivityModule;
import com.androidmvpexample.felipecano.androidmvpexample.injection.qualifier.ActivityContext;
import com.androidmvpexample.felipecano.androidmvpexample.injection.scope.PerActivity;
import com.androidmvpexample.felipecano.androidmvpexample.ui.activity.MainActivity;

import dagger.Component;



@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

    @ActivityContext
    Context context();

}
