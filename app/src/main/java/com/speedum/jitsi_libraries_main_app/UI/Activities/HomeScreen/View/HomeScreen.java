package com.speedum.jitsi_libraries_main_app.UI.Activities.HomeScreen.View;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.google.firebase.iid.FirebaseInstanceId;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
//import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.Gson;
import com.speedum.jitsi_lib.Utils.JitsiConferenceConfig;
import com.speedum.jitsi_libraries_main_app.API.APIModels.MeetingList.MeetingListResponse.MeetingListReturnDatum;
import com.speedum.jitsi_libraries_main_app.API.APIModels.Save_Push_Token.SavePushTokenBody;
import com.speedum.jitsi_libraries_main_app.API.Process_ID;
import com.speedum.jitsi_libraries_main_app.Config;
import com.speedum.jitsi_libraries_main_app.DB.DB_Queries;
import com.speedum.jitsi_libraries_main_app.DB.sharedPrefrances;
import com.speedum.jitsi_libraries_main_app.R;
import com.speedum.jitsi_libraries_main_app.UI.Activities.Base_Activity;
import com.speedum.jitsi_libraries_main_app.UI.Activities.HomeScreen.Presenter.HomeScreenPresenter;
import com.speedum.jitsi_libraries_main_app.UI.Activities.Splash_Screen.Splash_Screen_View.Splash_Screen_View;
import com.speedum.jitsi_libraries_main_app.Util.Double_Click.DebouncedOnClickListener;
import com.speedum.jitsi_libraries_main_app.Util.Util;
import com.speedum.jitsi_libraries_main_app.Util.config;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;

public class HomeScreen extends Base_Activity implements IHomeScreen {

    TextView mTextView_Title;
    TextView mTextView_CallButton;

    Gson gson = new Gson();

    @BindView(R.id.LinearLayout_ErrorMsgLay)
    LinearLayout mLinearLayout_ErrorMsgLay;

    @BindView(R.id.TextView_AddressScreen)
    TextView mTextView_AddressScreen;

    @BindView(R.id.TextView_OrderListScreen)
    TextView mTextView_OrderListScreen;

    @BindView(R.id.LinearLayout_Container)
    LinearLayout mLinearLayout_Container;

    @BindView(R.id.RecyclerView_MeetingList)
    RecyclerView mRecyclerView_MeetingList;

    private Context mContext;
    private HomeScreenPresenter mPresenter;

    private String mDialog_ID = "", mMeeting_code = "", mFormattedDateForDB = "";
    private boolean isToOpenChat = false;
    private RecyclerView.LayoutManager mLayoutManager;
    private SimpleDateFormat df_DB;
    private Calendar mCalendar;

    JitsiConferenceConfig mJitsiConferenceConfig;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        mTextView_Title = (TextView) findViewById(R.id.TextView_Title);
        mTextView_CallButton = (TextView) findViewById(R.id.TextView_CallButton);
        mCalendar = Calendar.getInstance();
        df_DB = new SimpleDateFormat("yyyy-MM-dd");
        mFormattedDateForDB = df_DB.format(mCalendar.getTime());

        mPresenter = (HomeScreenPresenter) getLastNonConfigurationInstance();
        if (mPresenter == null) {
            mPresenter = new HomeScreenPresenter(this, mDbHelper);
        }

        mJitsiConferenceConfig = new JitsiConferenceConfig();
//        mJitsiConferenceConfig.setConfiguration(this,
//                "https://meet.jit.si"
////                ""
//        );
        mJitsiConferenceConfig.setConfiguration(this,
//                Config.getAPI_BaseURl()
                ""
                , Config.getAI_CODE(),
                "https://ppe-sgultra-mindemr.speedum.tech/",
//                Config.getAPI_Link(),
                Config.getEnvironMent(),
                Config.NEW_INTERNAL,
                sharedPrefrances.getSessionToken(mContext),
                sharedPrefrances.getSessionExpiry(mContext), "ANDROID_D"
//                ""
        );

        mLayoutManager = new GridLayoutManager(mContext, 1);
        Intent intent = getIntent();
        if (intent.hasExtra("dialog_id") && Util.CheckForNullValue(intent.getStringExtra("dialog_id")).trim().length() > 0
                && intent.hasExtra("Open_Chat") && intent.getStringExtra("Open_Chat").equalsIgnoreCase("Yes")) {
            isToOpenChat = true;
            mDialog_ID = Util.CheckForNullValue(intent.getStringExtra("dialog_id"));
        }

