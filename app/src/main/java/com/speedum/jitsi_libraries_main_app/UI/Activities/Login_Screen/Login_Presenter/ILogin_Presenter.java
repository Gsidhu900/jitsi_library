package com.speedum.jitsi_libraries_main_app.UI.Activities.Login_Screen.Login_Presenter;


import com.speedum.jitsi_libraries_main_app.API.Comman_Data.CommonBody;

public interface ILogin_Presenter {

    void loginUserAuthenticate(CommonBody loginUserBody, String session_ID);

    void loginUserSuccess();

    void loginUserError(String msg);

    String getLastMsgID(String query);
}
