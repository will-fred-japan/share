package P6;

import A0.h;
import java.io.Serializable;
import java.util.HashMap;
import p096m7.j;
import p096m7.l;

/* JADX INFO: compiled from: MethodCallOperation.java */
/* JADX INFO: loaded from: classes.dex */
public final class b extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f3639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f3640c;

    /* JADX INFO: compiled from: MethodCallOperation.java */
    public static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l.d f3641a;

        public a(l.d dVar) {
            this.f3641a = dVar;
        }

        @Override // P6.c
        public final void a(Serializable serializable) {
            this.f3641a.success(serializable);
        }

        @Override // P6.c
        public final void c(String str, HashMap map) {
            this.f3641a.error("sqlite_error", str, map);
        }
    }

    public b(j jVar, l.d dVar) {
        super(5);
        this.f3640c = jVar;
        this.f3639b = new a(dVar);
    }

    @Override // A0.h
    public final <T> T f(String str) {
        return (T) this.f3640c.a(str);
    }

    @Override // A0.h
    public final String h() {
        return this.f3640c.f20496a;
    }

    @Override // A0.h
    public final c l() {
        return this.f3639b;
    }

    @Override // A0.h
    public final boolean p() {
        return this.f3640c.c("transactionId");
    }
}
