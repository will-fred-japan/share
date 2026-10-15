package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes2.dex */
public class cm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f17145a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static SimpleDateFormat f187a;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f187a = simpleDateFormat;
        f17145a = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static hy a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        hy hyVar = new hy();
        hyVar.d("category_push_stat");
        hyVar.a("push_sdk_stat_channel");
        hyVar.a(1L);
        hyVar.b(str);
        hyVar.a(true);
        hyVar.b(System.currentTimeMillis());
        hyVar.g(ca.a(context).m155a());
        hyVar.e("com.xiaomi.xmsf");
        hyVar.f("");
        hyVar.c("push_stat");
        return hyVar;
    }
}
