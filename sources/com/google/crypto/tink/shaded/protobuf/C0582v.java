package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: GeneratedMessageInfoFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0582v implements P {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0582v f14169a = new C0582v();

    @Override // com.google.crypto.tink.shaded.protobuf.P
    public final O a(Class<?> cls) {
        if (!AbstractC0583w.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (O) AbstractC0583w.n(cls.asSubclass(AbstractC0583w.class)).m(AbstractC0583w.f.f14174c);
        } catch (Exception e9) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e9);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.P
    public final boolean b(Class<?> cls) {
        return AbstractC0583w.class.isAssignableFrom(cls);
    }
}
