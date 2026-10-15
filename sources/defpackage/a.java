package defpackage;

import p056h5.C0598e;

/* JADX INFO: compiled from: WakelockPlusMessages.g.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f5669a;

    public a() {
        this(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return g.b(C0598e.y(this.f5669a), C0598e.y(((a) obj).f5669a));
    }

    public final int hashCode() {
        return C0598e.y(this.f5669a).hashCode();
    }

    public final String toString() {
        return "IsEnabledMessage(enabled=" + this.f5669a + ")";
    }

    public a(Boolean bool) {
        this.f5669a = bool;
    }
}
