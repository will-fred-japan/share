package defpackage;

import p056h5.C0598e;

/* JADX INFO: compiled from: WakelockPlusMessages.g.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f8468a;

    public b() {
        this(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return g.b(C0598e.y(this.f8468a), C0598e.y(((b) obj).f8468a));
    }

    public final int hashCode() {
        return C0598e.y(this.f8468a).hashCode();
    }

    public final String toString() {
        return "ToggleMessage(enable=" + this.f8468a + ")";
    }

    public b(Boolean bool) {
        this.f8468a = bool;
    }
}
