package S7;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes2.dex */
public class Z extends c0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f4253c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z() {
        super(true);
        boolean z8 = true;
        R(null);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c0.f4260b;
        InterfaceC0400l interfaceC0400l = (InterfaceC0400l) atomicReferenceFieldUpdater.get(this);
        C0401m c0401m = interfaceC0400l instanceof C0401m ? (C0401m) interfaceC0400l : null;
        if (c0401m == null) {
            z8 = false;
            break;
        }
        c0 c0VarI = c0401m.i();
        while (!c0VarI.M()) {
            InterfaceC0400l interfaceC0400l2 = (InterfaceC0400l) atomicReferenceFieldUpdater.get(c0VarI);
            C0401m c0401m2 = interfaceC0400l2 instanceof C0401m ? (C0401m) interfaceC0400l2 : null;
            if (c0401m2 == null) {
                z8 = false;
                break;
            }
            c0VarI = c0401m2.i();
        }
        this.f4253c = z8;
    }

    @Override // S7.c0
    public final boolean M() {
        return this.f4253c;
    }

    @Override // S7.c0
    public final boolean N() {
        return true;
    }
}
