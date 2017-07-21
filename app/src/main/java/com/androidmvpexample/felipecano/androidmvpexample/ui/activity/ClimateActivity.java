package com.androidmvpexample.felipecano.androidmvpexample.ui.activity;


import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.androidmvpexample.felipecano.androidmvpexample.R;
import com.androidmvpexample.felipecano.androidmvpexample.ui.presenter.ClimateActivityPresenter;
import com.androidmvpexample.felipecano.androidmvpexample.ui.view.ClimateActivityView;


import javax.inject.Inject;


public class ClimateActivity extends BaseActivity implements ClimateActivityView {

    @Inject
    ClimateActivityPresenter mMainActivityPresenter;

    TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textView);

        mMainActivityPresenter.attachView(this);

        //API
        mMainActivityPresenter.getInformationApi();

    }

    @Override
    public void showError() {

    }

    @Override
    public void showClimateInformation(String nameCity, String temp) {
        mTextView.setText(nameCity + "---" + temp);
        climateInformation(nameCity, temp);
        Log.d("LOG: ", nameCity + "---" + temp);
    }
    
    private void climateInformation(String city,String climateInformation){

         SharedPreferences prefs =
             getSharedPreferences("MyInformation",Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("city", city);
        editor.putString("information", climateInformation);
        editor.commit();
        
    }

    
}
