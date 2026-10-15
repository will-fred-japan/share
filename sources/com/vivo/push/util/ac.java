package com.vivo.push.util;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: PushClientSdkAppSp.java */
/* JADX INFO: loaded from: classes.dex */
public final class ac extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f16823b;

    public ac(Context context) {
        if (context != null) {
            this.f16823b = context;
            a(context);
        }
    }

    private synchronized void a(Context context) {
        a(context, "com.vivo.push_preferences.appconfig_v1");
    }

    public final String c() {
        String string;
        Context context = this.f16823b;
        String packageName = context.getPackageName();
        Object objA = ak.a(context, packageName, "com.vivo.push.app_id");
        if (objA != null) {
            string = objA.toString();
        } else {
            Object objA2 = ak.a(context, packageName, "app_id");
            string = objA2 != null ? objA2.toString() : "";
        }
        return TextUtils.isEmpty(string) ? b("APP_APPID", "") : string;
    }

    public final String d() {
        String string;
        Context context = this.f16823b;
        String packageName = context.getPackageName();
        Object objA = ak.a(context, packageName, "com.vivo.push.api_key");
        if (objA != null) {
            string = objA.toString();
        } else {
            Object objA2 = ak.a(context, packageName, "api_key");
            string = objA2 != null ? objA2.toString() : "";
        }
        return TextUtils.isEmpty(string) ? b("APP_APIKEY", "") : string;
    }
}
