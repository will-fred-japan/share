package com.google.crypto.tink.shaded.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: Internal.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0585y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f14183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f14184b;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.y$a */
    /* JADX INFO: compiled from: Internal.java */
    public interface a {
        int a();
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.y$b */
    /* JADX INFO: compiled from: Internal.java */
    public interface b {
        boolean a();
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.y$c */
    /* JADX INFO: compiled from: Internal.java */
    public interface c<E> extends List<E>, RandomAccess {
        void b();

        c<E> c(int i9);

        boolean e();
    }

    static {
        Charset.forName("US-ASCII");
        f14183a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f14184b = bArr;
        ByteBuffer.wrap(bArr);
        AbstractC0570i.f(false, 0, 0, bArr);
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static int b(long j) {
        return (int) (j ^ (j >>> 32));
    }
}
