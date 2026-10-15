package p162u7;

import java.util.Map;

/* JADX INFO: compiled from: Messages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f21765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f21766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f21767c;

    public j(boolean z8, boolean z9, Map<String, String> map) {
        this.f21765a = z8;
        this.f21766b = z9;
        this.f21767c = map;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(j.class)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        j jVar = (j) obj;
        return d.a(Boolean.valueOf(this.f21765a), Boolean.valueOf(jVar.f21765a)) && d.a(Boolean.valueOf(this.f21766b), Boolean.valueOf(jVar.f21766b)) && d.a(this.f21767c, jVar.f21767c);
    }

    public final int hashCode() {
        return d.b(this.f21767c) + ((d.b(Boolean.valueOf(this.f21766b)) + ((d.b(Boolean.valueOf(this.f21765a)) + (j.class.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "WebViewOptions(enableJavaScript=" + this.f21765a + ", enableDomStorage=" + this.f21766b + ", headers=" + this.f21767c + ")";
    }
}
