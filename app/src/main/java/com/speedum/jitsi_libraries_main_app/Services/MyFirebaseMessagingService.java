package com.speedum.jitsi_libraries_main_app.Services;

/**
 * Created by Nitin Sood on 07-10-2016.
 */

import android.util.Log;

//import com.google.firebase.messaging.FirebaseMessagingService;
//import com.google.firebase.messaging.RemoteMessage;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.speedum.jitsi_libraries_main_app.DB.DBHelper;
import com.speedum.jitsi_libraries_main_app.DB.DB_Queries;
import com.speedum.jitsi_libraries_main_app.DI.Components.ServiceComponent;
import com.speedum.jitsi_libraries_main_app.Util.Util;

import javax.inject.Inject;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Inject
    DBHelper mDbHelper;
    private ServiceComponent mServiceComponent;

    private static final String TAG = MyFirebaseMessagingService.class.getSimpleName();


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
//        Log.e("Nitin","MyFirebaseMessagingService");
        /*init dagger*/
//        getServiceComponent().inject(this);
        Log.e("onMessageReceived ","Vhelp_provider");
        String dialog_id = remoteMessage.getData().get("dialog_id");
        if(dialog_id==null){
            if (remoteMessage.getNotification() != null) {
                String title=remoteMessage.getNotification().getTitle();
                String body=remoteMessage.getNotification().getBody();
                /*showing push on notification screen*/
//                Log.e("Nitin","generateNotification2");
//                generateNotification2(this,body,title);
            }
        }else{
//            QB_Config qb_config=new QB_Config(getBaseContext());
//            Chat_Group_Model row_data =qb_config.getDialogInfo(dialog_id.trim());
//            QBChatDialog dialog = qb_config.getDialogFromDB(dialog_id);

            String message = remoteMessage.getData().get("message");
            String dialog_name = "";
            /*checking user role*/
            String user_rol = Util.decryptData(mDbHelper.getLastMsgID(DB_Queries.get_user_rol));
            /*checking is logged in user is patient or staff member*/
            if (user_rol.equalsIgnoreCase("PATIENT")) {
                dialog_name = mDbHelper.getLastMsgID(DB_Queries.getPushTitlePatient(dialog_id));
            } else {
                dialog_name = mDbHelper.getLastMsgID(DB_Queries.getPushTitleStaff(dialog_id));
            }

            if (message != null) {
//                Log.e("Nitin","generateNotification");
//                generateNotification(this, message, dialog_name, dialog_id);
            }
        }
    }

//    public ServiceComponent getServiceComponent() {
//        if (mServiceComponent == null) {
//            mServiceComponent = DaggerServiceComponent.builder()
//                    .service_Module(new Service_Module(this))
//                    .applicationComponent(My_Application.get(this).getComponent())
//                    .build();
//        }
//        return mServiceComponent;
//    }

/*
    private void generateNotification(Context context, String message, String title, String dialog_id) {
        try {
            String NOTIFICATION_CHANNEL_ID = "4565";
            CharSequence channelName = "vDent";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            /////////// Multiple msgs in one logic/////
            if (Util.mNotification_msg.containsKey(dialog_id)) {
                String msg = QB_Util.mNotification_msg.get(dialog_id);
                msg = msg + "~" + message;
                QB_Util.mNotification_msg.put(dialog_id, msg);
            } else {
                QB_Util.mNotification_msg.put(dialog_id, message);
            }
            String mMessage = QB_Util.mNotification_msg.get(dialog_id);
            Intent notificationIntent = null;
            long when = System.currentTimeMillis();
            int requestID = (int) System.currentTimeMillis();
//            int requestID = Integer.parseInt(from);
            NotificationManager notificationManager = (NotificationManager) context
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            ///// Logic to filter click on basis of function name from backend
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                AudioAttributes att = new AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                        .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                        .build();

                NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, channelName, importance);
                notificationChannel.enableLights(true);
                notificationChannel.setLightColor(Color.RED);
                notificationChannel.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION), att);
                notificationChannel.enableVibration(true);
                notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                notificationManager.createNotificationChannel(notificationChannel);
            }
            String user_rol = Util.decryptData(mDbHelper.getLastMsgID(DB_Queries.get_user_rol));
            */
