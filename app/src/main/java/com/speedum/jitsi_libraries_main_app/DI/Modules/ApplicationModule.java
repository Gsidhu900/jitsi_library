package com.speedum.jitsi_libraries_main_app.DI.Modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.speedum.jitsi_libraries_main_app.DI.ApplicationContext;
import com.speedum.jitsi_libraries_main_app.DI.DatabaseInfo;

import dagger.Module;
import dagger.Provides;


/**
 * Created by janisharali on 25/12/16.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application app) {
        mApplication = app;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return "vDent_DB.db";
    }

    @Provides
    @DatabaseInfo
    Integer provideDatabaseVersion() {
        return 2;
    }

    @Provides
    SharedPreferences provideSharedPrefs() {
        return mApplication.getSharedPreferences("demo-prefs", Context.MODE_PRIVATE);
    }
}
