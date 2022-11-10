package com.speedum.jitsi_libraries_main_app.UI.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.google.gson.Gson;
import com.speedum.jitsi_libraries_main_app.API.APIModels.GetColorConfig.GetColorConfigResponse.ColorConfigModel;
import com.speedum.jitsi_libraries_main_app.API.APIModels.Login_User.LoginReturnData;
import com.speedum.jitsi_libraries_main_app.API.API_Body;
import com.speedum.jitsi_libraries_main_app.API.Process_ID;
import com.speedum.jitsi_libraries_main_app.Config;
import com.speedum.jitsi_libraries_main_app.DB.DBHelper;
import com.speedum.jitsi_libraries_main_app.DB.DB_Queries;
import com.speedum.jitsi_libraries_main_app.DB.sharedPrefrances;
import com.speedum.jitsi_libraries_main_app.DI.Components.ActivityComponent;
import com.speedum.jitsi_libraries_main_app.DI.Components.DaggerActivityComponent;
import com.speedum.jitsi_libraries_main_app.DI.Modules.ActivityModule;
import com.speedum.jitsi_libraries_main_app.My_Application;
import com.speedum.jitsi_libraries_main_app.R;
import com.speedum.jitsi_libraries_main_app.Util.ProgressHUD;
import com.speedum.jitsi_libraries_main_app.Util.Util;

import net.sqlcipher.database.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;

public abstract class Base_Activity extends FragmentActivity implements DialogInterface.OnCancelListener, LifecycleObserver {

    @Inject
    public DBHelper mDbHelper;
    @Inject
    public DB_Queries mDB_Queries;
    @Inject
    public Process_ID mProcess_id;
    @Inject
    public API_Body mApi_body;
    private ActivityComponent activityComponent;
    private ProgressHUD mProgressHUD;
    private boolean IS_APP_IN_FOREGROUND = true;
    public ColorConfigModel mColorConfigModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getActivityComponent().inject(this);
        super.onCreate(savedInstanceState);
        /*initialize this in app object, SQLite cipher library*/
        SQLiteDatabase.loadLibs(this);
        mColorConfigModel=mDbHelper.getColorConfigFormDB(mDB_Queries.get_color_config);
        setContentView(getLayoutResourceId());

        ButterKnife.bind(this);

