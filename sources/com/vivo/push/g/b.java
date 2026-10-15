package com.vivo.push.g;

import android.content.Context;
import com.vivo.push.util.ContextDelegate;

/* JADX INFO: compiled from: PushSecurityManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile b f16605c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f16606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f16607b;

    private b() {
    }

    public static synchronized b a() {
        try {
            if (f16605c == null) {
                f16605c = new b();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f16605c;
    }

    public final synchronized a a(Context context) {
        try {
            a aVar = this.f16606a;
            if (aVar != null) {
                return aVar;
            }
            if (context == null) {
                return null;
            }
            if (aVar == null) {
                Context context2 = ContextDelegate.getContext(context.getApplicationContext());
                this.f16607b = context2;
                this.f16606a = new c(context2);
            }
            return this.f16606a;
        } catch (Throwable th) {
            throw th;
        }
    }
}
