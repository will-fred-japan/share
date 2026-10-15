package cn.jiguang.commons.a;

import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class hd {
    public static void a(af afVar, af afVar2) {
        if (afVar == null || afVar2 == null) {
            return;
        }
        if (afVar2.b() > 0) {
            afVar.a(afVar2.b());
        }
        if (afVar2.c() > 0) {
            afVar.b(afVar2.c());
        }
        if (afVar2.d() != null && !afVar2.d().isEmpty()) {
            afVar.b(afVar2.d());
        }
        if (afVar2.e() != 0) {
            afVar.c(afVar2.e());
        }
        if (afVar2.f() != 0 && (afVar.f() == 0 || Math.abs(afVar2.f()) < Math.abs(afVar.f()))) {
            afVar.d(afVar2.f());
        }
        if (afVar2.j() > 0) {
            afVar.f(afVar2.j());
        }
        if (afVar2.k() != Integer.MIN_VALUE) {
            afVar.g(afVar2.k());
        }
        if (afVar2.l() != null && !afVar2.l().isEmpty()) {
            afVar.d(afVar2.l());
        }
        if (afVar2.m() != 0) {
            afVar.h(afVar2.m());
        }
        if (afVar2.n() >= 0) {
            afVar.i(afVar2.n());
        }
        if (afVar2.o() >= 0) {
            afVar.j(afVar2.o());
        }
        if (afVar2.p() >= 0) {
            afVar.k(afVar2.p());
        }
        if (afVar2.q() != null && !afVar2.q().isEmpty()) {
            afVar.e(afVar2.q());
        }
        if (afVar2.r() != null && !afVar2.r().isEmpty()) {
            afVar.f(afVar2.r());
        }
        if (afVar2.s() >= 0) {
            afVar.l(afVar2.s());
        }
        if (afVar2.t() != null && !afVar2.t().isEmpty()) {
            for (Integer num : afVar2.t()) {
                if (!afVar.t().contains(num)) {
                    afVar.t().add(num);
                }
            }
        }
        if (afVar2.g() != null && !afVar2.g().isEmpty()) {
            for (String str : afVar2.g()) {
                if (!afVar.g().contains(str)) {
                    afVar.c(str);
                }
            }
        }
        if (afVar2.h() != null) {
            r rVarH = afVar.h();
            r rVarH2 = afVar2.h();
            if (rVarH == null) {
                afVar.a(rVarH2);
            } else {
                if (rVarH2.b() != -1) {
                    rVarH.a(rVarH2.b());
                }
                if (!TextUtils.isEmpty(rVarH2.c())) {
                    rVarH.a(rVarH2.c());
                }
                if (!rVarH2.d().isEmpty()) {
                    for (Integer num2 : rVarH2.d()) {
                        if (!rVarH.d().contains(num2)) {
                            rVarH.d().add(num2);
                        }
                    }
                }
                if (!TextUtils.isEmpty(rVarH2.e())) {
                    rVarH.b(rVarH2.e());
                }
                if (!rVarH2.f().isEmpty()) {
                    for (String str2 : rVarH2.f()) {
                        if (!rVarH.f().contains(str2)) {
                            rVarH.f().add(str2);
                        }
                    }
                }
                if (rVarH2.g() != Integer.MIN_VALUE) {
                    rVarH.b(rVarH2.g());
                }
                if (rVarH2.h() != 0) {
                    rVarH.c(rVarH2.h());
                }
                if (rVarH2.i() != 0) {
                    rVarH.d(rVarH2.i());
                }
                rVarH.e(rVarH2.j());
                List<String> listK = rVarH2.k();
                if (listK != null && !listK.isEmpty()) {
                    for (String str3 : listK) {
                        if (!rVarH.k().contains(str3)) {
                            rVarH.k().add(str3);
                        }
                    }
                }
                List<String> listL = rVarH2.l();
                if (listL != null && !listL.isEmpty()) {
                    for (String str4 : listL) {
                        if (!rVarH.l().contains(str4)) {
                            rVarH.l().add(str4);
                        }
                    }
                }
            }
        }
        if (afVar2.i() != null) {
            t tVarI = afVar.i();
            t tVarI2 = afVar2.i();
            if (tVarI == null) {
                afVar.a(tVarI2);
                return;
            }
            if (!TextUtils.isEmpty(tVarI2.b())) {
                tVarI.a(tVarI2.b());
            }
            if (tVarI2.c() != 0) {
                tVarI.a(tVarI2.c());
            }
            if (tVarI2.d() != 0) {
                tVarI.b(tVarI2.d());
            }
            if (tVarI2.e() != 0) {
                tVarI.c(tVarI2.e());
            }
        }
    }
}
