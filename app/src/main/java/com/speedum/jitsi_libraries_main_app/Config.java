package com.speedum.jitsi_libraries_main_app;

public class Config {
    public static String DEVICE_TYPE="ANDROID_PATIENT";
    public static String NEW_INTERNAL="https://ppe-sgint-mindemr.speedum.tech/";
    public static boolean isTwoFactorAuthEnabled=false;
    /*Setting working environment of app */
    static ENVIRONMENT Mode= ENVIRONMENT.MIND_EMR;



    private enum ENVIRONMENT{
        WELMIND_DEV,DEV,NEW_DEV,QA_SERVER,QA_MIND_EMR,WELMIND,DEMO_SERVER,MIND_EMR
    }

    /*Getting AI_CODE for apis*/
    public static String getAI_CODE(){
        if (Mode== ENVIRONMENT.NEW_DEV){
            return "TELEHEALTH";
        }else  if (Mode== ENVIRONMENT.MIND_EMR){
            return "TELEHEALTH";
        }else  if (Mode== ENVIRONMENT.WELMIND_DEV){
            return "WELMIND";
        }else if (Mode== ENVIRONMENT.WELMIND){
            return "WELMIND";
        }else if (Mode== ENVIRONMENT.QA_SERVER){
            return "TELEHEALTH";
        }else if (Mode== ENVIRONMENT.QA_MIND_EMR){
            return "TELEHEALTH";
        }else if (Mode== ENVIRONMENT.DEMO_SERVER){
            return "TELEHEALTH";
        }else {
            return "TELEHEALTH";
        }
    }

    /*Getting environment for apis*/
    public static String getEnvironMent(){
        if (Mode== ENVIRONMENT.NEW_DEV){
            return "VDENT";
        }else  if (Mode== ENVIRONMENT.MIND_EMR){
            return "VDENT";
        }else  if (Mode== ENVIRONMENT.WELMIND_DEV){
//            return "TELEHEALTH";
            return "VDENT";
        }else if (Mode== ENVIRONMENT.WELMIND){
//            return "WELMIND";
            return "VDENT";
        }else if (Mode== ENVIRONMENT.QA_SERVER){
            return "VDENT";
        }else if (Mode== ENVIRONMENT.QA_MIND_EMR){
            return "TELEHEALTH";
        }else if (Mode== ENVIRONMENT.DEMO_SERVER){
            return "TELEHEALTH";
        }else {
            return "VDENT";
        }
    }

    /*Getting screening url*/
    public static String getScreeningUrl(){
        if (Mode== ENVIRONMENT.NEW_DEV){
            return getBaseURl()+"patientportalmindemr/screening_view/index";
        }else  if (Mode== ENVIRONMENT.MIND_EMR){
            return getBaseURl()+"patientportalmindemr/screening_view/index";
        }else  if (Mode== ENVIRONMENT.WELMIND_DEV){
//            return "TELEHEALTH";
            return getBaseURl()+"patientportalmindemr/screening_view/index";
        }else if (Mode== ENVIRONMENT.WELMIND){
//            return getBaseURl()+"patientportalmindemr/screening_view/index";
            return getBaseURl()+"patientportal/screening_view/index";
        }else if (Mode== ENVIRONMENT.QA_SERVER){
            return getBaseURl()+"patientportalmindemr/screening_view/index";
        }else if (Mode== ENVIRONMENT.QA_MIND_EMR){
            return getBaseURl()+"patientportalmindemr/screening_view/index";
        }else if (Mode== ENVIRONMENT.DEMO_SERVER){
            return getBaseURl()+"patientportalmindemr/screening_view/index";
        }else {
            return getBaseURl()+"patientportalmindemr/screening_view/index";
        }
    }

