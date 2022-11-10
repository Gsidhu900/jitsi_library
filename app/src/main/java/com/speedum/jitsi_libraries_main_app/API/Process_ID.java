package com.speedum.jitsi_libraries_main_app.API;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Process_ID {

    @Inject
    public Process_ID() {
    }

    /* Process ids of APIs*/
//    public static String LOGIN_USER = "vdentconf_validate_user";
    public static String LOGIN_USER = "validate_user"; /*New process Id for Patient app*/
//    public static String LOGIN_USER = "hospapp_validate_user"; /*New process Id for Patient app*/
    public static String GET_CITY = "vdentconf_get_ct_city";
    public static String CancelOrder = "XCEL_MED2DOOR_update_trn_order_details_status";
    public static String Reorder = "XCEL_MED2DOOR_save_trn_order_details_reorderV2";
    public static String Get_OrderMedications = "xcelrcmconfig_get_mst_services_search_v2";
    public static String Get_SearchOrderMedications = "xcelrcmconfig_get_mst_services_search_v2";
    public static String GetOrderDetail = "XCEL_MED2DOOR_get_trn_order_details_by_id";
    public static String GetUploadedPrescriptions = "XCEL_MED2DOOR_get_uploaded_prescription_image";
    public static String GetOrderList = "XCEL_MED2DOOR_get_trn_order_details_list_for_patient";
    public static String Fetch_Meetings = "sgchat_get_trn_meeting_details";
//    public static String REGISTER_USER = "vdent_save_mst_user_for_signup"; // vDent
    public static String REGISTER_USER = "hospapp_save_mst_user_for_signup";  /*New process Id for Patient app*/
    public static String SUBMIT_CARD_DETAILS = "vdentconf_update_mst_usr_details";
    public static String UPDATE_PASSWORD = "vdentconf_update_mst_usr_password";
    public static String SEARCH_clinics = "vdentconf_get_orgs";
    public static String GetOrgID = "sgconf_get_mst_organization_by_ai_code";
    public static String SEARCH_Doctor = "vdentconf_get_mst_resources";
    public static String Get_Org_Wall = "hospapp_get_organisation";
    public static String Get_Doctor_Wall = "hospapp_get_resources";
    public static String GetAttendees = "speedum.libraries_main_app_get_mst_user_list_for_assessment_assignment";
    public static String GetAssessments = "speedum.libraries_main_app_get_trn_visit_assessment_for_patient_filled_by_patient";
    public static String Submit_doctor_mapping = "vdent_save_trn_mst_usr_org_doctor_mapping";
    public static String Update_Onboard_Status = "vdentconf_update_trn_mst_usr_onboarding_status";
    public static String Verify_Invite_Code = "vdent_get_trn_mst_usr_invites_for_validation";
    public static String Fetch_Org_Banners = "vdent_get_org_banners";
//    public static String Fetch_Org_Videos = "vdent_get_mst_org_videos";
    public static String Fetch_Org_Videos = "hospapp_get_mst_org_videos";
//    public static String Fetch_User_Profile = "vdentconf_get_mst_user_profile_details";
    public static String SaveMood = "speedum.libraries_main_app_save_trn_patient_emr_mental_health_mood_checkin";
    public static String Fetch_User_Profile = "hospapp_get_mst_user_profile_details";
//    public static String Fetch_User_Profile = "XCEL_MED2DOOR_get_mst_user_profile_details_med2door";
    public static String GetHealthFeeling = "speedum.libraries_main_appconf_get_mst_emr_mental_health_feeling";
    public static String GetHealthActivities = "speedum.libraries_main_appconf_get_mst_emr_mental_health_activity";
    public static String Fetch_resource_App = "xcelsch_get_trn_resource_appointments";
//    public static String Update_Appt_Status = "vdent_save_trn_appointment_to_arrival_status";
    public static String Update_Appt_Status = "hospapp_save_trn_appointment_to_arrival_status";
    public static String Mark_Complete = "xcelrcm_update_trn_visit_for_stage";
    public static String Update_Visit_Stage = "xcelrcm_get_trn_visit_for_video_consult_queue_details";
    public static String Fetch_My_dentist = "vdent_get_trn_mst_usr_org_doctor_mapping";
    public static String Fetch_Org_Dialogs = "vdent_get_usr_org_dialogs";
//    public static String Fetch_Consent_form = "vdentconf_get_mst_consent_forms";
    public static String Fetch_Consent_form = "hospapp_get_mst_consent_forms ";
    public static String Fetch_Form_Layout = "sgconf_get_fb_mst_form_layout";
    public static String Save_Form_Submit = "vdent_save_trn_mst_usr_consent_form_submissions";
    public static String Change_Password = "vdentconf_update_mst_usr_password_change_password";
    public static String submit_feedback = "hospitalapp_save_org_feedback";
    public static String Fetch_Panels_Details = "hospitalapp_get_org_panels";
    public static String Get_PaymentMethods = "XCEL_MED2DOOR_CONFIG_get_ct_payment_mode";
    public static String Save_Update_Cart_Item = "xcel_MED2Door_save_item_in_cart_healthstore";
    public static String Get_VisitID = "XCEL_MED2DOOR_fetch_current_visit_id";
    public static String Save_Final_Order = "XCEL_MED2DOOR_save_charges_for_orderV2";
    public static String Process_Order = "XCEL_MED2DOOR_update_order_statusV2";
    public static String Get_GrandTotal = "xcelMed2Door_get_trn_orders_grand_totalV2";
    public static String Get_CartItems = "xcelMed2Door_get_trn_order_all_for_current_visit_med2DoorV2";
    public static String Delete_Cart_Item = "xcelrcm_save_trn_order_cancelV2";
    public static String Get_Address_List = "XCEL_MED2DOOR_get_trn_patient_master_address_list";
    public static String Get_DefaultAddress = "XCEL_MED2DOOR_get_trn_patient_master_default_address";
    public static String Delete_Address = "XCEL_MED2DOOR_delete_trn_patient_address";
    public static String Get_Country_List = "XCEL_MED2DOOR_get_country_master";
    public static String Save_Address = "XCEL_MED2DOOR_save_trn_patient_master_address_med";
    public static String Get_State_List = "XCEL_MED2DOOR_get_state_master";
    public static String Get_City_List = "XCEL_MED2DOOR_get_city_master";
    public static String Get_AddressTypes = "xcelpatconfig_get_ct_address_type";
    public static String Upload_Process_Step1 = "xcel_Med2Door_save_upload_in_cart";
    public static String Upload_Process_Step3 = "xcelrcm_save_trn_document_external";
    public static String Fetch_Panels_List_Details = "hospapp_get_panel_details";
    public static String Fetch_Invoice_List = "xcelrcm_get_trn_pending_patient_invoice_list";
    public static String Fetch_Time_Line = "xcelsch_get_trn_resource_appointment_activity";
    public static String Save_Push_Token = "sgconf_save_usr_push_notification_token";
    public static String Fetch_Health_Card_Details = "vdentconf_get_mst_usr_medical_card_details";
    public static String Update_User_profile = "vdentconf_update_mst_usr_profile_details";
    public static String Fetch_Notification = "sgnot_get_usr_notifications";
//    public static String Fetch_Notification = "vdent_get_trn_usr_notifications";
    public static String Delete_Push_Token = "sgconf_save_usr_push_notification_token_as_inactive_on_logout";
    public static String Generate_OTP = "hospapp_save_generate_otp_for_user";
//    public static String Generate_OTP = "vdent_save_generate_otp_for_user";
    public static String Verify_OTP = "sgconf_verify_otp_for_user";
    public static String Upload_Image = "speedum.libraries_main_app_upload_base64_doc";
    public static String Fetch_Privacy_Policy = "hospapp_get_terms";
    public static String Update_Phone_Verify = "vdentconf_update_mst_usr_details_phone_verfied";
//    public static String Fetch_resource_App_New = "xcelsch_get_trn_resource_appointments_for_menu";  // vDent
//    public static String Fetch_resource_App_New = "xcelsch_get_trn_resource_appointments";  // patient
    public static String Fetch_resource_App_New = "hospapp_get_patient_appointments";  // patient new
    public static String Fetch_resource_PrefTimeSlots = "xcelschconf_get_mst_resource_preferred_timeslots";
    public static String Submit_Appt_Request = "xcelsch_save_trn_resource_appointment_requests";
    public static String Confirm_Appointment = "hospapp_update_trn_appointment_status";
    public static String Cancel_Appointment = "hospapp_update_trn_appointment_status_to_cancel";
    public static String Fetch_Patient_Partner = "xcelpat_get_trn_patient_master_partner";
    public static String ClearAllNotifications = "sgnot_update_notifications_clear_all_status";
    public static String ReadAllNotifications = "sgnot_update_notifications_read_all_status";
    public static String Fetch_Password_Policy = "sgint_proc_get_app_identifier_password_policy";
    public static String Fetch_App_Upgrade = "sgint_proc_get_app_identifier_versions";

    public static String ValidateUser_For_Payment = "sgconf_get_mst_user_payment_gateway_details";
    public static String Save_Payment_Card = "sgconf_create_customer_card_square_up_db";
    public static String Delete_Payment_Card = "sgconf_delete_customer_card_square_up_db";
    public static String Get_Saved_Card = "sgconf_get_mst_user_payment_gateway_card_mapping";
    public static String Get_Disclaimer = "sgconf_get_org_disclaimer";
    public static String Make_Payment = "xcelrcm_save_payment_square_up";
    public static String GetColorConfig = "sgint_proc_get_app_identifier_attribute_mapping";
    public static String GetHomeScreenConfig = "hospapp_get_mst_menu_app";
    public static String GetDoctorSchedule = "hospapp_get_doctor_schedule";
    public static String GetSaveAppointment = "hospapp_save_patient_appointment";
    public static String GetMedication = "hospapp_get_patient_medications";
    public static String GetORG_Medication = "hospapp_get_medications";
    public static String GetORG_User_Medication = "hospapp_get_user_medications";
    public static String Get_Save_User_Medication = "hosppp_save_user_medication";
    public static String Get_Save_Patient_Medication = "hospapp_save_patient_medication";
    public static String Get_Gallery_Content = "hospapp_get_org_video_image_gallery";
    public static String Fetch_Chat_User_Details = "xcelpat_get_mst_user_profile_html_for_chat";
    public static String Fetch_Chat_User_Partners = "xcelpat_get_trn_patient_partner_list";
    public static String Fetch_Chat_Categories = "sgconf_get_mst_user_contact_group_mapping";
    public static String Search_Chat_Contacts = "sgconf_get_mst_organisation_contact_group_for_user_search";
    public static String Create_OneToOne_Dialog = "sgchat_qb_create_dialog_one_to_one";
    public static String Get_OrgDetails = "hospapp_get_organisation_details";
    public static String Get_Prescriptions = "hospapp_get_patient_prescriptions";
    public static String Get_Panel_List = "hospapp_get_panel_master";
    public static String Get_Mapped_Org = "hospapp_get_user_patient_organisation_mapping";
    public static String Get_MoodReminderList = "speedum.libraries_main_app_get_trn_patient_reminder";
    public static String Get_Mood_Breakups = "speedum.libraries_main_app_get_trn_patient_emr_mental_health_mood_checkin_activity_breakup";
    public static String Save_MoodReminder = "speedum.libraries_main_app_save_trn_patient_reminder";
    public static String Get_Reminder_Types = "speedum.libraries_main_appconf_get_ct_reminder_type";
    public static String Get_Mapped_Doctor = "hospapp_get_user_patient_doctor_mapping";
    public static String fetch_unjoined_dialogs = "sgconf_get_mst_user_contact_group_mapping_for_non_dialog_list";
    public static String create_unjoined_dialogs = "sgconf_save_mst_user_contact_group_mapping_for_non_dialog_list_dialog";
    public static String fetch_courses_list = "speedum.libraries_main_app_get_trn_patient_learning_plan_details";
    public static String fetch_lesson_list = "speedum.libraries_main_appconf_get_mst_lm_topics_for_lp_details";
    public static String fetch_courses_cat_list = "speedum.libraries_main_appconf_get_mst_lm_course_category";
    public static String fetch_Searched_Courses_list = "speedum.libraries_main_appconf_get_mst_lm_course_for_public";
    public static String submit_searched_courses = "speedum.libraries_main_app_save_trn_patient_learning_plan_submission_data";
    public static String fetch_moods_list = "speedum.libraries_main_appconf_get_mst_emr_mental_health_mood";
    public static String fetch_moods_stats = "speedum.libraries_main_app_get_trn_patient_emr_mental_health_mood_checkin_stats";
    public static String fetch_Cogs_Text_result = "generic_cogsApp_API_calling";
    public static String submit_face_detection = "generic_azur_calling";
}
