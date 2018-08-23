package com.zeng.art.baselibrary.base.simple;

import android.support.annotation.NonNull;

import com.zeng.art.baselibrary.base.ArtFragment;

public abstract class SimpleFragment extends ArtFragment<SimplePresenter, SimpleView> implements SimpleView {
    @NonNull
    @Override
    public SimplePresenter providePresenter() {
        return new SimplePresenter();
    }
}
