package cn.jiguang.ad;

import java.security.SecureRandom;
import okhttp3.internal.http2.Settings;

/* JADX INFO: loaded from: classes.dex */
public class d implements Cloneable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static SecureRandom f8959d = new SecureRandom();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int[] f8962c;

    public d() {
        this.f8961b = 256;
        d();
    }

    public int a() {
        int i9;
        int i10 = this.f8960a;
        if (i10 >= 0) {
            return i10;
        }
        synchronized (this) {
            try {
                if (this.f8960a < 0) {
                    this.f8960a = f8959d.nextInt(Settings.DEFAULT_INITIAL_WINDOW_SIZE);
                }
                i9 = this.f8960a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i9;
    }

    public int b() {
        return this.f8961b & 15;
    }

    public int c() {
        return this.f8961b;
    }

    public Object clone() {
        d dVar = new d();
        dVar.f8960a = this.f8960a;
        dVar.f8961b = this.f8961b;
        int[] iArr = this.f8962c;
        System.arraycopy(iArr, 0, dVar.f8962c, 0, iArr.length);
        return dVar;
    }

    public String d(int i9) {
        StringBuffer stringBuffer = new StringBuffer(";; ->>HEADER<<- ");
        stringBuffer.append(", id: " + a());
        stringBuffer.append("\n; ");
        for (int i10 = 0; i10 < 4; i10++) {
            stringBuffer.append(n.a(i10) + ": " + c(i10) + " ");
        }
        return stringBuffer.toString();
    }

    public String toString() {
        return d(b());
    }

    public d(int i9) {
        this.f8961b = 256;
        d();
        a(i9);
    }

    private void d() {
        this.f8962c = new int[4];
        this.f8961b = 256;
        this.f8960a = -1;
    }

    public void a(int i9) {
        if (i9 < 0 || i9 > 65535) {
            throw new IllegalArgumentException(defpackage.f.b(i9, "DNS message ID ", " is out of range"));
        }
        this.f8960a = i9;
    }

    public void b(int i9) {
        int[] iArr = this.f8962c;
        int i10 = iArr[i9];
        if (i10 == 65535) {
            throw new IllegalStateException("DNS section count cannot be incremented");
        }
        iArr[i9] = i10 + 1;
    }

    public int c(int i9) {
        return this.f8962c[i9];
    }

    public d(b bVar) {
        this(bVar.g());
        this.f8961b = bVar.g();
        int i9 = 0;
        while (true) {
            int[] iArr = this.f8962c;
            if (i9 >= iArr.length) {
                return;
            }
            iArr[i9] = bVar.g();
            i9++;
        }
    }

    public void a(c cVar) {
        cVar.c(a());
        cVar.c(this.f8961b);
        int i9 = 0;
        while (true) {
            int[] iArr = this.f8962c;
            if (i9 >= iArr.length) {
                return;
            }
            cVar.c(iArr[i9]);
            i9++;
        }
    }
}
