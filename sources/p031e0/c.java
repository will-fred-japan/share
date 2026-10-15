package p031e0;

import A1.b;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: Table.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f18588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteBuffer f18589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f18590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f18591d;

    public c() {
        if (b.f1396D == null) {
            b.f1396D = new b();
        }
    }

    public final int a(int i9) {
        if (i9 < this.f18591d) {
            return this.f18589b.getShort(this.f18590c + i9);
        }
        return 0;
    }
}
