package androidx.emoji2.text;

import N6.G;
import P.g;
import android.content.Context;
import android.os.Trace;
import androidx.lifecycle.AbstractC0544j;
import androidx.lifecycle.InterfaceC0548n;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class EmojiCompatInitializer implements p140s0.b<Boolean> {

    public static class a extends androidx.emoji2.text.c.AbstractC0103c {
    }

    public static class b implements androidx.emoji2.text.c.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f7367a;

        public b(Context context) {
            this.f7367a = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.c.g
        public final void a(androidx.emoji2.text.c.h hVar) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new p022d0.a("EmojiCompatInitializer"));
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            threadPoolExecutor.execute(new G(this, hVar, threadPoolExecutor, 2));
        }
    }

    public static class c implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            try {
                int i9 = g.f3603a;
                Trace.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                if (androidx.emoji2.text.c.f7369k != null) {
                    androidx.emoji2.text.c.a().c();
                }
            } finally {
                int i10 = g.f3603a;
                Trace.endSection();
            }
        }
    }

    @Override // p140s0.b
    public final List<Class<? extends p140s0.b<?>>> a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // p140s0.b
    public final Boolean b(Context context) {
        Object objB;
        a aVar = new a(new b(context));
        aVar.f7383b = 1;
        if (androidx.emoji2.text.c.f7369k == null) {
            synchronized (androidx.emoji2.text.c.j) {
                try {
                    if (androidx.emoji2.text.c.f7369k == null) {
                        androidx.emoji2.text.c.f7369k = new androidx.emoji2.text.c(aVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        p140s0.a aVarC = p140s0.a.c(context);
        aVarC.getClass();
        synchronized (p140s0.a.f21180e) {
            try {
                objB = aVarC.f21181a.get(ProcessLifecycleInitializer.class);
                if (objB == null) {
                    objB = aVarC.b(ProcessLifecycleInitializer.class, new HashSet());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        AbstractC0544j lifecycle = ((InterfaceC0548n) objB).getLifecycle();
        lifecycle.a(new p022d0.d(this, lifecycle));
        return Boolean.TRUE;
    }
}
