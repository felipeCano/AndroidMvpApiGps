package com.androidmvpexample.felipecano.androidmvpexample.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.androidmvpexample.felipecano.androidmvpexample.R;
import com.androidmvpexample.felipecano.androidmvpexample.ui.view.MenuActivityView;
import com.auth0.android.jwt.Claim;
import com.auth0.android.jwt.JWT;

import java.util.Date;

/**
 * Created by felipecano on 29/06/17.
 */

public class MenuActivity extends BaseActivity implements MenuActivityView {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        setContentView(R.layout.menu_activity);
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzY290Y2guaW8iLCJleHAiOjEzMDA4MTkzODAsIm5hbWUiOiJDaHJpcyBTZXZpbGxlamEiLCJhZG1pbiI6dHJ1ZX0.03f329983b86f7d9a9f5fef85305880101d5e302afafa20154d094b229f75773";
        JWT jwt = new JWT(token);
        Date expiresAt = jwt.getExpiresAt();

        Claim claim = jwt.getClaim("admin");
        Claim claimm = jwt.getClaim("name");


        Log.d("este", expiresAt.toString() + claim.asString()+claimm.asString());

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
