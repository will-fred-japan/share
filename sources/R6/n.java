package R6;

import java.util.List;

/* JADX INFO: compiled from: GeneratedFileSelectorApi.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f4064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f4065b;

    public n(List<String> list, List<String> list2) {
        this.f4064a = list;
        this.f4065b = list2;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(n.class)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        n nVar = (n) obj;
        return r.a(this.f4064a, nVar.f4064a) && r.a(this.f4065b, nVar.f4065b);
    }

    public final int hashCode() {
        return r.b(this.f4065b) + ((r.b(this.f4064a) + (n.class.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "FileTypes(mimeTypes=" + this.f4064a + ", extensions=" + this.f4065b + ")";
    }
}
