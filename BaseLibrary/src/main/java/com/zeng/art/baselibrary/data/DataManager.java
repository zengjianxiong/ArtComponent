package com.zeng.art.baselibrary.data;

import com.zeng.art.baselibrary.data.local.db.DbHelper;
import com.zeng.art.baselibrary.data.local.prefs.PreferencesHelper;
import com.zeng.art.baselibrary.data.remote.ApiHelper;

public interface DataManager extends ApiHelper, DbHelper, PreferencesHelper {
}
