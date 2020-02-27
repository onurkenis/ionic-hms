package com.dtsetr.ionichms.plugin.analytics;

import android.os.Bundle;
import android.util.Log;

import com.dtsetr.ionichms.plugin.Constants;
import com.dtsetr.ionichms.utils.JsonUtils;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.huawei.hms.analytics.HiAnalytics;
import com.huawei.hms.analytics.HiAnalyticsInstance;
import com.huawei.hms.analytics.HiAnalyticsTools;

@NativePlugin()
public class HmsAnalyticsPlugin extends Plugin {
    private HiAnalyticsInstance instance;

    public void createHiAnalyticsInstance() {
        if(instance != null) return;

        HiAnalyticsTools.enableLog();
        instance = HiAnalytics.getInstance(getContext());

        Log.i(Constants.ANALYTICS_TAG, instance.toString());
        Log.i(Constants.ANALYTICS_TAG, "Instance created...");
    }

    @PluginMethod()
    public void logEvent(PluginCall call) {
        createHiAnalyticsInstance();

        String eventName = call.getString("eventName");
        String bundleString = call.getString("bundle");

        Bundle bundle = JsonUtils.jsonStringToBundle(bundleString);

        Log.i(Constants.ANALYTICS_TAG, "eventName: " + eventName);
        Log.i(Constants.ANALYTICS_TAG, "bundle: " + bundleString);

        instance.onEvent(eventName, bundle);
    }
}
