package kotlin.jvm.internal;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;

/* JADX INFO: compiled from: FunctionReference.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends AbstractC0622b implements h, P7.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f20003b;

    public i(int i9, Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, (i10 & 1) == 1);
        this.f20002a = i9;
        this.f20003b = 0;
    }

    @Override // kotlin.jvm.internal.AbstractC0622b
    public final P7.b computeReflected() {
        z.f20009a.getClass();
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            return getName().equals(iVar.getName()) && getSignature().equals(iVar.getSignature()) && this.f20003b == iVar.f20003b && this.f20002a == iVar.f20002a && k.a(getBoundReceiver(), iVar.getBoundReceiver()) && k.a(getOwner(), iVar.getOwner());
        }
        if (obj instanceof P7.e) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.h
    public final int getArity() {
        return this.f20002a;
    }

    @Override // kotlin.jvm.internal.AbstractC0622b
    public final P7.b getReflected() {
        return (P7.e) super.getReflected();
    }

    public final int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner() == null ? 0 : getOwner().hashCode() * 31)) * 31);
    }

    @Override // kotlin.jvm.internal.AbstractC0622b, P7.b
    public final boolean isSuspend() {
        return ((P7.e) super.getReflected()).isSuspend();
    }

    public final String toString() {
        P7.b bVarCompute = compute();
        if (bVarCompute != this) {
            return bVarCompute.toString();
        }
        if (AppAgent.CONSTRUCT.equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }
}
