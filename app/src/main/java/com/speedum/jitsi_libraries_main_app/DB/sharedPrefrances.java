package com.speedum.jitsi_libraries_main_app.DB;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class sharedPrefrances {

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

    public static void SaveIsUserLoggedIn(Context context, boolean IsUserLoggedIn) {
        try {
            SharedPreferences info = context.getSharedPreferences("IsUserLoggedIn",
                    Context.MODE_PRIVATE);
            Editor mEditor = info.edit();

            mEditor.clear();
            mEditor.commit();
            mEditor.putBoolean("IsUserLoggedIn", IsUserLoggedIn);
            mEditor.commit();
            mEditor = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static boolean getIsUserLoggedIn(Context context) {
        SharedPreferences info = context.getSharedPreferences("IsUserLoggedIn",
                Context.MODE_PRIVATE);

        boolean firstrun = info.getBoolean("IsUserLoggedIn", false);
        info = null;
        return firstrun;
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

    public static Integer getFirstRun(Context context) {
        SharedPreferences info = context.getSharedPreferences("FirstRun",
                Context.MODE_PRIVATE);

        int firstrun = info.getInt("FirstRun", 0);
        info = null;
        return firstrun;
    }

    public static void SaveIsInAppbrowser(Context context, int InAppbrowser) {
        try {
            SharedPreferences info = context.getSharedPreferences("InAppbrowser",
                    Context.MODE_PRIVATE);
            Editor mEditor = info.edit();

            mEditor.clear();
            mEditor.commit();
            mEditor.putInt("InAppbrowser", InAppbrowser);
            mEditor.commit();
            mEditor = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Integer getIsInAppbrowser(Context context) {
        SharedPreferences info = context.getSharedPreferences("InAppbrowser",
                Context.MODE_PRIVATE);

        int firstrun = info.getInt("InAppbrowser", 0);
        info = null;
        return firstrun;
    }

    public static void SavePasscodeRun(Context context, int PasscodeRun) {
        try {
            SharedPreferences info = context.getSharedPreferences("PasscodeRun",
                    Context.MODE_PRIVATE);
            Editor mEditor = info.edit();

            mEditor.clear();
            mEditor.commit();
            mEditor.putInt("PasscodeRun", PasscodeRun);
            mEditor.commit();
            mEditor = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void savePasscode(Context context, String Passcode) {
        try {
            SharedPreferences info = context.getSharedPreferences("Passcode",
                    Context.MODE_PRIVATE);
            Editor savepass = info.edit();

            savepass.clear();
            savepass.commit();
            savepass.putString("Passcode", Passcode);
            savepass.commit();
            savepass = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getPasscode(Context context) {
        SharedPreferences info = context.getSharedPreferences("Passcode",
                Context.MODE_PRIVATE);

        String Passcode = info.getString("Passcode", null);
        info = null;
        return Passcode;
    }

    public static Integer getPasscodeRun(Context context) {
        SharedPreferences info = context.getSharedPreferences("PasscodeRun",
                Context.MODE_PRIVATE);

        int PasscodeRun = info.getInt("PasscodeRun", 0);
        info = null;
        return PasscodeRun;
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

    public static void SaveFootPrint(Context context, int FirstRun) {
        try {
            SharedPreferences info = context.getSharedPreferences("FootPrint",
                    Context.MODE_PRIVATE);
            Editor mEditor = info.edit();

            mEditor.clear();
            mEditor.commit();
            mEditor.putInt("FootPrint", FirstRun);
            mEditor.commit();
            mEditor = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Integer getFootPrint(Context context) {
        SharedPreferences info = context.getSharedPreferences("FootPrint",
                Context.MODE_PRIVATE);

        int firstrun = info.getInt("FootPrint", 0);
        info = null;
        return firstrun;
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

    public static void saveErrorFlag(Context context, String DBPermissions) {
        try {
            SharedPreferences info = context.getSharedPreferences("ErrorFlag",
                    Context.MODE_PRIVATE);
            Editor savepass = info.edit();

            savepass.clear();
            savepass.commit();
            savepass.putString("ErrorFlag", DBPermissions);
            savepass.commit();
            savepass = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getErrorFlag(Context context) {
        SharedPreferences info = context.getSharedPreferences("ErrorFlag",
                Context.MODE_PRIVATE);

        String savepass = info.getString("ErrorFlag", "false");
        info = null;
        return savepass;
    }

    public static void saveErrorMsg(Context context, String DBPermissions) {
        try {
            SharedPreferences info = context.getSharedPreferences("ErrorMsg",
                    Context.MODE_PRIVATE);
            Editor savepass = info.edit();

            savepass.clear();
            savepass.commit();
            savepass.putString("ErrorMsg", DBPermissions);
            savepass.commit();
            savepass = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getErrorMsg(Context context) {
        SharedPreferences info = context.getSharedPreferences("ErrorMsg",
                Context.MODE_PRIVATE);

        String savepass = info.getString("ErrorMsg", "");
        info = null;
        return savepass;
    }

    public static void saveQuickBloxID(Context context, String QuickBloxID) {
        try {
            SharedPreferences info = context.getSharedPreferences("QuickBloxID",
                    Context.MODE_PRIVATE);
            Editor savepass = info.edit();

            savepass.clear();
            savepass.commit();
            savepass.putString("QuickBloxID", QuickBloxID);
            savepass.commit();
            savepass = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getQuickBloxID(Context context) {
        SharedPreferences info = context.getSharedPreferences("QuickBloxID",
                Context.MODE_PRIVATE);

        String savepass = info.getString("QuickBloxID", "");
        info = null;
        return savepass;
    }

    public static void saveCurrentOpenedDialog(Context context, String OpenedDialog) {
        try {
            SharedPreferences info = context.getSharedPreferences("OpenedDialog",
                    Context.MODE_PRIVATE);
            Editor saveUserName = info.edit();

            saveUserName.clear();
            saveUserName.commit();
            saveUserName.putString("OpenedDialog", OpenedDialog);
            saveUserName.commit();
            saveUserName = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getCurrentOpenedDialog(Context context) {
        SharedPreferences info = context.getSharedPreferences("OpenedDialog",
                Context.MODE_PRIVATE);

        String saveUserName = info.getString("OpenedDialog", "okokokokokokokok");
        info = null;
        return saveUserName;
    }

    public static String getPushToken(Context context) {
        SharedPreferences info = context.getSharedPreferences("PushToken",
                Context.MODE_PRIVATE);

        String savepass = info.getString("PushToken", "false");
        info = null;
        return savepass;
    }

    public static void savePushToken(Context context, String DBPermissions) {
        try {
            SharedPreferences info = context.getSharedPreferences("PushToken",
                    Context.MODE_PRIVATE);
            Editor savepass = info.edit();

            savepass.clear();
            savepass.commit();
            savepass.putString("PushToken", DBPermissions);
            savepass.commit();
            savepass = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void saveAppUpgradeTime(Context context, long synctym) {
        SharedPreferences info = context.getSharedPreferences("AppUpgrade",
                Context.MODE_PRIVATE);
        Editor agency = info.edit();

        agency.putLong("AppUpgrade", synctym);
        agency.commit();
    }

    public static long getAppUpgradeTime(Context context) {
        SharedPreferences info = context.getSharedPreferences("AppUpgrade",
                Context.MODE_PRIVATE);

        long tym = info.getLong("AppUpgrade", 0);
        info = null;
        return tym;
    }

    public static void saveMandatoryUpdate(Context context, int FirstRun) {
        try {
            SharedPreferences info = context.getSharedPreferences("MandatoryUpdate",
                    Context.MODE_PRIVATE);
            Editor mEditor = info.edit();

            mEditor.clear();
            mEditor.commit();
            mEditor.putInt("MandatoryUpdate", FirstRun);
            mEditor.commit();
            mEditor = null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Integer getMandatoryUpdate(Context context) {
        SharedPreferences info = context.getSharedPreferences("MandatoryUpdate",
                Context.MODE_PRIVATE);

        int firstrun = info.getInt("MandatoryUpdate", 0);
        info = null;
        return firstrun;
    }

}
