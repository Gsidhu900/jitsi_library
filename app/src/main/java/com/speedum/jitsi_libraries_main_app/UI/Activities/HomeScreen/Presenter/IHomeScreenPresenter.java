package com.speedum.jitsi_libraries_main_app.UI.Activities.HomeScreen.Presenter;


import com.speedum.jitsi_libraries_main_app.API.APIModels.MeetingList.MeetingListBody.MeetingListBody;
import com.speedum.jitsi_libraries_main_app.API.APIModels.MeetingList.MeetingListResponse.MeetingListReturnDatum;
import com.speedum.jitsi_libraries_main_app.API.APIModels.Save_Push_Token.SavePushTokenBody;

import java.util.List;

public interface IHomeScreenPresenter {
    String getUserIDFromDB(String query);

    void deletePushToken(SavePushTokenBody savePushTokenBody, String token);

    void deletePushTokenSuccess();

    void deletePushTokenError(String failureMessage);

    void deleteDataFromTables(String query);

    void savePushToken(SavePushTokenBody savePushTokenBody, String finalToken);

    void getMeetingList(MeetingListBody body, String token);

    void getMeetingSuccess(List<MeetingListReturnDatum> meetingList);

    void meetingListError(String msg);
}
