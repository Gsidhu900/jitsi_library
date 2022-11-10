
package com.speedum.jitsi_libraries_main_app.API.APIModels.GetColorConfig.GetColorConfigResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GetColorConfigReturnDatum implements Serializable
{

    @SerializedName("attributes")
    @Expose
    private String attributes;
    private final static long serialVersionUID = 6887741033351280341L;

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

}
