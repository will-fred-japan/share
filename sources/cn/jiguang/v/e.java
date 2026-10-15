package cn.jiguang.v;

import android.content.Context;
import android.content.SharedPreferences;
import com.jieli.jl_bt_ota.constant.AttrAndFunCode;
import com.xiaomi.mipush.sdk.Constants;
import okio.Utf8;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f10799a = cn.jiguang.t.a.b(new byte[]{Utf8.REPLACEMENT_BYTE, 85, 88, 109, 75, 121, 127, 86, 73, 126});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f10800b = cn.jiguang.t.a.b(new byte[]{116, 72, 84, 52});

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10801c = cn.jiguang.t.a.b(new byte[]{32, 2, 69, 45, 61, 32, 38, 87, 25, 40, 99, 37, 37, 66, AttrAndFunCode.SYS_INFO_FUNCTION_LOW_POWER, 46});

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f10802d = cn.jiguang.t.a.b(new byte[]{33, 1, 16, 43, 56, 37, 33, 4, 16, 44, 56, 32, 33, 7, 16, 33});

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f10803e = cn.jiguang.t.a.b(new byte[]{85, 118, 97, 33, 60, 84, 32, 0, 98, 46, 73, 85, 85, 116, 18, 44});

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static SharedPreferences f10804f;

    public static String a(Context context, int i9, String str) {
        if (f10804f == null) {
            f10804f = context.getSharedPreferences(f10799a, 0);
        }
        String string = f10804f.getString(f10800b + str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i9, "");
        StringBuilder sb = new StringBuilder("g1:");
        sb.append(string);
        cn.jiguang.u.b.b("JC", sb.toString());
        if (!"".equals(string)) {
            try {
                string = new String(i.a(string, f10801c, f10802d));
            } catch (Exception unused) {
                cn.jiguang.u.b.b("JC", "decrypt plugin failed");
            }
        }
        cn.jiguang.u.b.b("JC", "g2:" + string);
        return string;
    }

    public static void a(Context context, int i9, String str, String str2, boolean z8) {
        int iA;
        String str3;
        if (z8) {
            iA = cn.jiguang.r.c.a().a(context, i9);
            cn.jiguang.dy.c.a().a(context, i9, iA, cn.jiguang.s.a.j, 0, null);
        } else {
            iA = -1;
        }
        if (f10804f == null) {
            f10804f = context.getSharedPreferences(f10799a, 0);
        }
        try {
            cn.jiguang.u.b.b("JC", "s1:" + str2);
            String strA = i.a(str2.getBytes(), f10801c, f10802d);
            try {
                cn.jiguang.u.b.b("JC", "s2:" + strA);
                str3 = strA;
            } catch (Throwable th) {
                th = th;
                str3 = strA;
                cn.jiguang.u.b.g("JC", "aesEncrypt error , msg :" + th.getMessage());
                if (z8) {
                    cn.jiguang.dy.c.a().a(context, i9, iA, cn.jiguang.s.a.j, 2, th.getMessage());
                }
            }
        } catch (Throwable th2) {
            th = th2;
            str3 = str2;
        }
        SharedPreferences.Editor editorEdit = f10804f.edit();
        editorEdit.putString(f10800b + str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i9, str3);
        editorEdit.commit();
        if (z8) {
            cn.jiguang.dy.c.a().a(context, i9, iA, cn.jiguang.s.a.j, 1, null);
            cn.jiguang.dy.c.a().a(context, i9, iA, cn.jiguang.s.a.f10752f, 1, null);
        }
    }
}
