package com.speedum.jitsi_libraries_main_app;

import android.content.Context;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.speedum.jitsi_libraries_main_app.DB.DBHelper;
import com.speedum.jitsi_libraries_main_app.DI.Components.ApplicationComponent;
import com.speedum.jitsi_libraries_main_app.DI.Components.DaggerApplicationComponent;
import com.speedum.jitsi_libraries_main_app.DI.Modules.ApplicationModule;

import javax.inject.Inject;

public class My_Application extends MultiDexApplication {
    public static final String TAG = My_Application.class
            .getSimpleName();
    private final static String LOG_TAG = My_Application.class.getSimpleName();
    private static My_Application mInstance;

    protected ApplicationComponent applicationComponent;

    @Inject
    DBHelper mDbHelper;

    public static My_Application get(Context context) {
        return (My_Application) context.getApplicationContext();
    }

    @Override
    public void onCreate() {

        super.onCreate();
        /////////////
        mInstance = this;
//        Log.e("My_Application"," running main app ");
        daggerInit();
    }

    public static synchronized My_Application getInstance() {
        return mInstance;
    }


    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    private void daggerInit() {
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }




}
