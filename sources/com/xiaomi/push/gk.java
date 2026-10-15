package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes2.dex */
public class gk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f17529a = {80, 85, 83, 72};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private byte f492a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private int f493a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private short f494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f17530b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f17531a = new c();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public static final d f495a = new d();

        public static byte[] a(byte[] bArr) {
            return a(bArr, f495a);
        }

        public static byte[] a(byte[] bArr, b bVar) {
            if (!gk.m422a(bArr)) {
                return bArr;
            }
            gk gkVarA = gk.a(bArr);
            return (gkVarA.f492a == 0 || gkVarA.f492a != bVar.a()) ? gkVarA.f17530b : bVar.a(gkVarA.f17530b, gkVarA.f493a);
        }
    }

    public interface b {
        byte a();

        byte[] a(byte[] bArr, int i9);
    }

    public static final class c {
    }

    public static final class d implements b {
        @Override // com.xiaomi.push.gk.b
        public byte a() {
            return (byte) 2;
        }

        @Override // com.xiaomi.push.gk.b
        public byte[] a(byte[] bArr, int i9) throws Throwable {
            GZIPInputStream gZIPInputStream = null;
            try {
                GZIPInputStream gZIPInputStream2 = new GZIPInputStream(new ByteArrayInputStream(bArr), i9);
                try {
                    byte[] bArr2 = new byte[i9];
                    gZIPInputStream2.read(bArr2);
                    try {
                        gZIPInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return bArr2;
                } catch (IOException unused2) {
                    gZIPInputStream = gZIPInputStream2;
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return bArr;
                } catch (Throwable th) {
                    th = th;
                    gZIPInputStream = gZIPInputStream2;
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused5) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public gk(byte b9, int i9, byte[] bArr) {
        this((short) 1, b9, i9, bArr);
    }

    public gk(short s8, byte b9, int i9, byte[] bArr) {
        this.f494a = s8;
        this.f492a = b9;
        this.f493a = i9;
        this.f17530b = bArr;
    }

    public static gk a(byte b9, int i9, byte[] bArr) {
        return new gk(b9, i9, bArr);
    }

    public static gk a(short s8, byte b9, int i9, byte[] bArr) {
        return new gk(s8, b9, i9, bArr);
    }

    public static gk a(byte[] bArr) {
        if (m422a(bArr)) {
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
            byteBufferOrder.getInt();
            short s8 = byteBufferOrder.getShort();
            byte b9 = byteBufferOrder.get();
            int i9 = byteBufferOrder.getInt();
            byte[] bArr2 = new byte[byteBufferOrder.getInt()];
            byteBufferOrder.get(bArr2);
            return a(s8, b9, i9, bArr2);
        }
        return a((byte) 0, bArr.length, bArr);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m422a(byte[] bArr) {
        byte[] bArr2 = f17529a;
        return a(bArr2, bArr, bArr2.length);
    }

    public static boolean a(byte[] bArr, byte[] bArr2, int i9) {
        if (bArr.length < i9 || bArr2.length < i9) {
            return false;
        }
        for (int i10 = 0; i10 < i9; i10++) {
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
        }
        return true;
    }
}
