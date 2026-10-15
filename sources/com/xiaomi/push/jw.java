package com.xiaomi.push;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class jw extends jz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected InputStream f18116a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected OutputStream f920a;

    public jw() {
        this.f18116a = null;
        this.f920a = null;
    }

    @Override // com.xiaomi.push.jz
    public int a(byte[] bArr, int i9, int i10) throws ka {
        InputStream inputStream = this.f18116a;
        if (inputStream == null) {
            throw new ka(1, "Cannot read from null inputStream");
        }
        try {
            int i11 = inputStream.read(bArr, i9, i10);
            if (i11 >= 0) {
                return i11;
            }
            throw new ka(4);
        } catch (IOException e9) {
            throw new ka(0, e9);
        }
    }

    public jw(OutputStream outputStream) {
        this.f18116a = null;
        this.f920a = outputStream;
    }

    @Override // com.xiaomi.push.jz
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo644a(byte[] bArr, int i9, int i10) throws ka {
        OutputStream outputStream = this.f920a;
        if (outputStream != null) {
            try {
                outputStream.write(bArr, i9, i10);
                return;
            } catch (IOException e9) {
                throw new ka(0, e9);
            }
        }
        throw new ka(1, "Cannot write to null outputStream");
    }
}
