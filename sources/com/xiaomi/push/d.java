package com.xiaomi.push;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f17187a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final OutputStream f237a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final byte[] f238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f17188b;

    public static class a extends IOException {
        public a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private d(byte[] bArr, int i9, int i10) {
        this.f237a = null;
        this.f238a = bArr;
        this.f17188b = i9;
        this.f17187a = i9 + i10;
    }

    public static int a(boolean z8) {
        return 1;
    }

    public static int c(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int d(int i9) {
        if ((i9 & (-128)) == 0) {
            return 1;
        }
        if ((i9 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i9) == 0) {
            return 3;
        }
        return (i9 & (-268435456)) == 0 ? 4 : 5;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m215b(int i9, long j) throws IOException {
        c(i9, 0);
        m216b(j);
    }

    public static d a(OutputStream outputStream) {
        return a(outputStream, 4096);
    }

    private void c() throws IOException {
        OutputStream outputStream = this.f237a;
        if (outputStream == null) {
            throw new a();
        }
        outputStream.write(this.f238a, 0, this.f17188b);
        this.f17188b = 0;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public void m219d(int i9) throws IOException {
        while ((i9 & (-128)) != 0) {
            m217c((i9 & 127) | 128);
            i9 >>>= 7;
        }
        m217c(i9);
    }

    public static d a(OutputStream outputStream, int i9) {
        return new d(outputStream, new byte[i9]);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m214b(int i9, int i10) throws IOException {
        c(i9, 0);
        m213b(i10);
    }

    public static d a(byte[] bArr, int i9, int i10) {
        return new d(bArr, i9, i10);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m202a(int i9, long j) throws IOException {
        c(i9, 0);
        m207a(j);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m216b(long j) throws IOException {
        m218c(j);
    }

    private d(OutputStream outputStream, byte[] bArr) {
        this.f237a = outputStream;
        this.f238a = bArr;
        this.f17188b = 0;
        this.f17187a = bArr.length;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m213b(int i9) throws IOException {
        m219d(i9);
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public void m217c(int i9) throws IOException {
        a((byte) i9);
    }

    public static int b(int i9, long j) {
        return b(j) + c(i9);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m201a(int i9, int i10) throws IOException {
        c(i9, 0);
        m200a(i10);
    }

    public void c(int i9, int i10) throws IOException {
        m219d(g.a(i9, i10));
    }

    public static int b(int i9, int i10) {
        return b(i10) + c(i9);
    }

    public static int c(int i9) {
        return d(g.a(i9, 0));
    }

    public static int b(long j) {
        return c(j);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m206a(int i9, boolean z8) throws IOException {
        c(i9, 0);
        m211a(z8);
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public void m218c(long j) throws IOException {
        while (((-128) & j) != 0) {
            m217c((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m217c((int) j);
    }

    public static int b(int i9) {
        return d(i9);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m205a(int i9, String str) throws IOException {
        c(i9, 2);
        m210a(str);
    }

    public void b() {
        if (a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m204a(int i9, f fVar) throws IOException {
        c(i9, 2);
        m209a(fVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m203a(int i9, b bVar) throws IOException {
        c(i9, 2);
        m208a(bVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m207a(long j) throws IOException {
        m218c(j);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m200a(int i9) throws IOException {
        if (i9 >= 0) {
            m219d(i9);
        } else {
            m218c(i9);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m211a(boolean z8) throws IOException {
        m217c(z8 ? 1 : 0);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m210a(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        m219d(bytes.length);
        a(bytes);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m209a(f fVar) throws IOException {
        m219d(fVar.a());
        fVar.a(this);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m208a(b bVar) throws IOException {
        byte[] bArrM119a = bVar.m119a();
        m219d(bArrM119a.length);
        a(bArrM119a);
    }

    public static int a(int i9, long j) {
        return a(j) + c(i9);
    }

    public static int a(int i9, int i10) {
        return a(i10) + c(i9);
    }

    public static int a(int i9, boolean z8) {
        return a(z8) + c(i9);
    }

    public static int a(int i9, String str) {
        return a(str) + c(i9);
    }

    public static int a(int i9, f fVar) {
        return a(fVar) + c(i9);
    }

    public static int a(int i9, b bVar) {
        return a(bVar) + c(i9);
    }

    public static int a(long j) {
        return c(j);
    }

    public static int a(int i9) {
        if (i9 >= 0) {
            return d(i9);
        }
        return 10;
    }

    public static int a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return d(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static int a(f fVar) {
        int iB = fVar.b();
        return d(iB) + iB;
    }

    public static int a(b bVar) {
        return bVar.a() + d(bVar.a());
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m199a() throws IOException {
        if (this.f237a != null) {
            c();
        }
    }

    public int a() {
        if (this.f237a == null) {
            return this.f17187a - this.f17188b;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    public void a(byte b9) throws IOException {
        if (this.f17188b == this.f17187a) {
            c();
        }
        byte[] bArr = this.f238a;
        int i9 = this.f17188b;
        this.f17188b = i9 + 1;
        bArr[i9] = b9;
    }

    public void a(byte[] bArr) throws IOException {
        m212a(bArr, 0, bArr.length);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m212a(byte[] bArr, int i9, int i10) throws IOException {
        int i11 = this.f17187a;
        int i12 = this.f17188b;
        if (i11 - i12 >= i10) {
            System.arraycopy(bArr, i9, this.f238a, i12, i10);
            this.f17188b += i10;
            return;
        }
        int i13 = i11 - i12;
        System.arraycopy(bArr, i9, this.f238a, i12, i13);
        int i14 = i9 + i13;
        int i15 = i10 - i13;
        this.f17188b = this.f17187a;
        c();
        if (i15 <= this.f17187a) {
            System.arraycopy(bArr, i14, this.f238a, 0, i15);
            this.f17188b = i15;
        } else {
            this.f237a.write(bArr, i14, i15);
        }
    }
}
