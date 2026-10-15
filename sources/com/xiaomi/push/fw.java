package com.xiaomi.push;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class fw implements fu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private fu f17440a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static fw f17441a = new fw();
    }

    public static fw a() {
        return a.f17441a;
    }

    private fw() {
    }

    @Override // com.xiaomi.push.fu
    public void a(ft ftVar) {
        fu fuVar = this.f17440a;
        if (fuVar != null) {
            fuVar.a(ftVar);
        }
    }

    @Override // com.xiaomi.push.fu
    public void a(String str, Map<String, Object> map) {
        fu fuVar = this.f17440a;
        if (fuVar != null) {
            fuVar.a(str, map);
        }
    }
}
