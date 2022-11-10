package com.speedum.jitsi_libraries_main_app.API;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.text.format.Formatter;


import com.speedum.jitsi_libraries_main_app.API.APIModels.FetchOrgInfo.GetOrgIDDataJSON;
import com.speedum.jitsi_libraries_main_app.API.APIModels.Fetch_User_Profile.FetchUserProfileDataJSON;
import com.speedum.jitsi_libraries_main_app.API.APIModels.Foot_Print.FootPrintBody;
import com.speedum.jitsi_libraries_main_app.API.APIModels.GetColorConfig.GetColorConfigBody.GetColorConfigDataJSON;
import com.speedum.jitsi_libraries_main_app.API.APIModels.HomeScreenConfig.HomeScreenConfigBody.HomeScreenConfigDataJSON;
import com.speedum.jitsi_libraries_main_app.API.APIModels.Login_User.LoginDataJSON;
import com.speedum.jitsi_libraries_main_app.API.APIModels.MeetingList.MeetingListBody.MeetingListBody;
import com.speedum.jitsi_libraries_main_app.API.APIModels.MeetingList.MeetingListBody.MeetingListDataJSON;
import com.speedum.jitsi_libraries_main_app.API.APIModels.Save_Push_Token.SavePushDataJSON;
import com.speedum.jitsi_libraries_main_app.API.APIModels.Save_Push_Token.SavePushTokenBody;
import com.speedum.jitsi_libraries_main_app.API.APIModels.Session_Token.SessionTokenBody;
import com.speedum.jitsi_libraries_main_app.API.APIModels.Session_Token.SessionTokenResponse;
import com.speedum.jitsi_libraries_main_app.API.Comman_Data.CommonBody;
import com.speedum.jitsi_libraries_main_app.API.Comman_Data.MetaData;
import com.speedum.jitsi_libraries_main_app.API.Comman_Data.OtherData;
import com.speedum.jitsi_libraries_main_app.API.Comman_Data.UserData;
import com.speedum.jitsi_libraries_main_app.Config;
import com.speedum.jitsi_libraries_main_app.DB.sharedPrefrances;
import com.speedum.jitsi_libraries_main_app.R;
import com.speedum.jitsi_libraries_main_app.Util.Util;
import com.speedum.jitsi_libraries_main_app.Util.config;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.WIFI_SERVICE;

@Singleton
public class API_Body {
    private String mEnvironment = "";

    @Inject
    public API_Body() {
        mEnvironment = config.ENVIRONMENT;
    }

    private MetaData get_Body_MetaData(String patient_id) {
        MetaData metaData = new MetaData();
        metaData.setSgPatientId(patient_id);
        metaData.setSgVisitId("");

        return metaData;
    }

    private MetaData get_Body_MetaData(String patient_id, String Visit_id) {
        MetaData metaData = new MetaData();
        metaData.setSgPatientId(patient_id);
        metaData.setSgVisitId(Visit_id);

        return metaData;
    }

    private OtherData get_Body_OtherData(String remote_ip, Context context) {
        String versionName = "";
        try {
            PackageInfo pinfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            versionName = pinfo.versionName;
        } catch (Exception e) {
        }
        OtherData otherData = new OtherData();
        otherData.setRemoteAddr(remote_ip);
        otherData.setSgAppPlatform("ANDROID");
        otherData.setSgAppVersion(versionName);

        return otherData;
    }

    private UserData get_Body_UserData(String appSession, String org_id, String user_id, String role_id) {

        UserData userData = new UserData();
        userData.setSgMenuId("");
        userData.setSgAppSession(appSession);
        userData.setSgOrgId(org_id);
        userData.setSgRoleId(role_id);
        userData.setSgUserId(user_id);

        return userData;
    }

