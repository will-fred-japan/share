package defpackage;

import android.content.Context;
import cn.jiguang.commons.a.ee;
import cn.jpush.android.helper.Logger;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.huawei.secure.android.common.encrypt.utils.b;
import com.huawei.secure.android.common.ssl.util.e;
import p049g6.n;
import p057h6.a;
import p057h6.c;
import p057h6.d;
import p164v0.g;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements ObjectConstructor, c, g.InterfaceC0272g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18641a;

    public /* synthetic */ f(int i9) {
        this.f18641a = i9;
    }

    public static int a(int i9, int i10, int i11, int i12) {
        return ((i9 + i10) - i11) - i12;
    }

    public static String b(int i9, String str, String str2) {
        return str + i9 + str2;
    }

    public static String d(long j, String str) {
        return str + j;
    }

    public static String f(String str, String str2, String str3, Throwable th) {
        return str + th + str2 + str3;
    }

    public static String g(StringBuilder sb, boolean z8, char c5) {
        sb.append(z8);
        sb.append(c5);
        return sb.toString();
    }

    public static StringBuilder h(long j, String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(j);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder i(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static void j(long j, StringBuilder sb, String str, String str2) {
        sb.append(System.currentTimeMillis() - j);
        sb.append(str);
        e.a(str2, sb.toString());
    }

    public static void k(Exception exc, StringBuilder sb, String str) {
        sb.append(exc.getMessage());
        b.b(str, sb.toString());
    }

    public static void l(String str, String str2, Throwable th) {
        cn.jiguang.x.f.i(str2, str + th);
    }

    public static void m(StringBuilder sb, StringBuilder sb2) {
        sb.append(System.currentTimeMillis());
        sb2.append(sb.toString());
    }

    public static void n(Throwable th, StringBuilder sb, String str) {
        sb.append(th.getMessage());
        ee.d(str, sb.toString());
    }

    public static void o(String str, String str2, Throwable th) {
        Logger.w(str2, str + th);
    }

    public static void p(String str, String str2, Throwable th) {
        Logger.ww(str2, str + th);
    }

    public static void q(String str, String str2, Throwable th) {
        com.xiaomi.channel.commonutils.logger.c.c(str2, str + th);
    }

    @Override // p057h6.c
    public a c(Context context, n nVar) {
        return new d(context, nVar);
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        switch (this.f18641a) {
            case 9:
                return ConstructorConstructor.lambda$newMapConstructor$15();
            case 10:
                return ConstructorConstructor.lambda$newMapConstructor$18();
            default:
                return ConstructorConstructor.lambda$newCollectionConstructor$11();
        }
    }

    @Override // p164v0.g.InterfaceC0272g
    public void e(g.f fVar, g gVar, boolean z8) {
        fVar.f(gVar);
    }
}
