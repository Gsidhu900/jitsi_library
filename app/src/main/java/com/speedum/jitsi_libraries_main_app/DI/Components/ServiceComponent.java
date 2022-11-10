package com.speedum.jitsi_libraries_main_app.DI.Components;



import com.speedum.jitsi_libraries_main_app.DI.Modules.Service_Module;
import com.speedum.jitsi_libraries_main_app.DI.PerActivity;

import dagger.Component;

/**
 * Created by Sandeep Virk on 24-10-2017.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = Service_Module.class)
public interface ServiceComponent {


//    void inject(MyFirebaseMessagingService myFirebaseMessagingService);


}
