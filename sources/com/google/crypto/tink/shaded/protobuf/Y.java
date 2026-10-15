package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: compiled from: NewInstanceSchemas.java */
/* JADX INFO: loaded from: classes.dex */
public final class Y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final W f14035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final X f14036b;

    static {
        W w8;
        b0 b0Var = b0.f14041c;
        try {
            w8 = (W) Class.forName("com.google.crypto.tink.shaded.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            w8 = null;
        }
        f14035a = w8;
        f14036b = new X();
    }
}
