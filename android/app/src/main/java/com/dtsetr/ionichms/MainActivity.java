package com.dtsetr.ionichms;

import android.os.Bundle;

import com.dtsetr.ionichms.plugin.analytics.HmsAnalyticsPlugin;
import com.dtsetr.ionichms.plugin.push.HmsPushPlugin;
import com.getcapacitor.BridgeActivity;
import com.getcapacitor.Plugin;

import java.util.ArrayList;

public class MainActivity extends BridgeActivity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Initializes the Bridge
    this.init(savedInstanceState, new ArrayList<Class<? extends Plugin>>() {{
      // Additional plugins you've installed go here
      // Ex: add(TotallyAwesomePlugin.class);
      add(HmsPushPlugin.class);
      add(HmsAnalyticsPlugin.class);
    }});
  }
}
