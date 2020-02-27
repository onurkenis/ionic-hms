package com.dtsetr.ionichms;

import android.app.Application;
import android.util.Log;

import com.huawei.hms.analytics.HiAnalytics;
import com.huawei.hms.analytics.HiAnalyticsInstance;
import com.huawei.hms.analytics.HiAnalyticsTools;

public class MainApplication extends Application {
    HiAnalyticsInstance instance;

    @Override
    public void onCreate() {
        super.onCreate();

        HiAnalyticsTools.enableLog();

        instance = HiAnalytics.getInstance(this);

        Log.i("MainApplication",instance.toString());

        // TODO: can be configurable
        instance.setAnalyticsEnabled(true);
        // TODO: can be configurable
        instance.setAutoCollectionEnabled(true);

    }
}
