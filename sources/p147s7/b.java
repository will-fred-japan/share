package p147s7;

import java.util.List;

/* JADX INFO: compiled from: Messages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f21305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f21306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f21307c;

    public b(c cVar, a aVar, List<String> list) {
        this.f21305a = cVar;
        this.f21306b = aVar;
        this.f21307c = list;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(b.class)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        b bVar = (b) obj;
        return v.a(this.f21305a, bVar.f21305a) && v.a(this.f21306b, bVar.f21306b) && v.a(this.f21307c, bVar.f21307c);
    }

    public final int hashCode() {
        return v.b(this.f21307c) + ((v.b(this.f21306b) + ((v.b(this.f21305a) + (b.class.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "CacheRetrievalResult(type=" + this.f21305a + ", error=" + this.f21306b + ", paths=" + this.f21307c + ")";
    }
}
