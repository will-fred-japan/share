package androidx.constraintlayout.widget;

import A.m;
import C.d;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public abstract class VirtualLayout extends ConstraintHelper {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f6907i;
    public boolean j;

    public VirtualLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void g(AttributeSet attributeSet) {
        super.g(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.f1778b);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i9 = 0; i9 < indexCount; i9++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i9);
                if (index == 6) {
                    this.f6907i = true;
                } else if (index == 13) {
                    this.j = true;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public final void onAttachedToWindow() {
        ViewParent parent;
        super.onAttachedToWindow();
        if ((this.f6907i || this.j) && (parent = getParent()) != null && (parent instanceof ConstraintLayout)) {
            ConstraintLayout constraintLayout = (ConstraintLayout) parent;
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i9 = 0; i9 < this.f6798b; i9++) {
                View viewB = constraintLayout.b(this.f6797a[i9]);
                if (viewB != null) {
                    if (this.f6907i) {
                        viewB.setVisibility(visibility);
                    }
                    if (this.j && elevation > 0.0f) {
                        viewB.setTranslationZ(viewB.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f6) {
        super.setElevation(f6);
        d();
    }

    @Override // android.view.View
    public void setVisibility(int i9) {
        super.setVisibility(i9);
        d();
    }

    public void l(m mVar, int i9, int i10) {
    }
}
