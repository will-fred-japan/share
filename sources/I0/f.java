package I0;

import G0.h;
import G0.j;
import android.content.Context;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: MulticastConsumer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f implements S.a<WindowLayoutInfo>, Consumer<WindowLayoutInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2543a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f2545c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f2544b = new ReentrantLock();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashSet f2546d = new LinkedHashSet();

    public f(Context context) {
        this.f2543a = context;
    }

    @Override // S.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(WindowLayoutInfo value) {
        k.e(value, "value");
        ReentrantLock reentrantLock = this.f2544b;
        reentrantLock.lock();
        try {
            this.f2545c = e.c(this.f2543a, value);
            Iterator it = this.f2546d.iterator();
            while (it.hasNext()) {
                ((S.a) it.next()).accept(this.f2545c);
            }
            p188x7.k kVar = p188x7.k.f22364a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void b(h hVar) {
        ReentrantLock reentrantLock = this.f2544b;
        reentrantLock.lock();
        try {
            j jVar = this.f2545c;
            if (jVar != null) {
                hVar.accept(jVar);
            }
            this.f2546d.add(hVar);
        } finally {
            reentrantLock.unlock();
        }
    }
}