/*checking is logged in user is patient or staff member*//*

            if (user_rol.equalsIgnoreCase("PATIENT")) {
                notificationIntent = new Intent(context,
                        Splash_Screen_View.class);
            } else {
                notificationIntent = new Intent(context,
                        Splash_Screen_View.class);
            }
            notificationIntent.putExtra("BackButton", "No");
            notificationIntent.putExtra("Flag", "Single");
            notificationIntent.putExtra("Open_Chat", "Yes");
            notificationIntent.putExtra("dialog_id", dialog_id);
            // set intent so it does not start a new activity
            notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                    | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            notificationIntent.setAction(Intent.ACTION_MAIN);
            notificationIntent.addCategory(Intent.CATEGORY_LAUNCHER);
            PendingIntent intent = PendingIntent.getActivity(context, 0,
                    notificationIntent, PendingIntent.FLAG_ONE_SHOT);
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                    MyFirebaseMessagingService.this);

            mBuilder.setSmallIcon(R.drawable.ic_notification).setTicker(MyFirebaseMessagingService.this.getResources().getString(R.string.app_name)).setWhen(0)
                    .setAutoCancel(true)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setContentIntent(intent)
                    .setChannelId(NOTIFICATION_CHANNEL_ID)
                    .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                    .setLargeIcon(BitmapFactory.decodeResource(MyFirebaseMessagingService.this.getResources(), R.drawable.ic_notification))
                    .build();
            //////
            NotificationCompat.InboxStyle inboxStyle =
                    new NotificationCompat.InboxStyle();
            if (mMessage.length() > 0) {
                if (mMessage.contains("~")) {
                    String[] array = mMessage.split("~");
                    for (int i = 0; i < array.length; i++) {
                        if (i <= 4) {
                            inboxStyle.addLine(array[i]);
                        } else {
                            inboxStyle.setSummaryText(array.length + " messages");
                            break;
                        }
                    }
                } else {
                    inboxStyle.addLine(mMessage);
                }
            }
            ////
            mBuilder.setStyle(inboxStyle);
//            Notification notification = new Notification.InboxStyle(mBuilder)
//                    .setBigContentTitle(title)
////                    .setSummaryText("+3 more")
//                    .build();
            notificationManager.notify(dialog_id, 0, mBuilder.build());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
*/


/*
    private void generateNotification2(Context context, String message, String title) {
        try {
            String NOTIFICATION_CHANNEL_ID = "4565";
            CharSequence channelName = "vDent";
            int importance = NotificationManager.IMPORTANCE_HIGH;

            Intent notificationIntent = null;
            NotificationManager notificationManager = (NotificationManager) context
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            ///// Logic to filter click on basis of function name from backend
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                AudioAttributes att = new AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                        .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                        .build();

                NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, channelName, importance);
                notificationChannel.enableLights(true);
                notificationChannel.setLightColor(Color.RED);
                notificationChannel.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION), att);
                notificationChannel.enableVibration(true);
                notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                notificationManager.createNotificationChannel(notificationChannel);
            }

            String user_rol = Util.decryptData(mDbHelper.getLastMsgID(DB_Queries.get_user_rol));
            */
/*checking is logged in user is patient or staff member*//*

            if (user_rol.equalsIgnoreCase("PATIENT")) {
                notificationIntent = new Intent(context,
                        HomeScreen.class);
            } else {
                notificationIntent = new Intent(context,
                        HomeScreen.class);
            }
            notificationIntent.putExtra("Flag", "Normal");
//            notificationIntent.putExtra("dialog_id", dialog_id);
            // set intent so it does not start a new activity
            notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                    | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            notificationIntent.setAction(Intent.ACTION_MAIN);
            notificationIntent.addCategory(Intent.CATEGORY_LAUNCHER);
            PendingIntent intent = PendingIntent.getActivity(context, 0,
                    notificationIntent, PendingIntent.FLAG_ONE_SHOT);
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                    MyFirebaseMessagingService.this);

            mBuilder.setSmallIcon(R.drawable.ic_notification).setTicker(MyFirebaseMessagingService.this.getResources().getString(R.string.app_name)).setWhen(0)
                    .setAutoCancel(true)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setContentIntent(intent)
                    .setChannelId(NOTIFICATION_CHANNEL_ID)
                    .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                    .setLargeIcon(BitmapFactory.decodeResource(MyFirebaseMessagingService.this.getResources(), R.drawable.ic_notification))
                    .build();
            notificationManager.notify(0, mBuilder.build());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
*/
}