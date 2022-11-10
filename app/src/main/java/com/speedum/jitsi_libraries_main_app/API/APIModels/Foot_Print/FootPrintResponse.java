
package com.speedum.jitsi_libraries_main_app.API.APIModels.Foot_Print;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FootPrintResponse {

    @SerializedName("return_AppIdentifier")
    @Expose
    private String returnAppIdentifier;
    @SerializedName("return_LicenseIdentifier")
    @Expose
    private String returnLicenseIdentifier;
    @SerializedName("return_LicenseExpiry")
    @Expose
    private String returnLicenseExpiry;
    @SerializedName("return_Error")
    @Expose
    private String returnError;
    @SerializedName("return_SessionToken")
    @Expose
    private String returnSessionToken;
    @SerializedName("return_SessionExpiry")
    @Expose
    private String returnSessionExpiry;

    /**
     * No args constructor for use in serialization
     * 
     */
    public FootPrintResponse() {
    }

    /**
     * 
     * @param returnAppIdentifier
     * @param returnSessionToken
     * @param returnSessionExpiry
     * @param returnError
     * @param returnLicenseExpiry
     * @param returnLicenseIdentifier
     */
    public FootPrintResponse(String returnAppIdentifier, String returnLicenseIdentifier, String returnLicenseExpiry, String returnError, String returnSessionToken, String returnSessionExpiry) {
        super();
        this.returnAppIdentifier = returnAppIdentifier;
        this.returnLicenseIdentifier = returnLicenseIdentifier;
        this.returnLicenseExpiry = returnLicenseExpiry;
        this.returnError = returnError;
        this.returnSessionToken = returnSessionToken;
        this.returnSessionExpiry = returnSessionExpiry;
    }

    public String getReturnAppIdentifier() {
        return returnAppIdentifier;
    }

    public void setReturnAppIdentifier(String returnAppIdentifier) {
        this.returnAppIdentifier = returnAppIdentifier;
    }

    public String getReturnLicenseIdentifier() {
        return returnLicenseIdentifier;
    }

    public void setReturnLicenseIdentifier(String returnLicenseIdentifier) {
        this.returnLicenseIdentifier = returnLicenseIdentifier;
    }

    public String getReturnLicenseExpiry() {
        return returnLicenseExpiry;
    }

    public void setReturnLicenseExpiry(String returnLicenseExpiry) {
        this.returnLicenseExpiry = returnLicenseExpiry;
    }

    public String getReturnError() {
        return returnError;
    }

    public void setReturnError(String returnError) {
        this.returnError = returnError;
    }

    public String getReturnSessionToken() {
        return returnSessionToken;
    }

    public void setReturnSessionToken(String returnSessionToken) {
        this.returnSessionToken = returnSessionToken;
    }

    public String getReturnSessionExpiry() {
        return returnSessionExpiry;
    }

    public void setReturnSessionExpiry(String returnSessionExpiry) {
        this.returnSessionExpiry = returnSessionExpiry;
    }

}
