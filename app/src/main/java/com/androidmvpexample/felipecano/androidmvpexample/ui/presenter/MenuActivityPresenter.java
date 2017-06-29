package com.androidmvpexample.felipecano.androidmvpexample.ui.presenter;

import com.androidmvpexample.felipecano.androidmvpexample.ui.view.MenuActivityView;

import javax.inject.Inject;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by felipecano on 29/06/17.
 */

public class MenuActivityPresenter extends BasePresenter<MenuActivityView> {

    private CompositeSubscription mCompositeSubscription;


    @Inject
    public MenuActivityPresenter() {

    }

    @Override
    public void attachView(MenuActivityView mvpView) {
        super.attachView(mvpView);
        if (mCompositeSubscription == null || mCompositeSubscription.isUnsubscribed()) {
            mCompositeSubscription = new CompositeSubscription();
        }
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mCompositeSubscription != null) {
            mCompositeSubscription.clear();
        }
    }
}
