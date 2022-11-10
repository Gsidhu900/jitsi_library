
package com.speedum.jitsi_libraries_main_app.API.APIModels.MeetingList.MeetingListResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GridConfig implements Serializable
{

    @SerializedName("grid_id")
    @Expose
    private String gridId;
    @SerializedName("grid_code")
    @Expose
    private String gridCode;
    @SerializedName("grid_name")
    @Expose
    private String gridName;
    @SerializedName("grid_action_position")
    @Expose
    private String gridActionPosition;
    @SerializedName("grid_freeze_till_column")
    @Expose
    private String gridFreezeTillColumn;
    @SerializedName("grid_header_freeze_flag")
    @Expose
    private String gridHeaderFreezeFlag;
    @SerializedName("grid_excel_export_flag")
    @Expose
    private String gridExcelExportFlag;
    @SerializedName("grid_pivot_flag")
    @Expose
    private String gridPivotFlag;
    @SerializedName("grid_sub_total_flag")
    @Expose
    private String gridSubTotalFlag;
    @SerializedName("grid_grand_total_flag")
    @Expose
    private String gridGrandTotalFlag;
    @SerializedName("grid_archive_flag")
    @Expose
    private String gridArchiveFlag;
    @SerializedName("grid_selection_type")
    @Expose
    private String gridSelectionType;
    @SerializedName("grid_select_all_flag")
    @Expose
    private String gridSelectAllFlag;
    @SerializedName("grid_search_bar_hide_flag")
    @Expose
    private String gridSearchBarHideFlag;
    @SerializedName("grid_pagination_bar_hide_flag")
    @Expose
    private String gridPaginationBarHideFlag;
    @SerializedName("grid_blank_grid_allowed_flag")
    @Expose
    private String gridBlankGridAllowedFlag;
    @SerializedName("grid_height")
    @Expose
    private String gridHeight;
    @SerializedName("grid_default_row_count")
    @Expose
    private String gridDefaultRowCount;
    @SerializedName("grid_params_to_set_in_session_flag")
    @Expose
    private String gridParamsToSetInSessionFlag;
    @SerializedName("grid_actions_carried_forward_type")
    @Expose
    private String gridActionsCarriedForwardType;
    private final static long serialVersionUID = -2404806299238743639L;

    public String getGridId() {
        return gridId;
    }

    public void setGridId(String gridId) {
        this.gridId = gridId;
    }

    public String getGridCode() {
        return gridCode;
    }

    public void setGridCode(String gridCode) {
        this.gridCode = gridCode;
    }

    public String getGridName() {
        return gridName;
    }

    public void setGridName(String gridName) {
        this.gridName = gridName;
    }

    public String getGridActionPosition() {
        return gridActionPosition;
    }

    public void setGridActionPosition(String gridActionPosition) {
        this.gridActionPosition = gridActionPosition;
    }

    public String getGridFreezeTillColumn() {
        return gridFreezeTillColumn;
    }

    public void setGridFreezeTillColumn(String gridFreezeTillColumn) {
        this.gridFreezeTillColumn = gridFreezeTillColumn;
    }

    public String getGridHeaderFreezeFlag() {
        return gridHeaderFreezeFlag;
    }

    public void setGridHeaderFreezeFlag(String gridHeaderFreezeFlag) {
        this.gridHeaderFreezeFlag = gridHeaderFreezeFlag;
    }

    public String getGridExcelExportFlag() {
        return gridExcelExportFlag;
    }

    public void setGridExcelExportFlag(String gridExcelExportFlag) {
        this.gridExcelExportFlag = gridExcelExportFlag;
    }

    public String getGridPivotFlag() {
        return gridPivotFlag;
    }

    public void setGridPivotFlag(String gridPivotFlag) {
        this.gridPivotFlag = gridPivotFlag;
    }

    public String getGridSubTotalFlag() {
        return gridSubTotalFlag;
    }

    public void setGridSubTotalFlag(String gridSubTotalFlag) {
        this.gridSubTotalFlag = gridSubTotalFlag;
    }

    public String getGridGrandTotalFlag() {
        return gridGrandTotalFlag;
    }

    public void setGridGrandTotalFlag(String gridGrandTotalFlag) {
        this.gridGrandTotalFlag = gridGrandTotalFlag;
    }

    public String getGridArchiveFlag() {
        return gridArchiveFlag;
    }

    public void setGridArchiveFlag(String gridArchiveFlag) {
        this.gridArchiveFlag = gridArchiveFlag;
    }

    public String getGridSelectionType() {
        return gridSelectionType;
    }

    public void setGridSelectionType(String gridSelectionType) {
        this.gridSelectionType = gridSelectionType;
    }

    public String getGridSelectAllFlag() {
        return gridSelectAllFlag;
    }

    public void setGridSelectAllFlag(String gridSelectAllFlag) {
        this.gridSelectAllFlag = gridSelectAllFlag;
    }

    public String getGridSearchBarHideFlag() {
        return gridSearchBarHideFlag;
    }

    public void setGridSearchBarHideFlag(String gridSearchBarHideFlag) {
        this.gridSearchBarHideFlag = gridSearchBarHideFlag;
    }

    public String getGridPaginationBarHideFlag() {
        return gridPaginationBarHideFlag;
    }

    public void setGridPaginationBarHideFlag(String gridPaginationBarHideFlag) {
        this.gridPaginationBarHideFlag = gridPaginationBarHideFlag;
    }

    public String getGridBlankGridAllowedFlag() {
        return gridBlankGridAllowedFlag;
    }

    public void setGridBlankGridAllowedFlag(String gridBlankGridAllowedFlag) {
        this.gridBlankGridAllowedFlag = gridBlankGridAllowedFlag;
    }

    public String getGridHeight() {
        return gridHeight;
    }

    public void setGridHeight(String gridHeight) {
        this.gridHeight = gridHeight;
    }

    public String getGridDefaultRowCount() {
        return gridDefaultRowCount;
    }

    public void setGridDefaultRowCount(String gridDefaultRowCount) {
        this.gridDefaultRowCount = gridDefaultRowCount;
    }

    public String getGridParamsToSetInSessionFlag() {
        return gridParamsToSetInSessionFlag;
    }

    public void setGridParamsToSetInSessionFlag(String gridParamsToSetInSessionFlag) {
        this.gridParamsToSetInSessionFlag = gridParamsToSetInSessionFlag;
    }

    public String getGridActionsCarriedForwardType() {
        return gridActionsCarriedForwardType;
    }

    public void setGridActionsCarriedForwardType(String gridActionsCarriedForwardType) {
        this.gridActionsCarriedForwardType = gridActionsCarriedForwardType;
    }

}
