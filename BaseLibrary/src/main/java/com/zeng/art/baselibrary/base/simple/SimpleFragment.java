package com.zeng.art.baselibrary.base.simple;

import android.support.annotation.NonNull;

import com.zeng.art.baselibrary.base.ArtFragment;
import com.zeng.art.baselibrary.data.DataManager;
import com.zeng.art.baselibrary.utils.rx.SchedulerProvider;

import javax.inject.Inject;

public abstract class SimpleFragment extends ArtFragment<SimplePresenter<SimplePresenter.SimpleFragmentView>, SimplePresenter.SimpleFragmentView> implements SimplePresenter.SimpleFragmentView {

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
