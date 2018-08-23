package com.zeng.art.baselibrary.data;

import android.content.Context;

import com.google.gson.Gson;
import com.zeng.art.baselibrary.data.local.db.DbHelper;
import com.zeng.art.baselibrary.data.local.prefs.PreferencesHelper;
import com.zeng.art.baselibrary.data.remote.ApiHelper;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppDataManager implements DataManager {
    private final ApiHelper mApiHelper;

    private final Context mContext;

    private final DbHelper mDbHelper;

    private final Gson mGson;

    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public AppDataManager(Context context, DbHelper dbHelper, PreferencesHelper preferencesHelper, ApiHelper apiHelper, Gson gson) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
        mGson = gson;
    }
}
