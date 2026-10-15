package kotlin.jvm.internal;

import java.io.Serializable;

/* JADX INFO: compiled from: Lambda.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class l<R> implements h<R>, Serializable {
    private final int arity;

    public l(int i9) {
        this.arity = i9;
    }

    @Override // kotlin.jvm.internal.h
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        z.f20009a.getClass();
        String strA = A.a(this);
        k.d(strA, "renderLambdaToString(...)");
        return strA;
    }
}
