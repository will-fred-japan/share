package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.net.InetSocketAddress;

/* JADX INFO: loaded from: classes2.dex */
public final class cr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f17159a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f195a;

    public cr(String str, int i9) {
        this.f195a = str;
        this.f17159a = i9;
    }

    public int a() {
        return this.f17159a;
    }

    public String toString() {
        if (this.f17159a <= 0) {
            return this.f195a;
        }
        return this.f195a + Constants.COLON_SEPARATOR + this.f17159a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m169a() {
        return this.f195a;
    }

    public static cr a(String str, int i9) {
        int iLastIndexOf = str.lastIndexOf(Constants.COLON_SEPARATOR);
        if (iLastIndexOf != -1) {
            String strSubstring = str.substring(0, iLastIndexOf);
            try {
                int i10 = Integer.parseInt(str.substring(iLastIndexOf + 1));
                if (i10 > 0) {
                    i9 = i10;
                }
            } catch (NumberFormatException unused) {
            }
            str = strSubstring;
        }
        return new cr(str, i9);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static InetSocketAddress m168a(String str, int i9) {
        cr crVarA = a(str, i9);
        return new InetSocketAddress(crVarA.m169a(), crVarA.a());
    }
}
