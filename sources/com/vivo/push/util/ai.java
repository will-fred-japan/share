package com.vivo.push.util;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: compiled from: SystemCache.java */
/* JADX INFO: loaded from: classes.dex */
public final class ai implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashMap<String, Integer> f16834a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashMap<String, Long> f16835b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final HashMap<String, String> f16836c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ai f16837d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f16838e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private e f16839f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f16840g;

    private ai(Context context) {
        this.f16840g = false;
        this.f16838e = context;
        this.f16840g = a(context);
        w.d("SystemCache", "init status is " + this.f16840g + ";  curCache is " + this.f16839f);
    }

    public static synchronized ai b(Context context) {
        try {
            if (f16837d == null) {
                f16837d = new ai(context.getApplicationContext());
            }
        } catch (Throwable th) {
            throw th;
        }
        return f16837d;
    }

    public final void a() {
        ah ahVar = new ah();
        if (ahVar.a(this.f16838e)) {
            ahVar.a();
            w.d("SystemCache", "sp cache is cleared");
        }
    }

    @Override // com.vivo.push.util.e
    public final boolean a(Context context) {
        af afVar = new af();
        this.f16839f = afVar;
        boolean zA = afVar.a(context);
        if (!zA) {
            ah ahVar = new ah();
            this.f16839f = ahVar;
            zA = ahVar.a(context);
        }
        if (!zA) {
            this.f16839f = null;
        }
        return zA;
    }

    @Override // com.vivo.push.util.e
    public final String a(String str, String str2) {
        e eVar;
        String str3 = f16836c.get(str);
        return (str3 != null || (eVar = this.f16839f) == null) ? str3 : eVar.a(str, str2);
    }
}
