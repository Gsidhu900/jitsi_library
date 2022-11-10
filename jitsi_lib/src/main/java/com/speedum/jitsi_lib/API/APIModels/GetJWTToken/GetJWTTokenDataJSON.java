package com.speedum.jitsi_lib.API.APIModels.GetJWTToken;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetJWTTokenDataJSON {
    @SerializedName("meet_unique_code")
    @Expose
    private String meetUniqueCode;
    @SerializedName("p_user_roomName")
    @Expose
    private String pUserRoomName;
    @SerializedName("p_patient_id")
    @Expose
    private String pPatientId;
    @SerializedName("p_visit_id")
    @Expose
    private String pVisitId;

    public String getMeetUniqueCode() {
        return meetUniqueCode;
    }

    public void setMeetUniqueCode(String meetUniqueCode) {
        this.meetUniqueCode = meetUniqueCode;
    }

    public String getpUserRoomName() {
        return pUserRoomName;
    }

    public void setpUserRoomName(String pUserRoomName) {
        this.pUserRoomName = pUserRoomName;
    }

    public String getpPatientId() {
        return pPatientId;
    }

    public void setpPatientId(String pPatientId) {
        this.pPatientId = pPatientId;
    }

    public String getpVisitId() {
        return pVisitId;
    }

    public void setpVisitId(String pVisitId) {
        this.pVisitId = pVisitId;
    }
}
