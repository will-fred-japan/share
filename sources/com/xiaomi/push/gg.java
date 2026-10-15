package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class gg {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    int f474a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ef.a f475a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    String f476a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private short f477a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private final long f478b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private byte[] f479b;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f17523b = hm.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f17522a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final byte[] f473a = new byte[0];

    public gg() {
        this.f477a = (short) 2;
        this.f479b = f473a;
        this.f476a = null;
        this.f478b = System.currentTimeMillis();
        this.f475a = new ef.a();
        this.f474a = 1;
    }

    public static synchronized String d() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append(f17523b);
        long j = f17522a;
        f17522a = 1 + j;
        sb.append(Long.toString(j));
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long m407a() {
        return this.f478b;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public String m415b() {
        return this.f475a.m276d();
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public String m418c() {
        return this.f475a.m280f();
    }

    public String e() {
        String strM278e = this.f475a.m278e();
        if ("ID_NOT_AVAILABLE".equals(strM278e)) {
            return null;
        }
        if (this.f475a.g()) {
            return strM278e;
        }
        String strD = d();
        this.f475a.e(strD);
        return strD;
    }

    public String f() {
        return this.f476a;
    }

    public String g() {
        if (!this.f475a.m272b()) {
            return null;
        }
        return Long.toString(this.f475a.m266a()) + "@" + this.f475a.m268a() + "/" + this.f475a.m271b();
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + com.xiaomi.push.service.as.a(e()) + "; cmd=" + m408a() + "; type=" + ((int) m410a()) + "; from=" + g() + " ]";
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f475a.c(str);
        this.f475a.m267a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f475a.d(str2);
    }

    public int b() {
        return this.f475a.f();
    }

    public void c(long j) {
        this.f475a.c(j);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m416b() {
        return this.f475a.l();
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public long m417c() {
        return this.f475a.m266a();
    }

    public void b(long j) {
        this.f475a.b(j);
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int iIndexOf = str.indexOf("@");
        try {
            long j = Long.parseLong(str.substring(0, iIndexOf));
            int iIndexOf2 = str.indexOf("/", iIndexOf);
            String strSubstring = str.substring(iIndexOf + 1, iIndexOf2);
            String strSubstring2 = str.substring(iIndexOf2 + 1);
            this.f475a.a(j);
            this.f475a.a(strSubstring);
            this.f475a.b(strSubstring2);
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.m9a("Blob parse user err " + e9.getMessage());
        }
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public long m414b() {
        return this.f475a.m270b();
    }

    public void b(String str) {
        this.f476a = str;
    }

    public gg(ef.a aVar, short s8, byte[] bArr) {
        this.f477a = (short) 2;
        this.f479b = f473a;
        this.f476a = null;
        this.f478b = System.currentTimeMillis();
        this.f475a = aVar;
        this.f477a = s8;
        this.f479b = bArr;
        this.f474a = 2;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m408a() {
        return this.f475a.m274c();
    }

    public void a(int i9) {
        this.f475a.a(i9);
    }

    public int a() {
        return this.f475a.c();
    }

    public void a(String str) {
        this.f475a.e(str);
    }

    public void a(long j) {
        this.f475a.a(j);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m411a() {
        return this.f475a.j();
    }

    public void a(long j, String str, String str2) {
        if (j != 0) {
            this.f475a.a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f475a.a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f475a.b(str2);
    }

    public int c() {
        return this.f475a.b() + 8 + this.f479b.length;
    }

    public void a(byte[] bArr, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f475a.c(1);
            this.f479b = com.xiaomi.push.service.bc.a(com.xiaomi.push.service.bc.a(str, e()), bArr);
        } else {
            this.f475a.c(0);
            this.f479b = bArr;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m412a() {
        return gh.a(this, this.f479b);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m413a(String str) {
        if (this.f475a.e() == 1) {
            return gh.a(this, com.xiaomi.push.service.bc.a(com.xiaomi.push.service.bc.a(str, e()), this.f479b));
        }
        if (this.f475a.e() == 0) {
            return gh.a(this, this.f479b);
        }
        com.xiaomi.channel.commonutils.logger.c.m9a("unknow cipher = " + this.f475a.e());
        return gh.a(this, this.f479b);
    }

    @Deprecated
    public static gg a(hd hdVar, String str) {
        int i9;
        gg ggVar = new gg();
        try {
            i9 = Integer.parseInt(hdVar.k());
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.m9a("Blob parse chid err " + e9.getMessage());
            i9 = 1;
        }
        ggVar.a(i9);
        ggVar.a(hdVar.j());
        ggVar.c(hdVar.m());
        ggVar.b(hdVar.n());
        ggVar.a("XMLMSG", (String) null);
        try {
            ggVar.a(hdVar.mo463a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                ggVar.a((short) 3);
            } else {
                ggVar.a((short) 2);
                ggVar.a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e10) {
            com.xiaomi.channel.commonutils.logger.c.m9a("Blob setPayload err： " + e10.getMessage());
        }
        return ggVar;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public ByteBuffer mo409a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(c());
        }
        byteBuffer.putShort(this.f477a);
        byteBuffer.putShort((short) this.f475a.a());
        byteBuffer.putInt(this.f479b.length);
        int iPosition = byteBuffer.position();
        this.f475a.m373a(byteBuffer.array(), byteBuffer.arrayOffset() + iPosition, this.f475a.a());
        byteBuffer.position(this.f475a.a() + iPosition);
        byteBuffer.put(this.f479b);
        return byteBuffer;
    }

    public static gg a(ByteBuffer byteBuffer) throws IOException {
        try {
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            short s8 = byteBufferSlice.getShort(0);
            short s9 = byteBufferSlice.getShort(2);
            int i9 = byteBufferSlice.getInt(4);
            ef.a aVar = new ef.a();
            aVar.a(byteBufferSlice.array(), byteBufferSlice.arrayOffset() + 8, (int) s9);
            byte[] bArr = new byte[i9];
            byteBufferSlice.position(s9 + 8);
            byteBufferSlice.get(bArr, 0, i9);
            return new gg(aVar, s8, bArr);
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.m9a("read Blob err :" + e9.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public short m410a() {
        return this.f477a;
    }

    public void a(short s8) {
        this.f477a = s8;
    }
}
