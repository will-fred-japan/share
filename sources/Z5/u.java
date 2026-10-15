package Z5;

import com.google.crypto.tink.shaded.protobuf.C0585y;

/* JADX INFO: compiled from: HashType.java */
/* JADX INFO: loaded from: classes.dex */
public enum u implements C0585y.a {
    UNKNOWN_HASH(0),
    SHA1(1),
    SHA384(2),
    SHA256(3),
    SHA512(4),
    SHA224(5),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5538a;

    u(int i9) {
        this.f5538a = i9;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C0585y.a
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.f5538a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
