package androidx.datastore.preferences.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: Internal.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0530y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f7343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f7344b;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.y$a */
    /* JADX INFO: compiled from: Internal.java */
    public interface a {
        int a();
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.y$b */
    /* JADX INFO: compiled from: Internal.java */
    public interface b {
        boolean a();
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.y$c */
    /* JADX INFO: compiled from: Internal.java */
    public interface c<E> extends List<E>, RandomAccess {
        void b();

        c<E> c(int i9);

        boolean e();
    }

    static {
        Charset.forName("US-ASCII");
        f7343a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f7344b = bArr;
        ByteBuffer.wrap(bArr);
        try {
            new AbstractC0514h.a(false, 0, 0, bArr).e(0);
        } catch (C0531z e9) {
            throw new IllegalArgumentException(e9);
        }
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
