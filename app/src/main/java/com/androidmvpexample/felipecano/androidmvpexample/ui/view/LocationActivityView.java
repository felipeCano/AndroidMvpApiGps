package com.androidmvpexample.felipecano.androidmvpexample.ui.view;

/**
 * Created by felipecano on 29/06/17.
 */

public interface LocationActivityView extends MvpView {
    void showCoordinates(double lat, double lon);
}
