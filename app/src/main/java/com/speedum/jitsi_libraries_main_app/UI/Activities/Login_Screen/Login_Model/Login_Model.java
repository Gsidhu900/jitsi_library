package com.speedum.jitsi_libraries_main_app.UI.Activities.Login_Screen.Login_Model;

import android.content.Context;


import com.speedum.jitsi_libraries_main_app.API.APIManager;
import com.speedum.jitsi_libraries_main_app.API.APIModels.Login_User.LoginReturnData;
import com.speedum.jitsi_libraries_main_app.API.Comman_Data.CommonBody;
import com.speedum.jitsi_libraries_main_app.API.Comman_Data.CommonResponse;
import com.speedum.jitsi_libraries_main_app.API.Comman_Data.ResponseHandling;
import com.speedum.jitsi_libraries_main_app.DB.DBHelper;
import com.speedum.jitsi_libraries_main_app.DB.DB_Queries;
import com.speedum.jitsi_libraries_main_app.DB.sharedPrefrances;
import com.speedum.jitsi_libraries_main_app.R;
import com.speedum.jitsi_libraries_main_app.UI.Activities.Login_Screen.Login_Presenter.ILogin_Presenter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login_Model implements ILogin_Model {
    @Override
    public void loginUserAuthenticate(ILogin_Presenter iLogin_presenter, CommonBody loginUserBody
            , String session_ID, Context context, DBHelper dbHelper) {
        /*Calling API on server .*/
        Call<CommonResponse<LoginReturnData>> call = APIManager.getService().authenticateLogin(loginUserBody, session_ID);
        call.enqueue(new Callback<CommonResponse<LoginReturnData>>() {
            @Override
            public void onResponse(Call<CommonResponse<LoginReturnData>> call, Response<CommonResponse<LoginReturnData>> response) {
                ResponseHandling responseHandling=  new ResponseHandling();
                responseHandling.checkResponseData(context, response, new ResponseHandling.ResponseCallback() {
                    @Override
                    public void returnData(ArrayList returnData1, List User_info, String message) {
                        /*checking is array size is greater then 0*/
                        if (User_info.size() > 0) {
                            dbHelper.DeleteDataFromTable(DB_Queries.delete_user_info);
                            dbHelper.saveUserLoginDataInDB(User_info, DB_Queries.save_user_info);
                        }
                        sharedPrefrances.SaveIsUserLoggedIn(context, true);
                        sharedPrefrances.SaveFirstRun(context, 1);
                        /*return success back to model*/
                        iLogin_presenter.loginUserSuccess();
                    }

                    @Override
                    public void errorMessage(String message) {
                        /*return error back to model*/
                        iLogin_presenter.loginUserError(message);
                    }
                });
            }

            @Override
            public void onFailure(Call<CommonResponse<LoginReturnData>> call, Throwable t) {
                /*return error back to model*/
                iLogin_presenter.loginUserError(context.getResources().getString(R.string.error_occurred));
            }
        });


    }

    @Override
    public String getLastMsgID(String query, DBHelper dbHelper) {
        return dbHelper.getLastMsgID(query);
    }
}
