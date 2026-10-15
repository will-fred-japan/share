package p088l7;

import android.os.Build;
import io.flutter.plugin.editing.c;
import p096m7.j;
import p096m7.k;
import p096m7.l;

/* JADX INFO: compiled from: ScribeChannel.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f20198a;

    /* JADX INFO: compiled from: ScribeChannel.java */
    public class a implements l.c {
        public a() {
        }

        @Override // m7.l.c
        public final void onMethodCall(j jVar, l.d dVar) {
            boolean z8 = true;
            r rVar = r.this;
            if (rVar.f20198a == null) {
                return;
            }
            String str = jVar.f20496a;
            str.getClass();
            switch (str) {
                case "Scribe.isFeatureAvailable":
                    try {
                        c cVar = rVar.f20198a;
                        if (Build.VERSION.SDK_INT >= 34) {
                            if (cVar.f19530a.isStylusHandwritingAvailable()) {
                            }
                            ((k) dVar).success(Boolean.valueOf(z8));
                            break;
                        } else {
                            cVar.getClass();
                        }
                        z8 = false;
                        ((k) dVar).success(Boolean.valueOf(z8));
                        break;
                    } catch (IllegalStateException e9) {
                        ((k) dVar).error("error", e9.getMessage(), null);
                        return;
                    }
                    break;
                case "Scribe.startStylusHandwriting":
                    if (Build.VERSION.SDK_INT >= 33) {
                        try {
                            c cVar2 = rVar.f20198a;
                            cVar2.f19530a.startStylusHandwriting(cVar2.f19531b);
                            ((k) dVar).success(null);
                        } catch (IllegalStateException e10) {
                            ((k) dVar).error("error", e10.getMessage(), null);
                            return;
                        }
                        break;
                    } else {
                        ((k) dVar).error("error", "Requires API level 33 or higher.", null);
                        break;
                    }
                    break;
                case "Scribe.isStylusHandwritingAvailable":
                    if (Build.VERSION.SDK_INT >= 34) {
                        try {
                            ((k) dVar).success(Boolean.valueOf(rVar.f20198a.f19530a.isStylusHandwritingAvailable()));
                        } catch (IllegalStateException e11) {
                            ((k) dVar).error("error", e11.getMessage(), null);
                            return;
                        }
                        break;
                    } else {
                        ((k) dVar).error("error", "Requires API level 34 or higher.", null);
                        break;
                    }
                    break;
                default:
                    ((k) dVar).notImplemented();
                    break;
            }
        }
    }
}
