package com.speedum.jitsi_lib.API;

import static android.content.Context.WIFI_SERVICE;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.text.format.Formatter;

import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;
import com.speedum.jitsi_lib.API.APIModels.GetJWTToken.GetJWTTokenDataJSON;
import com.speedum.jitsi_lib.API.APIModels.Session_Token.SessionTokenBody;
import com.speedum.jitsi_lib.API.APIModels.Session_Token.SessionTokenResponse;
import com.speedum.jitsi_lib.API.Comman_Data.MetaData;
import com.speedum.jitsi_lib.API.Comman_Data.OtherData;
import com.speedum.jitsi_lib.API.Comman_Data.UserData;
import com.speedum.jitsi_lib.DB.sharedPrefrances;
import com.speedum.jitsi_lib.R;
import com.speedum.jitsi_lib.Utils.Config;
import com.speedum.jitsi_lib.Utils.Util;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class API_Body {

    private String mEnvironment = "";

    @Inject
    public API_Body() {
//        config config=new config();
//        mEnvironment = config.ENVIRONMENT;
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


    public void getJwtTokenBody(String PatientId, String VisitId,String UserRoomName, String MeetUniqueCode, String env, String remote_ip, String app_session, String process_id
            , String user_id, String org_id, String role_id, Context context, CheckSessionCallBack checkSessionCallBack) {
        CommonBody body = new CommonBody();
        GetJWTTokenDataJSON dataJSON = new GetJWTTokenDataJSON();
        dataJSON.setpPatientId(PatientId);
        dataJSON.setMeetUniqueCode(MeetUniqueCode);
        dataJSON.setpUserRoomName(UserRoomName);
        dataJSON.setpVisitId(VisitId);


        body.setDataJSON(dataJSON);
        body.setEnvironment(env);
        body.setMetaData(get_Body_MetaData(PatientId));
        body.setOtherData(get_Body_OtherData(remote_ip, context));
        body.setUserData(get_Body_UserData(app_session, org_id, user_id, role_id));
        body.setProcessId(process_id);

        /* Validating session token and return common body through callback */
        checkSession(context, body, org_id, user_id, role_id, checkSessionCallBack);
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

    /*Callback for Validating session token and return common body */
    public interface CheckSessionCallBack {
        void sessionIsUpdated(CommonBody body, String finalToken);

        void errorGettingNewToken(String Title, String message);
    }

    /* Validating session token and return common body through callback */
    private void checkSession(Context context, CommonBody commonBody, String org_id, String user_id, String role_id, CheckSessionCallBack checkSessionCallBack) {
        if (Util.isInternetOn(context)) {
//            String ss=new Gson().toJson(commonBody);
            String SessionExpiry = Config.TOKEN_EXPIRY;  //  2021-04-23 14:37:30  yyyy-MM-dd HH:mm:ss
//        String SessionExpiry = sharedPrefrances.getSessionExpiry(context);  //  2021-04-23 14:37:30  yyyy-MM-dd HH:mm:ss
            if (Util.isSessionNotExpire(SessionExpiry)) {
                String finalToken=commonBody.getUserData().getSgAppSession();
                checkSessionCallBack.sessionIsUpdated(commonBody,finalToken);
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
                SessionTokenBody sessionTokenBody = get_Session_Body(Config.AI_Code, Config.DEVICE_TYPE, "ANDROID", versionRelease, androidId, ip);
                /*Calling API on server*/
                /*Calling API on server .*/
                Call<SessionTokenResponse> call = APIManager.getService().Create_Session(Config.SESSION_CREATE_LINK, sessionTokenBody, "sgIntSessionToken", Config.AI_Code);
                call.enqueue(new Callback<SessionTokenResponse>() {

                    @Override
                    public void onResponse(Call<SessionTokenResponse> call, Response<SessionTokenResponse> response) {

                        if (response.isSuccessful()) {
                            if (response.body().getReturnAppIdentifier().equalsIgnoreCase("true") && response.body().getReturnLicenseIdentifier().equalsIgnoreCase("true")) {
                                String session_token = response.body().getReturnSessionToken();
                                String session_expire_time = response.body().getReturnSessionExpiry();
//                                session_token = Util.encryptData(session_token);
                                Config.TOKEN_EXPIRY =  Util.encryptData(session_token);
                                Config.Token = session_token;
                                sharedPrefrances.saveSessionToken(context,  Util.encryptData(session_token));
                                sharedPrefrances.saveSessionExpiry(context, session_expire_time);
                                commonBody.setUserData(get_Body_UserData(session_token, org_id, user_id, ""));
                                Intent i = new Intent("android.intent.action.sessionUpdateReciver");
                                i.putExtra("Token", Util.encryptData(session_token));
                                i.putExtra("TOKEN_EXPIRY", session_expire_time);
                                context.sendBroadcast(i);
                                checkSessionCallBack.sessionIsUpdated(commonBody, session_token);
                            } else {
                                if (true){
                                    Intent i = context.getPackageManager().
                                            getLaunchIntentForPackage(context.getPackageName());
                                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    context.startActivity(i);
                                }else {
                                    Intent i = new Intent("android.intent.action.sessionUpdateReciver");
                                    i.putExtra("Token", "");
                                    i.putExtra("TOKEN_EXPIRY", "2020-06-24 15:00:26");
                                    context.sendBroadcast(i);
                                    if (response.body().getReturnAppIdentifier().equalsIgnoreCase("false")) {
                                        sharedPrefrances.saveSessionToken(context, "");
                                    } else if (response.body().getReturnLicenseIdentifier().equalsIgnoreCase("false")) {
                                        String session_token = response.body().getReturnSessionToken();
                                        session_token = Util.encryptData(session_token);
                                        Config.Token = session_token;
                                        String error_msg = response.body().getReturnError();
                                        sharedPrefrances.saveSessionToken(context, session_token);
                                    }  ////  title -session error  ///   Session_Error_Message

                                    String msg = response.body().getReturnError();
                          /*  if (msg.length() <= 0) {
                                msg = response.body().getMessage();
                            } else {
                                msg = response.body().getFailureMessage();
                            }*/
                                    String sessionExDate="2020-06-24 15:00:26";
                                    sharedPrefrances.saveSessionExpiry(context, sessionExDate);
                                    Config.TOKEN_EXPIRY = sessionExDate;
                                    if (msg.length() <= 0) {
                                        msg = context.getString(R.string.Session_Error_Message);
                                    }
                                    checkSessionCallBack.errorGettingNewToken(context.getString(R.string.Session_Error_Title), msg);
                                }

                            }
                        } else {
                            if (true){
                                Intent i = context.getPackageManager().
                                        getLaunchIntentForPackage(context.getPackageName());
                                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                context.startActivity(i);
                            }else {
                                String msg = response.body().getReturnError();
                                Intent i = new Intent("android.intent.action.sessionUpdateReciver");
                                i.putExtra("Token", "");
                                i.putExtra("TOKEN_EXPIRY", "2020-06-24 15:00:26");
                                context.sendBroadcast(i);
                                String sessionExDate="2020-06-24 15:00:26";
                                sharedPrefrances.saveSessionExpiry(context, sessionExDate);
                                Config.TOKEN_EXPIRY = sessionExDate;
                                if (msg.length() <= 0) {
                                    msg = context.getString(R.string.Session_Error_Message);
                                }
                                checkSessionCallBack.errorGettingNewToken(context.getString(R.string.Session_Error_Title), msg);
                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<SessionTokenResponse> call, Throwable t) {
                        if (true){
                            Intent i = context.getPackageManager().
                                    getLaunchIntentForPackage(context.getPackageName());
                            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(i);
                        }else {
                            String sessionExDate="2020-06-24 15:00:26";
                            sharedPrefrances.saveSessionExpiry(context, sessionExDate);
                            sharedPrefrances.saveSessionToken(context, "");
                            String msg = "";
                            Config.TOKEN_EXPIRY = sessionExDate;
                            Intent i = new Intent("android.intent.action.sessionUpdateReciver");
                            i.putExtra("Token", "");
                            i.putExtra("TOKEN_EXPIRY", "2019-06-24 15:00:26");
                            context.sendBroadcast(i);
                            if (msg.length() > 0) {
                                msg = context.getString(R.string.Session_Error_Message);
                            }
                            checkSessionCallBack.errorGettingNewToken(context.getString(R.string.Session_Error_Title), msg);
                        }

                    }
                });

            }
        } else {
            SnackbarManager.show(
                    Snackbar.with(context)
                            .text(R.string.Internet_error));
        }

    }


}
