package N7;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: PlatformThreadLocalRandom.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends M7.a {
    @Override // M7.a
    public final Random a() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        k.d(threadLocalRandomCurrent, "current(...)");
        return threadLocalRandomCurrent;
    }
}
