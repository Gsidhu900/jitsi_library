package com.speedum.jitsi_libraries_main_app.Util;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Patterns;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import com.scottyab.aescrypt.AESCrypt;
import com.speedum.jitsi_libraries_main_app.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import static android.R.attr.data;
import static android.content.Context.WIFI_SERVICE;
import static android.os.Build.VERSION_CODES.HONEYCOMB;

public class Util {
    public static int ALERT_COUNT = 0;
    public static boolean mReminder_Flag = false;

    public enum ORDER_TYPE {
        MED, LAB
    }

    public static final boolean isInternetOn(Context c) {
        ConnectivityManager connec = (ConnectivityManager) c
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        try {
            NetworkInfo activeNetwork = connec.getActiveNetworkInfo();
            if (activeNetwork != null) {
                if (activeNetwork.isConnected()) {
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;

    }

    public interface InternetCheckCallback {
        void hasInternetConnection();

        void noInterNetConnection(String message);
    }

    public static final void isInternetOn(Context c, InternetCheckCallback checkCallback) {
        boolean isInternetConnected = false;
        ConnectivityManager connec = (ConnectivityManager) c
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        try {
            NetworkInfo activeNetwork = connec.getActiveNetworkInfo();
            if (activeNetwork != null) {
                if (activeNetwork.isConnected()) {
                    isInternetConnected = true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        if (isInternetConnected) {
            checkCallback.hasInternetConnection();
        } else {
            checkCallback.noInterNetConnection("Internet_error");
        }

    }


    ///////// Getting dates between 2 dates
    public static List<Date> getAllBetweenDates(String dateString1, String dateString2) {
        ArrayList<Date> dates = new ArrayList<Date>();
        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");

        Date date1 = null;
        Date date2 = null;

        try {
            date1 = df1.parse(dateString1);
            date2 = df1.parse(dateString2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);


        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
//        int diff = date1.compareTo(date2);
        long difference_In_Time = date2.getTime() - date1.getTime();

        long difference_In_Seconds
                = (difference_In_Time
                / 1000)
                % 60;

        long difference_In_Minutes
                = (difference_In_Time
                / (1000 * 60))
                % 60;

        long difference_In_Hours
                = (difference_In_Time
                / (1000 * 60 * 60))
                % 24;

        long difference_In_Years
                = (difference_In_Time
                / (1000l * 60 * 60 * 24 * 365));

        long oneYearMili = (1000l * 60 * 60 * 24 * 365);
        long halfYearMili = (1000l * 60 * 60 * 24 * 365);
        long difference_In_Days
                = (difference_In_Time
                / (1000 * 60 * 60 * 24))
                % 365;

        if (difference_In_Years > 1) {
//            long newDateString1 = date2.getTime()-oneYearMili;
            long newDateString1 = date2.getTime() - halfYearMili;
            cal1.setTimeInMillis(newDateString1);

        } else {
            while (!cal1.after(cal2)) {
                dates.add(cal1.getTime());
                cal1.add(Calendar.DATE, 1);
            }

        }
        return dates;
    }

    public static int dpToPx(float dp, Context context){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    public static String extractYoutubeId(String url) throws MalformedURLException {
        String id = null;
        String query = new URL(url).getQuery();
        if (query != null) {
            String[] param = query.split("&");

            for (String row : param) {
                String[] param1 = row.split("=");
                if (param1[0].equals("v")) {
                    id = param1[1];
                }
            }
        }

        return id;
    }

    public static void copyFile(File src, File dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                // Transfer bytes from in to out
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    public static String getFormattedDateFromTimestamp(long timestampInMilliSeconds) {
        Date date = new Date();
        date.setTime(timestampInMilliSeconds);
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd h:mm a").format(date);
        return formattedDate;

    }

    public static String checkIfDateIsPastOrFuture(String endDate) {
       /* String result = "";
        //Format of the date defined in the input String
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm aa");
        Date compairdate = null;
        Date currentDate = null;
        String output = null;
        try {
            //Converting the input String to Date
            compairdate = df.parse(endDate);
            try {
                currentDate = new Date();
                String dateString = df.format(currentDate);
                currentDate = df.parse(dateString);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
//            currentDate= df.parse(currentDate);
            if (compairdate.compareTo(currentDate) < 0) {
                result = "Past";
            } else if (compairdate.compareTo(currentDate) > 0) {
                result = "Future";
            } else {
                result = "Future";
            }
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return result;*/
        String result = "";
        //Format of the date defined in the input String
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm aa");
        Date compairdate = null;
        Date currentDate = null;
        String output = null;
        long nowMillis = 999999;
        long alarmTimw = 0;
        try {
            //Converting the input String to Date
            compairdate = df.parse(endDate);
            try {

                currentDate = new Date();
                String dateString = df.format(currentDate);
                currentDate = df.parse(dateString);
                alarmTimw = Util.milliseconds(endDate) + 15;
                Calendar calendarNow = Calendar.getInstance();
//                 nowMillis = calendarNow.getTimeInMillis();
                nowMillis = currentDate.getTime();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
//            currentDate= df.parse(currentDate);
            if ((alarmTimw - nowMillis) < 0) {
                result = "Past";
            } else if ((alarmTimw - nowMillis) > 0) {
                result = "Future";
            } else {
                result = "Future";
            }
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return result;
    }

    public static boolean isMobileNo(String phone) {
        if (Pattern.matches("[\\+]+[0-9]", phone)) {
            return true;
        }
        return false;
    }

    public static boolean isNumber(String phone) {
        if (TextUtils.isDigitsOnly(phone)) {
            return true;
        }
        return false;
    }

    public static String convertPriceZero(String original_price) {
        String final_price = "";
        if (original_price.contains(".")) {
            String First = Util.getMeNthParamInString(original_price, ".", 1);
            String second = Util.getMeNthParamInString(original_price, ".", 2);
            final_price = First + "." + firstTwo(second);
        } else {
            final_price = original_price;
        }
        return final_price;
    }

    public static String firstTwo(String str) {
        return str.length() < 2 ? str : str.substring(0, 2);
    }


    public static String TimeStamp() {
        String timestamp = String.valueOf(System.currentTimeMillis());
        return timestamp;
    }

    public static String getCurrentTime2() {
        String current_time = "";
        try {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat mdformat = new SimpleDateFormat("hh:mm:ss:SSS a");
            current_time = "" + mdformat.format(calendar.getTime());

        } catch (Exception e) {

        }
        return current_time;
    }


    public static long getCurrentDate() {
        long current_date = 0;
        String currentDatestr = "";
        try {
            Calendar calendar = Calendar.getInstance();
//            SimpleDateFormat mdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
            SimpleDateFormat mdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            mdformat.setTimeZone(TimeZone.getTimeZone("UTC"));
            currentDatestr = "" + mdformat.format(calendar.getTime());
            Date date = mdformat.parse(currentDatestr);

            current_date = date.getTime();

        } catch (Exception e) {

        }
        return current_date;
        //  return currentDatestr;
    }



    public static String getCurrentDateOnly() {
        String current_date = "";
        String currentDatestr = "";
        try {
            Calendar calendar = Calendar.getInstance();
//            SimpleDateFormat mdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
            SimpleDateFormat mdformat = new SimpleDateFormat("dd MMMM, yyyy");
//            mdformat.setTimeZone(TimeZone.getTimeZone("UTC"));
            currentDatestr = "" + mdformat.format(calendar.getTime());
           /* Date date = mdformat.parse(currentDatestr);

            current_date = date.getTime();
*/
            current_date = currentDatestr;
        } catch (Exception e) {

        }
        return current_date;
        //  return currentDatestr;
    }

    public static String convertDecimalTwoPosition(String value) {
        String result = "";
        if (value.trim().contains(".")) {
            double input = Double.parseDouble(value);
            DecimalFormat df2 = new DecimalFormat("#.##");
            df2.setRoundingMode(RoundingMode.DOWN);
            result = df2.format(input);
        }
        return result;
    }

    public static String CalculateDiscountDoub(String dis, String less_price) {
        String discount = "";
        double finalPrice = Double.parseDouble(less_price);
        double disco = Double.parseDouble(dis);

        try {
            double original_price = finalPrice + disco;
            NumberFormat formatter = new DecimalFormat("#0.00");
            discount = formatter.format(original_price);
//           discount= String.valueOf(original_price);
        } catch (Exception e) {

        }
        return discount;
    }


    public static String getCurrentTimeOnly() {
        String current_date = "";
        String currentDatestr = "";
        try {
            Calendar calendar = Calendar.getInstance();
//            SimpleDateFormat mdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
            SimpleDateFormat mdformat = new SimpleDateFormat("hh:mm a");
//            mdformat.setTimeZone(TimeZone.getTimeZone("UTC"));
            currentDatestr = "" + mdformat.format(calendar.getTime());
           /* Date date = mdformat.parse(currentDatestr);

            current_date = date.getTime();
*/
            current_date = currentDatestr;
        } catch (Exception e) {

        }
        return current_date;
        //  return currentDatestr;
    }

    public static String convertMeetingDateAndTime(String datestr) {
        String result = "";
        //Format of the date defined in the input String
        DateFormat df = new SimpleDateFormat("dd-MMM-yy HH:mm:ss");
//        DateFormat df = new SimpleDateFormat("MMM dd,yyyy hh:mm a");
        //Desired format: 24 hour format: Change the pattern as per the need
        DateFormat outputformat = new SimpleDateFormat("dd-MMM-HH:mm");
        Date date = null;
        String output = null;
        try {
            date = df.parse(datestr);
            //Converting the input String to Date
            //Changing the format of date and storing it in String
            output = outputformat.format(date);
            result = output;
            //Displaying the date
//            System.out.println(output);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return result;
    }



    public static boolean isFutureDateTimeMili(long pDateString) {
        try {
            Calendar calendar = Calendar.getInstance();
            long nowdate = calendar.getTimeInMillis();
            if (nowdate - pDateString > 0) {
//            Log.e("isFutureDateTime"," past date ");
                return false;
            } else {
//            Log.e("isFutureDateTime"," future date ");
                return true;
            }

        } catch (Exception pe) {
//            Log.e("isFutureDateTime", " pe " + pe.getLocalizedMessage());
            return true;
        }
    }


    // Check SIM available or not
    public static boolean isSimAvailable(Context context) {

        TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        if (tm.getSimState() != TelephonyManager.SIM_STATE_ABSENT) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isAirplaneModeOn(Context context) {
        return Settings.System.getInt(context.getContentResolver(),
                Settings.System.AIRPLANE_MODE_ON, 0) != 0;
    }


    public interface ActionOnNotNullnBlankCheckCallback {
        void onNotNull(String value);
    }

    public interface ActionOnStringValue {
        void onNotNull(String value);

        void onBlank(String value);

        void onNull();
    }

    public static final void ActionOnNotNullnBlankString(String InputValue, ActionOnNotNullnBlankCheckCallback checkCallback) {
        if (InputValue != null && !InputValue.trim().equalsIgnoreCase("")) {
            checkCallback.onNotNull(InputValue);
        }

    }

    public static final void ActionOnStringValue(String InputValue, ActionOnStringValue checkCallback) {
        if (InputValue == null) {
            checkCallback.onNull();
        } else if (InputValue.trim().equalsIgnoreCase("")) {
            checkCallback.onBlank(InputValue);
        } else {
            checkCallback.onNotNull(InputValue);
        }
    }






    public static boolean isEmailValid(String email) {
        String regExpn = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.matches())
            return false;
        else

            return true;
    }

    public static final Typeface getfontStyle(Context context, Fontstyle ft) {
        Typeface typeface = null;

        if (ft == Fontstyle.FONT_LIGHT) {
            typeface = Typeface.createFromAsset(context.getAssets(),
                    "fonts/OpenSans-Light.ttf");
        } else if (ft == Fontstyle.FONT_REGULAR) {
            typeface = Typeface.createFromAsset(context.getAssets(),
                    "fonts/Gilroy_Regular.ttf");
        } else if (ft == Fontstyle.FONT_BOLDITALIC) {
            typeface = Typeface.createFromAsset(context.getAssets(),
                    "fonts/Gilroy_Bold.ttf");
        }
       /* if (ft == Fontstyle.FONT_LIGHT) {
            typeface = Typeface.createFromAsset(context.getAssets(),
                    "fonts/Comfortaa-Light.ttf");
        } else if (ft == Fontstyle.FONT_REGULAR) {
            typeface = Typeface.createFromAsset(context.getAssets(),
                    "fonts/Comfortaa-Regular.ttf");
        } else if (ft == Fontstyle.FONT_BOLDITALIC) {
            typeface = Typeface.createFromAsset(context.getAssets(),
                    "fonts/Comfortaa-Bold.ttf");
        }*/
        return typeface;
    }


    public enum Fontstyle {
        FONT_REGULAR, FONT_LIGHT, FONT_BOLDITALIC
    }

    public static interface LoginCheckCallback {
        void userLoggedIn();
    }


    public static void InternetDialog(String MSG, Context context) {
        try {
            AlertDialog alertDialog = new AlertDialog.Builder(
                    context).create();
            alertDialog.setCancelable(true);
            // Setting Dialog Title
            alertDialog.setTitle("Alert!");
            // Setting Dialog Message
            alertDialog.setMessage(MSG);
            // Setting OK Button

            alertDialog.setButton2("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            // Showing Alert Message
            alertDialog.show();
        } catch (final IllegalArgumentException e) {
            // Handle or log or ignore
        } catch (final Exception e) {
            // Handle or log or ignore
        }
    }

    // to show toast on screen
    public static void showToast(String msg, Context context) {
        try {
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getVisitType(ORDER_TYPE order_type) {
        String visitType = "";
        if (order_type.equals(ORDER_TYPE.LAB)) {
            visitType = "lab_order";
        } else {
            visitType = "medicine_order";
        }
        return visitType;
    }

    public static String getUploadType(ORDER_TYPE order_type) {
        String visitType = "";
        if (order_type.equals(ORDER_TYPE.LAB)) {
            visitType = "lab_upload";
        } else {
            visitType = "medicine_upload";
        }
        return visitType;
    }

    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {

        // Create a new LinkedHashSet
        Set<T> set = new LinkedHashSet<>();

        // Add the elements to set
        set.addAll(list);

        // Clear the list
        list.clear();

        // add the elements of set
        // with no duplicates to the list
        list.addAll(set);

        // return the list
        return list;
    }


    public static String convertDateStringToAnotherFormat(String datestr) {
        String result = "";
        //Format of the date defined in the input String
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //Desired format: 24 hour format: Change the pattern as per the need
        DateFormat outputformat = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        Date date = null;
        String output = null;
        try {
            //Converting the input String to Date
            date = df.parse(datestr);
            //Changing the format of date and storing it in String
            output = outputformat.format(date);
            result = output;
            //Displaying the date
            System.out.println(output);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return result;
    }

    /*Checking entered text in chat message is a simple text or a url*/
    public static boolean isUrl(String text) {
        Pattern p = Patterns.WEB_URL;
        Matcher m = p.matcher(text.toLowerCase());
        if (m.matches())
            return true;
        else
            return false;
    }


    public static String convertApptDateToAnotherFormat(String datestr) {
        String result = "";
        //Format of the date defined in the input String
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //Desired format: 24 hour format: Change the pattern as per the need
        DateFormat outputformat = new SimpleDateFormat("dd-MMM-HH:mm");
        Date date = null;
        String output = null;
        try {
            //Converting the input String to Date
            date = df.parse(datestr);
            //Changing the format of date and storing it in String
            output = outputformat.format(date);
            result = output;
            //Displaying the date
            System.out.println(output);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return result;
    }

    public static String CheckForNullAndBlankForPrice(String value) {
        if (value == null || value.equalsIgnoreCase("null") || value.trim().equalsIgnoreCase("")) {
            value = "0";
        }
        return value;
    }

    public static String convertPickUpDateToAnotherFormat(Date date) {
        String result = "";
        //Format of the date defined in the input String
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy'T'HH:mm");
        //Desired format: 24 hour format: Change the pattern as per the need
        DateFormat outputformat = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
        String output = null;
        try {
            //Converting the input String to Date
            //Changing the format of date and storing it in String
            output = outputformat.format(date);
            result = output;
            //Displaying the date
            System.out.println(output);
        } catch (Exception pe) {
            pe.printStackTrace();
        }
        return result;
    }

    public static File getBlankFile(String fileName, Context context) {
        File movedFile = null;
        try {
            String target = Environment.getExternalStorageDirectory()
                    + "/Android/data/"
                    + context.getApplicationContext().getPackageName()
                    + "/temp/"+fileName;
            movedFile=new File(target);
        }catch (Exception e){

        }
        return movedFile;
        }
    public static File moveFile(File sourcefile, Context context) {
        File movedFile = null;
        try {
            String target = Environment.getExternalStorageDirectory()
                    + "/Android/data/"
                    + context.getApplicationContext().getPackageName()
                    + "/Prescription";

            InputStream in = null;
            OutputStream out = null;
            try {

                //create output directory if it doesn't exist
                File dir = new File(target);
                if (!dir.exists()) {
                    dir.mkdirs();
                }


                in = new FileInputStream(sourcefile.getAbsolutePath());
                out = new FileOutputStream(target + "/" + sourcefile.getName());

                byte[] buffer = new byte[1024];
                int read;
                while ((read = in.read(buffer)) != -1) {
                    out.write(buffer, 0, read);
                }
                in.close();
                in = null;

                // write the output file
                out.flush();
                out.close();
                out = null;
                movedFile = new File(target + "/" + sourcefile.getName());
                // delete the original file
                new File(sourcefile.getAbsolutePath()).delete();
            } catch (FileNotFoundException fnfe1) {
                Log.e("tag", fnfe1.getMessage());
            } catch (Exception e) {
                Log.e("tag", e.getMessage());
            }
        } catch (Exception e) {

        }
        return movedFile;
    }


    public static String CheckForNullValue(String value) {
        if (value == null || value.equalsIgnoreCase("null")) {
            value = "";
        }
        return value;
    }

    public static String CheckForNullValueReturnZero(String value) {
        if (value == null || value.equalsIgnoreCase("null")) {
            value = "0";
        }
        return value;
    }

    public static String getTodayDate() {
        String Current_Date = "";
        Calendar mCalendar = Calendar.getInstance();
        SimpleDateFormat df_DB = new SimpleDateFormat("yyyy-MM-dd");
        Current_Date = df_DB.format(mCalendar.getTime());
        return Current_Date;
    }

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1))
                * Math.sin(deg2rad(lat2))
                + Math.cos(deg2rad(lat1))
                * Math.cos(deg2rad(lat2))
                * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        return (dist);
    }

    public static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    public static double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

    public static String getCurrentTimeInUTC() {
        String date_time = "";
        SimpleDateFormat f = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy");
        f.setTimeZone(TimeZone.getTimeZone("UTC"));
        date_time = f.format(new Date());

        return date_time;
    }

    public static long milliseconds(String date) {
        //String date_ = date;
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd h:mm a");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm aa");
        try {
            Date mDate = sdf.parse(date);
            long timeInMilliseconds = mDate.getTime();
            System.out.println("Date in milli :: " + timeInMilliseconds);
            return timeInMilliseconds;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return 0;
    }

    public static String convertDateToUTCDateString(Date date) {
        String date_time = "";
        SimpleDateFormat f = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy");
        f.setTimeZone(TimeZone.getTimeZone("UTC"));
        date_time = f.format(date);

        return date_time;
    }

    public static Date ConvertUTCToLocalTime(String dateStr) {
        Date return_date = null;
        try {
            SimpleDateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy", Locale.ENGLISH);
            df.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date date = df.parse(dateStr);
            df.setTimeZone(TimeZone.getDefault());
            String formattedDate = df.format(date);
            return_date = df.parse(formattedDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return return_date;
    }

    /*function to encrypt data */
    public static String encryptData(String encryptedMsg) {
        String return_data = "";
        try {
            return_data = AESCrypt.encrypt(com.speedum.jitsi_libraries_main_app.Util.config.CODE_PASS, encryptedMsg);
        } catch (GeneralSecurityException e) {
            //handle error - could be due to incorrect password or tampered encryptedMsg
            return_data = "";
        } catch (Exception e) {
            //handle error - could be due to incorrect password or tampered encryptedMsg
            return_data = "";
        }
        return return_data;
    }

    /*function to decrypt data */
    public static String decryptData(String encryptedMsg) {
        String return_data = "";
        try {
            return_data = AESCrypt.decrypt(com.speedum.jitsi_libraries_main_app.Util.config.CODE_PASS, encryptedMsg);
        } catch (GeneralSecurityException e) {
            //handle error - could be due to incorrect password or tampered encryptedMsg
            return_data = "";
        } catch (Exception e) {
//            Log.e("","");
            //handle error - could be due to incorrect password or tampered encryptedMsg
            return_data = "";
        }
        return return_data;
    }

    public static String getMd5(String input) {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void closeKeyboard(Context context, View view) {
        /*Hiding key board code*/
        InputMethodManager imm = (InputMethodManager) context.getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static boolean checkIsTablet(Context context) {
        boolean isTablet = false;
        Display display = ((Activity) context).getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);

        float widthInches = metrics.widthPixels / metrics.xdpi;
        float heightInches = metrics.heightPixels / metrics.ydpi;
        double diagonalInches = Math.sqrt(Math.pow(widthInches, 2) + Math.pow(heightInches, 2));
        if (diagonalInches >= 7.0) {
            isTablet = true;
        }

        return isTablet;
    }

    public static void openKeyboard(Context context, View view) {
        /*Hiding key board code*/
        InputMethodManager inputMethodManager = (InputMethodManager) context.getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
    }

    public static String fetch_user_remoteIP(Context context) {
        String ip = "";
        try {
            WifiManager wm = (WifiManager) context.getApplicationContext().getSystemService(WIFI_SERVICE);
            ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ip;
    }

    public interface PermissionCallback {
        void permissionAlreadyAccepted();
    }

    public static void askReadWritePermissions(Activity activity, int RequestCode, PermissionCallback permissionCallback) {
        try {
                    if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)) {
            boolean permissions = true;
            if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                permissions = false;
            } else if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                permissions = false;
            } else if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                permissions = false;
            }
            if (!permissions) {
                /*only for gingerbread and newer versions*/
                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                }, RequestCode);
            } else {
                permissionCallback.permissionAlreadyAccepted();
            }
        } else {
            permissionCallback.permissionAlreadyAccepted();
        }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static String extractYoutubeVideoId(String ytUrl) {

        String vId = null;

        String pattern = "(?<=watch\\?v=|/videos/|embed\\/)[^#\\&\\?]*";

        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(ytUrl);

        if (matcher.find()) {
            vId = matcher.group();
        }
        return vId;
    }

    public static String getMeNthParamInString(String p_text,
                                               String p_seperator, int nThParam) { // / "TOTRPIDS=101=104" returns
        // "101" If nThParam ==
        // 2.
        String retStrThirdParam = new String("");
        int index = -1;
        int prevIdx = 0;
        int loopNM = 1;
        boolean loopBool = true;
        while (loopBool) {
            try {
                index = p_text.indexOf(p_seperator, prevIdx);
                if (loopNM >= nThParam) {
                    if (index >= 0) {
                        retStrThirdParam = p_text.substring(prevIdx, index);
                    } else // /-1
                    {
                        retStrThirdParam = p_text.substring(prevIdx);
                    }
                    loopBool = false;
                    break;
                } else {
                    if (index < 0) // /-1
                    {
                        loopBool = false;
                        retStrThirdParam = "";
                        break;
                    }
                }
                loopNM++;
                prevIdx = index + 1;
            } catch (Exception ex) {
                loopBool = false;
                retStrThirdParam = "";
                break;
            }
        } // /while
        if (retStrThirdParam.trim().length() <= 0) {
            retStrThirdParam = "";
        }
        return retStrThirdParam;
    }

    public static long getTimeUsedInMilliSeconds() {
        long timeMillisec = 0;
        Calendar calendar = Calendar.getInstance();
        long startTime = calendar.getTimeInMillis();
        return startTime;
    }

    public static String getFormattedDate(Context context, long smsTimeInMilis) {
        Calendar smsTime = Calendar.getInstance();
        smsTime.setTimeInMillis(smsTimeInMilis);

        Calendar now = Calendar.getInstance();

        final String dateTimeFormatString = "MMM dd, yyyy";
        if (now.get(Calendar.DATE) == smsTime.get(Calendar.DATE)) {
            return "TODAY";
        } else if (now.get(Calendar.DATE) - smsTime.get(Calendar.DATE) == 1) {
            return "YESTERDAY";
        } else if (now.get(Calendar.YEAR) == smsTime.get(Calendar.YEAR)) {
            return android.text.format.DateFormat.format(dateTimeFormatString, smsTime).toString();
        } else {
            return android.text.format.DateFormat.format("MMM dd, yyyy", smsTime).toString();
        }
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public static String convertDOBDateStringToAnotherFormat(String datestr) {
        String result = "";
        //Format of the date defined in the input String
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //Desired format: 24 hour format: Change the pattern as per the need
        DateFormat outputformat = new SimpleDateFormat("MMM dd,yyyy");
        Date date = null;
        String output = null;
        try {
            //Converting the input String to Date
            date = df.parse(datestr);
            //Changing the format of date and storing it in String
            output = outputformat.format(date);
            result = output;
            //Displaying the date
            System.out.println(output);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return result;
    }

    public static String encodeImage(Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] b = baos.toByteArray();
        String encImage = Base64.encodeToString(b, Base64.DEFAULT);

        return encImage;
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if (dir != null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }

    public static Bitmap convertBase64ToBitmap(String b64) {
        byte[] imageAsBytes = Base64.decode(b64.getBytes(), Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length);
    }

    public static String convertUTCTimeToLocal(String ourDate) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date value = formatter.parse(ourDate);

            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //this format changeable
            dateFormatter.setTimeZone(TimeZone.getDefault());
            ourDate = dateFormatter.format(value);

            //Log.d("ourDate", ourDate);
        } catch (Exception e) {
            ourDate = "00-00-0000 00:00";
        }
        return ourDate;
    }

    public static boolean isTodaysDate(String ourDate, String convertLocalFlag) {
        boolean isTodaysDate = false;
        try {
            if (convertLocalFlag.equalsIgnoreCase("Y")) {
                try {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
                    Date value = formatter.parse(ourDate);

                    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //this format changeable
                    dateFormatter.setTimeZone(TimeZone.getDefault());
                    ourDate = dateFormatter.format(value);

                    //Log.d("ourDate", ourDate);
                } catch (Exception e) {
                    ourDate = "00-00-0000 00:00";
                }
            }
            String result = "";
            //Format of the date defined in the input String
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //Desired format: 24 hour format: Change the pattern as per the need
            DateFormat outputformat = new SimpleDateFormat("dd MMM yyyy");
            Date date = null;
            String output = null;
            String outputCurrent = null;
            Date currentDate = new Date();
            try {
                //Converting the input String to Date
                date = df.parse(ourDate);
                //Changing the format of date and storing it in String
                output = outputformat.format(date);
                outputCurrent = outputformat.format(currentDate);
                if (output.equalsIgnoreCase(outputCurrent)) {
                    isTodaysDate = true;
                } else {
                    isTodaysDate = false;
                }
                result = output;
                //Displaying the date
                System.out.println(output);
            } catch (ParseException pe) {
                pe.printStackTrace();
                isTodaysDate = false;
            }
            //Log.d("ourDate", ourDate);
        } catch (Exception e) {
            isTodaysDate = false;
        }
        return isTodaysDate;
    }

    public static String saveToInternalStorage(Bitmap bitmapImage, Context context) {
        ContextWrapper cw = new ContextWrapper(context.getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("vDent", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath = new File(directory, "health_card.jpg");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mypath.getAbsolutePath();
    }

    public static String convertDate(String datestr) {
        String result = "";
        //Format of the date defined in the input String
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm aa");
//        DateFormat df = new SimpleDateFormat("MMM dd,yyyy hh:mm a");
        //Desired format: 24 hour format: Change the pattern as per the need
        DateFormat outputformat = new SimpleDateFormat("MMM dd,yyyy");
        Date date = null;
        String output = null;
        try {
            //Converting the input String to Date
            date = df.parse(datestr);
            //Changing the format of date and storing it in String
            output = outputformat.format(date);
            result = output;
            //Displaying the date
//            System.out.println(output);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return result;
    }


    public static String convertTime(String datestr) {
        String result = "";
        //Format of the date defined in the input String
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm aa");
//        DateFormat df = new SimpleDateFormat("MMM dd,yyyy hh:mm aa");
        //Desired format: 24 hour format: Change the pattern as per the need
        DateFormat outputformat = new SimpleDateFormat("hh:mm a");
        Date date = null;
        String output = null;
        try {
            //Converting the input String to Date
            date = df.parse(datestr);
            //Changing the format of date and storing it in String
            output = outputformat.format(date);
            result = output;
            //Displaying the date
//            System.out.println(output);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return result;
    }

    public static String convertTime24To12(String datestr) {
        String result = "";
        //Format of the date defined in the input String
        DateFormat df = new SimpleDateFormat("hh:mm:ss");
//        DateFormat df = new SimpleDateFormat("MMM dd,yyyy hh:mm aa");
        //Desired format: 24 hour format: Change the pattern as per the need
        DateFormat outputformat = new SimpleDateFormat("hh:mm a");
        Date date = null;
        String output = null;
        try {
            //Converting the input String to Date
            date = df.parse(datestr);
            //Changing the format of date and storing it in String
            output = outputformat.format(date);
            result = output;
            //Displaying the date
//            System.out.println(output);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return result;
    }


    public static boolean checkIfEndDateIsPastOrFuture(String endDate) {
        boolean result = true;
        try {
            Date currentDate = new Date();
//            Date date1 = new SimpleDateFormat("yyyy-MM-dd hh:mm aa").parse(endDate);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm aa");
//            df.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date dateLocal = null;
            dateLocal = df.parse(endDate);
            df.setTimeZone(TimeZone.getDefault());
            String formattedDate = df.format(dateLocal);
            Date date1 = df.parse(formattedDate);

            if (date1.compareTo(currentDate) < 0) {
                result = false;
            } else if (date1.compareTo(currentDate) > 0) {
                result = true;
            }
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return result;
    }

    public static boolean isDateInCurrentWeek(String endDate) {
        Date date = null;

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        df.setTimeZone(TimeZone.getTimeZone("UTC"));

        try {
            Date dateLocal = null;
            dateLocal = df.parse(endDate);
            df.setTimeZone(TimeZone.getDefault());
            String formattedDate = df.format(dateLocal);
            date = df.parse(formattedDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }

       /* try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }*/
        Calendar currentCalendar = Calendar.getInstance();
        int week = currentCalendar.get(Calendar.WEEK_OF_YEAR);
        int year = currentCalendar.get(Calendar.YEAR);
        Calendar targetCalendar = Calendar.getInstance();
        targetCalendar.setTime(date);
        int targetWeek = targetCalendar.get(Calendar.WEEK_OF_YEAR);
        int targetYear = targetCalendar.get(Calendar.YEAR);
        return week == targetWeek && year == targetYear;
    }

    public static boolean isSessionNotExpire(String endDate) {  // comming date  2021-04-23 14:37:30  yyyy-MM-dd HH:mm:ss
        boolean result = true;
        try {
            Date currentDate = new Date();
//            Date date1 = new SimpleDateFormat("yyyy-MM-dd hh:mm aa").parse(endDate);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            df.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date dateLocal = null;
            dateLocal = df.parse(endDate);
            df.setTimeZone(TimeZone.getDefault());
            String formattedDate = df.format(dateLocal);
            Date date1 = df.parse(formattedDate);

            if (date1.compareTo(currentDate) < 0) {
                result = false;
            } else if (date1.compareTo(currentDate) > 0) {
                result = true;
            }
        } catch (ParseException pe) {
            pe.printStackTrace();
            result = false;
        }
        return result;
    }

      public static boolean isDateInCurrentDay(String endDate) {
        Date date = null;

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date dateLocal = null;
            dateLocal = df.parse(endDate);
            df.setTimeZone(TimeZone.getDefault());
            String formattedDate = df.format(dateLocal);
            date = df.parse(formattedDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        SimpleDateFormat dftoday = new SimpleDateFormat("yyyy-MM-dd");
        Calendar currentCalendar = Calendar.getInstance();
        int week = currentCalendar.get(Calendar.WEEK_OF_YEAR);
        int year = currentCalendar.get(Calendar.YEAR);
        int day = currentCalendar.get(Calendar.DAY_OF_MONTH);
        Calendar targetCalendar = Calendar.getInstance();
        targetCalendar.setTime(date);
        int targetWeek = targetCalendar.get(Calendar.WEEK_OF_YEAR);
        int targetYear = targetCalendar.get(Calendar.YEAR);
        int targetday = targetCalendar.get(Calendar.DAY_OF_MONTH);
        return week == targetWeek && year == targetYear && day == targetday;
    }

    public static boolean isAfterCurrentWeek(String endDate) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        Calendar currentCalendar = Calendar.getInstance();
        int week = currentCalendar.get(Calendar.WEEK_OF_YEAR);
        int year = currentCalendar.get(Calendar.YEAR);
        Calendar targetCalendar = Calendar.getInstance();
        targetCalendar.setTime(date);
        int targetWeek = targetCalendar.get(Calendar.WEEK_OF_YEAR);
        int targetYear = targetCalendar.get(Calendar.YEAR);
        return targetWeek > week && year == targetYear;
    }


    public static String ConvertDateForAppointment(String date_time) {
        Date date;
        String retuntime = "";
        ////////
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdfs = new SimpleDateFormat("MMM dd,yyyy hh:mm a");
        try {
            date = sdf.parse(date_time);
            retuntime = sdfs.format(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return retuntime;
    }

    public static String getBase64FromPath(String path) {
        String base64 = "";
        try {/*from   w w w .  ja  va  2s  .  c om*/
            File file = new File(path);
            byte[] buffer = new byte[(int) file.length() + 100];
            @SuppressWarnings("resource")
            int length = new FileInputStream(file).read(buffer);
            base64 = Base64.encodeToString(buffer, 0, length,
                    Base64.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return base64;
    }

    public static String convertDateStringToAnotherFormat2(String datestr) {
        String result = "";
        //Format of the date defined in the input String
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //Desired format: 24 hour format: Change the pattern as per the need
        DateFormat outputformat = new SimpleDateFormat("EEEE, dd MMMM");
        Date date = null;
        String output = null;
        try {
            //Converting the input String to Date
            date = df.parse(datestr);
            //Changing the format of date and storing it in String
            output = outputformat.format(date);
            result = output;
            //Displaying the date
            System.out.println(output);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return result;
    }

    public static String convertDateMMM_dd_YYYY(String datestr) {
        String result = "";
        //Format of the date defined in the input String
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //Desired format: 24 hour format: Change the pattern as per the need
        DateFormat outputformat = new SimpleDateFormat("MMM, dd,yyyy");
        Date date = null;
        String output = null;
        try {
            //Converting the input String to Date
            date = df.parse(datestr);
            //Changing the format of date and storing it in String
            output = outputformat.format(date);
            result = output;
            //Displaying the date
            System.out.println(output);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return result;
    }

    public static String convertDateStringToAnotherFormat3(String datestr) {
        String result = "";
        //Format of the date defined in the input String
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //Desired format: 24 hour format: Change the pattern as per the need
        DateFormat outputformat = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        Date date = null;
        String output = null;
        try {
            //Converting the input String to Date
            date = df.parse(datestr);
            //Changing the format of date and storing it in String
            output = outputformat.format(date);
            result = output;
            //Displaying the date
            System.out.println(output);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return result;
    }

    public static String convertDateStringToAnotherFormat4(String datestr) {
        String result = "";
        //Format of the date defined in the input String
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //Desired format: 24 hour format: Change the pattern as per the need
        DateFormat outputformat = new SimpleDateFormat("dd MMMM");
        Date date = null;
        String output = null;
        try {
            //Converting the input String to Date
            date = df.parse(datestr);
            //Changing the format of date and storing it in String
            output = outputformat.format(date);
            result = output;
            //Displaying the date
            System.out.println(output);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return result;
    }

    public static boolean isValidPassword(int upper_case_characters, int lower_case_characters, int digit_characters
            , int special_characters, int min_characters, int max_characters, String password) {
        boolean response = true;
        /*check if string has special char*/
        int special_char_count = countSpecialChar(password);
        /*check if string has digit char*/
        int digit_char_count = getDigitCountFromString(password);
        /*check if string has lower case char */
        int lower_case_count = getLowerCaseCountFromString(password);
        /*check if string has upper case char */
        int upper_case_count = getUpperCaseCountFromString(password);
        if (special_characters != 0) {
            if (special_char_count < special_characters) {
                return response = false;
            }
        }
        if (digit_characters != 0) {
            if (digit_char_count < digit_characters) {
                return response = false;
            }
        }
        if (lower_case_characters != 0) {
            if (lower_case_count < lower_case_characters) {
                return response = false;
            }
        }
        if (upper_case_characters != 0) {
            if (upper_case_count < upper_case_characters) {
                return response = false;
            }
        }
        if (min_characters != 0) {
            if (password.length() < min_characters) {
                return response = false;
            }
        }
        if (max_characters != 0) {
            if (password.length() > max_characters) {
                return response = false;
            }
        }

        return response;
    }

    public static String passwordValidationMsg(int upper_case_characters, int lower_case_characters, int digit_characters
            , int special_characters, int min_characters, int max_characters) {
        String response_msg = "- Password  must  contain";

        if (special_characters != 0) {
            response_msg = response_msg + " " + special_characters + " special character";
        }
        if (digit_characters != 0) {
            response_msg = response_msg + ", " + digit_characters + " digit";
        }
        if (lower_case_characters != 0) {
            response_msg = response_msg + ", " + lower_case_characters + " lower case character";
        }
        if (upper_case_characters != 0) {
            response_msg = response_msg + ", " + upper_case_characters + " upper case character.";
        }
        if (max_characters != 0) {
            response_msg = response_msg + "\n\n" + "- Password  cannot  be  more  than " + max_characters + " character.";
        }
        if (min_characters != 0) {
            response_msg = response_msg + "\n\n" + "- Password  cannot  be  less  than " + min_characters + " character.";
        }

        return response_msg;
    }

    /*password Validation Alert*/
    public static void passwordValidationAlert(Context context, String msg) {
        AlertDialog alertDialog = new AlertDialog.Builder(
                context).create();
        alertDialog.setCancelable(true);
        // Setting Dialog Title
        alertDialog.setTitle("Error Alert!");
        // Setting Dialog Message
        alertDialog.setMessage(msg);
        // Setting OK Button
        alertDialog.setButton2("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        // Showing Alert Message
        alertDialog.show();
    }

    public static int countSpecialChar(String userInput) {
        if (userInput == null || userInput.trim().isEmpty()) {
            return 0;
        }
        int countSpecial = 0;

        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.substring(i, i + 1).matches("[^A-Za-z0-9]")) {
                countSpecial++;
            }

        }
        return countSpecial;
    }

    public static int getDigitCountFromString(String number) {
        int flag = 0;
        for (int i = 0; i < number.length(); i++) {
            if (Character.isDigit(number.charAt(i))) {
                flag++;
            }
        }
        return flag;
    }

    public static int getUpperCaseCountFromString(String str) {
        int flag = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                flag++;
            }
        }
        return flag;
    }

    public static int getLowerCaseCountFromString(String str) {
        int flag = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                flag++;
            }
        }
        return flag;
    }

    //////////// Convert simple time to AM and PM time
    public static String ConvertTime(String time) {
        Date date;
        String retuntime = "";
        ////////
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat sdfs = new SimpleDateFormat("hh:mm a");
        try {
            date = sdf.parse(time);
            retuntime = sdfs.format(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return retuntime;
    }

  //////////// Convert simple time to AM and PM time
    public static String getHoursTime(String time) {
        Date date;
        String retuntime = "";
        ////////
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat sdfs = new SimpleDateFormat("HH");
        try {
            date = sdf.parse(time);
            retuntime = sdfs.format(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return retuntime;
    }

 //////////// Convert simple time to AM and PM time
    public static String getMintsTime(String time) {
        Date date;
        String retuntime = "";
        ////////
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat sdfs = new SimpleDateFormat("mm");
        try {
            date = sdf.parse(time);
            retuntime = sdfs.format(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return retuntime;
    }

    public static String getDownloadedFiles(Context context, String fileName, String attachment_Type, String extension) {
        Log.e("getDownloadedFiles", " extension=" + extension + " attachment_Type=" + attachment_Type + " fileName=" + fileName);
        File returnFile = null;
        if (attachment_Type.equalsIgnoreCase("file")) {
            attachment_Type = extension;
        }
        String fileType = ".jpg";
        String DocType = "MergImages";
        if (attachment_Type.equalsIgnoreCase("PDF") || attachment_Type.equalsIgnoreCase("pdf")) {
            fileType = ".pdf";
            DocType = "MergDocuments";
        } else if (attachment_Type.equalsIgnoreCase("doc") || attachment_Type.equalsIgnoreCase("DOC")) {
            fileType = ".doc";
            DocType = "MergDocuments";
        } else if (attachment_Type.equalsIgnoreCase("docx") || attachment_Type.equalsIgnoreCase("DOCX")) {
            fileType = ".docx";
            DocType = "MergDocuments";
        } else if (attachment_Type.equalsIgnoreCase("TXT") || attachment_Type.equalsIgnoreCase("txt")) {
            fileType = ".txt";
            DocType = "MergDocuments";
        } else if (attachment_Type.equalsIgnoreCase("ppt") || attachment_Type.equalsIgnoreCase("PPT")) {
            fileType = ".ppt";
            DocType = "MergDocuments";
        } else if (attachment_Type.equalsIgnoreCase("pptx") || attachment_Type.equalsIgnoreCase("PPTX")) {
            fileType = ".pptx";
            DocType = "MergDocuments";
        } else if (attachment_Type.equalsIgnoreCase("xlsx") || attachment_Type.equalsIgnoreCase("XLSX")) {
            fileType = ".xlsx";
            DocType = "MergDocuments";
        } else if (attachment_Type.equalsIgnoreCase("xls") || attachment_Type.equalsIgnoreCase("XLS")) {
            fileType = ".xls";
            DocType = "MergDocuments";
        } else if (attachment_Type.equalsIgnoreCase("audio") || attachment_Type.equalsIgnoreCase("AUDIO")) {
            fileType = ".mp3";
            DocType = "MergAudios";
        } else if (attachment_Type.equalsIgnoreCase("video") || attachment_Type.equalsIgnoreCase("VIDEO")) {
            fileType = ".mp4";
            DocType = "MergVideos";
        } else if (attachment_Type.equalsIgnoreCase("photo") || attachment_Type.equalsIgnoreCase("photo")) {
            if (extension.contains("gif") || extension.contains("GIF")) {
                fileType = ".gif";
            } else if (extension.contains("png") || extension.contains("PNG")) {
                fileType = ".png";
            }

            DocType = "MergImages";
        }

        try {
            String root = Environment.getExternalStorageDirectory()
                    + "/Android/data/"
                    + context.getApplicationContext().getPackageName()
                    + "/" + DocType;

            returnFile = new File(root + "/" + fileName + fileType);
            if (!returnFile.exists()) {

            }
        } catch (Exception e) {

        }
        return returnFile.getAbsolutePath().trim();
    }

    public static File saveDownloadedFiles(Context context, String fileName, String attachment_Type, String extension) {

        File returnFile = null;
        OutputStream out;
        if (attachment_Type.equalsIgnoreCase("file")) {
            attachment_Type = extension;
        }
        String fileType = ".jpg";
        String DocType = "MergImages";
        if (attachment_Type.equalsIgnoreCase("PDF") || attachment_Type.equalsIgnoreCase("pdf")) {
            fileType = ".pdf";
            DocType = "MergDocuments";
        } else if (attachment_Type.equalsIgnoreCase("doc") || attachment_Type.equalsIgnoreCase("DOC")) {
            fileType = ".doc";
            DocType = "MergDocuments";
        } else if (attachment_Type.equalsIgnoreCase("docx") || attachment_Type.equalsIgnoreCase("DOCX")) {
            fileType = ".docx";
            DocType = "MergDocuments";
        } else if (attachment_Type.equalsIgnoreCase("TXT") || attachment_Type.equalsIgnoreCase("txt")) {
            fileType = ".txt";
            DocType = "MergDocuments";
        } else if (attachment_Type.equalsIgnoreCase("ppt") || attachment_Type.equalsIgnoreCase("PPT")) {
            fileType = ".ppt";
            DocType = "MergDocuments";
        } else if (attachment_Type.equalsIgnoreCase("pptx") || attachment_Type.equalsIgnoreCase("PPTX")) {
            fileType = ".pptx";
            DocType = "MergDocuments";
        } else if (attachment_Type.equalsIgnoreCase("xlsx") || attachment_Type.equalsIgnoreCase("XLSX")) {
            fileType = ".xlsx";
            DocType = "MergDocuments";
        } else if (attachment_Type.equalsIgnoreCase("xls") || attachment_Type.equalsIgnoreCase("XLS")) {
            fileType = ".xls";
            DocType = "MergDocuments";
        } else if (attachment_Type.equalsIgnoreCase("audio") || attachment_Type.equalsIgnoreCase("AUDIO")) {
            fileType = ".mp3";
            DocType = "MergAudios";
        } else if (attachment_Type.equalsIgnoreCase("video") || attachment_Type.equalsIgnoreCase("VIDEO")) {
            fileType = ".mp4";
            DocType = "MergVideos";
        } else if (attachment_Type.equalsIgnoreCase("photo") || attachment_Type.equalsIgnoreCase("photo")) {
            if (extension.contains("gif") || extension.contains("GIF")) {
                fileType = ".gif";
            } else if (extension.contains("png") || extension.contains("PNG")) {
                fileType = ".png";
            }

            DocType = "MergImages";
        }

        try {
            String root = Environment.getExternalStorageDirectory()
                    + "/Android/data/"
                    + context.getApplicationContext().getPackageName()
                    + "/" + DocType;
//            String root = Environment.getExternalStorageDirectory()
//                    + "/Merg/" + DocType;
            File createDir = new File(root);
            if (!createDir.exists()) {
                createDir.mkdirs();
            }
            returnFile = new File(createDir.getAbsolutePath() + "/" + fileName + fileType);
            returnFile.createNewFile();
            out = new FileOutputStream(returnFile);

            out.write(data);
            out.close();
        } catch (Exception e) {
            e.getMessage();
        }
        return returnFile;
    }

    public static interface BitmapDownloadCallback {
        void bitmapDownloaded(Bitmap bitmap);
    }

    public static void downloadBitmap(String url, BitmapDownloadCallback callback) {
        if (Build.VERSION.SDK_INT >= HONEYCOMB) {
            new GetBitmapFromURLAsync(callback).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, url);
        } else {
            new GetBitmapFromURLAsync(callback).execute(url);
        }
    }

    private static class GetBitmapFromURLAsync extends AsyncTask<String, Void, Bitmap> {
        BitmapDownloadCallback mBitmapDownloadCallback;

        public GetBitmapFromURLAsync(BitmapDownloadCallback mBitmapDownloadCallback) {
            this.mBitmapDownloadCallback = mBitmapDownloadCallback;
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            return getBitmapFromURL(params[0]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            mBitmapDownloadCallback.bitmapDownloaded(bitmap);
        }
    }

    public static Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setDefaultHostnameVerifier(new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, new X509TrustManager[]{new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] chain,
                                               String authType) throws CertificateException {
                }

                public void checkServerTrusted(X509Certificate[] chain,
                                               String authType) throws CertificateException {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }}, new SecureRandom());
            connection.setDefaultSSLSocketFactory(
                    context.getSocketFactory());


            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (Exception e) { // should never happen
            e.printStackTrace();
            return null;
        }


       /* try {

            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }*/
    }

    private static SSLSocketFactory getSSLSocketFactory() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            return sslSocketFactory;
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            return null;
        }

    }


    public static void printLog(String Tag, String message) {
        Log.e(Tag, " " + message);
    }

    /*dynamic home screen function*/

    /*org dynamic functions*/

    /*doctor dynamic actions functions*/



    /*Perpare message to send with attachment*/


    /* public static interface SessionAlertCallback{
         void continueProcess();
     }*/
    public static void showSessionAlert(Context context) {
        try {
            Activity activity = (Activity) context;
//            AlertDialog alertDialog = new AlertDialog.Builder(
//                    context).create();
//            alertDialog.setCancelable(false);
//            // Setting Dialog Title
//            alertDialog.setTitle("Alert!");
//            // Setting Dialog Message
//            alertDialog.setMessage("Session has been expired. Please relaunch the app.");
//            // Setting OK Button
//            alertDialog.setButton2("OK", new DialogInterface.OnClickListener() {
//                public void onClick(DialogInterface dialog, int which) {
//                    activity.finishAffinity();
//                    System.exit(0);
//                    alertDialog.dismiss();
//                }
//            });
//
//            // Showing Alert Message
//            alertDialog.show();
//            activity.finishAffinity();
//            System.exit(0);



        } catch (Exception e) {

        }


    }


    public static Bitmap imageBlur(Context context, Bitmap image) {
        final float BITMAP_SCALE = 0.4f;
        final float BLUR_RADIUS = 7.5f;

        int width = Math.round(image.getWidth() * BITMAP_SCALE);
        int height = Math.round(image.getHeight() * BITMAP_SCALE);

        Bitmap inputBitmap = Bitmap.createScaledBitmap(image, width, height, false);
        Bitmap outputBitmap = Bitmap.createBitmap(inputBitmap);

        RenderScript rs = RenderScript.create(context);
        ScriptIntrinsicBlur theIntrinsic = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        Allocation tmpIn = Allocation.createFromBitmap(rs, inputBitmap);
        Allocation tmpOut = Allocation.createFromBitmap(rs, outputBitmap);
        theIntrinsic.setRadius(BLUR_RADIUS);
        theIntrinsic.setInput(tmpIn);
        theIntrinsic.forEach(tmpOut);
        tmpOut.copyTo(outputBitmap);

        return outputBitmap;
    }


    public static String getRecordedCurrentDateOnly() {
        String current_date = "";
        String currentDatestr = "";
        try {
            Calendar calendar = Calendar.getInstance();
//            SimpleDateFormat mdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
            SimpleDateFormat mdformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
//            mdformat.setTimeZone(TimeZone.getTimeZone("UTC"));
            currentDatestr = "" + mdformat.format(calendar.getTime());
           /* Date date = mdformat.parse(currentDatestr);

            current_date = date.getTime();
*/
            current_date = currentDatestr;
        } catch (Exception e) {

        }
        return current_date;
        //  return currentDatestr;
    }

    public static String getCurrentExpiryDate() {
        String current_date = "";
        String currentDatestr = "";
        try {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat mdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//            SimpleDateFormat mdformat = new SimpleDateFormat("dd MMMM, yyyy");
//            mdformat.setTimeZone(TimeZone.getTimeZone("UTC"));
            currentDatestr = "" + mdformat.format(calendar.getTime());
           /* Date date = mdformat.parse(currentDatestr);

            current_date = date.getTime();
*/
            current_date = currentDatestr;
        } catch (Exception e) {

        }
        return current_date;
        //  return currentDatestr;
    }

    public static int getTimeDifferenceInMint(String date1_str, String date2_str) {
        int hours = 0;
        int mins = 0;
        try {
            SimpleDateFormat mdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date1 = mdformat.parse(date1_str);
            Date date2 = mdformat.parse(date2_str);

            long millis = date1.getTime() - date2.getTime();
            hours = (int) (millis / (1000 * 60 * 60));
            mins = (int) ((millis / (1000 * 60)) % 60);

        } catch (Exception e) {

        }
        return mins;
    }



}




