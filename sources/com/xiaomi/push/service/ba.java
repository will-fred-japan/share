package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import com.engagelab.privates.push.constants.MTPushConstants;

/* JADX INFO: loaded from: classes2.dex */
public class ba {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ba f18317a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private int f1072a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f1073a;

    private ba(Context context) {
        this.f1073a = context.getApplicationContext();
    }

    public static ba a(Context context) {
        if (f18317a == null) {
            f18317a = new ba(context);
        }
        return f18317a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m770a() {
        String str = com.xiaomi.push.z.f1181a;
        return str.contains("xmsf") || str.contains(MTPushConstants.Manufacturer.XIAOMI) || str.contains("miui");
    }

    @SuppressLint({"NewApi"})
    public int a() {
        int i9 = this.f1072a;
        if (i9 != 0) {
            return i9;
        }
        try {
            this.f1072a = Settings.Global.getInt(this.f1073a.getContentResolver(), "device_provisioned", 0);
        } catch (Exception unused) {
        }
        return this.f1072a;
    }

    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Uri m769a() {
        return Settings.Global.getUriFor("device_provisioned");
    }
}
