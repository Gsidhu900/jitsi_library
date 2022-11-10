
package com.speedum.jitsi_libraries_main_app.API.APIModels.Login_User;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginUserResponse {

    @SerializedName("returnCode")
    @Expose
    private String returnCode;
    @SerializedName("returnData")
    @Expose
        private List<LoginReturnData> returnData = null;
    @SerializedName("gridConfig")
    @Expose
    private List<Object> gridConfig = null;
    @SerializedName("gridLayoutData")
    @Expose
    private List<Object> gridLayoutData = null;
    @SerializedName("gridActionLayoutData")
    @Expose
    private List<Object> gridActionLayoutData = null;
    @SerializedName("failureMessage")
    @Expose
    private String failureMessage;
    @SerializedName("failureMessageIsCode")
    @Expose
    private String failureMessageIsCode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("messageIsCode")
    @Expose
    private String messageIsCode;
    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("inputProcessId")
    @Expose
    private String inputProcessId;
    @SerializedName("return_AppIdentifier")
    @Expose
    private String returnAppIdentifier;
    @SerializedName("return_LicenseIdentifier")
    @Expose
    private String returnLicenseIdentifier;
    @SerializedName("return_SessionIdentifier")
    @Expose
    private String returnSessionIdentifier;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LoginUserResponse() {
    }

    /**
     * 
     * @param returnAppIdentifier
     * @param messageIsCode
     * @param returnLicenseIdentifier
     * @param message
     * @param error
     * @param returnSessionIdentifier
     * @param gridActionLayoutData
     * @param returnCode
     * @param failureMessageIsCode
     * @param gridLayoutData
     * @param returnData
     * @param inputProcessId
     * @param gridConfig
     * @param failureMessage
     */
    public LoginUserResponse(String returnCode, List<LoginReturnData> returnData, List<Object> gridConfig, List<Object> gridLayoutData, List<Object> gridActionLayoutData, String failureMessage, String failureMessageIsCode, String message, String messageIsCode, String error, String inputProcessId, String returnAppIdentifier, String returnLicenseIdentifier, String returnSessionIdentifier) {
        super();
        this.returnCode = returnCode;
        this.returnData = returnData;
        this.gridConfig = gridConfig;
        this.gridLayoutData = gridLayoutData;
        this.gridActionLayoutData = gridActionLayoutData;
        this.failureMessage = failureMessage;
        this.failureMessageIsCode = failureMessageIsCode;
        this.message = message;
        this.messageIsCode = messageIsCode;
        this.error = error;
        this.inputProcessId = inputProcessId;
        this.returnAppIdentifier = returnAppIdentifier;
        this.returnLicenseIdentifier = returnLicenseIdentifier;
        this.returnSessionIdentifier = returnSessionIdentifier;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public List<LoginReturnData> getReturnData() {
        return returnData;
    }

    public void setReturnData(List<LoginReturnData> returnData) {
        this.returnData = returnData;
    }

    public List<Object> getGridConfig() {
        return gridConfig;
    }

    public void setGridConfig(List<Object> gridConfig) {
        this.gridConfig = gridConfig;
    }

    public List<Object> getGridLayoutData() {
        return gridLayoutData;
    }

    public void setGridLayoutData(List<Object> gridLayoutData) {
        this.gridLayoutData = gridLayoutData;
    }

    public List<Object> getGridActionLayoutData() {
        return gridActionLayoutData;
    }

    public void setGridActionLayoutData(List<Object> gridActionLayoutData) {
        this.gridActionLayoutData = gridActionLayoutData;
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }

    public String getFailureMessageIsCode() {
        return failureMessageIsCode;
    }

    public void setFailureMessageIsCode(String failureMessageIsCode) {
        this.failureMessageIsCode = failureMessageIsCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageIsCode() {
        return messageIsCode;
    }

    public void setMessageIsCode(String messageIsCode) {
        this.messageIsCode = messageIsCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getInputProcessId() {
        return inputProcessId;
    }

    public void setInputProcessId(String inputProcessId) {
        this.inputProcessId = inputProcessId;
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

    public String getReturnSessionIdentifier() {
        return returnSessionIdentifier;
    }

    public void setReturnSessionIdentifier(String returnSessionIdentifier) {
        this.returnSessionIdentifier = returnSessionIdentifier;
    }

}
