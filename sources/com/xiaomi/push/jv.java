package com.xiaomi.push;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class jv extends jl {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f18111b = 10000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f18112c = 10000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f18113d = 10000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f18114e = 10485760;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f18115f = 104857600;

    public static class a extends jl.a {
        public a() {
            super(false, true);
        }

        @Override // com.xiaomi.push.jl.a, com.xiaomi.push.jr
        public jp a(jz jzVar) {
            jv jvVar = new jv(jzVar, ((jl.a) this).f914a, this.f18101b);
            int i9 = ((jl.a) this).f18100a;
            if (i9 != 0) {
                jvVar.b(i9);
            }
            return jvVar;
        }

        public a(boolean z8, boolean z9, int i9) {
            super(z8, z9, i9);
        }
    }

    public jv(jz jzVar, boolean z8, boolean z9) {
        super(jzVar, z8, z9);
    }

    @Override // com.xiaomi.push.jl, com.xiaomi.push.jp
    /* JADX INFO: renamed from: a */
    public jo mo635a() throws jj {
        byte bA = a();
        byte bA2 = a();
        int iMo631a = mo631a();
        if (iMo631a <= f18111b) {
            return new jo(bA, bA2, iMo631a);
        }
        throw new jq(3, defpackage.f.b(iMo631a, "Thrift map size ", " out of range!"));
    }

    @Override // com.xiaomi.push.jl, com.xiaomi.push.jp
    /* JADX INFO: renamed from: a */
    public jn mo634a() throws jj {
        byte bA = a();
        int iMo631a = mo631a();
        if (iMo631a <= f18112c) {
            return new jn(bA, iMo631a);
        }
        throw new jq(3, defpackage.f.b(iMo631a, "Thrift list size ", " out of range!"));
    }

    @Override // com.xiaomi.push.jl, com.xiaomi.push.jp
    /* JADX INFO: renamed from: a */
    public jt mo636a() throws jj {
        byte bA = a();
        int iMo631a = mo631a();
        if (iMo631a <= f18113d) {
            return new jt(bA, iMo631a);
        }
        throw new jq(3, defpackage.f.b(iMo631a, "Thrift set size ", " out of range!"));
    }

    @Override // com.xiaomi.push.jl, com.xiaomi.push.jp
    /* JADX INFO: renamed from: a */
    public String mo638a() throws jj {
        int iMo631a = mo631a();
        if (iMo631a <= f18114e) {
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
        throw new jq(3, defpackage.f.b(iMo631a, "Thrift string size ", " out of range!"));
    }

    @Override // com.xiaomi.push.jl, com.xiaomi.push.jp
    /* JADX INFO: renamed from: a */
    public ByteBuffer mo639a() throws jj {
        int iMo631a = mo631a();
        if (iMo631a <= f18115f) {
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
        throw new jq(3, defpackage.f.b(iMo631a, "Thrift binary size ", " out of range!"));
    }
}
