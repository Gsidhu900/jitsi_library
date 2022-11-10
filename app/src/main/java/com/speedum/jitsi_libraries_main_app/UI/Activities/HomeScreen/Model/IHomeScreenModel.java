package com.speedum.jitsi_libraries_main_app.UI.Activities.HomeScreen.Model;

import android.app.Activity;

import com.speedum.jitsi_libraries_main_app.API.APIModels.MeetingList.MeetingListBody.MeetingListBody;
import com.speedum.jitsi_libraries_main_app.API.APIModels.Save_Push_Token.SavePushTokenBody;
import com.speedum.jitsi_libraries_main_app.DB.DBHelper;
import com.speedum.jitsi_libraries_main_app.UI.Activities.HomeScreen.Presenter.HomeScreenPresenter;

public interface IHomeScreenModel {
    void deletePushToken(Activity mContext, HomeScreenPresenter presenter, SavePushTokenBody savePushTokenBody, String token, DBHelper mDbHelper);

    void deleteDataFromTables(String query, DBHelper mDbHelper);

    String getUserIDFromDB(HomeScreenPresenter presenter, String query, DBHelper mDbHelper);

    void savePushToken(Activity mContext, HomeScreenPresenter presenter, SavePushTokenBody savePushTokenBody, String token);

    void getMeetingList(Activity mContext, HomeScreenPresenter presenter, MeetingListBody body, String token);
}
