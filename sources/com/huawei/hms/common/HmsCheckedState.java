package com.huawei.hms.common;

/* JADX INFO: loaded from: classes.dex */
public enum HmsCheckedState {
    UNCHECKED(0),
    NOT_NEED_UPDATE(1),
    NEED_UPDATE(2);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f14884a;

    HmsCheckedState(int i9) {
        this.f14884a = i9;
    }

    public int getState() {
        return this.f14884a;
    }
}
