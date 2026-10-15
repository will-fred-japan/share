package com.xiaomi.push;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class jl extends jp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ju f18092a = new ju();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected int f909a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected boolean f910a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private byte[] f911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected boolean f18093b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private byte[] f912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected boolean f18094c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private byte[] f913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f18095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f18096e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private byte[] f18097f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private byte[] f18098g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private byte[] f18099h;

    public static class a implements jr {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected int f18100a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        protected boolean f914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected boolean f18101b;

        public a() {
            this(false, true);
        }

        @Override // com.xiaomi.push.jr
        public jp a(jz jzVar) {
            jl jlVar = new jl(jzVar, this.f914a, this.f18101b);
            int i9 = this.f18100a;
            if (i9 != 0) {
                jlVar.b(i9);
            }
            return jlVar;
        }

        public a(boolean z8, boolean z9) {
            this(z8, z9, 0);
        }

        public a(boolean z8, boolean z9, int i9) {
            this.f914a = z8;
            this.f18101b = z9;
            this.f18100a = i9;
        }
    }

    public jl(jz jzVar, boolean z8, boolean z9) {
        super(jzVar);
        this.f18094c = false;
        this.f911a = new byte[1];
        this.f912b = new byte[2];
        this.f913c = new byte[4];
        this.f18095d = new byte[8];
        this.f18096e = new byte[1];
        this.f18097f = new byte[2];
        this.f18098g = new byte[4];
        this.f18099h = new byte[8];
        this.f910a = z8;
        this.f18093b = z9;
    }

    @Override // com.xiaomi.push.jp
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo641a() {
    }

    @Override // com.xiaomi.push.jp
    public void b() {
    }

    @Override // com.xiaomi.push.jp
    public void c() {
        a((byte) 0);
    }

    @Override // com.xiaomi.push.jp
    public void a(ju juVar) {
    }

    public void b(int i9) {
        this.f909a = i9;
        this.f18094c = true;
    }

    public void c(int i9) throws jj {
        if (i9 < 0) {
            throw new jj(W5.e.i(i9, "Negative length: "));
        }
        if (this.f18094c) {
            int i10 = this.f909a - i9;
            this.f909a = i10;
            if (i10 < 0) {
                throw new jj(W5.e.i(i9, "Message length exceeded: "));
            }
        }
    }

    @Override // com.xiaomi.push.jp
    public void a(jm jmVar) {
        a(jmVar.f18102a);
        a(jmVar.f916a);
    }

    @Override // com.xiaomi.push.jp
    public void a(jo joVar) {
        a(joVar.f18104a);
        a(joVar.f18105b);
        mo642a(joVar.f918a);
    }

    @Override // com.xiaomi.push.jp
    public void a(jn jnVar) {
        a(jnVar.f18103a);
        mo642a(jnVar.f917a);
    }

    @Override // com.xiaomi.push.jp
    public void a(boolean z8) {
        a(z8 ? (byte) 1 : (byte) 0);
    }

    @Override // com.xiaomi.push.jp
    public void a(byte b9) {
        byte[] bArr = this.f911a;
        bArr[0] = b9;
        ((jp) this).f18106a.mo644a(bArr, 0, 1);
    }

    @Override // com.xiaomi.push.jp
    public void a(short s8) {
        byte[] bArr = this.f912b;
        bArr[0] = (byte) ((s8 >> 8) & 255);
        bArr[1] = (byte) (s8 & 255);
        ((jp) this).f18106a.mo644a(bArr, 0, 2);
    }

    @Override // com.xiaomi.push.jp
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo642a(int i9) {
        byte[] bArr = this.f913c;
        bArr[0] = (byte) ((i9 >> 24) & 255);
        bArr[1] = (byte) ((i9 >> 16) & 255);
        bArr[2] = (byte) ((i9 >> 8) & 255);
        bArr[3] = (byte) (i9 & 255);
        ((jp) this).f18106a.mo644a(bArr, 0, 4);
    }

    @Override // com.xiaomi.push.jp
    public void a(long j) {
        byte[] bArr = this.f18095d;
        bArr[0] = (byte) ((j >> 56) & 255);
        bArr[1] = (byte) ((j >> 48) & 255);
        bArr[2] = (byte) ((j >> 40) & 255);
        bArr[3] = (byte) ((j >> 32) & 255);
        bArr[4] = (byte) ((j >> 24) & 255);
        bArr[5] = (byte) ((j >> 16) & 255);
        bArr[6] = (byte) ((j >> 8) & 255);
        bArr[7] = (byte) (j & 255);
        ((jp) this).f18106a.mo644a(bArr, 0, 8);
    }

    @Override // com.xiaomi.push.jp
    public void a(String str) throws jj {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            mo642a(bytes.length);
            ((jp) this).f18106a.mo644a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new jj("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.jp
    public void a(ByteBuffer byteBuffer) {
        int iLimit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
        mo642a(iLimit);
        ((jp) this).f18106a.mo644a(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), iLimit);
    }

    @Override // com.xiaomi.push.jp
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public ju mo637a() {
        return f18092a;
    }

    @Override // com.xiaomi.push.jp
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public jm mo633a() throws jj {
        byte bA = a();
        return new jm("", bA, bA == 0 ? (short) 0 : mo640a());
    }

    @Override // com.xiaomi.push.jp
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public jo mo635a() {
        return new jo(a(), a(), mo631a());
    }

    @Override // com.xiaomi.push.jp
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public jn mo634a() {
        return new jn(a(), mo631a());
    }

    @Override // com.xiaomi.push.jp
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public jt mo636a() {
        return new jt(a(), mo631a());
    }

    @Override // com.xiaomi.push.jp
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean mo643a() {
        return a() == 1;
    }

    @Override // com.xiaomi.push.jp
    public byte a() throws jj {
        if (((jp) this).f18106a.b() >= 1) {
            byte b9 = ((jp) this).f18106a.a()[((jp) this).f18106a.a_()];
            ((jp) this).f18106a.a(1);
            return b9;
        }
        a(this.f18096e, 0, 1);
        return this.f18096e[0];
    }

    @Override // com.xiaomi.push.jp
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public short mo640a() throws jj {
        int iA_;
        byte[] bArrA = this.f18097f;
        if (((jp) this).f18106a.b() >= 2) {
            bArrA = ((jp) this).f18106a.a();
            iA_ = ((jp) this).f18106a.a_();
            ((jp) this).f18106a.a(2);
        } else {
            a(this.f18097f, 0, 2);
            iA_ = 0;
        }
        return (short) ((bArrA[iA_ + 1] & 255) | ((bArrA[iA_] & 255) << 8));
    }

    @Override // com.xiaomi.push.jp
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public int mo631a() throws jj {
        int iA_;
        byte[] bArrA = this.f18098g;
        if (((jp) this).f18106a.b() >= 4) {
            bArrA = ((jp) this).f18106a.a();
            iA_ = ((jp) this).f18106a.a_();
            ((jp) this).f18106a.a(4);
        } else {
            a(this.f18098g, 0, 4);
            iA_ = 0;
        }
        return (bArrA[iA_ + 3] & 255) | ((bArrA[iA_] & 255) << 24) | ((bArrA[iA_ + 1] & 255) << 16) | ((bArrA[iA_ + 2] & 255) << 8);
    }

    @Override // com.xiaomi.push.jp
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long mo632a() throws jj {
        int iA_;
        byte[] bArrA = this.f18099h;
        if (((jp) this).f18106a.b() >= 8) {
            bArrA = ((jp) this).f18106a.a();
            iA_ = ((jp) this).f18106a.a_();
            ((jp) this).f18106a.a(8);
        } else {
            a(this.f18099h, 0, 8);
            iA_ = 0;
        }
        return ((long) (bArrA[iA_ + 7] & 255)) | (((long) (bArrA[iA_] & 255)) << 56) | (((long) (bArrA[iA_ + 1] & 255)) << 48) | (((long) (bArrA[iA_ + 2] & 255)) << 40) | (((long) (bArrA[iA_ + 3] & 255)) << 32) | (((long) (bArrA[iA_ + 4] & 255)) << 24) | (((long) (bArrA[iA_ + 5] & 255)) << 16) | (((long) (bArrA[iA_ + 6] & 255)) << 8);
    }

    @Override // com.xiaomi.push.jp
    public void d() {
    }

    @Override // com.xiaomi.push.jp
    public void e() {
    }

    @Override // com.xiaomi.push.jp
    public void f() {
    }

    @Override // com.xiaomi.push.jp
    public void g() {
    }

    @Override // com.xiaomi.push.jp
    public void h() {
    }

    @Override // com.xiaomi.push.jp
    public void i() {
    }

    @Override // com.xiaomi.push.jp
    public void j() {
    }

    @Override // com.xiaomi.push.jp
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public double mo630a() {
        return Double.longBitsToDouble(mo632a());
    }

    @Override // com.xiaomi.push.jp
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String mo638a() throws jj {
        int iMo631a = mo631a();
        if (((jp) this).f18106a.b() >= iMo631a) {
            try {
                String str = new String(((jp) this).f18106a.a(), ((jp) this).f18106a.a_(), iMo631a, "UTF-8");
                ((jp) this).f18106a.a(iMo631a);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new jj("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return a(iMo631a);
    }

    public String a(int i9) throws jj {
        try {
            c(i9);
            byte[] bArr = new byte[i9];
            ((jp) this).f18106a.b(bArr, 0, i9);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new jj("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.jp
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public ByteBuffer mo639a() throws jj {
        int iMo631a = mo631a();
        c(iMo631a);
        if (((jp) this).f18106a.b() >= iMo631a) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(((jp) this).f18106a.a(), ((jp) this).f18106a.a_(), iMo631a);
            ((jp) this).f18106a.a(iMo631a);
            return byteBufferWrap;
        }
        byte[] bArr = new byte[iMo631a];
        ((jp) this).f18106a.b(bArr, 0, iMo631a);
        return ByteBuffer.wrap(bArr);
    }

    private int a(byte[] bArr, int i9, int i10) throws jj {
        c(i10);
        return ((jp) this).f18106a.b(bArr, i9, i10);
    }
}
