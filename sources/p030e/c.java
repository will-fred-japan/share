package p030e;

import K7.a;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f18548b;

    public /* synthetic */ c(h hVar, int i9) {
        this.f18547a = i9;
        this.f18548b = hVar;
    }

    @Override // K7.a
    public final Object invoke() {
        switch (this.f18547a) {
            case 0:
                return h.fullyDrawnReporter_delegate$lambda$0$0(this.f18548b);
            case 1:
                return h.onBackPressedInput_delegate$lambda$0(this.f18548b);
            default:
                return h.onBackPressedDispatcher_delegate$lambda$0(this.f18548b);
        }
    }
}
