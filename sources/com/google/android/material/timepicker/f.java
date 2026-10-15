package com.google.android.material.timepicker;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;

/* JADX INFO: compiled from: TimePickerView.java */
/* JADX INFO: loaded from: classes.dex */
public final class f implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GestureDetector f13986a;

    public f(GestureDetector gestureDetector) {
        this.f13986a = gestureDetector;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (((Checkable) view).isChecked()) {
            return this.f13986a.onTouchEvent(motionEvent);
        }
        return false;
    }
}
