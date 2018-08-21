package com.zeng.art.baselibrary.base;

import android.os.Bundle;

import net.grandcentrix.thirtyinch.TiActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;

public abstract class ArtActivity<P extends ArtPresenter, V extends ArtView> extends TiActivity {


    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        performDependencyInjection();
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
