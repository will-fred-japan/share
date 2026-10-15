package com.vivo.push.restructure;

import android.content.Context;
import com.vivo.push.aa;
import com.vivo.push.i;
import com.vivo.push.l;
import com.vivo.push.restructure.a.a.d;
import com.vivo.push.restructure.b.b;
import com.vivo.push.restructure.b.f;
import com.vivo.push.util.ac;

/* JADX INFO: compiled from: PushClientController.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f16723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.vivo.push.restructure.c.a f16724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d f16725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.vivo.push.restructure.b.a f16726d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f16727e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.vivo.push.c.a f16728f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private l f16729g;

    /* JADX INFO: renamed from: com.vivo.push.restructure.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PushClientController.java */
    public static class C0182a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static a f16730a = new a(0);
    }

    public /* synthetic */ a(byte b9) {
        this();
    }

    public static a a() {
        return C0182a.f16730a;
    }

    public final synchronized Context b() {
        return this.f16723a;
    }

    public final com.vivo.push.restructure.c.a c() {
        return this.f16724b;
    }

    public final d d() {
        return this.f16725c;
    }

    public final synchronized com.vivo.push.restructure.b.a e() {
        return this.f16726d;
    }

    public final b f() {
        return this.f16727e;
    }

    public final com.vivo.push.c.a g() {
        return this.f16728f;
    }

    public final l h() {
        return this.f16729g;
    }

    private a() {
    }

    public final synchronized void a(Context context) {
        if (context == null) {
            return;
        }
        if (this.f16723a == null) {
            this.f16723a = context;
            com.vivo.push.restructure.b.d dVar = new com.vivo.push.restructure.b.d(new ac(context));
            this.f16726d = dVar;
            this.f16724b = new com.vivo.push.restructure.c.b(dVar);
            this.f16725c = new d();
            this.f16727e = new f();
            com.vivo.push.c.a aVar = new com.vivo.push.c.a(context);
            this.f16728f = aVar;
            this.f16729g = new aa(aVar, e());
            i.a().a(this.f16728f);
        }
    }
}
