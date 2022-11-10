
package com.speedum.jitsi_libraries_main_app.API.APIModels.HomeScreenConfig.HomeScreenConfigBody;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class HomeScreenConfigDataJSON implements Serializable
{

    @SerializedName("p_ai_code")
    @Expose
    private String pAiCode;
    @SerializedName("sgOrgId")
    @Expose
    private String sgOrgId;
    private final static long serialVersionUID = 4577156889686038277L;

    public String getPAiCode() {
        return pAiCode;
    }

    public void setPAiCode(String pAiCode) {
        this.pAiCode = pAiCode;
    }

    public String getSgOrgId() {
        return sgOrgId;
    }

    public void setSgOrgId(String sgOrgId) {
        this.sgOrgId = sgOrgId;
    }

}
