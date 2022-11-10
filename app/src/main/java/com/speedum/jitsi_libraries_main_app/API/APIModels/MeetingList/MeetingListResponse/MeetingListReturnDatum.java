
package com.speedum.jitsi_libraries_main_app.API.APIModels.MeetingList.MeetingListResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MeetingListReturnDatum implements Serializable
{

    @SerializedName("p_meet_id")
    @Expose
    private String pMeetId;
    @SerializedName("p_meet_title")
    @Expose
    private String pMeetTitle;
    @SerializedName("p_meet_required_attendees")
    @Expose
    private String pMeetRequiredAttendees;
    @SerializedName("p_meet_optional_attendees")
    @Expose
    private String pMeetOptionalAttendees;
    @SerializedName("p_meet_date")
    @Expose
    private String pMeetDate;
    @SerializedName("p_meet_from_time")
    @Expose
    private String pMeetFromTime;
    @SerializedName("p_meet_to_time")
    @Expose
    private String pMeetToTime;
    @SerializedName("p_meet_duration")
    @Expose
    private String pMeetDuration;
    @SerializedName("meet_repeat_type_id")
    @Expose
    private String meetRepeatTypeId;
    @SerializedName("meet_repeat_type_desc")
    @Expose
    private Object meetRepeatTypeDesc;
    @SerializedName("meet_reminder_type_id")
    @Expose
    private String meetReminderTypeId;
    @SerializedName("meet_reminder_type_desc")
    @Expose
    private Object meetReminderTypeDesc;
    @SerializedName("p_meet_email_reminder_flag")
    @Expose
    private String pMeetEmailReminderFlag;
    @SerializedName("p_meet_email_reminder_msg")
    @Expose
    private String pMeetEmailReminderMsg;
    @SerializedName("p_meet_description")
    @Expose
    private String pMeetDescription;
    @SerializedName("create_user")
    @Expose
    private String createUser;
    @SerializedName("p_org_id")
    @Expose
    private String pOrgId;
    @SerializedName("from_user_id")
    @Expose
    private String fromUserId;
    @SerializedName("p_dialog_id")
    @Expose
    private String pDialogId;

    @SerializedName("meet_unique_code")
    @Expose
    private String meet_unique_code;

    public String getMeet_unique_code() {
        return meet_unique_code;
    }

    public void setMeet_unique_code(String meet_unique_code) {
        this.meet_unique_code = meet_unique_code;
    }

    private final static long serialVersionUID = 7145876646540727436L;

    public String getPMeetId() {
        return pMeetId;
    }

    public void setPMeetId(String pMeetId) {
        this.pMeetId = pMeetId;
    }

    public String getPMeetTitle() {
        return pMeetTitle;
    }

    public void setPMeetTitle(String pMeetTitle) {
        this.pMeetTitle = pMeetTitle;
    }

    public String getPMeetRequiredAttendees() {
        return pMeetRequiredAttendees;
    }

    public void setPMeetRequiredAttendees(String pMeetRequiredAttendees) {
        this.pMeetRequiredAttendees = pMeetRequiredAttendees;
    }

    public String getPMeetOptionalAttendees() {
        return pMeetOptionalAttendees;
    }

    public void setPMeetOptionalAttendees(String pMeetOptionalAttendees) {
        this.pMeetOptionalAttendees = pMeetOptionalAttendees;
    }

    public String getPMeetDate() {
        return pMeetDate;
    }

    public void setPMeetDate(String pMeetDate) {
        this.pMeetDate = pMeetDate;
    }

    public String getPMeetFromTime() {
        return pMeetFromTime;
    }

    public void setPMeetFromTime(String pMeetFromTime) {
        this.pMeetFromTime = pMeetFromTime;
    }

    public String getPMeetToTime() {
        return pMeetToTime;
    }

    public void setPMeetToTime(String pMeetToTime) {
        this.pMeetToTime = pMeetToTime;
    }

    public String getPMeetDuration() {
        return pMeetDuration;
    }

    public void setPMeetDuration(String pMeetDuration) {
        this.pMeetDuration = pMeetDuration;
    }

    public String getMeetRepeatTypeId() {
        return meetRepeatTypeId;
    }

    public void setMeetRepeatTypeId(String meetRepeatTypeId) {
        this.meetRepeatTypeId = meetRepeatTypeId;
    }

    public Object getMeetRepeatTypeDesc() {
        return meetRepeatTypeDesc;
    }

    public void setMeetRepeatTypeDesc(Object meetRepeatTypeDesc) {
        this.meetRepeatTypeDesc = meetRepeatTypeDesc;
    }

    public String getMeetReminderTypeId() {
        return meetReminderTypeId;
    }

    public void setMeetReminderTypeId(String meetReminderTypeId) {
        this.meetReminderTypeId = meetReminderTypeId;
    }

    public Object getMeetReminderTypeDesc() {
        return meetReminderTypeDesc;
    }

    public void setMeetReminderTypeDesc(Object meetReminderTypeDesc) {
        this.meetReminderTypeDesc = meetReminderTypeDesc;
    }

    public String getPMeetEmailReminderFlag() {
        return pMeetEmailReminderFlag;
    }

    public void setPMeetEmailReminderFlag(String pMeetEmailReminderFlag) {
        this.pMeetEmailReminderFlag = pMeetEmailReminderFlag;
    }

    public String getPMeetEmailReminderMsg() {
        return pMeetEmailReminderMsg;
    }

    public void setPMeetEmailReminderMsg(String pMeetEmailReminderMsg) {
        this.pMeetEmailReminderMsg = pMeetEmailReminderMsg;
    }

    public String getPMeetDescription() {
        return pMeetDescription;
    }

    public void setPMeetDescription(String pMeetDescription) {
        this.pMeetDescription = pMeetDescription;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getPOrgId() {
        return pOrgId;
    }

    public void setPOrgId(String pOrgId) {
        this.pOrgId = pOrgId;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getPDialogId() {
        return pDialogId;
    }

    public void setPDialogId(String pDialogId) {
        this.pDialogId = pDialogId;
    }

}
