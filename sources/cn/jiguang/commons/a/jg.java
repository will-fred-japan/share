package cn.jiguang.commons.a;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class jg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Context f10257a;

    private jg() {
    }

    public static Context a() {
        return f10257a;
    }

    public static Context a(Context context) {
        if (f10257a == null && context != null && f10257a == null) {
            synchronized (jg.class) {
                try {
                    if (f10257a == null) {
                        f10257a = context.getApplicationContext();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f10257a;
    }
}
