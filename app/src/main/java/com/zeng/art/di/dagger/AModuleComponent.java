package com.zeng.art.di.dagger;

import android.app.Application;

import com.zeng.art.baselibrary.ArtApp;
import com.zeng.art.baselibrary.di.module.AppModule;
import com.zeng.art.baselibrary.di.module.NetworkModule;


import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;


@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,
        AModuleAllActivityModule.class
})
public interface AModuleComponent {

    void inject(ArtApp application);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AModuleComponent build();
    }

}