        /*saving push token*/
      /*  FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(this, instanceIdResult -> {
            String newToken = instanceIdResult.getToken();
            sharedPrefrances.savePushToken(mContext, newToken);
            savePushTokenOnServer();
        });*/
        FirebaseInstallations.getInstance().getToken(true);
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            return;
                        }
                        // Get new FCM registration token
                        String token = task.getResult();
                        if (token != null) {
                            sharedPrefrances.savePushToken(mContext, token);
                            savePushTokenOnServer();
                        }

                    }
                });

//        mHealthStoreConfiguration.getCartItems();

        clickListners();
        setWidgets();
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_home_screen;
    }


    private void clickListners() {


        mTextView_OrderListScreen.setOnClickListener(new DebouncedOnClickListener(700) {
            @Override
            public void onDebouncedClick(View v) {
                String org_id = Util.decryptData(mPresenter.getUserIDFromDB(DB_Queries.get_org_id));
                String user_id = Util.decryptData(mPresenter.getUserIDFromDB(DB_Queries.get_user_id));
                String patient_id = Util.decryptData(mPresenter.getUserIDFromDB(DB_Queries.get_patient_id));
                String UserRoomName = Util.decryptData(mPresenter.getUserIDFromDB(DB_Queries.get_user_name));
                String MeetUniqueCode = Util.decryptData(mPresenter.getUserIDFromDB(DB_Queries.get_user_name));
                String role_id = Util.decryptData(mPresenter.getUserIDFromDB(DB_Queries.get_role_id));
                String ip = Util.fetch_user_remoteIP(mContext);
//                mJitsiConferenceConfig.startConferenceCall("cdConf","Jack");
//                mJitsiConferenceConfig.startConferenceCall("svirk","Test","", "https://meet-dev.speedum.tech","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJNZWV0IiwiZXhwIjoxNjY3ODY2NTE0LCJpc3MiOiJzcGVlZHVtbWVldCIsIm5iZiI6MTY2Nzc4MDExNCwic3ViIjoibWVldC1kZXYuc3BlZWR1bS50ZWNoIiwicm9vbSI6IioiLCJkb21haW4iOiJtZWV0LWRldi5zcGVlZHVtLnRlY2giLCJtb2RlcmF0b3IiOiJ0cnVlIiwiaWF0IjoxNjY3Nzk4MTE0fQ.8zq_cjiBu54OloDq9DphhGumy1Og_TYj6JPCnukisSg");
                mJitsiConferenceConfig.startMeating(mContext, "", patient_id, UserRoomName, MeetUniqueCode, org_id, user_id, role_id, new com.speedum.jitsi_lib.Utils.Config.MeetingCallback() {
                    @RequiresApi(api = Build.VERSION_CODES.P)
                    @Override
                    public void inProgress() {
                        Log.e("startMeating---"," inProgress");
                        showProgressBar();
                    }

                    @Override
                    public void meetingStart() {
                        Log.e("startMeating---"," meetingStart");
                        dismissProgressBar();
                    }

                    @Override
                    public void error(String errorMessage) {
                        dismissProgressBar();
                        showAlertMessage(errorMessage);
                    }
                });
            }
        });

        mTextView_AddressScreen.setOnClickListener(new DebouncedOnClickListener(700) {
            @Override
            public void onDebouncedClick(View v) {

            }
        });


    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void setWidgets() {

    }






    /*Click listners*/

    public void logout(View view) {
        LogoutDialog();
    }

    /*Returning Bottom bar data list*/

    /*Returning blank list*/


    /*alert box for logout*/
    private void LogoutDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(
                this).create();
        alertDialog.setCancelable(true);
        // Setting Dialog Title
        alertDialog.setTitle("Confirm Logout!");
        // Setting Dialog Message
        alertDialog.setMessage("Are you sure you want to logout ?");
        // Setting OK Button
        alertDialog.setButton2("Yes", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
                /*show progress*/
                showProgressBar();
                /*calling delete token from server API*/
                deletePushTokenOnServer();
            }
        });
        alertDialog.setButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        // Showing Alert Message
        alertDialog.show();
    }

    /*save push token on Server*/
    private void savePushTokenOnServer() {
        String versionName = "";
        String org_id = Util.decryptData(mPresenter.getUserIDFromDB(DB_Queries.get_org_id));
        String user_id = Util.decryptData(mPresenter.getUserIDFromDB(DB_Queries.get_user_id));
        String patient_id = Util.decryptData(mPresenter.getUserIDFromDB(DB_Queries.get_patient_id));
        String ip = Util.fetch_user_remoteIP(mContext);
        /*getting token from shared Prefrances*/
        String token = sharedPrefrances.getSessionToken(mContext);
        token = Util.decryptData(token);
        try {
            PackageInfo pinfo = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);
            versionName = pinfo.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        String push_token = sharedPrefrances.getPushToken(mContext);
        /*creating login body*/
        String finalToken = token;
        /*creating login body*/
        SavePushTokenBody savePushTokenBody = mApi_body.save_push_Token_Body("VDENT", versionName, "", "", "", push_token
                , config.ENVIRONMENT, ip, token, Process_ID.Save_Push_Token, user_id, org_id, mContext, patient_id);
        /*calling api on server*/
        mPresenter.savePushToken(savePushTokenBody, finalToken);
    }

    /*delete push token on Server*/
    @RequiresApi(api = Build.VERSION_CODES.P)
    private void deletePushTokenOnServer() {
        showProgressBar();
        String versionName = "";
        String org_id = Util.decryptData(mPresenter.getUserIDFromDB(DB_Queries.get_org_id));
        String user_id = Util.decryptData(mPresenter.getUserIDFromDB(DB_Queries.get_user_id));
        String patient_id = Util.decryptData(mPresenter.getUserIDFromDB(DB_Queries.get_patient_id));
        String ip = Util.fetch_user_remoteIP(mContext);
        /*getting token from shared Prefrances*/
        String token = sharedPrefrances.getSessionToken(mContext);
        token = Util.decryptData(token);
        try {
            PackageInfo pinfo = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);
            versionName = pinfo.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        String push_token = sharedPrefrances.getPushToken(mContext);
        /*creating login body*/
        SavePushTokenBody savePushTokenBody = mApi_body.save_push_Token_Body("VDENT", versionName, "", "", "", push_token
                , config.ENVIRONMENT, ip, token, Process_ID.Delete_Push_Token, user_id, org_id, mContext, patient_id);
        /*calling api on server*/
        mPresenter.deletePushToken(savePushTokenBody, token);
    }


    @Override
    public void deletePushTokenSuccess() {
        dismissProgressBar();
        sharedPrefrances.SaveFirstRun(mContext, 0);
        try {
            /*deleting data from local DB*/
            mPresenter.deleteDataFromTables(DB_Queries.delete_user_info);
            mPresenter.deleteDataFromTables(DB_Queries.deletePatientReminder);
            mPresenter.deleteDataFromTables(DB_Queries.delete_patient_Partner);
            mPresenter.deleteDataFromTables(DB_Queries.delete_org_video);
            mPresenter.deleteDataFromTables(DB_Queries.delete_OrgUserMedications);
            mPresenter.deleteDataFromTables(DB_Queries.delete_OrgMedications);
            mPresenter.deleteDataFromTables(DB_Queries.delete_Gallery);
            mPresenter.deleteDataFromTables(DB_Queries.delete_chat_history);
            mPresenter.deleteDataFromTables(DB_Queries.delete_chat_categories);
            mPresenter.deleteDataFromTables(DB_Queries.delete_my_dentist);
            mPresenter.deleteDataFromTables(DB_Queries.delete_chat_Dialogs);
            mPresenter.deleteDataFromTables(DB_Queries.delete_form_builder);
            Intent intent = new Intent(mContext, Splash_Screen_View.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            e.getLocalizedMessage();
        }
        String QB_id = Util.decryptData(sharedPrefrances.getQuickBloxID(mContext));
    }

    @Override
    public void deletePushTokenError(String failureMessage) {
        dismissProgressBar();
    }

    @Override
    public void getMeetingSuccess(List<MeetingListReturnDatum> meetingList) {
    }

    @Override
    public void meetingListError(String msg) {
        dismissProgressBar();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}