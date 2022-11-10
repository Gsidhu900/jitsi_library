package com.speedum.jitsi_lib.API;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class Process_ID {

    @Inject
    public Process_ID() {
    }

    // Process ids of APIs
    public static String LOGIN_USER="login_user";
    public static String GET_JWT_TOKEN="sgconfig_get_ct_jitsi_credentials";


}
