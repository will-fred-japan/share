package p088l7;

import java.util.HashMap;
import p096m7.j;
import p096m7.k;
import p096m7.l;
import p096m7.s;

/* JADX INFO: compiled from: RestorationChannel.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f20191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f20192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f20193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k f20194d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f20195e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f20196f;

    /* JADX INFO: compiled from: RestorationChannel.java */
    public class a implements l.c {
        public a() {
        }

        @Override // m7.l.c
        public final void onMethodCall(j jVar, l.d dVar) {
            String str = jVar.f20496a;
            str.getClass();
            q qVar = q.this;
            if (!str.equals("get")) {
                if (!str.equals("put")) {
                    ((k) dVar).notImplemented();
                    return;
                } else {
                    qVar.f20192b = (byte[]) jVar.f20497b;
                    ((k) dVar).success(null);
                    return;
                }
            }
            qVar.f20196f = true;
            if (!qVar.f20195e && qVar.f20191a) {
                qVar.f20194d = (k) dVar;
            } else {
                ((k) dVar).success(q.a(qVar.f20192b));
            }
        }
    }

    public q(p013b7.a aVar, boolean z8) {
        l lVar = new l(aVar, "flutter/restoration", s.f20511a, null);
        this.f20195e = false;
        this.f20196f = false;
        a aVar2 = new a();
        this.f20193c = lVar;
        this.f20191a = z8;
        lVar.b(aVar2);
    }

    public static HashMap a(byte[] bArr) {
        HashMap map = new HashMap();
        map.put("enabled", Boolean.TRUE);
        map.put("data", bArr);
        return map;
    }
}
