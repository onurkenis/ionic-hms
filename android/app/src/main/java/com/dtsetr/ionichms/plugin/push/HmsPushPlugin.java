package com.dtsetr.ionichms.plugin.push;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;

import com.dtsetr.ionichms.plugin.Constants;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;

@NativePlugin()
public class HmsPushPlugin extends Plugin {

    private Activity activity;
    private String pushtoken;

    @PluginMethod()
    public void getToken(PluginCall call) {
        Log.i(Constants.PUSH_TAG, "get token: begin" );
        this.activity = getActivity();

        // get token
        new Thread() {
            @Override
            public void run() {
                try {
                    String appId = AGConnectServicesConfig.fromContext(activity).getString("client/app_id");
                    Log.i(Constants.PUSH_TAG, "appId: " + appId);
                    pushtoken = HmsInstanceId.getInstance(activity).getToken(appId, "HCM");
                    Log.i(Constants.PUSH_TAG, "thread token: " + pushtoken);

                    if(!TextUtils.isEmpty(pushtoken)) {
                        Log.i(Constants.PUSH_TAG, "get token:" + pushtoken);
                    }
                } catch (Exception e) {
                    Log.i(Constants.PUSH_TAG,"getToken failed, " + e);

                }
            }
        }.start();
    }
}