    public FootPrintBody get_FootPrint_Body(String aicode, String device_type, String device_os, String device_os_ver
            , String device_uniqueId, String device_IP) {
        FootPrintBody footPrintBody = new FootPrintBody();
        footPrintBody.setAiCode(aicode);
        footPrintBody.setDeviceType(device_type);
        footPrintBody.setDeviceOs(device_os);
        footPrintBody.setDeviceId(device_uniqueId);
        footPrintBody.setDeviceOsVersion(device_os_ver);
        footPrintBody.setDeviceUniqueId(device_uniqueId);
        footPrintBody.setDeviceIp(device_IP);

        return footPrintBody;
    }

    public MeetingListBody getMeetingListBody(String DateFrom, String RoleId, String env, String remote_ip, String app_session, String process_id
            , String user_id, String org_id, Context context, String patient_id) {
        MeetingListBody body = new MeetingListBody();
        MeetingListDataJSON dataJSON = new MeetingListDataJSON();
        dataJSON.setSgOrgId(org_id);
        dataJSON.setSgRoleId(RoleId);
        dataJSON.setSgUserId(user_id);
        dataJSON.setPDateFrom(DateFrom);

        body.setDataJSON(dataJSON);
        body.setEnvironment(env);
        body.setMetaData(get_Body_MetaData(patient_id));
        body.setOtherData(get_Body_OtherData(remote_ip, context));
        body.setUserData(get_Body_UserData(app_session, org_id, user_id, ""));
        body.setProcessId(process_id);

        return body;
    }


    public SavePushTokenBody save_push_Token_Body(String app_code, String app_ver, String app_device_idf
            , String device_make, String device_model, String device_token
            , String env, String remote_ip, String app_session, String process_id
            , String user_id, String org_id, Context context, String patient_id) {
        SavePushTokenBody savePushTokenBody = new SavePushTokenBody();
        SavePushDataJSON savePushDataJSON = new SavePushDataJSON();
        savePushDataJSON.setPAppCode(app_code);
        savePushDataJSON.setPUsrAppVersion(app_ver);
        savePushDataJSON.setPUsrDeviceIdentifier(app_device_idf);
        savePushDataJSON.setPUsrDeviceMake(device_make);
        savePushDataJSON.setPUsrDeviceModel(device_model);
        savePushDataJSON.setPUsrDeviceToken(device_token);
        savePushDataJSON.setPUsrDeviceType("Android");
        savePushTokenBody.setDataJSON(savePushDataJSON);
        savePushTokenBody.setEnvironment(env);
        savePushTokenBody.setMetaData(get_Body_MetaData(""));
        savePushTokenBody.setOtherData(get_Body_OtherData(remote_ip, context));
        savePushTokenBody.setUserData(get_Body_UserData(app_session, "", "", ""));
        savePushTokenBody.setProcessId(process_id);

        return savePushTokenBody;
    }


    public SessionTokenBody get_Session_Body(String aicode, String device_type, String device_os, String device_os_ver
            , String device_uniqueId, String device_IP) {
        SessionTokenBody sessionTokenBody = new SessionTokenBody();
        sessionTokenBody.setAiCode(aicode);
        sessionTokenBody.setDeviceType(device_type);
        sessionTokenBody.setDeviceOs(device_os);
        sessionTokenBody.setDeviceOsVersion(device_os_ver);
        sessionTokenBody.setDeviceUniqueId(device_uniqueId);
        sessionTokenBody.setDeviceIp(device_IP);

        return sessionTokenBody;
    }

    public void get_user_Auth_Body(String login_name, String password, String env, String remote_ip
            , String app_session, String process_id, Context context,CheckSessionCallBack checkSessionCallBack) {
        CommonBody loginUserBody = new CommonBody();
        LoginDataJSON loginDataJSON = new LoginDataJSON();
        loginDataJSON.setPLogin(login_name);
        loginDataJSON.setPPassword(password);
        loginUserBody.setDataJSON(loginDataJSON);
        loginUserBody.setEnvironment(env);
        loginUserBody.setMetaData(get_Body_MetaData(""));
        loginUserBody.setOtherData(get_Body_OtherData(remote_ip, context));
        loginUserBody.setUserData(get_Body_UserData(app_session, "", "", ""));
        loginUserBody.setProcessId(process_id);
        /* Validating session token and return common body through callback */
        checkSession(context, loginUserBody, "", "", "", checkSessionCallBack);
    }

