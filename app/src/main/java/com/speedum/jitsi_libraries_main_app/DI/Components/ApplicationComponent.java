package com.speedum.jitsi_libraries_main_app.DI.Components;

import android.app.Application;
import android.content.Context;

import com.speedum.jitsi_libraries_main_app.API.API_Body;
import com.speedum.jitsi_libraries_main_app.API.Process_ID;
import com.speedum.jitsi_libraries_main_app.DB.DBHelper;
import com.speedum.jitsi_libraries_main_app.DB.DB_Queries;
import com.speedum.jitsi_libraries_main_app.DI.ApplicationContext;
import com.speedum.jitsi_libraries_main_app.DI.Modules.ApplicationModule;
import com.speedum.jitsi_libraries_main_app.My_Application;

import javax.inject.Singleton;

import dagger.Component;


/**
 * Created by janisharali on 08/12/16.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

//    void inject(My_TestApplication Application);
    void inject(My_Application Application);


    @ApplicationContext
    Context getContext();

    Application getApplication();

    DBHelper getDbHelper();
    DB_Queries getDB_Queries();

    Process_ID getProcess_ID();

    API_Body getApiBody();

}
