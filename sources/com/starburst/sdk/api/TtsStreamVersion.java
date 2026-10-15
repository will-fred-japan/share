package com.starburst.sdk.api;

/* JADX INFO: loaded from: classes.dex */
public enum TtsStreamVersion {
    V1("v1"),
    V2("v2");

    private final String value;

    TtsStreamVersion(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
