
package com.speedum.jitsi_libraries_main_app.API.APIModels.GetColorConfig.GetColorConfigBody;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.speedum.jitsi_libraries_main_app.API.Comman_Data.MetaData;
import com.speedum.jitsi_libraries_main_app.API.Comman_Data.OtherData;
import com.speedum.jitsi_libraries_main_app.API.Comman_Data.UserData;

import java.io.Serializable;

public class GetColorConfigBody implements Serializable
{

    @SerializedName("dataJSON")
    @Expose
    private GetColorConfigDataJSON dataJSON;
    @SerializedName("environment")
    @Expose
    private String environment;
    @SerializedName("meta_data")
    @Expose
    private MetaData metaData;
    @SerializedName("other_data")
    @Expose
    private OtherData otherData;
    @SerializedName("process_id")
    @Expose
    private String processId;
    @SerializedName("user_data")
    @Expose
    private UserData userData;
    private final static long serialVersionUID = 747348631495514259L;

    public GetColorConfigDataJSON getDataJSON() {
        return dataJSON;
    }

    public void setDataJSON(GetColorConfigDataJSON dataJSON) {
        this.dataJSON = dataJSON;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
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

}
