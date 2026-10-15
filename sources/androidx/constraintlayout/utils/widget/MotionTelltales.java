package androidx.constraintlayout.utils.widget;

import android.graphics.Canvas;
import android.view.ViewParent;
import androidx.constraintlayout.motion.widget.MotionLayout;

/* JADX INFO: loaded from: classes.dex */
public class MotionTelltales extends MockView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MotionLayout f6794a;

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // androidx.constraintlayout.utils.widget.MockView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getMatrix().invert(null);
        if (this.f6794a != null) {
            getWidth();
            getHeight();
            this.f6794a.getClass();
            throw null;
        }
        ViewParent parent = getParent();
        if (parent instanceof MotionLayout) {
            this.f6794a = (MotionLayout) parent;
        }
    }

    @Override // android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        super.onLayout(z8, i9, i10, i11, i12);
        postInvalidate();
    }

    public void setText(CharSequence charSequence) {
        charSequence.toString();
        requestLayout();
    }
}
