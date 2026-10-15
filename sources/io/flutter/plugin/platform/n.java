package io.flutter.plugin.platform;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.datastore.preferences.protobuf.C0524s;
import io.flutter.embedding.android.FlutterImageView;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorView;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.view.TextureRegistry;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: PlatformViewsController.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n implements i {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Class[] f19616x = {SurfaceView.class};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Z6.a f19618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Activity f19619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FlutterView f19620d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextureRegistry f19622f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public io.flutter.plugin.editing.f f19623g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public p088l7.m f19624h;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Z6.p f19635u;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FlutterJNI f19621e = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f19631p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f19632q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f19633r = true;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f19636v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final a f19637w = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final J6.a f19617a = new J6.a();
    public final HashMap<Integer, v> j = new HashMap<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final io.flutter.plugin.platform.a f19625i = new io.flutter.plugin.platform.a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final HashMap<Context, View> f19626k = new HashMap<>();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final SparseArray<PlatformOverlayView> f19629n = new SparseArray<>();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final HashSet<Integer> f19634s = new HashSet<>();
    public final HashSet<Integer> t = new HashSet<>();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final SparseArray<PlatformViewWrapper> f19630o = new SparseArray<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final SparseArray<e> f19627l = new SparseArray<>();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final SparseArray<FlutterMutatorView> f19628m = new SparseArray<>();

    /* JADX INFO: compiled from: PlatformViewsController.java */
    public class a implements l7.m.c {
        public a() {
        }

        @Override // l7.m.c
        public final void a(boolean z8) {
            n.this.f19633r = z8;
        }

        @Override // l7.m.c
        public final void c(int i9, double d9, double d10) {
            n nVar = n.this;
            if (nVar.f(i9)) {
                return;
            }
            PlatformViewWrapper platformViewWrapper = nVar.f19630o.get(i9);
            if (platformViewWrapper == null) {
                Log.e("PlatformViewsController", "Setting offset for unknown platform view with id: " + i9);
            } else {
                int iO = nVar.o(d9);
                int iO2 = nVar.o(d10);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) platformViewWrapper.getLayoutParams();
                layoutParams.topMargin = iO;
                layoutParams.leftMargin = iO2;
                platformViewWrapper.setLayoutParams(layoutParams);
            }
        }

        @Override // l7.m.c
        public final void d(int i9, int i10) {
            View view;
            if (i10 != 0 && i10 != 1) {
                throw new IllegalStateException("Trying to set unknown direction value: " + i10 + "(view id: " + i9 + ")");
            }
            n nVar = n.this;
            if (nVar.f(i9)) {
                view = nVar.j.get(Integer.valueOf(i9)).a();
            } else {
                e eVar = nVar.f19627l.get(i9);
                if (eVar == null) {
                    Log.e("PlatformViewsController", "Setting direction to an unknown view with id: " + i9);
                    return;
                }
                view = eVar.getView();
            }
            if (view != null) {
                view.setLayoutDirection(i10);
                return;
            }
            Log.e("PlatformViewsController", "Setting direction to a null view with id: " + i9);
        }

        @Override // l7.m.c
        public final void e(p088l7.k kVar) {
            n nVar = n.this;
            nVar.getClass();
            n.e(19);
            n.a(nVar, kVar);
            if (nVar.f19621e.IsSurfaceControlEnabled()) {
                throw new IllegalStateException("Trying to create a Hybrid Composition view with HC++ enabled.");
            }
            nVar.c(kVar, false);
            n.e(19);
            if (nVar.f19621e.IsSurfaceControlEnabled()) {
                throw new IllegalStateException("Trying to create a Hybrid Composition view with HC++ enabled.");
            }
        }

        @Override // l7.m.c
        public final void g(p088l7.l lVar) {
            n nVar = n.this;
            float f6 = nVar.f19619c.getResources().getDisplayMetrics().density;
            int i9 = lVar.f20162a;
            if (nVar.f(i9)) {
                v vVar = nVar.j.get(Integer.valueOf(i9));
                MotionEvent motionEventN = nVar.n(f6, lVar, true);
                SingleViewPresentation singleViewPresentation = vVar.f19672a;
                if (singleViewPresentation == null) {
                    return;
                }
                singleViewPresentation.dispatchTouchEvent(motionEventN);
                return;
            }
            e eVar = nVar.f19627l.get(i9);
            if (eVar == null) {
                Log.e("PlatformViewsController", "Sending touch to an unknown view with id: " + i9);
                return;
            }
            View view = eVar.getView();
            if (view != null) {
                view.dispatchTouchEvent(nVar.n(f6, lVar, false));
                return;
            }
            Log.e("PlatformViewsController", "Sending touch to a null view with id: " + i9);
        }

        /* JADX WARN: Type inference failed for: r3v3, types: [io.flutter.plugin.platform.l] */
        @Override // l7.m.c
        @SuppressLint({"NewApi"})
        public final long i(final p088l7.k kVar) {
            PlatformViewWrapper platformViewWrapper;
            long j;
            final n nVar = n.this;
            n.a(nVar, kVar);
            SparseArray<PlatformViewWrapper> sparseArray = nVar.f19630o;
            int i9 = kVar.f20149a;
            if (sparseArray.get(i9) != null) {
                throw new IllegalStateException(W5.e.i(i9, "Trying to create an already created platform view, view id: "));
            }
            if (nVar.f19622f == null) {
                throw new IllegalStateException(W5.e.i(i9, "Texture registry is null. This means that platform views controller was detached, view id: "));
            }
            if (nVar.f19620d == null) {
                throw new IllegalStateException(W5.e.i(i9, "Flutter view is null. This means the platform views controller doesn't have an attached view, view id: "));
            }
            e eVarC = nVar.c(kVar, true);
            View view = eVarC.getView();
            if (view.getParent() != null) {
                throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
            }
            boolean zC = p170v7.b.c(view, new R3.e(14, n.f19616x));
            double d9 = kVar.f20152d;
            double d10 = kVar.f20151c;
            if (zC) {
                if (kVar.f20156h == l7.k.a.f20159b) {
                    n.e(19);
                    if (nVar.f19621e.IsSurfaceControlEnabled()) {
                        throw new IllegalStateException("Trying to create a Hybrid Composition view with HC++ enabled.");
                    }
                    return -2L;
                }
                if (!nVar.f19636v) {
                    n.e(20);
                    h hVarL = n.l(nVar.f19622f);
                    int iO = nVar.o(d10);
                    int iO2 = nVar.o(d9);
                    Activity activity = nVar.f19619c;
                    ?? r8 = new View.OnFocusChangeListener() { // from class: io.flutter.plugin.platform.l
                        @Override // android.view.View.OnFocusChangeListener
                        public final void onFocusChange(View view2, boolean z8) {
                            n nVar2 = nVar;
                            if (!z8) {
                                nVar2.getClass();
                                return;
                            }
                            p088l7.m mVar = nVar2.f19624h;
                            p088l7.k kVar2 = kVar;
                            p096m7.l lVar = mVar.f20177a;
                            if (lVar == null) {
                                return;
                            }
                            lVar.a("viewFocused", Integer.valueOf(kVar2.f20149a), null);
                        }
                    };
                    v.a aVar = v.f19671i;
                    v vVar = null;
                    if (iO != 0 && iO2 != 0) {
                        DisplayManager displayManager = (DisplayManager) activity.getSystemService("display");
                        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
                        hVarL.b(iO, iO2);
                        StringBuilder sb = new StringBuilder("flutter-vd#");
                        int i10 = kVar.f20149a;
                        sb.append(i10);
                        VirtualDisplay virtualDisplayCreateVirtualDisplay = displayManager.createVirtualDisplay(sb.toString(), iO, iO2, displayMetrics.densityDpi, hVarL.getSurface(), 0, v.f19671i, null);
                        if (virtualDisplayCreateVirtualDisplay != null) {
                            vVar = new v(activity, nVar.f19625i, virtualDisplayCreateVirtualDisplay, eVarC, hVarL, r8, i10);
                        }
                    }
                    if (vVar != null) {
                        nVar.j.put(Integer.valueOf(i9), vVar);
                        View view2 = eVarC.getView();
                        nVar.f19626k.put(view2.getContext(), view2);
                        return hVarL.a();
                    }
                    throw new IllegalStateException("Failed creating virtual display for a " + kVar.f20150b + " with id: " + i9);
                }
            }
            n.e(23);
            int iO3 = nVar.o(d10);
            int iO4 = nVar.o(d9);
            if (nVar.f19636v) {
                platformViewWrapper = new PlatformViewWrapper(nVar.f19619c);
                j = -1;
            } else {
                h hVarL2 = n.l(nVar.f19622f);
                PlatformViewWrapper platformViewWrapper2 = new PlatformViewWrapper(nVar.f19619c);
                platformViewWrapper2.f19577f = hVarL2;
                Surface surface = hVarL2.getSurface();
                if (surface != null) {
                    Canvas canvasLockHardwareCanvas = surface.lockHardwareCanvas();
                    try {
                        canvasLockHardwareCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                        surface.unlockCanvasAndPost(canvasLockHardwareCanvas);
                    } catch (Throwable th) {
                        surface.unlockCanvasAndPost(canvasLockHardwareCanvas);
                        throw th;
                    }
                }
                long jA = hVarL2.a();
                platformViewWrapper = platformViewWrapper2;
                j = jA;
            }
            platformViewWrapper.setTouchProcessor(nVar.f19618b);
            h hVar = platformViewWrapper.f19577f;
            if (hVar != null) {
                hVar.b(iO3, iO4);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iO3, iO4);
            int iO5 = nVar.o(kVar.f20153e);
            int iO6 = nVar.o(kVar.f20154f);
            layoutParams.topMargin = iO5;
            layoutParams.leftMargin = iO6;
            platformViewWrapper.setLayoutParams(layoutParams);
            View view3 = eVarC.getView();
            view3.setLayoutParams(new FrameLayout.LayoutParams(iO3, iO4));
            view3.setImportantForAccessibility(4);
            platformViewWrapper.addView(view3);
            platformViewWrapper.setOnDescendantFocusChangeListener(new View.OnFocusChangeListener() { // from class: io.flutter.plugin.platform.k
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view4, boolean z8) {
                    p088l7.k kVar2 = kVar;
                    n nVar2 = nVar;
                    int i11 = kVar2.f20149a;
                    if (z8) {
                        p096m7.l lVar = nVar2.f19624h.f20177a;
                        if (lVar == null) {
                            return;
                        }
                        lVar.a("viewFocused", Integer.valueOf(i11), null);
                        return;
                    }
                    io.flutter.plugin.editing.f fVar = nVar2.f19623g;
                    if (fVar != null) {
                        fVar.b(i11);
                    }
                }
            });
            nVar.f19620d.addView(platformViewWrapper);
            sparseArray.append(i9, platformViewWrapper);
            FlutterView flutterView = nVar.f19620d;
            if (flutterView == null) {
                return j;
            }
            eVarC.onFlutterViewAttached(flutterView);
            return j;
        }

        @Override // l7.m.c
        public final void j(int i9) {
            View view;
            n nVar = n.this;
            if (nVar.f(i9)) {
                view = nVar.j.get(Integer.valueOf(i9)).a();
            } else {
                e eVar = nVar.f19627l.get(i9);
                if (eVar == null) {
                    Log.e("PlatformViewsController", "Clearing focus on an unknown view with id: " + i9);
                    return;
                }
                view = eVar.getView();
            }
            if (view != null) {
                view.clearFocus();
                return;
            }
            Log.e("PlatformViewsController", "Clearing focus on a null view with id: " + i9);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v7, types: [io.flutter.plugin.platform.m, java.lang.Runnable] */
        @Override // l7.m.c
        public final void l(l7.m.b bVar, final p168v4.f fVar) {
            h hVar;
            n nVar = n.this;
            int iO = nVar.o(bVar.f20181b);
            int iO2 = nVar.o(bVar.f20182c);
            int i9 = bVar.f20180a;
            if (!nVar.f(i9)) {
                e eVar = nVar.f19627l.get(i9);
                PlatformViewWrapper platformViewWrapper = nVar.f19630o.get(i9);
                if (eVar == null || platformViewWrapper == null) {
                    Log.e("PlatformViewsController", "Resizing unknown platform view with id: " + i9);
                    return;
                }
                if ((iO > platformViewWrapper.getRenderTargetWidth() || iO2 > platformViewWrapper.getRenderTargetHeight()) && (hVar = platformViewWrapper.f19577f) != null) {
                    hVar.b(iO, iO2);
                }
                ViewGroup.LayoutParams layoutParams = platformViewWrapper.getLayoutParams();
                layoutParams.width = iO;
                layoutParams.height = iO2;
                platformViewWrapper.setLayoutParams(layoutParams);
                View view = eVar.getView();
                if (view != null) {
                    ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                    layoutParams2.width = iO;
                    layoutParams2.height = iO2;
                    view.setLayoutParams(layoutParams2);
                }
                int iRound = (int) Math.round(((double) platformViewWrapper.getRenderTargetWidth()) / ((double) nVar.i()));
                int iRound2 = (int) Math.round(((double) platformViewWrapper.getRenderTargetHeight()) / ((double) nVar.i()));
                p096m7.k kVar = fVar.f21909a;
                HashMap map = new HashMap();
                map.put("width", Double.valueOf(iRound));
                map.put("height", Double.valueOf(iRound2));
                kVar.success(map);
                return;
            }
            final float fI = nVar.i();
            final v vVar = nVar.j.get(Integer.valueOf(i9));
            io.flutter.plugin.editing.f fVar2 = nVar.f19623g;
            if (fVar2 != null) {
                if (fVar2.f19548e.f19561a == io.flutter.plugin.editing.f.c.a.f19565c) {
                    fVar2.f19558p = true;
                }
                SingleViewPresentation singleViewPresentation = vVar.f19672a;
                if (singleViewPresentation != null && singleViewPresentation.getView() != null) {
                    vVar.f19672a.getView().onInputConnectionLocked();
                }
            }
            ?? r8 = new Runnable() { // from class: io.flutter.plugin.platform.m
                @Override // java.lang.Runnable
                public final void run() {
                    n nVar2 = n.this;
                    io.flutter.plugin.editing.f fVar3 = nVar2.f19623g;
                    v vVar2 = vVar;
                    if (fVar3 != null) {
                        if (fVar3.f19548e.f19561a == io.flutter.plugin.editing.f.c.a.f19565c) {
                            fVar3.f19558p = false;
                        }
                        SingleViewPresentation singleViewPresentation2 = vVar2.f19672a;
                        if (singleViewPresentation2 != null && singleViewPresentation2.getView() != null) {
                            vVar2.f19672a.getView().onInputConnectionUnlocked();
                        }
                    }
                    double dI = nVar2.f19619c == null ? fI : nVar2.i();
                    int iRound3 = (int) Math.round(((double) vVar2.f19677f.getWidth()) / dI);
                    int iRound4 = (int) Math.round(((double) vVar2.f19677f.getHeight()) / dI);
                    p096m7.k kVar2 = fVar.f21909a;
                    HashMap map2 = new HashMap();
                    map2.put("width", Double.valueOf(iRound3));
                    map2.put("height", Double.valueOf(iRound4));
                    kVar2.success(map2);
                }
            };
            int width = vVar.f19677f.getWidth();
            h hVar2 = vVar.f19677f;
            if (iO == width && iO2 == hVar2.getHeight()) {
                vVar.a().postDelayed(r8, 0L);
                return;
            }
            if (Build.VERSION.SDK_INT >= 31) {
                View viewA = vVar.a();
                hVar2.b(iO, iO2);
                vVar.f19679h.resize(iO, iO2, vVar.f19675d);
                vVar.f19679h.setSurface(hVar2.getSurface());
                viewA.postDelayed(r8, 0L);
                return;
            }
            boolean zIsFocused = vVar.a().isFocused();
            SingleViewPresentation.d dVarDetachState = vVar.f19672a.detachState();
            vVar.f19679h.setSurface(null);
            vVar.f19679h.release();
            DisplayManager displayManager = (DisplayManager) vVar.f19673b.getSystemService("display");
            hVar2.b(iO, iO2);
            vVar.f19679h = displayManager.createVirtualDisplay("flutter-vd#" + vVar.f19676e, iO, iO2, vVar.f19675d, hVar2.getSurface(), 0, v.f19671i, null);
            View viewA2 = vVar.a();
            viewA2.addOnAttachStateChangeListener(new w(viewA2, r8));
            SingleViewPresentation singleViewPresentation2 = new SingleViewPresentation(vVar.f19673b, vVar.f19679h.getDisplay(), vVar.f19674c, dVarDetachState, vVar.f19678g, zIsFocused);
            singleViewPresentation2.show();
            vVar.f19672a.cancel();
            vVar.f19672a = singleViewPresentation2;
        }

        @Override // l7.m.c
        public final void m(int i9) {
            PlatformViewWrapper.a aVar;
            n nVar = n.this;
            e eVar = nVar.f19627l.get(i9);
            if (eVar == null) {
                Log.e("PlatformViewsController", "Disposing unknown platform view with id: " + i9);
                return;
            }
            if (eVar.getView() != null) {
                View view = eVar.getView();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
            }
            nVar.f19627l.remove(i9);
            try {
                eVar.dispose();
            } catch (RuntimeException e9) {
                Log.e("PlatformViewsController", "Disposing platform view threw an exception", e9);
            }
            if (nVar.f(i9)) {
                HashMap<Integer, v> map = nVar.j;
                v vVar = map.get(Integer.valueOf(i9));
                View viewA = vVar.a();
                if (viewA != null) {
                    nVar.f19626k.remove(viewA.getContext());
                }
                vVar.f19672a.cancel();
                vVar.f19672a.detachState();
                vVar.f19679h.release();
                vVar.f19677f.release();
                map.remove(Integer.valueOf(i9));
                return;
            }
            SparseArray<PlatformViewWrapper> sparseArray = nVar.f19630o;
            PlatformViewWrapper platformViewWrapper = sparseArray.get(i9);
            if (platformViewWrapper == null) {
                SparseArray<FlutterMutatorView> sparseArray2 = nVar.f19628m;
                FlutterMutatorView flutterMutatorView = sparseArray2.get(i9);
                if (flutterMutatorView != null) {
                    flutterMutatorView.removeAllViews();
                    flutterMutatorView.a();
                    ViewGroup viewGroup2 = (ViewGroup) flutterMutatorView.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(flutterMutatorView);
                    }
                    sparseArray2.remove(i9);
                    return;
                }
                return;
            }
            platformViewWrapper.removeAllViews();
            h hVar = platformViewWrapper.f19577f;
            if (hVar != null) {
                hVar.release();
                platformViewWrapper.f19577f = null;
            }
            ViewTreeObserver viewTreeObserver = platformViewWrapper.getViewTreeObserver();
            if (viewTreeObserver.isAlive() && (aVar = platformViewWrapper.f19578g) != null) {
                platformViewWrapper.f19578g = null;
                viewTreeObserver.removeOnGlobalFocusChangeListener(aVar);
            }
            ViewGroup viewGroup3 = (ViewGroup) platformViewWrapper.getParent();
            if (viewGroup3 != null) {
                viewGroup3.removeView(platformViewWrapper);
            }
            sparseArray.remove(i9);
        }
    }

    public n() {
        if (Z6.p.f5605c == null) {
            Z6.p.f5605c = new Z6.p();
        }
        this.f19635u = Z6.p.f5605c;
    }

    public static void a(n nVar, p088l7.k kVar) {
        nVar.getClass();
        int i9 = kVar.f20155g;
        if (i9 != 0 && i9 != 1) {
            throw new IllegalStateException(A.f.i(C0524s.a(i9, "Trying to create a view with unknown direction value: ", "(view id: "), kVar.f20149a, ")"));
        }
    }

    public static void e(int i9) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < i9) {
            throw new IllegalStateException(W5.e.h(i10, i9, "Trying to use platform views with API ", ", required API level is: "));
        }
    }

    public static h l(TextureRegistry textureRegistry) {
        int i9 = Build.VERSION.SDK_INT;
        if (i9 < 29) {
            return i9 >= 29 ? new b(((FlutterRenderer) textureRegistry).b()) : new u(((FlutterRenderer) textureRegistry).d());
        }
        TextureRegistry.SurfaceProducer surfaceProducerC = ((FlutterRenderer) textureRegistry).c(i9 <= 34 ? TextureRegistry.c.f19703b : TextureRegistry.c.f19702a);
        t tVar = new t();
        tVar.f19663a = surfaceProducerC;
        return tVar;
    }

    @Override // io.flutter.plugin.platform.i
    public final void b(io.flutter.view.b bVar) {
        this.f19625i.f19590a = bVar;
    }

    public final e c(p088l7.k kVar, boolean z8) {
        HashMap map = (HashMap) this.f19617a.f2691b;
        String str = kVar.f20150b;
        f fVar = (f) map.get(str);
        if (fVar == null) {
            throw new IllegalStateException("Trying to create a platform view of unregistered type: " + str);
        }
        ByteBuffer byteBuffer = kVar.f20157i;
        Object objB = byteBuffer != null ? fVar.getCreateArgsCodec().b(byteBuffer) : null;
        Context mutableContextWrapper = z8 ? new MutableContextWrapper(this.f19619c) : this.f19619c;
        int i9 = kVar.f20149a;
        e eVarCreate = fVar.create(mutableContextWrapper, i9, objB);
        View view = eVarCreate.getView();
        if (view == null) {
            throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
        }
        view.setLayoutDirection(kVar.f20155g);
        this.f19627l.put(i9, eVarCreate);
        FlutterView flutterView = this.f19620d;
        if (flutterView == null) {
            return eVarCreate;
        }
        eVarCreate.onFlutterViewAttached(flutterView);
        return eVarCreate;
    }

    public final void d() {
        int i9 = 0;
        while (true) {
            SparseArray<PlatformOverlayView> sparseArray = this.f19629n;
            if (i9 >= sparseArray.size()) {
                return;
            }
            PlatformOverlayView platformOverlayViewValueAt = sparseArray.valueAt(i9);
            platformOverlayViewValueAt.b();
            platformOverlayViewValueAt.f19322a.close();
            i9++;
        }
    }

    @Override // io.flutter.plugin.platform.i
    public final boolean f(int i9) {
        return this.j.containsKey(Integer.valueOf(i9));
    }

    public final void g(boolean z8) {
        int i9 = 0;
        while (true) {
            SparseArray<PlatformOverlayView> sparseArray = this.f19629n;
            if (i9 >= sparseArray.size()) {
                break;
            }
            int iKeyAt = sparseArray.keyAt(i9);
            PlatformOverlayView platformOverlayViewValueAt = sparseArray.valueAt(i9);
            if (this.f19634s.contains(Integer.valueOf(iKeyAt))) {
                io.flutter.embedding.engine.a aVar = this.f19620d.j;
                if (aVar != null) {
                    platformOverlayViewValueAt.c(aVar.f19408b);
                }
                z8 &= platformOverlayViewValueAt.d();
            } else {
                if (!this.f19632q) {
                    platformOverlayViewValueAt.b();
                }
                platformOverlayViewValueAt.setVisibility(8);
                this.f19620d.removeView(platformOverlayViewValueAt);
            }
            i9++;
        }
        int i10 = 0;
        while (true) {
            SparseArray<FlutterMutatorView> sparseArray2 = this.f19628m;
            if (i10 >= sparseArray2.size()) {
                return;
            }
            int iKeyAt2 = sparseArray2.keyAt(i10);
            FlutterMutatorView flutterMutatorView = sparseArray2.get(iKeyAt2);
            if (!this.t.contains(Integer.valueOf(iKeyAt2)) || (!z8 && this.f19633r)) {
                flutterMutatorView.setVisibility(8);
            } else {
                flutterMutatorView.setVisibility(0);
            }
            i10++;
        }
    }

    @Override // io.flutter.plugin.platform.i
    public final View h(int i9) {
        if (f(i9)) {
            return this.j.get(Integer.valueOf(i9)).a();
        }
        e eVar = this.f19627l.get(i9);
        if (eVar == null) {
            return null;
        }
        return eVar.getView();
    }

    public final float i() {
        return this.f19619c.getResources().getDisplayMetrics().density;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.View, io.flutter.embedding.engine.renderer.f] */
    public final void j() {
        if (!this.f19633r || this.f19632q) {
            return;
        }
        FlutterView flutterView = this.f19620d;
        flutterView.f19353f.pause();
        FlutterImageView flutterImageView = flutterView.f19352e;
        if (flutterImageView == null) {
            FlutterImageView flutterImageView2 = new FlutterImageView(flutterView.getContext(), flutterView.getWidth(), flutterView.getHeight(), FlutterImageView.a.f19329a);
            flutterView.f19352e = flutterImageView2;
            flutterView.addView(flutterImageView2);
        } else {
            flutterImageView.f(flutterView.getWidth(), flutterView.getHeight());
        }
        flutterView.f19354g = flutterView.f19353f;
        FlutterImageView flutterImageView3 = flutterView.f19352e;
        flutterView.f19353f = flutterImageView3;
        io.flutter.embedding.engine.a aVar = flutterView.j;
        if (aVar != null) {
            flutterImageView3.c(aVar.f19408b);
        }
        this.f19632q = true;
    }

    @Override // io.flutter.plugin.platform.i
    public final void k() {
        this.f19625i.f19590a = null;
    }

    public final void m() {
        for (v vVar : this.j.values()) {
            int width = vVar.f19677f.getWidth();
            h hVar = vVar.f19677f;
            int height = hVar.getHeight();
            boolean zIsFocused = vVar.a().isFocused();
            SingleViewPresentation.d dVarDetachState = vVar.f19672a.detachState();
            vVar.f19679h.setSurface(null);
            vVar.f19679h.release();
            vVar.f19679h = ((DisplayManager) vVar.f19673b.getSystemService("display")).createVirtualDisplay("flutter-vd#" + vVar.f19676e, width, height, vVar.f19675d, hVar.getSurface(), 0, v.f19671i, null);
            SingleViewPresentation singleViewPresentation = new SingleViewPresentation(vVar.f19673b, vVar.f19679h.getDisplay(), vVar.f19674c, dVarDetachState, vVar.f19678g, zIsFocused);
            singleViewPresentation.show();
            vVar.f19672a.cancel();
            vVar.f19672a = singleViewPresentation;
        }
    }

    public final MotionEvent n(float f6, p088l7.l lVar, boolean z8) {
        MotionEvent motionEventA = this.f19635u.a(new Z6.p.a(lVar.f20176p));
        List<List> list = (List) lVar.f20168g;
        ArrayList arrayList = new ArrayList();
        for (List list2 : list) {
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            pointerCoords.orientation = (float) ((Double) list2.get(0)).doubleValue();
            pointerCoords.pressure = (float) ((Double) list2.get(1)).doubleValue();
            pointerCoords.size = (float) ((Double) list2.get(2)).doubleValue();
            double d9 = f6;
            pointerCoords.toolMajor = (float) (((Double) list2.get(3)).doubleValue() * d9);
            pointerCoords.toolMinor = (float) (((Double) list2.get(4)).doubleValue() * d9);
            pointerCoords.touchMajor = (float) (((Double) list2.get(5)).doubleValue() * d9);
            pointerCoords.touchMinor = (float) (((Double) list2.get(6)).doubleValue() * d9);
            pointerCoords.x = (float) (((Double) list2.get(7)).doubleValue() * d9);
            pointerCoords.y = (float) (((Double) list2.get(8)).doubleValue() * d9);
            arrayList.add(pointerCoords);
        }
        int i9 = lVar.f20166e;
        MotionEvent.PointerCoords[] pointerCoordsArr = (MotionEvent.PointerCoords[]) arrayList.toArray(new MotionEvent.PointerCoords[i9]);
        List<List> list3 = (List) lVar.f20167f;
        ArrayList arrayList2 = new ArrayList();
        for (List list4 : list3) {
            MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
            pointerProperties.id = ((Integer) list4.get(0)).intValue();
            pointerProperties.toolType = ((Integer) list4.get(1)).intValue();
            arrayList2.add(pointerProperties);
        }
        MotionEvent.PointerProperties[] pointerPropertiesArr = (MotionEvent.PointerProperties[]) arrayList2.toArray(new MotionEvent.PointerProperties[i9]);
        if (z8 || motionEventA == null) {
            return MotionEvent.obtain(lVar.f20163b.longValue(), lVar.f20164c.longValue(), lVar.f20165d, lVar.f20166e, pointerPropertiesArr, pointerCoordsArr, lVar.f20169h, lVar.f20170i, lVar.j, lVar.f20171k, lVar.f20172l, lVar.f20173m, lVar.f20174n, lVar.f20175o);
        }
        if (motionEventA.getPointerCount() == i9 && motionEventA.getAction() == lVar.f20165d) {
            if (pointerCoordsArr.length < 1) {
                return motionEventA;
            }
            motionEventA.offsetLocation(pointerCoordsArr[0].x - motionEventA.getX(), pointerCoordsArr[0].y - motionEventA.getY());
            return motionEventA;
        }
        return MotionEvent.obtain(motionEventA.getDownTime(), motionEventA.getEventTime(), lVar.f20165d, lVar.f20166e, pointerPropertiesArr, pointerCoordsArr, motionEventA.getMetaState(), motionEventA.getButtonState(), motionEventA.getXPrecision(), motionEventA.getYPrecision(), motionEventA.getDeviceId(), motionEventA.getEdgeFlags(), motionEventA.getSource(), motionEventA.getFlags());
    }

    public final int o(double d9) {
        return (int) Math.round(d9 * ((double) i()));
    }
}
