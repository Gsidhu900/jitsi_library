package com.speedum.jitsi_lib.API;

import android.content.Context;

import com.google.gson.Gson;
import com.speedum.jitsi_lib.R;
import com.speedum.jitsi_lib.Utils.Util;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;


public class ResponseHandling<T> {

    public  interface ResponseCallback<T>{
    void returnData(ArrayList<T> returnData1, List<T> returnData2, String message);


        void errorMessage(String message);
}

    /*Checking response for data,error and session expire in return  */
    public static  <T> void checkResponseData(Context context, Response<CommonResponse<T>> response, ResponseCallback responseCallback){
        if (response.isSuccessful()) {
            String  ss=new Gson().toJson(response.body());
            if (Util.CheckForNullValue(response.body().getReturnCode()).equalsIgnoreCase("true")) {
                ArrayList<T> returnData1 = response.body().getReturnData();
                List<T> returnData2 = response.body().getReturnData();
                String returnDataString= String.valueOf(response.body().getReturnData());
                String message = Util.CheckForNullValue(response.body().getMessage());
                if (message.length() <= 0) {
                    message = Util.CheckForNullValue(response.body().getFailureMessage());
                }
                if (message.length() <= 0) {
                    message = Util.CheckForNullValue(response.body().getError());
                }
              /*  if (message.length() <= 0) {
                    message = response.message();
                }*/
                if (message.length() <= 0) {
                    message = context.getString(R.string.Went_Wrong_Message);
                }
                /*return success back to model*/
               responseCallback.returnData(returnData1,returnData2,message);
            } else {
                if (Util.CheckForNullValue(response.body().getReturnSessionIdentifier()).equalsIgnoreCase("false")) {
                    Util.showSessionAlert(context);
//                    String message = response.body().getMessage();
//                    if (message.length() <= 0) {
//                        message = response.body().getFailureMessage();
//                    }
//                    if (message.length() <= 0) {
//                        message = response.body().getError();
//                    }
//                    if (message.length() <= 0) {
//                        message = response.message();
//                    }
//                    if (message.length() <= 0) {
//                        message = context.getString(R.string.Went_Wrong_Message);
//                    }
//                    /*return error back to model*/
//                    responseCallback.errorMessage(message);
                } else {
                    String message = Util.CheckForNullValue(response.body().getMessage());
                    if (message.length() <= 0) {
                        message = Util.CheckForNullValue(response.body().getFailureMessage());
                    }
                    if (message.length() <= 0) {
                        message = Util.CheckForNullValue(response.body().getError());
                    }
                    if (message.length() <= 0) {
                        message = context.getString(R.string.Went_Wrong_Message);
                    }
                    /*return error back to model*/
                   responseCallback.errorMessage(message);
                }
            }
        } else {
            /*return error back to model*/
            responseCallback.errorMessage(context.getResources().getString(R.string.error_occurred));
        }
    }


}
