package com.speedum.jitsi_libraries_main_app.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import com.speedum.jitsi_libraries_main_app.API.APIModels.GetColorConfig.GetColorConfigResponse.ColorConfigModel;
import com.speedum.jitsi_libraries_main_app.API.APIModels.HomeScreenConfig.HomeScreenConfigResponse.HomeScreenConfigReturnDatum;
import com.speedum.jitsi_libraries_main_app.API.APIModels.Login_User.LoginReturnData;
import com.speedum.jitsi_libraries_main_app.API.APIModels.OrgInfo.GetOrgIDReturnDatum;
import com.speedum.jitsi_libraries_main_app.DI.ApplicationContext;
import com.speedum.jitsi_libraries_main_app.DI.DatabaseInfo;
import com.speedum.jitsi_libraries_main_app.Util.Util;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class DBHelper extends SQLiteAssetHelper {

    private Context mContext;
    private SQLiteDatabase db;
    private static String Lock = "dblock";

    @Inject
    public DBHelper(@ApplicationContext Context context, @DatabaseInfo String dbName,
                    @DatabaseInfo Integer version) {
        super(context, dbName, null, version);
        this.mContext = context;
        this.db = getWritableDatabase();
    }


    /*getting single column data from table*/
    public String getSingleColumnData(String Query) {
        String data = "";
        synchronized (Lock) {
            /*Create and/or open the database for writing*/
//            SQLiteDatabase db = getWritableDatabase();
            try {
                db.beginTransaction();
                String query = Query;
                Cursor c = getReadableDatabase().rawQuery(query, null);
                if (c.moveToFirst()) {
                    do {
                        data = c.getString(0);
                    } while (c.moveToNext());
                }
                c.close();
                db.setTransactionSuccessful();
                db.endTransaction();
//                db.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    /*delete data from table*/
    public void DeleteDataFromTable(String Query) {
        synchronized (Lock) {
            try {
                /*Create and/or open the database for writing*/
//                SQLiteDatabase db = getWritableDatabase();
                db.beginTransaction();
                db.execSQL(Query);
                db.setTransactionSuccessful();
                db.endTransaction();
//                db.close();
            } catch (Exception localException) {
                localException.printStackTrace();
            }
        }
    }

    /*save  chat categories in local DB*/
    public void saveOrgInfoInDB(List<GetOrgIDReturnDatum> cat_list, String query) {
        try {
            synchronized (Lock) {
                /*Create and/or open the database for writing*/
//                SQLiteDatabase db = getWritableDatabase();
                SQLiteStatement statement = db.compileStatement(query);
                db.beginTransaction();
                if (cat_list.size() > 0) {
                    for (int i = 0; i < cat_list.size(); i++) {
                        String org_id = Util.encryptData(Util.CheckForNullValue(cat_list.get(i).getOrgId()));
                        String org_code = Util.encryptData(Util.CheckForNullValue(cat_list.get(i).getOrgCode()));
                        String org_name = Util.encryptData(Util.CheckForNullValue(cat_list.get(i).getOrgName()));
                        String org_currency = Util.encryptData(Util.CheckForNullValue(cat_list.get(i).getOrg_currency()));

                        /*Adding data in DB*/
                        statement.clearBindings();
                        statement.bindString(1, org_id);
                        statement.bindString(2, org_code);
                        statement.bindString(3, org_name);
                        statement.bindString(4, org_currency);

                        statement.execute();
                    }
                }
                db.setTransactionSuccessful();
                db.endTransaction();
            }
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    /*deleting all the tables data*/
    public void DeleteAllTableData(ArrayList<String> Query) {
        synchronized (Lock) {
            // Create and/or open the database for writing
//            SQLiteDatabase db = getWritableDatabase();
            try {
                db.beginTransaction();
                for (int i = 0; i < Query.size(); i++) {
                    String query = Query.get(i).toString();
                    db.execSQL(query);
                }
                //DO some db writing
                db.setTransactionSuccessful();
                db.endTransaction();
//                db.close();
            } catch (Exception localException) {
                localException.printStackTrace();
            }
        }
    }

    /*update data from table*/
    public void UpdateDataFromTable(String Query) {
        try {
            synchronized (Lock) {
                /*Create and/or open the database for writing*/
//                SQLiteDatabase db = getWritableDatabase();
                db.beginTransaction();
                db.execSQL(Query);
                db.setTransactionSuccessful();
                db.endTransaction();
//                db.close();
            }
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    /*save org videos in local DB*/
    public void saveVisitID(String VisitID, String query) {
        try {
            synchronized (Lock) {
                /*Create and/or open the database for writing*/
//                SQLiteDatabase db = getWritableDatabase();

                SQLiteStatement statement = db.compileStatement(query);
                db.beginTransaction();

                String visitId = Util.encryptData(Util.CheckForNullValue(VisitID));
                /*saving data in local DB*/
                statement.clearBindings();
                statement.bindString(1, visitId);
                statement.execute();

                db.setTransactionSuccessful();
                db.endTransaction();
//                db.close();
            }
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }


    /*Application function starts from here*/
    /*saving load data in local DB*/

    public void saveUserLoginDataInDB(List<LoginReturnData> returnData, String query) {
        try {
            synchronized (Lock) {
                /*Create and/or open the database for writing*/
//                SQLiteDatabase db = getWritableDatabase();
                SQLiteStatement statement = db.compileStatement(query);
                db.beginTransaction();
                if (returnData.size() > 0) {
                    for (int i = 0; i < returnData.size(); i++) {

                        LoginReturnData loginReturnData = returnData.get(i);
                        String usr_email = Util.encryptData(Util.CheckForNullValue(loginReturnData.getUsrEmail()));
                        String usr_phone = Util.encryptData(Util.CheckForNullValue(loginReturnData.getUsrPhone()));
                        String usr_id = Util.encryptData(Util.CheckForNullValue(loginReturnData.getUsrId()));
                        String usr_name = Util.encryptData(Util.CheckForNullValue(loginReturnData.getUsrName()));
                        String usr_loginid = Util.encryptData(Util.CheckForNullValue(loginReturnData.getUsrLoginid()));
                        String rol_id = Util.encryptData(Util.CheckForNullValue(loginReturnData.getRolId()));
                        String rol_name = Util.encryptData(Util.CheckForNullValue(loginReturnData.getRolName()));
                        String usr_org_selection_popup_flag = Util.encryptData(Util.CheckForNullValue(loginReturnData.getUsrOrgSelectionPopupFlag()));
                        String usr_role_selection_popup_flag = Util.encryptData(Util.CheckForNullValue(loginReturnData.getUsrRoleSelectionPopupFlag()));
                        String usr_role = Util.encryptData(Util.CheckForNullValue(loginReturnData.getUsrRole()));
                        String usr_onboarding_status = Util.encryptData(Util.CheckForNullValue(loginReturnData.getUsrOnboardingStatus()));
                        String org_id = Util.encryptData(Util.CheckForNullValue(loginReturnData.getOrgId()));
                        String resource_id = Util.encryptData(Util.CheckForNullValue(loginReturnData.getResourceId()));
                        String doctor_id = Util.encryptData(Util.CheckForNullValue(loginReturnData.getDoctorId()));
                        String patient_id = Util.encryptData(Util.CheckForNullValue(loginReturnData.getPatientId()));
                        String usr_quickblox_login_id = Util.encryptData(Util.CheckForNullValue(loginReturnData.getUsrQuickbloxLoginId()));
                        String usr_quickblox_id = Util.encryptData(Util.CheckForNullValue(loginReturnData.getUsrQuickbloxId()));
                        /*checking if quickbloxs id is not null then save to shared prefrances*/
                        if (!usr_quickblox_id.equalsIgnoreCase("")) {
                            sharedPrefrances.saveQuickBloxID(mContext, usr_quickblox_id);
                        }
                        String org_name = Util.encryptData(Util.CheckForNullValue(loginReturnData.getOrgName()));
                        String org_latitude = Util.encryptData(Util.CheckForNullValue(loginReturnData.getOrgLatitude()));
                        String org_longitude = Util.encryptData(Util.CheckForNullValue(loginReturnData.getOrgLongitude()));
                        String org_profile_image = Util.encryptData(Util.CheckForNullValue(loginReturnData.getOrgProfileImage()));
                        String usr_city_id = Util.encryptData(Util.CheckForNullValue(loginReturnData.getUsrCityId()));
                        String usr_gender_code = Util.encryptData(Util.CheckForNullValue(loginReturnData.getUsrGenderCode()));
                        String usr_healthcard_number_verified_flag = Util.encryptData(Util.CheckForNullValue(loginReturnData.getUsrHealthcardNumberVerifiedFlag()));
                        String usr_phone_number_verified_flag = Util.encryptData(Util.CheckForNullValue(loginReturnData.getUsrPhoneNumberVerifiedFlag()));
                        String usr_address = Util.encryptData(Util.CheckForNullValue(loginReturnData.getUsrAddress()));
                        String usr_postal_code = Util.encryptData(Util.CheckForNullValue(loginReturnData.getUsrPostalCode()));
                        String usr_dob = Util.encryptData(Util.CheckForNullValue(loginReturnData.getUsrDob()));
                        String usr_quickblox_name = Util.encryptData(Util.CheckForNullValue(loginReturnData.getUsr_quickblox_name()));
                        String curreny_sign = Util.encryptData(Util.CheckForNullValue(loginReturnData.getCurreny_sign()));
                        String visit_id = Util.encryptData(Util.CheckForNullValue(loginReturnData.getVisit_id()));

                        /*saving data in local DB*/
                        statement.clearBindings();
                        statement.bindString(1, resource_id);
                        statement.bindString(2, usr_id);
                        statement.bindString(3, org_id);
                        statement.bindString(4, rol_id);
                        statement.bindString(5, patient_id);
                        statement.bindString(6, usr_quickblox_id);
                        statement.bindString(7, usr_quickblox_login_id);
                        statement.bindString(8, doctor_id);
                        statement.bindString(9, usr_onboarding_status);
                        statement.bindString(10, usr_role);
                        statement.bindString(11, rol_name);
                        statement.bindString(12, usr_loginid);
                        statement.bindString(13, usr_phone);
                        statement.bindString(14, usr_email);
                        statement.bindString(15, usr_name);
                        statement.bindString(16, usr_org_selection_popup_flag);
                        statement.bindString(17, usr_role_selection_popup_flag);
                        statement.bindString(18, org_name);
                        statement.bindString(19, org_latitude);
                        statement.bindString(20, org_longitude);
                        statement.bindString(21, org_profile_image);

                        statement.bindString(22, usr_city_id);
                        statement.bindString(23, usr_gender_code);
                        statement.bindString(24, usr_healthcard_number_verified_flag);
                        statement.bindString(25, usr_phone_number_verified_flag);
                        statement.bindString(26, usr_address);
                        statement.bindString(27, usr_postal_code);
                        statement.bindString(28, usr_dob);
                        statement.bindString(29, usr_quickblox_name);
//                        statement.bindString(30, visit_id);
//                        statement.bindString(31, curreny_sign);
                        statement.execute();
                    }
                }
                db.setTransactionSuccessful();
                db.endTransaction();
//                db.close();
            }
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }
    public int getNotificationCountDB() {
        String Query=DB_Queries.get_notificationCount;
        // Create and/or open the database for writing
        ArrayList<String> arr = new ArrayList<String>();
        synchronized (Lock) {
//            SQLiteDatabase db = getWritableDatabase();
            try {

                String query = Query;
                Cursor c = getReadableDatabase().rawQuery(query, null);
                db.beginTransaction();
                if (c.moveToFirst()) {
                    do {
                        String notification = c.getString(0);

                        arr.add(notification);
                    } while (c.moveToNext());
                }
                c.close();
                //DO some db writing
                db.setTransactionSuccessful();
                db.endTransaction();
//                db.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int count=arr.size();
        return count;
    }


    /*save  notification count in local DB*/

    /*save user info when user verify invite code*/

    /*save countries in local DB*/

    public ArrayList<String> GetSingleColumnArray(String query) {
        ArrayList<String> arr = new ArrayList<>();
        synchronized (Lock) {
//            SQLiteDatabase db = getWritableDatabase();
            db.beginTransaction();
            try {
                Cursor c = getReadableDatabase().rawQuery(query, null);
                if (c.moveToFirst()) {
                    do {
                        String resultColumn = Util.CheckForNullValue(c.getString(0));

                        arr.add(resultColumn);

                    } while (c.moveToNext());
                }
                c.close();
                db.setTransactionSuccessful();
                db.endTransaction();
//                db.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arr;
    }


    /*save States in local DB*/


    /*save countries in local DB*/



    /*save org videos in local DB*/

    /*save org videos in local DB*/
    public void saveColorConfigInDB(ColorConfigModel colorConfigModel, String query) {
        try {
            synchronized (Lock) {
                /*Create and/or open the database for writing*/
//                SQLiteDatabase db = getWritableDatabase();
                DeleteDataFromTable(DB_Queries.delete_color_config);
                SQLiteStatement statement = db.compileStatement(query);
                db.beginTransaction();

                String app_top_bar_color = Util.CheckForNullValue(colorConfigModel.getAppTopBarColor());
                String app_positive_button = Util.CheckForNullValue(colorConfigModel.getAppPositiveButton());
                String app_negative_button = Util.CheckForNullValue(colorConfigModel.getAppNegativeButton());
                String app_button_color = Util.CheckForNullValue(colorConfigModel.getAppButtonColor());
                String app_icon_color = Util.CheckForNullValue(colorConfigModel.getAppIconColor());
                String app_default_color = Util.CheckForNullValue(colorConfigModel.getAppDefaultColor());
                String app_dark_theme_color = Util.CheckForNullValue(colorConfigModel.getAppDarkThemeColor());
                String app_medium_theme = Util.CheckForNullValue(colorConfigModel.getAppMediumTheme());
                String app_light_theme_color = Util.CheckForNullValue(colorConfigModel.getAppLightThemeColor());
                String app_logo = Util.CheckForNullValue(colorConfigModel.getAppLogo());
                String app_link_color = Util.CheckForNullValue(colorConfigModel.getAppLinkColor());
                String topbar_icons_color = Util.CheckForNullValue(colorConfigModel.getTopbar_icons_color());
                String topbar_title_color = Util.CheckForNullValue(colorConfigModel.getMtopbar_title_color());
                String org_filter_keywords = Util.CheckForNullValue(colorConfigModel.getOrg_filter_keywords());
                String doctor_filter_keywords = Util.CheckForNullValue(colorConfigModel.getDoctor_filter_keywords());
                String app_icon_color_2 = Util.CheckForNullValue(colorConfigModel.getAppIconColor_2());
                String app_default_color_2 = Util.CheckForNullValue(colorConfigModel.getAppDefaultColor_2());

                /*saving data in local DB*/
                statement.clearBindings();
                statement.bindString(1, app_top_bar_color);
                statement.bindString(2, app_positive_button);
                statement.bindString(3, app_negative_button);
                statement.bindString(4, app_button_color);
                statement.bindString(5, app_icon_color);
                statement.bindString(6, app_default_color);
                statement.bindString(7, app_dark_theme_color);
                statement.bindString(8, app_medium_theme);
                statement.bindString(9, app_light_theme_color);
                statement.bindString(10, app_logo);
                statement.bindString(11, app_link_color);
                statement.bindString(12, topbar_icons_color);
                statement.bindString(13, topbar_title_color);
                statement.bindString(14, org_filter_keywords);
                statement.bindString(15, doctor_filter_keywords);

                statement.bindString(16, app_icon_color_2);
                statement.bindString(17, app_default_color_2);

                statement.execute();
            }
            db.setTransactionSuccessful();
            db.endTransaction();
//                db.close();
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    /*save org videos in local DB*/

    /*save  chat categories in local DB*/

    /*fetch videos from local DB*/
    public ColorConfigModel getColorConfigFormDB(String Query) {
        ColorConfigModel model = new ColorConfigModel();
        synchronized (Lock) {
//            SQLiteDatabase db = getWritableDatabase();
            db.beginTransaction();
            try {
                String query = Query;
                Cursor c = getReadableDatabase().rawQuery(query, null);
                if (c.moveToFirst()) {
                    do {

                        model.setAppTopBarColor(Util.CheckForNullValue(c.getString(0)));
                        model.setAppPositiveButton(Util.CheckForNullValue(c.getString(1)));
                        model.setAppNegativeButton(Util.CheckForNullValue(c.getString(2)));
                        model.setAppButtonColor(Util.CheckForNullValue(c.getString(3)));
                        model.setAppIconColor(Util.CheckForNullValue(c.getString(4)));
                        model.setAppDefaultColor(Util.CheckForNullValue(c.getString(5)));
                        model.setAppDarkThemeColor(Util.CheckForNullValue(c.getString(6)));
                        model.setAppMediumTheme(Util.CheckForNullValue(c.getString(7)));
                        model.setAppLightThemeColor(Util.CheckForNullValue(c.getString(8)));
                        model.setAppLogo(Util.CheckForNullValue(c.getString(9)));
                        model.setAppLinkColor(Util.CheckForNullValue(c.getString(10)));
                        model.setTopbar_icons_color(Util.CheckForNullValue(c.getString(11)));
                        model.setMtopbar_title_color(Util.CheckForNullValue(c.getString(12)));
                        model.setOrg_filter_keywords(Util.CheckForNullValue(c.getString(13)));
                        model.setDoctor_filter_keywords(Util.CheckForNullValue(c.getString(14)));
                        model.setAppIconColor_2(Util.CheckForNullValue(c.getString(15)));
                        model.setAppDefaultColor_2(Util.CheckForNullValue(c.getString(16)));

                    } while (c.moveToNext());
                }
                c.close();
                db.setTransactionSuccessful();
                db.endTransaction();
//                db.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return model;
    }

    /*save countries in local DB*/

    /*Save Address*/

    /*Getting Cities from local db*/

    /*Getting States from local db*/

    /*Getting Countries from local db*/
    public GetOrgIDReturnDatum getOrgInfoFormDB(String Query) {
        GetOrgIDReturnDatum model = new GetOrgIDReturnDatum();
        synchronized (Lock) {
//            SQLiteDatabase db = getWritableDatabase();
            db.beginTransaction();
            try {
                String query = Query;
                Cursor c = getReadableDatabase().rawQuery(query, null);
                if (c.moveToFirst()) {
                    do {
                        model.setOrgId(Util.CheckForNullValue(Util.decryptData(c.getString(0))));
                        model.setOrgCode(Util.CheckForNullValue(Util.decryptData(c.getString(1))));
                        model.setOrgName(Util.CheckForNullValue(Util.decryptData(c.getString(2))));
                        model.setOrg_currency(Util.CheckForNullValue(Util.decryptData(c.getString(3))));

                    } while (c.moveToNext());
                }
                c.close();
                db.setTransactionSuccessful();
                db.endTransaction();
//                db.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return model;
    }


    /*getting home screen configuration from local DB*/
    public void saveHomeScrenConfigDB(List<HomeScreenConfigReturnDatum> HomeConfig, String query) {
        try {
            synchronized (Lock) {
                /*Create and/or open the database for writing*/
//                SQLiteDatabase db = getWritableDatabase();
                DeleteDataFromTable(DB_Queries.delete_HomeScreen_Config);
                SQLiteStatement statement = db.compileStatement(query);
                db.beginTransaction();
                if (HomeConfig.size() > 0) {
                    for (int i = 0; i < HomeConfig.size(); i++) {
                        String menu_name = Util.CheckForNullValue(HomeConfig.get(i).getMenuName());
                        String menu_title = Util.CheckForNullValue(HomeConfig.get(i).getMenuTitle());
                        String menu_image = Util.CheckForNullValue(HomeConfig.get(i).getMenuImage());
                        String menu_color = Util.CheckForNullValue(HomeConfig.get(i).getMenuColor());
                        String menu_title_color = Util.CheckForNullValue(HomeConfig.get(i).getMenuTitleColor());
                        String menu_action_screen_identifier = Util.CheckForNullValue(HomeConfig.get(i).getMenuActionScreenIdentifier());
                        String menu_screen_title = Util.CheckForNullValue(HomeConfig.get(i).getMenuScreenTitle());
                        String menu_static_header_text = Util.CheckForNullValue(HomeConfig.get(i).getMenuStaticHeaderText());
                        String menu_empty_screen_text = Util.CheckForNullValue(HomeConfig.get(i).getMenuEmptyScreenText());
                        String menu_call_button = Util.CheckForNullValue(HomeConfig.get(i).getMenuCallButton());
                        String menu_url = Util.CheckForNullValue(HomeConfig.get(i).getMenuUrl());
                        String menu_download = Util.CheckForNullValue(HomeConfig.get(i).getMenuDownload());
                        String menu_icon = Util.CheckForNullValue(HomeConfig.get(i).getMenuIcon());
                        String menu_text = Util.CheckForNullValue(HomeConfig.get(i).getMenuText());
                        String menu_enable_feature = Util.CheckForNullValue(HomeConfig.get(i).getMenuEnableFeature());

                        String menu_parent_id = Util.CheckForNullValue(HomeConfig.get(i).getMenuParent_id());
                        String menu_type = Util.CheckForNullValue(HomeConfig.get(i).getMenuType());
                        String menu_display_order = Util.CheckForNullValue(HomeConfig.get(i).getMenuDisplay_order());
                        String menu_id = Util.CheckForNullValue(HomeConfig.get(i).getMenuId());
                        String menu_action_screen_identifier_detail = Util.CheckForNullValue(HomeConfig.get(i).getMenu_action_screen_identifier_detail());
                        String menu_action_screen_identifier_detail_json = Util.CheckForNullValue(HomeConfig.get(i).getMenu_action_screen_identifier_detail_json());

                        /*Adding data in DB*/
                        statement.clearBindings();
                        statement.bindString(1, menu_name);
                        statement.bindString(2, menu_title);
                        statement.bindString(3, menu_image);
                        statement.bindString(4, menu_color);
                        statement.bindString(5, menu_title_color);
                        statement.bindString(6, menu_action_screen_identifier);
                        statement.bindString(7, menu_screen_title);
                        statement.bindString(8, menu_static_header_text);
                        statement.bindString(9, menu_empty_screen_text);
                        statement.bindString(10, menu_call_button);
                        statement.bindString(11, menu_url);
                        statement.bindString(12, menu_download);
                        statement.bindString(13, menu_icon);
                        statement.bindString(14, menu_text);
                        statement.bindString(15, menu_enable_feature);
                        statement.bindString(16, menu_parent_id);
                        statement.bindString(17, menu_type);
                        statement.bindString(18, menu_display_order);
                        statement.bindString(19, menu_id);
                        statement.bindString(20, menu_action_screen_identifier_detail);
                        statement.bindString(21, menu_action_screen_identifier_detail_json);
                        statement.execute();
                    }
                }
                db.setTransactionSuccessful();
                db.endTransaction();
//                db.close();
            }
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }


    /*getting home screen configuration from local DB*/
    public List<HomeScreenConfigReturnDatum> getHomeScreen_Config(String Query) {
        List<HomeScreenConfigReturnDatum> arr = new ArrayList<>();
        synchronized (Lock) {
//            SQLiteDatabase db = getWritableDatabase();
            db.beginTransaction();
            try {
                String query = Query;
                Cursor c = getReadableDatabase().rawQuery(query, null);
                if (c.moveToFirst()) {
                    do {
                        HomeScreenConfigReturnDatum returnDatum = new HomeScreenConfigReturnDatum();
                        returnDatum.setMenuName(Util.CheckForNullValue(c.getString(0)));
                        returnDatum.setMenuTitle(Util.CheckForNullValue(c.getString(1)));
                        returnDatum.setMenuImage(Util.CheckForNullValue(c.getString(2)));
                        returnDatum.setMenuColor(Util.CheckForNullValue(c.getString(3)));
                        returnDatum.setMenuTitleColor(Util.CheckForNullValue(c.getString(4)));
                        returnDatum.setMenuActionScreenIdentifier(Util.CheckForNullValue(c.getString(5)));
                        returnDatum.setMenuScreenTitle(Util.CheckForNullValue(c.getString(6)));
                        returnDatum.setMenuStaticHeaderText(Util.CheckForNullValue(c.getString(7)));
                        returnDatum.setMenuEmptyScreenText(Util.CheckForNullValue(c.getString(8)));
                        returnDatum.setMenuCallButton(Util.CheckForNullValue(c.getString(9)));
                        returnDatum.setMenuUrl(Util.CheckForNullValue(c.getString(10)));
                        returnDatum.setMenuDownload(Util.CheckForNullValue(c.getString(11)));
                        returnDatum.setMenuIcon(Util.CheckForNullValue(c.getString(12)));
                        returnDatum.setMenuText(Util.CheckForNullValue(c.getString(13)));
                        returnDatum.setMenuEnableFeature(Util.CheckForNullValue(c.getString(14)));
                        returnDatum.setMenuParent_id(Util.CheckForNullValue(c.getString(15)));
                        returnDatum.setMenuType(Util.CheckForNullValue(c.getString(16)));
                        returnDatum.setMenuDisplay_order(Util.CheckForNullValue(c.getString(17)));
                        returnDatum.setMenuId(Util.CheckForNullValue(c.getString(18)));
                        returnDatum.setMenu_action_screen_identifier_detail(Util.CheckForNullValue(c.getString(19)));
                        returnDatum.setMenu_action_screen_identifier_detail_json(Util.CheckForNullValue(c.getString(20)));
                        arr.add(returnDatum);
                    } while (c.moveToNext());
                }
                c.close();
                db.setTransactionSuccessful();
                db.endTransaction();
//                db.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return arr;
    }



    /*fetch user profile from local DB*/
    public List<LoginReturnData> getUserProfileFormDB(String Query) {
        List<LoginReturnData> arr = new ArrayList<LoginReturnData>();
        synchronized (Lock) {
//            SQLiteDatabase db = getWritableDatabase();
            db.beginTransaction();
            try {
                String query = Query;
                Cursor c = getReadableDatabase().rawQuery(query, null);
                if (c.moveToFirst()) {
                    do {
                        String usr_email = Util.decryptData(c.getString(13));
                        String usr_phone = Util.decryptData(c.getString(12));
                        String usr_id = Util.decryptData(c.getString(1));
                        String usr_name = Util.decryptData(c.getString(14));
                        String usr_loginid = Util.decryptData(c.getString(11));
                        String rol_id = Util.decryptData(c.getString(3));
                        String rol_name = Util.decryptData(c.getString(10));
                        String usr_org_selection_popup_flag = Util.decryptData(c.getString(15));
                        String usr_role_selection_popup_flag = Util.decryptData(c.getString(16));
                        String usr_role = Util.decryptData(c.getString(9));
                        String usr_onboarding_status = Util.decryptData(c.getString(8));
                        String org_id = Util.decryptData(c.getString(2));
                        String resource_id = Util.decryptData(c.getString(0));
                        String doctor_id = Util.decryptData(c.getString(7));
                        String patient_id = Util.decryptData(c.getString(4));
                        String usr_quickblox_login_id = Util.decryptData(c.getString(6));
                        String usr_quickblox_id = Util.decryptData(c.getString(5));
                        String org_name = Util.decryptData(c.getString(17));
                        String org_latitude = Util.decryptData(c.getString(18));
                        String org_longitude = Util.decryptData(c.getString(19));
                        String org_profile_image = Util.decryptData(c.getString(20));
                        String usr_city_id = Util.decryptData(c.getString(21));
                        String usr_gender_code = Util.decryptData(c.getString(22));
                        String usr_healthcard_number_verified_flag = Util.decryptData(c.getString(23));
                        String usr_phone_number_verified_flag = Util.decryptData(c.getString(24));
                        String usr_address = Util.decryptData(c.getString(25));
                        String usr_postal_code = Util.decryptData(c.getString(26));
                        String usr_dob = Util.decryptData(c.getString(27));
                        String usr_quickblox_name = Util.decryptData(c.getString(28));
                        String visit_id = Util.decryptData(c.getString(29));
                        String currency_sign = Util.decryptData(c.getString(30));
                        String patient_photo = Util.decryptData(c.getString(31));

                        arr.add(new LoginReturnData(usr_email, usr_phone, usr_id, usr_name, usr_loginid
                                , rol_id, rol_name, usr_org_selection_popup_flag, usr_role_selection_popup_flag
                                , usr_role, usr_onboarding_status, org_id, resource_id, doctor_id
                                , patient_id, usr_quickblox_login_id, usr_quickblox_id, org_name, org_latitude
                                , org_longitude, org_profile_image, usr_city_id, usr_gender_code, usr_healthcard_number_verified_flag
                                , usr_phone_number_verified_flag, usr_address, usr_postal_code, usr_dob, usr_quickblox_name, patient_photo, currency_sign,visit_id));

                    } while (c.moveToNext());
                }
                c.close();
                db.setTransactionSuccessful();
                db.endTransaction();
//                db.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return arr;
    }

    /*fetch videos from local DB*/


    /*getting chat group list from DB*/

    /*fetch chat category list from DB*/

    public String getLastMsgID(String Query) {
        // Create and/or open the database for writing
        String data = "";
        synchronized (Lock) {
//            SQLiteDatabase db = getWritableDatabase();
            db.beginTransaction();
            try {
                String query = Query;
                Cursor c = getReadableDatabase().rawQuery(query, null);
                if (c.moveToFirst()) {
                    do {
                        data = c.getString(0);
                    } while (c.moveToNext());
                }
                c.close();
                db.setTransactionSuccessful();
                db.endTransaction();
//                db.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public String getChatHistoryForListFromDB(String Query) {
        String data = "";
        // Create and/or open the database for writing
        synchronized (Lock) {
//            SQLiteDatabase db = getWritableDatabase();
            db.beginTransaction();
            try {

                String query = Query;
                Cursor c = getReadableDatabase().rawQuery(query, null);
                if (c.moveToFirst()) {
                    do {
                        String msg_body = c.getString(2);
                        String msg_date_sent = c.getString(7);
                        String attachment_file_path = c.getString(9);
                        String msg_attach_url = c.getString(13);
                        String msg_attach_type = c.getString(10);
                        if (msg_attach_url == null) {
                            msg_attach_url = "";
                        }
                        if (attachment_file_path.length() > 0 || msg_attach_url.length() > 0) {
                            if (msg_attach_type.equalsIgnoreCase("photo")) {
                                msg_body = "\uD83D\uDCF7 Photo";
                            } else if (msg_attach_type.equalsIgnoreCase("INFO_MSG")) {
                                msg_body = msg_body;
                            } else {
                                msg_body = "\uD83D\uDDC4 Document";
                            }
                        }
                        data = msg_body + "~" + msg_date_sent;
                    } while (c.moveToNext());
                }
                c.close();
                //DO some db writing
                db.setTransactionSuccessful();
                db.endTransaction();
//                db.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    /*get chat history from local DB*/




    public ArrayList<String> getAllDialogIDSFromDB(String Query) {
        // Create and/or open the database for writing
        ArrayList<String> arr = new ArrayList<String>();
        synchronized (Lock) {
//            SQLiteDatabase db = getWritableDatabase();
            try {

                String query = Query;
                Cursor c = getReadableDatabase().rawQuery(query, null);
                db.beginTransaction();
                if (c.moveToFirst()) {
                    do {
                        String dialog_id = c.getString(0);

                        arr.add(dialog_id);
                    } while (c.moveToNext());
                }
                c.close();
                //DO some db writing
                db.setTransactionSuccessful();
                db.endTransaction();
//                db.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arr;
    }


    /*fetch offline messages from local DB*/

    public void updateChatMsg(String Query) {
        // Create and/or open the database for writing
        synchronized (Lock) {
//            SQLiteDatabase db = getWritableDatabase();
            db.beginTransaction();
            try {
                db.execSQL(Query);
                //DO some db writing
                db.setTransactionSuccessful();
                db.endTransaction();
//                db.close();
            } catch (Exception localException) {
                localException.printStackTrace();
            }
        }
    }

    /*save  my dentist in local DB*/

    /*fetch videos from local DB*/

    /*save  org dialogs in local DB*/

    /*save  org dialogs in local DB*/

    /*getting chat group list from DB*/

    /*get all the occupants from the dialogs to send subscription request*/


    /*save  org dialogs in local DB*/

    /*fetch form builder data from local DB*/

    /*get all the occupants from the dialogs to send subscription request*/
    public ArrayList<String> getAllpageNumbers(String Query) {
        String data = "";
        ArrayList<String> page_numbers = new ArrayList<String>();
        synchronized (Lock) {
            /*Create and/or open the database for writing*/
//            SQLiteDatabase db = getWritableDatabase();

            try {
                db.beginTransaction();
                String query = Query;
                Cursor c = getReadableDatabase().rawQuery(query, null);
                if (c.moveToFirst()) {
                    do {
                        data = c.getString(0);
                        /*logic to separate and add to array*/
                        if (data.length() > 0) {
                            page_numbers.add(data);
                        }
                    } while (c.moveToNext());
                }
                c.close();
                db.setTransactionSuccessful();
                db.endTransaction();
//                db.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return page_numbers;
    }

    /*save patient partner in local DB*/

    /*fetch patient profile data*/


    /*Return list or org medications*/






    public interface SaveDataInDB{
        void saveDone();
    }




    /*Update media which has been downloaded*/
    public void UpdateDownloadedMediaPath(String media_ID, String mediaPath) {
        // Create and/or open the database for writing
//        SQLiteDatabase db = getWritableDatabase();

        try {
            synchronized (Lock) {
                String sql = DB_Queries.SaveDownloadedMedia;
                SQLiteStatement statement = db.compileStatement(sql);
                db.beginTransaction();

                String Media_ID = Util.CheckForNullValue(media_ID);
                String MediaPath = Util.CheckForNullValue(mediaPath);

                ////////////Adding data in DB
                statement.clearBindings();
                statement.bindString(1, Media_ID);
                statement.bindString(2, MediaPath);
                statement.execute();


                //DO some db writing
                db.setTransactionSuccessful();
                db.endTransaction();
            }
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }



}



