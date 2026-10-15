package Z5;

import com.google.crypto.tink.shaded.protobuf.C0585y;

/* JADX INFO: compiled from: OutputPrefixType.java */
/* JADX INFO: loaded from: classes.dex */
public enum I implements C0585y.a {
    UNKNOWN_PREFIX(0),
    TINK(1),
    LEGACY(2),
    RAW(3),
    CRUNCHY(4),
    WITH_ID_REQUIREMENT(5),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5529a;

    I(int i9) {
        this.f5529a = i9;
    }

    public static I b(int i9) {
        if (i9 == 0) {
            return UNKNOWN_PREFIX;
        }
        if (i9 == 1) {
            return TINK;
        }
        if (i9 == 2) {
            return LEGACY;
        }
        if (i9 == 3) {
            return RAW;
        }
        if (i9 == 4) {
            return CRUNCHY;
        }
        if (i9 != 5) {
            return null;
        }
        return WITH_ID_REQUIREMENT;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C0585y.a
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.f5529a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
