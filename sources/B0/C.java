package B0;

import org.chromium.support_lib_boundary.ScriptHandlerBoundaryInterface;

/* JADX INFO: compiled from: ScriptHandlerImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class C implements A0.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScriptHandlerBoundaryInterface f1601a;

    public C(ScriptHandlerBoundaryInterface scriptHandlerBoundaryInterface) {
        this.f1601a = scriptHandlerBoundaryInterface;
    }

    @Override // A0.e
    public final void remove() {
        this.f1601a.remove();
    }
}
