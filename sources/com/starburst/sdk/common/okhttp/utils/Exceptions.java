package com.starburst.sdk.common.okhttp.utils;

/* JADX INFO: loaded from: classes.dex */
public class Exceptions {
    public static void illegalArgument(String str, Object... objArr) {
        throw new IllegalArgumentException(String.format(str, objArr));
    }
}
