package S7;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: renamed from: S7.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CompletionState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C0398j extends C0405q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f4286c = AtomicIntegerFieldUpdater.newUpdater(C0398j.class, "_resumed$volatile");
    private volatile /* synthetic */ int _resumed$volatile;

    public C0398j(C0396h c0396h, Throwable th, boolean z8) {
        if (th == null) {
            th = new CancellationException("Continuation " + c0396h + " was cancelled normally");
        }
        super(th, z8);
        this._resumed$volatile = 0;
    }
}
