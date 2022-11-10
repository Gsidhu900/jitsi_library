
package com.speedum.jitsi_libraries_main_app.API.APIModels.Save_Push_Token;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SavePushDataJSON implements Serializable
{

    @SerializedName("p_usr_device_token")
    @Expose
    private String pUsrDeviceToken;
    @SerializedName("p_app_code")
    @Expose
    private String pAppCode;
    @SerializedName("p_usr_app_version")
    @Expose
    private String pUsrAppVersion;
    @SerializedName("p_usr_device_type")
    @Expose
    private String pUsrDeviceType;
    @SerializedName("p_usr_device_model")
    @Expose
    private String pUsrDeviceModel;
    @SerializedName("p_usr_device_make")
    @Expose
    private String pUsrDeviceMake;
    @SerializedName("p_usr_device_identifier")
    @Expose
    private String pUsrDeviceIdentifier;
    private final static long serialVersionUID = -7176135391114891597L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SavePushDataJSON() {
    }

    /**
     * 
     * @param pUsrDeviceToken
     * @param pUsrDeviceModel
     * @param pUsrDeviceType
     * @param pUsrDeviceMake
     * @param pUsrDeviceIdentifier
     * @param pUsrAppVersion
     * @param pAppCode
     */
    public SavePushDataJSON(String pUsrDeviceToken, String pAppCode, String pUsrAppVersion, String pUsrDeviceType, String pUsrDeviceModel, String pUsrDeviceMake, String pUsrDeviceIdentifier) {
        super();
        this.pUsrDeviceToken = pUsrDeviceToken;
        this.pAppCode = pAppCode;
        this.pUsrAppVersion = pUsrAppVersion;
        this.pUsrDeviceType = pUsrDeviceType;
        this.pUsrDeviceModel = pUsrDeviceModel;
        this.pUsrDeviceMake = pUsrDeviceMake;
        this.pUsrDeviceIdentifier = pUsrDeviceIdentifier;
    }

    public String getPUsrDeviceToken() {
        return pUsrDeviceToken;
    }

    public void setPUsrDeviceToken(String pUsrDeviceToken) {
        this.pUsrDeviceToken = pUsrDeviceToken;
    }

    public String getPAppCode() {
        return pAppCode;
    }

    public void setPAppCode(String pAppCode) {
        this.pAppCode = pAppCode;
    }

    public String getPUsrAppVersion() {
        return pUsrAppVersion;
    }

    public void setPUsrAppVersion(String pUsrAppVersion) {
        this.pUsrAppVersion = pUsrAppVersion;
    }

    public String getPUsrDeviceType() {
        return pUsrDeviceType;
    }

    public void setPUsrDeviceType(String pUsrDeviceType) {
        this.pUsrDeviceType = pUsrDeviceType;
    }

    public String getPUsrDeviceModel() {
        return pUsrDeviceModel;
    }

    public void setPUsrDeviceModel(String pUsrDeviceModel) {
        this.pUsrDeviceModel = pUsrDeviceModel;
    }

    public String getPUsrDeviceMake() {
        return pUsrDeviceMake;
    }

    public void setPUsrDeviceMake(String pUsrDeviceMake) {
        this.pUsrDeviceMake = pUsrDeviceMake;
    }

    public String getPUsrDeviceIdentifier() {
        return pUsrDeviceIdentifier;
    }

    public void setPUsrDeviceIdentifier(String pUsrDeviceIdentifier) {
        this.pUsrDeviceIdentifier = pUsrDeviceIdentifier;
    }

}
