package com.zeng.art.baselibrary.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import net.grandcentrix.thirtyinch.TiActivity;
import net.grandcentrix.thirtyinch.TiPresenter;
import net.grandcentrix.thirtyinch.TiView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;

public abstract class ArtActivity<P extends ArtPresenter<V>, V extends ArtView> extends TiActivity<P ,V> {


    private Unbinder unbinder;

    private boolean isSimple = false;
    public void setSimple(boolean simple) {
        isSimple = simple;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (!isSimple) {
            performDependencyInjection();
        }
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        setUnBinder(ButterKnife.bind(this));
        setUp();
    }

    private void setUnBinder(Unbinder bind) {
        unbinder = bind;
    }

    protected abstract void setUp();

    protected abstract int getLayoutId();

    private void performDependencyInjection() {
        AndroidInjection.inject(this);
    }

    @Override
    protected void onDestroy() {
        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroy();
    }
}
