package p164v0;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: compiled from: ViewUtilsApi29.java */
/* JADX INFO: loaded from: classes.dex */
public final class u extends t {
    @Override // p164v0.q
    public final float a(View view) {
        return view.getTransitionAlpha();
    }

    @Override // p164v0.q
    public final void b(View view, float f6) {
        view.setTransitionAlpha(f6);
    }

    @Override // p164v0.t, p164v0.q
    public final void c(View view, int i9) {
        view.setTransitionVisibility(i9);
    }

    @Override // p164v0.r
    public final void d(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // p164v0.r
    public final void e(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }

    @Override // p164v0.s
    public final void f(View view, int i9, int i10, int i11, int i12) {
        view.setLeftTopRightBottom(i9, i10, i11, i12);
    }
}