    /*Getting URl for Upload files*/
    public static String getUploadFileURl(){
        if (Mode== ENVIRONMENT.NEW_DEV){
            return "https://mobile.speedum.tech/teleHealth/upload_by_parts.php";
//            return "https://dev.speedum.tech/teleHealth/upload_by_parts.php";
        }else  if (Mode== ENVIRONMENT.MIND_EMR){
            return "https://preprodmindemrapp.speedum.tech/teleHealth/upload_by_parts.php";
        }else if (Mode== ENVIRONMENT.WELMIND_DEV){
            return "https://mobile.speedum.tech/teleHealth/upload_by_parts.php";
//            return "https://dev.speedum.tech/teleHealth/upload_by_parts.php";
        }else if (Mode== ENVIRONMENT.QA_SERVER){
            return "https://qa.speedum.tech/teleHealth/upload_by_parts.php";
        }else if (Mode== ENVIRONMENT.QA_MIND_EMR){
            return "https://qamindemr.speedum.tech/teleHealth/upload_by_parts.php";
        }else if (Mode== ENVIRONMENT.WELMIND){
            return "https://welmind.speedum.tech/teleHealth/upload_by_parts.php";
//            return "http://144.168.162.166:8104/teleHealth/upload_by_parts.php";
        }else if (Mode== ENVIRONMENT.DEMO_SERVER){
            return "https://dev.speedum.tech/teleHealth/upload_by_parts.php";
//            return "https:/demo.speedum.tech/teleHealth/upload_by_parts.php";
        }else {
            return "https://dev.speedum.tech/teleHealth/upload_by_parts.php";
        }
    }



    /*Getting URl for Upload files*/
    public static String getFileURlPath(){
        if (Mode== ENVIRONMENT.NEW_DEV){
            return "https://mobile.speedum.tech/teleHealth/";
//            return "https://dev.speedum.tech/teleHealth/";
        }else if (Mode== ENVIRONMENT.MIND_EMR){
            return "https://preprodmindemrapp.speedum.tech/teleHealth/";
        }else if (Mode== ENVIRONMENT.WELMIND_DEV){
            return "https://mobile.speedum.tech/teleHealth/";
//            return "https://dev.speedum.tech/teleHealth/";
        }else if (Mode== ENVIRONMENT.QA_SERVER){
            return "https://qa.speedum.tech/teleHealth/";
        }else if (Mode== ENVIRONMENT.QA_MIND_EMR){
            return "https://qamindemr.speedum.tech/teleHealth/";
        }else if (Mode== ENVIRONMENT.WELMIND){
            return "https://welmind.speedum.tech/teleHealth/";
        }else if (Mode== ENVIRONMENT.DEMO_SERVER){
//            return "https:/demo.speedum.tech/teleHealth/";
            return "https://dev.speedum.tech/teleHealth/";
        }else {
            return "https://dev.speedum.tech/teleHealth/";
        }
    }

    /*Getting Powered By text*/
    public static String getPoweredBy(){
        if (Mode== ENVIRONMENT.NEW_DEV){
            return "Speedum";
        }else  if (Mode== ENVIRONMENT.MIND_EMR){
            return "Welmind";
        }else  if (Mode== ENVIRONMENT.WELMIND_DEV){
            return "Welmind";
        }else if (Mode== ENVIRONMENT.WELMIND){
            return "Welmind";
        }else if (Mode== ENVIRONMENT.QA_SERVER){
            return "Speedum";
        }else if (Mode== ENVIRONMENT.DEMO_SERVER){
            return "Speedum";
        }else {
            return "Speedum";
        }
    }


    /*Getting BaseURl for apis*/
    public static String getBaseURl(){
        if (Mode== ENVIRONMENT.NEW_DEV){
            return "https://mobile.speedum.tech/";
//            return "https://dev.speedum.tech/";
        }else if (Mode== ENVIRONMENT.MIND_EMR){
            return "https://preprodmindemrapp.speedum.tech/";
        }else if (Mode== ENVIRONMENT.WELMIND_DEV){
            return "https://mobile.speedum.tech/";
//            return "https://dev.speedum.tech/";
        }else if (Mode== ENVIRONMENT.WELMIND){
//            return "http://144.168.162.166:8104/";
            return "https://welmind.speedum.tech/";
        }else if (Mode== ENVIRONMENT.QA_SERVER){
            return "https://qa.speedum.tech/";
        }else if (Mode== ENVIRONMENT.QA_MIND_EMR){
            return "https://qamindemr.speedum.tech/";
        }else if (Mode== ENVIRONMENT.DEMO_SERVER){
            return "https://demo.speedum.tech/";
        }else {
            return "http://144.168.164.102:8100/";
        }
    }


