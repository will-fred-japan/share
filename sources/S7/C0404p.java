package S7;

import java.util.concurrent.CancellationException;

/* JADX INFO: renamed from: S7.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CancellableContinuationImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C0404p<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final R f4293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0393e f4294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final K7.q<Throwable, R, B7.h, p188x7.k> f4295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f4296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Throwable f4297e;

    /* JADX WARN: Multi-variable type inference failed */
    public C0404p(R r8, InterfaceC0393e interfaceC0393e, K7.q<? super Throwable, ? super R, ? super B7.h, p188x7.k> qVar, Object obj, Throwable th) {
        this.f4293a = r8;
        this.f4294b = interfaceC0393e;
        this.f4295c = qVar;
        this.f4296d = obj;
        this.f4297e = th;
    }

    public static C0404p a(C0404p c0404p, InterfaceC0393e interfaceC0393e, CancellationException cancellationException, int i9) {
        R r8 = c0404p.f4293a;
        if ((i9 & 2) != 0) {
            interfaceC0393e = c0404p.f4294b;
        }
        InterfaceC0393e interfaceC0393e2 = interfaceC0393e;
        K7.q<Throwable, R, B7.h, p188x7.k> qVar = c0404p.f4295c;
        Object obj = c0404p.f4296d;
        Throwable th = cancellationException;
        if ((i9 & 16) != 0) {
            th = c0404p.f4297e;
        }
        c0404p.getClass();
        return new C0404p(r8, interfaceC0393e2, qVar, obj, th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0404p)) {
            return false;
        }
        C0404p c0404p = (C0404p) obj;
        return kotlin.jvm.internal.k.a(this.f4293a, c0404p.f4293a) && kotlin.jvm.internal.k.a(this.f4294b, c0404p.f4294b) && kotlin.jvm.internal.k.a(this.f4295c, c0404p.f4295c) && kotlin.jvm.internal.k.a(this.f4296d, c0404p.f4296d) && kotlin.jvm.internal.k.a(this.f4297e, c0404p.f4297e);
    }

    public final int hashCode() {
        R r8 = this.f4293a;
        int iHashCode = (r8 == null ? 0 : r8.hashCode()) * 31;
        InterfaceC0393e interfaceC0393e = this.f4294b;
        int iHashCode2 = (iHashCode + (interfaceC0393e == null ? 0 : interfaceC0393e.hashCode())) * 31;
        K7.q<Throwable, R, B7.h, p188x7.k> qVar = this.f4295c;
        int iHashCode3 = (iHashCode2 + (qVar == null ? 0 : qVar.hashCode())) * 31;
        Object obj = this.f4296d;
        int iHashCode4 = (iHashCode3 + (obj == null ? 0 : obj.hashCode())) * 31;
        Throwable th = this.f4297e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f4293a + ", cancelHandler=" + this.f4294b + ", onCancellation=" + this.f4295c + ", idempotentResume=" + this.f4296d + ", cancelCause=" + this.f4297e + ')';
    }

    public /* synthetic */ C0404p(Object obj, InterfaceC0393e interfaceC0393e, K7.q qVar, CancellationException cancellationException, int i9) {
        this(obj, (i9 & 2) != 0 ? null : interfaceC0393e, (K7.q<? super Throwable, ? super Object, ? super B7.h, p188x7.k>) ((i9 & 4) != 0 ? null : qVar), (Object) null, (i9 & 16) != 0 ? null : cancellationException);
    }
}
