package com.speedum.jitsi_libraries_main_app.UI.Activities.HomeScreen.View;

import com.speedum.jitsi_libraries_main_app.API.APIModels.MeetingList.MeetingListResponse.MeetingListReturnDatum;

import java.util.List;

public interface IHomeScreen {
    void deletePushTokenSuccess();

    void deletePushTokenError(String failureMessage);

    void getMeetingSuccess(List<MeetingListReturnDatum> meetingList);

    void meetingListError(String msg);
}
