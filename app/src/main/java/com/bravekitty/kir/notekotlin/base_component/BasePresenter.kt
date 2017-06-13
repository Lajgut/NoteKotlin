package com.bravekitty.kir.notekotlin.base_component

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView

class BasePresenter<View : MvpView> : MvpPresenter<View>() {

    /*private CompositeSubscription compositeSubscription = new CompositeSubscription();

    protected void unsubscribeOnDestroy(@NonNull Subscription subscription) {
        compositeSubscription.add(subscription);
    }*/


    override fun onDestroy() {
        super.onDestroy()
        //compositeSubscription.clear();
    }
}
