package p187x6;

import android.os.Handler;
import android.os.Looper;
import p096m7.d;

/* JADX INFO: compiled from: RecorderRecordStreamHandler.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a implements d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d.b.a f22348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f22349b = new Handler(Looper.getMainLooper());

    @Override // m7.d.c
    public final void a(Object obj, d.b.a aVar) {
        this.f22348a = aVar;
    }

    @Override // m7.d.c
    public final void b() {
        this.f22348a = null;
    }
}
