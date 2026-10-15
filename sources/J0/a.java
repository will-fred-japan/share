package J0;

import D0.h;
import G0.j;
import android.annotation.SuppressLint;
import android.graphics.Rect;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.k;
import y7.p;

/* JADX INFO: compiled from: SidecarAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f2646b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f2647a = h.f1832a;

    /* JADX INFO: renamed from: J0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SidecarAdapter.kt */
    public static final class C0023a {
        @SuppressLint({"BanUncheckedReflection"})
        public static int a(SidecarDeviceState sidecarDeviceState) {
            k.e(sidecarDeviceState, "sidecarDeviceState");
            try {
                return sidecarDeviceState.posture;
            } catch (NoSuchFieldError unused) {
                try {
                    Object objInvoke = SidecarDeviceState.class.getMethod("getPosture", new Class[0]).invoke(sidecarDeviceState, new Object[0]);
                    k.c(objInvoke, "null cannot be cast to non-null type kotlin.Int");
                    return ((Integer) objInvoke).intValue();
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                    return 0;
                }
            }
        }

        public static int b(SidecarDeviceState sidecarDeviceState) {
            k.e(sidecarDeviceState, "sidecarDeviceState");
            int iA = a(sidecarDeviceState);
            if (iA < 0 || iA > 4) {
                return 0;
            }
            return iA;
        }

        @SuppressLint({"BanUncheckedReflection"})
        public static List c(SidecarWindowLayoutInfo info) {
            p pVar = p.f22408a;
            k.e(info, "info");
            try {
                try {
                    List list = info.displayFeatures;
                    return list == null ? pVar : list;
                } catch (NoSuchFieldError unused) {
                    Object objInvoke = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", new Class[0]).invoke(info, new Object[0]);
                    k.c(objInvoke, "null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
                    return (List) objInvoke;
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        @SuppressLint({"BanUncheckedReflection"})
        public static void d(SidecarDeviceState sidecarDeviceState, int i9) {
            try {
                try {
                    sidecarDeviceState.posture = i9;
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                }
            } catch (NoSuchFieldError unused2) {
                SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(sidecarDeviceState, Integer.valueOf(i9));
            }
        }
    }

    public a(int i9) {
    }

    public static boolean a(SidecarDisplayFeature sidecarDisplayFeature, SidecarDisplayFeature sidecarDisplayFeature2) {
        if (k.a(sidecarDisplayFeature, sidecarDisplayFeature2)) {
            return true;
        }
        if (sidecarDisplayFeature == null || sidecarDisplayFeature2 == null || sidecarDisplayFeature.getType() != sidecarDisplayFeature2.getType()) {
            return false;
        }
        return k.a(sidecarDisplayFeature.getRect(), sidecarDisplayFeature2.getRect());
    }

    public static boolean b(List list, List list2) {
        if (list == list2) {
            return true;
        }
        if (list.size() == list2.size()) {
            int size = list.size();
            for (int i9 = 0; i9 < size; i9++) {
                if (a((SidecarDisplayFeature) list.get(i9), (SidecarDisplayFeature) list2.get(i9))) {
                }
            }
            return true;
        }
        return false;
    }

    public final j c(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarDeviceState sidecarDeviceState) {
        if (sidecarWindowLayoutInfo == null) {
            return new j(p.f22408a);
        }
        SidecarDeviceState sidecarDeviceState2 = new SidecarDeviceState();
        C0023a.d(sidecarDeviceState2, C0023a.b(sidecarDeviceState));
        return new j(d(C0023a.c(sidecarWindowLayoutInfo), sidecarDeviceState2));
    }

    public final ArrayList d(List list, SidecarDeviceState sidecarDeviceState) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            G0.d dVarE = e((SidecarDisplayFeature) it.next(), sidecarDeviceState);
            if (dVarE != null) {
                arrayList.add(dVarE);
            }
        }
        return arrayList;
    }

    public final G0.d e(SidecarDisplayFeature feature, SidecarDeviceState sidecarDeviceState) {
        G0.d.a aVar;
        G0.c.b bVar;
        k.e(feature, "feature");
        D0.a aVar2 = D0.a.f1810a;
        h verificationMode = this.f2647a;
        k.e(verificationMode, "verificationMode");
        SidecarDisplayFeature sidecarDisplayFeature = (SidecarDisplayFeature) new D0.g(feature, verificationMode, aVar2).u("Type must be either TYPE_FOLD or TYPE_HINGE", b.f2648a).u("Feature bounds must not be 0", c.f2649a).u("TYPE_FOLD must have 0 area", d.f2650a).u("Feature be pinned to either left or top", e.f2651a).d();
        if (sidecarDisplayFeature == null) {
            return null;
        }
        int type = sidecarDisplayFeature.getType();
        if (type == 1) {
            aVar = G0.d.a.f2219b;
        } else {
            if (type != 2) {
                return null;
            }
            aVar = G0.d.a.f2220c;
        }
        int iB = C0023a.b(sidecarDeviceState);
        if (iB == 0 || iB == 1) {
            return null;
        }
        if (iB != 2) {
            bVar = G0.c.b.f2213b;
            if (iB != 3 && iB == 4) {
                return null;
            }
        } else {
            bVar = G0.c.b.f2214c;
        }
        Rect rect = feature.getRect();
        k.d(rect, "feature.rect");
        return new G0.d(new D0.b(rect), aVar, bVar);
    }
}
