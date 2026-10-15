package androidx.datastore.preferences.protobuf;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: ManifestSchemaFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class I {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f7167b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f7168a;

    /* JADX INFO: compiled from: ManifestSchemaFactory.java */
    public class a implements P {
        @Override // androidx.datastore.preferences.protobuf.P
        public final O a(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }

        @Override // androidx.datastore.preferences.protobuf.P
        public final boolean b(Class<?> cls) {
            return false;
        }
    }

    /* JADX INFO: compiled from: ManifestSchemaFactory.java */
    public static class b implements P {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public P[] f7169a;

        @Override // androidx.datastore.preferences.protobuf.P
        public final O a(Class<?> cls) {
            for (P p8 : this.f7169a) {
                if (p8.b(cls)) {
                    return p8.a(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
        }

        @Override // androidx.datastore.preferences.protobuf.P
        public final boolean b(Class<?> cls) {
            for (P p8 : this.f7169a) {
                if (p8.b(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public I() {
        c0 c0Var = c0.f7206c;
        P p8 = f7167b;
        try {
            p8 = (P) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
        }
        P[] pArr = {C0527v.f7331a, p8};
        b bVar = new b();
        bVar.f7169a = pArr;
        Charset charset = C0530y.f7343a;
        this.f7168a = bVar;
    }
}
