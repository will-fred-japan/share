package com.huawei.hms.push;

/* JADX INFO: loaded from: classes.dex */
public enum AttributionEvent {
    APP_START_COMPLETE(1),
    OPEN_PRIVACY_PAGE(2),
    REJECT_PRIVACY(3),
    AGREED_PRIVACY(4),
    PERMISSION_GRANTED(5),
    PERMISSION_DENIED(6),
    OPEN_LANDING_PAGE(7);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f15361a;

    AttributionEvent(int i9) {
        this.f15361a = i9;
    }

    public int getEventId() {
        return this.f15361a;
    }
}
