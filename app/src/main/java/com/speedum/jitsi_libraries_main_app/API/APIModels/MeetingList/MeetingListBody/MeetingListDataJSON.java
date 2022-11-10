
package com.speedum.jitsi_libraries_main_app.API.APIModels.MeetingList.MeetingListBody;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MeetingListDataJSON implements Serializable
{

    @SerializedName("sgOrgId")
    @Expose
    private String sgOrgId;
    @SerializedName("sgUserId")
    @Expose
    private String sgUserId;
    @SerializedName("sgRoleId")
    @Expose
    private String sgRoleId;
    @SerializedName("p_date_from")
    @Expose
    private String pDateFrom;
    private final static long serialVersionUID = 1360280062322080471L;

    public String getSgOrgId() {
        return sgOrgId;
    }

    public void setSgOrgId(String sgOrgId) {
        this.sgOrgId = sgOrgId;
    }

    public String getSgUserId() {
        return sgUserId;
    }

    public void setSgUserId(String sgUserId) {
        this.sgUserId = sgUserId;
    }

    public String getSgRoleId() {
        return sgRoleId;
    }

    public void setSgRoleId(String sgRoleId) {
        this.sgRoleId = sgRoleId;
    }

    public String getPDateFrom() {
        return pDateFrom;
    }

    public void setPDateFrom(String pDateFrom) {
        this.pDateFrom = pDateFrom;
    }

}
