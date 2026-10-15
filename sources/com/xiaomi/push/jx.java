package com.xiaomi.push;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class jx extends jz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18117a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private jh f921a;

    public jx(int i9) {
        this.f921a = new jh(i9);
    }

    @Override // com.xiaomi.push.jz
    public int a(byte[] bArr, int i9, int i10) {
        byte[] bArrM629a = this.f921a.m629a();
        if (i10 > this.f921a.a() - this.f18117a) {
            i10 = this.f921a.a() - this.f18117a;
        }
        if (i10 > 0) {
            System.arraycopy(bArrM629a, this.f18117a, bArr, i9, i10);
            this.f18117a += i10;
        }
        return i10;
    }

    @Override // com.xiaomi.push.jz
    /* JADX INFO: renamed from: a */
    public void mo644a(byte[] bArr, int i9, int i10) throws IOException {
        this.f921a.write(bArr, i9, i10);
    }

    public int a() {
        return this.f921a.size();
    }
}
