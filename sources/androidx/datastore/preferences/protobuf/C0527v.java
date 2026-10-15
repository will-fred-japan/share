package androidx.datastore.preferences.protobuf;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: GeneratedMessageInfoFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0527v implements P {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0527v f7331a = new C0527v();

    @Override // androidx.datastore.preferences.protobuf.P
    public final O a(Class<?> cls) {
        if (!AbstractC0528w.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (O) AbstractC0528w.j(cls.asSubclass(AbstractC0528w.class)).i(AbstractC0528w.f.f7336c);
        } catch (Exception e9) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e9);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.P
    public final boolean b(Class<?> cls) {
        return AbstractC0528w.class.isAssignableFrom(cls);
    }
}