    public void getGetOrgIDBody(String role_id, String env, String remote_ip, String app_session, String process_id
            , String user_id, String org_id, Context context, String patient_id, CheckSessionCallBack checkSessionCallBack) {
        CommonBody body = new CommonBody();
        GetOrgIDDataJSON dataJSON = new GetOrgIDDataJSON();
        dataJSON.setPOrgAiCode(Config.getAI_CODE());
        body.setDataJSON(dataJSON);
        body.setEnvironment(env);
        body.setMetaData(get_Body_MetaData(patient_id));
        body.setOtherData(get_Body_OtherData(remote_ip, context));
        body.setUserData(get_Body_UserData(app_session, org_id, user_id, role_id));
        body.setProcessId(process_id);
        /* Validating session token and return common body through callback */
        checkSession(context, body, org_id, user_id, "", checkSessionCallBack);
    }


    public void getHomeScreenConfigBody(String PatientId, String UserId, String RoleId, String AiCode, String env, String remote_ip, String app_session, String process_id
            , String org_id, Context context,CheckSessionCallBack checkSessionCallBack) {
        CommonBody body = new CommonBody();
        HomeScreenConfigDataJSON dataJSON = new HomeScreenConfigDataJSON();
        dataJSON.setPAiCode(AiCode);
        dataJSON.setSgOrgId(org_id);
        body.setDataJSON(dataJSON);
        body.setEnvironment(env);
        body.setMetaData(get_Body_MetaData(PatientId));
        body.setOtherData(get_Body_OtherData(remote_ip, context));
        body.setUserData(get_Body_UserData(app_session, org_id, UserId, RoleId));
        body.setProcessId(process_id);
        /* Validating session token and return common body through callback */
        checkSession(context, body, org_id, UserId, "", checkSessionCallBack);
    }


    public void getColorConfigBody(String AiCode, String env, String remote_ip, String app_session, String process_id
            , String org_id, Context context,CheckSessionCallBack checkSessionCallBack) {
        CommonBody body = new CommonBody();
        GetColorConfigDataJSON dataJSON = new GetColorConfigDataJSON();
        dataJSON.setPAiCode(AiCode);

        body.setDataJSON(dataJSON);
        body.setEnvironment(env);
        body.setMetaData(get_Body_MetaData(""));
        body.setOtherData(get_Body_OtherData(remote_ip, context));
        body.setUserData(get_Body_UserData(app_session, org_id, "", ""));
        body.setProcessId(process_id);
        /* Validating session token and return common body through callback */
        checkSession(context, body, org_id, "", "", checkSessionCallBack);
    }












    public void fetch_user_profile(String env, String remote_ip, String app_session, String process_id
            , String user_id, String org_id, Context context, String patient_id,CheckSessionCallBack checkSessionCallBack) {
        CommonBody fetchUserProfileBody = new CommonBody();
        FetchUserProfileDataJSON fetchUserProfileDataJSON = new FetchUserProfileDataJSON();
        fetchUserProfileBody.setDataJSON(fetchUserProfileDataJSON);
        fetchUserProfileBody.setEnvironment(env);
        fetchUserProfileBody.setMetaData(get_Body_MetaData(patient_id));
        fetchUserProfileBody.setOtherData(get_Body_OtherData(remote_ip, context));
        fetchUserProfileBody.setUserData(get_Body_UserData(app_session, org_id, user_id, ""));
        fetchUserProfileBody.setProcessId(process_id);
        /* Validating session token and return common body through callback */
        checkSession(context, fetchUserProfileBody, org_id, user_id, "", checkSessionCallBack);
    }


