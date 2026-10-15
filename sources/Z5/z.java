package Z5;

import com.google.crypto.tink.shaded.protobuf.C0585y;

/* JADX INFO: compiled from: KeyStatusType.java */
/* JADX INFO: loaded from: classes.dex */
public enum z implements C0585y.a {
    UNKNOWN_STATUS(0),
    ENABLED(1),
    DISABLED(2),
    DESTROYED(3),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5553a;

    z(int i9) {
        this.f5553a = i9;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C0585y.a
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.f5553a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
