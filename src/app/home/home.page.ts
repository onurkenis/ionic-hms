import { Component } from '@angular/core';
import { Plugins } from '@capacitor/core'

const { HmsPushPlugin, HmsAnalyticsPlugin } = Plugins;

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  constructor() { }

  getPushToken() {
    HmsPushPlugin.getToken();
  }

  logEvent(name: string, bundle: object) {
    const param = {eventName: name, bundle: JSON.stringify(bundle)}
    HmsAnalyticsPlugin.logEvent(param);
  }

}
