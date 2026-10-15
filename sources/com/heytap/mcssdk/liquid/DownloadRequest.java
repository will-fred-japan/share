package com.heytap.mcssdk.liquid;

import com.heytap.mcs.liquid.model.ActionInfo;
import com.heytap.msp.push.callback.ILiquidDownloadCallback;

/* JADX INFO: loaded from: classes.dex */
public class DownloadRequest {
    public static final int DOWNLOAD_TYPE_APP = 1;
    public static final int DOWNLOAD_TYPE_FILE = 2;
    public static final String PARAMS_MACRO_CLICK_AREA = "$clickArea$";
    public static final String PARAMS_MACRO_GROUP_TRACE_ID = "$groupTraceId$";
    public static final String PARAMS_MACRO_SHOW_TYPE = "$liquidShowType$";
    public static final String PARAMS_MACRO_STATUS = "$liquidStatus$";
    public static final String PARAMS_MACRO_TRACE_ID = "$traceId$";
    private ActionInfo action;
    private ILiquidDownloadCallback callback;
    private String desc;
    private int loadingType;
    private ActionInfo managerAction;
    private int percent;
    private String pkgName;
    private int status;
    private String token;
    private String traceId;

    public static final class Builder {
        private ActionInfo action;
        private ILiquidDownloadCallback callback;
        private String desc;
        private int loadingType;
        private ActionInfo managerAction;
        private int percent;
        private String pkgName;
        private int status;
        private String token;
        private String traceId;

        private Builder() {
        }

        public Builder action(ActionInfo actionInfo) {
            this.action = actionInfo;
            return this;
        }

        public DownloadRequest build() {
            return new DownloadRequest(this.loadingType, this.pkgName, this.traceId, this.token, this.status, this.desc, this.action, this.managerAction, this.percent, this.callback);
        }

        public Builder callback(ILiquidDownloadCallback iLiquidDownloadCallback) {
            this.callback = iLiquidDownloadCallback;
            return this;
        }

        public Builder desc(String str) {
            this.desc = str;
            return this;
        }

        public Builder loadingType(int i9) {
            this.loadingType = i9;
            return this;
        }

        public Builder managerAction(ActionInfo actionInfo) {
            this.managerAction = actionInfo;
            return this;
        }

        public Builder percent(int i9) {
            this.percent = i9;
            return this;
        }

        public Builder pkgName(String str) {
            this.pkgName = str;
            return this;
        }

        public Builder status(int i9) {
            this.status = i9;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder traceId(String str) {
            this.traceId = str;
            return this;
        }
    }

