package com.starburst.sdk.core.feature;

/* JADX INFO: loaded from: classes.dex */
public class TcFeatureDecision {
    public static final String DEFAULT_MESSAGE = "设备绑定套餐不支持此功能";
    public static final int ERROR_CODE_FEATURE_LIMIT = 81001;
    private final boolean allowed;
    private final int code;
    private final String message;

    private TcFeatureDecision(boolean z8, int i9, String str) {
        this.allowed = z8;
        this.code = i9;
        this.message = str;
    }

    public static TcFeatureDecision allow() {
        return new TcFeatureDecision(true, 0, "");
    }

    public static TcFeatureDecision deny(String str) {
        return new TcFeatureDecision(false, ERROR_CODE_FEATURE_LIMIT, str);
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isAllowed() {
        return this.allowed;
    }
}
