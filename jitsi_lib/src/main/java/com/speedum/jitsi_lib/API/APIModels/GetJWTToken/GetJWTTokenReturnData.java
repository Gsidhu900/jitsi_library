package com.speedum.jitsi_lib.API.APIModels.GetJWTToken;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetJWTTokenReturnData {
    @SerializedName("p_user_roomName")
    @Expose
    private String pUserRoomName;
    @SerializedName("p_meet_domain")
    @Expose
    private String pMeetDomain;
    @SerializedName("p_user_displayName")
    @Expose
    private String pUserDisplayName;
    @SerializedName("p_user_email")
    @Expose
    private String pUserEmail;
    @SerializedName("p_auth_jwt")
    @Expose
    private String pAuthJwt;

    public String getpUserRoomName() {
        return pUserRoomName;
    }

    public void setpUserRoomName(String pUserRoomName) {
        this.pUserRoomName = pUserRoomName;
    }

    public String getpMeetDomain() {
        return pMeetDomain;
    }

    public void setpMeetDomain(String pMeetDomain) {
        this.pMeetDomain = pMeetDomain;
    }

    public String getpUserDisplayName() {
        return pUserDisplayName;
    }

    public void setpUserDisplayName(String pUserDisplayName) {
        this.pUserDisplayName = pUserDisplayName;
    }

    public String getpUserEmail() {
        return pUserEmail;
    }

    public void setpUserEmail(String pUserEmail) {
        this.pUserEmail = pUserEmail;
    }

    public String getpAuthJwt() {
        return pAuthJwt;
    }

    public void setpAuthJwt(String pAuthJwt) {
        this.pAuthJwt = pAuthJwt;
    }
}
