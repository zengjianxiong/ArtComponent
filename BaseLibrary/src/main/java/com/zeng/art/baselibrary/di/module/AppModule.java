package com.zeng.art.baselibrary.di.module;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zeng.art.baselibrary.BuildConfig;
import com.zeng.art.baselibrary.data.AppDataManager;
import com.zeng.art.baselibrary.data.DataManager;
import com.zeng.art.baselibrary.data.local.db.AppDbHelper;
import com.zeng.art.baselibrary.data.local.db.DbHelper;
import com.zeng.art.baselibrary.data.local.prefs.AppPreferencesHelper;
import com.zeng.art.baselibrary.data.local.prefs.PreferencesHelper;
import com.zeng.art.baselibrary.data.remote.ApiHelper;
import com.zeng.art.baselibrary.data.remote.AppApiHelper;
import com.zeng.art.baselibrary.di.ApiInfo;
import com.zeng.art.baselibrary.di.DatabaseInfo;
import com.zeng.art.baselibrary.di.PreferenceInfo;
import com.zeng.art.baselibrary.utils.AppConstants;
import com.zeng.art.baselibrary.utils.rx.AppSchedulerProvider;
import com.zeng.art.baselibrary.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return AppConstants.API_KEY;
    }

//    @Provides
//    @Singleton
//    AppDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
//        return Room.databaseBuilder(context, AppDatabase.class, dbName).fallbackToDestructiveMigration()
//                .build();
//    }



    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }
}