    /*Callback for Validating session token and return common body */
    public interface CheckSessionCallBack {
        void sessionIsUpdated(CommonBody body);
        void errorGettingNewToken(String Title,String message);
    }

    /* Validating session token and return common body through callback */
    private void checkSession(Context context, CommonBody commonBody, String org_id, String user_id, String role_id, CheckSessionCallBack checkSessionCallBack) {
        String SessionExpiry = sharedPrefrances.getSessionExpiry(context);  //  2021-04-23 14:37:30  yyyy-MM-dd HH:mm:ss
        if (Util.isSessionNotExpire(SessionExpiry)) {
            checkSessionCallBack.sessionIsUpdated(commonBody);
        } else {
            String versionRelease = "";
            String androidId = "";
            String ip = "";
            try {
                versionRelease = Build.VERSION.RELEASE;
                /*getting unique id*/
                androidId = Settings.Secure.getString(context.getContentResolver(),
                        Settings.Secure.ANDROID_ID);
                WifiManager wm = (WifiManager) context.getApplicationContext().getSystemService(WIFI_SERVICE);
                ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
            } catch (Exception e) {
                e.printStackTrace();
            }
            /*creating foot print body*/
            SessionTokenBody sessionTokenBody = get_Session_Body(config.AI_CODE, "ANDROID", "ANDROID", versionRelease, androidId, ip);

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
                            commonBody.setUserData(get_Body_UserData(session_token, org_id, user_id, ""));
                            checkSessionCallBack.sessionIsUpdated(commonBody);
                        } else {
                            if (response.body().getReturnAppIdentifier().equalsIgnoreCase("false")) {
                                sharedPrefrances.saveSessionToken(context, "");
                                sharedPrefrances.saveErrorFlag(context, "false");
                            } else if (response.body().getReturnLicenseIdentifier().equalsIgnoreCase("false")) {
                                String session_token = response.body().getReturnSessionToken();
                                session_token = Util.encryptData(session_token);
                                String error_msg = response.body().getReturnError();
                                sharedPrefrances.saveSessionToken(context, session_token);
                                sharedPrefrances.saveErrorMsg(context, error_msg);
                                sharedPrefrances.saveErrorFlag(context, "true");
                            }  ////  title -session error  ///   Session_Error_Message

                            String msg = response.body().getReturnError();
                          /*  if (msg.length() <= 0) {
                                msg = response.body().getMessage();
                            } else {
                                msg = response.body().getFailureMessage();
                            }*/
                            if (msg.length() > 0) {
                                msg = context.getString(R.string.Session_Error_Message);
                            }
                            checkSessionCallBack.errorGettingNewToken(context.getString(R.string.Session_Error_Title),msg);
                        }
                    } else {
                        sharedPrefrances.SaveFootPrint(context, 0);
                        String msg = response.body().getReturnError();

                        if (msg.length() > 0) {
                            msg = context.getString(R.string.Session_Error_Message);
                        }
                        checkSessionCallBack.errorGettingNewToken(context.getString(R.string.Session_Error_Title),msg);
                    }
                }

                @Override
                public void onFailure(Call<SessionTokenResponse> call, Throwable t) {
                    sharedPrefrances.saveSessionToken(context, "");
                    sharedPrefrances.saveErrorFlag(context, "false");
                    String msg = "";

                    if (msg.length() > 0) {
                        msg = context.getString(R.string.Session_Error_Message);
                    }
                    checkSessionCallBack.errorGettingNewToken(context.getString(R.string.Session_Error_Title),msg);
                }
            });
        }
    }


    public class ResponseHandling<T> {


    }

    public interface ResponseCallback<T> {
        void returnData(ArrayList<T> returnData1, List<T> returnData2);

    }
}
