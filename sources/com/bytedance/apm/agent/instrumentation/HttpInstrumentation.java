package com.bytedance.apm.agent.instrumentation;

import java.net.HttpURLConnection;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import p061i1.g;
import p115p1.c;
import p149t1.a;
import p149t1.b;

/* JADX INFO: loaded from: classes.dex */
public final class HttpInstrumentation {
    public static URLConnection openConnection(URLConnection uRLConnection) {
        if (g.b().a()) {
            int i9 = c.f20774p;
            c cVar = c.a.f20785a;
            if (cVar.f20784o && (!cVar.j || !cVar.f20780k)) {
                return uRLConnection;
            }
            if (uRLConnection instanceof HttpsURLConnection) {
                return new b((HttpsURLConnection) uRLConnection);
            }
            if (uRLConnection instanceof HttpURLConnection) {
                return new a((HttpURLConnection) uRLConnection);
            }
        }
        return uRLConnection;
    }

    public static URLConnection openConnectionWithProxy(URLConnection uRLConnection) {
        if (g.b().a()) {
            int i9 = c.f20774p;
            c cVar = c.a.f20785a;
            if (cVar.f20784o && (!cVar.j || !cVar.f20780k)) {
                return uRLConnection;
            }
            if (uRLConnection instanceof HttpsURLConnection) {
                return new b((HttpsURLConnection) uRLConnection);
            }
            if (uRLConnection instanceof HttpURLConnection) {
                return new a((HttpURLConnection) uRLConnection);
            }
        }
        return uRLConnection;
    }
}
