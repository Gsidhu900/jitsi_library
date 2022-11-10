package com.speedum.jitsi_libraries_main_app.Util;

import com.speedum.jitsi_libraries_main_app.Config;

public final class config {

    private config() {
    }
    public static final String YOUTUBE_API_KEY = "AIzaSyBbzm_V_8uraXa_PnR5QqyZ376WJQbR5fQ";
//    public static final String AI_CODE = "TELEHEALTH";
    public static final String AI_CODE = Config.getAI_CODE();
//    public static final String AI_CODE = "VDENT";
//    public static final String ENVIRONMENT = "VDENT";
    public static final String ENVIRONMENT =  Config.getEnvironMent();
    public static final String CODE_PASS = "t4vo8jkek";
    public static final String QB_PASS = "12345678";


    // global topic to receive app wide push notifications
    public static final String TOPIC_GLOBAL = "global";

    // broadcast receiver intent filters
    public static final String REGISTRATION_COMPLETE = "registrationComplete";
    public static final String PUSH_NOTIFICATION = "pushNotification";
    public static final String CHAT_LOGIN_SUCCESS = "CHAT_LOGGED_IN";

    // id to handle the notification in the notification tray
    public static final int NOTIFICATION_ID = 100;
    public static final int NOTIFICATION_ID_BIG_IMAGE = 101;

    public static final String SHARED_PREF = "ah_firebase";
}
