package com.huawei.hms.push;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: compiled from: SelfShowType.java */
/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f15481c = {RemoteMessageConst.Notification.URL, "app", "cosa", "rp"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f15482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private o f15483b;

    public u(Context context, o oVar) {
        this.f15482a = context;
        this.f15483b = oVar;
    }

    public static boolean a(String str) {
        for (String str2 : f15481c) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private void b() {
        HMSLog.i("PushSelfShowLog", "run into launchCosaApp");
        try {
            HMSLog.i("PushSelfShowLog", "enter launchExistApp cosa, appPackageName =" + this.f15483b.c() + ",and msg.intentUri is " + this.f15483b.m());
            Intent intentB = e.b(this.f15482a, this.f15483b.c());
            boolean zBooleanValue = false;
            if (this.f15483b.m() != null) {
                try {
                    Intent uri = Intent.parseUri(this.f15483b.m(), 0);
                    uri.setSelector(null);
                    if (uri.getClipData() == null) {
                        uri.setClipData(ClipData.newPlainText("avoid intent add read permission flags", "avoid"));
                    }
                    HMSLog.i("PushSelfShowLog", "Intent.parseUri(msg.intentUri, 0), action:" + uri.getAction());
                    zBooleanValue = e.a(this.f15482a, this.f15483b.c(), uri).booleanValue();
                    if (zBooleanValue) {
                        intentB = uri;
                    }
                } catch (Exception e9) {
                    HMSLog.w("PushSelfShowLog", "intentUri error." + e9.toString());
                }
            } else if (this.f15483b.a() != null) {
                Intent intent = new Intent(this.f15483b.a());
                if (e.a(this.f15482a, this.f15483b.c(), intent).booleanValue()) {
                    intentB = intent;
                }
            }
            if (intentB == null) {
                HMSLog.i("PushSelfShowLog", "launchCosaApp,intent == null");
                return;
            }
            intentB.setPackage(this.f15483b.c());
            if (zBooleanValue) {
                intentB.addFlags(268435456);
            } else {
                intentB.setFlags(805437440);
            }
            this.f15482a.startActivity(intentB);
        } catch (Exception e10) {
            HMSLog.e("PushSelfShowLog", "launch Cosa App exception." + e10.toString());
        }
    }

    public void c() {
        o oVar;
        HMSLog.d("PushSelfShowLog", "enter launchNotify()");
        if (this.f15482a == null || (oVar = this.f15483b) == null) {
            HMSLog.d("PushSelfShowLog", "launchNotify  context or msg is null");
            return;
        }
        if ("app".equals(oVar.h())) {
            a();
            return;
        }
        if ("cosa".equals(this.f15483b.h())) {
            b();
            return;
        }
        if ("rp".equals(this.f15483b.h())) {
            HMSLog.w("PushSelfShowLog", this.f15483b.h() + " not support rich message.");
            return;
        }
        if (RemoteMessageConst.Notification.URL.equals(this.f15483b.h())) {
            HMSLog.w("PushSelfShowLog", this.f15483b.h() + " not support URL.");
            return;
        }
        HMSLog.d("PushSelfShowLog", this.f15483b.h() + " is not exist in hShowType");
    }

    private void a() {
        try {
            HMSLog.i("PushSelfShowLog", "enter launchApp, appPackageName =" + this.f15483b.c());
            if (e.c(this.f15482a, this.f15483b.c())) {
                b();
            }
        } catch (Exception e9) {
            HMSLog.e("PushSelfShowLog", "launchApp error:" + e9.toString());
        }
    }
}
