package com.google.crypto.tink.shaded.protobuf;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: ManifestSchemaFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class I {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f14007b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f14008a;

    /* JADX INFO: compiled from: ManifestSchemaFactory.java */
    public class a implements P {
        @Override // com.google.crypto.tink.shaded.protobuf.P
        public final O a(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.P
        public final boolean b(Class<?> cls) {
            return false;
        }
    }

    /* JADX INFO: compiled from: ManifestSchemaFactory.java */
    public static class b implements P {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public P[] f14009a;

        @Override // com.google.crypto.tink.shaded.protobuf.P
        public final O a(Class<?> cls) {
            for (P p8 : this.f14009a) {
                if (p8.b(cls)) {
                    return p8.a(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.P
        public final boolean b(Class<?> cls) {
            for (P p8 : this.f14009a) {
                if (p8.b(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public I() {
        b0 b0Var = b0.f14041c;
        P p8 = f14007b;
        try {
            p8 = (P) Class.forName("com.google.crypto.tink.shaded.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
        }
        P[] pArr = {C0582v.f14169a, p8};
        b bVar = new b();
        bVar.f14009a = pArr;
        Charset charset = C0585y.f14183a;
        this.f14008a = bVar;
    }
}
