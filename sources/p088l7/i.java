package p088l7;

import p096m7.g;
import p096m7.j;
import p096m7.k;
import p096m7.l;

/* JADX INFO: compiled from: NavigationChannel.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f20132a;

    /* JADX INFO: compiled from: NavigationChannel.java */
    public class a implements l.c {
        @Override // m7.l.c
        public final void onMethodCall(j jVar, l.d dVar) {
            ((k) dVar).success(null);
        }
    }

    public i(p013b7.a aVar) {
        a aVar2 = new a();
        l lVar = new l(aVar, "flutter/navigation", g.f20495a, null);
        this.f20132a = lVar;
        lVar.b(aVar2);
    }
}
