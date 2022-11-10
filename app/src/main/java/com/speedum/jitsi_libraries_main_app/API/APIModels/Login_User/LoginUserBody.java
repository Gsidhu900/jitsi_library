
package com.speedum.jitsi_libraries_main_app.API.APIModels.Login_User;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.speedum.jitsi_libraries_main_app.API.Comman_Data.MetaData;
import com.speedum.jitsi_libraries_main_app.API.Comman_Data.OtherData;
import com.speedum.jitsi_libraries_main_app.API.Comman_Data.UserData;

public class LoginUserBody {

    @SerializedName("dataJSON")
    @Expose
    private LoginDataJSON dataJSON;
    @SerializedName("environment")
    @Expose
    private String environment;
    @SerializedName("process_id")
    @Expose
    private String processId;
    @SerializedName("user_data")
    @Expose
    private UserData userData;
    @SerializedName("meta_data")
    @Expose
    private MetaData metaData;
    @SerializedName("other_data")
    @Expose
    private OtherData otherData;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LoginUserBody() {
    }

    /**
     * 
     * @param metaData
     * @param environment
     * @param userData
     * @param processId
     * @param otherData
     * @param loginDataJSON
     */
    public LoginUserBody(LoginDataJSON loginDataJSON, String environment, String processId, UserData userData, MetaData metaData, OtherData otherData) {
        super();
        this.dataJSON = loginDataJSON;
        this.environment = environment;
        this.processId = processId;
        this.userData = userData;
        this.metaData = metaData;
        this.otherData = otherData;
    }

    public LoginDataJSON getDataJSON() {
        return dataJSON;
    }

    public void setDataJSON(LoginDataJSON loginDataJSON) {
        this.dataJSON = loginDataJSON;
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
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public OtherData getOtherData() {
        return otherData;
    }

    public void setOtherData(OtherData otherData) {
        this.otherData = otherData;
    }

}
