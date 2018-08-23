package com.zeng.art.baselibrary;

import android.app.Activity;
import android.app.Application;
import android.app.Service;

import com.alibaba.android.arouter.launcher.ARouter;



import net.grandcentrix.thirtyinch.TiLog;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasServiceInjector;

/**
 * @author chaoti
 */
public abstract class ArtApp extends Application implements HasActivityInjector, HasServiceInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;
    @Inject
    DispatchingAndroidInjector<Service> serviceDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        initARouter();
        initLog();
        initDI();
    }

    private void initLog() {
        if (BuildConfig.DEBUG) {
            TiLog.setLogger(TiLog.LOGCAT);
        }
    }

    private void initDI() {
        injectApp();
    }

    protected abstract void injectApp();

    /**
     * 初始化ARouter 路由
     */
    private void initARouter() {
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        if (BuildConfig.DEBUG) {
            // 打印日志
            ARouter.openLog();
            // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug();
        }
        // 尽可能早，推荐在Application中初始化
        ARouter.init(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    @Override
    public AndroidInjector<Service> serviceInjector() {
        return serviceDispatchingAndroidInjector;
    }
}
