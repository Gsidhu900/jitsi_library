package com.speedum.jitsi_libraries_main_app.UI.Activities.Splash_Screen.Splash_Screen_View;


public interface ISplash_Screen_View {

    void createFootPrintSuccess();

    void createFootPrintError(String msg);

    void createSessionSuccess();

    void createSessionError(String msg);


    void fetchAppUpgradeError(String msg);


    void getColorConfigSuccess();

    void getColorConfigError(String message);

    void homeScreenCongifSuccess();
    void homeScreenOrgInfoSuccess();
}
