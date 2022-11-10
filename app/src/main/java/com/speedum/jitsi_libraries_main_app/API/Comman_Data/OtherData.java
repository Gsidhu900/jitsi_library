
package com.speedum.jitsi_libraries_main_app.API.Comman_Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OtherData {

    @SerializedName("remoteAddr")
    @Expose
    private String remoteAddr;

    @SerializedName("sgAppPlatform")
    @Expose
    private String sgAppPlatform;

    @SerializedName("sgAppVersion")
    @Expose
    private String sgAppVersion;

    /**
     * No args constructor for use in serialization
     * 
     */
    public OtherData() {
    }

    /**
     * 
     * @param remoteAddr
     */
    public OtherData(String remoteAddr,String sgAppPlatform,String sgAppVersion) {
        super();
        this.remoteAddr = remoteAddr;
        this.sgAppPlatform = sgAppPlatform;
        this.sgAppVersion = sgAppVersion;
    }

    public String getSgAppVersion() {
        return sgAppVersion;
    }

    public void setSgAppVersion(String sgAppVersion) {
        this.sgAppVersion = sgAppVersion;
    }

    public String getSgAppPlatform() {
        return sgAppPlatform;
    }

    public void setSgAppPlatform(String sgAppPlatform) {
        this.sgAppPlatform = sgAppPlatform;
    }

    public String getRemoteAddr() {
        return remoteAddr;
    }

    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }

}
