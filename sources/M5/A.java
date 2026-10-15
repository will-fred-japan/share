package M5;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: LegacyKmsAeadKey.java */
/* JADX INFO: loaded from: classes.dex */
public final class A extends AbstractC0318b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f2907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p012b6.a f2908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f2909d;

    public A(B b9, p012b6.a aVar, Integer num) {
        this.f2907b = b9;
        this.f2908c = aVar;
        this.f2909d = num;
    }

    public static A y(B b9, Integer num) throws GeneralSecurityException {
        p012b6.a aVarA;
        B.a aVar = B.a.f2912b;
        B.a aVar2 = b9.f2911b;
        if (aVar2 == aVar) {
            if (num == null) {
                throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
            }
            aVarA = p012b6.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
        } else {
            if (aVar2 != B.a.f2913c) {
                throw new GeneralSecurityException("Unknown Variant: " + aVar2);
            }
            if (num != null) {
                throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
            }
            aVarA = p012b6.a.a(new byte[0]);
        }
        return new A(b9, aVarA, num);
    }

    @Override // A0.h
    public final Integer g() {
        return this.f2909d;
    }

    @Override // M5.AbstractC0318b, A0.h
    public final L5.n m() {
        return this.f2907b;
    }

    @Override // M5.AbstractC0318b
    public final p012b6.a w() {
        return this.f2908c;
    }

    @Override // M5.AbstractC0318b
    /* JADX INFO: renamed from: x */
    public final AbstractC0319c m() {
        return this.f2907b;
    }
}
