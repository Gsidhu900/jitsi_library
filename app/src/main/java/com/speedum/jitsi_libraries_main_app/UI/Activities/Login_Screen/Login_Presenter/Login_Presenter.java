package com.speedum.jitsi_libraries_main_app.UI.Activities.Login_Screen.Login_Presenter;

import android.app.Activity;


import com.speedum.jitsi_libraries_main_app.API.Comman_Data.CommonBody;
import com.speedum.jitsi_libraries_main_app.DB.DBHelper;
import com.speedum.jitsi_libraries_main_app.UI.Activities.Login_Screen.Login_Model.Login_Model;
import com.speedum.jitsi_libraries_main_app.UI.Activities.Login_Screen.Login_View.Login_View;

import java.lang.ref.WeakReference;

public class Login_Presenter implements ILogin_Presenter {

    private WeakReference<Login_View> mView;
    private DBHelper mDbHelper;
    private Activity mContext;
    private Login_Model mLogin_model;

    public Login_Presenter(Login_View login_view, Activity context
            , DBHelper DbHelper) {
        this.mView = new WeakReference<Login_View>(login_view);
        /*Initializing Model for the Presenter*/
        this.mLogin_model = new Login_Model();
        this.mContext = context;
        this.mDbHelper = DbHelper;
    }

    @Override
    public void loginUserAuthenticate(CommonBody loginUserBody, String session_ID) {
        mLogin_model.loginUserAuthenticate(this, loginUserBody, session_ID, mContext, mDbHelper);
    }

    @Override
    public void loginUserSuccess() {
        if (mView.get() != null) {
            mView.get().loginUserSuccess();
        }
    }

    @Override
    public void loginUserError(String msg) {
        if (mView.get() != null) {
            mView.get().loginUserError(msg);
        }
    }

    @Override
    public String getLastMsgID(String query) {
        return mLogin_model.getLastMsgID(query, mDbHelper);
    }
}
