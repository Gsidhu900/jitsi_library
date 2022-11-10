
package com.speedum.jitsi_libraries_main_app.API.APIModels.Login_User;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginDataJSON {

    @SerializedName("p_password")
//    @SerializedName("p_password")
    @Expose
    private String pPassword;
    @SerializedName("p_username")
//    @SerializedName("p_login")
    @Expose
    private String pLogin;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LoginDataJSON() {
    }

    /**
     * 
     * @param pLogin
     * @param pPassword
     */
    public LoginDataJSON(String pPassword, String pLogin) {
        super();
        this.pPassword = pPassword;
        this.pLogin = pLogin;
    }

    public String getPPassword() {
        return pPassword;
    }

    public void setPPassword(String pPassword) {
        this.pPassword = pPassword;
    }

    public String getPLogin() {
        return pLogin;
    }

    public void setPLogin(String pLogin) {
        this.pLogin = pLogin;
    }

}
