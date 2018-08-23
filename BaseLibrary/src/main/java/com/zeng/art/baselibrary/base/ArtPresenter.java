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

    private  DataManager mDataManager;
    private  SchedulerProvider mSchedulerProvider;

    private RxTiPresenterDisposableHandler presenterDisposableHandler;

    public ArtPresenter(){

    }
    public ArtPresenter(DataManager dataManager, SchedulerProvider schedulerProvider) {
        this.mDataManager = dataManager;
        this.mSchedulerProvider = schedulerProvider;
        presenterDisposableHandler = new RxTiPresenterDisposableHandler(this);
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }
}
