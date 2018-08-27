package com.zeng.art;

import android.content.Context;
import android.support.annotation.Keep;

import com.taobao.sophix.PatchStatus;
import com.taobao.sophix.SophixApplication;
import com.taobao.sophix.SophixEntry;
import com.taobao.sophix.SophixManager;
import com.taobao.sophix.listener.PatchLoadStatusListener;
import com.zeng.art.commonres.utils.util.AppUtils;
import com.zeng.art.commonres.utils.util.Utils;

import net.grandcentrix.thirtyinch.TiLog;

public class SophixStubApplication extends SophixApplication {
    private final String TAG = "SophixStubApplication";

    // 此处SophixEntry应指定真正的Application，并且保证RealApplicationStub类名不被混淆。
    @Keep
    @SophixEntry(App.class)
    static class RealApplicationStub {
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//         如果需要使用MultiDex，需要在此处调用。
//         MultiDex.install(this);
        initSophix();
    }

    private void initSophix() {
        String appVersion = "0.0.0";
        try {
            appVersion = this.getPackageManager()
                    .getPackageInfo(this.getPackageName(), 0)
                    .versionName;
        } catch (Exception e) {
        }
        final SophixManager instance = SophixManager.getInstance();
        instance.setContext(this)
                .setAppVersion(appVersion)
                .setSecretMetaData("25045100", "1e8284304fdfa9e696fc13cf19d26b36", "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCgrCyD1Wytu/s3b/498tzFUhrz5TAcxEwsjjffT2NGhiO6HSDpadm9XGxVjwJUsp9H5CBUX+cf+dkDHj4KtdMJDg2623CDM8Uwx4ktlG4iWBwnegEPHP7wYxKvYKkG699P5UdX0zJX1JTh6a8/TcWTLA026qtifciCkTRACoEiipzywCnut7LV3wmRav65R9c64IzHIYmdHNghQEtlcV5LVh/ewD9lxMLUicNyJrt13hse82c+ZR2EsXLC8dPjESvua2nwjU7U7tq17QbXB9+Tw9PPTDxYvzngTXeI6M6l8svkD2U2uD+YYQNaTgXo1qgTYvOZM3kPuVwK4XIdmhM9AgMBAAECggEBAI372FKf9awJpFQ3GZsw1LtidQL2k2+4YAA3pVQnWXlm7Id5Wi4qJgpadDmfaNXkCzGCfLdTEHGHXqiMvxLD3rvvuV5YsLKguy8CBU1MD482AZs5C1qJqxhO1KI6buP46Jw35rXLon9PEkoZMY5lcaU+lmbjNZSRxvDq1BuLrNYR8w7Cl8la/ZsjLCVI+GgBZwiqRewLoHfO0FwhCzmh6aiOD7nMdUi01YABeAPRAOGVei42dOPaTgAptdkMcwL+dleye3GLmXIAa99zz3YitDLSaTaYUaSWz/QNNaZdQc9/lmuYaMi+v7mmG99tueAPshY80DSFmNYC5Bbqg/1W+hkCgYEA45m45ElLUd2L2Bzi3vUghmiX8UWNCRhDYGHEWmZBbeith0jJUeYwqBRWxc6AXjtrJyueMTj9jb5VGq2FdqXFd5rgyyEPjNyQKRDzQ476ByBFVK7V59j/1+tGqNR84cwXgmLnm/8etBCcOBUNTOlW4i+YGUPP5kxc9EWCPO2qPgMCgYEAtLiP//SJCTwBgiIj7xE+ysCCD36jXGg+geAQkvJPZ/rw10jdMk8mED6LzecVCanZWxHbYaGCHGJP1Z5CHUDBN8TiZ0Xs6Embjcc+Wo4JSoQRVyLKFfS3gNDxTKIt4WPfD/2Vo4h1ds5V/KOVthlnfKmiYxWYar43hYMOIDD1Rb8CgYAPB8/WA6EdvuvFUeMJplaHidC+9kDiIOASNWKqNaaMg5kyHfRtnC4Ka41vcru3fWUOKStBROo5uiAUqvDtbPUleOzvfTdxrf83Nw9Zns+UOOVbOlCWBxaeQ8Ne0umMX9YNnkp9WtPEQHSQn5NJSP+b4FjDEl9gbhqVZyG6tFdR0QKBgELbSIKDP7MH3PL8mFiYA6fUYglDa0IDWqSHdPo35EJuZmzuis5S050M1oGc7H5/tGZpi8RpkI3ZnPlFK+ZQj2qHTs6v4r3ohUCFJj8v7qX/h765oxNOThi8s5gLI3gPj3UF9jbig7opCUyGZBtS+KL4ypdnZNSQfE/LNQ2ZrxNXAoGASseGvW/Oxqmvt7OCmFrwirTLonScqBdAlGifFOOJaZ5ADviVaEfyBFEA+4lAlK01mq1ekF1qY5Q7c1gQzVW7yZmig6az6RMpZFpkyOGSheGIjaa9tKS+ek6HY+QDk/WR84hofb3D25cpcmzhxB+k1amhX+0Zgr62Zsb39GArQY4=")
                .setEnableDebug(true)
                .setAesKey("1qaz2wsx3edc4rfv")
                .setEnableFullLog()
                .setPatchLoadStatusStub(new PatchLoadStatusListener() {
                    @Override
                    public void onLoad(final int mode, final int code, final String info, final int handlePatchVersion) {
                        if (code == PatchStatus.CODE_LOAD_SUCCESS) {
                            TiLog.i(TAG, "sophix load patch success!");
                        } else if (code == PatchStatus.CODE_LOAD_RELAUNCH) {
                            // 如果需要在后台重启，建议此处用SharePreference保存状态。
                            TiLog.i(TAG, "sophix preload patch success. restart app to make effect.");
                        }
                    }
                }).initialize();
    }
}