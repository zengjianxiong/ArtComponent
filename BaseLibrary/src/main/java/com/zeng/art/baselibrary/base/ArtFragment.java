package com.zeng.art.baselibrary.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.grandcentrix.thirtyinch.TiFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;

public abstract class ArtFragment<P extends ArtPresenter<V>, V extends ArtView> extends TiFragment<P,V> {
    private Unbinder mUnBinder;
    public View mRootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        performDependencyInjection();
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRootView = inflater.inflate(getLayoutId(), container, false);
        super.onCreateView(inflater, container, savedInstanceState);
        return mRootView;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        setUnBinder(ButterKnife.bind(this, view));
        setUp();
        super.onViewCreated(view, savedInstanceState);

    }

    protected abstract void setUp();

    private void setUnBinder(Unbinder bind) {
        mUnBinder = bind;
    }

    protected abstract int getLayoutId();

    private void performDependencyInjection() {
        AndroidSupportInjection.inject(this);
    }

    @Override
    public void onDestroy() {
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }
}
