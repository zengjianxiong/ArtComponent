package com.zeng.art.baselibrary.di.component;

import android.app.Application;

import com.zeng.art.baselibrary.ArtApp;
import com.zeng.art.baselibrary.di.builder.ActivityBuilder;
import com.zeng.art.baselibrary.di.builder.ServiceBuilder;
import com.zeng.art.baselibrary.di.module.AppModule;
import com.zeng.art.baselibrary.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, NetworkModule.class, ActivityBuilder.class, ServiceBuilder.class})
public interface AppComponent {

    void inject(ArtApp app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}