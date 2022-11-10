package com.speedum.jitsi_libraries_main_app.DI.Components;


import com.speedum.jitsi_libraries_main_app.DI.Modules.ActivityModule;
import com.speedum.jitsi_libraries_main_app.DI.PerActivity;
import com.speedum.jitsi_libraries_main_app.UI.Activities.Base_Activity;
import com.speedum.jitsi_libraries_main_app.UI.Activities.Splash_Base_Activity;

import dagger.Component;

/**
 * Created by nitin sood on 08/12/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(Base_Activity baseActivity);


    void inject(Splash_Base_Activity splash_base_activity);



}
