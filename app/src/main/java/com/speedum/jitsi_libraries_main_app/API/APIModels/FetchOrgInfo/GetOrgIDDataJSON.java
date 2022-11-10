package com.speedum.jitsi_libraries_main_app.API.APIModels.FetchOrgInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetOrgIDDataJSON {
    @SerializedName("p_org_ai_code")
    @Expose
    private String pOrgAiCode;
    private final static long serialVersionUID = 6479901903665544449L;

    public String getPOrgAiCode() {
        return pOrgAiCode;
    }

    public void setPOrgAiCode(String pOrgAiCode) {
        this.pOrgAiCode = pOrgAiCode;
    }
}
