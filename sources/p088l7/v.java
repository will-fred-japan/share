package p088l7;

import io.flutter.plugin.editing.d;
import java.util.ArrayList;
import p096m7.j;
import p096m7.k;
import p096m7.l;

/* JADX INFO: compiled from: SpellCheckChannel.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f20212a;

    /* JADX INFO: compiled from: SpellCheckChannel.java */
    public class a implements l.c {
        public a() {
        }

        @Override // m7.l.c
        public final void onMethodCall(j jVar, l.d dVar) {
            v vVar = v.this;
            if (vVar.f20212a == null) {
                return;
            }
            String str = jVar.f20496a;
            Object obj = jVar.f20497b;
            str.getClass();
            if (!str.equals("SpellCheck.initiateSpellCheck")) {
                ((k) dVar).notImplemented();
                return;
            }
            try {
                ArrayList arrayList = (ArrayList) obj;
                vVar.f20212a.a((String) arrayList.get(0), (String) arrayList.get(1), (k) dVar);
            } catch (IllegalStateException e9) {
                ((k) dVar).error("error", e9.getMessage(), null);
            }
        }
    }
}
