package p088l7;

import android.util.Log;
import p096m7.l;

/* JADX INFO: compiled from: RestorationChannel.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p implements l.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ byte[] f20189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f20190b;

    public p(q qVar, byte[] bArr) {
        this.f20190b = qVar;
        this.f20189a = bArr;
    }

    @Override // m7.l.d
    public final void error(String str, String str2, Object obj) {
        Log.e("RestorationChannel", "Error " + str + " while sending restoration data to framework: " + str2);
    }

    @Override // m7.l.d
    public final void success(Object obj) {
        this.f20190b.f20192b = this.f20189a;
    }

    @Override // m7.l.d
    public final void notImplemented() {
    }
}
