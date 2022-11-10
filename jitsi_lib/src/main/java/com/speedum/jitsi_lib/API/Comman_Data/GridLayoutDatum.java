
package com.speedum.jitsi_lib.API.Comman_Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GridLayoutDatum implements Serializable
{

    @SerializedName("column_name")
    @Expose
    private String columnName;
    @SerializedName("column_label")
    @Expose
    private String columnLabel;
    @SerializedName("column_hide_flag")
    @Expose
    private String columnHideFlag;
    @SerializedName("column_text_wrap")
    @Expose
    private String columnTextWrap;
    @SerializedName("column_alignment")
    @Expose
    private String columnAlignment;
    @SerializedName("column_size")
    @Expose
    private String columnSize;
    @SerializedName("column_param_flag")
    @Expose
    private String columnParamFlag;
    @SerializedName("column_read_more_flag")
    @Expose
    private String columnReadMoreFlag;
    @SerializedName("column_action_flag")
    @Expose
    private String columnActionFlag;
    @SerializedName("column_action_code")
    @Expose
    private String columnActionCode;
    @SerializedName("column_filter_type")
    @Expose
    private String columnFilterType;
    @SerializedName("column_checkbox_param_flag")
    @Expose
    private String columnCheckboxParamFlag;
    @SerializedName("column_compact_grid_flag")
    @Expose
    private String columnCompactGridFlag;
    @SerializedName("column_compact_grid_sequence")
    @Expose
    private String columnCompactGridSequence;
    @SerializedName("column_list_flag")
    @Expose
    private String columnListFlag;
    @SerializedName("column_list_sequence")
    @Expose
    private String columnListSequence;
    @SerializedName("column_list_type")
    @Expose
    private String columnListType;
    private final static long serialVersionUID = 6186045069390418339L;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnLabel() {
        return columnLabel;
    }

    public void setColumnLabel(String columnLabel) {
        this.columnLabel = columnLabel;
    }

    public String getColumnHideFlag() {
        return columnHideFlag;
    }

    public void setColumnHideFlag(String columnHideFlag) {
        this.columnHideFlag = columnHideFlag;
    }

    public String getColumnTextWrap() {
        return columnTextWrap;
    }

    public void setColumnTextWrap(String columnTextWrap) {
        this.columnTextWrap = columnTextWrap;
    }

    public String getColumnAlignment() {
        return columnAlignment;
    }

    public void setColumnAlignment(String columnAlignment) {
        this.columnAlignment = columnAlignment;
    }

    public String getColumnSize() {
        return columnSize;
    }

    public void setColumnSize(String columnSize) {
        this.columnSize = columnSize;
    }

    public String getColumnParamFlag() {
        return columnParamFlag;
    }

    public void setColumnParamFlag(String columnParamFlag) {
        this.columnParamFlag = columnParamFlag;
    }

    public String getColumnReadMoreFlag() {
        return columnReadMoreFlag;
    }

    public void setColumnReadMoreFlag(String columnReadMoreFlag) {
        this.columnReadMoreFlag = columnReadMoreFlag;
    }

    public String getColumnActionFlag() {
        return columnActionFlag;
    }

    public void setColumnActionFlag(String columnActionFlag) {
        this.columnActionFlag = columnActionFlag;
    }

    public String getColumnActionCode() {
        return columnActionCode;
    }

    public void setColumnActionCode(String columnActionCode) {
        this.columnActionCode = columnActionCode;
    }

    public String getColumnFilterType() {
        return columnFilterType;
    }

    public void setColumnFilterType(String columnFilterType) {
        this.columnFilterType = columnFilterType;
    }

    public String getColumnCheckboxParamFlag() {
        return columnCheckboxParamFlag;
    }

    public void setColumnCheckboxParamFlag(String columnCheckboxParamFlag) {
        this.columnCheckboxParamFlag = columnCheckboxParamFlag;
    }

    public String getColumnCompactGridFlag() {
        return columnCompactGridFlag;
    }

    public void setColumnCompactGridFlag(String columnCompactGridFlag) {
        this.columnCompactGridFlag = columnCompactGridFlag;
    }

    public String getColumnCompactGridSequence() {
        return columnCompactGridSequence;
    }

    public void setColumnCompactGridSequence(String columnCompactGridSequence) {
        this.columnCompactGridSequence = columnCompactGridSequence;
    }

    public String getColumnListFlag() {
        return columnListFlag;
    }

    public void setColumnListFlag(String columnListFlag) {
        this.columnListFlag = columnListFlag;
    }

    public String getColumnListSequence() {
        return columnListSequence;
    }

    public void setColumnListSequence(String columnListSequence) {
        this.columnListSequence = columnListSequence;
    }

    public String getColumnListType() {
        return columnListType;
    }

    public void setColumnListType(String columnListType) {
        this.columnListType = columnListType;
    }

}
