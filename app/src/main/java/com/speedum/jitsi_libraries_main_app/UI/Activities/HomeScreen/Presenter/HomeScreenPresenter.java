package com.speedum.jitsi_libraries_main_app.UI.Activities.HomeScreen.Presenter;

import android.app.Activity;

import com.speedum.jitsi_libraries_main_app.API.APIModels.MeetingList.MeetingListBody.MeetingListBody;
import com.speedum.jitsi_libraries_main_app.API.APIModels.MeetingList.MeetingListResponse.MeetingListReturnDatum;
import com.speedum.jitsi_libraries_main_app.API.APIModels.Save_Push_Token.SavePushTokenBody;
import com.speedum.jitsi_libraries_main_app.DB.DBHelper;
import com.speedum.jitsi_libraries_main_app.UI.Activities.HomeScreen.Model.HomeScreenModel;
import com.speedum.jitsi_libraries_main_app.UI.Activities.HomeScreen.View.HomeScreen;

import java.lang.ref.WeakReference;
import java.util.List;

public class HomeScreenPresenter implements IHomeScreenPresenter{
    private WeakReference<HomeScreen> mView;
    private DBHelper mDbHelper;
    private Activity mContext;
    private HomeScreenModel model;
    public HomeScreenPresenter(HomeScreen homeScreen, DBHelper mDbHelper) {
        this.mView = new WeakReference<HomeScreen>(homeScreen);
        /*Initializing Model for the Presenter*/
        this.model = new HomeScreenModel();
        this.mContext = homeScreen;
        this.mDbHelper = mDbHelper;
    }


    @Override
    public String getUserIDFromDB(String query) {
        return model.getUserIDFromDB(this, query, mDbHelper);
    }

    @Override
    public void deletePushToken(SavePushTokenBody savePushTokenBody, String token) {
        model.deletePushToken(mContext, this, savePushTokenBody, token,mDbHelper);
    }

    @Override
    public void deletePushTokenSuccess() {
        if (mView.get()!=null){
            mView.get().deletePushTokenSuccess();
        }
    }

    @Override
    public void deletePushTokenError(String failureMessage) {
        if (mView.get()!=null){
            mView.get().deletePushTokenError(failureMessage);
        }
    }

    @Override
    public void deleteDataFromTables(String query) {
        model.deleteDataFromTables(query, mDbHelper);
    }

    @Override
    public void savePushToken(SavePushTokenBody savePushTokenBody, String token) {
        model.savePushToken(mContext, this, savePushTokenBody, token);
    }

    @Override
    public void getMeetingList(MeetingListBody body, String token) {
        model.getMeetingList(mContext, this, body, token);
    }

    @Override
    public void getMeetingSuccess(List<MeetingListReturnDatum> meetingList) {
        if (mView.get()!=null){
            mView.get().getMeetingSuccess(meetingList);
        }
    }

    @Override
    public void meetingListError(String msg) {
        if (mView.get()!=null){
            mView.get().meetingListError(msg);
        }
    }
}
