package M7;

import java.util.Random;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: PlatformRandom.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends M7.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f3102c = new a();

    /* JADX INFO: compiled from: PlatformRandom.kt */
    public static final class a extends ThreadLocal<Random> {
        @Override // java.lang.ThreadLocal
        public final Random initialValue() {
            return new Random();
        }
    }

    @Override // M7.a
    public final Random a() {
        Random random = this.f3102c.get();
        k.d(random, "get(...)");
        return random;
    }
}
