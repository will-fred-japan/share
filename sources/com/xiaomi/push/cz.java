package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class cz {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final List<String> f236a = Arrays.asList("001", "002", "003", "004", "005");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Boolean f17186a = null;

    public static void a(String str, String str2) {
    }

    public static boolean a(Context context) {
        if (f17186a == null) {
            try {
                if (!k.m649a(context)) {
                    f17186a = Boolean.FALSE;
                }
                String strM827a = com.xiaomi.push.service.v.m827a(context);
                if (TextUtils.isEmpty(strM827a) || strM827a.length() < 3) {
                    f17186a = Boolean.FALSE;
                } else {
                    f17186a = Boolean.valueOf(f236a.contains(strM827a.substring(strM827a.length() - 3)));
                }
                a("Sampling statistical connection quality: " + f17186a);
            } catch (Throwable th) {
                f17186a = Boolean.FALSE;
                defpackage.f.q("Determine sampling switch error: ", "Push-ConnectionQualityStatsHelper", th);
            }
        }
        return f17186a.booleanValue();
    }

    public static void a(String str) {
        a("Push-ConnectionQualityStatsHelper", str);
    }
}
