package p011b4;

import android.os.SystemClock;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f8574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static l f8575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArrayList<g> f8576c = new CopyOnWriteArrayList<>();

    /* JADX WARN: Code duplicated, block: B:14:0x002e  */
    public static void a(boolean z8, String str) {
        g.f8539b = System.nanoTime() / 1000000;
        SystemClock.currentThreadTimeMillis();
        CopyOnWriteArrayList<g> copyOnWriteArrayList = f8576c;
        for (int i9 = 0; i9 < copyOnWriteArrayList.size(); i9++) {
            g gVar = copyOnWriteArrayList.get(i9);
            if (gVar != null && (gVar instanceof k)) {
                boolean z9 = gVar.f8540a;
                if (z8) {
                    if (!z9) {
                        gVar.a(str);
                    }
                } else if (z9) {
                    gVar.b();
                }
            } else if (!z8 && gVar.f8540a) {
                gVar.b();
            }
        }
    }
}
