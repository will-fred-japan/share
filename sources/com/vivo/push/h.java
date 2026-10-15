package com.vivo.push;

/* JADX INFO: compiled from: ClientSdkQueryResultDS.java */
/* JADX INFO: loaded from: classes.dex */
final class h implements com.vivo.push.restructure.request.a.a.c.a<g> {
    private static g b(String str) {
        try {
            return new g(new com.vivo.push.restructure.request.a.a.a(str));
        } catch (Exception e9) {
            com.vivo.push.util.w.a(8101, e9.getMessage());
            return null;
        }
    }

    @Override // com.vivo.push.restructure.request.a.a.c.a
    public final /* synthetic */ com.vivo.push.restructure.request.a.a.c a(String str) {
        return b(str);
    }
}
