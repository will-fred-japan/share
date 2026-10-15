package P;

import android.os.LocaleList;

/* JADX INFO: compiled from: LocaleListPlatformWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public final class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocaleList f3602a;

    public f(LocaleList localeList) {
        this.f3602a = localeList;
    }

    @Override // P.e
    public final Object a() {
        return this.f3602a;
    }

    public final boolean equals(Object obj) {
        return this.f3602a.equals(((e) obj).a());
    }

    public final int hashCode() {
        return this.f3602a.hashCode();
    }

    public final String toString() {
        return this.f3602a.toString();
    }
}
