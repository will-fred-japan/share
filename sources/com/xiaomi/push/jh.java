package com.xiaomi.push;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class jh extends ByteArrayOutputStream {
    public jh(int i9) {
        super(i9);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m629a() {
        return ((ByteArrayOutputStream) this).buf;
    }

    public jh() {
    }

    public int a() {
        return ((ByteArrayOutputStream) this).count;
    }
}
