package com.speedum.jitsi_libraries_main_app.UI.Activities.Splash_Screen.Splash_Screen_View;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Html;
import android.text.format.Formatter;
import android.util.Log;

import com.speedum.jitsi_libraries_main_app.API.APIModels.Foot_Print.FootPrintBody;
import com.speedum.jitsi_libraries_main_app.API.APIModels.Session_Token.SessionTokenBody;
import com.speedum.jitsi_libraries_main_app.API.API_Body;
import com.speedum.jitsi_libraries_main_app.API.Comman_Data.CommonBody;
import com.speedum.jitsi_libraries_main_app.API.Process_ID;
import com.speedum.jitsi_libraries_main_app.Config;
import com.speedum.jitsi_libraries_main_app.DB.DB_Queries;
import com.speedum.jitsi_libraries_main_app.DB.sharedPrefrances;
import com.speedum.jitsi_libraries_main_app.R;
import com.speedum.jitsi_libraries_main_app.UI.Activities.HomeScreen.View.HomeScreen;
import com.speedum.jitsi_libraries_main_app.UI.Activities.Login_Screen.Login_View.Login_View;
import com.speedum.jitsi_libraries_main_app.UI.Activities.Splash_Base_Activity;
import com.speedum.jitsi_libraries_main_app.UI.Activities.Splash_Screen.Splash_Screen_Presenter.Splash_Screen_Presenter;
import com.speedum.jitsi_libraries_main_app.Util.MyLoader;
import com.speedum.jitsi_libraries_main_app.Util.MyTextView_Regular;
import com.speedum.jitsi_libraries_main_app.Util.Util;
import com.speedum.jitsi_libraries_main_app.Util.config;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;

@SuppressLint("MissingPermission")
public class Splash_Screen_View extends Splash_Base_Activity implements ISplash_Screen_View {

    @BindView(R.id.AVLoadingIndicatorView)
    MyLoader mMyLoader;

    @BindView(R.id.MyTextView_RegulargetPoweredBy)
    MyTextView_Regular mMyTextView_RegulargetPoweredBy;

    private Splash_Screen_Presenter mSplash_screen_presenter;

    private String mDialog_ID="";
    private boolean isToOpenChat=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*Initializing presenter for the view*/
        if (getLastNonConfigurationInstance() instanceof Splash_Screen_Presenter) {
            mSplash_screen_presenter = (Splash_Screen_Presenter) getLastNonConfigurationInstance();
        }
        if (mSplash_screen_presenter == null) {
            mSplash_screen_presenter = new Splash_Screen_Presenter(this, Splash_Screen_View.this, mDbHelper);
        }

