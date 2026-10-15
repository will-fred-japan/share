package cn.jiguang.ag;

import android.content.Context;
import cn.jiguang.aw.l;
import cn.jiguang.aw.s;
import cn.jiguang.aw.t;
import cn.jiguang.internal.JConstants;
import cn.jiguang.w.j;
import cn.jiguang.x.f;
import com.jieli.jl_bt_ota.constant.AttrAndFunCode;
import java.nio.ByteBuffer;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Integer f9098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f9099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f9100c = l.b(new byte[]{92, 118, 75, 110, 77, 97, 72, 120, 107, 118, 82, 95, 107, 90, 16, 90, 73, 71, 72, 121, 107, 118, 82, 95, 107, 90, 16, 93, 73, 71, 114, 116, 113, 126, 73, 83, 40, 88, 83, 45, 125, 127, 75, 93, 11, 42, 57, 83, 122, 121, 114, 65, 121, 110, 66, 68, 103, 117, 66, 33, 98, 64, 102, 107, 94, 82, 72, 7, 110, 99, 71, 98, 120, 123, 118, 47, 57, 95, 35, 68, 75, 123, 106, 81, 90, 4, 83, 125, 106, 97, 90, 5, 23, 122, 92, 114, 125, 122, 111, 109, 66, 96, 93, 101, 118, 111, 99, 71, 103, 120, 87, 122, 114, 98, 92, 92, 65, 32, 109, 97, 40, 87, 29, 36});

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f9101d = l.b(new byte[]{109, 80, 79, 112, 92, 113, 16, 94, 75, 69, 96, 119, 115, 80, 106, 37, 85, 97, 101, 91, 73, 71, 68, 113, 97, 45, 79, 88, 80, 116, 99, 91, 97, 71, 90, 114, 71, 72, 75, 61, 102, 9, 110, 96, 82, 38, 85, 90, 85, 75, 110, 87, 89, 120, 71, 99, 67, 66, 90, 8, 76, 91, 123, 94, 40, 92, 69, 86, 74, 103, 40, 87, 106, 86, 48, 64, 114, 70, 117, 97, 120, 85, 125, 3, 18, 64, 113, 90, 101, 5, 70, 118, 78, 76, 82, 113, 98, 85, 76, 92, 97, 104, 110, 78, 49, 89, 96, 116, 65, 83, 99, 36, 64, 31, 108, 94, 49, 93, 37, 73, 16, 76, 74, 99, 121, 122, 86, 97, 121, 89, 86, 82, AttrAndFunCode.SYS_INFO_FUNCTION_LOW_POWER, 67, 56, 119, 105, 99, 105, 106, 110, 101, 72, 1, 23, 73, 68, 84, 101, 2, 76, 78, 35, 83, 105, 74, 102, 92, 113, 68, 124, 65, 65, 76, 94, 125, 33, 66, 79, 73, 62, 35, 120, 31, 17, 119, 109, 82, 71, 69, 66, 80, 106, 46, 95, 99, 117, 96, 93, 69, 107, 73, 103, 124, 106, 83, 84, 127, 106, 93, 64, 47, 62, 113, 107, 122, 122, 82, 38, 97, 105, 93, 73, 71, 80, 114});

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f9102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f9103b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f9104c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f9105d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f9106e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f9107f;

        public a(byte[] bArr, int i9, String str, long j, String str2, int i10) {
            this.f9102a = bArr;
            this.f9103b = i9;
            this.f9104c = str;
            this.f9105d = j;
            this.f9106e = str2;
            this.f9107f = i10;
        }
    }

    public static int a() {
        Integer num = f9098a;
        if (num != null) {
            return num.intValue();
        }
        Integer numValueOf = Integer.valueOf(Math.abs(new SecureRandom().nextInt()));
        f9098a = numValueOf;
        return numValueOf.intValue();
    }

    public static a b(Context context) {
        return a(context, 0L, null, true);
    }

    public static a a(Context context, long j, String str) {
        return a(context, j, str, true);
    }

    private static a a(Context context, long j, String str, boolean z8) {
        String str2;
        int i9;
        j.a aVarC;
        String str3 = str != null ? str : "";
        if (j <= 0) {
            j = a();
        }
        String str4 = f9100c;
        String str5 = f9101d;
        if (!z8 || (aVarC = j.c()) == null) {
            str2 = str4;
            i9 = 0;
        } else {
            String str6 = aVarC.f10906f;
            str5 = aVarC.f10907g;
            str2 = str6;
            i9 = aVarC.f10901a;
        }
        t.a aVarA = t.a.a(context, j + "", str3, str2, str5, cn.jiguang.ac.c.e(context));
        f9099b = new String(aVarA.b());
        cn.jiguang.aj.b bVar = new cn.jiguang.aj.b();
        String str7 = str3;
        int iD = aVarA.d();
        byte[] bArrA = aVarA.a();
        bVar.a(3 == iD ? 4 : iD);
        if (z8) {
            bVar.b(i9);
        }
        bVar.b(bArrA);
        return new a(a(bVar.b()), iD, f9099b, j, str7, z8 ? i9 : 0);
    }

    public static String a(Context context) {
        return f9099b;
    }

    public static String a(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.getShort()];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, "UTF-8");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] a(long j, int i9, long j8, short s8, int i10, int i11, int i12) {
        cn.jiguang.aj.b bVar = new cn.jiguang.aj.b(20480);
        bVar.b(0);
        bVar.a(8);
        bVar.a(2);
        bVar.b(j);
        bVar.a(i9);
        bVar.b(j8);
        bVar.a(s8);
        bVar.a(i10);
        bVar.b(i11);
        bVar.a(i12);
        bVar.b(bVar.a(), 0);
        return bVar.b();
    }

    public static byte[] a(long j, long j8, String str, String str2, String str3, long j9, byte b9, int i9, String str4, String str5, String str6, String str7, int i10, int i11, String str8) {
        cn.jiguang.aj.b bVar = new cn.jiguang.aj.b(20480);
        bVar.b(0);
        bVar.a(30);
        bVar.a(1);
        bVar.b(j);
        bVar.a(0L);
        bVar.b(j8);
        bVar.a(97);
        bVar.a(0);
        bVar.b(0);
        bVar.a(str);
        bVar.a(str3);
        bVar.a(str2);
        bVar.a(0);
        bVar.a(j9);
        bVar.a((int) b9);
        bVar.a(i9);
        bVar.a(str4);
        bVar.a(str5);
        bVar.a(str6);
        bVar.a(str7);
        bVar.a(i10);
        bVar.a(i11);
        bVar.a(str8);
        bVar.b(bVar.a(), 0);
        return bVar.b();
    }

    public static byte[] a(long j, String str, String str2, String str3, String str4, long j8, String str5) {
        int iA = a();
        cn.jiguang.aj.b bVar = new cn.jiguang.aj.b(20480);
        bVar.b(0);
        bVar.a(38);
        bVar.a(0);
        bVar.b(j);
        bVar.a(iA);
        bVar.b(0L);
        bVar.a(str);
        bVar.a(str2);
        bVar.a(str3);
        bVar.a(0);
        bVar.a(str4);
        bVar.a(j8);
        bVar.a(str5);
        bVar.b(bVar.a(), 0);
        return bVar.b();
    }

    public static byte[] a(Context context, int i9, int i10, long j, byte[] bArr, long j8) {
        cn.jiguang.aj.b bVar = new cn.jiguang.aj.b(20480);
        bVar.b(0);
        bVar.a(i10);
        bVar.a(i9);
        bVar.b(j);
        bVar.a(JConstants.tcpSessionId);
        if (j8 == 0) {
            j8 = cn.jiguang.d.a.f(context);
        }
        bVar.b(j8);
        bVar.a(bArr);
        bVar.b(bVar.a(), 0);
        return a(context, bVar.b());
    }

    public static byte[] a(Context context, byte[] bArr) {
        return a(context, bArr, new byte[0]);
    }

    public static byte[] a(Context context, byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        int length = bArr.length - 24;
        byte[] bArr3 = new byte[24];
        byte[] bArr4 = new byte[length];
        System.arraycopy(bArr, 0, bArr3, 0, 24);
        System.arraycopy(bArr, 24, bArr4, 0, length);
        String strA = a(context);
        try {
            byte b9 = JConstants.tcpAlgorithm;
            byte[] bArrA = b9 == 2 ? new s().a(bArr4, strA) : t.a(bArr4, strA, strA.substring(0, 16), true);
            int length2 = bArr2 != null ? bArr2.length : 0;
            int i9 = length2 + 24;
            int length3 = bArrA.length + i9;
            byte[] bArr5 = new byte[length3];
            System.arraycopy(bArr3, 0, bArr5, 0, 24);
            if (length2 > 0) {
                System.arraycopy(bArr2, 0, bArr5, 24, length2);
            }
            System.arraycopy(bArrA, 0, bArr5, i9, bArrA.length);
            byte b10 = (byte) ((length3 >>> 8) & 255);
            bArr5[0] = b10;
            bArr5[1] = (byte) (length3 & 255);
            bArr5[0] = (byte) (b10 | 128);
            bArr5[4] = b9;
            return bArr5;
        } catch (Exception e9) {
            f.i("CorePackage", "e:" + e9);
            f.j("CorePackage", "encrpt data failed");
            return null;
        }
    }

    public static byte[] a(short s8, short s9, String str) {
        cn.jiguang.aj.b bVar = new cn.jiguang.aj.b(20480);
        bVar.a((int) s8);
        bVar.a((int) s9);
        bVar.a(str);
        return bVar.b();
    }

    private static byte[] a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }
}
