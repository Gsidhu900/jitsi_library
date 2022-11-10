
package com.speedum.jitsi_libraries_main_app.API.APIModels.MeetingList.MeetingListResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MeetingListResponse implements Serializable
{

    @SerializedName("returnCode")
    @Expose
    private String returnCode;
    @SerializedName("returnData")
    @Expose
    private List<MeetingListReturnDatum> returnData = null;
    @SerializedName("gridConfig")
    @Expose
    private List<GridConfig> gridConfig = null;
    @SerializedName("gridLayoutData")
    @Expose
    private List<GridLayoutDatum> gridLayoutData = null;
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
    @SerializedName("transactionType")
    @Expose
    private String transactionType;
    @SerializedName("transactionKey")
    @Expose
    private String transactionKey;
    @SerializedName("return_AppIdentifier")
    @Expose
    private String returnAppIdentifier;
    @SerializedName("return_LicenseIdentifier")
    @Expose
    private String returnLicenseIdentifier;
    @SerializedName("return_SessionIdentifier")
    @Expose
    private String returnSessionIdentifier;
    private final static long serialVersionUID = -1777930334258467967L;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public List<MeetingListReturnDatum> getReturnData() {
        return returnData;
    }

    public void setReturnData(List<MeetingListReturnDatum> returnData) {
        this.returnData = returnData;
    }

    public List<GridConfig> getGridConfig() {
        return gridConfig;
    }

    public void setGridConfig(List<GridConfig> gridConfig) {
        this.gridConfig = gridConfig;
    }

    public List<GridLayoutDatum> getGridLayoutData() {
        return gridLayoutData;
    }

    public void setGridLayoutData(List<GridLayoutDatum> gridLayoutData) {
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

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionKey() {
        return transactionKey;
    }

    public void setTransactionKey(String transactionKey) {
        this.transactionKey = transactionKey;
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
