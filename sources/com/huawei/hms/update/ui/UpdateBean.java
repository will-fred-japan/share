package com.huawei.hms.update.ui;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class UpdateBean implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f15582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f15583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f15584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f15585d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f15586e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f15587f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ArrayList f15588g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f15589h = true;

    public String getClientAppId() {
        return (String) a(this.f15586e);
    }

    public String getClientAppName() {
        return (String) a(this.f15587f);
    }

    public String getClientPackageName() {
        return (String) a(this.f15584c);
    }

    public int getClientVersionCode() {
        return ((Integer) a(Integer.valueOf(this.f15585d))).intValue();
    }

    public boolean getResolutionInstallHMS() {
        return this.f15583b;
    }

    public ArrayList getTypeList() {
        return (ArrayList) a(this.f15588g);
    }

    public boolean isHmsOrApkUpgrade() {
        return ((Boolean) a(Boolean.valueOf(this.f15582a))).booleanValue();
    }

    public boolean isNeedConfirm() {
        return ((Boolean) a(Boolean.valueOf(this.f15589h))).booleanValue();
    }

    public void setClientAppId(String str) {
        this.f15586e = str;
    }

    public void setClientAppName(String str) {
        this.f15587f = str;
    }

    public void setClientPackageName(String str) {
        this.f15584c = str;
    }

    public void setClientVersionCode(int i9) {
        this.f15585d = i9;
    }

    public void setHmsOrApkUpgrade(boolean z8) {
        this.f15582a = z8;
    }

    public void setNeedConfirm(boolean z8) {
        this.f15589h = z8;
    }

    public void setResolutionInstallHMS(boolean z8) {
        this.f15583b = z8;
    }

    public void setTypeList(ArrayList arrayList) {
        this.f15588g = arrayList;
    }

    private static <T> T a(T t) {
        return t;
    }
}
