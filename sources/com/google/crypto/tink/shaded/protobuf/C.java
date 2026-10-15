package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: compiled from: LazyFieldLite.java */
/* JADX INFO: loaded from: classes.dex */
public class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Q f14000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile AbstractC0569h f14001b;

    public final Q a(Q q8) {
        if (this.f14000a == null) {
            synchronized (this) {
                if (this.f14000a == null) {
                    try {
                        this.f14000a = q8;
                        this.f14001b = AbstractC0569h.f14069b;
                    } catch (C0586z unused) {
                        this.f14000a = q8;
                        this.f14001b = AbstractC0569h.f14069b;
                    }
                }
            }
        }
        return this.f14000a;
    }

    public final AbstractC0569h b() {
        if (this.f14001b != null) {
            return this.f14001b;
        }
        synchronized (this) {
            try {
                if (this.f14001b != null) {
                    return this.f14001b;
                }
                if (this.f14000a == null) {
                    this.f14001b = AbstractC0569h.f14069b;
                } else {
                    this.f14001b = this.f14000a.c();
                }
                return this.f14001b;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C)) {
            return false;
        }
        C c5 = (C) obj;
        Q q8 = this.f14000a;
        Q q9 = c5.f14000a;
        if (q8 == null && q9 == null) {
            return b().equals(c5.b());
        }
        if (q8 == null || q9 == null) {
            return q8 != null ? q8.equals(c5.a(q8.e())) : a(q9.e()).equals(q9);
        }
        return q8.equals(q9);
    }

    public int hashCode() {
        return 1;
    }
}
