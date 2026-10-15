package androidx.window.layout.adapter.sidecar;

import D0.i;
import G0.j;
import J0.g;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.window.layout.adapter.sidecar.SidecarCompat;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarProvider;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.k;
import y7.p;

/* JADX INFO: compiled from: SidecarCompat.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SidecarCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SidecarInterface f8457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final J0.a f8458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f8459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f8460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f8461e;

    /* JADX INFO: compiled from: SidecarCompat.kt */
    public final class TranslatingCallback implements SidecarInterface.SidecarCallback {
        public TranslatingCallback() {
        }

        public void onDeviceStateChanged(SidecarDeviceState newDeviceState) {
            SidecarInterface sidecarInterface;
            Window window;
            WindowManager.LayoutParams attributes;
            k.e(newDeviceState, "newDeviceState");
            Collection<Activity> collectionValues = SidecarCompat.this.f8459c.values();
            SidecarCompat sidecarCompat = SidecarCompat.this;
            for (Activity activity : collectionValues) {
                SidecarWindowLayoutInfo windowLayoutInfo = null;
                IBinder iBinder = (activity == null || (window = activity.getWindow()) == null || (attributes = window.getAttributes()) == null) ? null : attributes.token;
                if (iBinder != null && (sidecarInterface = sidecarCompat.f8457a) != null) {
                    windowLayoutInfo = sidecarInterface.getWindowLayoutInfo(iBinder);
                }
                b bVar = sidecarCompat.f8461e;
                if (bVar != null) {
                    bVar.a(activity, sidecarCompat.f8458b.c(windowLayoutInfo, newDeviceState));
                }
            }
        }

        public void onWindowLayoutChanged(IBinder windowToken, SidecarWindowLayoutInfo newLayout) {
            SidecarDeviceState sidecarDeviceState;
            k.e(windowToken, "windowToken");
            k.e(newLayout, "newLayout");
            Activity activity = (Activity) SidecarCompat.this.f8459c.get(windowToken);
            if (activity == null) {
                Log.w("SidecarCompat", "Unable to resolve activity from window token. Missing a call to #onWindowLayoutChangeListenerAdded()?");
                return;
            }
            SidecarCompat sidecarCompat = SidecarCompat.this;
            J0.a aVar = sidecarCompat.f8458b;
            SidecarInterface sidecarInterface = sidecarCompat.f8457a;
            if (sidecarInterface == null || (sidecarDeviceState = sidecarInterface.getDeviceState()) == null) {
                sidecarDeviceState = new SidecarDeviceState();
            }
            j jVarC = aVar.c(newLayout, sidecarDeviceState);
            b bVar = SidecarCompat.this.f8461e;
            if (bVar != null) {
                bVar.a(activity, jVarC);
            }
        }
    }

    /* JADX INFO: compiled from: SidecarCompat.kt */
    public static final class a {
        public static SidecarInterface a(Context context) {
            k.e(context, "context");
            return SidecarProvider.getSidecarImpl(context.getApplicationContext());
        }

        public static i b() {
            try {
                String apiVersion = SidecarProvider.getApiVersion();
                if (TextUtils.isEmpty(apiVersion)) {
                    return null;
                }
                i iVar = i.f1834f;
                return i.a.a(apiVersion);
            } catch (NoClassDefFoundError | UnsupportedOperationException unused) {
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: SidecarCompat.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g.a f8463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ReentrantLock f8464b = new ReentrantLock();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WeakHashMap<Activity, j> f8465c = new WeakHashMap<>();

        public b(g.a aVar) {
            this.f8463a = aVar;
        }

        public final void a(Activity activity, j jVar) {
            k.e(activity, "activity");
            ReentrantLock reentrantLock = this.f8464b;
            reentrantLock.lock();
            WeakHashMap<Activity, j> weakHashMap = this.f8465c;
            try {
                if (jVar.equals(weakHashMap.get(activity))) {
                    reentrantLock.unlock();
                    return;
                }
                weakHashMap.put(activity, jVar);
                reentrantLock.unlock();
                for (g.b bVar : g.this.f2657b) {
                    if (bVar.f2659a.equals(activity)) {
                        bVar.f2661c = jVar;
                        bVar.f2660b.accept(jVar);
                    }
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: SidecarCompat.kt */
    public static final class c implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SidecarCompat f8466a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakReference<Activity> f8467b;

        public c(SidecarCompat sidecarCompat, Activity activity) {
            k.e(sidecarCompat, "sidecarCompat");
            this.f8466a = sidecarCompat;
            this.f8467b = new WeakReference<>(activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            Window window;
            WindowManager.LayoutParams attributes;
            k.e(view, "view");
            view.removeOnAttachStateChangeListener(this);
            Activity activity = this.f8467b.get();
            IBinder iBinder = (activity == null || (window = activity.getWindow()) == null || (attributes = window.getAttributes()) == null) ? null : attributes.token;
            if (activity == null || iBinder == null) {
                return;
            }
            this.f8466a.c(iBinder, activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            k.e(view, "view");
        }
    }

    public SidecarCompat(Context context) {
        k.e(context, "context");
        SidecarInterface sidecarInterfaceA = a.a(context);
        J0.a aVar = new J0.a(0);
        this.f8457a = sidecarInterfaceA;
        this.f8458b = aVar;
        this.f8459c = new LinkedHashMap();
        this.f8460d = new LinkedHashMap();
    }

    public final j a(Activity activity) {
        SidecarDeviceState sidecarDeviceState;
        WindowManager.LayoutParams attributes;
        Window window = activity.getWindow();
        IBinder iBinder = (window == null || (attributes = window.getAttributes()) == null) ? null : attributes.token;
        if (iBinder == null) {
            return new j(p.f22408a);
        }
        SidecarInterface sidecarInterface = this.f8457a;
        SidecarWindowLayoutInfo windowLayoutInfo = sidecarInterface != null ? sidecarInterface.getWindowLayoutInfo(iBinder) : null;
        SidecarInterface sidecarInterface2 = this.f8457a;
        if (sidecarInterface2 == null || (sidecarDeviceState = sidecarInterface2.getDeviceState()) == null) {
            sidecarDeviceState = new SidecarDeviceState();
        }
        return this.f8458b.c(windowLayoutInfo, sidecarDeviceState);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(Activity activity) {
        SidecarInterface sidecarInterface;
        WindowManager.LayoutParams attributes;
        Window window = activity.getWindow();
        IBinder iBinder = (window == null || (attributes = window.getAttributes()) == null) ? null : attributes.token;
        if (iBinder == null) {
            return;
        }
        SidecarInterface sidecarInterface2 = this.f8457a;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerRemoved(iBinder);
        }
        LinkedHashMap linkedHashMap = this.f8460d;
        S.a<Configuration> aVar = (S.a) linkedHashMap.get(activity);
        if (aVar != null) {
            if (activity instanceof I.b) {
                ((I.b) activity).removeOnConfigurationChangedListener(aVar);
            }
            linkedHashMap.remove(activity);
        }
        b bVar = this.f8461e;
        if (bVar != null) {
            ReentrantLock reentrantLock = bVar.f8464b;
            reentrantLock.lock();
            try {
                bVar.f8465c.put(activity, null);
                p188x7.k kVar = p188x7.k.f22364a;
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        LinkedHashMap linkedHashMap2 = this.f8459c;
        boolean z8 = linkedHashMap2.size() == 1;
        linkedHashMap2.remove(iBinder);
        if (!z8 || (sidecarInterface = this.f8457a) == null) {
            return;
        }
        sidecarInterface.onDeviceStateListenersChanged(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(IBinder iBinder, final Activity activity) {
        SidecarInterface sidecarInterface;
        LinkedHashMap linkedHashMap = this.f8459c;
        linkedHashMap.put(iBinder, activity);
        SidecarInterface sidecarInterface2 = this.f8457a;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerAdded(iBinder);
        }
        if (linkedHashMap.size() == 1 && (sidecarInterface = this.f8457a) != null) {
            sidecarInterface.onDeviceStateListenersChanged(false);
        }
        b bVar = this.f8461e;
        if (bVar != null) {
            bVar.a(activity, a(activity));
        }
        LinkedHashMap linkedHashMap2 = this.f8460d;
        if (linkedHashMap2.get(activity) == null && (activity instanceof I.b)) {
            S.a<Configuration> aVar = new S.a() { // from class: J0.f
                @Override // S.a
                public final void accept(Object obj) {
                    SidecarCompat this$0 = this.f2652a;
                    k.e(this$0, "this$0");
                    Activity activity2 = activity;
                    k.e(activity2, "$activity");
                    SidecarCompat.b bVar2 = this$0.f8461e;
                    if (bVar2 != null) {
                        bVar2.a(activity2, this$0.a(activity2));
                    }
                }
            };
            linkedHashMap2.put(activity, aVar);
            ((I.b) activity).addOnConfigurationChangedListener(aVar);
        }
    }

    public final void d(g.a aVar) {
        this.f8461e = new b(aVar);
        SidecarInterface sidecarInterface = this.f8457a;
        if (sidecarInterface != null) {
            sidecarInterface.setSidecarCallback(new DistinctElementSidecarCallback(this.f8458b, new TranslatingCallback()));
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    public final boolean e() {
        Class<?> cls;
        Class<?> cls2;
        Class<?> cls3;
        Class<?> cls4;
        try {
            SidecarInterface sidecarInterface = this.f8457a;
            Method method = (sidecarInterface == null || (cls4 = sidecarInterface.getClass()) == null) ? null : cls4.getMethod("setSidecarCallback", SidecarInterface.SidecarCallback.class);
            Class<?> returnType = method != null ? method.getReturnType() : null;
            Class cls5 = Void.TYPE;
            if (!k.a(returnType, cls5)) {
                throw new NoSuchMethodException("Illegal return type for 'setSidecarCallback': " + returnType);
            }
            SidecarInterface sidecarInterface2 = this.f8457a;
            if (sidecarInterface2 != null) {
                sidecarInterface2.getDeviceState();
            }
            SidecarInterface sidecarInterface3 = this.f8457a;
            if (sidecarInterface3 != null) {
                sidecarInterface3.onDeviceStateListenersChanged(true);
            }
            SidecarInterface sidecarInterface4 = this.f8457a;
            Method method2 = (sidecarInterface4 == null || (cls3 = sidecarInterface4.getClass()) == null) ? null : cls3.getMethod("getWindowLayoutInfo", IBinder.class);
            Class<?> returnType2 = method2 != null ? method2.getReturnType() : null;
            if (!k.a(returnType2, SidecarWindowLayoutInfo.class)) {
                throw new NoSuchMethodException("Illegal return type for 'getWindowLayoutInfo': " + returnType2);
            }
            SidecarInterface sidecarInterface5 = this.f8457a;
            Method method3 = (sidecarInterface5 == null || (cls2 = sidecarInterface5.getClass()) == null) ? null : cls2.getMethod("onWindowLayoutChangeListenerAdded", IBinder.class);
            Class<?> returnType3 = method3 != null ? method3.getReturnType() : null;
            if (!k.a(returnType3, cls5)) {
                throw new NoSuchMethodException("Illegal return type for 'onWindowLayoutChangeListenerAdded': " + returnType3);
            }
            SidecarInterface sidecarInterface6 = this.f8457a;
            Method method4 = (sidecarInterface6 == null || (cls = sidecarInterface6.getClass()) == null) ? null : cls.getMethod("onWindowLayoutChangeListenerRemoved", IBinder.class);
            Class<?> returnType4 = method4 != null ? method4.getReturnType() : null;
            if (!k.a(returnType4, cls5)) {
                throw new NoSuchMethodException("Illegal return type for 'onWindowLayoutChangeListenerRemoved': " + returnType4);
            }
            SidecarDeviceState sidecarDeviceState = new SidecarDeviceState();
            try {
                sidecarDeviceState.posture = 3;
            } catch (NoSuchFieldError unused) {
                SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(sidecarDeviceState, 3);
                Object objInvoke = SidecarDeviceState.class.getMethod("getPosture", new Class[0]).invoke(sidecarDeviceState, new Object[0]);
                k.c(objInvoke, "null cannot be cast to non-null type kotlin.Int");
                if (((Integer) objInvoke).intValue() != 3) {
                    throw new Exception("Invalid device posture getter/setter");
                }
            }
            SidecarDisplayFeature sidecarDisplayFeature = new SidecarDisplayFeature();
            Rect rect = sidecarDisplayFeature.getRect();
            k.d(rect, "displayFeature.rect");
            sidecarDisplayFeature.setRect(rect);
            sidecarDisplayFeature.getType();
            sidecarDisplayFeature.setType(1);
            SidecarWindowLayoutInfo sidecarWindowLayoutInfo = new SidecarWindowLayoutInfo();
            try {
                List list = sidecarWindowLayoutInfo.displayFeatures;
            } catch (NoSuchFieldError unused2) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(sidecarDisplayFeature);
                SidecarWindowLayoutInfo.class.getMethod("setDisplayFeatures", List.class).invoke(sidecarWindowLayoutInfo, arrayList);
                Object objInvoke2 = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", new Class[0]).invoke(sidecarWindowLayoutInfo, new Object[0]);
                k.c(objInvoke2, "null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
                if (!arrayList.equals((List) objInvoke2)) {
                    throw new Exception("Invalid display feature getter/setter");
                }
            }
            return true;
        } catch (Throwable unused3) {
            return false;
        }
    }
}
