package com.speedum.jitsi_libraries_main_app.UI.Activities.Splash_Screen.Splash_Screen_Presenter;


import com.speedum.jitsi_libraries_main_app.API.APIModels.Foot_Print.FootPrintBody;
import com.speedum.jitsi_libraries_main_app.API.APIModels.Session_Token.SessionTokenBody;
import com.speedum.jitsi_libraries_main_app.API.Comman_Data.CommonBody;

public interface ISplash_Screen_Presenter {

    void createFootPrint(FootPrintBody footPrintBody);

    void createFootPrintSuccess();

    void createFootPrintError(String msg);

    void createSession(SessionTokenBody sessionTokenBody);

    void createSessionSuccess();

    void createSessionError(String msg);

    String getLastMsgID(String query);

    /*void fetchAppUpgrade(CommonBody checkAppUpgradeBody, String app_session);


    void fetchAppUpgradeError(String msg);*/

    void getColorConfig(CommonBody body, String token);

    void getColorConfigSuccess();

    void getColorConfigError(String message);

    void getHomeScrenConfig(CommonBody body, String token);

    void homeScreenCongifSuccess();

    void homeScreenOrgInfoSuccess();

    void getOrgInfoFromServer(CommonBody body, String finalToken);
}
