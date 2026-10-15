package p030e;

import androidx.lifecycle.AbstractC0544j;
import androidx.lifecycle.InterfaceC0546l;
import androidx.lifecycle.InterfaceC0548n;
import kotlin.jvm.internal.k;
import p131r0.b;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements InterfaceC0546l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f18553b;

    public /* synthetic */ f(int i9, Object obj) {
        this.f18552a = i9;
        this.f18553b = obj;
    }

    @Override // androidx.lifecycle.InterfaceC0546l
    public final void d(InterfaceC0548n interfaceC0548n, AbstractC0544j.a aVar) {
        switch (this.f18552a) {
            case 0:
                h._init_$lambda$2((h) this.f18553b, interfaceC0548n, aVar);
                break;
            default:
                b this$0 = (b) this.f18553b;
                k.e(this$0, "this$0");
                if (aVar == AbstractC0544j.a.ON_START) {
                    this$0.f21099f = true;
                } else if (aVar == AbstractC0544j.a.ON_STOP) {
                    this$0.f21099f = false;
                }
                break;
        }
    }
}