    /*Getting API link for apis*/
    public static String getAPI_BaseURl(){
        if (Mode== ENVIRONMENT.NEW_DEV){
            return getBaseURl()+"suggestusUltraV2/";
        }else if (Mode== ENVIRONMENT.MIND_EMR){
            return getBaseURl()+"suggestusUltra/";
        }else if (Mode== ENVIRONMENT.QA_SERVER){
            return getBaseURl()+"suggestusUltraV2/";
        }else if (Mode== ENVIRONMENT.WELMIND_DEV){
            return getBaseURl()+"suggestusUltraV2/";
//            return "suggestusUltra/suggestus";
        }else if (Mode== ENVIRONMENT.WELMIND){
            return getBaseURl()+"suggestusUltra/";
        }else if (Mode== ENVIRONMENT.QA_MIND_EMR){
            return getBaseURl()+"suggestusUltraV2/";
        }else if (Mode== ENVIRONMENT.DEMO_SERVER){
            return getBaseURl()+"suggestusUltraV2/";
        }else {
            return getBaseURl()+"suggestusUltraV2/";
        }
    }
    /*Getting API link for apis*/
    public static String getAPI_Link(){
        if (Mode== ENVIRONMENT.NEW_DEV){
            return "suggestusUltraV2/suggestus";
        }else if (Mode== ENVIRONMENT.MIND_EMR){
            return "suggestusUltra/suggestus";
        }else if (Mode== ENVIRONMENT.QA_SERVER){
            return "suggestusUltraV2/suggestus";
        }else if (Mode== ENVIRONMENT.WELMIND_DEV){
            return "suggestusUltraV2/suggestus";
//            return "suggestusUltra/suggestus";
        }else if (Mode== ENVIRONMENT.WELMIND){
            return "suggestusUltra/suggestus";
        }else if (Mode== ENVIRONMENT.QA_MIND_EMR){
            return "suggestusUltraV2/suggestus";
        }else if (Mode== ENVIRONMENT.DEMO_SERVER){
            return "suggestusUltraV2/suggestus";
        }else {
            return "suggestusUltraV2/suggestus";
        }
    }

    /*Getting API link for apis*/
    public static String getINTERNAL_link(){
        if (Mode== ENVIRONMENT.NEW_DEV){
            return "suggestusUltraV2/suggestus/internal";
//            return "suggestusUltra/suggestus/internal";
        }else if (Mode== ENVIRONMENT.MIND_EMR){
            return "suggestusUltra/suggestus/internal";
        }else if (Mode== ENVIRONMENT.QA_SERVER){
            return "suggestusUltraV2/suggestus/internal";
        }else if (Mode== ENVIRONMENT.WELMIND_DEV){
            return "suggestusUltraV2/suggestus/internal";
//            return "suggestusUltra/suggestus/internal";
//            return "suggestusUltra/suggestus/internal";
        }else if (Mode== ENVIRONMENT.WELMIND){
            return "suggestusUltra/suggestus/internal";
        }else if (Mode== ENVIRONMENT.QA_MIND_EMR){
            return "suggestusUltraV2/suggestus/internal";
        }else if (Mode== ENVIRONMENT.DEMO_SERVER){
            return "suggestusUltraV2/suggestus/internal";
        }else {
            return "suggestusUltraV2/suggestus/internal";
        }
    }

    /*Getting BaseURl for apis*/
    public static String getCourseURl(){
        if (Mode== ENVIRONMENT.NEW_DEV){
            return "https://dev.speedum.tech/lms_access/?";
        }else if (Mode== ENVIRONMENT.MIND_EMR){
            return "https://preprodmindemrapp.speedum.tech/lms_access/?";
        }else if (Mode== ENVIRONMENT.WELMIND_DEV){
            return "https://dev.speedum.tech/lms_access/?";
        }else if (Mode== ENVIRONMENT.WELMIND){
            return "https://welmind.speedum.tech/lms_access/?";
        }else if (Mode== ENVIRONMENT.QA_SERVER){
            return "https://qa.speedum.tech/lms_access/?";
        }else if (Mode== ENVIRONMENT.QA_MIND_EMR){
            return "https://qamindemr.speedum.tech/lms_access/?";
        }else if (Mode== ENVIRONMENT.DEMO_SERVER){
            return "https://demo.speedum.tech/lms_access/?";
        }else {
            return "https://dev.speedum.tech/lms_access/?";
        }
    }


    /*Quickblox config*/
    /*Getting APP_ID*/
    public static String getAPP_ID(){
        if (Mode== ENVIRONMENT.NEW_DEV){
            return "22";
        }else if (Mode== ENVIRONMENT.MIND_EMR){
            return "32";
        }else if (Mode== ENVIRONMENT.WELMIND_DEV){
            return "22";
        }else if (Mode== ENVIRONMENT.WELMIND){
            return "29";
        }else if (Mode== ENVIRONMENT.QA_SERVER){
            return "24";
        }else if (Mode== ENVIRONMENT.DEMO_SERVER){
            return "25";
        }else {
            return "22";
        }
    }


