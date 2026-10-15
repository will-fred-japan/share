package p092m3;

import java.util.Arrays;

/* JADX INFO: compiled from: Field.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f20328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f20329c;

    public a(int i9, c cVar, Object obj) {
        this.f20327a = i9;
        this.f20328b = cVar;
        this.f20329c = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f20327a != aVar.f20327a || !this.f20328b.equals(aVar.f20328b)) {
            return false;
        }
        Object obj2 = this.f20329c;
        Object obj3 = aVar.f20329c;
        return (obj2 == null || obj2.equals(obj3)) && (obj3 == null || obj3.equals(obj2));
    }

    public final int hashCode() {
        return (Arrays.hashCode(this.f20328b.f20335a) << 31) + this.f20327a;
    }
}
