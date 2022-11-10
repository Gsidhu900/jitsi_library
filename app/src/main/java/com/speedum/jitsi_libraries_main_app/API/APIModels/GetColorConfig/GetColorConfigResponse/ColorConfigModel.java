
package com.speedum.jitsi_libraries_main_app.API.APIModels.GetColorConfig.GetColorConfigResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ColorConfigModel implements Serializable {

    @SerializedName("app_top_bar_color")
    @Expose
    private String appTopBarColor="#FF5733";
    @SerializedName("topbar_title_color")
    @Expose
    private String mtopbar_title_color="#FF5733";
    @SerializedName("topbar_icons_color")
    @Expose
    private String topbar_icons_color="#FF5733";
    @SerializedName("app_positive_button")
    @Expose
    private String appPositiveButton="#FF5733";
    @SerializedName("app_negative_button")
    @Expose
    private String appNegativeButton="#FF5733";
    @SerializedName("app_button_color")
    @Expose
    private String appButtonColor="#FF5733";
    @SerializedName("app_icon_color")
    @Expose
    private String appIconColor="#FF5733";
    @SerializedName("app_default_color")
    @Expose
    private String appDefaultColor="#FF5733";
    @SerializedName("app_dark_theme_color")
    @Expose
    private String appDarkThemeColor="#FF5733";
    @SerializedName("app_medium_theme")
    @Expose
    private String appMediumTheme="#FF5733";
    @SerializedName("app_light_theme_color")
    @Expose
    private String appLightThemeColor="#FF5733";
    @SerializedName("app_logo")
    @Expose
    private String appLogo="#FF5733";
    @SerializedName("app_link_color")
    @Expose
    private String appLinkColor="#FF5733";
   @SerializedName("doctor_filter_keywords")
    @Expose
    private String doctor_filter_keywords="#FF5733";
     @SerializedName("org_filter_keywords")
    @Expose
    private String org_filter_keywords="#FF5733";

    @SerializedName("app_icon_color_2")
    @Expose
    private String appIconColor_2="#FF5733";
    @SerializedName("app_default_color_2")
    @Expose
    private String appDefaultColor_2="#FF5733";

    public String getAppIconColor_2() {
        if (appIconColor_2==null||appIconColor_2.length()<=0){
            appIconColor_2="#0099cc";
        }
        return appIconColor_2;
    }

    public void setAppIconColor_2(String appIconColor_2) {
        this.appIconColor_2 = appIconColor_2;
    }

    public String getAppDefaultColor_2() {
        if (appDefaultColor_2==null||appDefaultColor_2.length()<=0){
            appDefaultColor_2="#0099cc";
        }
        return appDefaultColor_2;
    }

    public void setAppDefaultColor_2(String appDefaultColor_2) {
        this.appDefaultColor_2 = appDefaultColor_2;
    }

    private final static long serialVersionUID = 595408288742175930L;

    public String getAppTopBarColor() {
        return appTopBarColor;
    }

    public void setAppTopBarColor(String appTopBarColor) {
        this.appTopBarColor = appTopBarColor;
    }

    public String getAppPositiveButton() {
        return appPositiveButton;
    }

    public void setAppPositiveButton(String appPositiveButton) {
        this.appPositiveButton = appPositiveButton;
    }

    public String getDoctor_filter_keywords() {
        return doctor_filter_keywords;
    }

    public void setDoctor_filter_keywords(String doctor_filter_keywords) {
        this.doctor_filter_keywords = doctor_filter_keywords;
    }

    public String getOrg_filter_keywords() {
        return org_filter_keywords;
    }

    public void setOrg_filter_keywords(String org_filter_keywords) {
        this.org_filter_keywords = org_filter_keywords;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAppNegativeButton() {
        return appNegativeButton;
    }

    public void setAppNegativeButton(String appNegativeButton) {
        this.appNegativeButton = appNegativeButton;
    }

    public String getAppButtonColor() {
        return appButtonColor;
    }

    public void setAppButtonColor(String appButtonColor) {
        this.appButtonColor = appButtonColor;
    }

    public String getAppIconColor() {
        return appIconColor;
    }

    public void setAppIconColor(String appIconColor) {
        this.appIconColor = appIconColor;
    }

    public String getAppDefaultColor() {
        return appDefaultColor;
    }

    public void setAppDefaultColor(String appDefaultColor) {
        this.appDefaultColor = appDefaultColor;
    }

    public String getAppDarkThemeColor() {
        return appDarkThemeColor;
    }

    public void setAppDarkThemeColor(String appDarkThemeColor) {
        this.appDarkThemeColor = appDarkThemeColor;
    }

    public String getAppMediumTheme() {
        return appMediumTheme;
    }

    public void setAppMediumTheme(String appMediumTheme) {
        this.appMediumTheme = appMediumTheme;
    }

    public String getAppLightThemeColor() {
        return appLightThemeColor;
    }

    public void setAppLightThemeColor(String appLightThemeColor) {
        this.appLightThemeColor = appLightThemeColor;
    }

    public String getAppLogo() {
        return appLogo;
    }

    public void setAppLogo(String appLogo) {
        this.appLogo = appLogo;
    }

    public String getAppLinkColor() {
        return appLinkColor;
    }

    public void setAppLinkColor(String appLinkColor) {
        this.appLinkColor = appLinkColor;
    }

    public String getMtopbar_title_color() {
        return mtopbar_title_color;
    }

    public void setMtopbar_title_color(String mtopbar_title_color) {
        this.mtopbar_title_color = mtopbar_title_color;
    }

    public String getTopbar_icons_color() {
        if (topbar_icons_color==null){
            topbar_icons_color="";
        }
        return topbar_icons_color;
    }

    public void setTopbar_icons_color(String topbar_icons_color) {
        this.topbar_icons_color = topbar_icons_color;
    }
}
