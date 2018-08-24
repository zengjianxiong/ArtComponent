package com.zeng.art.baselibrary.base.simple;

import com.zeng.art.baselibrary.base.ArtPresenter;
import com.zeng.art.baselibrary.data.DataManager;
import com.zeng.art.baselibrary.utils.rx.SchedulerProvider;

import javax.inject.Inject;

public class SimplePresenter<V extends SimpleView> extends ArtPresenter<V> {


    public interface SimpleActivityView extends SimpleView {
    }

    public interface SimpleFragmentView extends SimpleView {
    }

    public interface SimpleDialogFragmentView extends SimpleView {
    }

    public SimplePresenter(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
    public void fun(){

    }
}
