package com.google.android.material.timepicker;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: compiled from: TimePickerView.java */
/* JADX INFO: loaded from: classes.dex */
public final class e extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TimePickerView f13985a;

    public e(TimePickerView timePickerView) {
        this.f13985a = timePickerView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        int i9 = TimePickerView.t;
        this.f13985a.getClass();
        return false;
    }
}
