package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static z0 f15142a;

    private static synchronized z0 a() {
        try {
            if (f15142a == null) {
                f15142a = q.c().b();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f15142a;
    }

    public static void b(int i9, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a() == null || !q1.b().a()) {
            return;
        }
        if (i9 == 1 || i9 == 0) {
            f15142a.b(i9, str, linkedHashMap);
            return;
        }
        v.d("hmsSdk", "Data type no longer collects range.type: " + i9);
    }

    public static void c() {
        if (a() == null || !q1.b().a()) {
            return;
        }
        f15142a.a(-1);
    }

    public static void a(int i9, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a() == null || !q1.b().a()) {
            return;
        }
        if (i9 == 1 || i9 == 0) {
            f15142a.a(i9, str, linkedHashMap);
            return;
        }
        v.d("hmsSdk", "Data type no longer collects range.type: " + i9);
    }

    public static boolean b() {
        return q.c().a();
    }

    @Deprecated
    public static void a(Context context, String str, String str2) {
        if (a() != null) {
            f15142a.a(context, str, str2);
        }
    }
}
