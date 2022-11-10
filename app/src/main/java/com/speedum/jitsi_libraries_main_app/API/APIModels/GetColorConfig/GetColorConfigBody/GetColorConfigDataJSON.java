
package com.speedum.jitsi_libraries_main_app.API.APIModels.GetColorConfig.GetColorConfigBody;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GetColorConfigDataJSON implements Serializable
{

    @SerializedName("p_ai_code")
    @Expose
    private String pAiCode;
    private final static long serialVersionUID = 8532886837346029682L;

    public String getPAiCode() {
        return pAiCode;
    }

    public void setPAiCode(String pAiCode) {
        this.pAiCode = pAiCode;
    }

}
