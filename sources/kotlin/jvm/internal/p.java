package kotlin.jvm.internal;

/* JADX INFO: compiled from: PackageReference.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class p implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f20004a;

    public p(Class jClass) {
        k.e(jClass, "jClass");
        this.f20004a = jClass;
    }

    @Override // kotlin.jvm.internal.c
    public final Class<?> b() {
        return this.f20004a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof p) {
            return k.a(this.f20004a, ((p) obj).f20004a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f20004a.hashCode();
    }

    public final String toString() {
        return this.f20004a + " (Kotlin reflection is not available)";
    }
}
