package io.flutter.plugin.platform;

import android.app.Activity;
import android.hardware.display.VirtualDisplay;
import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: VirtualDisplayController.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f19671i = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SingleViewPresentation f19672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Activity f19673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final io.flutter.plugin.platform.a f19674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f19675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f19676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h f19677f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l f19678g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public VirtualDisplay f19679h;

    /* JADX INFO: compiled from: VirtualDisplayController.java */
    public static class b implements ViewTreeObserver.OnDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f19680a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public w.a f19681b;

        /* JADX INFO: compiled from: VirtualDisplayController.java */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                b bVar = b.this;
                bVar.f19680a.getViewTreeObserver().removeOnDrawListener(bVar);
            }
        }

        public b(View view, w.a aVar) {
            this.f19680a = view;
            this.f19681b = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public final void onDraw() {
            w.a aVar = this.f19681b;
            if (aVar == null) {
                return;
            }
            aVar.run();
            this.f19681b = null;
            this.f19680a.post(new a());
        }
    }

    public v(Activity activity, io.flutter.plugin.platform.a aVar, VirtualDisplay virtualDisplay, e eVar, h hVar, l lVar, int i9) {
        this.f19673b = activity;
        this.f19674c = aVar;
        this.f19677f = hVar;
        this.f19678g = lVar;
        this.f19676e = i9;
        this.f19679h = virtualDisplay;
        this.f19675d = activity.getResources().getDisplayMetrics().densityDpi;
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(activity, this.f19679h.getDisplay(), eVar, aVar, i9, lVar);
        this.f19672a = singleViewPresentation;
        singleViewPresentation.show();
    }

    public final View a() {
        SingleViewPresentation singleViewPresentation = this.f19672a;
        if (singleViewPresentation == null) {
            return null;
        }
        return singleViewPresentation.getView().getView();
    }

    /* JADX INFO: compiled from: VirtualDisplayController.java */
    public class a extends VirtualDisplay.Callback {
        @Override // android.hardware.display.VirtualDisplay.Callback
        public final void onPaused() {
        }

        @Override // android.hardware.display.VirtualDisplay.Callback
        public final void onResumed() {
        }
    }
}
