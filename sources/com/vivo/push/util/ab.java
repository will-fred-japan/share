package com.vivo.push.util;

/* JADX INFO: compiled from: OperateUtil.java */
/* JADX INFO: loaded from: classes.dex */
public final class ab {
    public static int a(com.vivo.push.b.c cVar) {
        ag agVarC = ag.c();
        int iB = cVar.b();
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iB2 = agVarC.b("com.vivo.push_preferences.operate." + iB + "OPERATE_COUNT", 0);
        long jB = jCurrentTimeMillis - agVarC.b(defpackage.f.b(iB, "com.vivo.push_preferences.operate.", "START_TIME"), 0L);
        if (jB > 86400000 || jB < 0) {
            agVarC.a(defpackage.f.b(iB, "com.vivo.push_preferences.operate.", "START_TIME"), System.currentTimeMillis());
            agVarC.a("com.vivo.push_preferences.operate." + iB + "OPERATE_COUNT", 1);
        } else {
            if (iB2 >= cVar.e()) {
                return 1001;
            }
            agVarC.a(defpackage.f.b(iB, "com.vivo.push_preferences.operate.", "OPERATE_COUNT"), iB2 + 1);
        }
        return 0;
    }
}
