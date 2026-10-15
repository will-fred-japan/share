package M5;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: LegacyKmsEnvelopeAeadKey.java */
/* JADX INFO: loaded from: classes.dex */
public final class D extends AbstractC0318b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final E f2919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p012b6.a f2920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f2921d;

    public D(E e9, p012b6.a aVar, Integer num) {
        this.f2919b = e9;
        this.f2920c = aVar;
        this.f2921d = num;
    }

    public static D y(E e9, Integer num) throws GeneralSecurityException {
        p012b6.a aVarB;
        E.b bVar = E.b.f2934c;
        E.b bVar2 = e9.f2922a;
        if (bVar2 == bVar) {
            if (num != null) {
                throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
            }
            aVarB = U5.t.f4731a;
        } else {
            if (bVar2 != E.b.f2933b) {
                throw new GeneralSecurityException("Unknown Variant: " + bVar2);
            }
            if (num == null) {
                throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
            }
            aVarB = U5.t.b(num.intValue());
        }
        return new D(e9, aVarB, num);
    }

    @Override // A0.h
    public final Integer g() {
        return this.f2921d;
    }

    @Override // M5.AbstractC0318b, A0.h
    public final L5.n m() {
        return this.f2919b;
    }

    @Override // M5.AbstractC0318b
    public final p012b6.a w() {
        return this.f2920c;
    }

    @Override // M5.AbstractC0318b
    /* JADX INFO: renamed from: x */
    public final AbstractC0319c m() {
        return this.f2919b;
    }
}
