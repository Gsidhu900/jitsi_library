package com.speedum.jitsi_lib.Utils;

import android.app.Activity;
import android.content.Context;

import org.jitsi.meet.sdk.JitsiMeetActivityDelegate;

import java.util.List;

public class JitsiConferenceConfig {

    Context mContext;
    Activity mActivity;
    Config mConfig;

    /*Save links in local db and globle variables*/
    public void setConfiguration(Activity activity, String base_url, String ai_code, String api_link, String environment, String internal_link, String token, String token_expiry, String deviceType) {
        mContext = activity;
        mActivity = activity;
        mConfig = new Config(mActivity);
        mConfig.setConfiguration(base_url, ai_code, api_link, environment, internal_link, token, token_expiry, deviceType);
    }

    //  /*Save links in local db and globle variables*/
//    public void setConfiguration(Activity activity, String base_url) {
//        mContext = activity;
//        mActivity = activity;
//        mConfig = new Config(mActivity);
//        mConfig.setConfiguration(base_url);
//    }
//
    public void startConferenceCall(String conferenceRoomID, String memberName) {
        mConfig.startConferenceCall(conferenceRoomID, memberName);
    }

    public void startConferenceCall(String conferenceRoomID, String displayName, String email, String meetDomain, String authJWT) {
        mConfig.startConferenceCall(conferenceRoomID, displayName, email, meetDomain, authJWT);
    }

    public void startMeating(Context context, String VisitId, String patient_id, String UserRoomName, String MeetUniqueCode, String org_id, String user_id, String role_id, Config.MeetingCallback callback) {
        mConfig.startMeating(context, VisitId, patient_id, UserRoomName, MeetUniqueCode, org_id, user_id, role_id,callback);

    }

    public void onResume() {
        mConfig.onResume();
    }


    public void onStop() {
        mConfig.onStop();
    }

}
