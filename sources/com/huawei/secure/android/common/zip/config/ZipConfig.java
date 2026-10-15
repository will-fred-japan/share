package com.huawei.secure.android.common.zip.config;

import com.jieli.jl_bt_ota.constant.BluetoothConstant;

/* JADX INFO: loaded from: classes.dex */
public class ZipConfig {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f16005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f16006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String[] f16007e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f16003a = 104857600;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16004b = BluetoothConstant.SEND_DATA_MAX_TIMEOUT;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String[] f16008f = {"jsp", "php", "php2", "php3", "php4", "php5", "phps", "pht", "phtm", "phtml", "py", "pl", "elf", "lua", "sh", "js"};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f16009g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f16010h = false;

    public ZipConfig(String str, String str2) {
        this.f16005c = str;
        this.f16006d = str2;
    }

    public String[] getBlackListSuffix() {
        return this.f16008f;
    }

    public int getFileNumThreshold() {
        return this.f16004b;
    }

    public String getTargetDir() {
        return this.f16006d;
    }

    public long getTopSizeThreshold() {
        return this.f16003a;
    }

    public String[] getWhiteListSuffix() {
        return this.f16007e;
    }

    public String getZipFile() {
        return this.f16005c;
    }

    public boolean isGbkZipFile() {
        return this.f16010h;
    }

    public boolean isLoadDisk() {
        return this.f16009g;
    }

    public void setBlackListSuffix(String[] strArr) {
        this.f16008f = strArr;
    }

    public void setFileNumThreshold(int i9) {
        this.f16004b = i9;
    }

    public void setGbkZipFile(boolean z8) {
        this.f16010h = z8;
    }

    public void setLoadDisk(boolean z8) {
        this.f16009g = z8;
    }

    public void setTargetDir(String str) {
        this.f16006d = str;
    }

    public void setTopSizeThreshold(long j) {
        this.f16003a = j;
    }

    public void setWhiteListSuffix(String[] strArr) {
        this.f16007e = strArr;
    }

    public void setZipFile(String str) {
        this.f16005c = str;
    }
}
