
package com.speedum.jitsi_libraries_main_app.API.APIModels.Login_User;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoginReturnData implements Serializable {

    @SerializedName("curreny_sign")
    @Expose
    private String curreny_sign;
    @SerializedName("visit_id")
    @Expose
    private String visit_id;
    @SerializedName("usr_email")
    @Expose
    private String usrEmail;
    @SerializedName("usr_phone")
    @Expose
    private String usrPhone;
    @SerializedName("usr_id")
    @Expose
    private String usrId;
    @SerializedName("usr_name")
    @Expose
    private String usrName;
    @SerializedName("usr_loginid")
    @Expose
    private String usrLoginid;
    @SerializedName("rol_id")
    @Expose
    private String rolId;
    @SerializedName("rol_name")
    @Expose
    private String rolName;
    @SerializedName("usr_org_selection_popup_flag")
    @Expose
    private String usrOrgSelectionPopupFlag;
    @SerializedName("usr_role_selection_popup_flag")
    @Expose
    private String usrRoleSelectionPopupFlag;
    @SerializedName("usr_role")
    @Expose
    private String usrRole;
    @SerializedName("usr_onboarding_status")
    @Expose
    private String usrOnboardingStatus;
    @SerializedName("org_id")
    @Expose
    private String orgId;
    @SerializedName("resource_id")
    @Expose
    private String resourceId;
    @SerializedName("doctor_id")
    @Expose
    private String doctorId;
    @SerializedName("patient_id")
    @Expose
    private String patientId;
    @SerializedName("usr_quickblox_login_id")
    @Expose
    private String usrQuickbloxLoginId;
    @SerializedName("usr_quickblox_id")
    @Expose
    private String usrQuickbloxId;
    @SerializedName("org_name")
    @Expose
    private String orgName;
    @SerializedName("org_latitude")
    @Expose
    private String orgLatitude;
    @SerializedName("org_longitude")
    @Expose
    private String orgLongitude;
    @SerializedName("org_profile_image")
    @Expose
    private String orgProfileImage;
    @SerializedName("usr_city_id")
    @Expose
    private String usrCityId;
    @SerializedName("usr_gender_code")
    @Expose
    private String usrGenderCode;
    @SerializedName("usr_healthcard_number_verified_flag")
    @Expose
    private String usrHealthcardNumberVerifiedFlag;
    @SerializedName("usr_phone_number_verified_flag")
    @Expose
    private String usrPhoneNumberVerifiedFlag;
    @SerializedName("usr_address")
    @Expose
    private String usrAddress;
    @SerializedName("usr_postal_code")
    @Expose
    private String usrPostalCode;
    @SerializedName("usr_dob")
    @Expose
    private String usrDob;
    @SerializedName("usr_quickblox_name")
    @Expose
    private String usr_quickblox_name;
    @SerializedName("patient_photo")
    @Expose
    private String patient_photo;

    private final static long serialVersionUID = -5646672758532662754L;

    /**
     * No args constructor for use in serialization
     */
    public LoginReturnData() {
    }

    /**
     * @param resourceId
     * @param patientId
     * @param usrRole
     * @param usrPhone
     * @param orgId
     * @param usrRoleSelectionPopupFlag
     * @param doctorId
     * @param orgProfileImage
     * @param usrGenderCode
     * @param orgLatitude
     * @param usrCityId
     * @param usrName
     * @param orgName
     * @param usrLoginid
     * @param usrQuickbloxId
     * @param usrAddress
     * @param usrQuickbloxLoginId
     * @param orgLongitude
     * @param usrId
     * @param usrOnboardingStatus
     * @param usrPhoneNumberVerifiedFlag
     * @param usrOrgSelectionPopupFlag
     * @param rolId
     * @param usrDob
     * @param usrPostalCode
     * @param usrEmail
     * @param usrHealthcardNumberVerifiedFlag
     * @param rolName
     */
    public LoginReturnData(String usrEmail, String usrPhone, String usrId, String usrName, String usrLoginid
            , String rolId, String rolName, String usrOrgSelectionPopupFlag, String usrRoleSelectionPopupFlag
            , String usrRole, String usrOnboardingStatus, String orgId, String resourceId, String doctorId
            , String patientId, String usrQuickbloxLoginId, String usrQuickbloxId, String orgName, String orgLatitude
            , String orgLongitude, String orgProfileImage, String usrCityId, String usrGenderCode, String usrHealthcardNumberVerifiedFlag
            , String usrPhoneNumberVerifiedFlag, String usrAddress, String usrPostalCode, String usrDob
            , String usr_quickblox_name, String patient_photo, String currency_sign, String visit_id) {
        super();
        this.usrEmail = usrEmail;
        this.usrPhone = usrPhone;
        this.usrId = usrId;
        this.usrName = usrName;
        this.usrLoginid = usrLoginid;
        this.rolId = rolId;
        this.rolName = rolName;
        this.usrOrgSelectionPopupFlag = usrOrgSelectionPopupFlag;
        this.usrRoleSelectionPopupFlag = usrRoleSelectionPopupFlag;
        this.usrRole = usrRole;
        this.usrOnboardingStatus = usrOnboardingStatus;
        this.orgId = orgId;
        this.resourceId = resourceId;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.usrQuickbloxLoginId = usrQuickbloxLoginId;
        this.usrQuickbloxId = usrQuickbloxId;
        this.orgName = orgName;
        this.orgLatitude = orgLatitude;
        this.orgLongitude = orgLongitude;
        this.orgProfileImage = orgProfileImage;
        this.usrCityId = usrCityId;
        this.usrGenderCode = usrGenderCode;
        this.usrHealthcardNumberVerifiedFlag = usrHealthcardNumberVerifiedFlag;
        this.usrPhoneNumberVerifiedFlag = usrPhoneNumberVerifiedFlag;
        this.usrAddress = usrAddress;
        this.usrPostalCode = usrPostalCode;
        this.usrDob = usrDob;
        this.usr_quickblox_name = usr_quickblox_name;
        this.patient_photo = patient_photo;
        this.curreny_sign = currency_sign;
        this.visit_id = visit_id;
    }

    public String getUsr_quickblox_name() {
        return usr_quickblox_name;
    }

    public void setUsr_quickblox_name(String usr_quickblox_name) {
        this.usr_quickblox_name = usr_quickblox_name;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    public String getUsrPhone() {
        return usrPhone;
    }

    public void setUsrPhone(String usrPhone) {
        this.usrPhone = usrPhone;
    }

    public String getUsrId() {
        return usrId;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getUsrLoginid() {
        return usrLoginid;
    }

    public void setUsrLoginid(String usrLoginid) {
        this.usrLoginid = usrLoginid;
    }

    public String getRolId() {
        return rolId;
    }

    public void setRolId(String rolId) {
        this.rolId = rolId;
    }

    public String getRolName() {
        return rolName;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
    }

    public String getUsrOrgSelectionPopupFlag() {
        return usrOrgSelectionPopupFlag;
    }

    public void setUsrOrgSelectionPopupFlag(String usrOrgSelectionPopupFlag) {
        this.usrOrgSelectionPopupFlag = usrOrgSelectionPopupFlag;
    }

    public String getUsrRoleSelectionPopupFlag() {
        return usrRoleSelectionPopupFlag;
    }

    public void setUsrRoleSelectionPopupFlag(String usrRoleSelectionPopupFlag) {
        this.usrRoleSelectionPopupFlag = usrRoleSelectionPopupFlag;
    }

    public String getUsrRole() {
        return usrRole;
    }

    public void setUsrRole(String usrRole) {
        this.usrRole = usrRole;
    }

    public String getUsrOnboardingStatus() {
        return usrOnboardingStatus;
    }

    public void setUsrOnboardingStatus(String usrOnboardingStatus) {
        this.usrOnboardingStatus = usrOnboardingStatus;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getUsrQuickbloxLoginId() {
        return usrQuickbloxLoginId;
    }

    public void setUsrQuickbloxLoginId(String usrQuickbloxLoginId) {
        this.usrQuickbloxLoginId = usrQuickbloxLoginId;
    }

    public String getUsrQuickbloxId() {
        return usrQuickbloxId;
    }

    public void setUsrQuickbloxId(String usrQuickbloxId) {
        this.usrQuickbloxId = usrQuickbloxId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgLatitude() {
        return orgLatitude;
    }

    public void setOrgLatitude(String orgLatitude) {
        this.orgLatitude = orgLatitude;
    }

    public String getOrgLongitude() {
        return orgLongitude;
    }

    public void setOrgLongitude(String orgLongitude) {
        this.orgLongitude = orgLongitude;
    }

    public String getOrgProfileImage() {
        return orgProfileImage;
    }

    public void setOrgProfileImage(String orgProfileImage) {
        this.orgProfileImage = orgProfileImage;
    }

    public String getUsrCityId() {
        return usrCityId;
    }

    public void setUsrCityId(String usrCityId) {
        this.usrCityId = usrCityId;
    }

    public String getUsrGenderCode() {
        return usrGenderCode;
    }

    public void setUsrGenderCode(String usrGenderCode) {
        this.usrGenderCode = usrGenderCode;
    }

    public String getUsrHealthcardNumberVerifiedFlag() {
        return usrHealthcardNumberVerifiedFlag;
    }

    public void setUsrHealthcardNumberVerifiedFlag(String usrHealthcardNumberVerifiedFlag) {
        this.usrHealthcardNumberVerifiedFlag = usrHealthcardNumberVerifiedFlag;
    }

    public String getUsrPhoneNumberVerifiedFlag() {
        return usrPhoneNumberVerifiedFlag;
    }

    public void setUsrPhoneNumberVerifiedFlag(String usrPhoneNumberVerifiedFlag) {
        this.usrPhoneNumberVerifiedFlag = usrPhoneNumberVerifiedFlag;
    }

    public String getUsrAddress() {
        return usrAddress;
    }

    public void setUsrAddress(String usrAddress) {
        this.usrAddress = usrAddress;
    }

    public String getUsrPostalCode() {
        return usrPostalCode;
    }

    public void setUsrPostalCode(String usrPostalCode) {
        this.usrPostalCode = usrPostalCode;
    }

    public String getUsrDob() {
        return usrDob;
    }

    public String getCurreny_sign() {
        return curreny_sign;
    }

    public void setCurreny_sign(String curreny_sign) {
        this.curreny_sign = curreny_sign;
    }

    public void setUsrDob(String usrDob) {
        this.usrDob = usrDob;
    }

    public String getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(String visit_id) {
        this.visit_id = visit_id;
    }

    public String getPatient_photo() {
        return patient_photo;
    }

    public void setPatient_photo(String patient_photo) {
        this.patient_photo = patient_photo;
    }
}