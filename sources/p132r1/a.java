package p132r1;

import java.util.LinkedList;

/* JADX INFO: compiled from: ActionRecord.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f21103b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p125q2.a f21104a;

    public a() {
        p125q2.a aVar = new p125q2.a();
        aVar.f20907b = new LinkedList();
        aVar.f20906a = 20;
        this.f21104a = aVar;
    }

    public static a a() {
        if (f21103b == null) {
            synchronized (a.class) {
                try {
                    if (f21103b == null) {
                        f21103b = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f21103b;
    }
}
