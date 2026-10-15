package X7;

import S7.InterfaceC0413z;

/* JADX INFO: compiled from: Scopes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements InterfaceC0413z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final B7.h f5134a;

    public c(B7.h hVar) {
        this.f5134a = hVar;
    }

    @Override // S7.InterfaceC0413z
    public final B7.h g() {
        return this.f5134a;
    }

    public final String toString() {
        return "CoroutineScope(coroutineContext=" + this.f5134a + ')';
    }
}
