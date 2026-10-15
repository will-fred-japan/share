package io.flutter.plugin.platform;

import android.content.Context;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/* JADX INFO: compiled from: SingleViewFakeWindowViewGroup.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f19659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f19660b;

    public r(Context context) {
        super(context);
        this.f19659a = new Rect();
        this.f19660b = new Rect();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        for (int i13 = 0; i13 < getChildCount(); i13++) {
            View childAt = getChildAt(i13);
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) childAt.getLayoutParams();
            this.f19659a.set(i9, i10, i11, i12);
            Gravity.apply(layoutParams.gravity, childAt.getMeasuredWidth(), childAt.getMeasuredHeight(), this.f19659a, layoutParams.x, layoutParams.y, this.f19660b);
            Rect rect = this.f19660b;
            childAt.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i9, int i10) {
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            getChildAt(i11).measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i9), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i10), Integer.MIN_VALUE));
        }
        super.onMeasure(i9, i10);
    }
}
