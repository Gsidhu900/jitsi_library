
package com.speedum.jitsi_libraries_main_app.API.APIModels.Save_Push_Token;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.speedum.jitsi_libraries_main_app.API.Comman_Data.MetaData;
import com.speedum.jitsi_libraries_main_app.API.Comman_Data.OtherData;
import com.speedum.jitsi_libraries_main_app.API.Comman_Data.UserData;

import java.io.Serializable;

public class SavePushTokenBody implements Serializable
{

    @SerializedName("dataJSON")
    @Expose
    private SavePushDataJSON dataJSON;
    @SerializedName("environment")
    @Expose
    private String environment;
    @SerializedName("process_id")
    @Expose
    private String processId;
    @SerializedName("user_data")
    @Expose
    private UserData QBUserData;
    @SerializedName("meta_data")
    @Expose
    private MetaData QBMetaData;
    @SerializedName("other_data")
    @Expose
    private OtherData QBOtherData;
    private final static long serialVersionUID = 8405407423021371638L;

    /**
     * No args constructor for use in serialization
     *
     */
    public SavePushTokenBody() {
    }

    /**
     *
     * @param QBMetaData
     * @param environment
     * @param QBUserData
     * @param processId
     * @param QBOtherData
     * @param savePushDataJSON
     */
    public SavePushTokenBody(SavePushDataJSON savePushDataJSON, String environment, String processId, UserData QBUserData, MetaData QBMetaData, OtherData QBOtherData) {
        super();
        this.dataJSON = savePushDataJSON;
        this.environment = environment;
        this.processId = processId;
        this.QBUserData = QBUserData;
        this.QBMetaData = QBMetaData;
        this.QBOtherData = QBOtherData;
    }

    public SavePushDataJSON getDataJSON() {
        return dataJSON;
    }

    public void setDataJSON(SavePushDataJSON savePushDataJSON) {
        this.dataJSON = savePushDataJSON;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public UserData getUserData() {
        return QBUserData;
    }

    public void setUserData(UserData QBUserData) {
        this.QBUserData = QBUserData;
    }

    public MetaData getMetaData() {
        return QBMetaData;
    }

    public void setMetaData(MetaData QBMetaData) {
        this.QBMetaData = QBMetaData;
    }

    public OtherData getOtherData() {
        return QBOtherData;
    }

    public void setOtherData(OtherData QBOtherData) {
        this.QBOtherData = QBOtherData;
    }

}
