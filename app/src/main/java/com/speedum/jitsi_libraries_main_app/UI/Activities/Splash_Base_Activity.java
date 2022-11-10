package com.speedum.jitsi_libraries_main_app.UI.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.speedum.jitsi_libraries_main_app.API.APIModels.GetColorConfig.GetColorConfigResponse.ColorConfigModel;
import com.speedum.jitsi_libraries_main_app.API.API_Body;
import com.speedum.jitsi_libraries_main_app.API.Process_ID;
import com.speedum.jitsi_libraries_main_app.DB.DBHelper;
import com.speedum.jitsi_libraries_main_app.DB.DB_Queries;
import com.speedum.jitsi_libraries_main_app.DI.Components.ActivityComponent;
import com.speedum.jitsi_libraries_main_app.DI.Components.DaggerActivityComponent;
import com.speedum.jitsi_libraries_main_app.DI.Modules.ActivityModule;
import com.speedum.jitsi_libraries_main_app.My_Application;
import com.speedum.jitsi_libraries_main_app.R;
import com.speedum.jitsi_libraries_main_app.Util.ProgressHUD;
import com.speedum.jitsi_libraries_main_app.Util.Util;

import net.sqlcipher.database.SQLiteDatabase;

import javax.inject.Inject;

import butterknife.ButterKnife;

public abstract class Splash_Base_Activity extends FragmentActivity implements DialogInterface.OnCancelListener {

    @Inject
    public DBHelper mDbHelper;
    @Inject
    public Process_ID mProcess_id;
    @Inject
    public API_Body mApi_body;
    private ActivityComponent activityComponent;
    private ProgressHUD mProgressHUD;
    public ColorConfigModel mColorConfigModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getActivityComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        /*initialize this in app object, SQLite cipher library*/
        SQLiteDatabase.loadLibs(this);
        mColorConfigModel = mDbHelper.getColorConfigFormDB(DB_Queries.get_color_config);
        ButterKnife.bind(this);

        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//            window.setStatusBarColor(Color.parseColor(mColorConfigModel.getAppTopBarColor()));
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.screen_bg_color));
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

  /*  public void showProgressBar() {
        mProgressHUD = ProgressHUD.showSplash(Splash_Base_Activity.this, true,
                false, this);
    }

    public void dismissProgressBar() {
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
    }*/

    public interface AlertMessageCallback{
        void OnButtonPress();
    }
    /*alert box for logout*/
    public void showAlertMessage(String Title, String message, AlertMessageCallback callback) {

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

    @Override
    public void onCancel(DialogInterface dialog) {
        // TODO Auto-generated method stub
        mProgressHUD.dismiss();
    }

    /*alert box for logout*/
    public void showAlertMessage(String message) {
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
       /* alertDialog.setButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        });*/
        // Showing Alert Message
        alertDialog.show();
    }


}
