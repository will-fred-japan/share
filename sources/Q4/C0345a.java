package Q4;

import P4.a.c;
import S4.C0375f;
import java.util.Arrays;

/* JADX INFO: renamed from: Q4.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0345a<O extends P4.a.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final P4.a f3798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final P4.a.c f3799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3800d;

    public C0345a(P4.a aVar, P4.a.c cVar, String str) {
        this.f3798b = aVar;
        this.f3799c = cVar;
        this.f3800d = str;
        this.f3797a = Arrays.hashCode(new Object[]{aVar, cVar, str});
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0345a)) {
            return false;
        }
        C0345a c0345a = (C0345a) obj;
        return C0375f.a(this.f3798b, c0345a.f3798b) && C0375f.a(this.f3799c, c0345a.f3799c) && C0375f.a(this.f3800d, c0345a.f3800d);
    }

    public final int hashCode() {
        return this.f3797a;
    }
}
