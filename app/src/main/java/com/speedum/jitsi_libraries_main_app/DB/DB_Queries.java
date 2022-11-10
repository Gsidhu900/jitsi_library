package com.speedum.jitsi_libraries_main_app.DB;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class DB_Queries {
    @Inject
    public DB_Queries() {

    }

    public static String delete_user_info = "delete from user_info";
    public static String delete_chat_history = "delete from chat_history";
    public static String delete_my_dentist = "delete from my_dentist";
    public static String delete_Gallery = "delete from gallery";
    public static String delete_OrgMedications = "delete from org_medication";
    public static String delete_OrgUserMedications = "delete from org_user_medication";
    public static String delete_chat_Dialogs = "delete from chat_group";
    public static String delete_org_video = "delete from org_videos";
    public static String delete_org_dialogs = "delete from server_chat_group";
    public static String delete_form_builder = "delete from form_builder_layout";
    public static String delete_patient_Partner = "delete from patient_partner";
    public static String delete_NotificationCount = "delete from notification_count";
    public static String delete_VisitID = "delete from extra_info_params";
    public static String delete_HomeScreen_Config = "delete from home_screen_config";
    public static String delete_chat_categories = "delete from chat_group_category";
    public static String get_visit_id = "Select vst_id from extra_info_params;";
    public static String get_org_groups = "select * from my_dentist GROUP By org_id";
    public static String get_my_dentist = "select * from my_dentist order by resource_name";
    public static String get_BottomBar_btn_Config_forChatLib = "select * from home_screen_config where menu_type='AppTabMenu' or menu_type='TabDrawerMenu' order by menu_display_order asc";
    public static String get_HomeScreen_btn_Config = "select * from home_screen_config where menu_type='HomeScreen' order by menu_display_order asc";
    public static String get_BottomBar_btn_Config = "select * from home_screen_config where menu_type='AppTabMenu' order by menu_display_order asc";
    public static String get_HomeScreen_PTNMenu_Config = "select * from home_screen_config where menu_type='LeftMenu' and menu_parent_id='' order by menu_display_order asc";
    public static String get_DashBoard_details = "select * from home_screen_config where menu_type='PatientMenu' order by menu_display_order asc";
    public static String get_occupant_ids = "select occupant_ids from chat_group";
    public static String get_Org_Medications = "select * from org_medication";
    public static String deletePatientReminder = "delete from patient_reminders";
    public static String delete_country_list = "delete from country_list";
    public static String delete_state_list = "delete from state_list";
    public static String get_curreny_sign = "Select curreny_sign from user_info;";
    public static String delete_cities_list = "delete from cities_list";
    public static String get_org_info = "Select * from org_info;";
    public static String get_org_currency = "Select org_currency from org_info;";
    public static String delete_org_info = "delete from org_info";
    public static String get_notificationCount = "select * from notification_count where notification_read_status='N'";
    public static String saveNotificationCount = "insert or replace into notification_count(notification_read_status) values(?);";
    public static String save_org_Info = "insert into org_info(org_id,org_code,org_name,org_currency) " +
            "values(?,?,?,?);";

    public static String savePatientReminder = "insert or replace into patient_reminders(row_id,medicine_id,user_medicine_id,dosage" +
            ",frequency,reminder_date,reminder_time,notes,medication_end_date,active_status" +
            ",system_generated_flag) values(?,?,?,?,?,?,?,?,?,?,?);";


    public static String GetCountriesNameList = "select cnt_description from country_list";

    public static String get_HomeScreen_ChildMenu_Config(String ptn_id) {
        String query = "select * from home_screen_config where menu_type='LeftMenu' and menu_parent_id='" + ptn_id + "' order by menu_display_order asc";
        return query;
    }

    public static String deleteMessage(String chatMessageId) {
        String query = "delete from chat_history  where msg_id_for_update='" + chatMessageId.trim() + "'";
        return query;
    }

    public static String deleteMessageFromDB(String chatMessageId) {
        String query = "delete from chat_history  where msg_id='" + chatMessageId.trim() + "'";
        return query;
    }

    public static String get_Org_MedicationsSearch(String search_txt) {
        String query = "select * from org_medication where mdcn_name like '%" + search_txt + "%'";
        return query;
    }

    public static String get_Org_MedicationsName(String medicine_id) {
        String query = "select mdcn_name from org_medication where id='" + medicine_id.trim() + "'";
        return query;
    }

    public static String getGalleryData(String GalleryName) {
//        String query="select * from gallery where category='" + GalleryName.trim() + "'";
        String query = "select * from gallery where category='" + GalleryName.trim() + "' and asset_type='image_gallery'";
        return query;
    }

    public static String getGalleryDataVideo(String GalleryName) {
        String query = "select * from gallery where category='" + GalleryName.trim() + "' and asset_type='video'";
        return query;
    }

    public static String getReminders(String date) {
        String query = "select id,row_id,medicine_id,user_medicine_id,dosage" +
                ",frequency,reminder_date,reminder_time,notes,medication_end_date,active_status" +
                ",system_generated_flag from patient_reminders where reminder_date='" + date + "'";
        return query;
    }

    public static String SaveDownloadedMedia = "insert or replace into downloaded_chat_media(media_id,media_path) values(?,?);";

    public static String save_user_info = "insert into user_info(resource_id,usr_id,org_id,rol_id,patient_id" +
            ",usr_quickblox_id,usr_quickblox_login_id,doctor_id,usr_onboarding_status,usr_role,rol_name,usr_loginid" +
            ",usr_phone,usr_email,usr_name,usr_org_selection_popup_flag,usr_role_selection_popup_flag,org_name" +
            ",org_lat,org_long,org_profile_image,usr_city_id,usr_gender_code,user_hlt_ver_flag,user_phone_ver_flag" +
            ",usr_address,usr_postal_code,usr_dob,usr_quickblox_name) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

    public static String save_HomeScreen_Config = "insert into home_screen_config(menu_name,menu_title,menu_image,menu_color,menu_title_color," +
            "menu_action_screen_identifier,menu_screen_title,menu_static_header_text,menu_empty_screen_text,menu_call_button," +
            "menu_url,menu_download,menu_icon,menu_text,menu_enable_feature,menu_parent_id,menu_type,menu_display_order" +
            ",menu_id,menu_action_screen_identifier_detail,menu_action_screen_identifier_detail_json) " +
            "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

    public static String save_form_builder_data = "insert into form_builder_layout(field_id,form_id,form_code,form_submission_reference_key,form_save_process_id,section_id" +
            ",section_label,section_sequence,section_page_no,field_code,field_label,field_control_type,field_options,ff_id" +
            ",ff_row_no,ff_column_no,ff_mandatory_flag) " +
            "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

    public static String save_invite_code_user_info = "insert into user_info(resource_id,usr_id,org_id,rol_id,patient_id,usr_quickblox_id" +
            ",usr_quickblox_login_id,doctor_id,usr_onboarding_status,usr_role,rol_name,usr_loginid,usr_phone,usr_email" +
            ",usr_name,usr_org_selection_popup_flag,usr_role_selection_popup_flag,org_name,org_lat,org_long,org_profile_image" +
            ",usr_city_id,usr_gender_code,user_hlt_ver_flag,user_phone_ver_flag,usr_address,usr_postal_code,usr_dob,usr_quickblox_name,visit_id,curreny_sign,patient_photo) " +
            "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    public static String save_org_videos = "insert into org_videos(id,org_id,video_category,video_url,video_alt,video_sequence" +
            ",video_title,active_status) " +
            "values(?,?,?,?,?,?,?,?);";

    public static String save_org_dialogs = "insert into server_chat_group(cg_id,contact_group_name,contact_group_type" +
            ",icon_class_name,contact_group_image,contact_group_description" +
            ",qb_dialog_joining_type) " +
            "values(?,?,?,?,?,?,?);";

    public static String save_patient_partners = "insert into patient_partner(ptmp_id,ptm_id_partner" +
            ",ptmp_relation,ptm_name,ptm_mr_number,usr_id,selected_profile,patient_photo) values(?,?,?,?,?,?,?,?);";

    public static String save_chat_categories = "insert into chat_group_category(id,cg_id" +
            ",contact_group_name,contact_group_type,icon_class_name) values(?,?,?,?,?);";

    public static String save_Org_Gallery = "insert into gallery(p_org_asset_id,title,category,url,alt,sequence,asset_type) values(?,?,?,?,?,?,?);";
    public static String save_Org_Medication = "insert into org_medication(id,mdcn_code,mdcn_name,mdcn_description,mdcn_manufacturer) values(?,?,?,?,?);";
    public static String save_Org_User_Medication = "insert into org_user_medication(id,mdcn_name,created_by_patient_id) values(?,?,?);";

    public static String save_my_dentist = "insert into my_dentist(id,org_id,org_code,org_name,org_profile_image,resource_id" +
            ",resource_name,resource_profile_picture,resource_qualification,resource_languages_known,resource_short_description," +
            "resource_long_description,dpt_description,mapping_type,mapping_status,qb_dialog_id,favorite_flag" +
            ",doctor_short_description,doctor_full_description,doctor_opd_schedule,doctor_booking_flag) " +
            "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";


    public static String SaveGroupsInDB = "insert into chat_group(merg_group_id,dialog_id,merg_title,room_jid," +
            "quickblox_id,merg_image_url,last_msg_datetime,last_msg,last_msg_username,occupant_ids" +
            ",unread_count,caterogy_id,is_admin,read_only,user_ids,creater_QB_ID,usr_role_id,category_type" +
            ",org_ids,creater_user_id,dialog_type,cg_id) " +
            "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

    public static String save_VisitID = "insert into extra_info_params(vst_id) " +
            "values(?);";


    public static String get_org_videos = "select * from org_videos where active_status='Yes' order by video_sequence asc";
    public static String get_org_videos_cats = "select DISTINCT(video_category) from org_videos where active_status='Yes' order by video_sequence asc";
//    public static String get_chat_groups_patient = "select mg.merg_group_id,mg.dialog_id,sc.org_name AS merg_title,mg.room_jid,mg.user_row_id,mg.quickblox_id\n" +
//            ",sc.org_profile_image AS merg_image_url,mg.flag,mg.last_msg_datetime,mg.last_msg_datetime,mg.last_msg" +
//            ",mg.last_msg_username,mg.occupant_ids,mg.other_profile_ids,mg.unread_count,mg.group_type_flag" +
//            ",mg.is_read_only,mg.merg_private,mg.is_draft,mg.other_user_data,mg.creater_data from server_chat_group as sc " +
//            "INNER JOIN merg_group as mg on mg.dialog_id=sc.qb_dialog_id order by mg.last_msg_datetime desc";
//
//    public static String get_chat_groups_Staff = "select mg.merg_group_id,mg.dialog_id,sc.usr_quickblox_name AS merg_title,mg.room_jid,mg.user_row_id" +
//            ",mg.quickblox_id,'' AS merg_image_url,mg.flag,mg.last_msg_datetime,mg.last_msg_datetime,mg.last_msg" +
//            ",mg.last_msg_username,mg.occupant_ids,mg.other_profile_ids,mg.unread_count,mg.group_type_flag" +
//            ",mg.is_read_only,mg.merg_private,mg.is_draft,mg.other_user_data,mg.creater_data " +
//            "from server_chat_group as sc INNER JOIN merg_group as mg on mg.dialog_id=sc.qb_dialog_id order by " +
//            "mg.last_msg_datetime desc";

    public static String get_chat_groups_patient = "select * FROM chat_group where dialog_type<>'conference' order by last_msg_datetime desc";

    public static String get_chat_groups_Staff = "select * FROM chat_group order by last_msg_datetime desc";

    public static String get_UnJoined_dialogs = "SELECT * FROM server_chat_group WHERE cg_id NOT IN (SELECT cg_id FROM chat_group)";

    public static String SaveChatMsgInDB = "insert or replace into chat_history(msg_dialog_id,msg_id,msg_body,msg_time_sent" +
            ",msg_user_name,msg_user_Image,msg_type,msg_date_sent" +
            ",msg_sender_id,msg_attachment_path,msg_attachment_type,msg_attachment_id" +
            ",msg_attach_sent_flag,msg_attach_url,msg_attach_received_flag,msg_like_count,msg_comment_count,msg_attachment_ext" +
            ",msg_attachment_fileName,msg_id_for_update,user_profile_id,caption_text,reply_msg_type,reply_msg_sender_name,reply_msg_file_name" +
            ",reply_msg_attchement_type,reply_msg_id,reply_msg_body,read,updated_at,sent_time,sort_timestamp,msg_status" +
            ") values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    public static String get_user_dob = "Select usr_dob from user_info;";
    public static String get_user_id = "Select usr_id from user_info;";
    public static String get_qb_name = "Select usr_quickblox_name from user_info;";
    public static String get_patient_id = "Select patient_id from user_info;";
    public static String get_role_id = "Select rol_id from user_info;";
    public static String get_usr_email = "Select usr_email from user_info;";
    public static String get_usr_phone = "Select usr_phone from user_info;";
    public static String get_usr_gender_code = "Select usr_gender_code from user_info;";
    public static String get_resource_id = "Select resource_id from user_info;";
    public static String get_user_profile = "Select * from user_info;";
    public static String get_page_count = "select DISTINCT(section_page_no) from form_builder_layout;";
    public static String get_org_id = "Select org_id from user_info;";
//    public static String get_org_id = "Select org_id from org_info;";
    public static String get_unread_count = "select sum(unread_count) as count from chat_group where unread_count>0;";
    public static String get_org_name = "Select org_name from user_info;";
    public static String get_org_lat = "Select org_lat from user_info;";
    public static String get_org_long = "Select org_long from user_info;";
    public static String get_org_profile = "Select org_profile_image from user_info;";
    public static String get_user_name = "Select usr_name from user_info;";
    public static String get_user_phone_check = "Select user_phone_ver_flag from user_info;";
    public static String get_user_rol = "Select rol_name from user_info;";
    public static String get_user_org_id = "Select org_id from user_info;";
    public static String get_user_onboarding_status = "Select usr_onboarding_status from user_info;";
    public static String get_user_LoginID = "Select usr_quickblox_login_id from user_info;";
    public static String get_user_QbID = "Select usr_quickblox_id from user_info;";
    public static String get_All_DialogIDS = "select dialog_id from chat_group;";
    public static String GetOfflineChatHistoryFromDB = "select * from chat_history where msg_status='0' order by msg_time_sent,msg_date_sent";

    public static String get_patient_partners = "Select * from patient_partner;";


    public static String get_org_video_Filter(List<String> mFilter_List) {
        String allCats = "";
        if (mFilter_List.size() > 0) {
            for (int i = 0; i < mFilter_List.size(); i++) {
                String cat = mFilter_List.get(i);
                if (allCats.equalsIgnoreCase("")) {
                    allCats = "'" + cat + "'";
                } else {
                    allCats = allCats + ",'" + cat + "'";
                }
            }
        }
        String query = "select * from org_videos where active_status='Yes' and video_category in (";
        query = query + allCats + ") order by video_sequence asc";
        return query;
    }

    public static String get_Chat_History(String dialog_id, int count) {
        String query = "select * from chat_history where msg_dialog_id='" + dialog_id.trim() + "' order by msg_date_sent desc LIMIT 0," + count;

        return query;
    }

    public static String get_Chat_HistoryToDelete(String dialog_id) {
        String query = "delete from chat_history where msg_dialog_id='" + dialog_id.trim() + "'";

        return query;
    }

    public static String get_Chat_LoadMore(String dialog_id, int totalcount, int showingcount) {
        String query = "select * from chat_history where msg_dialog_id='" + dialog_id.trim() + "' order by msg_date_sent desc LIMIT " + totalcount + "," + showingcount;

        return query;
    }

    public static String get_update_msg_Status(String dialog_id) {
        String query = "Update chat_history set msg_type='N' where msg_dialog_id='" + dialog_id.trim() + "'";

        return query;
    }

    public static String get_update_msg_Status2(String dialog_id, String msg_id) {
        String query = "Update chat_history set msg_status='2' where msg_dialog_id='" + dialog_id + "' and msg_id='" + msg_id + "'";

        return query;
    }

    public static String get_temp_msg(String dialog_id) {
        String query = "select * from chat_history where msg_dialog_id='" + dialog_id.trim() + "' order by msg_date_sent desc LIMIT 1";

        return query;
    }

    public static String get_last_msg_date(String dialog_id) {
        String query = "select msg_date_sent from chat_history where msg_dialog_id='" + dialog_id.trim() + "' order by msg_date_sent DESC LIMIT 1";

        return query;
    }

    public static String getCountryID(String CountryName) {
        String query = "select cnt_id from country_list where cnt_description='" + CountryName.trim() + "'";
        return query;
    }

    public static String getCountryName(String CountryID) {
        String query = "select cnt_description from country_list where cnt_id='" + CountryID.trim() + "'";
        return query;
    }

    public static String delete_addresses = "delete from address";

    public static String delete_addresses(String address_id) {
        String query = "delete from address where p_patadd_id='" + address_id + "'";
        return query;
    }


    public static String save_countries = "insert into country_list" +
            "(cnt_id,cnt_code,cnt_description,cnt_status,cnt_default_flag,cnt_modify_timestamp,cnt_modify_user,cnt_create_timestamp,cnt_create_user)" +
            " values(?,?,?,?,?,?,?,?,?);";

    public static String save_state_list = "insert into state_list" +
            "(stt_id,stt_code,stt_description,cnt_id,stt_status,stt_default_flag,stt_modify_timestamp,stt_modify_user,stt_create_timestamp,stt_create_user)" +
            " values(?,?,?,?,?,?,?,?,?,?);";

    public static String save_cities = "insert into cities_list" +
            "(cit_id,cit_code,cit_description,stt_id,cit_status,cit_default_flag,cit_modify_timestamp,cit_modify_user,cit_create_timestamp,cit_create_user)" +
            " values(?,?,?,?,?,?,?,?,?,?);";


    public static String get_AddressesByID(String addressId) {
        String query = "select * from address where p_patadd_id='" + addressId.trim() + "'";

        return query;
    }

    public static String get_Addresses = "select * from address";
    public static String save_Address = "insert into address" +
            "(p_patadd_id,p_address,p_street,p_pcode,p_city,p_province,p_country,city_desc,state_desc,coutry_desc,patadd_first_name,patadd_last_name,patadd_phone_no,default_address_flag,p_add_type,add_type_desc,image_path)" +
            " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";


    public static String getStateID(String StateName) {
        String query = "select stt_id from state_list where stt_description='" + StateName.trim() + "'";
        return query;
    }

    public static String getStateName(String StateID) {
        String query = "select stt_description from state_list where stt_id='" + StateID.trim() + "'";
        return query;
    }

    public static String getCityName(String CityID) {
        String query = "select cit_description from cities_list where cit_id='" + CityID.trim() + "'";
        return query;
    }

    public static String getCityID(String CityName) {
        String query = "select cit_id from cities_list where cit_description='" + CityName.trim() + "'";
        return query;
    }


    public static String getStateList(String CountryID) {
        String query = "select stt_description from state_list where cnt_id='" + CountryID.trim() + "'";
        return query;
    }

    public static String getCityList(String State) {
        String query = "select cit_description from cities_list where stt_id='" + State.trim() + "'";
        return query;
    }

    public static String update_unread_count(String dialog_id) {
        String query = "Update chat_group set unread_count='0' where dialog_id='" + dialog_id.trim() + "'";

        return query;
    }

    public static String get_Dialog_info(String dialog_id) {
        String query = "select * from chat_group where dialog_id='" + dialog_id.trim() + "'";

        return query;
    }

    public static String update_Chat_Msg(String update_date, String last_msg, String count, String dialog_id) {
        String query = "Update chat_group set last_msg_datetime='" + update_date + "',last_msg='" + last_msg + "',unread_count='" + count + "' where dialog_id='" + dialog_id.trim() + "'";

        return query;
    }

    public static String get_chat_msg_count(String dialog_id) {
        String query = "select COUNT(*) from chat_history where msg_dialog_id='" + dialog_id + "' order by msg_date_sent desc limit 1";

        return query;
    }

    public static String get_last_msg_id(String dialog_id) {
        String query = "select msg_id from chat_history where msg_dialog_id='" + dialog_id + "' order by msg_date_sent desc limit 1";

        return query;
    }

    public static String GetDialogsByID(String DialogID) {
        String Query = "select * from chat_group " +
                "where dialog_id='" + DialogID.trim() + "' order by last_msg_datetime desc";
        return Query;
    }

    public static String Update_Chat_History_MsgSent(String dialog_id, String msgId) {
        String Query = "Update chat_history set msg_status='1' where msg_dialog_id='" + dialog_id + "' and msg_id='" + msgId + "'";
        return Query;
    }

    public static String clearUnreadCount(String count, String dialog_id) {
        String query = "Update chat_group set unread_count='" + count + "' where dialog_id='" + dialog_id + "'";

        return query;
    }

    public static String get_single_chat_dialog_Staff(String dialog_id) {
        String query = "select * from chat_group where dialog_id='" + dialog_id + "' order by last_msg_datetime desc";

        return query;
    }

    public static String get_single_chat_dialog_patient(String dialog_id) {
        String query = "select * from chat_group where dialog_id='" + dialog_id + "' order by last_msg_datetime desc";

        return query;
    }

    public static String get_chat_category() {
        String query = "select * from chat_group_category order by cg_id";

        return query;
    }

    public static String getPushTitleStaff(String dialog_id) {
        String query = "select merg_title from chat_group where dialog_id='" + dialog_id + "'";

        return query;
    }

    public static String getPushTitlePatient(String dialog_id) {
        String query = "select merg_title from chat_group where dialog_id='" + dialog_id + "'";

        return query;
    }

    public static String getPatientQbID(String dialog_id) {
        String query = "select usr_quickblox_id from server_chat_group where qb_dialog_id='" + dialog_id + "'";

        return query;
    }

    public static String getPageLayout(String page_no) {
        String query = "select * from form_builder_layout where section_page_no='" + page_no + "' order by section_id,section_page_no,ff_row_no,ff_column_no asc";

        return query;
    }

    public static String get_chat_groups_patient_name(String dialog_id) {
        String query = "select merg_title from chat_group where dialog_id='" + dialog_id + "'";

        return query;
    }

    public static String get_chat_groups_Staff_name(String dialog_id) {
        String query = "select merg_title from chat_group where dialog_id='" + dialog_id + "'";

        return query;
    }


    public static String get_dialog_offline_Msgs(String dialog_id) {
        String query = "select * from chat_history where msg_status='0' and msg_dialog_id='" + dialog_id + "' order by msg_time_sent,msg_date_sent";

        return query;
    }

    public static ArrayList<String> ClearAllTables() {
        ArrayList<String> Query = new ArrayList<>();
        Query.add("delete from chat_history");
        Query.add("delete from chat_group");
        Query.add("delete from form_builder_layout");
        Query.add("delete from my_dentist");
        Query.add("delete from org_videos");
        Query.add("delete from user_info");
        return Query;
    }

    public static String update_user_info(String user_id, String patient_id) {
        String query = "Update user_info set usr_id='" + user_id + "',patient_id='" + patient_id + "';";

        return query;
    }

    /*Patient app queries below*/
    public static String save_color_config = "insert into app_color_config(app_top_bar_color,app_positive_button," +
            "app_negative_button,app_button_color,app_icon_color,app_default_color,app_dark_theme_color," +
            "app_medium_theme,app_light_theme_color,app_logo,app_link_color,topbar_icons_color,topbar_title_color,org_filter_keywords,doctor_filter_keywords,app_icon_color_2,app_default_color_2) " +
            "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

    public static String delete_color_config = "delete from app_color_config";

    public static String get_color_config = "select * from app_color_config";

    public static String delete_select_dialog(String dialogId) {
        String query = "delete from chat_group where dialog_id='" + dialogId.trim() + "';";

        return query;
    }

    public static String get_chat_groups_patient(String cat_id) {
        String query = "";
        if (cat_id.length() > 0) {
            query = "select * FROM chat_group where caterogy_id='" + cat_id.trim() + "' and dialog_type<>'conference' order by last_msg_datetime desc;";
        } else {
            query = "select * FROM chat_group where dialog_type<>'conference' order by last_msg_datetime desc;";
        }


        return query;
    }

    public static String get_Single_chat_groups_patient(String cat_id, String dialogID) {
        String query = "select * FROM chat_group where caterogy_id='" + cat_id.trim() + "' and dialog_id='" + dialogID.trim() + "' order by last_msg_datetime desc;";

        return query;
    }

    public static String search_chat_groupswithCat(String cat_id, String searchText) {
        String query = "select * FROM chat_group where caterogy_id='" + cat_id.trim() + "' and merg_title like '%" + searchText + "%' order by last_msg_datetime desc;";

        return query;
    }

    public static String get_chat_groups_Staff(String cat_id) {
        String query = "select * FROM chat_group where caterogy_id='" + cat_id.trim() + "' order by last_msg_datetime desc;";

        return query;
    }

    public static String search_chat_groups(String searchText) {
        String query = "select * FROM chat_group where merg_title like '%" + searchText + "%' order by last_msg_datetime desc;";

        return query;
    }

    public static String get_categoryType(String cat_id) {
        String query = "select contact_group_type FROM chat_group_category where cg_id='" + cat_id.trim() + "';";

        return query;
    }

}