package com.zeng.art.baselibrary.base.simple;

import android.support.annotation.NonNull;

import com.zeng.art.baselibrary.base.ArtActivity;

public abstract class SimpleActivity extends ArtActivity<SimplePresenter, SimpleView> implements SimpleView {

    @NonNull
    @Override
    public SimplePresenter providePresenter() {
        return new SimplePresenter();
    }
}
