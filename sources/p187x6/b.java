package p187x6;

import A6.a;
import android.os.Handler;
import android.os.Looper;
import p096m7.d;
import q6.f;

/* JADX INFO: compiled from: RecorderStateStreamHandler.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b implements d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d.b.a f22350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f22351b = f.STOP;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f22352c = new Handler(Looper.getMainLooper());

    @Override // m7.d.c
    public final void a(Object obj, d.b.a aVar) {
        this.f22350a = aVar;
    }

    @Override // m7.d.c
    public final void b() {
        this.f22350a = null;
    }

    public final void c(f fVar) {
        if (this.f22351b != fVar) {
            this.f22351b = fVar;
            this.f22352c.post(new a(12, this, fVar));
        }
    }
}
