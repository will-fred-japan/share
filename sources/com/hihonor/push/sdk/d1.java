package com.hihonor.push.sdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class d1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f14475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f14476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Exception f14477d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f14474a = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<r0<Object>> f14478e = new ArrayList();

    public final d1 a(r0 r0Var) {
        synchronized (this.f14474a) {
            try {
                if (this.f14475b) {
                    r0Var.a(this);
                } else {
                    this.f14478e.add(r0Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this;
    }

    public final Object b() {
        Object obj;
        synchronized (this.f14474a) {
            try {
                if (this.f14477d != null) {
                    throw new RuntimeException(this.f14477d);
                }
                obj = this.f14476c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0016  */
    public final boolean c() {
        boolean z8;
        synchronized (this.f14474a) {
            if (this.f14475b) {
                synchronized (this.f14474a) {
                }
                if (this.f14477d == null) {
                    z8 = true;
                } else {
                    z8 = false;
                }
            } else {
                z8 = false;
            }
        }
        return z8;
    }

    public final void a() {
        synchronized (this.f14474a) {
            Iterator<r0<Object>> it = this.f14478e.iterator();
            while (it.hasNext()) {
                try {
                    it.next().a(this);
                } catch (RuntimeException e9) {
                    throw e9;
                } catch (Exception e10) {
                    throw new RuntimeException(e10);
                }
            }
            this.f14478e = null;
        }
    }
}
