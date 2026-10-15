package androidx.constraintlayout.motion.widget;

import C.d;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: classes.dex */
public class MotionHelper extends ConstraintHelper implements MotionLayout.b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f6763i;
    public boolean j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f6764k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View[] f6765l;

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void g(AttributeSet attributeSet) {
        super.g(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.f1783g);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i9 = 0; i9 < indexCount; i9++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i9);
                if (index == 1) {
                    this.f6763i = typedArrayObtainStyledAttributes.getBoolean(index, this.f6763i);
                } else if (index == 0) {
                    this.j = typedArrayObtainStyledAttributes.getBoolean(index, this.j);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public float getProgress() {
        return this.f6764k;
    }

    public void setProgress(float f6) {
        this.f6764k = f6;
        int i9 = 0;
        if (this.f6798b > 0) {
            this.f6765l = f((ConstraintLayout) getParent());
            while (i9 < this.f6798b) {
                View view = this.f6765l[i9];
                i9++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i9 < childCount) {
            boolean z8 = viewGroup.getChildAt(i9) instanceof MotionHelper;
            i9++;
        }
    }
}
