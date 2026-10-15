package com.google.android.material.timepicker;

import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: ClockFaceView.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f13981a;

    public a(ClockFaceView clockFaceView) {
        this.f13981a = clockFaceView;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ClockFaceView clockFaceView = this.f13981a;
        if (!clockFaceView.isShown()) {
            return true;
        }
        clockFaceView.getViewTreeObserver().removeOnPreDrawListener(this);
        int height = ((clockFaceView.getHeight() / 2) - clockFaceView.f13958v.f13966d) - clockFaceView.f13951D;
        if (height != clockFaceView.t) {
            clockFaceView.t = height;
            clockFaceView.i();
            int i9 = clockFaceView.t;
            ClockHandView clockHandView = clockFaceView.f13958v;
            clockHandView.f13973l = i9;
            clockHandView.invalidate();
        }
        return true;
    }
}
