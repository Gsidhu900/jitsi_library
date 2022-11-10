package com.speedum.jitsi_libraries_main_app.UI.Activities.Splash_Screen.Splash_Screen_Model;

import android.app.Activity;
import android.content.Context;

import com.speedum.jitsi_libraries_main_app.API.APIModels.Foot_Print.FootPrintBody;
import com.speedum.jitsi_libraries_main_app.API.APIModels.Session_Token.SessionTokenBody;
import com.speedum.jitsi_libraries_main_app.API.Comman_Data.CommonBody;
import com.speedum.jitsi_libraries_main_app.DB.DBHelper;
import com.speedum.jitsi_libraries_main_app.UI.Activities.Splash_Screen.Splash_Screen_Presenter.ISplash_Screen_Presenter;
import com.speedum.jitsi_libraries_main_app.UI.Activities.Splash_Screen.Splash_Screen_Presenter.Splash_Screen_Presenter;

public interface ISplash_Screen_Model {

    void createFootPrint(ISplash_Screen_Presenter iSplash_screen_presenter, FootPrintBody footPrintBody, Context context);

    void createSession(ISplash_Screen_Presenter iSplash_screen_presenter, SessionTokenBody sessionTokenBody, Context context);

    String getLastMsgID(String query, DBHelper dbHelper);


    void getColorConfig(Splash_Screen_Presenter splash_screen_presenter, CommonBody body, Activity mContext, DBHelper mDbHelper, String session_ID);

    void getHomeScrenConfig(Splash_Screen_Presenter splash_screen_presenter, CommonBody body, Activity mContext, DBHelper mDbHelper, String token);

    void getOrgInfoFromServer(Splash_Screen_Presenter splash_screen_presenter, CommonBody body, Activity mContext, DBHelper mDbHelper, String token);

}
