package com.zeng.art.baselibrary.base.simple;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.zeng.art.baselibrary.base.ArtActivity;
import com.zeng.art.baselibrary.data.DataManager;
import com.zeng.art.baselibrary.utils.rx.SchedulerProvider;

import javax.inject.Inject;

public abstract class SimpleActivity extends ArtActivity<SimplePresenter<SimplePresenter.SimpleActivityView>, SimplePresenter.SimpleActivityView> implements SimplePresenter.SimpleActivityView {


    @Inject
    DataManager dataManager;
    @Inject
    SchedulerProvider schedulerProvider;

    @NonNull
    @Override
    public SimplePresenter providePresenter() {
        return new SimplePresenter(dataManager, schedulerProvider);
    }
}