        if (mColorConfigModel!=null&&mColorConfigModel.getAppTopBarColor()!=null&&!mColorConfigModel.getAppTopBarColor().equalsIgnoreCase("")){
                Window window = this.getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//            window.setStatusBarColor(Color.parseColor(mColorConfigModel.getAppTopBarColor()));
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.screen_bg_color));
//            window.setStatusBarContrastEnforced(true);
        }



        /*life cycle observer*/

    }

    protected abstract int getLayoutResourceId();

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(My_Application.get(this).getComponent())
                    .build();
        }
        return activityComponent;
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public void showProgressBar() {
        try {
            Log.e("HelthStoreLib","showProgressBar");
//            mProgressHUD = ProgressHUD.show(Base_Activity.this, true,
//                    false, this,mColorConfigModel);
        }catch (Exception e){

        }
    }

    public void dismissProgressBar() {
        Log.e("HelthStoreLib","dismissProgressBar");
        try {
            if ((this.mProgressHUD != null) && this.mProgressHUD.isShowing()) {
                this.mProgressHUD.dismiss();
            }
        } catch (final IllegalArgumentException e) {
            // Handle or log or ignore
        } catch (final Exception e) {
            // Handle or log or ignore
        } finally {
            this.mProgressHUD = null;
        }
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        // TODO Auto-generated method stub
        try {
            if ((this.mProgressHUD != null) && this.mProgressHUD.isShowing()) {
                this.mProgressHUD.dismiss();
            }
        } catch (final IllegalArgumentException e) {
            // Handle or log or ignore
        } catch (final Exception e) {
            // Handle or log or ignore
        } finally {
            this.mProgressHUD = null;
        }

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void appInForeground() {
        if (!IS_APP_IN_FOREGROUND) {
            /*checking passcode*/
            int passcodeRun = sharedPrefrances.getPasscodeRun(Base_Activity.this);
            int IsInAppbrowserOpen = sharedPrefrances.getIsInAppbrowser(this);
            if (passcodeRun == 1 && IsInAppbrowserOpen==0) {

            }
        }
        IS_APP_IN_FOREGROUND = true;
    }

    /*alert box for logout*/
    public void showAlertMessage(String message) {
        try {
            AlertDialog alertDialog = new AlertDialog.Builder(
                    this).create();
            alertDialog.setCancelable(true);
            // Setting Dialog Title
            alertDialog.setTitle("Alert!");
            // Setting Dialog Message
            alertDialog.setMessage(message);
            // Setting OK Button
            alertDialog.setButton2("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    alertDialog.dismiss();
                }
            });

        
        // Showing Alert Message
        alertDialog.show();
        }catch (Exception e){

        }

    }

    public interface AlertMessageCallback{
        void OnButtonPress();
    }
  /*alert box for logout*/
    public void showAlertMessage(String Title,String message,AlertMessageCallback callback) {

        try{
            AlertDialog alertDialog = new AlertDialog.Builder(
                    this).create();
            alertDialog.setCancelable(true);
            // Setting Dialog Title
            alertDialog.setTitle(Util.CheckForNullValue(Title));
            // Setting Dialog Message
            alertDialog.setMessage(message);
            // Setting OK Button
            alertDialog.setButton2("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    callback.OnButtonPress();
                    alertDialog.dismiss();
                }
            });
       /* alertDialog.setButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        });*/
            // Showing Alert Message
            alertDialog.show();
        }catch (Exception e){

        }

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void appInBackground() {
        IS_APP_IN_FOREGROUND = false;
    }

    public interface AlertButtonCallback{
        void onClickOK();
        void onClickCancel();
    }


    public void showMessage(String message) {
        try {
            AlertDialog alertDialog = new AlertDialog.Builder(
                    this).create();
            alertDialog.setCancelable(true);
            // Setting Dialog Title
            alertDialog.setTitle("Message");
            // Setting Dialog Message
            alertDialog.setMessage(message);
            // Setting OK Button
            alertDialog.setButton2("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    alertDialog.dismiss();
                }
            });
       /* alertDialog.setButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        });*/
            // Showing Alert Message
            alertDialog.show();
        } catch (Exception e) {

        }

    }

    /*Configur health-store library*/

    private List<LoginReturnData> getBlankProfile() {
        List<LoginReturnData> arr = new ArrayList<LoginReturnData>();
        String org_currency=Util.CheckForNullValue(Util.decryptData(mDbHelper.getSingleColumnData(mDB_Queries.get_org_currency)));
        arr.add(new LoginReturnData("ggggg", "", "", "", ""
                , "", "", "", ""
                , "", "", "", "", "jjjjj"
                , "", "jbjbjbj", "", "", ""
                , "", "", "", "M", "jjjjjj"
                , "", "bbbbb", "jjjjjj", "nnnnnnn", "","",org_currency,""));
        return arr;
    }


    /*broad cast receiver to update chat connection receiver on home screen*/
//    private BroadcastReceiver mIdentifierReciver = new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            /*get data from intent*/
//            String identifierReciver=Util.CheckForNullValue(intent.getStringExtra("identifier"));
////            Log.e("BroadcastReceiverss"," identifierReciver "+identifierReciver);
//             List<HomeScreenConfigReturnDatum> menuDetail = mDbHelper.getHomeScreen_Config(DB_Queries.get_BottomBar_btn_Config(identifierReciver));
//                if (menuDetail!=null&&menuDetail.size()>0){
//                    String action_identifiers = Util.CheckForNullValue(menuDetail.get(0).getMenuActionScreenIdentifier());
//                    String screen_title = Util.CheckForNullValue(menuDetail.get(0).getMenuScreenTitle());
//                    String identifier_detail = Util.CheckForNullValue(menuDetail.get(0).getMenu_action_screen_identifier_detail());
//                    String menu_url = Util.CheckForNullValue(menuDetail.get(0).getMenuUrl());
//                    /*call action dynamic function*/
//                    Util.dynamicActionsOnHomeScreen(mHealthStoreConfiguration,context, action_identifiers, screen_title
//                            , identifier_detail, menu_url, null
//                            , null, (Activity) mBaseContext,mColorConfigModel);
//                }else if (identifierReciver.equalsIgnoreCase("internal_web")) {
//                    String menuUrl = Util.CheckForNullValue(intent.getStringExtra("Url"));
//                    if (menuUrl.length() > 0) {
//                        Util.dynamicActionsOnHomeScreen(mHealthStoreConfiguration,context, identifierReciver, ""
//                                , "", menuUrl, null
//                                , null, (Activity) mBaseContext,mColorConfigModel);
//                    }
//                }
//        }
//    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dismissProgressBar();
    }
}
