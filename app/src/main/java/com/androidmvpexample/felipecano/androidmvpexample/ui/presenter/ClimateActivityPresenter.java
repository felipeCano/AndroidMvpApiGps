package com.androidmvpexample.felipecano.androidmvpexample.ui.presenter;

import android.content.Context;
import android.util.Log;

import com.androidmvpexample.felipecano.androidmvpexample.data.DataManager;
import com.androidmvpexample.felipecano.androidmvpexample.injection.qualifier.ApplicationContext;
import com.androidmvpexample.felipecano.androidmvpexample.ui.view.ClimateActivityView;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by felipecano on 28/06/17.
 */

public class ClimateActivityPresenter extends BasePresenter<ClimateActivityView> {

    private CompositeSubscription mCompositeSubscription;

    private final DataManager mDataManager;


    @Inject
    @ApplicationContext
    Context mContext;

    @Inject
    public ClimateActivityPresenter(DataManager dataManager) {
        this.mDataManager = dataManager;
    }

    @Override
    public void attachView(ClimateActivityView mvpView) {
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

    public void getInformationApi() {
        checkViewAttached();

        mCompositeSubscription.add(
                mDataManager.getClimate()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(climate -> {

                            getMvpView().showClimateInformation(
                                    climate.getCurrentObservation().getTempC().toString(),
                                    climate.getCurrentObservation().getObservationLocation().getCity());

                        }, throwable -> {
                            Log.d("ERROR ", throwable.getMessage());
                        })

        );

    }


}