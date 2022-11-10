package com.speedum.jitsi_libraries_main_app.UI.Activities.Splash_Screen.Splash_Screen_Presenter;

import android.app.Activity;

import com.speedum.jitsi_libraries_main_app.API.APIModels.Foot_Print.FootPrintBody;
import com.speedum.jitsi_libraries_main_app.API.APIModels.Session_Token.SessionTokenBody;
import com.speedum.jitsi_libraries_main_app.API.Comman_Data.CommonBody;
import com.speedum.jitsi_libraries_main_app.DB.DBHelper;
import com.speedum.jitsi_libraries_main_app.UI.Activities.Splash_Screen.Splash_Screen_Model.Splash_Screen_Model;
import com.speedum.jitsi_libraries_main_app.UI.Activities.Splash_Screen.Splash_Screen_View.Splash_Screen_View;

import java.lang.ref.WeakReference;

public class Splash_Screen_Presenter implements ISplash_Screen_Presenter {

    private WeakReference<Splash_Screen_View> mView;
    private DBHelper mDbHelper;
    private Activity mContext;
    private Splash_Screen_Model mSplash_screen_model;

    public Splash_Screen_Presenter(Splash_Screen_View splash_screen_view, Activity context
            , DBHelper DbHelper) {
        this.mView = new WeakReference<Splash_Screen_View>(splash_screen_view);
        /*Initializing Model for the Presenter*/
        this.mSplash_screen_model = new Splash_Screen_Model();
        this.mContext = context;
        this.mDbHelper = DbHelper;
    }

    @Override
    public void createFootPrint(FootPrintBody footPrintBody) {
        mSplash_screen_model.createFootPrint(this, footPrintBody, mContext);
    }

    @Override
    public void createFootPrintSuccess() {
        if (mView.get() != null) {
            mView.get().createFootPrintSuccess();
        }
    }

    @Override
    public void createFootPrintError(String msg) {
        if (mView.get() != null) {
            mView.get().createFootPrintError(msg);
        }
    }

    @Override
    public void createSession(SessionTokenBody sessionTokenBody) {
        mSplash_screen_model.createSession(this, sessionTokenBody, mContext);
    }

   @Override
    public void getColorConfig(CommonBody body, String token) {
        mSplash_screen_model.getColorConfig(this, body, mContext,mDbHelper,token);
    }

    @Override
    public void getColorConfigSuccess() {
        if (mView.get() != null) {
            mView.get().getColorConfigSuccess();
        }
    }

    @Override
    public void getColorConfigError(String message) {
        if (mView.get() != null) {
            mView.get().getColorConfigError(message);
        }
    }

    @Override
    public void getHomeScrenConfig(CommonBody body, String token) {
        mSplash_screen_model.getHomeScrenConfig(this, body, mContext,mDbHelper,token);
    }

    @Override
    public void homeScreenCongifSuccess() {
        if (mView.get() != null) {
            mView.get().homeScreenCongifSuccess();
        }
    }

    @Override
    public void homeScreenOrgInfoSuccess() {
        if (mView.get() != null) {
            mView.get().homeScreenOrgInfoSuccess();
        }
    }

    @Override
    public void getOrgInfoFromServer(CommonBody body, String finalToken) {
        mSplash_screen_model.getOrgInfoFromServer(this,body,mContext,mDbHelper,finalToken);
    }

    @Override
    public void createSessionSuccess() {
        if (mView.get() != null) {
            mView.get().createSessionSuccess();
        }
    }

    @Override
    public void createSessionError(String msg) {
        if (mView.get() != null) {
            mView.get().createSessionError(msg);
        }
    }

    @Override
    public String getLastMsgID(String query) {
        return mSplash_screen_model.getLastMsgID(query, mDbHelper);
    }

  /*  @Override
    public void fetchAppUpgrade(CommonBody checkAppUpgradeBody, String app_session) {
        mSplash_screen_model.fetchAppUpgrade(this, checkAppUpgradeBody, mContext, mDbHelper, app_session);
    }


    @Override
    public void fetchAppUpgradeError(String msg) {
        if (mView.get() != null) {
            mView.get().fetchAppUpgradeError(msg);
        }
    }*/
}
