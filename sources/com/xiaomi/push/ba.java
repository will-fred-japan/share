package com.xiaomi.push;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class ba {

    /* JADX INFO: renamed from: com.xiaomi.push.ba$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f17072a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        final /* synthetic */ String f138a;

        @Override // java.lang.Runnable
        public void run() {
            ba.a(this.f138a, this.f17072a);
        }
    }

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final bg f17073a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private final Runnable f139a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private final String f140a;

        public /* synthetic */ a(bg bgVar, String str, Runnable runnable, AnonymousClass1 anonymousClass1) {
            this(bgVar, str, runnable);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f17073a.a(this.f140a);
            this.f139a.run();
            this.f17073a.mo120a();
        }

        private a(bg bgVar, String str, Runnable runnable) {
            this.f17073a = bgVar;
            this.f140a = str;
            this.f139a = runnable;
        }
    }

    public static void a(String str, Runnable runnable) {
        bd bdVarA = bd.a();
        bdVarA.execute(new a(bdVarA, str, runnable, null));
    }

    public static void b(String str, Runnable runnable) {
        be beVarA = be.a();
        beVarA.execute(new a(beVarA, str, runnable, null));
    }

    public static void a(String str, Runnable runnable, boolean z8) {
        if (z8) {
            a(str, runnable);
        } else {
            b(str, runnable);
        }
    }

    public static ScheduledFuture a(String str, Runnable runnable, long j, TimeUnit timeUnit) {
        bf bfVarA = bf.a();
        return bfVarA.schedule(new a(bfVarA, str, runnable, null), j, timeUnit);
    }
}
