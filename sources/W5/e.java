package W5;

import H5.l;
import U5.AbstractC0443e;
import U5.E;
import U5.F;
import U5.x;
import Z5.A;
import Z5.I;
import Z5.u;
import Z5.v;
import Z5.w;
import android.content.Context;
import androidx.datastore.preferences.protobuf.C0524s;
import cn.jpush.android.helper.Logger;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.google.android.material.carousel.MaskableFrameLayout;
import com.google.crypto.tink.shaded.protobuf.C0576o;
import com.google.crypto.tink.shaded.protobuf.C0586z;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.huawei.hms.support.log.HMSLog;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import okio.Path;
import p049g6.n;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements x.a, AbstractC0443e.a, ObjectConstructor, p057h6.c, l.b, p164v0.g.InterfaceC0272g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5064a;

    public /* synthetic */ e(int i9) {
        this.f5064a = i9;
    }

    public static int b(String str) throws NoSuchFieldException {
        for (int i9 : C0524s.c(8)) {
            String str2 = null;
            switch (i9) {
                case 1:
                    break;
                case 2:
                    str2 = "HapticFeedbackType.lightImpact";
                    break;
                case 3:
                    str2 = "HapticFeedbackType.mediumImpact";
                    break;
                case 4:
                    str2 = "HapticFeedbackType.heavyImpact";
                    break;
                case 5:
                    str2 = "HapticFeedbackType.selectionClick";
                    break;
                case 6:
                    str2 = "HapticFeedbackType.successNotification";
                    break;
                case 7:
                    str2 = "HapticFeedbackType.warningNotification";
                    break;
                case 8:
                    str2 = "HapticFeedbackType.errorNotification";
                    break;
                default:
                    throw null;
            }
            if ((str2 == null && str == null) || (str2 != null && str2.equals(str))) {
                return i9;
            }
        }
        throw new NoSuchFieldException(l("No such HapticFeedbackType: ", str));
    }

    public static char g(int i9, int i10, int i11, JSONLexerBase jSONLexerBase) {
        return jSONLexerBase.charAt(i9 + i10 + i11);
    }

    public static String h(int i9, int i10, String str, String str2) {
        return str + i9 + str2 + i10;
    }

    public static String i(int i9, String str) {
        return str + i9;
    }

    public static String j(Class cls, String str) {
        return str + cls;
    }

    public static String k(Object obj, String str) {
        return str + obj;
    }

    public static String l(String str, String str2) {
        return str + str2;
    }

    public static String m(StringBuilder sb, long j, String str) {
        sb.append(j);
        sb.append(str);
        return sb.toString();
    }

    public static String n(Path path, String str) {
        return str + path;
    }

    public static void o(int i9, String str, String str2) {
        HMSLog.i(str2, str + i9);
    }

    public static void p(int i9, HashMap map, String str, int i10, String str2) {
        map.put(str, Integer.valueOf(i9));
        map.put(str2, Integer.valueOf(i10));
    }

    public static void q(Exception exc, String str, String str2) {
        p199z2.b.l(exc, new StringBuilder(str), str2);
    }

    public static void r(String str, String str2, String str3) {
        Logger.d(str3, str + str2);
    }

    public static void s(String str, String str2, Throwable th) {
        Logger.d(str2, str + th);
    }

    public static void t(Throwable th, StringBuilder sb, String str) {
        sb.append(th.getMessage());
        cn.jiguang.x.f.i(str, sb.toString());
    }

    public static String u(String str, String str2) {
        return str + str2;
    }

    @Override // H5.l.b
    public H5.d a(H5.d dVar) {
        int i9 = MaskableFrameLayout.f13103c;
        return dVar instanceof H5.a ? new H5.c(((H5.a) dVar).f2415a) : dVar;
    }

    @Override // p057h6.c
    public p057h6.a c(Context context, n nVar) {
        return new p057h6.e(context, nVar);
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        switch (this.f5064a) {
            case 12:
                return ConstructorConstructor.lambda$newMapConstructor$16();
            default:
                return ConstructorConstructor.lambda$newCollectionConstructor$12();
        }
    }

    @Override // U5.AbstractC0443e.a
    public A0.h d(E e9) throws GeneralSecurityException {
        if (!e9.f4676a.equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
        }
        try {
            v vVarL = v.L(e9.f4678c, C0576o.a());
            if (vVarL.J() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            V5.h.a aVarB = V5.h.b();
            aVarB.f4870a = Integer.valueOf(vVarL.H().size());
            aVarB.f4871b = Integer.valueOf(vVarL.I().I());
            aVarB.f4872c = (V5.h.b) g.f5067b.g(vVarL.I().H());
            aVarB.f4873d = (V5.h.c) g.f5066a.g(e9.f4680e);
            V5.h hVarA = aVarB.a();
            V5.f.a aVar = new V5.f.a();
            aVar.f4858b = null;
            aVar.f4859c = null;
            aVar.f4857a = hVarA;
            aVar.f4858b = new J6.a(5, p012b6.a.a(vVarL.H().o()));
            aVar.f4859c = e9.f4681f;
            return aVar.a();
        } catch (C0586z | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing HmacKey failed");
        }
    }

    @Override // p164v0.g.InterfaceC0272g
    public void e(v0.g.f fVar, p164v0.g gVar, boolean z8) {
        switch (this.f5064a) {
            case 22:
                fVar.a(gVar);
                break;
            default:
                fVar.b();
                break;
        }
    }

    @Override // U5.x.a
    public F f(L5.n nVar) {
        V5.h hVar = (V5.h) nVar;
        A.a aVarL = A.L();
        aVarL.m("type.googleapis.com/google.crypto.tink.HmacKey");
        w.a aVarK = w.K();
        Z5.x.a aVarJ = Z5.x.J();
        int i9 = hVar.f4867b;
        aVarJ.i();
        Z5.x.E((Z5.x) aVarJ.f14171b, i9);
        u uVar = (u) g.f5067b.l(hVar.f4869d);
        aVarJ.i();
        Z5.x.D((Z5.x) aVarJ.f14171b, uVar);
        Z5.x xVarF = aVarJ.f();
        aVarK.i();
        w.D((w) aVarK.f14171b, xVarF);
        aVarK.i();
        w.E((w) aVarK.f14171b, hVar.f4866a);
        aVarL.n(aVarK.f().c());
        aVarL.l((I) g.f5066a.l(hVar.f4868c));
        return F.a(aVarL.f());
    }
}
