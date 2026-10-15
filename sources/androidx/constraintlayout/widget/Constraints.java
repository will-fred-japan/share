package androidx.constraintlayout.widget;

import C.d;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class Constraints extends ViewGroup {

    public static class a extends ConstraintLayout.a {

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        public float f6891m0;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        public boolean f6892n0;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        public float f6893o0;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public float f6894p0;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        public float f6895q0;

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        public float f6896r0;

        /* JADX INFO: renamed from: s0, reason: collision with root package name */
        public float f6897s0;

        /* JADX INFO: renamed from: t0, reason: collision with root package name */
        public float f6898t0;

        /* JADX INFO: renamed from: u0, reason: collision with root package name */
        public float f6899u0;

        /* JADX INFO: renamed from: v0, reason: collision with root package name */
        public float f6900v0;

        /* JADX INFO: renamed from: w0, reason: collision with root package name */
        public float f6901w0;

        /* JADX INFO: renamed from: x0, reason: collision with root package name */
        public float f6902x0;

        /* JADX INFO: renamed from: y0, reason: collision with root package name */
        public float f6903y0;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        a aVar = new a();
        aVar.f6891m0 = 1.0f;
        aVar.f6892n0 = false;
        aVar.f6893o0 = 0.0f;
        aVar.f6894p0 = 0.0f;
        aVar.f6895q0 = 0.0f;
        aVar.f6896r0 = 0.0f;
        aVar.f6897s0 = 1.0f;
        aVar.f6898t0 = 1.0f;
        aVar.f6899u0 = 0.0f;
        aVar.f6900v0 = 0.0f;
        aVar.f6901w0 = 0.0f;
        aVar.f6902x0 = 0.0f;
        aVar.f6903y0 = 0.0f;
        return aVar;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        a aVar = new a(context, attributeSet);
        aVar.f6891m0 = 1.0f;
        aVar.f6892n0 = false;
        aVar.f6893o0 = 0.0f;
        aVar.f6894p0 = 0.0f;
        aVar.f6895q0 = 0.0f;
        aVar.f6896r0 = 0.0f;
        aVar.f6897s0 = 1.0f;
        aVar.f6898t0 = 1.0f;
        aVar.f6899u0 = 0.0f;
        aVar.f6900v0 = 0.0f;
        aVar.f6901w0 = 0.0f;
        aVar.f6902x0 = 0.0f;
        aVar.f6903y0 = 0.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.f1779c);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i9 = 0; i9 < indexCount; i9++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i9);
            if (index == 15) {
                aVar.f6891m0 = typedArrayObtainStyledAttributes.getFloat(index, aVar.f6891m0);
            } else if (index == 28) {
                aVar.f6893o0 = typedArrayObtainStyledAttributes.getFloat(index, aVar.f6893o0);
                aVar.f6892n0 = true;
            } else if (index == 23) {
                aVar.f6895q0 = typedArrayObtainStyledAttributes.getFloat(index, aVar.f6895q0);
            } else if (index == 24) {
                aVar.f6896r0 = typedArrayObtainStyledAttributes.getFloat(index, aVar.f6896r0);
            } else if (index == 22) {
                aVar.f6894p0 = typedArrayObtainStyledAttributes.getFloat(index, aVar.f6894p0);
            } else if (index == 20) {
                aVar.f6897s0 = typedArrayObtainStyledAttributes.getFloat(index, aVar.f6897s0);
            } else if (index == 21) {
                aVar.f6898t0 = typedArrayObtainStyledAttributes.getFloat(index, aVar.f6898t0);
            } else if (index == 16) {
                aVar.f6899u0 = typedArrayObtainStyledAttributes.getFloat(index, aVar.f6899u0);
            } else if (index == 17) {
                aVar.f6900v0 = typedArrayObtainStyledAttributes.getFloat(index, aVar.f6900v0);
            } else if (index == 18) {
                aVar.f6901w0 = typedArrayObtainStyledAttributes.getFloat(index, aVar.f6901w0);
            } else if (index == 19) {
                aVar.f6902x0 = typedArrayObtainStyledAttributes.getFloat(index, aVar.f6902x0);
            } else if (index == 27) {
                aVar.f6903y0 = typedArrayObtainStyledAttributes.getFloat(index, aVar.f6903y0);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return aVar;
    }

    public b getConstraintSet() {
        getChildCount();
        throw null;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.a(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
    }
}
