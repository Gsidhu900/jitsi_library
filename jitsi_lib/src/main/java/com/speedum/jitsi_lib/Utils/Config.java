package com.speedum.jitsi_lib.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.speedum.jitsi_lib.API.APIManager;
import com.speedum.jitsi_lib.API.APIModels.GetJWTToken.GetJWTTokenReturnData;
import com.speedum.jitsi_lib.API.API_Body;
import com.speedum.jitsi_lib.API.CommonBody;
import com.speedum.jitsi_lib.API.CommonResponse;
import com.speedum.jitsi_lib.API.Process_ID;
import com.speedum.jitsi_lib.API.ResponseHandling;

import org.jitsi.meet.sdk.JitsiMeet;
import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetActivityDelegate;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;
import org.jitsi.meet.sdk.JitsiMeetUserInfo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Config {

    Context mContext;
    Activity mActivity;
    public static String Base_Url = "";
    public static String AI_Code = "";
    public static String API_Url = "";
    public static String Token = "";
    public static String TOKEN_EXPIRY = "";
    public static String API_Link = "";
    public static String SESSION_CREATE_LINK = "";
    public static String ENVIRONMENT = "";
    public static String DEVICE_TYPE = "";

    public Config(Activity activity) {
        mContext = activity;
        mActivity=activity;
    }


    /*Save globle variables*/
    public void setConfiguration(String base_url, String ai_code, String api_link, String environment, String internal_link, String token, String token_expiry, String deviceType){
        this.Base_Url=base_url;
        this.AI_Code = ai_code;
        this.Base_Url = base_url;
//        this.API_Link = api_link;
        this.API_Link = base_url+api_link;
        this.ENVIRONMENT = environment;
        this.SESSION_CREATE_LINK =internal_link;
//        this.SESSION_CREATE_LINK = base_url+ internal_link;
        this.API_Url = API_Link;
        this.Token = token;
        this.TOKEN_EXPIRY = token_expiry;
        this.DEVICE_TYPE = deviceType;
    }

    public  void startConferenceCall(String conferenceRoomID, String displayName, String email, String meetDomain, String authJWT){

        URL serverURL;
        if (checkNullValue(meetDomain).trim().length()>0){
            try {
                // When using JaaS, replace "https://meet.jit.si" with the proper serverURL
//                serverURL = new URL(Base_Url);
                serverURL = new URL(meetDomain);
//            serverURL = new URL("https://meet.jit.si");
            } catch (MalformedURLException e) {
                e.printStackTrace();
                throw new RuntimeException("Invalid server URL!");
            }


            JitsiMeetConferenceOptions defaultOptions
                    = new JitsiMeetConferenceOptions.Builder()
                    .setServerURL(serverURL)
                    // When using JaaS, set the obtained JWT here
                    .setToken(authJWT)
                    // Different features flags can be set
                    .setFeatureFlag("raise-hand.enabled", false)
                    .setFeatureFlag("invite.enabled", false)
                    .setFeatureFlag("toolbox.enabled", true)
                    .setFeatureFlag("filmstrip.enabled", false)
                    .setFeatureFlag("welcomepage.enabled", false)
                    .build();
            JitsiMeet.setDefaultConferenceOptions(defaultOptions);

            String text = checkNullValue(conferenceRoomID).trim();
            if (text.length() > 0) {
                // Build options object for joining the conference. The SDK will merge the default
                // one we set earlier and this one when joining.
                JitsiMeetUserInfo userInfo=new JitsiMeetUserInfo();
//userInfo.setAvatar();
                userInfo.setDisplayName(checkNullValue(displayName));
//userInfo.setEmail();
                JitsiMeetConferenceOptions options
                        = new JitsiMeetConferenceOptions.Builder()
                        .setRoom(text)
                        .setUserInfo(userInfo)

                        // Settings for audio and video
                        //.setAudioMuted(true)
                        //.setVideoMuted(true)
                        .build();
                // Launch the new activity with the given options. The launch() method takes care
                // of creating the required Intent and passing the options.
                JitsiMeetActivity.launch(mActivity, options);
            }else {
                Toast.makeText(mActivity, "Member name is blank.", Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(mActivity, "Meeting url is blank.", Toast.LENGTH_LONG).show();
        }



    }
    public  void startConferenceCall(String conferenceRoomID,String memberName){

        URL serverURL;
        if (checkNullValue(Base_Url).trim().length()>0){
            try {
                // When using JaaS, replace "https://meet.jit.si" with the proper serverURL
                serverURL = new URL(Base_Url);
//            serverURL = new URL("https://meet.jit.si");
            } catch (MalformedURLException e) {
                e.printStackTrace();
                throw new RuntimeException("Invalid server URL!");
            }


            JitsiMeetConferenceOptions defaultOptions
                    = new JitsiMeetConferenceOptions.Builder()
                    .setServerURL(serverURL)
                    // When using JaaS, set the obtained JWT here
                    //.setToken("MyJWT")
                    // Different features flags can be set
                    .setFeatureFlag("raise-hand.enabled", false)
                    .setFeatureFlag("invite.enabled", false)
                    .setFeatureFlag("toolbox.enabled", true)
                    .setFeatureFlag("filmstrip.enabled", false)
                    .setFeatureFlag("welcomepage.enabled", false)
                    .build();
            JitsiMeet.setDefaultConferenceOptions(defaultOptions);

            String text = checkNullValue(conferenceRoomID).trim();
            if (text.length() > 0) {
                // Build options object for joining the conference. The SDK will merge the default
                // one we set earlier and this one when joining.
                JitsiMeetUserInfo userInfo=new JitsiMeetUserInfo();
//userInfo.setAvatar();
userInfo.setDisplayName(checkNullValue(memberName));
//userInfo.setEmail();
                JitsiMeetConferenceOptions options
                        = new JitsiMeetConferenceOptions.Builder()
                        .setRoom(text)
                        .setUserInfo(userInfo)

                        // Settings for audio and video
                        //.setAudioMuted(true)
                        //.setVideoMuted(true)
                        .build();
                // Launch the new activity with the given options. The launch() method takes care
                // of creating the required Intent and passing the options.
                JitsiMeetActivity.launch(mActivity, options);
            }else {
                Toast.makeText(mActivity, "Member name is blank.", Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(mActivity, "Meeting url is blank.", Toast.LENGTH_LONG).show();
        }

    }


    public void onResume() {
        JitsiMeetActivityDelegate.onHostResume(mActivity);
    }


    public void onStop() {
        JitsiMeetActivityDelegate.onHostPause(mActivity);
    }

    protected void onDestroy() {
//        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
    }

    public String checkNullValue(String value){
        String returnValur=value;
        if (returnValur==null){
            returnValur="";
        }
        return returnValur;
    }

    public String getUrl(String value){
        String returnValur=value;
        if (returnValur==null){
            returnValur="https://meet.jit.si";
        }else if (!returnValur.startsWith("https://")){
            returnValur="http://"+returnValur;
        }
        return returnValur;
    }

    public interface MeetingCallback{
        void inProgress();
        void meetingStart();
        void error(String errorMessage);
    }


    public void startMeating(Context context, String VisitId,String patient_id,String UserRoomName,String MeetUniqueCode, String org_id, String user_id, String role_id,MeetingCallback callback) {
        /*show loader*/
        callback.inProgress();
        API_Body mApi_body = new API_Body();
        String ip = Util.fetch_user_remoteIP(context);
        /*getting token from shared Prefrances*/
        String token = Token;
        token = Util.decryptData(token);
        /*Creating API body*/
        String finalToken = token;
        String finalToken1 = token;
        /*Getting current visit id */
        mApi_body.getJwtTokenBody(patient_id, VisitId,UserRoomName,  MeetUniqueCode, ENVIRONMENT, ip, token, Process_ID.GET_JWT_TOKEN
                , user_id, org_id, role_id, context, new API_Body.CheckSessionCallBack() {
            @Override
            public void sessionIsUpdated(CommonBody body, String finalToken) {

                Call<CommonResponse<GetJWTTokenReturnData>> call = APIManager.getService().getJwtToken(API_Url, body, finalToken);
                call.enqueue(new Callback<CommonResponse<GetJWTTokenReturnData>>() {
                    @Override
                    public void onResponse(Call<CommonResponse<GetJWTTokenReturnData>> call, Response<CommonResponse<GetJWTTokenReturnData>> response) {
                        ResponseHandling responseHandling = new ResponseHandling();
                        responseHandling.checkResponseData(context, response, new ResponseHandling.ResponseCallback() {
                            @Override
                            public void returnData(ArrayList returnData1, List returnData2, String message) {
                                List<GetJWTTokenReturnData> tokenReturnData= returnData2;
                                GetJWTTokenReturnData tokenData=tokenReturnData.get(0);
                                callback.meetingStart();
                                startConferenceCall(checkNullValue(tokenData.getpUserRoomName()),
                                        checkNullValue(tokenData.getpUserDisplayName()),
                                        checkNullValue(tokenData.getpUserEmail()),
                                        getUrl(checkNullValue(tokenData.getpMeetDomain())),
                                        checkNullValue(tokenData.getpAuthJwt())
                                        );
                            }

                            @Override
                            public void errorMessage(String message) {
                                callback.error(message);
//                                Util.showSessionAlert();
                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<CommonResponse<GetJWTTokenReturnData>> call, Throwable t) {
                        callback.error(t.getLocalizedMessage());
                    }
                });
            }

            @Override
            public void errorGettingNewToken(String Title, String message) {
                callback.error(message);
            }
        });
    }

}
