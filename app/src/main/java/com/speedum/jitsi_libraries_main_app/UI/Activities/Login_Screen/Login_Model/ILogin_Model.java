package com.speedum.jitsi_libraries_main_app.UI.Activities.Login_Screen.Login_Model;

import android.content.Context;

import com.speedum.jitsi_libraries_main_app.API.Comman_Data.CommonBody;
import com.speedum.jitsi_libraries_main_app.DB.DBHelper;
import com.speedum.jitsi_libraries_main_app.UI.Activities.Login_Screen.Login_Presenter.ILogin_Presenter;


public interface ILogin_Model {

    void loginUserAuthenticate(ILogin_Presenter iLogin_presenter, CommonBody loginUserBody, String session_ID, Context context, DBHelper dbHelper);

    String getLastMsgID(String query, DBHelper dbHelper);
}