    /*Getting AUTH_KEY*/
    public static String getAUTH_KEY(){
        if (Mode== ENVIRONMENT.NEW_DEV){
            return "vVb7pDYrHkPD-ab";
        }else if (Mode== ENVIRONMENT.MIND_EMR){
            return "5r8TeuJTw5y3ZuP";
        }else if (Mode== ENVIRONMENT.WELMIND_DEV){
            return "vVb7pDYrHkPD-ab";
        }else if (Mode== ENVIRONMENT.WELMIND){
            return "8aMTDFgJWT9ejQ4";
        }else if (Mode== ENVIRONMENT.QA_SERVER){
            return "YH7XHHX-EQfqRPA";
        }else if (Mode== ENVIRONMENT.DEMO_SERVER){
            return "eG5CKb6qq36yvvu";
        }else {
            return "vVb7pDYrHkPD-ab";
        }
    }


    /*Getting AUTH_SECRET*/
    public static String getAUTH_SECRET(){
        if (Mode== ENVIRONMENT.NEW_DEV){
            return "YPP5ZNM2WRBGzD3";
        }else if (Mode== ENVIRONMENT.MIND_EMR){
            return "FSuaGrLBnXMq5Yz";
        }else if (Mode== ENVIRONMENT.WELMIND_DEV){
            return "YPP5ZNM2WRBGzD3";
        }else if (Mode== ENVIRONMENT.WELMIND){
            return "XyLUDjhWCD5rGdO";
        }else if (Mode== ENVIRONMENT.QA_SERVER){
            return "gjuPa5AbtMC5ZDh";
        }else if (Mode== ENVIRONMENT.DEMO_SERVER){
            return "UCze2Dun7DdPD5y";
        }else {
            return "YPP5ZNM2WRBGzD3";
        }
    }

    /*Getting ACCOUNT_KEY*/
    public static String getACCOUNT_KEY(){
        if (Mode== ENVIRONMENT.NEW_DEV){
            return "Hf12BgmaC1hew9AxZHU6";
        }else if (Mode== ENVIRONMENT.MIND_EMR){
            return "Hf12BgmaC1hew9AxZHU6";
        }else if (Mode== ENVIRONMENT.WELMIND_DEV){
            return "Hf12BgmaC1hew9AxZHU6";
        }else if (Mode== ENVIRONMENT.WELMIND){
            return "Hf12BgmaC1hew9AxZHU6";
        }else if (Mode== ENVIRONMENT.QA_SERVER){
            return "Hf12BgmaC1hew9AxZHU6";
        }else if (Mode== ENVIRONMENT.DEMO_SERVER){
            return "Hf12BgmaC1hew9AxZHU6";
        }else {
            return "Hf12BgmaC1hew9AxZHU6";
        }
    }

    /*Getting API_DOMAIN*/
    public static String getAPI_DOMAIN(){
        if (Mode== ENVIRONMENT.NEW_DEV){
            return "https://apispeedum.quickblox.com";
        }else if (Mode== ENVIRONMENT.MIND_EMR){
            return "https://apispeedum.quickblox.com";
        }else if (Mode== ENVIRONMENT.WELMIND_DEV){
            return "https://apispeedum.quickblox.com";
        }else if (Mode== ENVIRONMENT.WELMIND){
            return "https://apispeedum.quickblox.com";
        }else if (Mode== ENVIRONMENT.QA_SERVER){
            return "https://apispeedum.quickblox.com";
        }else if (Mode== ENVIRONMENT.DEMO_SERVER){
            return "https://apispeedum.quickblox.com";
        }else {
            return "https://apispeedum.quickblox.com";
        }
    }

    /*Getting CHAT_DOMAIN */
    public static String getCHAT_DOMAIN(){
        if (Mode== ENVIRONMENT.NEW_DEV){
            return "chatspeedum.quickblox.com";
        }else if (Mode== ENVIRONMENT.MIND_EMR){
            return "chatspeedum.quickblox.com";
        }else if (Mode== ENVIRONMENT.WELMIND_DEV){
            return "chatspeedum.quickblox.com";
        }else if (Mode== ENVIRONMENT.WELMIND){
            return "chatspeedum.quickblox.com";
        }else if (Mode== ENVIRONMENT.QA_SERVER){
            return "chatspeedum.quickblox.com";
        }else if (Mode== ENVIRONMENT.DEMO_SERVER){
            return "chatspeedum.quickblox.com";
        }else {
            return "chatspeedum.quickblox.com";
        }
    }

