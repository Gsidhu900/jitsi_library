package com.speedum.jitsi_libraries_main_app.API.Comman_Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CommonBody <T> implements Serializable {

    @SerializedName("dataJSON")
    @Expose
    private T dataJSON;
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
    private final static long serialVersionUID = -8388407591112579885L;

    /**
     * No args constructor for use in serialization
     *
     */
    public CommonBody() {
    }


    public T getDataJSON() {
        return dataJSON;
    }

    public void setDataJSON(T dataJSON) {
        this.dataJSON =  dataJSON;
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
