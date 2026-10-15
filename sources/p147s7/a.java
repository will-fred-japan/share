package p147s7;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: Messages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21304b;

    public a(String code, String str) {
        k.e(code, "code");
        this.f21303a = code;
        this.f21304b = str;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(a.class)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        a aVar = (a) obj;
        return v.a(this.f21303a, aVar.f21303a) && v.a(this.f21304b, aVar.f21304b);
    }

    public final int hashCode() {
        return v.b(this.f21304b) + ((v.b(this.f21303a) + (a.class.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "CacheRetrievalError(code=" + this.f21303a + ", message=" + this.f21304b + ")";
    }
}