    /*Getting CHAT_DOMAIN */
    public static String getJANUS_SERVER_DOMAIN(){
        if (Mode== ENVIRONMENT.NEW_DEV){
//            return "wss://groupcallsspeedum.quickblox.com:8989";
            return "wss://newgroupcallsspeedum.quickblox.com";
        }else if (Mode== ENVIRONMENT.MIND_EMR){
            return "wss://newgroupcallsspeedum.quickblox.com";
        }else if (Mode== ENVIRONMENT.WELMIND_DEV){
//            return "wss://groupcallsspeedum.quickblox.com:8989";
            return "wss://newgroupcallsspeedum.quickblox.com";
        }else if (Mode== ENVIRONMENT.WELMIND){
//            return "wss://groupcallsspeedum.quickblox.com:8989";
            return "wss://newgroupcallsspeedum.quickblox.com";
        }else if (Mode== ENVIRONMENT.QA_SERVER){
//            return "wss://groupcallsspeedum.quickblox.com:8989";
            return "wss://newgroupcallsspeedum.quickblox.com";
        }else if (Mode== ENVIRONMENT.DEMO_SERVER){
//            return "wss://groupcallsspeedum.quickblox.com:8989";
            return "wss://newgroupcallsspeedum.quickblox.com";
        }else {
//            return "wss://groupcallsspeedum.quickblox.com:8989";
            return "wss://newgroupcallsspeedum.quickblox.com";
        }
    }

    /*Getting Conference Domain */
    public static String getConference_DOMAIN(){
        if (Mode==ENVIRONMENT.NEW_DEV){
            return "wss://newgroupcallsspeedum.quickblox.com";  //New url 05_07_2021
        }/*else  if (Mode== ENVIRONMENT.ACTUM_PRE_PROD){
            return "wss://newgroupcallsspeedum.quickblox.com";
        }else  if (Mode== ENVIRONMENT.ACTUM_PRE_PROD1){
            return "wss://newgroupcallsspeedum.quickblox.com";
        }*/else if (Mode==ENVIRONMENT.MIND_EMR){
            return "wss://newgroupcallsspeedum.quickblox.com";
        }else if (Mode==ENVIRONMENT.WELMIND){
//            return "wss://groupcallsspeedum.quickblox.com:8989";
            return "wss://newgroupcallsspeedum.quickblox.com";
        }else if (Mode==ENVIRONMENT.WELMIND_DEV){
//            return "wss://groupcallsspeedum.quickblox.com:8989";
            return "wss://newgroupcallsspeedum.quickblox.com"; //New url 05_07_2021
        }else if (Mode==ENVIRONMENT.QA_SERVER){
            return "wss://groupcallsspeedum.quickblox.com:8989";
        }else {
            return "wss://groupcallsspeedum.quickblox.com:8989";
        }
    }

    /*Getting URl for Upload files*/
    public static String getMeetingURl(){
        if (Mode== ENVIRONMENT.NEW_DEV){
            return "https://dev.speedum.tech/teleHealth/joinmeeting/";
        }/*else  if (Mode== ENVIRONMENT.ACTUM_PRE_PROD){
            return "https://qamindemr.speedum.tech/telehealth/joinmeeting/";
        }else  if (Mode== ENVIRONMENT.ACTUM_PRE_PROD1){
            return "https://preprodmindemr.speedum.tech/telehealth/joinmeeting/";
        }*/else if (Mode== ENVIRONMENT.MIND_EMR){
            return "https://preprodmindemrapp.speedum.tech/telehealth/joinmeeting/";
//            return "https://dev.speedum.tech/teleHealth/joinmeeting/";
        }else if (Mode== ENVIRONMENT.WELMIND_DEV){
            return "https://dev.speedum.tech/teleHealth/joinmeeting/";
        }else if (Mode== ENVIRONMENT.QA_SERVER){
            return "https://dev.speedum.tech/teleHealth/joinmeeting/";
        }else if (Mode== ENVIRONMENT.WELMIND){
            return "http://144.168.162.166:8104/teleHealth/joinmeeting/";
        }else {
            return "https://dev.speedum.tech/teleHealth/joinmeeting/";
        }
    }

}
