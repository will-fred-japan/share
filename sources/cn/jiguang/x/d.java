package cn.jiguang.x;

import android.content.Context;
import cn.jiguang.e.g;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static synchronized void a(Context context) {
        g.a(context, 1);
        f.c("LogRefManager", "Log reference count increased to: 1");
    }

    public static synchronized void b(Context context) {
        int iC = g.c(context);
        if (iC > 0) {
            int i9 = iC - 1;
            g.a(context, i9);
            f.c("LogRefManager", "Log reference count decreased to: " + i9);
        }
    }

    public static synchronized boolean c(Context context) {
        boolean z8;
        z8 = g.c(context) == 0;
        f.c("LogRefManager", "Can clear log: " + z8);
        return z8;
    }
}
