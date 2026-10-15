package p088l7;

import io.flutter.embedding.android.b;
import io.flutter.embedding.android.c;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import p096m7.j;
import p096m7.k;
import p096m7.l;

/* JADX INFO: compiled from: KeyboardChannel.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f20115a;

    /* JADX INFO: compiled from: KeyboardChannel.java */
    public class a implements l.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map<Long, Long> f20116a = new HashMap();

        public a() {
        }

        @Override // m7.l.c
        public final void onMethodCall(j jVar, l.d dVar) {
            e eVar = e.this;
            if (eVar.f20115a == null) {
                ((k) dVar).success(this.f20116a);
                return;
            }
            String str = jVar.f20496a;
            str.getClass();
            if (!str.equals("getKeyboardState")) {
                ((k) dVar).notImplemented();
                return;
            }
            try {
                this.f20116a = Collections.unmodifiableMap(((b) eVar.f20115a.f19387a[0]).f19384b);
            } catch (IllegalStateException e9) {
                ((k) dVar).error("error", e9.getMessage(), null);
            }
            ((k) dVar).success(this.f20116a);
        }
    }
}
