package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: LazyFieldLite.java */
/* JADX INFO: loaded from: classes.dex */
public class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Q f7161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile AbstractC0513g f7162b;

    public final Q a(Q q8) {
        if (this.f7161a == null) {
            synchronized (this) {
                if (this.f7161a == null) {
                    try {
                        this.f7161a = q8;
                        this.f7162b = AbstractC0513g.f7223b;
                    } catch (C0531z unused) {
                        this.f7161a = q8;
                        this.f7162b = AbstractC0513g.f7223b;
                    }
                }
            }
        }
        return this.f7161a;
    }

    public final AbstractC0513g b() {
        if (this.f7162b != null) {
            return this.f7162b;
        }
        synchronized (this) {
            try {
                if (this.f7162b != null) {
                    return this.f7162b;
                }
                if (this.f7161a == null) {
                    this.f7162b = AbstractC0513g.f7223b;
                } else {
                    this.f7162b = this.f7161a.c();
                }
                return this.f7162b;
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
        Q q8 = this.f7161a;
        Q q9 = c5.f7161a;
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
