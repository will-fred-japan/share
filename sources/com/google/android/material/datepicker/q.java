package com.google.android.material.datepicker;

import T.C0414a;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: compiled from: MaterialCalendarGridView.java */
/* JADX INFO: loaded from: classes.dex */
public final class q extends C0414a {
    @Override // T.C0414a
    public final void d(View view, U.f fVar) {
        View.AccessibilityDelegate accessibilityDelegate = this.f4401a;
        AccessibilityNodeInfo accessibilityNodeInfo = fVar.f4577a;
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(null);
    }
}
