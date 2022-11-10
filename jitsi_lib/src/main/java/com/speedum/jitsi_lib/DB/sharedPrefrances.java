package com.speedum.jitsi_lib.DB;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class sharedPrefrances {

    public static void SaveFirstRun(Context context, int FirstRun) {
        try {
            SharedPreferences info = context.getSharedPreferences("FirstRun",
                    Context.MODE_PRIVATE);
            Editor mEditor = info.edit();

            mEditor.clear();
            mEditor.commit();
            mEditor.putInt("FirstRun", FirstRun);
            mEditor.commit();
            mEditor = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void saveUnReadMessagCount(Context context, String UnReadMessagCount) {
        try {
            SharedPreferences info = context.getSharedPreferences("UnReadMessagCount",
                    Context.MODE_PRIVATE);
            Editor savepass = info.edit();

            savepass.clear();
            savepass.commit();
            savepass.putString("UnReadMessagCount", UnReadMessagCount);
            savepass.commit();
            savepass = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getUnReadMessagCount(Context context) {
        SharedPreferences info = context.getSharedPreferences("UnReadMessagCount",
                Context.MODE_PRIVATE);

        String savepass = info.getString("UnReadMessagCount", null);
        info = null;
        return savepass;
    }


    public static void saveStaticMessagCartScreen(Context context, String StaticMessagCartScreen) {
        try {
            SharedPreferences info = context.getSharedPreferences("StaticMessagCartScreen",
                    Context.MODE_PRIVATE);
            Editor savepass = info.edit();

            savepass.clear();
            savepass.commit();
            savepass.putString("StaticMessagCartScreen", StaticMessagCartScreen);
            savepass.commit();
            savepass = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getStaticMessagCartScreen(Context context) {
        SharedPreferences info = context.getSharedPreferences("StaticMessagCartScreen",
                Context.MODE_PRIVATE);

        String savepass = info.getString("StaticMessagCartScreen", null);
        info = null;
        return savepass;
    }

    public static void saveStaticMessagCartScreenBillText(Context context, String StaticMessagCartScreen) {
        try {
            SharedPreferences info = context.getSharedPreferences("CartScreenBillText",
                    Context.MODE_PRIVATE);
            Editor savepass = info.edit();

            savepass.clear();
            savepass.commit();
            savepass.putString("CartScreenBillText", StaticMessagCartScreen);
            savepass.commit();
            savepass = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getStaticMessagCartScreenBillText(Context context) {
        SharedPreferences info = context.getSharedPreferences("CartScreenBillText",
                Context.MODE_PRIVATE);

        String savepass = info.getString("CartScreenBillText", null);
        info = null;
        return savepass;
    }

    public static void SaveCartCount(Context context, int CartCount) {
        try {
            SharedPreferences info = context.getSharedPreferences("CartCount",
                    Context.MODE_PRIVATE);
            Editor mEditor = info.edit();

            mEditor.clear();
            mEditor.commit();
            mEditor.putInt("CartCount", CartCount);
            mEditor.commit();
            mEditor = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Integer getCartCount(Context context) {
        SharedPreferences info = context.getSharedPreferences("CartCount",
                Context.MODE_PRIVATE);

        int firstrun = info.getInt("CartCount", 0);
        info = null;
        return firstrun;
    }    public static void SaveAlertCount(Context context, int AlertCount) {
        try {
            SharedPreferences info = context.getSharedPreferences("AlertCount",
                    Context.MODE_PRIVATE);
            Editor mEditor = info.edit();

            mEditor.clear();
            mEditor.commit();
            mEditor.putInt("AlertCount", AlertCount);
            mEditor.commit();
            mEditor = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Integer getFirstRun(Context context) {
        SharedPreferences info = context.getSharedPreferences("FirstRun",
                Context.MODE_PRIVATE);

        int firstrun = info.getInt("FirstRun", 0);
        info = null;
        return firstrun;
    }

    public static void saveSessionExpiry(Context context, String SessionExpiry) {
        try {
            SharedPreferences info = context.getSharedPreferences("SessionExpiry",
                    Context.MODE_PRIVATE);
            Editor savepass = info.edit();

            savepass.clear();
            savepass.commit();
            savepass.putString("SessionExpiry", SessionExpiry);
            savepass.commit();
            savepass = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getSessionExpiry(Context context) {
        SharedPreferences info = context.getSharedPreferences("SessionExpiry",
                Context.MODE_PRIVATE);

        String savepass = info.getString("SessionExpiry", null);
        info = null;
        return savepass;
    }

    public static void saveSessionToken(Context context, String DBPermissions) {
        try {
            SharedPreferences info = context.getSharedPreferences("SessionToken",
                    Context.MODE_PRIVATE);
            Editor savepass = info.edit();

            savepass.clear();
            savepass.commit();
            savepass.putString("SessionToken", DBPermissions);
            savepass.commit();
            savepass = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getSessionToken(Context context) {
        SharedPreferences info = context.getSharedPreferences("SessionToken",
                Context.MODE_PRIVATE);

        String savepass = info.getString("SessionToken", null);
        info = null;
        return savepass;
    }


    public static void saveToken(Context context, String Token) {
        try {
            SharedPreferences info = context.getSharedPreferences("Token",
                    Context.MODE_PRIVATE);
            Editor savepass = info.edit();

            savepass.clear();
            savepass.commit();
            savepass.putString("Token", Token);
            savepass.commit();
            savepass = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getToken(Context context) {
        SharedPreferences info = context.getSharedPreferences("Token",
                Context.MODE_PRIVATE);

        String savepass = info.getString("Token", null);
        info = null;
        return savepass;
    }

    public static void saveCameraPermissions(Context context, String CameraPermissions) {
        try {
            SharedPreferences info = context.getSharedPreferences("CameraPermissions",
                    Context.MODE_PRIVATE);
            Editor savepass = info.edit();

            savepass.clear();
            savepass.commit();
            savepass.putString("CameraPermissions", CameraPermissions);
            savepass.commit();
            savepass = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getCameraPermissions(Context context) {
        SharedPreferences info = context.getSharedPreferences("CameraPermissions",
                Context.MODE_PRIVATE);

        String savepass = info.getString("CameraPermissions", null);
        info = null;
        return savepass;
    }

    public static void saveMapPermissions(Context context, String MapPermissions) {
        try {
            SharedPreferences info = context.getSharedPreferences("MapPermissions",
                    Context.MODE_PRIVATE);
            Editor savepass = info.edit();

            savepass.clear();
            savepass.commit();
            savepass.putString("MapPermissions", MapPermissions);
            savepass.commit();
            savepass = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getMapPermissions(Context context) {
        SharedPreferences info = context.getSharedPreferences("MapPermissions",
                Context.MODE_PRIVATE);

        String savepass = info.getString("MapPermissions", null);
        info = null;
        return savepass;
    }

    public static void saveCallPermissions(Context context, String CallPermissions) {
        try {
            SharedPreferences info = context.getSharedPreferences("CallPermissions",
                    Context.MODE_PRIVATE);
            Editor savepass = info.edit();

            savepass.clear();
            savepass.commit();
            savepass.putString("CallPermissions", CallPermissions);
            savepass.commit();
            savepass = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getCallPermissions(Context context) {
        SharedPreferences info = context.getSharedPreferences("CallPermissions",
                Context.MODE_PRIVATE);

        String savepass = info.getString("CallPermissions", null);
        info = null;
        return savepass;
    }

    public static void saveDBPermissions(Context context, String DBPermissions) {
        try {
            SharedPreferences info = context.getSharedPreferences("DBPermissions",
                    Context.MODE_PRIVATE);
            Editor savepass = info.edit();

            savepass.clear();
            savepass.commit();
            savepass.putString("DBPermissions", DBPermissions);
            savepass.commit();
            savepass = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getDBPermissions(Context context) {
        SharedPreferences info = context.getSharedPreferences("DBPermissions",
                Context.MODE_PRIVATE);

        String savepass = info.getString("DBPermissions", null);
        info = null;
        return savepass;
    }

    public static void saveUserID(Context context, String UserID) {
        try {
            SharedPreferences info = context.getSharedPreferences("UserID",
                    Context.MODE_PRIVATE);
            Editor savepass = info.edit();

            savepass.clear();
            savepass.commit();
            savepass.putString("UserID", UserID);
            savepass.commit();
            savepass = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getUserID(Context context) {
        SharedPreferences info = context.getSharedPreferences("UserID",
                Context.MODE_PRIVATE);

        String savepass = info.getString("UserID", "");
        info = null;
        return savepass;
    }
    public static void saveProfileID(Context context, String ProfileID) {
        try {
            SharedPreferences info = context.getSharedPreferences("ProfileID",
                    Context.MODE_PRIVATE);
            Editor savepass = info.edit();

            savepass.clear();
            savepass.commit();
            savepass.putString("ProfileID", ProfileID);
            savepass.commit();
            savepass = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getProfileID(Context context) {
        SharedPreferences info = context.getSharedPreferences("ProfileID",
                Context.MODE_PRIVATE);

        String savepass = info.getString("ProfileID", "");
        info = null;
        return savepass;
    }

    public static void saveQuickBloxID(Context context, int QuickBloxID) {
        try {
            SharedPreferences info = context.getSharedPreferences("QuickBloxID",
                    Context.MODE_PRIVATE);
            Editor savepass = info.edit();

            savepass.clear();
            savepass.commit();
            savepass.putInt("QuickBloxID", QuickBloxID);
            savepass.commit();
            savepass = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static int getQuickBloxID(Context context) {
        SharedPreferences info = context.getSharedPreferences("QuickBloxID",
                Context.MODE_PRIVATE);

        int savepass = info.getInt("QuickBloxID", 0);
        info = null;
        return savepass;
    }

    public static void saveUserName(Context context, String UserName) {
        try {
            SharedPreferences info = context.getSharedPreferences("UserName",
                    Context.MODE_PRIVATE);
            Editor saveUserName = info.edit();

            saveUserName.clear();
            saveUserName.commit();
            saveUserName.putString("UserName", UserName);
            saveUserName.commit();
            saveUserName = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getUserName(Context context) {
        SharedPreferences info = context.getSharedPreferences("UserName",
                Context.MODE_PRIVATE);

        String saveUserName = info.getString("UserName", null);
        info = null;
        return saveUserName;
    }

    public static void saveUserPassword(Context context, String UserPassword) {
        try {
            SharedPreferences info = context.getSharedPreferences("UserPassword",
                    Context.MODE_PRIVATE);
            Editor saveUserPassword = info.edit();

            saveUserPassword.clear();
            saveUserPassword.commit();
            saveUserPassword.putString("UserPassword", UserPassword);
            saveUserPassword.commit();
            saveUserPassword = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getUserPassword(Context context) {
        SharedPreferences info = context.getSharedPreferences("UserPassword",
                Context.MODE_PRIVATE);

        String saveUserPassword = info.getString("UserPassword", null);
        info = null;
        return saveUserPassword;
    }

    public static void savePassword(Context context, String UserPassword) {
        try {
            SharedPreferences info = context.getSharedPreferences("Password",
                    Context.MODE_PRIVATE);
            Editor saveUserPassword = info.edit();

            saveUserPassword.clear();
            saveUserPassword.commit();
            saveUserPassword.putString("Password", UserPassword);
            saveUserPassword.commit();
            saveUserPassword = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getPassword(Context context) {
        SharedPreferences info = context.getSharedPreferences("Password",
                Context.MODE_PRIVATE);

        String saveUserPassword = info.getString("Password", null);
        info = null;
        return saveUserPassword;
    }


    public static void saveUserImageURL(Context context, String UserImageURL) {
        try {
            SharedPreferences info = context.getSharedPreferences("UserImageURL",
                    Context.MODE_PRIVATE);
            Editor saveUserName = info.edit();

            saveUserName.clear();
            saveUserName.commit();
            saveUserName.putString("UserImageURL", UserImageURL);
            saveUserName.commit();
            saveUserName = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getUserImageURL(Context context) {
        SharedPreferences info = context.getSharedPreferences("UserImageURL",
                Context.MODE_PRIVATE);

        String saveUserName = info.getString("UserImageURL", null);
        info = null;
        return saveUserName;
    }

    /////User data
    public static void saveUserEmail(Context context, String UserEmail) {
        try {
            SharedPreferences info = context.getSharedPreferences("UserEmail",
                    Context.MODE_PRIVATE);
            Editor saveUserName = info.edit();

            saveUserName.clear();
            saveUserName.commit();
            saveUserName.putString("UserEmail", UserEmail);
            saveUserName.commit();
            saveUserName = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getUserEmail(Context context) {
        SharedPreferences info = context.getSharedPreferences("UserEmail",
                Context.MODE_PRIVATE);

        String saveUserName = info.getString("UserEmail", null);
        info = null;
        return saveUserName;
    }

    public static void saveOnBoardingStatus(Context context, String OnBoardingStatus) {
        try {
            SharedPreferences info = context.getSharedPreferences("OnBoardingStatus",
                    Context.MODE_PRIVATE);
            Editor savepass = info.edit();

            savepass.clear();
            savepass.commit();
            savepass.putString("OnBoardingStatus", OnBoardingStatus);
            savepass.commit();
            savepass = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getOnBoardingStatus(Context context) {
        SharedPreferences info = context.getSharedPreferences("OnBoardingStatus",
                Context.MODE_PRIVATE);

        String savepass = info.getString("OnBoardingStatus", "");
        info = null;
        return savepass;
    }


    public static void saveCurrentProfileID(Context context, String CurrentProfileID) {
        try {
            SharedPreferences info = context.getSharedPreferences("CurrentProfileID",
                    Context.MODE_PRIVATE);
            Editor saveUserName = info.edit();

            saveUserName.clear();
            saveUserName.commit();
            saveUserName.putString("CurrentProfileID", CurrentProfileID);
            saveUserName.commit();
            saveUserName = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getCurrentProfileID(Context context) {
        SharedPreferences info = context.getSharedPreferences("CurrentProfileID",
                Context.MODE_PRIVATE);

        String saveUserName = info.getString("CurrentProfileID", null);
        info = null;
        return saveUserName;
    }

}
