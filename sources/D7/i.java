package D7;

import kotlin.jvm.internal.A;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.z;

/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class i extends c implements kotlin.jvm.internal.h<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1944a;

    public i(int i9, B7.e<Object> eVar) {
        super(eVar);
        this.f1944a = i9;
    }

    @Override // kotlin.jvm.internal.h
    public final int getArity() {
        return this.f1944a;
    }

    @Override // D7.a
    public final String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        z.f20009a.getClass();
        String strA = A.a(this);
        k.d(strA, "renderLambdaToString(...)");
        return strA;
    }
}
