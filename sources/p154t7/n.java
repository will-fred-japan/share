package p154t7;

import java.util.List;
import y7.h;

/* JADX INFO: compiled from: MessagesAsync.g.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f21500b;

    public n(String str, boolean z8) {
        this.f21499a = str;
        this.f21500b = z8;
    }

    public final List<Object> a() {
        return h.C(this.f21499a, Boolean.valueOf(this.f21500b));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return g.a(a(), ((n) obj).a());
    }

    public final int hashCode() {
        return a().hashCode();
    }

    public final String toString() {
        return "SharedPreferencesPigeonOptions(fileName=" + this.f21499a + ", useDataStore=" + this.f21500b + ")";
    }
}
