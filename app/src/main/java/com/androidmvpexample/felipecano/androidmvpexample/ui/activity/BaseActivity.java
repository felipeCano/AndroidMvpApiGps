package com.androidmvpexample.felipecano.androidmvpexample.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.androidmvpexample.felipecano.androidmvpexample.AppAplication;
import com.androidmvpexample.felipecano.androidmvpexample.injection.component.ActivityComponent;
import com.androidmvpexample.felipecano.androidmvpexample.injection.component.DaggerActivityComponent;
import com.androidmvpexample.felipecano.androidmvpexample.injection.module.ActivityModule;

/**
 * Created by felipecano on 28/06/17.
 */

public class BaseActivity extends AppCompatActivity {
    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }



    public ActivityComponent getActivityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder().activityModule(new ActivityModule(this))
                    .applicationComponent(AppAplication.get(this).getComponent()).build();
        }
        return mActivityComponent;
    }

    protected void callActivity(Intent intent) {
        startActivity(intent);
    }
}
