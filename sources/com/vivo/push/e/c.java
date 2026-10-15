package com.vivo.push.e;

import com.vivo.push.util.w;

/* JADX INFO: compiled from: ProfileInfoDS.java */
/* JADX INFO: loaded from: classes.dex */
final class c implements com.vivo.push.restructure.request.a.a.c.a<b> {
    private static b b(String str) {
        try {
            return new b(new com.vivo.push.restructure.request.a.a.a(str));
        } catch (Exception e9) {
            w.a(8101, e9.getMessage());
            return null;
        }
    }

    @Override // com.vivo.push.restructure.request.a.a.c.a
    public final /* synthetic */ com.vivo.push.restructure.request.a.a.c a(String str) {
        return b(str);
    }
}
