package p096m7;

import p013b7.c;

/* JADX INFO: compiled from: MethodChannel.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k implements l.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.e f20498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l.a f20499b;

    public k(l.a aVar, c.e eVar) {
        this.f20499b = aVar;
        this.f20498a = eVar;
    }

    @Override // m7.l.d
    public final void error(String str, String str2, Object obj) {
        this.f20498a.a(l.this.f20502c.c(str, str2, obj));
    }

    @Override // m7.l.d
    public final void notImplemented() {
        this.f20498a.a(null);
    }

    @Override // m7.l.d
    public final void success(Object obj) {
        this.f20498a.a(l.this.f20502c.a(obj));
    }
}
