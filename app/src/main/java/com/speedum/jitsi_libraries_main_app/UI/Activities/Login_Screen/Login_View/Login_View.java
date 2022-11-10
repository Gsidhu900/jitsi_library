package com.speedum.jitsi_libraries_main_app.UI.Activities.Login_Screen.Login_View;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;

import com.rilixtech.widget.countrycodepicker.CountryCodePicker;
import com.speedum.jitsi_libraries_main_app.API.API_Body;
import com.speedum.jitsi_libraries_main_app.API.Comman_Data.CommonBody;
import com.speedum.jitsi_libraries_main_app.API.Process_ID;
import com.speedum.jitsi_libraries_main_app.DB.DB_Queries;
import com.speedum.jitsi_libraries_main_app.DB.sharedPrefrances;
import com.speedum.jitsi_libraries_main_app.R;
import com.speedum.jitsi_libraries_main_app.UI.Activities.Base_Activity;
import com.speedum.jitsi_libraries_main_app.UI.Activities.HomeScreen.View.HomeScreen;
import com.speedum.jitsi_libraries_main_app.UI.Activities.Login_Screen.Login_Presenter.Login_Presenter;
import com.speedum.jitsi_libraries_main_app.Util.CustomShapes;
import com.speedum.jitsi_libraries_main_app.Util.Double_Click.DebouncedOnClickListener;
import com.speedum.jitsi_libraries_main_app.Util.MyButtons;
import com.speedum.jitsi_libraries_main_app.Util.MyEditText;
import com.speedum.jitsi_libraries_main_app.Util.MyPasswordEditText;
import com.speedum.jitsi_libraries_main_app.Util.MyTextView_Bold;
import com.speedum.jitsi_libraries_main_app.Util.Util;
import com.speedum.jitsi_libraries_main_app.Util.config;

import butterknife.BindView;
import butterknife.OnTextChanged;

public class Login_View extends Base_Activity implements ILogin_View {
    @BindView(R.id.MyEditText_UserName)
    MyEditText mMyEditText_UserName;

    @BindView(R.id.EditTextPassword_Password)
    MyPasswordEditText mEditTextPassword_Password;

    @BindView(R.id.LinearLayout_Mobile)
    LinearLayout mLinearLayout_Mobile;

    @BindView(R.id.ImageView_PasswordIcon)
    ImageView mImageView_PasswordIcon;

    @BindView(R.id.ImageView_UserName)
    ImageView mImageView_UserName;

    @BindView(R.id.LinearLayout_Country_code)
    LinearLayout mLinearLayout_Country_code;

    @BindView(R.id.LinearLayout_Password)
    LinearLayout mLinearLayout_Password;

    @BindView(R.id.MyTextView_Bold_Forgot_Pass)
    MyTextView_Bold mMyTextView_Bold_Forgot_Pass;

    @BindView(R.id.Button_Login)
    MyButtons mButton_Login;

    @BindView(R.id.MyTextView_Bold_SignUp)
    MyTextView_Bold mMyTextView_Bold_SignUp;

    @BindView(R.id.CountryCodePicker_view)
    CountryCodePicker mCountryCodePicker_view;


