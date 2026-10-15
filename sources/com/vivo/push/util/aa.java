package com.vivo.push.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: compiled from: NetUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class aa {
    public static NetworkInfo a(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e9) {
            w.a("NetUtils", e9);
            return null;
        }
    }
}
