package com.speedum.jitsi_libraries_main_app.UI.Activities.HomeScreen.Model;

import android.app.Activity;

import com.speedum.jitsi_libraries_main_app.API.APIManager;
import com.speedum.jitsi_libraries_main_app.API.APIModels.MeetingList.MeetingListBody.MeetingListBody;
import com.speedum.jitsi_libraries_main_app.API.APIModels.MeetingList.MeetingListResponse.GridConfig;
import com.speedum.jitsi_libraries_main_app.API.APIModels.MeetingList.MeetingListResponse.GridLayoutDatum;
import com.speedum.jitsi_libraries_main_app.API.APIModels.MeetingList.MeetingListResponse.MeetingListResponse;
import com.speedum.jitsi_libraries_main_app.API.APIModels.MeetingList.MeetingListResponse.MeetingListReturnDatum;
import com.speedum.jitsi_libraries_main_app.API.APIModels.Save_Push_Token.SavePushTokenBody;
import com.speedum.jitsi_libraries_main_app.API.APIModels.Save_Push_Token.SavePushTokenResponse;
import com.speedum.jitsi_libraries_main_app.DB.DBHelper;
import com.speedum.jitsi_libraries_main_app.R;
import com.speedum.jitsi_libraries_main_app.UI.Activities.HomeScreen.Presenter.HomeScreenPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeScreenModel implements IHomeScreenModel{
    @Override
    public void deletePushToken(Activity mContext, HomeScreenPresenter presenter, SavePushTokenBody savePushTokenBody, String token, DBHelper mDbHelper) {
        /*Calling API on server .*/
        Call<SavePushTokenResponse> call = APIManager.getService().Save_Push_Token(savePushTokenBody, token);

        call.enqueue(new Callback<SavePushTokenResponse>() {

            @Override
            public void onResponse(Call<SavePushTokenResponse> call, Response<SavePushTokenResponse> response) {

                if (response.isSuccessful()) {
                    if (response.body().getReturnCode().equalsIgnoreCase("true")) {

                        presenter.deletePushTokenSuccess();
                    } else {
                        presenter.deletePushTokenError(response.body().getFailureMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<SavePushTokenResponse> call, Throwable t) {
                presenter.deletePushTokenError(mContext.getString(R.string.Went_Wrong_Message));
            }
        });
    }

    @Override
    public void deleteDataFromTables(String query, DBHelper mDbHelper) {
        mDbHelper.DeleteDataFromTable(query);
    }

    @Override
    public String getUserIDFromDB(HomeScreenPresenter presenter, String query, DBHelper mDbHelper) {
        return mDbHelper.getSingleColumnData(query);
    }

    @Override
    public void savePushToken(Activity mContext, HomeScreenPresenter presenter, SavePushTokenBody savePushTokenBody, String token) {
        /*Calling API on server .*/
        Call<SavePushTokenResponse> call = APIManager.getService().Save_Push_Token(savePushTokenBody, token);

        call.enqueue(new Callback<SavePushTokenResponse>() {

            @Override
            public void onResponse(Call<SavePushTokenResponse> call, Response<SavePushTokenResponse> response) {
/*
                if (response.isSuccessful()) {
                    if (response.body().getReturnCode().equalsIgnoreCase("true")) {
                        presenter.deletePushTokenSuccess();
                    } else {
                        presenter.deletePushTokenError(response.body().getFailureMessage());
                    }
                }*/
            }

            @Override
            public void onFailure(Call<SavePushTokenResponse> call, Throwable t) {
//                presenter.deletePushTokenError(mContext.getString(R.string.Went_Wrong_Message));
            }
        });
    }

    @Override
    public void getMeetingList(Activity mActivity, HomeScreenPresenter meeting_list_screen_provider, MeetingListBody body, String token) {
        Call<MeetingListResponse> call = APIManager.getService().getMeetingList(body, token);
        call.enqueue(new Callback<MeetingListResponse>() {
            @Override
            public void onResponse(Call<MeetingListResponse> call, Response<MeetingListResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getReturnCode().equalsIgnoreCase("true")) {
                        List<GridConfig> GridConfig = response.body().getGridConfig();
                        List<GridLayoutDatum> GridLayoutDatum = response.body().getGridLayoutData();
                        List<MeetingListReturnDatum> meetingList=response.body().getReturnData();
                        /*  return success back to model*/
                        meeting_list_screen_provider.getMeetingSuccess(meetingList);
                    } else {
                        String msg = response.body().getMessage();
                        if(msg.length()>0){
                            msg = response.body().getMessage();
                        }else{
                            msg= response.body().getFailureMessage();
                        }
                        if (msg.length() > 0) {
                            msg=mActivity.getString(R.string.Went_Wrong_Message);
                        }
                        /*return error back to model*/
                        meeting_list_screen_provider.meetingListError(msg);
                    }
                } else {
                    /*return error back to model*/
                    meeting_list_screen_provider.meetingListError(mActivity.getResources().getString(R.string.error_occurred));
                }
            }

            @Override
            public void onFailure(Call<MeetingListResponse> call, Throwable t) {
                /*return error back to model*/
                meeting_list_screen_provider.meetingListError(mActivity.getResources().getString(R.string.error_occurred));
            }
        });
    }
}
