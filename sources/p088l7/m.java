package p088l7;

import android.util.Log;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import p096m7.j;
import p096m7.k;
import p096m7.l;
import p096m7.s;
import p168v4.f;

/* JADX INFO: compiled from: PlatformViewsChannel.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f20177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f20178b;

    /* JADX INFO: compiled from: PlatformViewsChannel.java */
    public class a implements l.c {
        public a() {
        }

        @Override // m7.l.c
        public final void onMethodCall(j jVar, l.d dVar) {
            boolean z8 = false;
            m mVar = m.this;
            if (mVar.f20178b == null) {
                return;
            }
            String str = jVar.f20496a;
            str.getClass();
            Object obj = jVar.f20497b;
            switch (str) {
                case "create":
                    Map map = (Map) obj;
                    boolean z9 = map.containsKey("hybrid") && ((Boolean) map.get("hybrid")).booleanValue();
                    ByteBuffer byteBufferWrap = map.containsKey(com.heytap.mcssdk.constant.b.f14278D) ? ByteBuffer.wrap((byte[]) map.get(com.heytap.mcssdk.constant.b.f14278D)) : null;
                    try {
                        if (z9) {
                            mVar.f20178b.e(new k(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), 0.0d, 0.0d, 0.0d, 0.0d, ((Integer) map.get(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION)).intValue(), k.a.f20160c, byteBufferWrap));
                            ((k) dVar).success(null);
                            return;
                        }
                        if (map.containsKey("hybridFallback") && ((Boolean) map.get("hybridFallback")).booleanValue()) {
                            z8 = true;
                        }
                        long jI = mVar.f20178b.i(new k(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), map.containsKey("top") ? ((Double) map.get("top")).doubleValue() : 0.0d, map.containsKey("left") ? ((Double) map.get("left")).doubleValue() : 0.0d, ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue(), ((Integer) map.get(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION)).intValue(), z8 ? k.a.f20159b : k.a.f20158a, byteBufferWrap));
                        if (jI != -2) {
                            ((k) dVar).success(Long.valueOf(jI));
                            return;
                        } else {
                            if (!z8) {
                                throw new AssertionError("Platform view attempted to fall back to hybrid mode when not requested.");
                            }
                            ((k) dVar).success(null);
                            return;
                        }
                    } catch (IllegalStateException e9) {
                        ((k) dVar).error("error", Log.getStackTraceString(e9), null);
                        return;
                    }
                case "offset":
                    Map map2 = (Map) obj;
                    try {
                        mVar.f20178b.c(((Integer) map2.get("id")).intValue(), ((Double) map2.get("top")).doubleValue(), ((Double) map2.get("left")).doubleValue());
                        ((k) dVar).success(null);
                        return;
                    } catch (IllegalStateException e10) {
                        ((k) dVar).error("error", Log.getStackTraceString(e10), null);
                        return;
                    }
                case "resize":
                    Map map3 = (Map) obj;
                    try {
                        mVar.f20178b.l(new b(((Integer) map3.get("id")).intValue(), ((Double) map3.get("width")).doubleValue(), ((Double) map3.get("height")).doubleValue()), new f((k) dVar));
                        return;
                    } catch (IllegalStateException e11) {
                        ((k) dVar).error("error", Log.getStackTraceString(e11), null);
                        return;
                    }
                case "clearFocus":
                    try {
                        mVar.f20178b.j(((Integer) obj).intValue());
                        ((k) dVar).success(null);
                        return;
                    } catch (IllegalStateException e12) {
                        ((k) dVar).error("error", Log.getStackTraceString(e12), null);
                        return;
                    }
                case "synchronizeToNativeViewHierarchy":
                    try {
                        mVar.f20178b.a(((Boolean) obj).booleanValue());
                        ((k) dVar).success(null);
                        return;
                    } catch (IllegalStateException e13) {
                        ((k) dVar).error("error", Log.getStackTraceString(e13), null);
                        return;
                    }
                case "touch":
                    List list = (List) obj;
                    try {
                        mVar.f20178b.g(new l(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue(), ((Number) list.get(15)).longValue()));
                        ((k) dVar).success(null);
                        return;
                    } catch (IllegalStateException e14) {
                        ((k) dVar).error("error", Log.getStackTraceString(e14), null);
                        return;
                    }
                case "setDirection":
                    Map map4 = (Map) obj;
                    try {
                        mVar.f20178b.d(((Integer) map4.get("id")).intValue(), ((Integer) map4.get(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION)).intValue());
                        ((k) dVar).success(null);
                        return;
                    } catch (IllegalStateException e15) {
                        ((k) dVar).error("error", Log.getStackTraceString(e15), null);
                        return;
                    }
                case "dispose":
                    try {
                        mVar.f20178b.m(((Integer) ((Map) obj).get("id")).intValue());
                        ((k) dVar).success(null);
                        return;
                    } catch (IllegalStateException e16) {
                        ((k) dVar).error("error", Log.getStackTraceString(e16), null);
                        return;
                    }
                default:
                    ((k) dVar).notImplemented();
                    return;
            }
        }
    }

    /* JADX INFO: compiled from: PlatformViewsChannel.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double f20181b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final double f20182c;

        public b(int i9, double d9, double d10) {
            this.f20180a = i9;
            this.f20181b = d9;
            this.f20182c = d10;
        }
    }

    /* JADX INFO: compiled from: PlatformViewsChannel.java */
    public interface c {
        void a(boolean z8);

        void c(int i9, double d9, double d10);

        void d(int i9, int i10);

        void e(k kVar);

        void g(l lVar);

        long i(k kVar);

        void j(int i9);

        void l(b bVar, f fVar);

        void m(int i9);
    }

    public m(p013b7.a aVar) {
        a aVar2 = new a();
        l lVar = new l(aVar, "flutter/platform_views", s.f20511a, null);
        this.f20177a = lVar;
        lVar.b(aVar2);
    }
}