    public interface ErrorCode {
        public static final int ERROR_APP_SWITCH_OFF = 39;
        public static final int ERROR_BASE_INFO_MISSING = 10;
        public static final int ERROR_CODE_FREQUENT = 10003;
        public static final int ERROR_CONTEXT = 10001;
        public static final int ERROR_DESC_EMPTY = 17;
        public static final int ERROR_DEVICE_IS_TABLET = 36;
        public static final int ERROR_ERR_ADDR_NOT_FOUND = 19;
        public static final int ERROR_ERR_JUMP_TARGET_APP_ILLEGAL = 26;
        public static final int ERROR_ERR_MANAGER_ADDR_NOT_FOUND = 20;
        public static final int ERROR_ERR_TASK_STATUS_ILLEGALL = -2;
        public static final int ERROR_HAS_SAME_NAMED_TASK = 11;
        public static final int ERROR_ILLEGAL_COMPONENT = 10002;
        public static final int ERROR_ILLEGAL_LOADING_TYPE = 8;
        public static final int ERROR_ILLEGAL_PERCENT = 22;
        public static final int ERROR_INIT_BASE_INFO_MISSING = 21;
        public static final int ERROR_JUMP_TARGET_APP_PACKAGE_ERROR = 25;
        public static final int ERROR_LIQUID_CARD_NOT_SHOWED_YET = 31;
        public static final int ERROR_LIQUID_SWITCH_NOT_OPENED = 27;
        public static final int ERROR_LIQUID_TASK_CARD_HAS_BEEN_CLOSED_BY_USER = 40;
        public static final int ERROR_LOADING_TARGET_VERIFY_FAILED = 5;
        public static final int ERROR_LOADING_TYPE_FAILED = 16;
        public static final int ERROR_MAX_LIMIT = 10004;
        public static final int ERROR_MCS_NOT_SUPPORT_LIQUID = 10005;
        public static final int ERROR_MCS_NOT_SUPPORT_LIQUID_BATCH = 10006;
        public static final int ERROR_MISSING_CALLBACK = 12;
        public static final int ERROR_MISSING_PACKAGE_NAME = 9;
        public static final int ERROR_MISSING_TARGET_NAME = 7;
        public static final int ERROR_MISSING_TOKEN = 6;
        public static final int ERROR_MISSING_TRACE_ID = 2;
        public static final int ERROR_OS_NOT_SUPPORT_LIQUID = 30;
        public static final int ERROR_OS_VERSION_BELOW_15 = 10007;
        public static final int ERROR_PACKAGE_NAME_VERIFY_FAILED = 3;
        public static final int ERROR_SHOW_LIQUID_PANEL_FAILED = 24;
        public static final int ERROR_SWITCH_PANEL_OPEN_ERROR = 28;
        public static final int ERROR_TASK_APP_LARGEST_NUMBER_LIMITED = 34;
        public static final int ERROR_TASK_LARGEST_NUMBER_LIMIT = 35;
        public static final int ERROR_TASK_LIMITED = 29;
        public static final int ERROR_TASK_STATUS_ILLEGAL = 38;
        public static final int ERROR_TITLE_EMPTY = 18;
        public static final int ERROR_TOKEN_EXPIRED = 4;
        public static final int ERROR_TOKEN_VERIFY_FAILED = 37;
        public static final int ERROR_TRACE_ID_VERIFY_FAILED = 13;
    }

    public DownloadRequest(int i9, String str, String str2, String str3, int i10, String str4, ActionInfo actionInfo, ActionInfo actionInfo2, int i11, ILiquidDownloadCallback iLiquidDownloadCallback) {
        this.loadingType = i9;
        this.pkgName = str;
        this.traceId = str2;
        this.token = str3;
        this.status = i10;
        this.desc = str4;
        this.action = actionInfo;
        this.managerAction = actionInfo2;
        this.percent = i11;
        this.callback = iLiquidDownloadCallback;
    }

    public static Builder builder() {
        return new Builder();
    }

    public ActionInfo getAction() {
        return this.action;
    }

    public ILiquidDownloadCallback getCallback() {
        return this.callback;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getLoadingType() {
        return this.loadingType;
    }

    public ActionInfo getManagerAction() {
        return this.managerAction;
    }

    public int getPercent() {
        return this.percent;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public int getStatus() {
        return this.status;
    }

    public String getToken() {
        return this.token;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public void setAction(ActionInfo actionInfo) {
        this.action = actionInfo;
    }

    public void setCallback(ILiquidDownloadCallback iLiquidDownloadCallback) {
        this.callback = iLiquidDownloadCallback;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setLoadingType(int i9) {
        this.loadingType = i9;
    }

    public void setManagerAction(ActionInfo actionInfo) {
        this.managerAction = actionInfo;
    }

    public void setPercent(int i9) {
        this.percent = i9;
    }

    public void setPkgName(String str) {
        this.pkgName = str;
    }

    public void setStatus(int i9) {
        this.status = i9;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    public String toString() {
        return "DownloadRequest{loadingType=" + this.loadingType + ", pkgName='" + this.pkgName + "', traceId='" + this.traceId + "', token='" + this.token + "', status=" + this.status + ", desc='" + this.desc + "', action=" + this.action + ", managerAction=" + this.managerAction + ", percent=" + this.percent + ", callback=" + this.callback + '}';
    }
}
