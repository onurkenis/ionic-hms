import { Component } from "@angular/core";
import { Plugins } from "@capacitor/core";

const { HmsAnalyticsPlugin } = Plugins;

declare var HMSPush: any;

@Component({
  selector: "app-home",
  templateUrl: "home.page.html",
  styleUrls: ["home.page.scss"],
})
export class HomePage {
  constructor() {}

  getPushToken() {
    HMSPush.getToken(
      (message) => {
        // Success callback
        alert(`Token: ${message}`);
      },
      (message) => console.log("Error", message) // Error callback
    );
  }

  logEvent(name: string, bundle: object) {
    const param = { eventName: name, bundle: JSON.stringify(bundle) };
    HmsAnalyticsPlugin.logEvent(param);
  }
}
