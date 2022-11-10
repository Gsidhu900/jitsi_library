
package com.speedum.jitsi_lib.API.APIModels.Session_Token;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SessionTokenBody {

    @SerializedName("ai_code")
    @Expose
    private String aiCode;
    @SerializedName("device_type")
    @Expose
    private String deviceType;
    @SerializedName("device_unique_id")
    @Expose
    private String deviceUniqueId;
    @SerializedName("device_os")
    @Expose
    private String deviceOs;
    @SerializedName("device_os_version")
    @Expose
    private String deviceOsVersion;
    @SerializedName("device_ip")
    @Expose
    private String deviceIp;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SessionTokenBody() {
    }

    /**
     * 
     * @param deviceIp
     * @param deviceOsVersion
     * @param deviceUniqueId
     * @param deviceType
     * @param aiCode
     * @param deviceOs
     */
    public SessionTokenBody(String aiCode, String deviceType, String deviceUniqueId, String deviceOs, String deviceOsVersion, String deviceIp) {
        super();
        this.aiCode = aiCode;
        this.deviceType = deviceType;
        this.deviceUniqueId = deviceUniqueId;
        this.deviceOs = deviceOs;
        this.deviceOsVersion = deviceOsVersion;
        this.deviceIp = deviceIp;
    }

    public String getAiCode() {
        return aiCode;
    }

    public void setAiCode(String aiCode) {
        this.aiCode = aiCode;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceUniqueId() {
        return deviceUniqueId;
    }

    public void setDeviceUniqueId(String deviceUniqueId) {
        this.deviceUniqueId = deviceUniqueId;
    }

    public String getDeviceOs() {
        return deviceOs;
    }

    public void setDeviceOs(String deviceOs) {
        this.deviceOs = deviceOs;
    }

    public String getDeviceOsVersion() {
        return deviceOsVersion;
    }

    public void setDeviceOsVersion(String deviceOsVersion) {
        this.deviceOsVersion = deviceOsVersion;
    }

    public String getDeviceIp() {
        return deviceIp;
    }

    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp;
    }

}
