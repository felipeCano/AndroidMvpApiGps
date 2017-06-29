package com.androidmvpexample.felipecano.androidmvpexample.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.androidmvpexample.felipecano.androidmvpexample.R;
import com.androidmvpexample.felipecano.androidmvpexample.ui.view.MenuActivityView;

/**
 * Created by felipecano on 29/06/17.
 */

public class MenuActivity extends BaseActivity implements MenuActivityView {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        setContentView(R.layout.menu_activity);

    }

    public void buttonShowClimateActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), ClimateActivity.class);
        startActivity(intent);
    }

    public void buttonShowLocationActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), LocationActivity.class);
        startActivity(intent);
    }

    @Override
    public void showError() {

    }

    @Override
    public void showClimateActivity() {

    }

    @Override
    public void showLocationActivity() {

    }
}
