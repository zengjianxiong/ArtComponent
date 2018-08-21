package com.zeng.art.di.component;

import android.app.Application;

import com.zeng.art.baselibrary.ArtApp;

import com.zeng.art.di.builder.ActivityBuilder;
import com.zeng.art.di.builder.ServiceBuilder;
import com.zeng.art.di.module.AppModule;
import com.zeng.art.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        NetworkModule.class,
        ActivityBuilder.class,
        ServiceBuilder.class})
public interface AppComponent {

    void inject(ArtApp app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}