    private Login_Presenter mLogin_presenter;
    private Context mContext;
    private boolean mUserFlag=true;

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*Initializing presenter for the view*/
        mLogin_presenter = (Login_Presenter) getLastNonConfigurationInstance();
        if (mLogin_presenter == null) {
            mLogin_presenter = new Login_Presenter(this, Login_View.this, mDbHelper);
        }
        mContext = Login_View.this;
        /*Set color config*/
        setColorConfig();
        /*init view click listeners*/
        setOnClickListener();
        /*saving push token*/
      /*  FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(this, instanceIdResult -> {
            String newToken = instanceIdResult.getToken();
            sharedPrefrances.savePushToken(mContext, newToken);
        });*/
        /*logic of country code popup*/
        mCountryCodePicker_view.hideNameCode(true);
        mCountryCodePicker_view.enableSetCountryByTimeZone(true);
        mCountryCodePicker_view.setKeyboardAutoPopOnSearch(false);


    }

    /*Set color config */
    private void setColorConfig() {
        mButton_Login.setBackground(CustomShapes.getDefaultButtonShape(mContext, mColorConfigModel));

        GradientDrawable shape = CustomShapes.getTextBoxOutline(mColorConfigModel);

        mLinearLayout_Password.setBackground(shape);


        mLinearLayout_Mobile.setBackground(shape);
        mMyTextView_Bold_Forgot_Pass.setTextColor(Color.parseColor(mColorConfigModel.getAppButtonColor()));
        mMyTextView_Bold_SignUp.setTextColor(Color.parseColor(mColorConfigModel.getAppButtonColor()));
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_login_view;
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return mLogin_presenter;
    }


    @OnTextChanged(R.id.MyEditText_UserName)
    void _Email() {
        String enteredText = mMyEditText_UserName.getText().toString();
        if (mMyEditText_UserName != null && !mMyEditText_UserName.getText().toString().trim().equalsIgnoreCase("")) {
            if (Util.isNumber(mMyEditText_UserName.getText().toString().trim())) {
                mImageView_UserName.setVisibility(View.GONE);
                mLinearLayout_Country_code.setVisibility(View.VISIBLE);
                mUserFlag = true;
            } else {
                mUserFlag = false;
                mImageView_UserName.setVisibility(View.VISIBLE);
                mLinearLayout_Country_code.setVisibility(View.GONE);
            }
        } else {
            mUserFlag = false;
            mImageView_UserName.setVisibility(View.VISIBLE);
            mLinearLayout_Country_code.setVisibility(View.GONE);
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.P)
    private void authenticateUserLogin() {
        if (Util.isInternetOn(mContext)) {
            /*show loader*/
            showProgressBar();
            /*closing phone keyboard*/
            Util.closeKeyboard(mContext, mMyEditText_UserName);
            String user_name = mMyEditText_UserName.getText().toString().trim();
            String phoneCode = mCountryCodePicker_view.getSelectedCountryCodeWithPlus();
            String country_Code = mCountryCodePicker_view.getSelectedCountryNameCode();
            if (mUserFlag){
                user_name = country_Code + " " + phoneCode + " " + user_name;
            }

            String password = mEditTextPassword_Password.getText().toString().trim();
            /*converting password to MD5*/
            password = Util.getMd5(password);
            String ip = Util.fetch_user_remoteIP(mContext);
            /*getting token from shared Prefrances*/
            String token = sharedPrefrances.getSessionToken(mContext);
            token = Util.decryptData(token);
            /*creating login body*/
            mApi_body.get_user_Auth_Body(user_name, password, config.ENVIRONMENT, ip, token, Process_ID.LOGIN_USER, mContext, new API_Body.CheckSessionCallBack() {
                @Override
                public void sessionIsUpdated(CommonBody body) {
                    /*getting token from shared Prefrances*/
                    String token = sharedPrefrances.getSessionToken(mContext);
                    token = Util.decryptData(token);
                    /*calling api on server*/
                    mLogin_presenter.loginUserAuthenticate(body, token);
                }

                @Override
                public void errorGettingNewToken(String Title, String message) {
                    dismissProgressBar();
                    showAlertMessage(Title, message, new AlertMessageCallback() {
                        @Override
                        public void OnButtonPress() {

                        }
                    });
                }
            });


        } else {
            Util.showToast(getResources().getString(R.string.internet_error), mContext);
        }
    }

    /*checking login form validations. function will return false in case of */
    private boolean validateLogin() {
        boolean result = true;

        if (mMyEditText_UserName.getText().toString().trim().length() == 0) {
            Util.showToast(getResources().getString(R.string.enter_user_name), mContext);
            /*closing phone keyboard*/
            Util.closeKeyboard(mContext, mMyEditText_UserName);
            return result = false;
        } else if (mEditTextPassword_Password.getText().toString().trim().length() == 0) {
            Util.showToast(getResources().getString(R.string.enter_password), mContext);
            /*closing phone keyboard*/
            Util.closeKeyboard(mContext, mEditTextPassword_Password);
            return result = false;
        }
        return result;
    }

    /*set onclick listener for call the views*/
    private void setOnClickListener(){
        /*added all the login form click from here*/
        mButton_Login.setOnClickListener(new DebouncedOnClickListener(600) {
            @Override
            public void onDebouncedClick(View v) {
                /*checking login form validation*/
                if (validateLogin()) {
                    /*authenticate user on server*/
                    authenticateUserLogin();
                }
            }
        });

        mMyTextView_Bold_Forgot_Pass.setOnClickListener(new DebouncedOnClickListener(600) {
            @Override
            public void onDebouncedClick(View v) {
                /*closing phone keyboard*/
                Util.closeKeyboard(mContext, mMyEditText_UserName);
                /*calling forgot password activity*/

            }
        });
        mMyTextView_Bold_SignUp.setOnClickListener(new DebouncedOnClickListener(600) {
            @Override
            public void onDebouncedClick(View v) {
                /*closing phone keyboard*/
                Util.closeKeyboard(mContext, mMyEditText_UserName);
                /*calling forgot password activity*/

            }
        });
    }

    @Override
    public void loginUserSuccess() {
//        /*dismiss loader*/
//        dismissProgressBar();
        callNextActivity();
//        callNextActivity();
    }

    private void callNextActivity() {
        /*dismiss loader*/
        dismissProgressBar();
        /*calling home Screen*/
        String user_rol = Util.decryptData(mLogin_presenter.getLastMsgID(DB_Queries.get_user_rol));
        String usrOnboardingStatus = Util.decryptData(mLogin_presenter.getLastMsgID(DB_Queries.get_user_onboarding_status));
        /*checking user role*/
        Intent intent = new Intent(mContext, HomeScreen.class);
        startActivity(intent);
        finishAffinity();
        if (!user_rol.equalsIgnoreCase("PATIENT")) {

        } else {
           /* if (usrOnboardingStatus != null && usrOnboardingStatus.equalsIgnoreCase("registered")) {
                Intent intent = new Intent(mContext, Health_Card_View.class);
                intent.putExtra("Flag", "Verify");
                startActivity(intent);
                finishAffinity();
            } else if (usrOnboardingStatus != null && usrOnboardingStatus.equalsIgnoreCase("password_generated")) {
                Intent intent = new Intent(mContext, Health_Card_View.class);
                intent.putExtra("Flag", "Verify");
                startActivity(intent);
                finishAffinity();
            } else if (usrOnboardingStatus != null && usrOnboardingStatus.equalsIgnoreCase("medical_card_updated")) {
                Intent intent = new Intent(mContext, Select_Clinic_View.class);
                intent.putExtra("Flag", "Health_Card");
                intent.putExtra("Org_id", "");
                startActivity(intent);
                finishAffinity();
            } else if (usrOnboardingStatus != null && usrOnboardingStatus.equalsIgnoreCase("org_assigned")) {
                String mOrg_ID = Util.decryptData(mLogin_presenter.getLastMsgID(DB_Queries.get_user_org_id));
                if (mOrg_ID.equalsIgnoreCase("")) {
                    Intent intent = new Intent(mContext, Select_Doctor_View.class);
                    intent.putExtra("Org_Id", mOrg_ID);
                    intent.putExtra("Flag", "Clinic");
                    startActivity(intent);
                    finishAffinity();
                } else {
                    Intent intent = new Intent(mContext, Select_Clinic_View.class);
                    intent.putExtra("Flag", "Health_Card");
                    intent.putExtra("Org_id", "");
                    startActivity(intent);
                    finishAffinity();
                }
            } else*/
        }
    }

    @Override
    public void loginUserError(String msg) {
        /*dismiss loader*/
        dismissProgressBar();
        if (msg.length() > 0) {
            Util.showToast(msg, mContext);
        }
    }



    /*login QB chat server*/
}
