package com.starburst.sdk.api;

/* JADX INFO: loaded from: classes.dex */
public interface IFileDownLoadCallback {
    public static final int STATUS_DOWNLOADING = 1;
    public static final int STATUS_DOWNLOAD_FAIL = 3;
    public static final int STATUS_DOWNLOAD_SUCCESS = 2;

    void onProgressChange(int i9);

    void onStatusChange(int i9, String str);
}
