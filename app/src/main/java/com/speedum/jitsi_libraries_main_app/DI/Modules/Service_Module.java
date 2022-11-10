package com.speedum.jitsi_libraries_main_app.DI.Modules;

import android.app.Service;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Sandeep Virk on 24-10-2017.
 */
@Module
public class Service_Module {

    private Service mService;

    public Service_Module(Service service) {
        mService = service;
    }

    @Provides
    Service provideMyService() {
        return mService;
    }
}
