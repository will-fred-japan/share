package p154t7;

import y7.h;

/* JADX INFO: compiled from: MessagesAsync.g.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f21627b;

    public w(String str, u uVar) {
        this.f21626a = str;
        this.f21627b = uVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof w)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        w wVar = (w) obj;
        return g.a(h.C(this.f21626a, this.f21627b), h.C(wVar.f21626a, wVar.f21627b));
    }

    public final int hashCode() {
        return h.C(this.f21626a, this.f21627b).hashCode();
    }

    public final String toString() {
        return "StringListResult(jsonEncodedValue=" + this.f21626a + ", type=" + this.f21627b + ")";
    }
}
