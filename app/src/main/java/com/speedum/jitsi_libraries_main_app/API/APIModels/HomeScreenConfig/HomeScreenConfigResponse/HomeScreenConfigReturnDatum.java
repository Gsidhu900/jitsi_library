
package com.speedum.jitsi_libraries_main_app.API.APIModels.HomeScreenConfig.HomeScreenConfigResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class HomeScreenConfigReturnDatum implements Serializable {

    @SerializedName("menu_name")
    @Expose
    private String menuName;
    @SerializedName("menu_title")
    @Expose
    private String menuTitle;
    @SerializedName("menu_image")
    @Expose
    private String menuImage;
    @SerializedName("menu_color")
    @Expose
    private String menuColor;
    @SerializedName("menu_title_color")
    @Expose
    private String menuTitleColor;
    @SerializedName("menu_action_screen_identifier")
    @Expose
    private String menuActionScreenIdentifier;
    @SerializedName("menu_screen_title")
    @Expose
    private String menuScreenTitle;
    @SerializedName("menu_static_header_text")
    @Expose
    private String menuStaticHeaderText;
    @SerializedName("menu_empty_screen_text")
    @Expose
    private String menuEmptyScreenText;
    @SerializedName("menu_call_button")
    @Expose
    private String menuCallButton;
    @SerializedName("menu_url")
    @Expose
    private String menuUrl;
    @SerializedName("menu_download")
    @Expose
    private String menuDownload;
    @SerializedName("menu_icon")
    @Expose
    private String menuIcon;
    @SerializedName("menu_text")
    @Expose
    private String menuText;
    @SerializedName("menu_enable_feature")
    @Expose
    private String menuEnableFeature;
    @SerializedName("menu_parent_id")
    @Expose
    private String menuParent_id;
    @SerializedName("menu_type")
    @Expose
    private String menuType;
    @SerializedName("menu_display_order")
    @Expose
    private String menuDisplay_order;
    @SerializedName("menu_id")
    @Expose
    private String menuId;
    @SerializedName("menu_action_screen_identifier_detail")
    @Expose
    private String menu_action_screen_identifier_detail;
    @SerializedName("menu_action_screen_identifier_detail_json")
    @Expose
    private String menu_action_screen_identifier_detail_json;

    public String getMenu_action_screen_identifier_detail_json() {
        return menu_action_screen_identifier_detail_json;
    }

    public void setMenu_action_screen_identifier_detail_json(String menu_action_screen_identifier_detail_json) {
        this.menu_action_screen_identifier_detail_json = menu_action_screen_identifier_detail_json;
    }

    private final static long serialVersionUID = -6137324301777082140L;

    public String getMenu_action_screen_identifier_detail() {
        return menu_action_screen_identifier_detail;
    }

    public void setMenu_action_screen_identifier_detail(String menu_action_screen_identifier_detail) {
        this.menu_action_screen_identifier_detail = menu_action_screen_identifier_detail;
    }

    public void setMenuParent_id(String menuParent_id) {
        this.menuParent_id = menuParent_id;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuDisplay_order() {
        return menuDisplay_order;
    }

    public void setMenuDisplay_order(String menuDisplay_order) {
        this.menuDisplay_order = menuDisplay_order;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public String getMenuImage() {
        return menuImage;
    }

    public void setMenuImage(String menuImage) {
        this.menuImage = menuImage;
    }

    public String getMenuColor() {
        return menuColor;
    }

    public void setMenuColor(String menuColor) {
        this.menuColor = menuColor;
    }

    public String getMenuTitleColor() {
        return menuTitleColor;
    }

    public void setMenuTitleColor(String menuTitleColor) {
        this.menuTitleColor = menuTitleColor;
    }

    public String getMenuActionScreenIdentifier() {
        return menuActionScreenIdentifier;
    }

    public void setMenuActionScreenIdentifier(String menuActionScreenIdentifier) {
        this.menuActionScreenIdentifier = menuActionScreenIdentifier;
    }

    public String getMenuScreenTitle() {
        return menuScreenTitle;
    }

    public void setMenuScreenTitle(String menuScreenTitle) {
        this.menuScreenTitle = menuScreenTitle;
    }

    public String getMenuStaticHeaderText() {
        return menuStaticHeaderText;
    }

    public void setMenuStaticHeaderText(String menuStaticHeaderText) {
        this.menuStaticHeaderText = menuStaticHeaderText;
    }

    public String getMenuEmptyScreenText() {
        return menuEmptyScreenText;
    }

    public void setMenuEmptyScreenText(String menuEmptyScreenText) {
        this.menuEmptyScreenText = menuEmptyScreenText;
    }

    public String getMenuCallButton() {
        return menuCallButton;
    }

    public void setMenuCallButton(String menuCallButton) {
        this.menuCallButton = menuCallButton;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuDownload() {
        return menuDownload;
    }

    public void setMenuDownload(String menuDownload) {
        this.menuDownload = menuDownload;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuText() {
        return menuText;
    }

    public void setMenuText(String menuText) {
        this.menuText = menuText;
    }

    public String getMenuEnableFeature() {
        return menuEnableFeature;
    }

    public void setMenuEnableFeature(String menuEnableFeature) {
        this.menuEnableFeature = menuEnableFeature;
    }

    public String getMenuName() {
        return menuName;
    }

    public String getMenuParent_id() {
        return menuParent_id;
    }

}
