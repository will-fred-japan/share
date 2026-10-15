package p088l7;

import android.content.pm.PackageManager;
import java.util.ArrayList;
import p096m7.j;
import p096m7.k;
import p096m7.l;
import p096m7.s;

/* JADX INFO: compiled from: ProcessTextChannel.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PackageManager f20186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p121p7.a f20187b;

    /* JADX INFO: compiled from: ProcessTextChannel.java */
    public class a implements l.c {
        public a() {
        }

        @Override // m7.l.c
        public final void onMethodCall(j jVar, l.d dVar) {
            o oVar = o.this;
            if (oVar.f20187b == null) {
                return;
            }
            String str = jVar.f20496a;
            Object obj = jVar.f20497b;
            str.getClass();
            if (str.equals("ProcessText.processTextAction")) {
                try {
                    ArrayList arrayList = (ArrayList) obj;
                    oVar.f20187b.a((String) arrayList.get(0), (String) arrayList.get(1), ((Boolean) arrayList.get(2)).booleanValue(), (k) dVar);
                    return;
                } catch (IllegalStateException e9) {
                    ((k) dVar).error("error", e9.getMessage(), null);
                    return;
                }
            }
            if (!str.equals("ProcessText.queryTextActions")) {
                ((k) dVar).notImplemented();
                return;
            }
            try {
                ((k) dVar).success(oVar.f20187b.b());
            } catch (IllegalStateException e10) {
                ((k) dVar).error("error", e10.getMessage(), null);
            }
        }
    }

    public o(p013b7.a aVar, PackageManager packageManager) {
        a aVar2 = new a();
        this.f20186a = packageManager;
        new l(aVar, "flutter/processtext", s.f20511a, null).b(aVar2);
    }
}
