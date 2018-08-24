package com.zeng.art.baselibrary.base;

import com.zeng.art.baselibrary.data.DataManager;
import com.zeng.art.baselibrary.utils.rx.SchedulerProvider;

import net.grandcentrix.thirtyinch.TiPresenter;
import net.grandcentrix.thirtyinch.rx2.RxTiPresenterDisposableHandler;

import javax.inject.Inject;


/**
 * @author chaoti
 */
public abstract class ArtPresenter<V extends ArtView> extends TiPresenter<V> {

    private final DataManager mDataManager;
    private final SchedulerProvider mSchedulerProvider;
    private final RxTiPresenterDisposableHandler mDisposableHandler;

    public ArtPresenter(DataManager dataManager, SchedulerProvider schedulerProvider) {
        this.mDataManager = dataManager;
        this.mSchedulerProvider = schedulerProvider;
        mDisposableHandler = new RxTiPresenterDisposableHandler(this);
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    public RxTiPresenterDisposableHandler getDisposableHandler() {
        return mDisposableHandler;
    }
}
