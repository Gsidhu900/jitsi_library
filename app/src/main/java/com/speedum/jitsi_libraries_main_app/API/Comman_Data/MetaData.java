
package com.speedum.jitsi_libraries_main_app.API.Comman_Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MetaData {

    @SerializedName("sgPatientId")
    @Expose
    private String sgPatientId;
    @SerializedName("sgVisitId")
    @Expose
    private String sgVisitId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MetaData() {
    }

    /**
     * 
     * @param sgVisitId
     * @param sgPatientId
     */
    public MetaData(String sgPatientId, String sgVisitId) {
        super();
        this.sgPatientId = sgPatientId;
        this.sgVisitId = sgVisitId;
    }

    public String getSgPatientId() {
        return sgPatientId;
    }

    public void setSgPatientId(String sgPatientId) {
        this.sgPatientId = sgPatientId;
    }

    public String getSgVisitId() {
        return sgVisitId;
    }

    public void setSgVisitId(String sgVisitId) {
        this.sgVisitId = sgVisitId;
    }

}
