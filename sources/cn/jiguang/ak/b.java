package cn.jiguang.ak;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f9205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f9206b = new Object();

    public static void a() {
        synchronized (f9206b) {
            try {
                a aVar = f9205a;
                if (aVar != null) {
                    aVar.interrupt();
                    f9205a = null;
                    cn.jiguang.x.f.c("AnrHelper", "AnrHelper removed.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(cn.jiguang.al.a aVar) {
        cn.jiguang.al.c cVar = new cn.jiguang.al.c();
        cVar.a("ANR");
        h.a().a(new c(cVar, aVar, aVar.a(), true));
    }

    public static void a(Context context) {
        synchronized (f9206b) {
            try {
                a aVar = f9205a;
                if (aVar == null || !aVar.isAlive()) {
                    f9205a = null;
                    a aVar2 = new a(10000L, false, new a.InterfaceC0122a() { // from class: cn.jiguang.ak.b.1
                        @Override // cn.jiguang.ak.a.InterfaceC0122a
                        public void a(cn.jiguang.al.a aVar3) {
                            b.b(aVar3);
                        }
                    }, context);
                    f9205a = aVar2;
                    aVar2.start();
                } else {
                    cn.jiguang.x.f.c("AnrHelper", "AnrHelper already started.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
