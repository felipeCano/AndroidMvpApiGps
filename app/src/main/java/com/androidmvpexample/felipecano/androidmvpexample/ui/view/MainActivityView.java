package com.androidmvpexample.felipecano.androidmvpexample.ui.view;

/**
 * Created by felipecano on 28/06/17.
 */

public interface MainActivityView extends MvpView {
    void showClimateInformation(String nameCity, String temp);
    void showCoordinates(double lat, double lon);
}
