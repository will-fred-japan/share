package p088l7;

import android.os.Build;
import defpackage.f;
import p096m7.j;
import p096m7.k;
import p096m7.l;
import p129q7.b;

/* JADX INFO: compiled from: SensitiveContentChannel.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f20200a;

    /* JADX INFO: compiled from: SensitiveContentChannel.java */
    public class a implements l.c {
        public a() {
        }

        @Override // m7.l.c
        public final void onMethodCall(j jVar, l.d dVar) {
            int i9 = 2;
            s sVar = s.this;
            if (sVar.f20200a == null) {
                return;
            }
            String str = jVar.f20496a;
            str.getClass();
            switch (str) {
                case "SensitiveContent.getContentSensitivity":
                    try {
                        int iA = sVar.f20200a.a();
                        if (iA == 0) {
                            i9 = 0;
                        } else if (iA == 1) {
                            i9 = 1;
                        } else if (iA != 2) {
                            i9 = 3;
                        }
                        ((k) dVar).success(Integer.valueOf(i9));
                        return;
                    } catch (IllegalArgumentException | IllegalStateException e9) {
                        ((k) dVar).error("error", e9.getMessage(), null);
                        return;
                    }
                case "SensitiveContent.setContentSensitivity":
                    int iIntValue = ((Integer) jVar.f20497b).intValue();
                    try {
                        b bVar = sVar.f20200a;
                        sVar.getClass();
                        if (iIntValue == 0) {
                            i9 = 0;
                        } else if (iIntValue == 1) {
                            i9 = 1;
                        } else if (iIntValue != 2) {
                            throw new IllegalArgumentException(f.b(iIntValue, "contentSensitivityIndex ", " not known to the SensitiveContentChannel."));
                        }
                        bVar.b(i9);
                        return;
                    } catch (IllegalArgumentException e10) {
                        e = e10;
                        ((k) dVar).error("error", e.getMessage(), null);
                        return;
                    } catch (IllegalStateException e11) {
                        e = e11;
                        ((k) dVar).error("error", e.getMessage(), null);
                        return;
                    }
                case "SensitiveContent.isSupported":
                    sVar.f20200a.getClass();
                    ((k) dVar).success(Boolean.valueOf(Build.VERSION.SDK_INT >= 35));
                    return;
                default:
                    ((k) dVar).notImplemented();
                    return;
            }
        }
    }
}
