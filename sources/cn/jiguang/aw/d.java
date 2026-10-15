package cn.jiguang.aw;

import android.content.Context;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReference<Context> f9496a = new AtomicReference<>();

    public static Context a() {
        return a(null);
    }

    public static Context a(Context context) {
        AtomicReference<Context> atomicReference = f9496a;
        Context applicationContext = atomicReference.get();
        if (applicationContext == null) {
            if (context != null) {
                applicationContext = context.getApplicationContext();
            }
            atomicReference.set(applicationContext);
        }
        return applicationContext;
    }
}
