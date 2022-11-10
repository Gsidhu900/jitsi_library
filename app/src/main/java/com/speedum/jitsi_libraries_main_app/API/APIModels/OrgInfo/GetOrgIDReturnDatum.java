
package com.speedum.jitsi_libraries_main_app.API.APIModels.OrgInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GetOrgIDReturnDatum implements Serializable
{
    @SerializedName("org_id")
    @Expose
    private String orgId;
    @SerializedName("org_code")
    @Expose
    private String orgCode;
    @SerializedName("org_name")
    @Expose
    private String orgName;
    @SerializedName("org_currency")
    @Expose
    private String org_currency;
    private final static long serialVersionUID = 4505643835794218071L;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrg_currency() {
        return org_currency;
    }

    public void setOrg_currency(String org_currency) {
        this.org_currency = org_currency;
    }
}
