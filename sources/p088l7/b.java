package p088l7;

import android.window.BackEvent;
import java.util.Arrays;
import java.util.HashMap;
import p096m7.j;
import p096m7.k;
import p096m7.l;
import p096m7.s;

/* JADX INFO: compiled from: BackGestureChannel.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f20112a;

    /* JADX INFO: compiled from: BackGestureChannel.java */
    public class a implements l.c {
        @Override // m7.l.c
        public final void onMethodCall(j jVar, l.d dVar) {
            ((k) dVar).success(null);
        }
    }

    public b(p013b7.a aVar) {
        a aVar2 = new a();
        l lVar = new l(aVar, "flutter/backgesture", s.f20511a, null);
        this.f20112a = lVar;
        lVar.b(aVar2);
    }

    public static HashMap a(BackEvent backEvent) {
        HashMap map = new HashMap(3);
        float touchX = backEvent.getTouchX();
        float touchY = backEvent.getTouchY();
        map.put("touchOffset", (Float.isNaN(touchX) || Float.isNaN(touchY)) ? null : Arrays.asList(Float.valueOf(touchX), Float.valueOf(touchY)));
        map.put("progress", Float.valueOf(backEvent.getProgress()));
        map.put("swipeEdge", Integer.valueOf(backEvent.getSwipeEdge()));
        return map;
    }
}
