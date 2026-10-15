package cn.jiguang.aw;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Handler f9529b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f9528a = new AtomicInteger(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<String, b> f9530c = new ConcurrentHashMap<>(32);

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final m f9534a = new m();
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Runnable f9535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f9536b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final AtomicBoolean f9537c = new AtomicBoolean(false);

        public b(Runnable runnable, String str) {
            this.f9535a = runnable;
            this.f9536b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!this.f9537c.get()) {
                    cn.jiguang.av.d.a("FUTURE_TASK", new Runnable() { // from class: cn.jiguang.aw.m.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.f9535a.run();
                        }
                    });
                }
            } finally {
                m.f9530c.remove(this.f9536b, this);
            }
        }

        public void a() {
            this.f9537c.set(true);
        }
    }

    private m() {
        f9529b = new Handler(Looper.getMainLooper());
    }

    public static m a() {
        return a.f9534a;
    }

    public void a(final String str, final Runnable runnable, long j) {
        if (runnable == null || str == null) {
            return;
        }
        f9529b.postDelayed(f9530c.compute(str, new BiFunction<String, b, b>() { // from class: cn.jiguang.aw.m.1
            @Override // java.util.function.BiFunction
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public b apply(String str2, b bVar) {
                if (bVar != null) {
                    m.f9529b.removeCallbacks(bVar);
                }
                return new b(runnable, str);
            }
        }), j);
    }

    public boolean b(String str) {
        return f9530c.containsKey(str);
    }

    public boolean a(String str) {
        b bVarRemove = f9530c.remove(str);
        if (bVarRemove == null) {
            return false;
        }
        bVarRemove.a();
        f9529b.removeCallbacks(bVarRemove);
        return true;
    }
}
