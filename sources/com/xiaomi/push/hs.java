package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class hs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile hs f17663a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Context f571a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Map<String, ht> f572a = new HashMap();

    private hs(Context context) {
        this.f571a = context;
    }

    public static hs a(Context context) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.c.d("[TinyDataManager]:mContext is null, TinyDataManager.getInstance(Context) failed.");
            return null;
        }
        if (f17663a == null) {
            synchronized (hs.class) {
                try {
                    if (f17663a == null) {
                        f17663a = new hs(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f17663a;
    }

    public void a(ht htVar, String str) {
        if (htVar == null) {
            com.xiaomi.channel.commonutils.logger.c.d("[TinyDataManager]: please do not add null mUploader to TinyDataManager.");
        } else if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.c.d("[TinyDataManager]: can not add a provider from unkown resource.");
        } else {
            m482a().put(str, htVar);
        }
    }

    public ht a() {
        ht htVar = this.f572a.get("UPLOADER_PUSH_CHANNEL");
        if (htVar != null) {
            return htVar;
        }
        ht htVar2 = this.f572a.get("UPLOADER_HTTP");
        if (htVar2 != null) {
            return htVar2;
        }
        return null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Map<String, ht> m482a() {
        return this.f572a;
    }

    public boolean a(hy hyVar, String str) {
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.c.m9a("pkgName is null or empty, upload ClientUploadDataItem failed.");
            return false;
        }
        if (com.xiaomi.push.service.bl.a(hyVar, false)) {
            return false;
        }
        if (TextUtils.isEmpty(hyVar.d())) {
            hyVar.f(com.xiaomi.push.service.bl.a());
        }
        hyVar.g(str);
        com.xiaomi.push.service.bm.a(this.f571a, hyVar);
        return true;
    }
}