        Intent intent=getIntent();
        if (intent.hasExtra("dialog_id")&&Util.CheckForNullValue(intent.getStringExtra("dialog_id")).trim().length()>0
                &&intent.hasExtra("Open_Chat")&&intent.getStringExtra("Open_Chat").equalsIgnoreCase("Yes")){
            isToOpenChat=true;
            mDialog_ID=Util.CheckForNullValue(intent.getStringExtra("dialog_id"));
            Log.e("Splash_Screen "," mDialog_ID "+mDialog_ID);
        }
        /*App Powered By*/
        /**/
        if (mColorConfigModel != null && mColorConfigModel.getAppDefaultColor() != null && !mColorConfigModel.getAppDefaultColor().trim().equalsIgnoreCase(""))
            mMyLoader.setIndecatorColor(mColorConfigModel.getAppDefaultColor());
        /*register application footprint*/
        createFootPrint();
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_splash_screen_view;
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return mSplash_screen_presenter;
    }

    /*create Foot print on server*/

    private void createFootPrint() {
        String versionRelease = "";
        String androidId = "";
        String ip = "";
        try {
            versionRelease = Build.VERSION.RELEASE;
            /*getting unique id*/
            androidId = Settings.Secure.getString(getContentResolver(),
                    Settings.Secure.ANDROID_ID);
            WifiManager wm = (WifiManager) this.getApplicationContext().getSystemService(WIFI_SERVICE);
            ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
        androidId=androidId+"963";
        /*creating foot print body*/
        FootPrintBody footPrintBody = mApi_body.get_FootPrint_Body(config.AI_CODE, Config.DEVICE_TYPE, "ANDROID", versionRelease, androidId, ip);
        /*Calling API on server*/
        mSplash_screen_presenter.createFootPrint(footPrintBody);
    }


    /*create session on server*/
    private void createSession() {
        String versionRelease = "";
        String androidId = "";
        String ip = "";
        try {
            versionRelease = Build.VERSION.RELEASE;
            /*getting unique id*/
            androidId = Settings.Secure.getString(getContentResolver(),
                    Settings.Secure.ANDROID_ID);
            WifiManager wm = (WifiManager) this.getApplicationContext().getSystemService(WIFI_SERVICE);
            ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
        androidId=androidId+"963";
        /*creating foot print body*/
        SessionTokenBody sessionTokenBody = mApi_body.get_Session_Body(config.AI_CODE, Config.DEVICE_TYPE, "ANDROID", versionRelease, androidId, ip);
        /*Calling API on server*/
        mSplash_screen_presenter.createSession(sessionTokenBody);
    }

    /* fetch password policy from server*/
    private void fetchApplicationUpgradeFromServer() {
        CallNextActivity();
//        getColorConfig();
    }

    /*Get Color config from server*/
    private void getColorConfig() {
        String org = "";
        if (Util.isInternetOn(this)) {
            String ip = Util.fetch_user_remoteIP(this);
            /*getting token from shared Prefrances*/
            String token = sharedPrefrances.getSessionToken(this);
            token = Util.decryptData(token);
            /*creating login body*/
           mApi_body.getColorConfigBody(config.AI_CODE, config.ENVIRONMENT, ip, token, Process_ID.GetColorConfig, org, this, new API_Body.CheckSessionCallBack() {
               @Override
               public void sessionIsUpdated(CommonBody body) {
                   /*getting token from shared Prefrances*/
                   String token = sharedPrefrances.getSessionToken(Splash_Screen_View.this);
                   token = Util.decryptData(token);
                   /*calling api on server*/
                   mSplash_screen_presenter.getColorConfig(body, token);
               }

               @Override
               public void errorGettingNewToken(String Title, String message) {
                   showAlertMessage(Title, message, new AlertMessageCallback() {
                       @Override
                       public void OnButtonPress() {

                       }
                   });
               }
           });
        }

    }

    /*Getting org info*/
    private void getOrgInfo() {
        String org_id = "";
        String user_id = "";
        String patient_id = "";
        String role_id = "";
        String ip = "";
        /*getting token from shared Prefrances*/
        String token = sharedPrefrances.getSessionToken(this);
        token = Util.decryptData(token);
        /*creating GetOrgIDBody body*/
        String finalToken = token;
        mApi_body.getGetOrgIDBody(role_id, config.ENVIRONMENT, ip, token, Process_ID.GetOrgID, user_id, org_id, this, patient_id, new API_Body.CheckSessionCallBack() {
            @Override
            public void sessionIsUpdated(CommonBody body) {
                /*calling api on server*/
                mSplash_screen_presenter.getOrgInfoFromServer(body, finalToken);
            }

            @Override
            public void errorGettingNewToken(String Title, String message) {
                showAlertMessage(Title, message, new AlertMessageCallback() {
                    @Override
                    public void OnButtonPress() {

                    }
                });
            }
        });

    }

    /*Set color config*/
    private void getHomeScrenConfig() {
        String token = sharedPrefrances.getSessionToken(Splash_Screen_View.this);
        CommonBody bodyaa=new CommonBody();
        mSplash_screen_presenter.getHomeScrenConfig(bodyaa, token);
        Util.isInternetOn(this, new Util.InternetCheckCallback() {
            @Override
            public void hasInternetConnection() {

                String token = sharedPrefrances.getSessionToken(Splash_Screen_View.this);
                token = Util.decryptData(token);
                String ip = Util.fetch_user_remoteIP(Splash_Screen_View.this);
                String org_ID = "";

//        String org_ID= Util.decryptData(mSplash_screen_presenter.getUserIDFromDB(DB_Queries.get_org_id));
                String finalToken = token;
                mApi_body.getHomeScreenConfigBody("", "", "", config.AI_CODE, config.ENVIRONMENT, ip, token, Process_ID.GetHomeScreenConfig, org_ID, Splash_Screen_View.this, new API_Body.CheckSessionCallBack() {
                    @Override
                    public void sessionIsUpdated(CommonBody body) {
                        /*calling api on server*/
                        mSplash_screen_presenter.getHomeScrenConfig(body, finalToken);
                    }

                    @Override
                    public void errorGettingNewToken(String Title, String message) {
                        showAlertMessage(Title, message, new AlertMessageCallback() {
                            @Override
                            public void OnButtonPress() {

                            }
                        });
                    }
                });

            }

            @Override
            public void noInterNetConnection(String message) {
                showAlertMessage(message);
            }
        });
    }

    private void FootPrintDialog(String MSG) {
        AlertDialog alertDialog = new AlertDialog.Builder(
                this).create();
        alertDialog.setCancelable(true);
        // Setting Dialog Title
        alertDialog.setTitle("Alert!");
        // Setting Dialog Message
        alertDialog.setMessage(MSG);
        // Setting OK Button
        alertDialog.setButton2("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        // Showing Alert Message
        alertDialog.show();
    }

    private void CallNextActivity() {
        int FirstRun = sharedPrefrances.getFirstRun(Splash_Screen_View.this);
        /*calling home Screen*/
        if (FirstRun == 0) {
            Intent intent = new Intent(Splash_Screen_View.this, Login_View.class);
            startActivity(intent);
            finishAffinity();
        } else {
            String unReadCount = Util.CheckForNullValue(mSplash_screen_presenter.getLastMsgID(DB_Queries.get_unread_count));
            sharedPrefrances.saveUnReadMessagCount(Splash_Screen_View.this, unReadCount);
            String user_rol = Util.decryptData(mSplash_screen_presenter.getLastMsgID(DB_Queries.get_user_rol));
            String usrOnboardingStatus = Util.decryptData(mSplash_screen_presenter.getLastMsgID(DB_Queries.get_user_onboarding_status));
            /*checking user role*/
            Intent intent = new Intent(Splash_Screen_View.this, HomeScreen.class);
            if (isToOpenChat){
                intent.putExtra("Open_Chat", "Yes");
                intent.putExtra("dialog_id", mDialog_ID);
            }
            startActivity(intent);
            finishAffinity();

        }

    }

    @Override
    public void createFootPrintSuccess() {
        /*calling API on server to get session token*/
        createSession();
    }

    @Override
    public void createFootPrintError(String msg) {
        FootPrintDialog(msg);
    }

    @Override
    public void createSessionSuccess() {
//        getColorConfig();
        if (checkSynced()) {/*this loop called when ever date changes*/
            /*Hit API and getting Static data from Back end*/
            fetchApplicationUpgradeFromServer();
            /*saving date for compare*/
            sharedPrefrances.saveAppUpgradeTime(Splash_Screen_View.this, Calendar
                    .getInstance().getTimeInMillis());
        } else {
            int mandatory_update = sharedPrefrances.getMandatoryUpdate(Splash_Screen_View.this);
            if (mandatory_update == 0) {
//                getHomeScrenConfig();
//                getColorConfig();
                CallNextActivity();
            } else {
                fetchApplicationUpgradeFromServer();
            }
        }
    }

    @Override
    public void createSessionError(String msg) {
        FootPrintDialog(msg);
    }



    @Override
    public void fetchAppUpgradeError(String msg) {

    }

    @Override
    public void getColorConfigSuccess() {
        getOrgInfo();

//        getHomeScrenConfig();
//        CallNextActivity();
    }

    @Override
    public void getColorConfigError(String message) {
    }

    @Override
    public void homeScreenCongifSuccess() {
        CallNextActivity();
    }

    @Override
    public void homeScreenOrgInfoSuccess() {
        getHomeScrenConfig();
    }

    /*password Validation Alert*/
    private void mandatoryUpgradeAlert(Context context, String msg, String url) {
        AlertDialog alertDialog = new AlertDialog.Builder(
                context).create();
        alertDialog.setCancelable(false);
        // Setting Dialog Title
        alertDialog.setTitle("Upgrade Alert!");
        // Setting Dialog Message
        alertDialog.setMessage(Html.fromHtml(msg));
        // Setting OK Button
        alertDialog.setButton2("Upgrade", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Uri uri = Uri.parse(url); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                finishAffinity();
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }

    /*password Validation Alert*/
    private void mildUpgradeAlert(Context context, String msg, String url) {
        AlertDialog alertDialog = new AlertDialog.Builder(
                context).create();
        alertDialog.setCancelable(false);
        // Setting Dialog Title
        alertDialog.setTitle("Upgrade Alert!");
        // Setting Dialog Message
        alertDialog.setMessage(Html.fromHtml(msg));
        // Setting OK Button
        alertDialog.setButton("Later", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                CallNextActivity();
            }
        });
        alertDialog.setButton2("Upgrade Now", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Uri uri = Uri.parse(url); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                finishAffinity();
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }

    private boolean checkSynced() {// this functions check if date has changed or not if changed then it return true
        long reloadTime = sharedPrefrances.getAppUpgradeTime(Splash_Screen_View.this);

        Date reload_date = new Date(reloadTime);

        Date today = new Date();
        if (today.getYear() != reload_date.getYear()
                || today.getMonth() != reload_date.getMonth()
                || today.getDate() != reload_date.getDate()) {
            return true;
        } else {
            return false;
        }
    }

}
