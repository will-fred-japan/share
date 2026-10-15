package com.xiaomi.push;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {
    public abstract int a();

    public abstract f a(c cVar);

    public abstract void a(d dVar);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m374a() {
        int iB = b();
        byte[] bArr = new byte[iB];
        m373a(bArr, 0, iB);
        return bArr;
    }

    public abstract int b();

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m373a(byte[] bArr, int i9, int i10) {
        try {
            d dVarA = d.a(bArr, i9, i10);
            a(dVarA);
            dVarA.b();
        } catch (IOException unused) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
    }

    public f a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public f a(byte[] bArr, int i9, int i10) throws e {
        try {
            c cVarA = c.a(bArr, i9, i10);
            a(cVarA);
            cVarA.m144a(0);
            return this;
        } catch (e e9) {
            throw e9;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public boolean a(c cVar, int i9) {
        return cVar.m146a(i9);
    }
}
