package com.zeng.art.baselibrary.di.component;


import com.zeng.art.baselibrary.base.ArtActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;


@Subcomponent(modules = {
        AndroidInjectionModule.class})
public interface ArtActivityComponent extends AndroidInjector<ArtActivity> {


    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ArtActivity> {

    }

}
