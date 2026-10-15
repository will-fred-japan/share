package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.config.AesDecrypt;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AesDecrypt f14617a;

    public k(Context context, String str) {
        this.f14617a = !TextUtils.isEmpty(a(context, str)) ? new h(context, str) : new g(context, str);
    }

    private String a(Context context, String str) {
        String strA = l.a(context, str, "agc_plugin_", "crypto");
        if (strA == null) {
            return null;
        }
        try {
            return new String(Hex.decodeHexString(strA), "utf-8");
        } catch (UnsupportedEncodingException | IllegalArgumentException e9) {
            H2.a.h(e9, new StringBuilder("UnsupportedEncodingException"), "ReaderStrategy");
            return null;
        }
    }

    public String a(String str, String str2) {
        return this.f14617a.decrypt(str, str2);
    }
}
