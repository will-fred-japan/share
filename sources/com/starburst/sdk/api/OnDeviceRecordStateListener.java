package com.starburst.sdk.api;

/* JADX INFO: loaded from: classes.dex */
public interface OnDeviceRecordStateListener {
    public static final int FUNCTION_A2DP_RECORD = 2;
    public static final int FUNCTION_CALL_RECORD = 1;
    public static final int FUNCTION_FACE_TO_FACE_TRANSLATION = 4;
    public static final int FUNCTION_LIVE_RECORD = 0;
    public static final int FUNCTION_SIMULTANEOUS_TRANSLATION = 3;
    public static final int STATE_END = 2;
    public static final int STATE_START = 1;
    public static final int TYPE_A2DP_TRANSLATE = 3;
    public static final int TYPE_CALL_RECORD = 2;
    public static final int TYPE_CALL_TRANSLATE = 4;
    public static final int TYPE_RECORD = 1;

    void onError(int i9, int i10);

    void onStateChange(int i9, int i10);

    default void onRemoteFunctionRequest(int i9) {
    }
}
