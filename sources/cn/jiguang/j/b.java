package cn.jiguang.j;

import android.text.TextUtils;
import cn.jiguang.aw.v;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f10576a = 1;

    public static long a() {
        long j = f10576a + 1;
        f10576a = j;
        if (j >= 2147483647L) {
            f10576a = 1L;
        }
        return f10576a;
    }

    public static byte[] a(long j, String str) {
        cn.jiguang.k.a aVar = new cn.jiguang.k.a(20480);
        aVar.a(0);
        aVar.a(j);
        if (str != null && !TextUtils.isEmpty(str)) {
            aVar.a(v.j(str));
        }
        return aVar.a();
    }
}
