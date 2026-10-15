package com.starburst.sdk.req;

/* JADX INFO: loaded from: classes.dex */
public enum TTsType {
    STREAM("stream"),
    FILE("file");

    private final String mValue;

    TTsType(String str) {
        this.mValue = str;
    }

    public String getValue() {
        return this.mValue;
    }
}
