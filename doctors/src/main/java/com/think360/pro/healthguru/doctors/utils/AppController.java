package com.think360.pro.healthguru.doctors.utils;

import android.app.Application;
import com.think360.pro.healthguru.doctors.interfaces.AppComponent;
import com.think360.pro.healthguru.doctors.interfaces.DaggerAppComponent;


public class AppController extends Application {


    private AppComponent component;

    private RxBus bus;
    @Override
    public void onCreate() {
        super.onCreate();
        bus = new RxBus();
        component = DaggerAppComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .httpModule(new HttpModule())
                .build();
    }

    public RxBus bus() {
        return bus;
    }


    public AppComponent getComponent() {
        return component;
    }
}

