package N6;

import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: N6.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BleCallbackGeneration.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0334e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f3318a = new AtomicLong();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicLong f3319b = new AtomicLong();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, AtomicLong> f3320c = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: N6.e$a */
    /* JADX INFO: compiled from: BleCallbackGeneration.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3321a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C0332c f3322b;

        public a(String str, C0332c c0332c) {
            this.f3321a = str;
            this.f3322b = c0332c;
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x002f  */
    public final a a(String str, String str2) {
        AtomicLong atomicLongComputeIfAbsent;
        long j = this.f3318a.get();
        if (str != null) {
            ConcurrentHashMap<String, AtomicLong> concurrentHashMap = this.f3320c;
            String upperCase = str.toUpperCase(Locale.ROOT);
            kotlin.jvm.internal.k.d(upperCase, "toUpperCase(...)");
            atomicLongComputeIfAbsent = concurrentHashMap.computeIfAbsent(upperCase, new C0331b(new C0330a(0), 0));
            if (atomicLongComputeIfAbsent == null) {
                atomicLongComputeIfAbsent = this.f3319b;
            }
        } else {
            atomicLongComputeIfAbsent = this.f3319b;
        }
        AtomicLong atomicLong = atomicLongComputeIfAbsent;
        return new a(str2, new C0332c(this, j, atomicLong, atomicLong.get()));
    }

    public final void b(String str) {
        if (str == null) {
            this.f3318a.incrementAndGet();
            return;
        }
        ConcurrentHashMap<String, AtomicLong> concurrentHashMap = this.f3320c;
        String upperCase = str.toUpperCase(Locale.ROOT);
        kotlin.jvm.internal.k.d(upperCase, "toUpperCase(...)");
        concurrentHashMap.computeIfAbsent(upperCase, new C0331b(new C0330a(1), 1)).incrementAndGet();
        this.f3319b.incrementAndGet();
    }
}
