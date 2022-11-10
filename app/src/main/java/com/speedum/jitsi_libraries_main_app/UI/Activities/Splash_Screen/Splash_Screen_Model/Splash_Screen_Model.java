package com.speedum.jitsi_libraries_main_app.UI.Activities.Splash_Screen.Splash_Screen_Model;

import android.app.Activity;
import android.content.Context;

import com.google.gson.Gson;
import com.speedum.jitsi_libraries_main_app.API.APIManager;
import com.speedum.jitsi_libraries_main_app.API.APIModels.Foot_Print.FootPrintBody;
import com.speedum.jitsi_libraries_main_app.API.APIModels.Foot_Print.FootPrintResponse;
import com.speedum.jitsi_libraries_main_app.API.APIModels.GetColorConfig.GetColorConfigResponse.ColorConfigModel;
import com.speedum.jitsi_libraries_main_app.API.APIModels.GetColorConfig.GetColorConfigResponse.GetColorConfigReturnDatum;
import com.speedum.jitsi_libraries_main_app.API.APIModels.HomeScreenConfig.HomeScreenConfigResponse.HomeScreenConfigReturnDatum;
import com.speedum.jitsi_libraries_main_app.API.APIModels.OrgInfo.GetOrgIDReturnDatum;
import com.speedum.jitsi_libraries_main_app.API.APIModels.Session_Token.SessionTokenBody;
import com.speedum.jitsi_libraries_main_app.API.APIModels.Session_Token.SessionTokenResponse;
import com.speedum.jitsi_libraries_main_app.API.Comman_Data.CommonBody;
import com.speedum.jitsi_libraries_main_app.API.Comman_Data.CommonResponse;
import com.speedum.jitsi_libraries_main_app.API.Comman_Data.ResponseHandling;
import com.speedum.jitsi_libraries_main_app.Config;
import com.speedum.jitsi_libraries_main_app.DB.DBHelper;
import com.speedum.jitsi_libraries_main_app.DB.DB_Queries;
import com.speedum.jitsi_libraries_main_app.DB.sharedPrefrances;
import com.speedum.jitsi_libraries_main_app.R;
import com.speedum.jitsi_libraries_main_app.UI.Activities.Splash_Screen.Splash_Screen_Presenter.ISplash_Screen_Presenter;
import com.speedum.jitsi_libraries_main_app.UI.Activities.Splash_Screen.Splash_Screen_Presenter.Splash_Screen_Presenter;
import com.speedum.jitsi_libraries_main_app.Util.Util;
import com.speedum.jitsi_libraries_main_app.Util.config;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Splash_Screen_Model implements ISplash_Screen_Model {

    @Override
    public void createFootPrint(ISplash_Screen_Presenter iSplash_screen_presenter, FootPrintBody footPrintBody, Context context) {
        /*Calling API on server .*/
        Call<FootPrintResponse> call = APIManager.getService().FootPrint(Config.NEW_INTERNAL,footPrintBody, "sgIntFootPrint", config.AI_CODE);

        call.enqueue(new Callback<FootPrintResponse>() {

            @Override
            public void onResponse(Call<FootPrintResponse> call, Response<FootPrintResponse> response) {

                if (response.isSuccessful()) {
                    if (response.body().getReturnAppIdentifier().equalsIgnoreCase("true")) {
                        sharedPrefrances.SaveFootPrint(context, 1);
                        /*return success back to model*/
                        iSplash_screen_presenter.createFootPrintSuccess();
                    } else {
                        sharedPrefrances.SaveFootPrint(context, 0);
                        /*return error back to model*/
                        iSplash_screen_presenter.createFootPrintError(context.getResources().getString(R.string.footprint_error));
                    }
                } else {
                    sharedPrefrances.SaveFootPrint(context, 0);
                    /*return error back to model*/
                    iSplash_screen_presenter.createFootPrintError(context.getResources().getString(R.string.footprint_error));
                }
            }

            @Override
            public void onFailure(Call<FootPrintResponse> call, Throwable t) {
                sharedPrefrances.SaveFootPrint(context, 0);
                /*return error back to model*/
                iSplash_screen_presenter.createFootPrintError(context.getResources().getString(R.string.footprint_error));
            }
        });
    }

    @Override
    public void createSession(ISplash_Screen_Presenter iSplash_screen_presenter, SessionTokenBody sessionTokenBody, Context context) {
        /*Calling API on server .*/
        Call<SessionTokenResponse> call = APIManager.getService().Create_Session(Config.NEW_INTERNAL,sessionTokenBody, "sgIntSessionToken", config.AI_CODE);

        call.enqueue(new Callback<SessionTokenResponse>() {

            @Override
            public void onResponse(Call<SessionTokenResponse> call, Response<SessionTokenResponse> response) {

                if (response.isSuccessful()) {
                    if (response.body().getReturnAppIdentifier().equalsIgnoreCase("true") && response.body().getReturnLicenseIdentifier().equalsIgnoreCase("true")) {
                        String session_token = response.body().getReturnSessionToken();
                        String session_expire_time = response.body().getReturnSessionExpiry();
                        session_token = Util.encryptData(session_token);
                        sharedPrefrances.saveSessionToken(context, session_token);
                        sharedPrefrances.saveSessionExpiry(context, session_expire_time);
                        sharedPrefrances.saveErrorFlag(context, "false");
                        /*return success back to model*/
                        iSplash_screen_presenter.createSessionSuccess();
                    } else {
                        if (response.body().getReturnAppIdentifier().equalsIgnoreCase("false")) {
                            sharedPrefrances.saveSessionToken(context, "");
                            sharedPrefrances.saveErrorFlag(context, "false");
                            String error_msg = response.body().getReturnError();
                            /*return error back to model*/
                            iSplash_screen_presenter.createSessionError(error_msg);
                        } else if (response.body().getReturnLicenseIdentifier().equalsIgnoreCase("false")) {
                            String session_token = response.body().getReturnSessionToken();
                            session_token = Util.encryptData(session_token);
                            String error_msg = response.body().getReturnError();
                            sharedPrefrances.saveSessionToken(context, session_token);
                            sharedPrefrances.saveErrorMsg(context, error_msg);
                            sharedPrefrances.saveErrorFlag(context, "true");
                            /*return error back to model*/
                            iSplash_screen_presenter.createSessionError(context.getResources().getString(R.string.license_expired));
                        }
                    }
                } else {
                    sharedPrefrances.SaveFootPrint(context, 0);
                    /*return error back to model*/
                    iSplash_screen_presenter.createSessionError(context.getResources().getString(R.string.error_occurred));
                }
            }

            @Override
            public void onFailure(Call<SessionTokenResponse> call, Throwable t) {
                sharedPrefrances.saveSessionToken(context, "");
                sharedPrefrances.saveErrorFlag(context, "false");
                /*return error back to model*/
                iSplash_screen_presenter.createSessionError(context.getResources().getString(R.string.error_occurred));
            }
        });
    }

    @Override
    public String getLastMsgID(String query, DBHelper dbHelper) {
        return dbHelper.getLastMsgID(query);
    }


    @Override
    public void getColorConfig(Splash_Screen_Presenter splash_screen_presenter, CommonBody body, Activity mContext, DBHelper mDbHelper, String session_ID) {
        /*Calling API on server .*/
        Call<CommonResponse<GetColorConfigReturnDatum>> call = APIManager.getService().getColorConfig(body, session_ID);
        call.enqueue(new Callback<CommonResponse<GetColorConfigReturnDatum>>() {
            @Override
            public void onResponse(Call<CommonResponse<GetColorConfigReturnDatum>> call, Response<CommonResponse<GetColorConfigReturnDatum>> response) {
                ResponseHandling responseHandling = new ResponseHandling();
                responseHandling.checkResponseData(mContext, response, new ResponseHandling.ResponseCallback() {
                    @Override
                    public void returnData(ArrayList returnData1, List returnData2, String message) {
                        /*return success back to model*/
                        List<GetColorConfigReturnDatum> returnData = returnData2;
                        String payload = returnData.get(0).getAttributes();
//                        Log.e("getColorConfig"," payload "+payload);
                        ColorConfigModel colorConfigModel = new ColorConfigModel();
                        if (payload != null && !payload.trim().equalsIgnoreCase("")) {
                            payload = payload.replace("\t", "");
                            payload = payload.replace("\n", "");
                            payload = payload.replace("\\", "");
                            payload = payload.replace("}, {", ",");
                            payload = payload.replace("},{", ",");
                            payload = payload.replace("[", "");
                            payload = payload.replace("]", "");
                            Gson gson = new Gson();
                            colorConfigModel = gson.fromJson(payload, ColorConfigModel.class);
                            mDbHelper.saveColorConfigInDB(colorConfigModel, DB_Queries.save_color_config);
                            splash_screen_presenter.getColorConfigSuccess();
                        }
                    }

                    @Override
                    public void errorMessage(String message) {
                        /*return error back to model*/
                        splash_screen_presenter.getColorConfigError(message);
                    }
                });
            }

            @Override
            public void onFailure(Call<CommonResponse<GetColorConfigReturnDatum>> call, Throwable t) {
                splash_screen_presenter.getColorConfigError(mContext.getResources().getString(R.string.error_occurred));
            }
        });
    }

    @Override
    public void getHomeScrenConfig(Splash_Screen_Presenter splash_screen_presenter, CommonBody body, Activity mContext, DBHelper mDbHelper, String token) {
        splash_screen_presenter.homeScreenCongifSuccess();
        Call<CommonResponse<HomeScreenConfigReturnDatum>> call = APIManager.getService().getHomeScreenConfig(body, token);
        call.enqueue(new Callback<CommonResponse<HomeScreenConfigReturnDatum>>() {
            @Override
            public void onResponse(Call<CommonResponse<HomeScreenConfigReturnDatum>> call, Response<CommonResponse<HomeScreenConfigReturnDatum>> response) {
                ResponseHandling responseHandling = new ResponseHandling();
                responseHandling.checkResponseData(mContext, response, new ResponseHandling.ResponseCallback() {
                    @Override
                    public void returnData(ArrayList returnData1, List HomeConfig, String message) {
                        String all = new Gson().toJson(returnData1);
                        mDbHelper.DeleteDataFromTable(DB_Queries.delete_HomeScreen_Config);
                        mDbHelper.saveHomeScrenConfigDB(HomeConfig, DB_Queries.save_HomeScreen_Config);
                        splash_screen_presenter.homeScreenCongifSuccess();
                    }

                    @Override
                    public void errorMessage(String message) {
                        /* return error back to model*/
                        splash_screen_presenter.homeScreenCongifSuccess();
                    }
                });
            }

            @Override
            public void onFailure(Call<CommonResponse<HomeScreenConfigReturnDatum>> call, Throwable t) {
                splash_screen_presenter.homeScreenCongifSuccess();
            }
        });
    }

    @Override
    public void getOrgInfoFromServer(Splash_Screen_Presenter splash_screen_presenter, CommonBody body, Activity mContext, DBHelper mDbHelper, String token) {
        Call<CommonResponse<GetOrgIDReturnDatum>> call = APIManager.getService().getOrgInfoFromServer(body, token);
        call.enqueue(new Callback<CommonResponse<GetOrgIDReturnDatum>>() {
            @Override
            public void onResponse(Call<CommonResponse<GetOrgIDReturnDatum>> call, Response<CommonResponse<GetOrgIDReturnDatum>> response) {
                ResponseHandling responseHandling = new ResponseHandling();
                responseHandling.checkResponseData(mContext, response, new ResponseHandling.ResponseCallback() {
                    @Override
                    public void returnData(ArrayList returnData1, List HomeConfig, String message) {
                        List<GetOrgIDReturnDatum> orgInfo = HomeConfig;
                        mDbHelper.DeleteDataFromTable(DB_Queries.delete_org_info);
                        mDbHelper.saveOrgInfoInDB(orgInfo, DB_Queries.save_org_Info);
                    }

                    @Override
                    public void errorMessage(String message) {

                    }
                });
                splash_screen_presenter.homeScreenOrgInfoSuccess();
            }

            @Override
            public void onFailure(Call<CommonResponse<GetOrgIDReturnDatum>> call, Throwable t) {
                splash_screen_presenter.homeScreenOrgInfoSuccess();
            }
        });
    }
}
