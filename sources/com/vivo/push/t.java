package com.vivo.push;

import android.content.Context;

/* JADX INFO: compiled from: PushClientTask.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f16804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private w f16806c;

    public t(w wVar) {
        this.f16805b = -1;
        this.f16806c = wVar;
        int iB = wVar.b();
        this.f16805b = iB;
        if (iB < 0) {
            throw new IllegalArgumentException("PushTask need a > 0 task id.");
        }
        this.f16804a = n.a().h();
    }

    public final int a() {
        return this.f16805b;
    }

    public abstract void a(w wVar);

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f16804a != null && !(this.f16806c instanceof com.vivo.push.b.o)) {
            com.vivo.push.util.w.a("[执行指令]" + this.f16806c);
        }
        a(this.f16806c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("{");
        w wVar = this.f16806c;
        return A.a.j(sb, wVar == null ? "[null]" : wVar.toString(), "}");
    }
}
