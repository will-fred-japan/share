package p088l7;

import org.json.JSONException;
import org.json.JSONObject;
import p096m7.j;
import p096m7.k;
import p096m7.l;

/* JADX INFO: compiled from: LocalizationChannel.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f20127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p105n7.a.C0237a f20128b;

    /* JADX INFO: compiled from: LocalizationChannel.java */
    public class a implements l.c {
        public a() {
        }

        @Override // m7.l.c
        public final void onMethodCall(j jVar, l.d dVar) {
            g gVar = g.this;
            if (gVar.f20128b == null) {
                return;
            }
            String str = jVar.f20496a;
            str.getClass();
            if (!str.equals("Localization.getStringResource")) {
                ((k) dVar).notImplemented();
                return;
            }
            JSONObject jSONObject = (JSONObject) jVar.f20497b;
            try {
                ((k) dVar).success(gVar.f20128b.a(jSONObject.getString("key"), jSONObject.has("locale") ? jSONObject.getString("locale") : null));
            } catch (JSONException e9) {
                ((k) dVar).error("error", e9.getMessage(), null);
            }
        }
    }

    public g(p013b7.a aVar) {
        a aVar2 = new a();
        l lVar = new l(aVar, "flutter/localization", p096m7.g.f20495a, null);
        this.f20127a = lVar;
        lVar.b(aVar2);
    }
}
