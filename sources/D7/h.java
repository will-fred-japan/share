package D7;

import kotlin.jvm.internal.A;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.z;

/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class h extends g implements kotlin.jvm.internal.h<Object> {
    private final int arity;

    public h(int i9, B7.e<Object> eVar) {
        super(eVar);
        this.arity = i9;
    }

    @Override // kotlin.jvm.internal.h
    public int getArity() {
        return this.arity;
    }

    @Override // D7.a
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        z.f20009a.getClass();
        String strA = A.a(this);
        k.d(strA, "renderLambdaToString(...)");
        return strA;
    }

    public h(int i9) {
        this(i9, null);
    }
}
