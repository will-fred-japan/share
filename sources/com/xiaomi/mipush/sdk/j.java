package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.hu;
import com.xiaomi.push.ie;
import com.xiaomi.push.iq;
import com.xiaomi.push.it;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile j f16981a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Context f62a;

    private j(Context context) {
        this.f62a = context.getApplicationContext();
    }

    private static j a(Context context) {
        if (f16981a == null) {
            synchronized (j.class) {
                try {
                    if (f16981a == null) {
                        f16981a = new j(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f16981a;
    }

    public static void b(Context context, iq iqVar, Intent intent, boolean z8) {
        a(context).a(iqVar, intent, 2, z8);
    }

    public static void c(Context context, iq iqVar, Intent intent, boolean z8) {
        a(context).a(iqVar, intent, 3, z8);
    }

    public static void d(Context context, iq iqVar, Intent intent, boolean z8) {
        a(context).a(iqVar, intent, 4, z8);
    }

    public static void e(Context context, iq iqVar, Intent intent, boolean z8) {
        a(context).a(iqVar, intent, 8, z8);
    }

    public static void f(Context context, iq iqVar, Intent intent, boolean z8) {
        b bVarM35a = b.m35a(context);
        if (TextUtils.isEmpty(bVarM35a.m43c()) || TextUtils.isEmpty(bVarM35a.d())) {
            a(context).a(iqVar, intent, 6, z8);
        } else if (bVarM35a.m47f()) {
            a(context).a(iqVar, intent, 7, z8);
        } else {
            a(context).a(iqVar, intent, 5, z8);
        }
    }

    public static void a(Context context, iq iqVar, Intent intent, boolean z8) {
        a(context).a(iqVar, intent, 1, z8);
    }

    public static void a(Context context, String str, Intent intent, int i9, boolean z8, Throwable th) {
        a(context).a(str, intent, i9, z8, th, System.currentTimeMillis());
    }

    public static void a(Context context, Intent intent, int i9, Throwable th) {
        if (intent == null) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("mipush_notified", false);
        a(context).a(intent.getStringExtra("messageId"), intent, i9, booleanExtra, th, System.currentTimeMillis());
    }

    public static void a(Context context, iq iqVar, Intent intent, long j) {
        a(context).a(iqVar, intent, 0, true, j);
    }

    private void a(iq iqVar, Intent intent, int i9, boolean z8) {
        a(iqVar, intent, i9, z8, System.currentTimeMillis());
    }

    private void a(iq iqVar, Intent intent, int i9, boolean z8, long j) {
        if (com.xiaomi.push.k.m649a(this.f62a) || !com.xiaomi.push.k.m648a() || iqVar == null || iqVar.f731a != hu.SendMessage || iqVar.m552a() == null || !z8) {
            return;
        }
        a(iqVar.m552a().m518a(), iqVar.f738b, iqVar.m553a(), intent, i9, null, j);
    }

    private void a(String str, Intent intent, int i9, boolean z8, Throwable th, long j) {
        if (this.f62a == null || TextUtils.isEmpty(str) || com.xiaomi.push.k.m649a(this.f62a) || !com.xiaomi.push.k.m648a() || !z8) {
            return;
        }
        a(str, this.f62a.getPackageName(), b.m35a(this.f62a).m36a(), intent, i9, th, j);
    }

    private void a(String str, String str2, String str3, Intent intent, int i9, Throwable th, long j) {
        try {
            com.xiaomi.channel.commonutils.logger.c.m9a("click to start activity result:" + i9);
            it itVar = new it(str, false);
            itVar.c(ie.SDK_START_ACTIVITY.f611a);
            itVar.b(str3);
            itVar.d(str2);
            HashMap map = new HashMap();
            itVar.f750a = map;
            map.put("result", String.valueOf(i9));
            itVar.f750a.put(CrashHianalyticsData.TIME, String.valueOf(j));
            itVar.f750a.put("sdk_vc", String.valueOf(BuildConfig.VERSION_CODE));
            if (th != null) {
                itVar.f750a.put("sdk_pull_exception", String.valueOf(th));
            }
            if (intent != null) {
                long longExtra = intent.getLongExtra("nca_create_time", 0L);
                if (longExtra > 0) {
                    itVar.f750a.put("nca_create_time", String.valueOf(longExtra));
                }
                long longExtra2 = intent.getLongExtra("nca_resume_time", 0L);
                if (longExtra2 > 0) {
                    itVar.f750a.put("nca_resume_time", String.valueOf(longExtra2));
                }
                long longExtra3 = intent.getLongExtra("pmh_handle_time", 0L);
                if (longExtra3 > 0) {
                    itVar.f750a.put("pmh_handle_time", String.valueOf(longExtra3));
                }
            }
            try {
                u.a(this.f62a).a(itVar, hu.Notification, false, false, null, true, str2, str3, true, false);
            } catch (Throwable th2) {
                th = th2;
                com.xiaomi.channel.commonutils.logger.c.d("exception occurred in report pull result, exception: " + th);
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
