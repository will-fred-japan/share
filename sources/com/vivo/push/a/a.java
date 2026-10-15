package com.vivo.push.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.vivo.push.d;
import com.vivo.push.j;
import com.vivo.push.w;

/* JADX INFO: compiled from: CommandBridge.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static void a(Context context, String str, w wVar) {
        boolean zD = wVar.d();
        j jVarA = j.a(context, zD ? "com.vivo.vms.upstageservice" : "com.vivo.vms.aidlservice");
        boolean zA = jVarA.a();
        if (TextUtils.isEmpty(wVar.a())) {
            wVar.a(context.getPackageName());
        }
        if (zA && !"com.vivo.pushservice".equals(context.getPackageName())) {
            d dVar = new d(wVar.a(), str, new Bundle());
            wVar.a(dVar);
            if (jVarA.a(dVar.b())) {
                return;
            }
            com.vivo.push.util.w.b("CommandBridge", "send command error by aidl");
            com.vivo.push.util.w.c("send command error by aidl");
        }
        Intent intent = new Intent("com.vivo.pushservice.action.METHOD");
        intent.setPackage(str);
        intent.setClassName(str, zD ? "com.vivo.push.sdk.service.UpstageService" : "com.vivo.push.sdk.service.PushService");
        wVar.a(intent);
        try {
            a(context, intent);
        } catch (Exception e9) {
            com.vivo.push.util.w.a("CommandBridge", "CommandBridge startService exception: ", e9);
        }
    }

    public static void a(Context context, Intent intent) {
        if (context == null) {
            com.vivo.push.util.w.d("CommandBridge", "enter startService context is null");
            throw new Exception("context is null");
        }
        try {
            context.startService(intent);
        } catch (Exception e9) {
            com.vivo.push.util.w.a("CommandBridge", "start service error", e9);
            intent.setComponent(null);
            context.sendBroadcast(intent);
        }
    }
}
