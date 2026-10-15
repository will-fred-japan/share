package androidx.fragment.app;

import android.os.Bundle;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements p131r0.b.InterfaceC0248b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p030e.h f7617b;

    public /* synthetic */ e(p030e.h hVar, int i9) {
        this.f7616a = i9;
        this.f7617b = hVar;
    }

    @Override // p131r0.b.InterfaceC0248b
    public final Bundle a() {
        switch (this.f7616a) {
            case 0:
                return ((g) this.f7617b).lambda$init$0();
            default:
                return p030e.h._init_$lambda$3(this.f7617b);
        }
    }
}
