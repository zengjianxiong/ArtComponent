package com.zeng.art.baselibrary;

import android.app.Activity;
import android.app.Application;

import com.zeng.art.baselibrary.di.component.DaggerAppComponent;

import net.grandcentrix.thirtyinch.TiLog;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * @author chaoti
 *
 */
public class ArtApp extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);
        TiLog.setLogger(TiLog.LOGCAT);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
