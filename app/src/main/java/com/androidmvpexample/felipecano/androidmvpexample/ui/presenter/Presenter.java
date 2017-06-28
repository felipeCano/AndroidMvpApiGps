package com.androidmvpexample.felipecano.androidmvpexample.ui.presenter;

import com.androidmvpexample.felipecano.androidmvpexample.ui.view.MvpView;

/**
 * Created by felipecano on 28/06/17.
 */

public interface Presenter<V extends MvpView> {
    void attachView(V MvpView);

    void detachView();


}
