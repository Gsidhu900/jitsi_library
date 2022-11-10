
package com.speedum.jitsi_libraries_main_app.API.Comman_Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserData {

    @SerializedName("sgUserId")
    @Expose
    private String sgUserId;
    @SerializedName("sgOrgId")
    @Expose
    private String sgOrgId;
    @SerializedName("sgRoleId")
    @Expose
    private String sgRoleId;
    @SerializedName("sgMenuId")
    @Expose
    private String sgMenuId;
    @SerializedName("sgAppSession")
    @Expose
    private String sgAppSession;

    /**
     * No args constructor for use in serialization
     * 
     */
    public UserData() {
    }

    /**
     * 
     * @param sgRoleId
     * @param sgUserId
     * @param sgOrgId
     * @param sgAppSession
     * @param sgMenuId
     */
    public UserData(String sgUserId, String sgOrgId, String sgRoleId, String sgMenuId, String sgAppSession) {
        super();
        this.sgUserId = sgUserId;
        this.sgOrgId = sgOrgId;
        this.sgRoleId = sgRoleId;
        this.sgMenuId = sgMenuId;
        this.sgAppSession = sgAppSession;
    }

    public String getSgUserId() {
        return sgUserId;
    }

    public void setSgUserId(String sgUserId) {
        this.sgUserId = sgUserId;
    }

    public String getSgOrgId() {
        return sgOrgId;
    }

    public void setSgOrgId(String sgOrgId) {
        this.sgOrgId = sgOrgId;
    }

    public String getSgRoleId() {
        return sgRoleId;
    }

    public void setSgRoleId(String sgRoleId) {
        this.sgRoleId = sgRoleId;
    }

    public String getSgMenuId() {
        return sgMenuId;
    }

    public void setSgMenuId(String sgMenuId) {
        this.sgMenuId = sgMenuId;
    }

    public String getSgAppSession() {
        return sgAppSession;
    }

    public void setSgAppSession(String sgAppSession) {
        this.sgAppSession = sgAppSession;
    }

}
